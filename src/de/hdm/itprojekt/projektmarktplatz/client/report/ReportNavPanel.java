package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.client.gui.BeteiligungPanel;
import de.hdm.itprojekt.projektmarktplatz.client.gui.Home;
import de.hdm.itprojekt.projektmarktplatz.client.gui.ProfilForm;
import de.hdm.itprojekt.projektmarktplatz.client.gui.ProjektmarktplatzForm;

public class ReportNavPanel extends VerticalPanel{
	HorizontalPanel nav = new HorizontalPanel();
	HorizontalPanel info = new HorizontalPanel();
	public void onLoad() {
		super.onLoad();
	    // Create a stack panel containing three labels.
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
	
	private VerticalPanel ausschreibungStack(){
		VerticalPanel astack = new VerticalPanel();
		Button btAlleAusschreibungen = new Button("Alle Ausschreibungen");
		Button btEmpfAusschreibungen = new Button("Empfohlene Ausschreibungen");
		btAlleAusschreibungen.addClickHandler(new AlleAusschreibungenClickHandler());
		btEmpfAusschreibungen.addClickHandler(new EmpfAusschreibungenClickHandler());
		astack.add(btAlleAusschreibungen);
		astack.add(btEmpfAusschreibungen);
		return astack;
	}
	
	private VerticalPanel bewerbungStack(){
		VerticalPanel bstack = new VerticalPanel();
		Button btEigeneBewerbungen = new Button("Eigene Bewerbungen");
		Button btAndereBewerbungen = new Button("Andere Bewerbungen");
		btEigeneBewerbungen.addClickHandler(new EigeneBewerbungenClickHandler());
		btAndereBewerbungen.addClickHandler(new AndereBewerbungenClickHandler());
		bstack.add(btEigeneBewerbungen);
		bstack.add(btAndereBewerbungen);
		return bstack;
	}
	
	private VerticalPanel andereStack(){
		VerticalPanel astack = new VerticalPanel();
		Button btProjektverflechtung = new Button("Projektverflechtungen");
		Button btAnalyse = new Button("Analyse durchführen");
		btProjektverflechtung.addClickHandler(new ProjektverflechtungClickHandler());
		btAnalyse.addClickHandler(new AnalyseClickHandler());
		astack.add(btProjektverflechtung);
		astack.add(btAnalyse);
		return astack;
	}
	
	private class AlleAusschreibungenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AlleAusschreibungenReport aar = new AlleAusschreibungenReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(aar);
		}
	}
	
	private class EmpfAusschreibungenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			EmpfAusschreibungReport ear = new EmpfAusschreibungReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(ear);
		}
	}
	
	private class EigeneBewerbungenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			EigBewerbungenReport ebr = new EigBewerbungenReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(ebr);
		}
	}
	
	private class AndereBewerbungenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AusBewerbungenReport abr = new AusBewerbungenReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(abr);
		}
	}
	
	private class ProjektverflechtungClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			ProjektverflechtungReport prep = new ProjektverflechtungReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(prep);
		}	
	}
	
	private class AnalyseClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AnalyseReport anrep = new AnalyseReport();
			RootPanel.get("mainReport").clear();
			RootPanel.get("mainReport").add(anrep);
		}	
	}
	
	private class ProjektMarktplatzClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			Window.open(GWT.getHostPageBaseURL(), "/ProjektmarktplatzProjekt.html", "enable");
			//TODO logout
		}	
	}
}
