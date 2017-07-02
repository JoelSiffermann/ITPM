package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

public class BewerbungNeuForm extends VerticalPanel {

	/*
	 * Neues Design
	 */

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	HorizontalPanel hpButton = new HorizontalPanel();
	Label lblInhalt = new Label("Inhalt:");
	TextArea taInhalt = new TextArea();
	Button btSpeichern = new Button("Speichern");
	Button btAbbrechen = new Button("Abbrechen");

	Bewerbung bewerbung = new Bewerbung();

	public BewerbungNeuForm(Bewerbung b) {
		this.bewerbung = b;
	}

	public void onLoad() {

		super.onLoad();
		if (this.bewerbung != null) {
			// lblInhalt.setText(bewerbung.getInhalt());
		}

		taInhalt.setWidth("300px");
		taInhalt.setHeight("300px");

		btSpeichern.addClickHandler(new SichBewerbenClickHandler());
		hpButton.add(btSpeichern);
		hpButton.add(btAbbrechen);

		this.clear();
		this.add(lblInhalt);
		this.add(taInhalt);
		this.add(hpButton);

	}

	private class SichBewerbenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if (taInhalt.getText().isEmpty()) {
				Window.alert("Bewerbungsschreiben eingeben: ");
			}

			else {
				Bewerbung bewerbung = new Bewerbung();
				bewerbung.setInhalt(taInhalt.getText());
				projektService.insertBewerbung(bewerbung, new SetBewerbung());
			}
			
		}
		
	}

	private class SetBewerbung implements AsyncCallback<Bewerbung> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Bewerbung konnte nicht angelegt werden");

		}

		@Override
		public void onSuccess(Bewerbung result) {
			Window.alert("Bewerbung wurde erfolgreich angelegt");
			RootPanel.get("Details").clear();
		}

	}
}
