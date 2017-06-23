package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class Home extends VerticalPanel {
	
	/*
	 * Neues Design
	 */

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public void onLoad() {

		final HorizontalPanel hpHeader = new HorizontalPanel();
		final HorizontalPanel hpInfo = new HorizontalPanel();
		final VerticalPanel vpMainNavigation = new VerticalPanel();
		final VerticalPanel vpInfo = new VerticalPanel();
		final Button btLogout = new Button("Logout");

		final Button btProfil = new Button("Profil");
		final Button btProjektNeu = new Button("Projekt anlegen");
		final Button btAusschreibungNeu = new Button("Ausschreibung anlegen");
		final Button btAusschreibungAnzeigen = new Button("Ausschreibung anzeigen");

		btProfil.addClickHandler(new ClickHandler() {

			ProfilNeuForm profilNeu = new ProfilNeuForm();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(profilNeu);
			}

		});

		btProjektNeu.addClickHandler(new ClickHandler() {

			ProjektNeuForm projektNeu = new ProjektNeuForm();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(projektNeu);
			}

		});

		btAusschreibungAnzeigen.addClickHandler(new ClickHandler() {

			AusschreibungAnzeigenForm ausschreibungAnzeigen = new AusschreibungAnzeigenForm();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(ausschreibungAnzeigen);
			}
		});

		btAusschreibungNeu.addClickHandler(new ClickHandler() {

			AusschreibungNeuForm ausschreibungNeu = new AusschreibungNeuForm();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(ausschreibungNeu);
			}

		});

		vpMainNavigation.addStyleName("mainNavigation");
		vpMainNavigation.add(btProfil);
		vpMainNavigation.add(btProjektNeu);
		vpMainNavigation.add(btAusschreibungNeu);
		vpMainNavigation.add(btAusschreibungAnzeigen);


		hpInfo.add(vpMainNavigation);
		hpInfo.add(vpInfo);

		RootPanel.get("nav").add(vpMainNavigation);
		RootPanel.get("header").add(btLogout);
		this.add(hpHeader);
		this.add(hpInfo);

	}
}
