package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;

public class BeteiligungAndereProjekte extends VerticalPanel{
	
private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	
	final VerticalPanel vpBeteiligung = new VerticalPanel();
	final List<String> list = null;
	private String listnames = null;
	final TextCell textCell = new TextCell();
	CellList<String> clBeteiligungProjekte = new CellList<String>(textCell);
	
	public BeteiligungAndereProjekte(){
		
		projektService.readAllBeteiligung(new AsyncCallback<ArrayList<Beteiligung>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList<Beteiligung> result) {
				// TODO Auto-generated method stub
//				final DialogBox d = new DialogBox();
//				d.setText("klappt");
//				d.show();
				for(Beteiligung b : result){
					listnames = "Beteiligung" + b.getId();
					list.add(listnames);
				}
			}
			
		});
		clBeteiligungProjekte.setRowCount(list.size(), true);
		
		clBeteiligungProjekte.setRowData(0, list);
		
		vpBeteiligung.add(clBeteiligungProjekte);
		this.add(vpBeteiligung);
		
	}

}
