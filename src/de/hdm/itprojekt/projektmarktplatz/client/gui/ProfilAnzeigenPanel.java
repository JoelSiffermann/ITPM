package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class ProfilAnzeigenPanel extends HorizontalPanel {
	
	/*
	 * Neues Design
	 */

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	
	public void onLoad(){
		
		final VerticalPanel vpProfilForm1 = new VerticalPanel();
		final VerticalPanel vpProfilForm2 = new VerticalPanel();
		final TextBox tbName = new TextBox();
		final TextBox tbVorname = new TextBox();
		final TextBox tbBeruf = new TextBox();
		final TextBox tbJahreszahl = new TextBox();
		final Label lblBerufserfahrung = new Label("Berufserfahrung: ");
		final Label lblJahre = new Label("Jahre");
		final Grid gridProfil = new Grid(7, 2);

		
		final Button btProfilBearbeiten = new Button("Profil bearbeiten");
		final Button btProfilEntfernen = new Button("Profil entfernen");
	
		tbName.getElement().setPropertyString("placeholder", "Name");
		tbVorname.getElement().setPropertyString("placeholder", "Vorname");
		tbBeruf.getElement().setPropertyString("placeholder", "Beruf");
		tbJahreszahl.getElement().setPropertyString("placeholder", "Jahreszahl");
		
		gridProfil.setWidget(0, 0, tbJahreszahl);
		gridProfil.setWidget(0, 1, lblJahre);
		
		vpProfilForm1.add(tbVorname);
		vpProfilForm1.add(tbName);
		vpProfilForm1.add(tbBeruf);
		vpProfilForm1.add(lblBerufserfahrung);
		vpProfilForm1.add(gridProfil);
		
		vpProfilForm2.add(btProfilBearbeiten);
		vpProfilForm2.add(btProfilEntfernen);
		
		this.clear();
		this.add(vpProfilForm1);
		this.add(vpProfilForm2);

	}

}
