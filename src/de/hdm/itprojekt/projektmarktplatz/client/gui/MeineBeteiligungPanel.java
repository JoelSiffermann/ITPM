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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class MeineBeteiligungPanel extends HorizontalPanel {

	/*
	 * Neues Design
	 */

//	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

//	List<String> PROJEKTE = Arrays.asList("Projekt 1", "Projekt 2", "Projekt 3", "Projekt 4");
	VerticalPanel vpMeineBeteiligungForm1 = new VerticalPanel();
	VerticalPanel vpMeineBeteiligungForm2 = new VerticalPanel();
	HorizontalPanel hpMeineBeteiligung = new HorizontalPanel();

	TextArea taProjektBeschreibung = new TextArea();
	TextBox tbTage = new TextBox();

	DatePicker startPickerProjekt = new DatePicker();
	DatePicker endPickerProjekt = new DatePicker();
	DatePicker startPickerAusschreibung = new DatePicker();
	DatePicker endPickerAusschreibung = new DatePicker();

	Label lblProjektName = new Label("Projektbezeichnung");
	Label lblStartProjekt = new Label("Start:");
	Label lblEndeProjekt = new Label("Ende:");
	Label lblProjektBeschreibung = new Label("Projektbeschreibung:");
	Label lblStartAusschreibung = new Label("Start:");
	Label lblEndeAusschreibung = new Label("Ende:");
	Label lblUmfang = new Label("Umfang");
	Label lblTage = new Label("Tage");

	Button btBeteiligungKuendigen = new Button("Beteiligung kuendigen");

	Grid gridUmfang = new Grid(1, 2);
	TextCell textCell = new TextCell();
	
	Projekt projekt = new Projekt();
	
	public MeineBeteiligungPanel (Projekt p) {
		this.projekt = p;
	}
	
	public void onLoad() {

		super.onLoad();
		if(this.projekt!=null){
			lblProjektName.setText(projekt.getName());
		}
		
//
//		// Create a cell to render each value.
//
//
//		// Create a CellList that uses the cell.
//		CellList<String> cellList = new CellList<String>(textCell);
//		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
//
//		// Add a selection model to handle user selection.
//		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
//		cellList.setSelectionModel(selectionModel);
//		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//			public void onSelectionChange(SelectionChangeEvent event) {
//				String selected = selectionModel.getSelectedObject();
//
//				if (selected != null) {
//					// Window.alert("You selected: " + selected);
//					lblProjektName.setText(selected.toString());
//				}
//
//			}
//		});
//
//		cellList.addStyleName("scrollable");
//		cellList.setPageSize(30);
//		cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
//		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);
//
//		cellList.setRowCount(PROJEKTE.size(), true);
//
//		// Push the data into the widget.
//		cellList.setRowData(0, PROJEKTE);

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

		vpMeineBeteiligungForm1.add(lblProjektName);
		vpMeineBeteiligungForm1.add(lblStartProjekt);
		vpMeineBeteiligungForm1.add(startPickerProjekt);
		vpMeineBeteiligungForm1.add(lblEndeProjekt);
		vpMeineBeteiligungForm1.add(endPickerProjekt);
		vpMeineBeteiligungForm1.add(lblProjektBeschreibung);
		vpMeineBeteiligungForm1.add(taProjektBeschreibung);

		vpMeineBeteiligungForm2.add(lblStartAusschreibung);
		vpMeineBeteiligungForm2.add(startPickerAusschreibung);
		vpMeineBeteiligungForm2.add(lblEndeAusschreibung);
		vpMeineBeteiligungForm2.add(endPickerAusschreibung);
		vpMeineBeteiligungForm2.add(lblUmfang);
		vpMeineBeteiligungForm2.add(gridUmfang);
		vpMeineBeteiligungForm2.add(btBeteiligungKuendigen);

		this.clear();
		
		hpMeineBeteiligung.add(vpMeineBeteiligungForm1);
		hpMeineBeteiligung.add(vpMeineBeteiligungForm2);
//		this.add(cellList);
		this.add(hpMeineBeteiligung);

	}

}
