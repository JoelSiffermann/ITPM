package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gargoylesoftware.htmlunit.javascript.host.Text;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
//import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
//import de.hdm.itprojekt.projektmarktplatz.shared.CompositePM;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class ProjektmarktplatzAnzeigen extends HorizontalPanel {

	/* Neues Design für die GUI */

	Projekt projekt = new Projekt();

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	Projektmarktplatz pm = null;

	// CustomerAccountsTreeViewModel catvm = null;
	NumberFormat decimalFormatter = NumberFormat.getDecimalFormat();

	final HorizontalPanel hPanel = new HorizontalPanel();
	HorizontalPanel hPanel2 = new HorizontalPanel();
	VerticalPanel vPanel = new VerticalPanel();
	Label lblProjekt = new Label();
	Button btErstellen = new Button();
	Button btAndere = new Button();

	
	
	/*
	 * Im Konstruktor werden die Widgets z.T. erzeugt. Alle werden in einem
	 * Raster angeordnet, dessen Größe sich aus dem Platzbedarf der
	 * enthaltenen Widgets bestimmt.
	 */

	// public ProjektmarktplatzAnzeigen(Projekt p) {
	// this.projekt = p;
	// }

	public ProjektmarktplatzAnzeigen(Projektmarktplatz p) {
		this.pm = p;
		super.onLoad();

		// ERSIN: HIER UNSERE KLASSE AN DEN KONSTRUKTOR ANPASSEN!
		/**
		 * Das Grid-Widget erlaubt die Anordnung anderer Widgets in einem
		 * Gitter.
		 */

		String[] liste = {};

		// projektService.readAllProjektmarktplatz(new ReadAllPM(liste));
		// List<String> MEINEBEWERBUNGEN = Arrays.asList(liste);

		List<String> PROJEKTMARKTPLAETZE = Arrays.asList(liste);
		TextCell textCell = new TextCell();
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		cellList.addStyleName("scrollable");
		cellList.setPageSize(20);
		cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		cellList.setRowCount(PROJEKTMARKTPLAETZE.size(), true);

		// Add a selection model to handle user selection.
		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				String selected = selectionModel.getSelectedObject();

				if (selected != null) {
					Window.alert("You selected: " + selected);

				}

			}
		});


		this.add(vPanel);

	}

	/*
	 * Click handlers und abhängige AsyncCallback Klassen.
	 */

	public void getData(CellList<String> clist) {
		projektService.readAllProjektmarktplatz(new ReadAllPM(clist));
		// MEINEBEWERBUNGEN = Arrays.asList(liste);
		// cellList.setRowCount(MEINEBEWERBUNGEN.size(), true);
		//
		// // Push the data into the widget.
		// cellList.setRowData(0, MEINEBEWERBUNGEN);
	}

	private class ErstellenClickHandler implements ClickHandler {
		// HIER MUSS REIN WAS DA DAZU GEHÖRT
		HorizontalPanel hp;

		public ErstellenClickHandler(HorizontalPanel hp) {
			this.hp = hp;
		}

		@Override
		public void onClick(ClickEvent event) {
			ProjektmarktplatzAnlegen pma = new ProjektmarktplatzAnlegen();
			this.hp.clear();
			this.hp.add(pma);
		}

	}

	private class AnzeigenClickHandler implements ClickHandler {
		// HIER MUSS REIN WAS DA DAZU GEHÖRT
		HorizontalPanel hp;
		CellList<String> clist;

		public AnzeigenClickHandler(HorizontalPanel hp, CellList clist) {
			this.hp = hp;
			this.clist = clist;
		}

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			projektService.readAllProjektmarktplatz(new ReadAllPM(this.clist));
			this.hp.clear();
			this.hp.add(this.clist);

		}

	}

	public void onLoad() {

		super.onLoad();
		if (this.projekt != null) {
			lblProjekt.setText(projekt.getName());
		}
	}

	private class ReadAllPM extends VerticalPanel implements AsyncCallback<ArrayList<Projektmarktplatz>> {
		String[] l;
		CellList<String> clist;
		List<String> PROJEKTMARKTPLAETZE;

		public ReadAllPM(CellList clist) {
			this.clist = clist;
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSuccess(ArrayList<Projektmarktplatz> result) {
			// TODO Auto-generated method stub

			this.l = new String[result.size()];
			int i = 0;
			for (Projektmarktplatz p : result) {
//				 Window.alert(p.getBezeichnung());
				l[i] = p.getBezeichnung();
				i++;
			}

			PROJEKTMARKTPLAETZE = Arrays.asList(l);
			// // Push the data into the widget.
			clist.setRowData(0, PROJEKTMARKTPLAETZE);
			// this.add(clist);
		}

	}

	// public void onLoad() {
	//
	//
	// final List<String> MEINEBEWERBUNGEN = Arrays.asList("PM 1", "PM 2", "PM
	// 3", "PM 4");
	// TextCell textCell = new TextCell();
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
	//
	// btErstellen.addClickHandler(new ClickHandler() {
	//
	// @Override
	// public void onClick(ClickEvent event) {
	// hPanel.clear();
	// //TODO objekt von PM anlegen
	// // in hpanel adden
	// ProjektmarktplatzAnlegen pa = new ProjektmarktplatzAnlegen();
	// hPanel.add(pa);
	// }
	// });
	//
	// btAndere.addClickHandler(new ClickHandler() {
	//
	// @Override
	// public void onClick(ClickEvent event) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	//
	// hPanel.add(hPanel2);
	// hPanel2.add(cellList);
	// vPanel.add(btErstellen);
	// vPanel.add(btAndere);
	//
	// hPanel2.add(vPanel);
	//
	// this.add(hPanel);

}
