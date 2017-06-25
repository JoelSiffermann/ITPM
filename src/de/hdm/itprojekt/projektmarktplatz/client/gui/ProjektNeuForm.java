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

	public void onLoad() {

		final HorizontalPanel hpProjektForm = new HorizontalPanel();
		final VerticalPanel vpProjektForm1 = new VerticalPanel();
		final VerticalPanel vpProjektForm2 = new VerticalPanel();
		final HorizontalPanel hpButton = new HorizontalPanel();
		final TextArea taProjektInhalt = new TextArea();
		final TextBox tbProjektName = new TextBox();

		final DatePicker startPicker = new DatePicker();
		final DatePicker endPicker = new DatePicker();

		final Button btSpeichern = new Button("Projekt speichern");
		final Button btAbbrechen = new Button("Abbrechen");
		final Label lblProjektName = new Label("Projektname:");
		final Label lblStart = new Label("Start:");
		final Label lblEnde = new Label("Ende:");
		final Label lblInhalt = new Label("Inhalt:");
		
		tbProjektName.getElement().setPropertyString("placeholder", "Projektname");

		taProjektInhalt.setWidth("300px");
		taProjektInhalt.setHeight("300px");
		taProjektInhalt.getElement().setPropertyString("placeholder", "Projektbezeichnung");
		
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

		endPicker.setValue(new Date(), true);

//		tbProjektName.setVisible(false);
//		lbProjektListe.setVisible(true);

//		gridProjektForm1.setWidget(0, 0, lblProjektName);
//		gridProjektForm1.setWidget(0, 1, tbProjektName);
//		gridProjektForm1.setWidget(1, 0, lblInhalt);
//		gridProjektForm1.setWidget(1, 1, taInhalt);

		vpProjektForm1.add(lblProjektName);
		vpProjektForm1.add(tbProjektName);
		vpProjektForm1.add(lblInhalt);
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
}
