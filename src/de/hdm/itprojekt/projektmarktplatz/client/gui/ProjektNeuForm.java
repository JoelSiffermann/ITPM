package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;


import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class ProjektNeuForm extends VerticalPanel {
	
	/*
	 * Neues Design
	 */
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	
	
	VerticalPanel vpanel = new VerticalPanel();
	HorizontalPanel hpanel = new HorizontalPanel();
	Button ok = new Button("Sichern");
	Button abbrechen = new Button("Abbrechen");
	
	Label pmp = new Label ("Projektmarktplatz: ");
	
	
	Label projektbezeichnung = new Label ("Projektbezeichnung: ");
	TextArea bezeichnung = new TextArea();
	
	Label projektbeschreibung = new Label ("Projektbeschreibung: ");
	TextArea beschreibung = new TextArea();
	
	Label label_startdatum = new Label("Startdatum");
	
	Label label_enddatum = new Label("Enddatum");
	
	DateBox startdatum = new DateBox();
	
	DateBox enddatum = new DateBox();
	
	
	private Projekt proj = new Projekt();
	private FlexTable projektseite = new FlexTable();
	
	private Projektmarktplatz p1 = new Projektmarktplatz();
	private Person person;

	
	public ProjektNeuForm(final Projektmarktplatz sprojekt){
				
		Label lObjekt = new Label(sprojekt.getBezeichnung());
		
		
		this.setText("Projekt anlegen");
//		this.setAnimationEnabled(false);
//		this.setGlassEnabled(true);
//		this.setStylePrimaryName("dialogbox-projekt");
		
		ok.setStylePrimaryName("button");
		abbrechen.setStylePrimaryName("button");
		
		hpanel.add(ok);
		hpanel.add(abbrechen);
		
		// Create a date picker
		final DatePicker datepicker_startdatum = new DatePicker();
		
		
	    final DatePicker datepicker_enddatum = new DatePicker();
	    //   final Label text = new Label();
	 // Set the value in the text box when the user selects a date
	    datepicker_startdatum.addValueChangeHandler(new ValueChangeHandler<Date>() {

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM).format(new Date());
				}
		});
	    datepicker_startdatum.setValue(new Date(), true);
	    
	    
	    datepicker_enddatum.addValueChangeHandler(new ValueChangeHandler<Date>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM).format(new Date());
//				text.setText(dateString);
			}
		});
	 // Set the default value
	    datepicker_enddatum.setValue(new Date(), true);

	    
	    abbrechen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}

			private void hide() {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    // Anlegen der Funktion für den ClickHandel des Buttons "OK"
	     
	    ok.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				proj.setName(beschreibung.getText());
				proj.setName(bezeichnung.getText());
				proj.setStart(datepicker_startdatum.getValue());
				proj.setEnde(datepicker_enddatum.getValue());
				proj.setProjektmarktplatz(sprojekt);
				if (bezeichnung.getText().isEmpty()){
					Window.alert("Bitte geben Sie ein Projektenamen an");
				}if (beschreibung.getText().isEmpty()){
					Window.alert("Bitte geben Sie eine Projektbeschreibung an");
				}else{
					((ServiceDefTarget)projektService).setServiceEntryPoint("/ProjektmarktplatzProjekt/projektmarktplatz");
					 
					if (projektService == null) {
					 ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
					 }
						projektService.insertProjekt(proj, new addProjekteinDB());

					}
				
			}
		});
	    
	    
	    
