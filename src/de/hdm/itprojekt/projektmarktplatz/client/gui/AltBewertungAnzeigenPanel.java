package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class AltBewertungAnzeigenPanel extends HorizontalPanel{

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	
	public void onLoad (){
		final HorizontalPanel hPanel = new HorizontalPanel();
		final VerticalPanel vPanel = new VerticalPanel();
		final VerticalPanel vPanel2 = new VerticalPanel();
		final Label lBewertung = new Label("Bewertung: "); 
		final Label lBegruendung = new Label("Begründung: ");
		final TextArea taBegruendung = new TextArea();
		final Button btBearbeiten = new Button("Bearbeiten");
		final Button btLoeschen = new Button("Löschen");
		final Button btSpeichern = new Button("Speichern");
		
		hPanel.add(vPanel);
		hPanel.add(vPanel2);
		vPanel.add(lBewertung);
		vPanel.add(lBegruendung);
		vPanel2.add(btBearbeiten);
		vPanel2.add(btLoeschen);
		vPanel2.add(btSpeichern);
		
		
		this.add(hPanel);
		
		
		
	
		
	}
}
