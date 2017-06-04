package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuBarPanel extends MenuBar {

	public MenuBar getMenuBarPanel(final VerticalPanel mainP) {
		Command cmd = new Command() {
			public void execute() {
				Window.alert("You selected a menu item!");
			}
		};

		Command cmdProfilBearbeiten = new Command() {
			public void execute() {
				ProfilForm profilBearbeitenForm = new ProfilForm();
				mainP.clear();
				mainP.add(profilBearbeitenForm);
			}
		};

		Command cmdAusschreibungErstellen = new Command() {
			public void execute() {
				AusschreibungForm ausschreibungErstellenForm = new AusschreibungForm();
				mainP.clear();
				mainP.add(ausschreibungErstellenForm);
			}
		};

		Command cmdBewertungErstellen = new Command() {
			public void execute() {
				AusschreibungForm bewertungErstellenForm = new AusschreibungForm();
				mainP.clear();
				mainP.add(bewertungErstellenForm);
			}
		};

		Command cmdBewerbungErstellen = new Command() {
			public void execute() {
				AusschreibungForm bewerbungErstellenForm = new AusschreibungForm();
				mainP.clear();
				mainP.add(bewerbungErstellenForm);
			}
		};

		Command cmdPartnerProfilErstellen = new Command() {
			public void execute() {
				AusschreibungForm partnerProfilErstellenForm = new AusschreibungForm();
				mainP.clear();
				mainP.add(partnerProfilErstellenForm);
			}
		};

		Command cmdPmpAnzeigen = new Command() {
			public void execute() {
				MainPanel mp = new MainPanel();
				// mainP.clear();
				// mainP.add(mp);
				RootPanel.get("main").clear();
				RootPanel.get("main").add(mp);
			}
		};

		MenuBar profilMenu = new MenuBar(true);
		profilMenu.addItem("Profil bearbeiten", cmdProfilBearbeiten);
		profilMenu.addItem("Ausschreibung erstellen", cmdAusschreibungErstellen);
		profilMenu.addItem("Bewertung erstellen", cmdBewertungErstellen);
		profilMenu.addItem("Bewerbung erstellen", cmdBewerbungErstellen);
		profilMenu.addItem("Partnerprofil erstellen", cmdPartnerProfilErstellen);

		MenuBar reportMenu = new MenuBar(true);
		reportMenu.addItem("Report anzeigen", cmd);

		MenuBar pmpMenu = new MenuBar(true);
		pmpMenu.addItem("Projektmarktplatz anzeigen", cmdPmpAnzeigen);

		MenuBar logoutMenu = new MenuBar(true);
		logoutMenu.addItem("Logout", cmd);

		MenuBar menu = new MenuBar();
		menu.addItem("Profil", profilMenu);
		menu.addItem("Projektmarktplatz", pmpMenu);
		menu.addItem("Report", reportMenu);
		menu.addItem("Logout", logoutMenu);
		return menu;
	}

	public VerticalPanel getProfilAnlegenForm(VerticalPanel vpProfilAnlegenForm) {

		return vpProfilAnlegenForm;
	}
}
