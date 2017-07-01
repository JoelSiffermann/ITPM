package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class ProfilAnzeigenPanel extends HorizontalPanel {
	
	/*
	 * Neues Design
	 */

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	
	public void onLoad(){
		//Superklasse ->Methodenaufrauf    
		super.onLoad();
		
	
		tbName.getElement().setPropertyString("placeholder", "Name");
		tbVorname.getElement().setPropertyString("placeholder", "Vorname");
		tbBeruf.getElement().setPropertyString("placeholder", "Beruf");
		tbJahreszahl.getElement().setPropertyString("placeholder", "Berufserfahrung in Jahre");
		
		gridProfil.setWidget(0, 0, tbJahreszahl);
		
		vpProfilForm1.add(tbVorname);
		vpProfilForm1.add(tbName);
		vpProfilForm1.add(tbBeruf);
		vpProfilForm1.add(gridProfil);
		
		vpProfilForm2.add(btProfilBearbeiten);
		vpProfilForm2.add(btProfilEntfernen);
		
		this.clear();//nicht nötig, weil frisch angelegt wurde
		
		this.add(vpProfilForm1);
		this.add(vpProfilForm2);

	}
	
	 VerticalPanel vpProfilForm1 = new VerticalPanel();
	 VerticalPanel vpProfilForm2 = new VerticalPanel();
	 TextBox tbName = new TextBox();
	 TextBox tbVorname = new TextBox();
	 TextBox tbBeruf = new TextBox();
	 TextBox tbJahreszahl = new TextBox();
	 Grid gridProfil = new Grid(7, 2);

	
	 Button btProfilBearbeiten = new Button("Profil bearbeiten");
	 Button btProfilEntfernen = new Button("Profil entfernen");

}
