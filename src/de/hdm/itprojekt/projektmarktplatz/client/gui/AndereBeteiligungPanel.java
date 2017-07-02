package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class AndereBeteiligungPanel extends HorizontalPanel {

	/*
	 * Neues Design
	 */

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	Projekt projekt;
	Beteiligung beteiligung;

	VerticalPanel vpAndereProjekteForm1 = new VerticalPanel();
	VerticalPanel vpAndereProjekteForm2 = new VerticalPanel();
	VerticalPanel vpBewertung = new VerticalPanel();
	VerticalPanel vpOrga = new VerticalPanel();
	VerticalPanel vpBet = new VerticalPanel();

	HorizontalPanel hpAndereProjekteForm = new HorizontalPanel();

	//Orga
	Label lblEMail = new Label("Email:");
	Label lblName = new Label("Name:");
	TextBox tbEmail = new TextBox();
	TextBox tbName = new TextBox();
	//Beteiligung
	TextBox tbUmfang = new TextBox();
	TextBox startPicker = new TextBox();
	TextBox endPicker = new TextBox();
	Label lblUmfang = new Label("Umfang:");
	Label lblStart = new Label("Start:");
	Label lblEnde = new Label("Ende:");
	Button btBewertungAnzeigen = new Button("Bewertung anzeigen");
	Button btBeteiligungBeenden = new Button("Beteiligung beenden");
	Grid gridErfahrung = new Grid(1, 2);
	Grid gridUmfang = new Grid(1, 2);
	TextCell textCell = new TextCell();

	private SingleSelectionModel<Beteiligung> ssmBeteiligung = null;
	private Beteiligung selectedBeteiligung = null;
	private CellTable<Beteiligung> cellTable = new CellTable<Beteiligung>();

	Column<Beteiligung, String> col = new Column<Beteiligung, String>(new ClickableTextCell()) {
		@Override
		public String getValue(Beteiligung object) {
			setSelectedBeteiligung(object);
			return object.getProjekt().getName();
		}
	};
	
	public AndereBeteiligungPanel(Projekt p) {
		this.projekt = p;
	}
	
	public void onLoad() {

		super.onLoad();
		
		ssmBeteiligung = new SingleSelectionModel<Beteiligung>();
		ssmBeteiligung.addSelectionChangeHandler(new SelectionHandler());
		cellTable.addColumn(col, "Beteiligung");
		fillTable();
		cellTable.setSelectionModel(ssmBeteiligung);
		btBeteiligungBeenden.addClickHandler(new BeendenClickHandler());
		btBewertungAnzeigen.addClickHandler(new BewertungClickHandler());
		vpAndereProjekteForm1.add(cellTable);
		vpAndereProjekteForm2.add(vpOrga);
		vpAndereProjekteForm2.add(vpBet);
		hpAndereProjekteForm.add(vpAndereProjekteForm1);
		hpAndereProjekteForm.add(vpAndereProjekteForm2);
		hpAndereProjekteForm.add(vpBewertung);
		this.add(hpAndereProjekteForm);
	}

	public void fillTable() {
		projektService.getBeteiligungBy(projekt, new ReadBeteiligungCallback());
	}
	
	private class BeendenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			projektService.deleteBeteiligung(selectedBeteiligung, new DeleteCallback());
		}
		
	}
	
	private class DeleteCallback implements AsyncCallback<Void> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Konnte nicht gelöscht werden");
		}

		@Override
		public void onSuccess(Void result) {
			RootPanel.get("main").clear();
		}

	}

	private class ReadBeteiligungCallback implements AsyncCallback<ArrayList<Beteiligung>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSuccess(ArrayList<Beteiligung> result) {
			
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);

		}
	}

	private class SelectionHandler implements SelectionChangeEvent.Handler {

		@Override
		public void onSelectionChange(SelectionChangeEvent event) {

			Beteiligung selection = getSelectedBeteiligung();
			projektService.getOrgaByBeteiligung(selection, new OrgaCallBack());
			loadPanel(selection);
		}

		private void loadPanel(Beteiligung selection) {
			vpBet.clear();
			vpBet.add(lblUmfang);
			vpBet.add(tbUmfang);
			vpBet.add(lblStart);
			vpBet.add(startPicker);
			vpBet.add(lblEnde);
			vpBet.add(endPicker);
			vpBet.add(btBewertungAnzeigen);
			vpBet.add(btBeteiligungBeenden);
			if(selection!=null){
				tbUmfang.setText(selection.getUmfang() + "");
				startPicker.setText(selection.getStart() + "");
				endPicker.setText(selection.getEnde()+ "");
			}
		}
	}
	
	private class OrgaCallBack implements AsyncCallback<Organisationseinheit>{

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Organisationseinheit result) {
			vpOrga.clear();
			vpOrga.add(lblName);
			vpOrga.add(tbName);
			vpOrga.add(lblEMail);
			vpOrga.add(tbEmail);
			if(result != null) {
				tbName.setText(result.getName());
				tbEmail.setText(result.getEmail());
			}
		}
		
	}
	
	private class BewertungClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			BewertungAnzeigen ba = new BewertungAnzeigen(selectedBeteiligung);
			vpBewertung.clear();
			vpBewertung.add(ba);
		}
		
	}

	Beteiligung getSelectedBeteiligung() {
		return selectedBeteiligung;
	}

	void setSelectedBeteiligung(Beteiligung a) {
		selectedBeteiligung = a;
	}
}
