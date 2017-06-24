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

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class MeineBewerbung extends HorizontalPanel {
	
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public void onLoad (){
		
		final HorizontalPanel hPanel = new HorizontalPanel();
		final VerticalPanel vPanel = new VerticalPanel();
		final VerticalPanel vPanel2 = new VerticalPanel();
		final Label lDatum = new Label("Datum: ");
		final TextArea taAnschreiben = new TextArea();
		final Button btBearbeiten = new Button("Bewerbung bearbeiten");
		final Button btLoeschen = new Button("Bewerbung löschen");
		final Button btAnzeigen = new Button("Bewerbung anzeigen");
		final Button btAusschreiben = new Button("Ausschreibung anzeigen");
		final List<String> MEINEBEWERBUNGEN = Arrays.asList("Bewerbung 1", "Bewerbung 2", "Bewerbung 3", "Bewerbung 4");
		// Create a cell to render each value.
		TextCell textCell = new TextCell();

		// Create a CellList that uses the cell.
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		cellList.addStyleName("scrollable");
		cellList.setPageSize(30);
	    cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
	    cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		cellList.setRowCount(MEINEBEWERBUNGEN.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, MEINEBEWERBUNGEN);
		
		hPanel.add(cellList);
		vPanel2.add(lDatum);
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
