package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.List;

import com.gargoylesoftware.htmlunit.javascript.host.Text;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class ProjektmarktplatzAnzeigen extends VerticalPanel {

	/* Neues Design für die GUI */

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public void onLoad() {
		final HorizontalPanel hPanel = new HorizontalPanel();
		HorizontalPanel hPanel2 = new HorizontalPanel();
		VerticalPanel vPanel = new VerticalPanel();
		Button btErstellen = new Button("PM erstellen");
		Button btAndere = new Button("PM aendern");

		final List<String> MEINEBEWERBUNGEN = Arrays.asList("PM 1", "PM 2", "PM 3", "PM 4");
		TextCell textCell = new TextCell();
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		cellList.addStyleName("scrollable");
		cellList.setPageSize(20);
		cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		cellList.setRowCount(MEINEBEWERBUNGEN.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, MEINEBEWERBUNGEN);

		btErstellen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				hPanel.clear();
				//TODO objekt von PM anlegen
				// in hpanel adden
				ProjektmarktplatzAnlegen pa = new ProjektmarktplatzAnlegen();
				hPanel.add(pa);
			}
		});

		btAndere.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

			}
		});

		hPanel.add(hPanel2);
		hPanel2.add(cellList);
		vPanel.add(btErstellen);
		vPanel.add(btAndere);

		hPanel2.add(vPanel);

		this.add(hPanel);

	}

}