//	    RootPanel.get().add(text);
//	    RootPanel.get().add(datePicker);
	    
	    DateTimeFormat dateformat = DateTimeFormat.getFormat("dd.MM.yyyy");
		startdatum.setFormat(new DateBox.DefaultFormat(dateformat));
		enddatum.setFormat(new DateBox.DefaultFormat(dateformat));
	
		projektseite.setWidget(1, 0, projektbezeichnung);
		projektseite.setWidget(1, 1, bezeichnung);
		projektseite.setWidget(2, 0, projektbeschreibung);
		projektseite.setWidget(2, 1, beschreibung);
		projektseite.setWidget(3, 0, label_startdatum);
		projektseite.setWidget(3, 1, startdatum);
		projektseite.setWidget(4, 0, label_enddatum);
		projektseite.setWidget(4, 1, enddatum);
		projektseite.setWidget(5, 0, pmp);
		projektseite.setWidget(5, 1, lObjekt);
		vpanel.add(projektseite);
		vpanel.add(hpanel);
		this.add(vpanel);
	
	}	
	
	private void setText(String string) {
		// TODO Auto-generated method stub

	}

	private class addProjekteinDB implements AsyncCallback<Projekt>{

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fehler beim Laden der Daten in die Datenbank");
		}

		@Override
		public void onSuccess(Projekt result) {

//			Window.alert("Projekt wurde in die Datenbank eingetragen");
//        	RootPanel.get("main").clear();
//			RootPanel.get("main").add(showcase);
		}
	}
	
	private class GetPersonCallback implements AsyncCallback<Person>{

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Die Person wurde nicht gefunden");
			
		}

		@Override
		public void onSuccess(Person result) {
			if (result != null){
				((ServiceDefTarget)projektService).setServiceEntryPoint("/IT_Projekt_SS17/projektmarktplatz");
				 
				if (projektService == null) {
				 ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
				 }
				
				Projekt p = new Projekt ();
				
				p.setStart(startdatum.getValue());
				p.setEnde(enddatum.getValue());
				p.setName(bezeichnung.getText());
				p.setInhalt(beschreibung.getText());  
				p.setId(result.getId());
				
				 projektService.insertProjekt(  p, new addProjekteinDB());
			}
			
		}
		
	} 
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
//	HorizontalPanel hpProjektForm = new HorizontalPanel();
//	VerticalPanel vpProjektForm1 = new VerticalPanel();
//	VerticalPanel vpProjektForm2 = new VerticalPanel();
//	HorizontalPanel hpButton = new HorizontalPanel();
//	TextArea taProjektInhalt = new TextArea();
//	TextBox tbProjektName = new TextBox();
//	DatePicker startPicker = new DatePicker();
//	DatePicker endPicker = new DatePicker();
//	
//	Projekt projekt = new Projekt();
//	
//	public ProjektNeuForm (Projekt p) {
//		this.projekt = p;
//	}
//	
//	public void onLoad() {
//
//		super.onLoad();
//		
//		Label lblStart = new Label("Start:");
//		Label lblEnde = new Label("Ende:");
//		
//		Button btSpeichern = new Button("Projekt speichern");
//		Button btAbbrechen = new Button("Abbrechen");
//		
//		
//		tbProjektName.getElement().setPropertyString("placeholder", "Projektname");
//
//		taProjektInhalt.setWidth("300px");
//		taProjektInhalt.setHeight("300px");
//		taProjektInhalt.getElement().setPropertyString("placeholder", "Projektbezeichnung");
//		
//		// Set the value in the text box when the user selects a date
//		startPicker.addValueChangeHandler(new DateValuePicker());
//
//		// Set the default value
//		startPicker.setValue(new Date(), true);
//
//		// Set the value in the text box when the user selects a date
//		endPicker.addValueChangeHandler(new DateValuePicker());
//
//		endPicker.setValue(new Date(), true);
//		
//		btSpeichern.addClickHandler(new SpeichernClickHandler());
//
//		btAbbrechen.addClickHandler(new AbbrechenClickHandler());
//		
////		tbProjektName.setVisible(false);
////		lbProjektListe.setVisible(true);
//
////		gridProjektForm1.setWidget(0, 0, lblProjektName);
////		gridProjektForm1.setWidget(0, 1, tbProjektName);
////		gridProjektForm1.setWidget(1, 0, lblInhalt);
////		gridProjektForm1.setWidget(1, 1, taInhalt);
//
//		
//		vpProjektForm1.add(tbProjektName);
//		vpProjektForm1.add(taProjektInhalt);
//		
////		gridProjektForm2.setWidget(0, 0, lblStart);
////		gridProjektForm2.setWidget(0, 1, startPicker);
////		gridProjektForm2.setWidget(1, 0, lblEnde);
////		gridProjektForm2.setWidget(1, 1, endPicker);
////	
//		vpProjektForm2.add(lblStart);
//		vpProjektForm2.add(startPicker);
//		vpProjektForm2.add(lblEnde);
//		vpProjektForm2.add(endPicker);
//		
//		hpButton.add(btSpeichern);
//		hpButton.add(btAbbrechen);
//
//		hpProjektForm.add(vpProjektForm1);
//		hpProjektForm.add(vpProjektForm2);
//		
//		this.clear();
//		this.add(hpProjektForm);
//		this.add(hpButton);
//		
//	} 
//	
//	private class DateValuePicker implements ValueChangeHandler<Date> {
//
//		@Override
//		public void onValueChange(ValueChangeEvent<Date> event) {
//			// TODO Auto-generated method stub
//			Date date = event.getValue();
//			String dateString = DateTimeFormat.getMediumDateFormat().format(date);
//		}
//		
//	}
//	
//	private class SpeichernClickHandler implements ClickHandler {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			// TODO Auto-generated method stub
//			Projekt p = new Projekt();
//			p.setName(tbProjektName.getText());
//			p.setStart(startPicker.getValue());
//			p.setEnde(endPicker.getValue());
//			p.setInhalt(taProjektInhalt.getText());
//			projektService.updateProjekt(p, new ProjektSpeichernCallback(p));
//		}
//	}
//
//	private class ProjektSpeichernCallback implements AsyncCallback<Projekt> {
//		Projekt p = null;
//		ProjektSpeichernCallback(Projekt projekt){
//			p = projekt;
//		}
//		@Override
//		public void onFailure(Throwable caught) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void onSuccess(Projekt result) {
//			// TODO Projekt panel aktualisieren
//		}
//		
//	}
//	
//	private class AbbrechenClickHandler implements ClickHandler {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			// TODO Auto-generated method stub
//			hpProjektForm.clear();
//		}
//		
//	}
//	
//}
//
//
