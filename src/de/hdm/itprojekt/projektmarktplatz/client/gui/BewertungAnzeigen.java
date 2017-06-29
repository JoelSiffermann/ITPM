package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.gargoylesoftware.htmlunit.javascript.host.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class BewertungAnzeigen extends VerticalPanel {
	
	/*
	 * Neues Design
	 */
	
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public void onLoad() {
		
		final Label lblBewertungSkala = new Label("Bewertung: ");
		final Label lblBegruendung = new Label("Begruendung: ");
		final TextArea taBewertungInhalt = new TextArea();
		final TextBox tbSkalaWert = new TextBox();
		final Grid gridBewertung = new Grid(1, 2);
		
		final Button btZurueck = new Button("Zurueck");
			
		gridBewertung.setWidget(0, 0, lblBewertungSkala);
		gridBewertung.setWidget(0, 1, tbSkalaWert);
		
		this.clear();
		this.add(gridBewertung);
		this.add(lblBegruendung);
		this.add(taBewertungInhalt);
		this.add(btZurueck);
		
	}

}
