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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
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
	VerticalPanel vpAndereProjekteForm3 = new VerticalPanel();

	HorizontalPanel hpAndereProjekteForm = new HorizontalPanel();

//	ListBox lbBeteiligung = new ListBox();
	TextBox tbBeruf = new TextBox();
	TextBox tbName = new TextBox();
	TextBox tbUmfang = new TextBox();
	TextBox tbErfahrung = new TextBox();
	DatePicker startPicker = new DatePicker();
	DatePicker endPicker = new DatePicker();
	Label lblName = new Label("Name:");
	Label lblStart = new Label("Start:");
	Label lblEnde = new Label("Ende:");
	Label lblBeruf = new Label("Beruf:");
	Label lblUmfang = new Label("Umfang:");
	Label lblJahre = new Label("Jahre");
	Label lblTage = new Label("Tage");
	Label lblErfahrung = new Label("Erfahrung:");
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
		vpAndereProjekteForm2.add(cellTable);
		
		if (this.beteiligung != null) {
			lblName.setText(beteiligung.getOrganisationseinheit().getName());
			lblBeruf.setText(beteiligung.getOrganisationseinheit().getPartnerprofil().getAusschreibung().getBezeichnung());
		}
		
//		lbBeteiligung.addItem("Beteiligung 1");
//		lbBeteiligung.addItem("Beteiligung 2");

		// Set the value in the text box when the user selects a date
		startPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		startPicker.setValue(new Date(), true);

		// Set the value in the text box when the user selects a date
		endPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
			}
		});

		btBewertungAnzeigen.addClickHandler(new BewertungAnzeigenClickHandler());

		endPicker.setValue(new Date(), true);

		gridErfahrung.setWidget(0, 0, tbErfahrung);
		gridErfahrung.setWidget(0, 1, lblJahre);

		gridUmfang.setWidget(0, 0, tbUmfang);
		gridUmfang.setWidget(0, 1, lblTage);

//		vpAndereProjekteForm1.add(lbBeteiligung);
		vpAndereProjekteForm1.add(lblName);
		vpAndereProjekteForm1.add(tbName);
		vpAndereProjekteForm1.add(lblBeruf);
		vpAndereProjekteForm1.add(tbBeruf);
		vpAndereProjekteForm1.add(lblErfahrung);
		vpAndereProjekteForm1.add(gridErfahrung);
		vpAndereProjekteForm1.add(lblStart);
		vpAndereProjekteForm1.add(startPicker);
		vpAndereProjekteForm1.add(lblEnde);
		vpAndereProjekteForm1.add(endPicker);
		vpAndereProjekteForm1.add(lblUmfang);
		vpAndereProjekteForm1.add(gridUmfang);

		vpAndereProjekteForm2.add(btBewertungAnzeigen);
		vpAndereProjekteForm2.add(btBeteiligungBeenden);

		this.clear();
		this.add(vpAndereProjekteForm1);
		this.add(vpAndereProjekteForm2);
		this.add(vpAndereProjekteForm3);

	}

	public void fillTable() {
		projektService.readAllBeteiligung(new ReadBeteiligungCallback());
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
			BewertungAnzeigen ap = new BewertungAnzeigen(selection);
			vpAndereProjekteForm3.clear();
			vpAndereProjekteForm3.add(ap);
		}

	}

	Beteiligung getSelectedBeteiligung() {
		return selectedBeteiligung;
	}

	void setSelectedBeteiligung(Beteiligung a) {
		selectedBeteiligung = a;
	}
	
	private class BewertungAnzeigenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			BewertungAnzeigen ba = new BewertungAnzeigen(null);
			vpAndereProjekteForm3.clear();
			vpAndereProjekteForm3.add(ba);
		}
	}

}
