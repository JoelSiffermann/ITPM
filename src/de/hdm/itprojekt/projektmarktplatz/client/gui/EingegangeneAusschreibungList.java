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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class EingegangeneAusschreibungList extends HorizontalPanel{
	
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	
	Projekt projekt = null;

	private Ausschreibung selectedAusschreibung = null;
	private SingleSelectionModel<Ausschreibung> ssmAusschreibung = null;
	private ListDataProvider<Ausschreibung> projektDataProvider = null;
//	private KeyProvider projKey = new KeyProvider();
	private CellTable<Ausschreibung> cellTable = new CellTable<Ausschreibung>();
	HorizontalPanel hpList = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();

	Column<Ausschreibung, String> col = new Column<Ausschreibung, String>(new ClickableTextCell()){
		@Override
		public String getValue(Ausschreibung object) {
			setSelectedAusschreibung(object);
			return object.getBezeichnung();
		}
	};
	
	//Gerade auskommentiert, wird nicht gebraucht evtl?
	
	public EingegangeneAusschreibungList(Projekt pm) {
		
		this.projekt = pm;
	}
	
	public void onLoad(){
		super.onLoad();
		ssmAusschreibung = new SingleSelectionModel<Ausschreibung>();
		ssmAusschreibung.addSelectionChangeHandler(new SelectionHandler());
		cellTable.addColumn(col, "Ausschreibung");
		fillTable();
		cellTable.setSelectionModel(ssmAusschreibung);
		hpList.add(cellTable);
		this.add(hpList);
		this.add(hpInfo);
	}
	
	public void fillTable(){
//		projektService.readAllProjekt(new ReadProjektCallback());
//		projektService.readByIdProjektProjektmarktplatz(this.projekt, new ReadAusschreibungCallback());
		projektService.readAllAusschreibung(new ReadAusschreibungCallback());

	}
	
	private class ReadAusschreibungCallback implements AsyncCallback<ArrayList<Ausschreibung>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<Ausschreibung> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);

		}
		
	}
	
	private class SelectionHandler implements SelectionChangeEvent.Handler {

		@Override
		public void onSelectionChange(SelectionChangeEvent event) {

			Ausschreibung selection = getSelectedAusschreibung();
			EingegangeneBewerbungList ap = new EingegangeneBewerbungList(selection);
			hpInfo.clear();
			hpInfo.add(ap);
		}
		
	}
	
	Ausschreibung getSelectedAusschreibung() {
		return selectedAusschreibung;
	}

	void setSelectedAusschreibung(Ausschreibung p){
		selectedAusschreibung = p;
	}

}
