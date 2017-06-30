package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

public class EmpfAusschreibungReport extends VerticalPanel {

	private ProjektmarktplatzReportAdminAsync reportService = ClientSideSettings.getReportGenerator();
	private CellTable<Ausschreibung> cellTable;
	private Organisationseinheit e = new Organisationseinheit();
	int id = 0;
	
	public void onLoad(){
		
		super.onLoad();
		//TODO
		id = 1;
		e.setId(id);
		e.setEmail("test@test.de");
		e.setName("teest");
		
		
		getAusschreibungen();

		cellTable = new CellTable<Ausschreibung>();
		cellTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		TextColumn<Ausschreibung> bezColumn = new TextColumn<Ausschreibung>() {
		      @Override
		      public String getValue(Ausschreibung object) {
		        return object.getBezeichnung();
		      }
		    };
		 cellTable.addColumn(bezColumn, "Bezeichnung");
		 TextColumn<Ausschreibung> inhColumn = new TextColumn<Ausschreibung>() {
		      @Override
		      public String getValue(Ausschreibung object) {
		        return object.getInhalt();
		      }
		    };
		 cellTable.addColumn(inhColumn, "Inhalt");
		 DateCell frist = new DateCell();
		 Column<Ausschreibung, Date> fristColumn = new Column<Ausschreibung, Date>(frist) {
		      @Override
		      public Date getValue(Ausschreibung object) {
		        return object.getFrist();
		      }
		    };
		 cellTable.addColumn(fristColumn, "Frist");
		 this.add(cellTable);
	}

	private void getAusschreibungen() {
		reportService.getEmpfAusschreibungen(e , new AusschreibungenCallback());
	}
	
	private class AusschreibungenCallback implements AsyncCallback<ArrayList<Ausschreibung>>{
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<Ausschreibung> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);
		}
	}
}
