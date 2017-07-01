package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Date;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class MeineBeteiligungPanel extends HorizontalPanel {

	/*
	 * Neues Design
	 */

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

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
	
	Projekt projekt;
	
	Ausschreibung ausschreibung;
	
	public MeineBeteiligungPanel (Projekt p) {
		this.projekt = p;
	}
	
	public void onLoad() {
		super.onLoad();
		
		taProjektBeschreibung.setHeight("300px");
		taProjektBeschreibung.setWidth("300px");
		taProjektBeschreibung.setEnabled(false);
		
		if(this.projekt!=null){
			lblProjektName.setText(projekt.getName());
			taProjektBeschreibung.setText(projekt.getInhalt());
//			tbTage.setText(ausschreibung.getFrist().toString());
		}
		


		// Set the value in the text box when the user selects a date
		startPickerProjekt.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		startPickerProjekt.setValue(projekt.getStart(), true);

		// Set the value in the text box when the user selects a date
		endPickerProjekt.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		endPickerProjekt.setValue(projekt.getEnde(), true);

		// Set the value in the text box when the user selects a date
		startPickerAusschreibung.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		startPickerAusschreibung.setValue(projekt.getStart(), true);

		// Set the value in the text box when the user selects a date
		endPickerAusschreibung.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		endPickerAusschreibung.setValue(projekt.getEnde(), true);

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
