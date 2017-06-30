package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

public class MeineBewerbung extends HorizontalPanel {

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	HorizontalPanel hPanel = new HorizontalPanel();
	VerticalPanel vPanel = new VerticalPanel();
	VerticalPanel vPanel2 = new VerticalPanel();
	Label lblDatum = new Label("Datum: ");
	TextArea taAnschreiben = new TextArea();
	Button btBearbeiten = new Button("Bewerbung bearbeiten");
	Button btLoeschen = new Button("Bewerbung löschen");
	Button btAnzeigen = new Button("Bewerbung anzeigen");
	Button btAusschreiben = new Button("Ausschreibung anzeigen");

	Bewerbung bewerbung = new Bewerbung();

	public MeineBewerbung (Bewerbung p) {
		this.bewerbung = p;
	}

	public void onLoad() {
		
		super.onLoad();
		if(this.bewerbung!=null){
//			lblInhalt.setText(bewerbung.getInhalt());
		}

		// final List<String> MEINEBEWERBUNGEN = Arrays.asList("Bewerbung 1",
		// "Bewerbung 2", "Bewerbung 3", "Bewerbung 4");
		// // Create a cell to render each value.
		// TextCell textCell = new TextCell();
		//
		// // Create a CellList that uses the cell.
		// CellList<String> cellList = new CellList<String>(textCell);
		// cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		// cellList.addStyleName("scrollable");
		// cellList.setPageSize(20);
		// cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
		// cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);
		//
		// cellList.setRowCount(MEINEBEWERBUNGEN.size(), true);
		//
		// // Push the data into the widget.
		// cellList.setRowData(0, MEINEBEWERBUNGEN);

		// hPanel.add(cellList);
		vPanel2.add(lblDatum);
		vPanel2.add(taAnschreiben);
		hPanel.add(vPanel2);
		vPanel.add(btAusschreiben);
		vPanel.add(btAnzeigen);
		vPanel.add(btLoeschen);
		vPanel.add(btBearbeiten);
		hPanel.add(vPanel);

		this.add(hPanel);

	}

}
