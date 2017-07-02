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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

/**
 * Klasse zur Darstellung der Liste von eingegangen Bewerbung-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class EingegangeneBewerbungList extends HorizontalPanel{
	
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	
	Ausschreibung ausschreibung = null;

	private Bewerbung selectedBewerbung = null;
	private SingleSelectionModel<Bewerbung> ssmBewerbung = null;
	private ListDataProvider<Bewerbung> projektDataProvider = null;
	private CellTable<Bewerbung> cellTable = new CellTable<Bewerbung>();
	HorizontalPanel hpList = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();

	Column<Bewerbung, String> col = new Column<Bewerbung, String>(new ClickableTextCell()){
		@Override
		public String getValue(Bewerbung object) {
			setSelectedBewerbung(object);
			return object.getBewerber().toString();
		}
	};
	
	/**
	 * Konstruktor
	 * @param a Ausschreibung
	 */
	
	public EingegangeneBewerbungList(Ausschreibung a) {
		
		this.ausschreibung = a;
	}
	
	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */
	
	public void onLoad(){
		super.onLoad();
		ssmBewerbung = new SingleSelectionModel<Bewerbung>();
		ssmBewerbung.addSelectionChangeHandler(new SelectionHandler());
		cellTable.addColumn(col, "Bewerbung");
		fillTable();
		cellTable.setSelectionModel(ssmBewerbung);
		hpList.add(cellTable);
		this.add(hpList);
		this.add(hpInfo);
	}
	
	/**
	 * die Methode fillTable() ruft alle Projektmarktplaetze aus Datenbank aus.
	 */
	
	public void fillTable(){

		projektService.readAllBewerbung(new ReadBewerbungCallback());

	}
	
	/**
	 * Die innere Klasse ReadBewerbungCallback ruft die Array-Liste Bewerbung auf.
 	 * Implementiert das AysncCallback Interface.
	 */
	
	private class ReadBewerbungCallback implements AsyncCallback<ArrayList<Bewerbung>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<Bewerbung> result) {
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

			Bewerbung selection = getSelectedBewerbung();
//			AndereAusschreibungenAnzeigen ap = new AndereAusschreibungenAnzeigen(selection);
			hpInfo.clear();
//			hpInfo.add(ap);
		}
		
	}
	
	Bewerbung getSelectedBewerbung() {
		return selectedBewerbung;
	}

	void setSelectedBewerbung(Bewerbung p){
		selectedBewerbung = p;
	}

}
