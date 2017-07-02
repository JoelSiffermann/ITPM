package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

public class BewerbungAnzeigen extends VerticalPanel{
	
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	HorizontalPanel hp = new HorizontalPanel();
	VerticalPanel vpBe = new VerticalPanel();
	VerticalPanel vpBw = new VerticalPanel();
	VerticalPanel vpInfo = new VerticalPanel();
	VerticalPanel vpButton = new VerticalPanel();
	Label lbName = new Label("Name:");
	TextBox tbName = new TextBox();
	Label lbEmail = new Label("Email:");
	TextBox tbEmail = new TextBox();
	Label lbDatum = new Label("Datum:");
	TextBox tbDatum = new TextBox();
	Label lbInhalt = new Label("Inhalt:");
	TextArea taInhalt = new TextArea();
	Button btBwAnzeigen = new Button("Bewertung anzeigen");
	Button btBeAnlegen = new Button("Beteiligung anlegen");
	Bewerbung be = new Bewerbung();
	
	public BewerbungAnzeigen(Bewerbung b) {
		this.be = b;
	}
	
	public void onLoad(){
		super.onLoad();
		if(be!=null){
			tbName.setText(be.getBewerber().getName());
			tbEmail.setText(be.getBewerber().getEmail());
			tbDatum.setText(be.getErstelldatum() + "");
			taInhalt.setText(be.getInhalt());
		}
		vpInfo.add(lbName);
		vpInfo.add(tbName);
		vpInfo.add(lbEmail);
		vpInfo.add(tbEmail);
		vpInfo.add(lbDatum);
		vpInfo.add(tbDatum);
		vpInfo.add(lbInhalt);
		vpInfo.add(taInhalt);
		vpButton.add(btBwAnzeigen);
		btBwAnzeigen.addClickHandler(new BewertungClickHandler());
		vpButton.add(btBeAnlegen);
		vpBe.add(vpInfo);
		vpBe.add(vpButton);
		hp.add(vpBe);
		hp.add(vpBw);
		this.add(hp);
	}

	private class BewertungClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			BewertungForm ba = new BewertungForm(be);
			vpBw.clear();
			vpBw.add(ba);
		}
		
	}
}
