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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

/**
 * Klasse zur Darstellung der Liste von meinen Beteiligung-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class MeineBeteiligungList extends HorizontalPanel {

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	private Projekt selectedProjekt = null;
	private SingleSelectionModel<Projekt> ssmProjekt = null;
	private ListDataProvider<Projekt> projektDataProvider = null;
	private CellTable<Projekt> cellTable = new CellTable<Projekt>();
	HorizontalPanel hpList = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();

	Column<Projekt, String> col = new Column<Projekt, String>(new ClickableTextCell()){
		@Override
		public String getValue(Projekt object) {
			setSelectedProjekt(object);
			return object.getName();
		}
	};
	
	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */
	
	public void onLoad(){
		super.onLoad();
		ssmProjekt = new SingleSelectionModel<Projekt>();
		ssmProjekt.addSelectionChangeHandler(new SelectionHandler());
		cellTable.addColumn(col, "Beteiligungen");
		fillTable();
		cellTable.setSelectionModel(ssmProjekt);
		hpList.add(cellTable);
		this.add(hpList);
		this.add(hpInfo);
	}
	
	/**
	 * die Methode fillTable() ruft alle Projektmarktplaetze aus Datenbank aus.
	 */
	
	public void fillTable(){
		projektService.readAllProjekt(new ReadProjektCallback());
	}
	
	/**
	 * Die innere Klasse ReadProjektCallback ruft die Array-Liste Projekt auf.
	 *
	 */
	
	private class ReadProjektCallback implements AsyncCallback<ArrayList<Projekt>> {

		@Override
		public void onFailure(Throwable caught) {
			
		}

		@Override
		public void onSuccess(ArrayList<Projekt> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);

		}
		
	}
	
	/**
	 * Die innere Klasse f�r die Reaktion auf Selektionsereignisse.
	 *
	 */
	
	private class SelectionHandler implements SelectionChangeEvent.Handler {

		@Override
		public void onSelectionChange(SelectionChangeEvent event) {

			Projekt selection = getSelectedProjekt();
			MeineBeteiligungPanel pbm = new MeineBeteiligungPanel(selection);
			hpInfo.clear();
			hpInfo.add(pbm);
		}
		
	}
	
	Projekt getSelectedProjekt() {
		return selectedProjekt;
	}

	void setSelectedProjekt(Projekt p){
		selectedProjekt = p;
	}
}
