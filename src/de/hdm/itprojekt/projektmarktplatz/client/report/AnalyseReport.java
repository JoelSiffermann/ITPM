package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.ArrayList;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;

/**
 * Klasse zur Darstellung des Reports von der Analyse
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class AnalyseReport extends VerticalPanel {

	private ProjektmarktplatzReportAdminAsync reportService = ClientSideSettings.getReportGenerator();
	private CellTable<String> cellTable;
	
	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */
	
	public void onLoad(){
		super.onLoad();
		getData();
		cellTable = new CellTable<String>();
		cellTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		TextColumn<String> teilnehmerColumn = new TextColumn<String>() {
		      @Override
		      public String getValue(String s) {
		    	  String[] r = s.split("\\s+");
		    	  String name = r[0];
		        return name;
		      }
		    };
		cellTable.addColumn(teilnehmerColumn, "Teilnehmer");
		TextColumn<String> emailColumn = new TextColumn<String>() {
		      @Override
		      public String getValue(String s) {
		    	  String[] r = s.split("\\s+");
		    	  String email = r[1];
		        return email;
		      }
		    };
		cellTable.addColumn(emailColumn, "EMail");
		TextColumn<String> bewerbungColumn = new TextColumn<String>() {
		      @Override
		      public String getValue(String s) {
		    	  String[] r = s.split("\\s+");
		    	  String bew = r[2];
		    	  return bew;
		      }
		    };
		cellTable.addColumn(bewerbungColumn, "Anzahl Bewerbungen");
		TextColumn<String> beteiligungColumn = new TextColumn<String>() {
		      @Override
		      public String getValue(String s) {
		    	  String[] r = s.split("\\s+");
		    	  String bet = r[3];
		    	  return bet;
		      }
		    };
		cellTable.addColumn(beteiligungColumn, "Anzahl Beteiligungen");
		this.add(cellTable);
	}

	private void getData() {
		reportService.getFanAnalyse(new TeilnehmerCallback());
	}
	
	/**
	 * Die innere Klasse TeilnehmerCallback ruft die Array-Liste String auf.
	 *
	 */
	
	private class TeilnehmerCallback implements AsyncCallback<ArrayList<String>> {
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(ArrayList<String> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);
		}
	}
}
