package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class BewerbungNeuForm extends VerticalPanel {
	
	/*
	 * Neues Design
	 */

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public void onLoad() {
		
		HorizontalPanel hpButton = new HorizontalPanel();
		Label lblInhalt = new Label("Inhalt:");
		TextArea taInhalt = new TextArea();
		Button btSpeichern = new Button("Speichern");
		Button btAbbrechen = new Button("Abbrechen");
		
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
