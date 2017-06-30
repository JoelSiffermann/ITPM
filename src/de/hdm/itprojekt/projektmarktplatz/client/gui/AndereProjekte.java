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
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class AndereProjekte extends HorizontalPanel {

	/*
	 * Neues Design
	 */

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	
	Projektmarktplatz projektmarktplatz = new Projektmarktplatz();
	
	public AndereProjekte(Projektmarktplatz pm) {
		this.projektmarktplatz = pm;
	}
	
	VerticalPanel vpAndereProjekteForm1 = new VerticalPanel();
	VerticalPanel vpAndereProjekteForm2 = new VerticalPanel();
	HorizontalPanel hpAndereProjekteForm = new HorizontalPanel();

	ListBox lbProjekte = new ListBox();
	ListBox lbAusschreibung = new ListBox();

	TextBox tbProjektName = new TextBox();
	TextArea taProjektbeschreibung = new TextArea();
	
	DatePicker startPicker = new DatePicker();
	DatePicker endPicker = new DatePicker();
	
	Label lblProjektmarktplatz = new Label("Projektmarktplatz:");
	Label lblProjektName = new Label("Projektname:");
	Label lblStart = new Label("Start:");
	Label lblEnde = new Label("Ende:");
	Label lblProjektBeschreibung = new Label("Beschreibung:");

	Button btBewerbung = new Button("Sich Bewerben");
	TextCell textCell = new TextCell();

	public void onLoad() {
		
		super.onLoad();	
		if(this.projektmarktplatz!=null){
			lblProjektmarktplatz.setText(projektmarktplatz.getBezeichnung());
			
		}
//		
//		lbProjekte.addItem("Projekte 1");
//		lbProjekte.addItem("Projekte 2");
//
//		lbAusschreibung.addItem("Ausschreibung 1");
//		lbAusschreibung.addItem("Ausschreibung 2");
//		lbAusschreibung.addItem("Ausschreibung 3");

		// Set the value in the text box when the user selects a date
		startPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		startPicker.setValue(new Date(), true);

		// Set the value in the text box when the user selects a date
		endPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});
						
		btBewerbung.addClickHandler(new SichBewerbenClickHandler());
		
		endPicker.setValue(new Date(), true);
		
		vpAndereProjekteForm1.add(lbProjekte);
		vpAndereProjekteForm1.add(lblProjektName);
		vpAndereProjekteForm1.add(tbProjektName);
		vpAndereProjekteForm1.add(lblStart);
		vpAndereProjekteForm1.add(startPicker);
		vpAndereProjekteForm1.add(lblEnde);
		vpAndereProjekteForm1.add(endPicker);
		vpAndereProjekteForm1.add(lblProjektBeschreibung);
		vpAndereProjekteForm1.add(taProjektbeschreibung);

		vpAndereProjekteForm2.add(lbAusschreibung);
		vpAndereProjekteForm2.add(btBewerbung);

		this.clear();
		this.add(vpAndereProjekteForm1);
		this.add(vpAndereProjekteForm2);
		
	}
	
	private class SichBewerbenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			BewerbungNeuForm bn = new BewerbungNeuForm(null);
			hpAndereProjekteForm.clear();
			hpAndereProjekteForm.add(bn);
		}
		}
}
