package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

public class BewertungForm extends VerticalPanel {

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public BewertungForm() {
		
	}
	
	public VerticalPanel getBewertungenSchreiben() {

		final VerticalPanel vpKopf = new VerticalPanel();
		final TextBox tbTitel = new TextBox();
		final VerticalPanel vpUnten = new VerticalPanel();
		final VerticalPanel bewertungTextPanel = new VerticalPanel();
		final TextArea bewertungText = new TextArea();
		
		final Button btSpeichern = new Button("Speichern");

		projektService.readAllBewerbung(new AsyncCallback<ArrayList<Bewerbung>>() {
			
			@Override
			public void onSuccess(ArrayList<Bewerbung> result) {
				// TODO Auto-generated method stub
				for (Bewerbung b : result) {
					
				}
				Window.alert("test");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("test2");
				
			}
		});
		tbTitel.getElement().setPropertyString("placeholder", "Name");
		vpKopf.add(tbTitel);

		bewertungText.setWidth("1000px");
		bewertungText.setHeight("300px");
		
		// add text to text area
		bewertungText.setText("");
		bewertungText.getElement().setPropertyString("placeholder", "Bewertungstext");

		// Add text boxes to the root panel.
		bewertungTextPanel.add(bewertungText);

		// **********************************************
	

		vpUnten.add(btSpeichern);

		this.add(vpKopf);
		this.add(bewertungTextPanel);
		this.add(vpUnten);
		
		return this;
	}

	public VerticalPanel getBewertungenAnzeigen() {

		final VerticalPanel vpKopf = new VerticalPanel();
		final ListBox lbTitel = new ListBox();
		final Button btBeteiligungErteilen = new Button("Beteiligung erteilen");
		final VerticalPanel vpUnten = new VerticalPanel();
		final VerticalPanel bewertungTextPanel = new VerticalPanel();
		final TextArea bewertungText = new TextArea();
		
		lbTitel.getElement().setPropertyString("placeholder", "Name");
		vpKopf.add(lbTitel);

		bewertungText.setWidth("1000px");
		bewertungText.setHeight("300px");
		bewertungText.setEnabled(false);

		// add text to text area
		bewertungText.setText("");
		bewertungText.getElement().setPropertyString("placeholder", "Bewertungstext");

		// Add text boxes to the root panel.
		bewertungTextPanel.add(bewertungText);

		vpUnten.add(btBeteiligungErteilen);

		this.add(vpKopf);
		this.add(bewertungTextPanel);
		this.add(vpUnten);
		return this;

	}

}
