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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;

/**
 * Klasse zur Darstellung des Reports von allen Ausschreibungen
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class AlleAusschreibungenReport extends VerticalPanel {

	private ProjektmarktplatzReportAdminAsync reportService = ClientSideSettings.getReportGenerator();
	private CellTable<Ausschreibung> cellTable;

	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */

	public void onLoad() {
		super.onLoad();
		getData();
		cellTable = new CellTable<Ausschreibung>();
		cellTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		TextColumn<Ausschreibung> idColumn = new TextColumn<Ausschreibung>() {
			@Override
			public String getValue(Ausschreibung object) {
				return "Nr. " + object.getId();
			}
		};
		cellTable.addColumn(idColumn, "Ausschreibung");
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

	private void getData() {
		reportService.getAllAusschreibung(new AusschreibungenCallback());
	}

	/**
	 * Die innere Klasse AusschreibungenCallback ruft die Array-Liste Ausschreibung auf.
	 *
	 */
	
	private class AusschreibungenCallback implements AsyncCallback<ArrayList<Ausschreibung>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(ArrayList<Ausschreibung> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);
		}

	}
}
