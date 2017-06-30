package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.*;

public class AnalyseReport extends VerticalPanel{

	private ProjektmarktplatzReportAdminAsync reportService = null;
	private FlexTable table = new FlexTable();
	private Projekt p = new Projekt();
	private int anz = 0;
	private int anzahlbew = 0;
	private int anzahlbet = 0;
	private int anzahlaus = 0;
	
	public void onLoad(){
		super.onLoad();
		//TODO
		p.setId(60);
		table.addStyleName("Table");
		table.setCellPadding(6);
		table.getCellFormatter().addStyleName(0, 0, "TableHeader");
		table.getCellFormatter().addStyleName(0, 1, "TableHeader");
		table.getCellFormatter().addStyleName(0, 2, "TableHeader");
		table.getCellFormatter().addStyleName(0, 3, "TableHeader");
		table.setText(0, 0, "Projekt");
		table.setText(0, 1, "Bewerbungen");
		table.setText(0, 2, "Beteiligungen");
		table.setText(0, 3, "Ausschreibungen");
		table.setText(1, 0, p.getId() + "");
		
		getProjektTeilnehmer();
		getAnzahlAusschreibungen();
		getAnzahlBeteiligungen();
		
		this.add(table);
	}

	private void getAnzahlBeteiligungen() {
		reportService.getAnzahlBeteiligungen(p, new AnzahlBeteiligungenCallback());
	}

	private void getAnzahlAusschreibungen() {
		reportService.getAnzahlAusschreibungen(p, new AnzahlAusschreibungenCallback());
	}

	private void getProjektTeilnehmer() {
		reportService.getPersonenByProjekt(p, new ProjektTeilnehmerCallback());
	}
	
	public int getAnz(Organisationseinheit o){
		reportService.getAnzahlBewerbungen(o, new AnzahlBewerbungenCallback());
		return anz;
	}
	
	private class AnzahlBewerbungenCallback implements AsyncCallback<Integer> {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Integer result) {
			anz = result;
		}
	}
	
	private class ProjektTeilnehmerCallback implements AsyncCallback<ArrayList<Organisationseinheit>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<Organisationseinheit> result) {
			for(Organisationseinheit o : result){
				anzahlbew = getAnz(o);
				table.setText(1, 1, anzahlbew + "");
			}
		}
	}
	
	private class AnzahlAusschreibungenCallback implements AsyncCallback<Integer> {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Integer result) {
			anzahlaus = result;
			table.setText(1, 3, anzahlaus + "");
		}
	}
	
	private class AnzahlBeteiligungenCallback implements AsyncCallback<Integer> {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Integer result) {
			anzahlbet = result;
			table.setText(1, 2, anzahlbet + "");
		}
	}
}
