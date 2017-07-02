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

/**
 * Klasse zur Darstellung von Projektmarktplatz-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class ProjektmarktplatzAnzeigen extends HorizontalPanel {

	Projekt projekt = new Projekt();

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	Projektmarktplatz pm = null;

	NumberFormat decimalFormatter = NumberFormat.getDecimalFormat();

	final HorizontalPanel hPanel = new HorizontalPanel();
	HorizontalPanel hPanel2 = new HorizontalPanel();
	VerticalPanel vPanel = new VerticalPanel();
	Label lblProjekt = new Label();
	Button btErstellen = new Button();
	Button btAndere = new Button();

	/**
	 * Konstruktor
	 * @param p Projektmarktplatz
	 */
	
	public ProjektmarktplatzAnzeigen(Projektmarktplatz p) {
		this.pm = p;
		super.onLoad();

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

	
	public void getData(CellList<String> clist) {
		projektService.readAllProjektmarktplatz(new ReadAllPM(clist));

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

	/**
	 * Die innere Klasse ReadAllPM ruft die Array-Liste Projektmarktplatz auf.
 	 * Implementiert das AysncCallback Interface.
	 *
	 */
	
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

}
