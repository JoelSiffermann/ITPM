package de.hdm.itprojekt.projektmarktplatz.client.report;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Klasse zur Navigation des ReportGenerators
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class ReportNavPanel extends VerticalPanel {
	HorizontalPanel nav = new HorizontalPanel();
	HorizontalPanel info = new HorizontalPanel();

	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */

	public void onLoad() {
		super.onLoad();
		StackPanel panel = new StackPanel();
		panel.add(ausschreibungStack(), "Ausschreibungen abfragen");
		panel.add(bewerbungStack(), "Bewerbungen abfragen");
		panel.add(andereStack(), "Andere Reports");
		panel.add(projektmarktplatz(), "Projektmarktplatz");
		nav.add(panel);
		RootPanel.get("nav").add(nav);
		RootPanel.get("mainReport").clear();
		RootPanel.get("mainReport").add(info);
	}

	private VerticalPanel projektmarktplatz() {
		VerticalPanel pm = new VerticalPanel();
		Button btPM = new Button("Zum Projektmarktplatz wechseln");
		btPM.addClickHandler(new ProjektMarktplatzClickHandler());
		pm.add(btPM);
		return pm;
	}

	private VerticalPanel ausschreibungStack() {
		VerticalPanel astack = new VerticalPanel();
		Button btAlleAusschreibungen = new Button("Alle Ausschreibungen");
		Button btEmpfAusschreibungen = new Button("Empfohlene Ausschreibungen");
		btAlleAusschreibungen.addClickHandler(new AlleAusschreibungenClickHandler());
		btEmpfAusschreibungen.addClickHandler(new EmpfAusschreibungenClickHandler());
		astack.add(btAlleAusschreibungen);
		astack.add(btEmpfAusschreibungen);
		return astack;
	}

	private VerticalPanel bewerbungStack() {
		VerticalPanel bstack = new VerticalPanel();
		Button btEigeneBewerbungen = new Button("Eigene Bewerbungen");
		Button btAndereBewerbungen = new Button("Andere Bewerbungen");
		btEigeneBewerbungen.addClickHandler(new EigeneBewerbungenClickHandler());
		btAndereBewerbungen.addClickHandler(new AndereBewerbungenClickHandler());
		bstack.add(btEigeneBewerbungen);
		bstack.add(btAndereBewerbungen);
		return bstack;
	}

	private VerticalPanel andereStack() {
		VerticalPanel astack = new VerticalPanel();
		Button btProjektverflechtung = new Button("Projektverflechtungen");
		Button btAnalyse = new Button("Analyse durchführen");
		btProjektverflechtung.addClickHandler(new ProjektverflechtungClickHandler());
		btAnalyse.addClickHandler(new AnalyseClickHandler());
		astack.add(btProjektverflechtung);
		astack.add(btAnalyse);
		return astack;
	}

	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */

	private class AlleAusschreibungenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AlleAusschreibungenReport aar = new AlleAusschreibungenReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(aar);
		}
	}

	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */

	private class EmpfAusschreibungenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			EmpfAusschreibungReport ear = new EmpfAusschreibungReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(ear);
		}
	}

	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */

	private class EigeneBewerbungenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			EigBewerbungenReport ebr = new EigBewerbungenReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(ebr);
		}
	}

	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */

	private class AndereBewerbungenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AusBewerbungenReport abr = new AusBewerbungenReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(abr);
		}
	}

	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */

	private class ProjektverflechtungClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			ProjektverflechtungReport prep = new ProjektverflechtungReport();
			// ProjVerTest prep = new ProjVerTest();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(prep);
		}
	}

	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */

	private class AnalyseClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AnalyseReport anrep = new AnalyseReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(anrep);
		}
	}

	/**
	 * Innere Klasse zum Behandeln von ClickEvents.
	 * 
	 *
	 */

	private class ProjektMarktplatzClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			Window.open(GWT.getHostPageBaseURL() + "ProjektmarktplatzProjekt.html", "_self", "enable");
		}
	}
}
