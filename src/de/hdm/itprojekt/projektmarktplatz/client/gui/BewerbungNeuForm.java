package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

/**
 * Klasse zur Darstellung von Bewerbung-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class BewerbungNeuForm extends VerticalPanel {

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	HorizontalPanel hpButton = new HorizontalPanel();
	Label lblInhalt = new Label("Inhalt:");
	TextArea taInhalt = new TextArea();
	Button btSpeichern = new Button("Speichern");
	Button btAbbrechen = new Button("Abbrechen");
	
	Bewerbung bewerbung = new Bewerbung();
	
	/**
	 * Konstruktor
	 * @param b Bewerbung
	 */
	
	public BewerbungNeuForm (Bewerbung b) {
		this.bewerbung = b;
	}
	
	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */
	
	public void onLoad() {

		super.onLoad();
		if(this.bewerbung!=null){
		}
		
		taInhalt.setWidth("300px");
		taInhalt.setHeight("300px");
		
		hpButton.add(btSpeichern);
		hpButton.add(btAbbrechen);
		
		this.clear();
		this.add(lblInhalt);
		this.add(taInhalt);
		this.add(hpButton);
		
	}

}
