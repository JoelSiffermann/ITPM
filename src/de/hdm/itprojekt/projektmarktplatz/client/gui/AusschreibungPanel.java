package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class AusschreibungPanel extends VerticalPanel {
	
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	final ListBox listBoxBezeichnung = new ListBox();

	public AusschreibungPanel() {

	}

	public VerticalPanel getAusschreibungBewerben() {

		final VerticalPanel vpBewerben = new VerticalPanel();
		final TextArea taInhalt = new TextArea();
		final TextArea taBewerbungInhalt = new TextArea();
		final DatePicker frist = new DatePicker();
		final Grid gridAusschreibungAnzeigen = new Grid(8, 2);
		final Button btAusschreibungBewerben = new Button("Auf Ausschreibung bewerben");

		listBoxBezeichnung.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				Ausschreibung a = new Ausschreibung();
				int id = Integer.parseInt(listBoxBezeichnung.getSelectedValue());
				a.setId(id);
				projektService.readByIdAusschreibung(a, new AsyncCallback<Ausschreibung>() {

					@Override
					public void onFailure(Throwable caught) {

					}

					@Override
					public void onSuccess(Ausschreibung result) {
					
						taInhalt.setText(result.getInhalt());
						frist.setValue(result.getFrist());

					}
				});

			}
		});

		btAusschreibungBewerben.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Window.alert("clickhandler");

				BewerbungForm bewerbenAnzeigenForm = new BewerbungForm();
				vpBewerben.clear();
				vpBewerben.add(bewerbenAnzeigenForm.getAufProjektBewerben());
			}
		});

		projektService.readAllAusschreibung(new AsyncCallback<ArrayList<Ausschreibung>>() {

			@Override
			public void onSuccess(ArrayList<Ausschreibung> result) {

				for (Ausschreibung a : result) {
					// listBoxBezeichnung.addItem(a.getBezeichnung());
					listBoxBezeichnung.addItem(a.getBezeichnung(), a.getId() + "");

				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});

		taInhalt.setWidth("1000px");
		taInhalt.setHeight("300px");
		taInhalt.setEnabled(false);

		// add text to text area
		taInhalt.setText("");
		taInhalt.getElement().setPropertyString("placeholder", "Ausschreibungstext");

		taBewerbungInhalt.setWidth("1000px");
		taBewerbungInhalt.setHeight("300px");

		// add text to text area
		taBewerbungInhalt.setText("");
		taBewerbungInhalt.getElement().setPropertyString("placeholder", "Bewerbungstext");

		gridAusschreibungAnzeigen.setWidget(0, 0, new Label("Bezeichnung"));
		gridAusschreibungAnzeigen.setWidget(0, 1, listBoxBezeichnung);
		gridAusschreibungAnzeigen.setWidget(1, 0, new Label("Inhalt"));
		gridAusschreibungAnzeigen.setWidget(1, 1, taInhalt);
		gridAusschreibungAnzeigen.setWidget(2, 0, new Label("Frist"));
		gridAusschreibungAnzeigen.setWidget(2, 1, frist);
		gridAusschreibungAnzeigen.setWidget(5, 0, btAusschreibungBewerben);

		this.add(gridAusschreibungAnzeigen);
		// **************************************
		this.add(vpBewerben);
		return this;
	}

	public VerticalPanel getAusschreibungAnlegen() {
		// muss hier dynamisch sein Ausschreibung

		final FlexTable ftKenntnis = new FlexTable();
		final Grid gridAusschreibungAnlegen = new Grid(7, 2);

		final Button btAdd = new Button("+");
		final Button btAusschreibungSpeichern = new Button("Ausschreibung speichern");
		final Button btAusschreibungEntfernen = new Button("Ausschreibung entfernen");
		final TextBox tbKenntnis = new TextBox();
		final TextBox tbJahr = new TextBox();
		final TextBox tbBeruf = new TextBox();

		final TextBox tbBezeichnung = new TextBox();
		final TextArea taInhalt = new TextArea();
		DatePicker dpFrist = new DatePicker();

		taInhalt.setWidth("1000px");
		taInhalt.setHeight("300px");

		// add text to text area
		taInhalt.setText("");
		taInhalt.getElement().setPropertyString("placeholder", "Ausschreibungstext");

		gridAusschreibungAnlegen.setWidget(0, 0, new Label("Bezeichnung"));
		gridAusschreibungAnlegen.setWidget(0, 1, tbBezeichnung);
		gridAusschreibungAnlegen.setWidget(1, 0, new Label("Inhalt"));
		gridAusschreibungAnlegen.setWidget(1, 1, taInhalt);
		gridAusschreibungAnlegen.setWidget(2, 0, new Label("Frist"));
		gridAusschreibungAnlegen.setWidget(2, 1, dpFrist);
		gridAusschreibungAnlegen.setWidget(3, 0, btAusschreibungSpeichern);
		gridAusschreibungAnlegen.setWidget(3, 1, btAusschreibungEntfernen);
		gridAusschreibungAnlegen.setWidget(4, 0, new Label("Beruf: "));
		gridAusschreibungAnlegen.setWidget(4, 1, tbBeruf);
		this.add(gridAusschreibungAnlegen);
		// *******************************************

		tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
		tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");

		// grid.setWidget(4, 0, tbKenntnis);
		// grid.setWidget(4, 1, tbJahr);
		ftKenntnis.setWidget(0, 0, tbKenntnis);
		ftKenntnis.setWidget(0, 1, tbJahr);

		this.add(ftKenntnis);
		this.add(btAdd);

		btAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				TextBox tbKenntnis = new TextBox();
				TextBox tbJahr = new TextBox();
				int zeile = ftKenntnis.getRowCount() + 1;

				tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
				tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");
				ftKenntnis.setWidget(zeile, 0, tbKenntnis);
				ftKenntnis.setWidget(zeile, 1, tbJahr);
				// ftKenntnis.setText(zeile, 2, "Jahr");

				// vthis.add(ftKenntnis);
			}
		});

		return this;
	}

	public VerticalPanel getAusschreibungAnzeigen() {
		// muss hier dynamisch sein Ausschreibung
		final VerticalPanel vpBewerben = new VerticalPanel();
		final ListBox listBoxBezeichnung = new ListBox();
		final TextArea taInhalt = new TextArea();
		final TextArea taBewerbungInhalt = new TextArea();
		final DatePicker frist = new DatePicker();
		final Grid gridAusschreibungAnzeigen = new Grid(8, 2);
		Button btMeineProjekteBewerbungAnzeigen = new Button("Bewerbungen anzeigen");
		Button btAusschreibungSpeichern = new Button("Ausschreibung speichern");
		TextBox tbKenntnis = new TextBox();
		TextBox tbJahr = new TextBox();


		listBoxBezeichnung.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub
				Ausschreibung a = new Ausschreibung();
				int id = Integer.parseInt(listBoxBezeichnung.getSelectedValue());
				a.setId(id);
				projektService.readByIdAusschreibung(a, new AsyncCallback<Ausschreibung>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(Ausschreibung result) {
						// TODO Auto-generated method stub
						// Window.alert("geändert " +
						// listBoxBezeichnung.getSelectedValue());
						taInhalt.setText(result.getInhalt());
						frist.setValue(result.getFrist());

					}
				});

			}
		});


		btMeineProjekteBewerbungAnzeigen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Window.alert("clickhandler");

				BewerbungForm bewerbenAnzeigenForm = new BewerbungForm();
				vpBewerben.clear();
				vpBewerben.add(bewerbenAnzeigenForm.getMeineProjekteBewerbungAnzeigen(listBoxBezeichnung.getSelectedValue()));
			}
		});


		btAusschreibungSpeichern.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Ausschreibung a = new Ausschreibung();
				Projekt p = new Projekt();
				Partnerprofil pp = new Partnerprofil();

				int id = Integer.parseInt(listBoxBezeichnung.getSelectedValue());

				a.setId(id);
				a.setBezeichnung(listBoxBezeichnung.getSelectedItemText());
				a.setInhalt(taInhalt.getText());
				a.setFrist(frist.getValue());
				p.setId(1);
				pp.setId(1);

				a.setProjekt(p);
				a.setPartnerprofil(pp);

				projektService.updateAusschreibung(a, new AsyncCallback<Ausschreibung>() {

					@Override
					public void onFailure(Throwable caught) {
						
						Window.alert("Ein Fehler ist aufgetreten: " + caught.getMessage());
					}

					@Override
					public void onSuccess(Ausschreibung result) {
						
						Window.alert("Ausschreibung gespeichert ");
					}
				});

			}
		});

		projektService.readAllAusschreibung(new AsyncCallback<ArrayList<Ausschreibung>>() {

			@Override
			public void onSuccess(ArrayList<Ausschreibung> result) {

				for (Ausschreibung a : result) {
					
					listBoxBezeichnung.addItem(a.getBezeichnung(), a.getId() + "");

				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});

		taInhalt.setWidth("1000px");
		taInhalt.setHeight("300px");

		// add text to text area
		taInhalt.setText("");
		taInhalt.getElement().setPropertyString("placeholder", "Ausschreibungstext");

		taBewerbungInhalt.setWidth("1000px");
		taBewerbungInhalt.setHeight("300px");

		// add text to text area
		taBewerbungInhalt.setText("");
		taBewerbungInhalt.getElement().setPropertyString("placeholder", "Bewerbungstext");

		gridAusschreibungAnzeigen.setWidget(0, 0, new Label("Bezeichnung"));
		gridAusschreibungAnzeigen.setWidget(0, 1, listBoxBezeichnung);
		gridAusschreibungAnzeigen.setWidget(1, 0, new Label("Inhalt"));
		gridAusschreibungAnzeigen.setWidget(1, 1, taInhalt);
		gridAusschreibungAnzeigen.setWidget(2, 0, new Label("Frist"));
		gridAusschreibungAnzeigen.setWidget(2, 1, frist);
		gridAusschreibungAnzeigen.setWidget(5, 0, btMeineProjekteBewerbungAnzeigen);
		gridAusschreibungAnzeigen.setWidget(5, 1, btAusschreibungSpeichern);

		this.add(gridAusschreibungAnzeigen);
		// *******************************************

		tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
		tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");

		this.add(vpBewerben);
		return this;
	}

	protected void clear(VerticalPanel vpBewerben) {
		// TODO Auto-generated method stub

	}

	public void clear(Panel p) {
		// Window.alert("clickhandler clear");
		p.clear();
	}
	public void addBewerbungForm(Panel p) {
		this.add(p);
	}
}
