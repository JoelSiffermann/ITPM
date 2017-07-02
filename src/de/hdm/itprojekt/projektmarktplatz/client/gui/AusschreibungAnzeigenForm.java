package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Date;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

/**
 * Klasse zur Darstellung von Ausschreibung-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class AusschreibungAnzeigenForm extends HorizontalPanel {

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	VerticalPanel vpAusschreibungAnzeigenForm1 = new VerticalPanel();
	VerticalPanel vpAusschreibungAnzeigenForm2 = new VerticalPanel();
	HorizontalPanel hpAusschreibungAnzeigenForm = new HorizontalPanel();

	TextBox tbPartnerProfilBeschreibung = new TextBox();
	TextBox tbPartnerProfilWert = new TextBox();
	DatePicker dpFrist = new DatePicker();
	TextArea taAusschreibungInhalt = new TextArea();
	Label lblAusschreibungName = new Label("Ausschreibungbezeichnung");
	Label lblAusschreibungInhalt = new Label("Ausschreibungsbeschreibung:");
	Label lblFrist = new Label("Frist:");
	Label lblGesucht = new Label("Gesucht:");
	Label lblPartnerProfilBeschreibung = new Label("Beschreibung:");
	Label lblPartnerProfilWert = new Label("Wert:");

	Button btAusschreibungBearbeiten = new Button("Ausschreibung bearbeiten");
	Button btAusschreibungEntfernen = new Button("Ausschreibung entfernen");
	TextCell textCell = new TextCell();

	Projekt projekt = new Projekt();
	
	/**
	 * Konstruktor
	 * @param p Projekt
	 */
	
	public AusschreibungAnzeigenForm(Projekt p) {
		this.projekt = p;
	}
	
	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */
	
	public void onLoad() {
		
		super.onLoad();
		
		tbPartnerProfilWert.setEnabled(false);
		tbPartnerProfilBeschreibung.setEnabled(false);
		taAusschreibungInhalt.setEnabled(false);
		taAusschreibungInhalt.setHeight("300px");
		taAusschreibungInhalt.setWidth("300px");
			
		dpFrist.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		dpFrist.setValue(new Date(), true);
		
		btAusschreibungBearbeiten.addClickHandler(new ClickHandler() {
			
			AusschreibungNeuForm ausschreibungNeu = new AusschreibungNeuForm(projekt);

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hpAusschreibungAnzeigenForm.clear();
				hpAusschreibungAnzeigenForm.add(ausschreibungNeu);
			}
			
		});

		vpAusschreibungAnzeigenForm1.add(lblAusschreibungName);
		vpAusschreibungAnzeigenForm1.add(lblAusschreibungInhalt);
		vpAusschreibungAnzeigenForm1.add(taAusschreibungInhalt);
		vpAusschreibungAnzeigenForm1.add(lblFrist);
		vpAusschreibungAnzeigenForm1.add(dpFrist);
		vpAusschreibungAnzeigenForm1.add(lblGesucht);
		vpAusschreibungAnzeigenForm1.add(lblPartnerProfilBeschreibung);
		vpAusschreibungAnzeigenForm1.add(tbPartnerProfilBeschreibung);
		vpAusschreibungAnzeigenForm1.add(lblPartnerProfilWert);
		vpAusschreibungAnzeigenForm1.add(tbPartnerProfilWert);

		vpAusschreibungAnzeigenForm2.add(btAusschreibungBearbeiten);
		vpAusschreibungAnzeigenForm2.add(btAusschreibungEntfernen);

		hpAusschreibungAnzeigenForm.add(vpAusschreibungAnzeigenForm1);
		hpAusschreibungAnzeigenForm.add(vpAusschreibungAnzeigenForm2);

		this.clear();
		this.add(hpAusschreibungAnzeigenForm);

	}

}
