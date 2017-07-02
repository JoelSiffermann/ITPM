package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
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

	/**
	 * GUI-Elemente & globale Variablen/ Objekte anlegen
	 */

	FlexTable ft_projektErstellen = new FlexTable();
	Button btn_ok = new Button("OK");
	Button btn_abbrechen = new Button("Abbrechen");

	Label lbl_projektname = new Label("Projektname: ");
	TextBox txt_projektname = new TextBox();
	Label lbl_beschreibung = new Label("Beschreibung: ");
	TextArea txta_beschreibung = new TextArea();
	Label lbl_startdatum = new Label("Startdatum: ");
	DateBox db_startdatum = new DateBox();
	Label lbl_enddatum = new Label("Enddatum: ");
	DateBox db_enddatum = new DateBox();
	DatePicker datepicker = new DatePicker();
	VerticalPanel hp = new VerticalPanel();
	ListBox dropBox = new ListBox();

	// private Navigation navigation=null;

	/**
	 * Konstruktor
	 */
	
	public ProjektNeuForm() {

		this.setText("Projekt anlegen...");
		btn_ok.setStylePrimaryName("cell-btn");
		btn_abbrechen.setStylePrimaryName("cell-btn");
		hp.add(btn_ok);
		hp.add(btn_abbrechen);

		btn_ok.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (db_enddatum.getValue().before(db_startdatum.getValue())) {
					Window.alert("Das Enddatum muss nach dem Startdatum erfolgen.");
				} else if (txt_projektname.getText().isEmpty()) {
					Window.alert("Bitte geben Sie einen Projektnamen für Ihr Projekt ein.");
				} else if (txta_beschreibung.getText().isEmpty()) {
					Window.alert("Bitte geben Sie eine Beschreibung für Ihr Projekt ein.");
				} else {
					Window.alert("Daten speichern");
					Organisationseinheit o = new Organisationseinheit();
					Projektmarktplatz pm = new Projektmarktplatz();
					Projekt proj = new Projekt();
					Person p = new Person();
					proj.setStart(db_startdatum.getValue());
					proj.setEnde(db_enddatum.getValue());
					proj.setInhalt(txta_beschreibung.getText());
					proj.setName(txt_projektname.getText());

					o.setId(Integer.parseInt(Cookies.getCookie("userid")));
					o.setEmail(Cookies.getCookie("email"));
					Window.alert(o.getId() + " " + o.getEmail());
					proj.setProjektleiter(o);

					Window.alert(dropBox.getSelectedValue());
					Window.alert(dropBox.getSelectedItemText());

					pm.setId(Integer.parseInt(dropBox.getSelectedValue()));
					pm.setBezeichnung(dropBox.getSelectedItemText());

					p.setId(o.getId());

					proj.setPerson(p);
					// Window.alert(pm.getId() + " " + pm.getBezeichnung());

					proj.setProjektmarktplatz(pm);

					projektService.insertProjekt(proj, new SetProjekt());

					Window.alert("Gespeichert");

				}

			}
		});

		btn_abbrechen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();

			}
		});

		projektService.readAllProjektmarktplatz(new ReadAllPMAsnc());
		dropBox.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub

			}
		});

		hp.add(lbl_beschreibung);
		hp.add(txta_beschreibung);

		hp.add(lbl_startdatum);
		hp.add(db_startdatum);
		hp.add(lbl_enddatum);
		hp.add(db_enddatum);

		hp.add(lbl_projektname);
		hp.add(txt_projektname);

		hp.add(dropBox);

		this.add(hp);

	}

	/**
	 * Die innere Klasse ReadAllPMAsnc ruft die Array-Liste Projektmarktplatz auf.
	 * Implementiert das AysncCallback Interface.
	 *
	 */
	
	class ReadAllPMAsnc implements AsyncCallback<ArrayList<Projektmarktplatz>> {
		ListBox lb;

		public ReadAllPMAsnc() {
			// TODO Auto-generated constructor stub
		}

		public ReadAllPMAsnc(ListBox lb) {
			// TODO Auto-generated constructor stub
			this.lb = lb;
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSuccess(ArrayList<Projektmarktplatz> result) {
			// TODO Auto-generated method stub
			for (Projektmarktplatz pm : result) {
				// Window.alert("Projektmarpltz " + pm.getBezeichnung() + " " +
				// pm.getId());
				// this.lb.addItem(pm.getId()+"", pm.getBezeichnung());
				dropBox.addItem(pm.getBezeichnung(), pm.getId() + "");

			}
		}

	}

	private void setText(String string) {
		// TODO Auto-generated method stub

	}

	private class SetProjekt implements AsyncCallback<Projekt> {
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Projekt konnte nicht angelegt werden");

		}

		@Override
		public void onSuccess(Projekt result) {
			Window.alert("Projekt wurde erfolgreich angelegt");
			RootPanel.get("Details").clear();
		}

	}
}
