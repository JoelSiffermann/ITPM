package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class AndereProjektePanel extends HorizontalPanel {

	/*
	 * Neues Design
	 */

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	
	Projektmarktplatz projektmarktplatz;
	Projekt projekt;

	VerticalPanel vpAndereProjekteForm1 = new VerticalPanel();
	VerticalPanel vpAndereProjekteForm2 = new VerticalPanel();
	VerticalPanel vpAndereProjekteForm3 = new VerticalPanel();
	HorizontalPanel hpAndereProjekteForm = new HorizontalPanel();

	TextBox tbProjektName = new TextBox();
	TextArea taProjektbeschreibung = new TextArea();
	DatePicker startPicker = new DatePicker();
	DatePicker endPicker = new DatePicker();
	Label lblProjektmarktplatz = new Label("Projektmarktplatz:");
	Label lblProjektName = new Label("Projektname:");
	Label lblStart = new Label("Start:");
	Label lblEnde = new Label("Ende:");
	Label lblProjektBeschreibung = new Label("Beschreibung:");
	TextCell textCell = new TextCell();

	private SingleSelectionModel<Ausschreibung> ssmAusschreibung = null;
	private Ausschreibung selectedAusschreibung = null;
	private CellTable<Ausschreibung> cellTable = new CellTable<Ausschreibung>();

	Column<Ausschreibung, String> col = new Column<Ausschreibung, String>(new ClickableTextCell()) {
		@Override
		public String getValue(Ausschreibung object) {
			setSelectedAusschreibung(object);
			return object.getBezeichnung();
		}
	};
	
	public AndereProjektePanel(Projekt p) {
		this.projekt = p;
	}

	public void onLoad() {

		super.onLoad();

		taProjektbeschreibung.setHeight("300px");
		taProjektbeschreibung.setWidth("300px");
		taProjektbeschreibung.setEnabled(false);

		ssmAusschreibung = new SingleSelectionModel<Ausschreibung>();
		ssmAusschreibung.addSelectionChangeHandler(new SelectionHandler());
		cellTable.addColumn(col, "Ausschreibung");
		fillTable();
		cellTable.setSelectionModel(ssmAusschreibung);
		vpAndereProjekteForm2.add(cellTable);

		if (this.projekt != null) {
			// lblProjektmarktplatz.setText(projektmarktplatz.getBezeichnung());
			lblProjektName.setText(projekt.getName());
			taProjektbeschreibung.setText(projekt.getInhalt());
			taProjektbeschreibung.setValue(projekt.getInhalt());

		}

		startPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
			}
		});

		startPicker.setValue(projekt.getStart(), true);

		endPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
			}
		});

		endPicker.setValue(projekt.getEnde(), true);

		vpAndereProjekteForm1.add(lblProjektName);
		vpAndereProjekteForm1.add(tbProjektName);
		vpAndereProjekteForm1.add(lblStart);
		vpAndereProjekteForm1.add(startPicker);
		vpAndereProjekteForm1.add(lblEnde);
		vpAndereProjekteForm1.add(endPicker);
		vpAndereProjekteForm1.add(lblProjektBeschreibung);
		vpAndereProjekteForm1.add(taProjektbeschreibung);

		this.clear();
		this.add(vpAndereProjekteForm1);
		this.add(vpAndereProjekteForm2);
		this.add(vpAndereProjekteForm3);

	}

	public void fillTable() {
		projektService.readAllAusschreibung(new ReadAusschreibungCallback());
	}

	private class ReadAusschreibungCallback implements AsyncCallback<ArrayList<Ausschreibung>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSuccess(ArrayList<Ausschreibung> result) {
			cellTable.setRowData(0, result);
			cellTable.setRowCount(result.size(), true);

		}

	}

	private class SelectionHandler implements SelectionChangeEvent.Handler {

		@Override
		public void onSelectionChange(SelectionChangeEvent event) {

			Ausschreibung selection = getSelectedAusschreibung();
			AndereAusschreibungenAnzeigen ap = new AndereAusschreibungenAnzeigen(selection);
			vpAndereProjekteForm3.clear();
			vpAndereProjekteForm3.add(ap);
		}

	}

	Ausschreibung getSelectedAusschreibung() {
		return selectedAusschreibung;
	}

	void setSelectedAusschreibung(Ausschreibung a) {
		selectedAusschreibung = a;
	}

}
