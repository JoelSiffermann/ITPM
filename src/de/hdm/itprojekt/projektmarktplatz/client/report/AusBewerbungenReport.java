package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

public class AusBewerbungenReport extends VerticalPanel{

	private ProjektmarktplatzReportAdminAsync reportService = ClientSideSettings.getReportGenerator();
	private CellTable<Bewerbung> cellTable;
	private Organisationseinheit o = new Organisationseinheit();
	
	public void onLoad(){
		super.onLoad();
		//TODO get aktueller nutzer
		o.setId(60);
		getData();
		cellTable = new CellTable<Bewerbung>();
		cellTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		TextColumn<Bewerbung> idColumn = new TextColumn<Bewerbung>() {
		      @Override
		      public String getValue(Bewerbung object) {
		        return "Nr. " + object.getId();
		      }
		    };
		cellTable.addColumn(idColumn, "Bewerbung");
		TextColumn<Bewerbung> bewColumn = new TextColumn<Bewerbung>() {
		      @Override
		      public String getValue(Bewerbung object) {
		        return object.getInhalt();
		      }
		    };
		cellTable.addColumn(bewColumn, "Inhalt");
		DateCell datum = new DateCell();
		Column<Bewerbung, Date> datumColumn = new Column<Bewerbung, Date>(datum) {
		      @Override
		      public Date getValue(Bewerbung object) {
		        return object.getErstelldatum();
		      }
		    };
		cellTable.addColumn(datumColumn, "Erstelldatum");
		TextColumn<Bewerbung> ausColumn = new TextColumn<Bewerbung>() {
		      @Override
		      public String getValue(Bewerbung object) {
		        return "Ausschreibung Nr." + object.getAusschreibung().getId();
		      }
		    };
		cellTable.addColumn(ausColumn, "zugehoerige Ausschreibung");
		this.add(cellTable);
	}

	private void getData() {
		reportService.getBewerbungenByAusschreibung(o, new BewerbungenCallback());
	}
	
	private class BewerbungenCallback implements AsyncCallback<ArrayList<Bewerbung>> {
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(ArrayList<Bewerbung> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);
		}
	}
}
