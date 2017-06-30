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
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class ProjektNeuForm extends VerticalPanel {
	
	/*
	 * Neues Design
	 */

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	HorizontalPanel hpProjektForm = new HorizontalPanel();
	VerticalPanel vpProjektForm1 = new VerticalPanel();
	VerticalPanel vpProjektForm2 = new VerticalPanel();
	HorizontalPanel hpButton = new HorizontalPanel();
	TextArea taProjektInhalt = new TextArea();
	TextBox tbProjektName = new TextBox();
	DatePicker startPicker = new DatePicker();
	DatePicker endPicker = new DatePicker();
	
	
	public void onLoad() {

		super.onLoad();
		
		Label lblStart = new Label("Start:");
		Label lblEnde = new Label("Ende:");
		
		Button btSpeichern = new Button("Projekt speichern");
		Button btAbbrechen = new Button("Abbrechen");
		
		
		tbProjektName.getElement().setPropertyString("placeholder", "Projektname");

		taProjektInhalt.setWidth("300px");
		taProjektInhalt.setHeight("300px");
		taProjektInhalt.getElement().setPropertyString("placeholder", "Projektbezeichnung");
		
		// Set the value in the text box when the user selects a date
		startPicker.addValueChangeHandler(new DateValuePicker());

		// Set the default value
		startPicker.setValue(new Date(), true);

		// Set the value in the text box when the user selects a date
		endPicker.addValueChangeHandler(new DateValuePicker());

		endPicker.setValue(new Date(), true);
		
		btSpeichern.addClickHandler(new SpeichernClickHandler());

		btAbbrechen.addClickHandler(new AbbrechenClickHandler());
		
//		tbProjektName.setVisible(false);
//		lbProjektListe.setVisible(true);

//		gridProjektForm1.setWidget(0, 0, lblProjektName);
//		gridProjektForm1.setWidget(0, 1, tbProjektName);
//		gridProjektForm1.setWidget(1, 0, lblInhalt);
//		gridProjektForm1.setWidget(1, 1, taInhalt);

		
		vpProjektForm1.add(tbProjektName);
		vpProjektForm1.add(taProjektInhalt);
		
//		gridProjektForm2.setWidget(0, 0, lblStart);
//		gridProjektForm2.setWidget(0, 1, startPicker);
//		gridProjektForm2.setWidget(1, 0, lblEnde);
//		gridProjektForm2.setWidget(1, 1, endPicker);
//	
		vpProjektForm2.add(lblStart);
		vpProjektForm2.add(startPicker);
		vpProjektForm2.add(lblEnde);
		vpProjektForm2.add(endPicker);
		
		hpButton.add(btSpeichern);
		hpButton.add(btAbbrechen);

		hpProjektForm.add(vpProjektForm1);
		hpProjektForm.add(vpProjektForm2);
		
		this.clear();
		this.add(hpProjektForm);
		this.add(hpButton);
		
	} 
	
	private class DateValuePicker implements ValueChangeHandler<Date> {

		@Override
		public void onValueChange(ValueChangeEvent<Date> event) {
			// TODO Auto-generated method stub
			Date date = event.getValue();
			String dateString = DateTimeFormat.getMediumDateFormat().format(date);
		}
		
	}
	
	private class SpeichernClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			Projekt p = new Projekt();
			p.setName(tbProjektName.getText());
			p.setStart(startPicker.getValue());
			p.setEnde(endPicker.getValue());
			p.setInhalt(taProjektInhalt.getText());
			projektService.updateProjekt(p, new ProjektSpeichernCallback(p));
		}
	}

	private class ProjektSpeichernCallback implements AsyncCallback<Projekt> {
		Projekt p = null;
		ProjektSpeichernCallback(Projekt projekt){
			p = projekt;
		}
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onSuccess(Projekt result) {
			// TODO Projekt panel aktualisieren
		}
		
	}
	
	private class AbbrechenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			hpProjektForm.clear();
		}
		
	}
	
}


