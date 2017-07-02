package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;

/**
 * Klasse zur Darstellung von Bewertung-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class BewertungAnzeigen extends VerticalPanel {

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	Label lblBewertungSkala = new Label("Bewertung: ");
	Label lblBegruendung = new Label("Begruendung: ");
	TextArea taBewertungInhalt = new TextArea();
	TextBox tbSkalaWert = new TextBox();
	Grid gridBewertung = new Grid(1, 2);
	
	Bewertung bewertung;
	Beteiligung beteiligung;
	
	/**
	 * Konstruktor
	 * @param selection
	 */
	
	public BewertungAnzeigen(Beteiligung selection) {
		this.beteiligung = selection;
	}

	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */
	
	public void onLoad() {

		super.onLoad();
		
		taBewertungInhalt.setWidth("300px");
		taBewertungInhalt.setHeight("300px");
		taBewertungInhalt.setEnabled(false);
		
		if (this.bewertung != null) {
			lblBegruendung.setText(bewertung.getInhalt());
		}

		gridBewertung.setWidget(0, 0, lblBewertungSkala);
		gridBewertung.setWidget(0, 1, tbSkalaWert);

		this.clear();
		this.add(gridBewertung);
		this.add(lblBegruendung);
		this.add(taBewertungInhalt);

	}

}
