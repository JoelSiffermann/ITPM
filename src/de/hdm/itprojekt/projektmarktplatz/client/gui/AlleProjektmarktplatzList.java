package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

/**
 * Klasse zur Darstellung der Liste von allen Projektmarktplatz-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class AlleProjektmarktplatzList extends HorizontalPanel{
	
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	private Projektmarktplatz selectedProjektmarktplatz = null;
	private SingleSelectionModel<Projektmarktplatz> ssmProjektmarktplatz = null;
	private ListDataProvider<Projektmarktplatz> projektmarktplatzDataProvider = null;
//	private KeyProvider projKey = new KeyProvider();
	private CellTable<Projektmarktplatz> cellTable = new CellTable<Projektmarktplatz>();
	HorizontalPanel hpList = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();

	Column<Projektmarktplatz, String> col = new Column<Projektmarktplatz, String>(new ClickableTextCell()){
		@Override
		public String getValue(Projektmarktplatz object) {
			setSelectedProjektmarktplatz(object);
			return object.getBezeichnung();
		}
	};
		
	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */
	
	public void onLoad(){
		super.onLoad();
		ssmProjektmarktplatz = new SingleSelectionModel<Projektmarktplatz>();
		ssmProjektmarktplatz.addSelectionChangeHandler(new SelectionHandler());
//		projektDataProvider = new ListDataProvider<Projekt>();
		cellTable.addColumn(col, "Projektmarktplatz");
		fillTable();
		cellTable.setSelectionModel(ssmProjektmarktplatz);
		hpList.add(cellTable);
		this.add(hpList);
		this.add(hpInfo);
	}
	
	/**
	 * die Methode fillTable() ruft alle Projektmarktplaetze aus Datenbank aus.
	 */
	
	public void fillTable(){
		projektService.readAllProjektmarktplatz(new ReadProjektmarktplatzCallback());
	}
	
	/**
	 * Die innere Klasse ReadProjektmarktplatzCallback ruft die Array-Liste Projektmarktplatz auf.
  	 * Implementiert das AysncCallback Interface.
	 *
	 */
	
	private class ReadProjektmarktplatzCallback implements AsyncCallback<ArrayList<Projektmarktplatz>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<Projektmarktplatz> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);

		}
		
	}
	
	/**
	 * Die innere Klasse für die Reaktion auf Selektionsereignisse.
	 *
	 */
	
	private class SelectionHandler implements SelectionChangeEvent.Handler {

		@Override
		public void onSelectionChange(SelectionChangeEvent event) {

			Projektmarktplatz selection = getSelectedProjektmarktplatz();
			AndereProjekteList apl = new AndereProjekteList(selection);
			hpInfo.clear();
			hpInfo.add(apl);
		}
	}
	
	Projektmarktplatz getSelectedProjektmarktplatz() {
		return selectedProjektmarktplatz;
	}

	void setSelectedProjektmarktplatz(Projektmarktplatz pm){
		selectedProjektmarktplatz = pm;
	}

}
