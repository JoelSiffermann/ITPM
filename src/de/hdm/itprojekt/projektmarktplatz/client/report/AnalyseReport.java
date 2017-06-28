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

	private final ProjektmarktplatzReportAdminAsync reportService = GWT.create(ProjektmarktplatzReportAdmin.class);
	private final FlexTable table = new FlexTable();
	private Projekt p = new Projekt();
	private int anz = 0;
	private int anzahlbew = 0;
	private int anzahlbet = 0;
	private int anzahlaus = 0;
	
	//TODO DataGrid statt Flextable
	
	//TODO onLoad() wichtig!
	
	public AnalyseReport(){
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
					anzahlbew = getAnz(o);
					table.setText(1, 1, anzahlbew + "");
				}
			}
			
		});
		
		reportService.getAnzahlAusschreibungen(p, new AsyncCallback<Integer>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer result) {
				anzahlaus = result;
				table.setText(1, 3, anzahlaus + "");
			}
			
		});
		
		reportService.getAnzahlBeteiligungen(p, new AsyncCallback<Integer>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer result) {
				anzahlbet = result;
				table.setText(1, 2, anzahlbet + "");
			}
			
		});
		
		
		this.add(table);
	}
	
	public int getAnz(Organisationseinheit o){
		reportService.getAnzahlBewerbungen(o, new AsyncCallback<Integer>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer result) {
				anz = result;
			}
			
		});
		return anz;
	}
}
