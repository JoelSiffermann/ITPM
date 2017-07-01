package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Date;


import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;


public class AusschreibungNeuForm extends VerticalPanel {
	
	/*
	 * Neues Design
	 */

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	
	public void onLoad() {
		
		final HorizontalPanel hpAusschreibungForm = new HorizontalPanel();
		final VerticalPanel vpAusschreibungForm1 = new VerticalPanel();
		final VerticalPanel vpAusschreibungForm2 = new VerticalPanel();
		final HorizontalPanel hpButton = new HorizontalPanel();		
		final TextBox tbAusschreibung = new TextBox();
		final TextBox tbPartnerProfilBeschreibung = new TextBox();
		final TextBox tbPartnerProfilWert = new TextBox();
		final TextArea taAusschreibungInhalt = new TextArea();
		final DatePicker dpFrist = new DatePicker();
		final Label lblAusschreibungName = new Label("Ausschreibungbezeichnung:");
		final Label lblAusschreibungInhalt = new Label("Ausschreibungsbeschreibung:");
		final Label lblFrist = new Label("Frist:");
		final Label lblPartnerProfil = new Label("Partnerprofil:");
		final Label lblPartnerProfilBeschreibung = new Label("Beschreibung:");
		final Label lblPartnerProfilWert = new Label("Wert:");
		
		final Button btSpeichern = new Button("Speichern");
		final Button btAbbrechen = new Button("Abbrechen");
		
		tbAusschreibung.getElement().setPropertyString("placeholder", "Ausschreibungname");

		taAusschreibungInhalt.setWidth("300px");
		taAusschreibungInhalt.setHeight("300px");
		taAusschreibungInhalt.getElement().setPropertyString("placeholder", "Ausschreibungbezeichnung");
		
		dpFrist.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		dpFrist.setValue(new Date(), true);

		vpAusschreibungForm1.add(lblAusschreibungName);
		vpAusschreibungForm1.add(tbAusschreibung);
		vpAusschreibungForm1.add(lblFrist);
		vpAusschreibungForm1.add(dpFrist);
		vpAusschreibungForm1.add(lblAusschreibungInhalt);
		vpAusschreibungForm1.add(taAusschreibungInhalt);
		
		vpAusschreibungForm2.add(lblPartnerProfil);
		vpAusschreibungForm2.add(lblPartnerProfilBeschreibung);
		vpAusschreibungForm2.add(tbPartnerProfilBeschreibung);
		vpAusschreibungForm2.add(lblPartnerProfilWert);
		vpAusschreibungForm2.add(tbPartnerProfilWert);

		hpButton.add(btSpeichern);
		hpButton.add(btAbbrechen);

		hpAusschreibungForm.add(vpAusschreibungForm1);
		hpAusschreibungForm.add(vpAusschreibungForm2);
		
		this.clear();
		this.add(hpAusschreibungForm);
		this.add(hpButton);
		
	}
}
