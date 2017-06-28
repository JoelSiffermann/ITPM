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
	private VerticalPanel vp = new VerticalPanel();
	private Projekt p = new Projekt();
	private int row = 1;
	
	public ProjektverflechtungReport(){
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
		
		reportService.getPersonenByProjekt(p, new AsyncCallback<ArrayList<Organisationseinheit>>(){
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
					reportService.getBewerbungenByNutzer(o, new AsyncCallback<ArrayList<Bewerbung>>(){
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							final DialogBox dialogBox = new DialogBox();
							dialogBox.setText("klappt ned " + caught.getMessage());
							dialogBox.show();
						}

						@Override
						public void onSuccess(ArrayList<Bewerbung> result) {
							for(Bewerbung b : result){
								table.setText(getRow(), 0, b.getId() + "");
								table.setText(getRow(), 1, b.getInhalt());
								table.setText(getRow(), 2, b.getErstelldatum().toString());
							};
						}
					});
					reportService.getBeteiligungByProjektteilnehmer(o, p, new AsyncCallback<Beteiligung>(){
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							final DialogBox dialogBox = new DialogBox();
							dialogBox.setText("klappt ned " + caught.getMessage());
							dialogBox.show();
						}

						@Override
						public void onSuccess(Beteiligung result) {
							table2.setText(getRow(), 3, result.getId() + "");
							table2.setText(getRow(), 4, result.getStart().toString());
							table2.setText(getRow(), 5, result.getEnde().toString());
							table2.setText(getRow(), 6, result.getUmfang() + "");
							};
						}
					);
				}
			}
			
		});
		
//		reportService.getBewerbungenByNutzer(o, new AsyncCallback<ArrayList<Bewerbung>>(){
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("klappt ned " + caught.getMessage());
//				dialogBox.show();
//			}
//
//			@Override
//			public void onSuccess(ArrayList<Bewerbung> result) {
//				int reihe = 0;
//				
//				for(Bewerbung b : result){
//					reihe++;
//					table.setText(reihe, 0, b.getId() + "");
//					table.setText(reihe, 1, b.getInhalt());
//					table.setText(reihe, 2, b.getErstelldatum().toString());
//				};
//			}
//		});
		
		vp.add(table);
		vp.add(table2);
		this.add(vp);
	}
	
	public int getRow(){
		return row;
	}
	
	public void setRow(int row){
		row = this.row;
	}
}
