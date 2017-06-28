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
import de.hdm.itprojekt.projektmarktplatz.shared.CompositePM;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;





public class ProjektmarktplatzAnzeigen extends VerticalPanel {

	/* Neues Design für die GUI */
	private ListDataProvider<Projektmarktplatz> customerDataProvider = null;

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings
			.getProjektmarktplatzVerwaltung();
	
	Projektmarktplatz accountToDisplay = null;
	//CustomerAccountsTreeViewModel catvm = null;
	NumberFormat decimalFormatter = NumberFormat.getDecimalFormat();

	final HorizontalPanel hPanel = new HorizontalPanel();
	HorizontalPanel hPanel2 = new HorizontalPanel();
	VerticalPanel vPanel = new VerticalPanel();
	Button btErstellen = new Button();
	Button btAndere = new Button();
	
	String[] liste = {};
	
	
	List<String> MEINEBEWERBUNGEN = Arrays.asList(liste);
	TextCell textCell = new TextCell();
	CellList<String> cellList = new CellList<String>(textCell);
	/*
	 * Im Konstruktor werden die Widgets z.T. erzeugt. Alle werden in
	 * einem Raster angeordnet, dessen Größe sich aus dem Platzbedarf
	 * der enthaltenen Widgets bestimmt.
	 */
	
	public ProjektmarktplatzAnzeigen(){
		
		//ERSIN: HIER UNSERE KLASSE AN DEN KONSTRUKTOR ANPASSEN!
		/**
		 * Das Grid-Widget erlaubt die Anordnung anderer Widgets in einem Gitter.
		 */
//		
//		String[] liste = {};
//		
//		projektService.readAllProjektmarktplatz(new ReadAllPM(liste));
//		List<String> MEINEBEWERBUNGEN = Arrays.asList(liste);
		
		 
		
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		cellList.addStyleName("scrollable");
		cellList.setPageSize(20);
		cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		//cellList.setRowCount(MEINEBEWERBUNGEN.size(), true);

		// Push the data into the widget.
		//cellList.setRowData(0, MEINEBEWERBUNGEN);
		this.getData();
		Button btErstellen = new Button("Erstellen");
		Button btAndere = new Button("Andere Projektmarktplätze");
		
		btErstellen.addClickHandler(new ErstellenClickHandler());
		
		
		this.add(cellList);
		this.add(btErstellen);
		this.add(btAndere);
		
//		Grid customerGrid = new Grid(4, 2);
//		this.add(customerGrid);
//
//		Label idLabel = new Label("Kontonummer");
//		customerGrid.setWidget(1, 0, idLabel);
//		customerGrid.setWidget(1, 1, idValueLabel);
//
//		Label balanceLabel = new Label("Kontonstand");
//		customerGrid.setWidget(2, 0, balanceLabel);
//		customerGrid.setWidget(2, 1, balanceValueLabel);
//
//		Label amountLabel = new Label("Betrag");
//		customerGrid.setWidget(3, 0, amountLabel);
//		customerGrid.setWidget(3, 1, amountTextBox);
//
//		HorizontalPanel accountButtonsPanel = new HorizontalPanel();
//		this.add(accountButtonsPanel);
//
//		Button depositButton = new Button("Einzahlen");
//		depositButton.addClickHandler(new DepositClickHandler());
//		accountButtonsPanel.add(depositButton);
//
//		Button withdrawButton = new Button("Abheben");
//		withdrawButton.addClickHandler(new WithdrawClickHandler());
//		accountButtonsPanel.add(withdrawButton);
//
//		Button deleteButton = new Button("Löschen");
//		deleteButton.addClickHandler(new DeleteClickHandler());
//		accountButtonsPanel.add(deleteButton);
//
//		Button newButton = new Button("Neu");
//		newButton.addClickHandler(new NewClickHandler());
//		accountButtonsPanel.add(newButton);
//	}
	}
	
	
	/*
	 * Click handlers und abhängige AsyncCallback Klassen.
	 */
	
	public void getData(){
		projektService.readAllProjektmarktplatz(new ReadAllPM(liste));
		MEINEBEWERBUNGEN = Arrays.asList(liste);
		cellList.setRowCount(MEINEBEWERBUNGEN.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, MEINEBEWERBUNGEN);
	}
	
	private class ErstellenClickHandler implements ClickHandler {
									// HIER MUSS REIN WAS DA DAZU GEHÖRT 
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			//projektService.readAllProjektmarktplatz(new ReadAllPM());
		}
		
	}
	private class ReadAllPM implements AsyncCallback<ArrayList<Projektmarktplatz>> {
		String[] l;
		List<String> MEINEBEWERBUNGEN = Arrays.asList(liste);
		public ReadAllPM(String[] l){
			this.l = l;
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<Projektmarktplatz> result) {
			// TODO Auto-generated method stub
			customerDataProvider = new ListDataProvider<Projektmarktplatz>();

			this.l = new String[result.size()];
			int i = 0;
			for( Projektmarktplatz p : result){
				Window.alert(p.getBezeichnung());
				//this.l.add(p.getBezeichnung());
				l[i] = p.getBezeichnung();
				customerDataProvider.getList().add(p);
				i++;
			}
		//	MEINEBEWERBUNGEN = customerDataProvider.getList();
			RootPanel.get("main").clear();
			RootPanel.get("main").add(new Label(l[0])); 
		}


}

	
	
	
	
	
	
	
	
	
	
//	public void onLoad() {
//
//
//		final List<String> MEINEBEWERBUNGEN = Arrays.asList("PM 1", "PM 2", "PM 3", "PM 4");
//		TextCell textCell = new TextCell();
//		CellList<String> cellList = new CellList<String>(textCell);
//		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
//		cellList.addStyleName("scrollable");
//		cellList.setPageSize(20);
//		cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
//		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);
//
//		cellList.setRowCount(MEINEBEWERBUNGEN.size(), true);
//
//		// Push the data into the widget.
//		cellList.setRowData(0, MEINEBEWERBUNGEN);
//
//		btErstellen.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				hPanel.clear();
//				//TODO objekt von PM anlegen
//				// in hpanel adden
//				ProjektmarktplatzAnlegen pa = new ProjektmarktplatzAnlegen();
//				hPanel.add(pa);
//			}
//		});
//
//		btAndere.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//
//		hPanel.add(hPanel2);
//		hPanel2.add(cellList);
//		vPanel.add(btErstellen);
//		vPanel.add(btAndere);
//
//		hPanel2.add(vPanel);
//
//		this.add(hPanel);

	}


