package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

public class MeineBewerbungList extends HorizontalPanel {
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	private Bewerbung selectedBewerbung = null;
	private SingleSelectionModel<Bewerbung> ssmBewerbung = null;
	private ListDataProvider<Bewerbung> projektDataProvider = null;
//	private KeyProvider projKey = new KeyProvider();
	private CellTable<Bewerbung> cellTable = new CellTable<Bewerbung>();
	HorizontalPanel hpList = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();

	Column<Bewerbung, String> col = new Column<Bewerbung, String>(new ClickableTextCell()){
		@Override
		public String getValue(Bewerbung object) {
			setSelectedBewerbung(object);
			return object.getInhalt();
		}
	};
	
	public void onLoad(){
		super.onLoad();
		ssmBewerbung = new SingleSelectionModel<Bewerbung>();
		ssmBewerbung.addSelectionChangeHandler(new SelectionHandler());
		cellTable.addColumn(col, "Bewerbungen");
		fillTable();
		cellTable.setSelectionModel(ssmBewerbung);
		hpList.add(cellTable);
		this.add(hpList);
		this.add(hpInfo);
	}
	
	public void fillTable(){
		projektService.readAllBewerbung(new ReadBewerbungCallback());
	}
	
	private class ReadBewerbungCallback implements AsyncCallback<ArrayList<Bewerbung>> {

		@Override
		public void onFailure(Throwable caught) {
			
		}

		@Override
		public void onSuccess(ArrayList<Bewerbung> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);

		}
		
	}
	
	private class SelectionHandler implements SelectionChangeEvent.Handler {

		@Override
		public void onSelectionChange(SelectionChangeEvent event) {

			Bewerbung selection = getSelectedBewerbung();
			MeineBewerbung b = new MeineBewerbung(selection);
			hpInfo.clear();
			hpInfo.add(b);
		}
		
	}
	
	Bewerbung getSelectedBewerbung() {
		return selectedBewerbung;
	}

	void setSelectedBewerbung (Bewerbung b){
		selectedBewerbung = b;
	}
}
