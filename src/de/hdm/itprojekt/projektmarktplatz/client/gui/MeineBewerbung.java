package de.hdm.itprojekt.projektmarktplatz.client.gui;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

/**
 * Klasse zur Darstellung von meinen Bewerbung-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */


public class MeineBewerbung extends HorizontalPanel {

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	HorizontalPanel hPanel = new HorizontalPanel();
	VerticalPanel vPanel = new VerticalPanel();
	VerticalPanel vPanel2 = new VerticalPanel();
	Label lblDatum = new Label("Datum: ");
	DatePicker eDatum = new DatePicker();
	TextArea taAnschreiben = new TextArea();
//	Button btBearbeiten = new Button("Bewerbung bearbeiten");
	Button btLoeschen = new Button("Bewerbung löschen");
//	Button btAnzeigen = new Button("Bewertung anzeigen");
//	Button btAusschreiben = new Button("Ausschreibung anzeigen");
	Organisationseinheit o = new Organisationseinheit();

	Bewerbung bewerbung = new Bewerbung();

	/**
	 * Konstruktor
	 * @param p
	 */
	
	public MeineBewerbung (Bewerbung p) {
		this.bewerbung = p;
	}

	/**
	 * Die Methode onLoad() baut das Widget auf.
	 */
	
	public void onLoad() {

		super.onLoad();
		o.setEmail(Cookies.getCookie("email"));
		if(this.bewerbung!=null){

			taAnschreiben.setText(bewerbung.getInhalt());
			eDatum.setValue(bewerbung.getErstelldatum());

		}

//		btAusschreiben.addClickHandler(new AusschreibenClickHandler());
//		btAnzeigen.addClickHandler(new AnzeigenClickHandler());
		taAnschreiben.setEnabled(true);
//		btBearbeiten.addClickHandler(new SpeichernClickHandler(bewerbung));
		btLoeschen.addClickHandler(new DeleteClickHandler());
		vPanel2.add(lblDatum);
		vPanel2.add(eDatum);
		vPanel2.add(taAnschreiben);
		hPanel.add(vPanel2);
//		vPanel.add(btAusschreiben);
//		vPanel.add(btAnzeigen);
		vPanel.add(btLoeschen);
//		vPanel.add(btBearbeiten);
		hPanel.add(vPanel);
		this.clear();
		this.add(hPanel);

	}
	
	private class DeleteClickHandler implements ClickHandler {
		

		@Override
		public void onClick(ClickEvent event) {
			projektService.deleteBewerbung(bewerbung, new DeleteCallback());
		}
		
	}
	
//	private class SpeichernClickHandler implements ClickHandler {
//
//		Bewerbung be = new Bewerbung();
//		public SpeichernClickHandler(Bewerbung b) {
//			be = b;
//			be.setInhalt(taAnschreiben.getValue());
//		}
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			projektService.updateBewerbung(be, new SpeichernCallback());
//		}
//		
//	}
	
//	private class AusschreibenClickHandler implements ClickHandler {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			Window.alert("Ausschreibung: " + bewerbung.getAusschreibung().getId() + " " + bewerbung.getAusschreibung().getInhalt());
//		}
//		
//	}
//	
//	private class AnzeigenClickHandler implements ClickHandler {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
//	
//	private class SpeichernCallback implements AsyncCallback<Bewerbung>{
//
//		@Override
//		public void onFailure(Throwable caught) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onSuccess(Bewerbung result) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
	
	private class DeleteCallback implements AsyncCallback<Void>{

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
