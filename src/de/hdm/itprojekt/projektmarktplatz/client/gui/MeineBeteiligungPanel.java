package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class MeineBeteiligungPanel extends HorizontalPanel {

	/*
	 * Neues Design
	 */

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public void onLoad() {

		final List<String> PROJEKTE = Arrays.asList("Projekt 1", "Projekt 2", "Projekt 3", "Projekt 4");
		final VerticalPanel vpMeineProjekteForm1 = new VerticalPanel();
		final VerticalPanel vpMeineProjekteForm2 = new VerticalPanel();

		final TextArea taProjektBeschreibung = new TextArea();
		final TextBox tbTage = new TextBox();

		final DatePicker startPickerProjekt = new DatePicker();
		final DatePicker endPickerProjekt = new DatePicker();
		final DatePicker startPickerAusschreibung = new DatePicker();
		final DatePicker endPickerAusschreibung = new DatePicker();

		final Label lblProjektName = new Label("Projektbezeichnung");
		final Label lblStartProjekt = new Label("Start:");
		final Label lblEndeProjekt = new Label("Ende:");
		final Label lblProjektBeschreibung = new Label("Projektbeschreibung:");
		final Label lblStartAusschreibung = new Label("Start:");
		final Label lblEndeAusschreibung = new Label("Ende:");
		final Label lblUmfang = new Label("Umfang");
		final Label lblTage = new Label("Tage");

		final Button btBeteiligungKuendigen = new Button("Beteiligung kuendigen");

		final Grid gridUmfang = new Grid(1, 2);

		// Create a cell to render each value.
		TextCell textCell = new TextCell();

		// Create a CellList that uses the cell.
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Add a selection model to handle user selection.
		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				String selected = selectionModel.getSelectedObject();

				if (selected != null) {
					// Window.alert("You selected: " + selected);
					lblProjektName.setText(selected.toString());
				}

			}
		});

		cellList.addStyleName("scrollable");
		cellList.setPageSize(30);
		cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		cellList.setRowCount(PROJEKTE.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, PROJEKTE);

		// Set the value in the text box when the user selects a date
		startPickerProjekt.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		startPickerProjekt.setValue(new Date(), true);

		// Set the value in the text box when the user selects a date
		endPickerProjekt.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the value in the text box when the user selects a date
		startPickerAusschreibung.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		startPickerAusschreibung.setValue(new Date(), true);

		// Set the value in the text box when the user selects a date
		endPickerAusschreibung.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		endPickerAusschreibung.setValue(new Date(), true);

		btBeteiligungKuendigen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.alert("Button kuendigen noch herstellen");
			}

		});

		gridUmfang.setWidget(0, 0, tbTage);
		gridUmfang.setWidget(0, 1, lblTage);

		vpMeineProjekteForm1.add(lblProjektName);
		vpMeineProjekteForm1.add(lblStartProjekt);
		vpMeineProjekteForm1.add(startPickerProjekt);
		vpMeineProjekteForm1.add(lblEndeProjekt);
		vpMeineProjekteForm1.add(endPickerProjekt);
		vpMeineProjekteForm1.add(lblProjektBeschreibung);
		vpMeineProjekteForm1.add(taProjektBeschreibung);

		vpMeineProjekteForm2.add(lblStartAusschreibung);
		vpMeineProjekteForm2.add(startPickerAusschreibung);
		vpMeineProjekteForm2.add(lblEndeAusschreibung);
		vpMeineProjekteForm2.add(endPickerAusschreibung);
		vpMeineProjekteForm2.add(lblUmfang);
		vpMeineProjekteForm2.add(gridUmfang);
		vpMeineProjekteForm2.add(btBeteiligungKuendigen);

		this.clear();
		this.add(cellList);
		this.add(vpMeineProjekteForm1);
		this.add(vpMeineProjekteForm2);

	}

}
