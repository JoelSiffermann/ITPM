package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Date;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Eigenschaft;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

public class AndereAusschreibungenAnzeigen extends HorizontalPanel {

	/*
	 * Neues Design
	 */
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	VerticalPanel vpAusschreibungAnzeigenForm1 = new VerticalPanel();
	VerticalPanel vpAusschreibungAnzeigenForm2 = new VerticalPanel();
	HorizontalPanel hpAusschreibungAnzeigenForm = new HorizontalPanel();

	TextBox tbPartnerProfilBeschreibung = new TextBox();
	TextBox tbPartnerProfilWert = new TextBox();
	DatePicker dpFrist = new DatePicker();
	TextArea taAusschreibungInhalt = new TextArea();
	Label lblAusschreibungName = new Label("Ausschreibungbezeichnung");
	Label lblAusschreibungInhalt = new Label("Ausschreibungsbeschreibung:");
	Label lblFrist = new Label("Frist:");
	Label lblGesucht = new Label("Gesucht:");
	Label lblPartnerProfilBeschreibung = new Label("Beschreibung:");
	Label lblPartnerProfilWert = new Label("Wert:");

	Button btBewerbung = new Button("Sich Bewerben");
	TextCell textCell = new TextCell();

	Ausschreibung ausschreibung;
	Partnerprofil partnerprofil;
	Eigenschaft eigenschaft;
	Bewerbung bewerbung;
	
	public AndereAusschreibungenAnzeigen(Ausschreibung a) {
		this.ausschreibung = a;
	}

	public void onLoad() {

		super.onLoad();

		taAusschreibungInhalt.setWidth("300px");
		taAusschreibungInhalt.setHeight("300px");
		taAusschreibungInhalt.setEnabled(false);
		
		if(this.ausschreibung!=null){
			lblAusschreibungName.setText(ausschreibung.getBezeichnung());
			taAusschreibungInhalt.setText(ausschreibung.getInhalt());
			taAusschreibungInhalt.setValue(ausschreibung.getInhalt());
//			lblPartnerProfilBeschreibung.setText(partnerprofil.getAusschreibung().toString());
//			lblPartnerProfilBeschreibung.setText(eigenschaft.getPartnerprofil().toString());

		}
		
		dpFrist.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		dpFrist.setValue(ausschreibung.getFrist(), true);

		btBewerbung.addClickHandler(new SichBewerbenClickHandler());

		vpAusschreibungAnzeigenForm1.add(lblAusschreibungName);
		vpAusschreibungAnzeigenForm1.add(lblAusschreibungInhalt);
		vpAusschreibungAnzeigenForm1.add(taAusschreibungInhalt);
		vpAusschreibungAnzeigenForm1.add(lblFrist);
		vpAusschreibungAnzeigenForm1.add(dpFrist);
		vpAusschreibungAnzeigenForm1.add(lblGesucht);
		vpAusschreibungAnzeigenForm1.add(lblPartnerProfilBeschreibung);
		vpAusschreibungAnzeigenForm1.add(tbPartnerProfilBeschreibung);
		vpAusschreibungAnzeigenForm1.add(lblPartnerProfilWert);
		vpAusschreibungAnzeigenForm1.add(tbPartnerProfilWert);

		vpAusschreibungAnzeigenForm2.add(btBewerbung);

		hpAusschreibungAnzeigenForm.add(vpAusschreibungAnzeigenForm1);
		hpAusschreibungAnzeigenForm.add(vpAusschreibungAnzeigenForm2);

		this.clear();
		this.add(hpAusschreibungAnzeigenForm);

	};

	private class SichBewerbenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			BewerbungNeuForm bnf = new BewerbungNeuForm(null);
			vpAusschreibungAnzeigenForm2.clear();
			vpAusschreibungAnzeigenForm2.add(bnf);
		}

	}

}
