package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

public class EmpfAusschreibungReport extends VerticalPanel{

	private final ProjektmarktplatzReportAdminAsync reportService = GWT.create(ProjektmarktplatzReportAdmin.class);
	private final FlexTable table = new FlexTable();
	private VerticalPanel vp = new VerticalPanel();
	private Organisationseinheit e = new Organisationseinheit();
	private Partnerprofil p = new Partnerprofil();
	int id = 0;
	
	public EmpfAusschreibungReport(){
		
		id = Integer.parseInt(Cookies.getCookie("userid"));
		e.setId(id);
		e.setEmail(Cookies.getCookie("email"));
		
		p.setOrganisationseinheit(e);
		
		
		table.addStyleName("Table");
		table.setCellPadding(6);
		table.getCellFormatter().addStyleName(0, 0, "TableHeader");
		table.getCellFormatter().addStyleName(0, 1, "TableHeader");
		table.getCellFormatter().addStyleName(0, 2, "TableHeader");
		table.getCellFormatter().addStyleName(0, 3, "TableHeader");
		table.setText(0, 0, "ID");
		table.setText(0, 1, "Bewerbungsfrist");
		table.setText(0, 2, "Bezeichnung");
		table.setText(0, 3, "Inhalt");
		
//		reportService.getTest(new AsyncCallback<String>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("klappt ned " + caught.getMessage());
//				dialogBox.show();
//			}
//
//			@Override
//			public void onSuccess(String result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("klappt " + result);
//				dialogBox.show();
//			}
//		});
		
		
		reportService.getAuschreibungenByPartnerprofil(p , new AsyncCallback<ArrayList<Ausschreibung>>(){
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				final DialogBox dialogBox = new DialogBox();
				dialogBox.setText("klappt ned " + caught.getMessage());
				dialogBox.show();
			}

			@Override
			public void onSuccess(ArrayList<Ausschreibung> result) {
				int reihe = 0;
				
				for(Ausschreibung a : result){
					reihe++;
					table.setText(reihe, 0, a.getId() + "");
					table.setText(reihe, 1, a.getFrist().toString());
					table.setText(reihe, 2, a.getBezeichnung());
					table.setText(reihe, 3, a.getInhalt());
				};
			}
		});
		
		vp.add(table);
		this.add(vp);
	}
}
