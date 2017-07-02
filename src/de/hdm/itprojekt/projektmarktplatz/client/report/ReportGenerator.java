package de.hdm.itprojekt.projektmarktplatz.client.report;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

import de.hdm.itprojekt.projektmarktplatz.client.Impressum;

	/**
	 * Entrypoint der Klasse ReportGenerator
	 * @author Vi Quan, Joey Siffermann
	 *
	 */

public class ReportGenerator implements EntryPoint {

	HorizontalPanel hpHeader = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();
	Button btLogout = new Button("Logout");
	Button btImpressum = new Button("Impressum");
	
	/**
	 * Die Methode onModuleLoad() baut das Widget auf.
	 */
	
	@Override
	public void onModuleLoad() {
		
		loadGUI();
	}

	private void loadGUI() {
		btLogout.addClickHandler(new LogoutClickHandler());
		btImpressum.addClickHandler(new ImpressumClickHandler());
		ReportNavPanel repnav = new ReportNavPanel();
		RootPanel.get("nav").add(repnav);
		RootPanel.get("header").add(btLogout);
		RootPanel.get("footer").add(btImpressum);
	}
	
	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */
	
	private class ImpressumClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			Impressum imp = new Impressum();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(imp);
		}
		
	}
	
	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */
	
	private class LogoutClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			RootPanel.get("nav").clear();
			RootPanel.get("mainReport").clear();
			RootPanel.get("header").clear();
			Window.open("https://www.google.de/", "_self", "");
		}
		
	}
}
