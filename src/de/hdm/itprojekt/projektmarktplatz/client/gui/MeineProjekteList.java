package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class MeineProjekteList extends HorizontalPanel{
	
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	private Projekt selectedProjekt = null;
	private SingleSelectionModel<Projekt> ssmProjekt = null;
	private ListDataProvider<Projekt> projektDataProvider = null;
	private KeyProvider projKey = new KeyProvider();
	private CellTable<Projekt> cellTable = new CellTable<Projekt>();
	HorizontalPanel hpList = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();
	Organisationseinheit o = new Organisationseinheit();

	Column<Projekt, String> col = new Column<Projekt, String>(new ClickableTextCell()){
		@Override
		public String getValue(Projekt object) {
			setSelectedProjekt(object);
			return object.getName();
		}
	};
	
	//Gerade auskommentiert, wird nicht gebraucht evtl?
	
	private class KeyProvider implements ProvidesKey<Projekt> {
		@Override
		public Integer getKey(Projekt item) {
			return new Integer(item.getId());
		}
		
	}
	
	public void onLoad(){
		super.onLoad();
		o.setEmail(Cookies.getCookie("email"));
		ssmProjekt = new SingleSelectionModel<Projekt>();
		ssmProjekt.addSelectionChangeHandler(new SelectionHandler());
//		projektDataProvider = new ListDataProvider<Projekt>();
		cellTable.addColumn(col, "Projekte");
		fillTable();
		cellTable.setSelectionModel(ssmProjekt);
		hpList.add(cellTable);
		this.add(hpList);
		this.add(hpInfo);
	}
	
	public void fillTable(){
		projektService.getMeineProjekte(o, new ReadProjektCallback());
	}
	
	private class ReadProjektCallback implements AsyncCallback<ArrayList<Projekt>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<Projekt> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);
//			for (Projekt p : result) {
//				projektDataProvider.getList().add(p);
//			}
		}
		
	}
	
	private class SelectionHandler implements SelectionChangeEvent.Handler {

		@Override
		public void onSelectionChange(SelectionChangeEvent event) {
//			Projekt selection = ssmProjekt.getSelectedObject();
//			setSelectedProjekt((Projekt) selection);
			Projekt selection = getSelectedProjekt();
//			DialogBox d = new DialogBox();
//			d.setText("id " + selection.getId() + " Inhalt" + selection.getInhalt() + " Name" + selection.getName());
//			d.show();
			MeineProjektePanel pm = new MeineProjektePanel(selection);
			hpInfo.clear();
			hpInfo.add(pm);
		}
		
	}
	
	Projekt getSelectedProjekt() {
		return selectedProjekt;
	}

	void setSelectedProjekt(Projekt p){
		selectedProjekt = p;
	}
}
