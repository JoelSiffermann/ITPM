package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.LoginInfo;

public class Home extends VerticalPanel {
	
	/*
	 * Neues Design
	 */
	MainNavigationPanel mainnav = new MainNavigationPanel();

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
//	private Anchor signOutLink = new Anchor("Sign Out");
//	private LoginInfo loginInfo = null;
	public void onLoad() {

		super.onLoad();
		final HorizontalPanel hpHeader = new HorizontalPanel();
		final HorizontalPanel hpInfo = new HorizontalPanel();
		final VerticalPanel vpMainNavigation = new VerticalPanel();
		final VerticalPanel vpInfo = new VerticalPanel();
//		signOutLink.setHref(loginInfo.getLogoutUrl());
		final Button btLogout = new Button("Logout");

		final Button btProfilBearbeiten = new Button("Profil bearbeiten");
		final Button btProfilAnzeigen = new Button("Profil anzeigen");
		final Button btProjektNeu = new Button("Projekt anlegen");
		final Button btAusschreibungNeu = new Button("Ausschreibung anlegen");
		final Button btAusschreibungAnzeigen = new Button("Ausschreibung anzeigen");
		final Button btMeineProjekte = new Button("Meine Projekte");
		final Button btMeineBeteiligung = new Button("Meine Beteiligung");
		final Button btBewertungAnzeigen = new Button("Bewertung anzeigen");
		final Button btAndereBeteiligung = new Button("Andere Beteiligung");
		final Button btAndereProjekte = new Button("Andere Projekte");
		final Button btMeineBewerbung = new Button("Meine Bewerbungen");
		final Button btBewerbungNeu = new Button("Sich bewerben");
		final Button btPM = new Button("Projektmarktplatz");
		
		btProfilBearbeiten.addClickHandler(new ClickHandler() {

			ProfilNeuForm profilNeu = new ProfilNeuForm();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(profilNeu);
			}

		});
		
		btProfilAnzeigen.addClickHandler(new ClickHandler() {
			
			ProfilAnzeigenPanel profilAnzeigen = new ProfilAnzeigenPanel();
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(profilAnzeigen);
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
		
		btMeineProjekte.addClickHandler(new ClickHandler() {

//			MeineProjektePanel meineProjekte = new MeineProjektePanel();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
//				vpInfo.add(meineProjekte);
			}

		});
		
		btMeineBeteiligung.addClickHandler(new ClickHandler() {

			MeineBeteiligungPanel meineBeteiligung = new MeineBeteiligungPanel();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(meineBeteiligung);
			}

		});
		
		btAndereBeteiligung.addClickHandler(new ClickHandler() {

			AndereBeteiligungPanel andereBeteiligung = new AndereBeteiligungPanel();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(andereBeteiligung);
				
			}

		});

		btBewertungAnzeigen.addClickHandler(new ClickHandler() {

			BewertungAnzeigen bewertungAnzeigen = new BewertungAnzeigen();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(bewertungAnzeigen);
			}

		});
		
		btAndereProjekte.addClickHandler(new ClickHandler() {

			AndereProjekte andereProjekte = new AndereProjekte();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(andereProjekte);
			}

		});
		btMeineBewerbung.addClickHandler(new ClickHandler() {
			MeineBewerbung m = new MeineBewerbung();
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(m); 
			}
		});
		
		btBewerbungNeu.addClickHandler(new ClickHandler() {

			BewerbungNeuForm sichBewerben = new BewerbungNeuForm();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(sichBewerben);
			}

		});
		
		btPM.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ProjektmarktplatzAnzeigen pm = new ProjektmarktplatzAnzeigen();
				// TODO Auto-generated method stub
				vpInfo.clear();
				vpInfo.add(pm);
				//pm.getData();
				
			}
		});
		
//		vpMainNavigation.addStyleName("mainNavigation");
//		vpMainNavigation.add(btProfilBearbeiten);
//		vpMainNavigation.add(btProfilAnzeigen);
//		vpMainNavigation.add(btProjektNeu);
//		vpMainNavigation.add(btAusschreibungNeu);
//		vpMainNavigation.add(btAusschreibungAnzeigen);
//		vpMainNavigation.add(btPM);
//		vpMainNavigation.add(btMeineProjekte);
//		vpMainNavigation.add(btMeineBeteiligung);
//		vpMainNavigation.add(btBewertungAnzeigen);
//		vpMainNavigation.add(btAndereBeteiligung);
//		vpMainNavigation.add(btAndereProjekte);
//		vpMainNavigation.add(btMeineBewerbung);
//		vpMainNavigation.add(btBewerbungNeu);


//		hpInfo.add(vpMainNavigation);
//		hpInfo.add(vpInfo);

//		RootPanel.get("nav").add(vpMainNavigation);
//		RootPanel.get("nav").add(mainnav);
//		RootPanel.get("header").add(signOutLink);

		
//		this.clear();
//		this.add(hpHeader);
//		this.add(hpInfo);


	}
}
