package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.*;

public class ProjektverflechtungReport extends VerticalPanel{

	private final ProjektmarktplatzReportAdminAsync reportService = GWT.create(ProjektmarktplatzReportAdmin.class);
	private final FlexTable table = new FlexTable();
	private final FlexTable table2 = new FlexTable();
	private Projekt p = new Projekt();
	private int row = 1;
	
	public void onLoad(){
		super.onLoad();
		//TODO
		p.setId(60);
		table.addStyleName("Table");
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
		getVerflechtung();
		
		this.add(table);
		this.add(table2);
	}

	private void getVerflechtung() {
		reportService.getPersonenByProjekt(p, new TeilnehmerCallback());
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
			// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
		}

		@Override
		public void onSuccess(Beteiligung result) {
			table2.setText(getRow(), 3, result.getId() + "");
			table2.setText(getRow(), 4, result.getStart().toString());
			table2.setText(getRow(), 5, result.getEnde().toString());
			table2.setText(getRow(), 6, result.getUmfang() + "");
		};
	}
	
	private class TeilnehmerCallback implements AsyncCallback<ArrayList<Organisationseinheit>> {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
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
			reportService.getBeteiligungByProjektteilnehmer(o, p, new BeteiligungenCallback());
		}
		private void getBewerbungen(Organisationseinheit o) {
			reportService.getBewerbungenByNutzer(o, new BewerbungenCallback());
		}
	}
}
