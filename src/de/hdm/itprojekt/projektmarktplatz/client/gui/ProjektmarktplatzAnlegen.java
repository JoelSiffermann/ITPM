package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

/**
 * Klasse zur Darstellung von neuen Projektmarktplatz-Objekten
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class ProjektmarktplatzAnlegen extends VerticalPanel {

	private final ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	Button btOk = new Button("Sichern");
	Button btAbbruch = new Button("Abbrechen");

	VerticalPanel vpanel = new VerticalPanel();
	HorizontalPanel hpanel = new HorizontalPanel();

	Label pmName = new Label("Projektmarktplatzbezeichnung: ");
	TextArea bez = new TextArea();
	FlexTable pmSeite = new FlexTable();

	/**
	 * Konstruktor
	 * 
	 */

	public ProjektmarktplatzAnlegen() {
		this.setText("Projektmarktplatz anlegen");
		btOk.setStylePrimaryName("button");
		btAbbruch.setStylePrimaryName("button");

		hpanel.add(btOk);
		hpanel.add(btAbbruch);

		btOk.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (bez.getText().isEmpty()) {
					Window.alert("Projektmarktplatzbezeichnung eingeben: ");
				}

				else {
					Projektmarktplatz projMark = new Projektmarktplatz();
					projMark.setBezeichnung(bez.getText());
					projektService.insertProjektmarktplatz(projMark, new SetPM());
				}
			}

		}

		);
		btAbbruch.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();

			}
		});

		pmSeite.setWidget(1, 0, pmName);
		pmSeite.setWidget(2, 0, bez);

		vpanel.add(pmSeite);
		vpanel.add(hpanel);
		this.add(vpanel);

	}

	private void setText(String string) {
		// TODO Auto-generated method stub

	}

	private class SetPM implements AsyncCallback<Projektmarktplatz> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Projektmarktplatz konnte nicht angelegt werden");

		}

		@Override
		public void onSuccess(Projektmarktplatz result) {
			Window.alert("Projektmarktplatz wurde erfolgreich angelegt");
			RootPanel.get("Details").clear();
		}

	}

}
