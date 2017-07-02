package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

/**
 * Klasse zur Darstellung von neuen Projekt-Objekten 
 * 
 * @author Vi Quan, Joey Siffermann
 *
 */

public class ProjektNeuForm extends VerticalPanel {
	
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

	/**
	 * Konstruktor
	 * @param sprojekt Projektmarktplatz
	 */
	
	public ProjektNeuForm(final Projektmarktplatz sprojekt){
				
		Label lObjekt = new Label(sprojekt.getBezeichnung());
		
		
		this.setText("Projekt anlegen");
		
		ok.setStylePrimaryName("button");
		abbrechen.setStylePrimaryName("button");
		
		hpanel.add(ok);
		hpanel.add(abbrechen);
		
		// Create a date picker
		final DatePicker datepicker_startdatum = new DatePicker();
		
		
	    final DatePicker datepicker_enddatum = new DatePicker();
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

	/**
	 * Die innere Klasse addProjekteinDB ruft das Objekt Projekt auf.
 	 * Implementiert das AysncCallback Interface.
	 *
	 */
	
	private class addProjekteinDB implements AsyncCallback<Projekt>{

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fehler beim Laden der Daten in die Datenbank");
		}

		@Override
		public void onSuccess(Projekt result) {

		}
	}
	
	/**
	 * Die innere Klasse GetPersonCallback ruft das Objekt Person auf.
 	 * Implementiert das AysncCallback Interface.
	 *
	 */
	
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
	
