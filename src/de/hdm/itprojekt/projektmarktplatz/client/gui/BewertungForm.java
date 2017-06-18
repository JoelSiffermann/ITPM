package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;

public class BewertungForm extends VerticalPanel {

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public BewertungForm() {
		
	}
	
	public VerticalPanel getBewertungenSchreiben(final String selectedValue) {

		final VerticalPanel vpKopf = new VerticalPanel();
		final Label lblTitel = new Label();
		final VerticalPanel vpUnten = new VerticalPanel();
		final VerticalPanel bewertungTextPanel = new VerticalPanel();
		final TextArea bewertungText = new TextArea();
		final Button btSpeichern = new Button("Speichern");

		btSpeichern.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

//				for (Bewerbung b : result) {
//					
//				}
//				Window.alert("test");
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
//				Window.alert("test2");

				Bewertung bt = new Bewertung();

				
				bt.setInhalt(bewertungText.getText());
				bt.setSkala(0);
				
				projektService.insertBewertung(bt, selectedValue, new AsyncCallback<Bewertung>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Bewertung result) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
		
		lblTitel.getElement().setPropertyString("placeholder", "Name");
		vpKopf.add(lblTitel);

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
