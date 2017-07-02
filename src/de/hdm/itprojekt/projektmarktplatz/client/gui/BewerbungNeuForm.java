package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class BewerbungNeuForm extends VerticalPanel {
	
	/*
	 * Neues Design
	 */

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	VerticalPanel vp = new VerticalPanel();
	HorizontalPanel hpButton = new HorizontalPanel();
	Label lblInhalt = new Label("Inhalt:");
	TextArea taInhalt = new TextArea();
	Button btSpeichern = new Button("Speichern");
	Button btAbbrechen = new Button("Abbrechen");
	Bewerbung b = new Bewerbung();
	Organisationseinheit bewerber = new Organisationseinheit();
	Ausschreibung a = new Ausschreibung();
	
	public BewerbungNeuForm (Ausschreibung aus) {
		this.a = aus;
	}
	
	public void onLoad() {

		super.onLoad();
		bewerber.setEmail(Cookies.getCookie("email"));
		taInhalt.setWidth("300px");
		taInhalt.setHeight("300px");
		
		hpButton.add(btSpeichern);
		btSpeichern.addClickHandler(new SpeichernClickHandler());
		hpButton.add(btAbbrechen);
		btAbbrechen.addClickHandler(new AbbrechenClickHandler());
		
		
		vp.add(lblInhalt);
		vp.add(taInhalt);
		vp.add(hpButton);
		this.add(vp);
	}
	
	private class SpeichernClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			b.setAusschreibung(a);
			b.setBewerber(bewerber);
			b.setInhalt(taInhalt.getText());
			b.setErstelldatum(new Date());
			projektService.insertBewerbung(b, new BewerbungCallback());
		}
		
	}
	
	private class AbbrechenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			vp.clear();
		}
		
	}
	
	private class BewerbungCallback implements AsyncCallback<Bewerbung> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(Bewerbung result) {
			Window.alert("Gespeichert.");
			vp.clear();
		}
		
	}

}
