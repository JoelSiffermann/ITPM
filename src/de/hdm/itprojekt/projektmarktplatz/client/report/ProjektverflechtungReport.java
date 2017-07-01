package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.ArrayList;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.*;

public class ProjektverflechtungReport extends VerticalPanel{
	
	private final ProjektmarktplatzReportAdminAsync reportService = GWT.create(ProjektmarktplatzReportAdmin.class);
	private final FlexTable table = new FlexTable();
	private final FlexTable table2 = new FlexTable();
	HorizontalPanel hp = new HorizontalPanel();
	VerticalPanel vpTable1 = new VerticalPanel();
	VerticalPanel vpTable2 = new VerticalPanel();
	private Projekt selectedProjekt = null;
	private SingleSelectionModel<Projekt> ssmProjekt = null;
	private CellTable<Projekt> cellTable = new CellTable<Projekt>();
	HorizontalPanel hpList = new HorizontalPanel();
	HorizontalPanel hp3 = new HorizontalPanel();
	private Organisationseinheit o = new Organisationseinheit();
	private int row = 1;
	
	Column<Projekt, String> col = new Column<Projekt, String>(new ClickableTextCell()){
		@Override
		public String getValue(Projekt object) {
			setSelectedProjekt(object);
			return object.getName();
		}
	};
	
	public void onLoad(){
		super.onLoad();
		//TODO
		o.setId(60);
		ssmProjekt = new SingleSelectionModel<Projekt>();
		ssmProjekt.addSelectionChangeHandler(new SelectionHandler());
		cellTable.addColumn(col, "Projekte");
		fillTable();
		cellTable.setSelectionModel(ssmProjekt);
		table.addStyleName("Table");
		table2.addStyleName("Table");
		table.setCellPadding(6);
		table.getCellFormatter().addStyleName(0, 0, "TableHeader");
		table.getCellFormatter().addStyleName(0, 1, "TableHeader");
		table.getCellFormatter().addStyleName(0, 2, "TableHeader");
		table2.getCellFormatter().addStyleName(0, 0, "TableHeader");
		table2.getCellFormatter().addStyleName(0, 1, "TableHeader");
		table2.getCellFormatter().addStyleName(0, 2, "TableHeader");
		table2.getCellFormatter().addStyleName(0, 3, "TableHeader");
		table.setText(0, 0, "Bewerbung");
		table.setText(0, 1, "Inhalt");
		table.setText(0, 2, "Datum");
		table2.setText(0, 0, "Beteiligung");
		table2.setText(0, 1, "Start");
		table2.setText(0, 2, "Ende");
		table2.setText(0, 3, "Umfang");
		hpList.add(cellTable);
		hp.add(hpList);
		hp.add(hp3);
		this.add(hp);
	}

	private void fillTable() {
		reportService.getProjekteByNutzer(o, new ProjekteCallback());
	}
	
	private class SelectionHandler implements SelectionChangeEvent.Handler {

		@Override
		public void onSelectionChange(SelectionChangeEvent event) {
			getVerflechtung();
			vpTable1.add(table);
			vpTable2.add(table2);
			hp3.clear();
			hp3.add(vpTable1);
			hp3.add(vpTable2);
		}
		
	}
	
	Projekt getSelectedProjekt() {
		return selectedProjekt;
	}

	void setSelectedProjekt(Projekt p){
		selectedProjekt = p;
	}

	private void getVerflechtung() {
		reportService.getPersonenByProjekt(selectedProjekt, new TeilnehmerCallback());
	}
	
	public int getRow(){
		return row;
	}
	
	public void setRow(int row){
		row = this.row;
	}
	
	private class BewerbungenCallback implements AsyncCallback<ArrayList<Bewerbung>> {
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(ArrayList<Bewerbung> result) {
			for(Bewerbung b : result){
				table.setText(getRow(), 0, b.getId() + "");
				table.setText(getRow(), 1, b.getInhalt());
				table.setText(getRow(), 2, b.getErstelldatum().toString());
			};
		}
	}
	
	private class BeteiligungenCallback implements AsyncCallback<Beteiligung> {
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(Beteiligung result) {
			table2.setText(getRow(), 0, result.getId() + "");
			table2.setText(getRow(), 1, result.getStart().toString());
			table2.setText(getRow(), 2, result.getEnde().toString());
			table2.setText(getRow(), 3, result.getUmfang() + "");
		};
	}
	
	private class ProjekteCallback implements AsyncCallback<ArrayList<Projekt>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(ArrayList<Projekt> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);
		}
		
	}
	
	private class TeilnehmerCallback implements AsyncCallback<ArrayList<Organisationseinheit>> {
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}
		@Override
		public void onSuccess(ArrayList<Organisationseinheit> result) {
			for(Organisationseinheit o : result){
				int i = 1;
				i++;
				setRow(i);
				getBewerbungen(o);
				getBeteiligungen(o);
			}
		}
		private void getBeteiligungen(Organisationseinheit o) {
			reportService.getBeteiligungByProjektteilnehmer(o, selectedProjekt, new BeteiligungenCallback());
		}
		private void getBewerbungen(Organisationseinheit o) {
			reportService.getBewerbungenByNutzer(o, new BewerbungenCallback());
		}
	}
}
