package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

public class BewertungForm extends VerticalPanel{
	
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	VerticalPanel vp = new VerticalPanel();
	HorizontalPanel hpButton = new HorizontalPanel();
	Label lblBewertungSkala = new Label("Bewertung: ");
	Label lblBegruendung = new Label("Begruendung: ");
	TextArea taBewertungInhalt = new TextArea();
	TextBox tbSkalaWert = new TextBox();
	Button btSpeichern = new Button("Speichern");
	Button btAnlegen = new Button("Anlegen");
	Button btAbbrechen = new Button("Abbrechen");
	Bewerbung be = new Bewerbung();
	Bewertung bt = new Bewertung();
	Organisationseinheit o = new Organisationseinheit();
	
	public BewertungForm(Bewerbung b) {
		this.be = b;
		o.setId(b.getBewerber().getId());
		o.setName(b.getBewerber().getName());
		o.setEmail(b.getBewerber().getEmail());
		o.setPartnerprofil(b.getBewerber().getPartnerprofil());
	}
	
	public void onLoad(){
		super.onLoad();
		getBewertung();
		taBewertungInhalt.setWidth("300px");
		taBewertungInhalt.setHeight("300px");
		this.clear();
		vp.clear();
		vp.add(lblBegruendung);
		vp.add(taBewertungInhalt);
		vp.add(lblBewertungSkala);
		vp.add(tbSkalaWert);
		this.add(vp);
		this.add(hpButton);
	}

	private void getBewertung() {
		projektService.getBewertungByBewerber(o, new BewertungCallback());
	}

	private class BewertungCallback implements AsyncCallback<Bewertung> {
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Bewertung result) {
			bt = result;
			if(result != null){
				taBewertungInhalt.setText(result.getInhalt());
				tbSkalaWert.setText(result.getSkala() + "");
				hpButton.clear();
				hpButton.add(btSpeichern);
				btSpeichern.addClickHandler(new SpeichernClickHandler(result));
				hpButton.add(btAbbrechen);
			} else {
				hpButton.clear();
				hpButton.add(btAnlegen);
				btAnlegen.addClickHandler(new AnlegenClickHandler(result));
				hpButton.add(btAbbrechen);
			}
		}
		private class SpeichernClickHandler implements ClickHandler{

			Bewertung bt = new Bewertung();
			public SpeichernClickHandler(Bewertung b) {
				bt.setId(b.getId());
				bt.setInhalt(taBewertungInhalt.getText());
				bt.setSkala(Float.parseFloat(tbSkalaWert.getText()));
				bt.setPerson(b.getPerson());
			}
			
			@Override
			public void onClick(ClickEvent event) {
				projektService.updateBewertung(bt, new SpeichernCallback());
			}
			
		}
		private class AnlegenClickHandler implements ClickHandler {
			
			Bewertung bt = new Bewertung();
			public AnlegenClickHandler(Bewertung b) {
				this.bt = b;
				bt.setInhalt(taBewertungInhalt.getText());
				bt.setSkala(Float.parseFloat(tbSkalaWert.getText()));
				bt.setPerson(b.getPerson());
			}

			@Override
			public void onClick(ClickEvent event) {
				projektService.insertBewertung(bt, new AnlegenCallback());
			}
			
		}
		
	}
	
//	private class SpeichernClickHandler implements ClickHandler{
//
//		Bewertung bt = new Bewertung();
//		public SpeichernClickHandler(Bewertung b) {
//			bt.setId(b.getId());
//			bt.setInhalt(taBewertungInhalt.getText());
//			bt.setSkala(Float.parseFloat(tbSkalaWert.getText()));
//			bt.setPerson(b.getPerson());
//		}
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			projektService.updateBewertung(bt, new SpeichernCallback());
//		}
//		
//	}
	
	private class SpeichernCallback implements AsyncCallback<Bewertung>{

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(Bewertung result) {
			Window.alert("Gespeichert.");
		}
		
	}
	
//	private class AnlegenClickHandler implements ClickHandler {
//		
//		Bewertung bt = new Bewertung();
//		public AnlegenClickHandler(Bewertung b) {
//			this.bt = b;
//			bt.setInhalt(taBewertungInhalt.getText());
//			bt.setSkala(Float.parseFloat(tbSkalaWert.getText()));
//			bt.setPerson(b.getPerson());
//		}
//
//		@Override
//		public void onClick(ClickEvent event) {
//			projektService.insertBewertung(bt, new AnlegenCallback());
//		}
//		
//	}
	
	private class AnlegenCallback implements AsyncCallback<Bewertung> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Ein Fehler ist aufgetreten.");
		}

		@Override
		public void onSuccess(Bewertung result) {
			Window.alert("Gespeichert.");
		}
		
	}
}
