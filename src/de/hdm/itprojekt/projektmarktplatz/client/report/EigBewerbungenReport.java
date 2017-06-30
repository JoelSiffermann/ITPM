package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

public class EigBewerbungenReport extends VerticalPanel{

	private ProjektmarktplatzReportAdminAsync reportService = null;
	private FlexTable table = new FlexTable();
	private Organisationseinheit o = new Organisationseinheit();
	
	public void onLoad(){
		super.onLoad();
		table.addStyleName("Table");
		table.setCellPadding(6);
		table.getCellFormatter().addStyleName(0, 0, "TableHeader");
		table.getCellFormatter().addStyleName(0, 1, "TableHeader");
		table.getCellFormatter().addStyleName(0, 2, "TableHeader");
		table.getCellFormatter().addStyleName(0, 3, "TableHeader");
		table.getCellFormatter().addStyleName(0, 4, "TableHeader");
		table.getCellFormatter().addStyleName(0, 5, "TableHeader");
		table.getCellFormatter().addStyleName(0, 6, "TableHeader");
		table.setText(0, 0, "ID");
		table.setText(0, 1, "Inhalt");
		table.setText(0, 2, "Erstelldatum");
		table.setText(0, 3, "Ausschreibungs-ID");
		table.setText(0, 4, "Bewerbungsfrist");
		table.setText(0, 5, "Bezeichnung");
		table.setText(0, 6, "Inhalt");
		
		getBewerbungen();
		
		this.add(table);
	}

	private void getBewerbungen() {
		reportService.getBewerbungenByNutzer(o , new BewerbungenCallback());
	}
	
	private class BewerbungenCallback implements AsyncCallback<ArrayList<Bewerbung>> {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			final DialogBox dialogBox = new DialogBox();
			dialogBox.setText("klappt ned " + caught.getMessage());
			dialogBox.show();
		}

		@Override
		public void onSuccess(ArrayList<Bewerbung> result) {
			int reihe = 0;
			
			for(Bewerbung b : result){
				reihe++;
				table.setText(reihe, 0, b.getId() + "");
				table.setText(reihe, 1, b.getErstelldatum().toString());
				table.setText(reihe, 2, b.getInhalt());
				table.setText(reihe, 3, b.getAusschreibung().getId() + "");
				table.setText(reihe, 4, b.getAusschreibung().getFrist().toString());
				table.setText(reihe, 5, b.getAusschreibung().getBezeichnung());
				table.setText(reihe, 6, b.getAusschreibung().getInhalt());
			};
		}
	}
}
