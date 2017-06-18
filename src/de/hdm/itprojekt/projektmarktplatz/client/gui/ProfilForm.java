package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Eigenschaft;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Team;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Unternehmen;

public class ProfilForm extends VerticalPanel {

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public ProfilForm() {

		/**
		 * <p>
		 * Kopf für Name und Organisationseinheit
		 * </p>
		 * 
		 */

		final VerticalPanel vpKopf = new VerticalPanel();
		final TextBox tbName = new TextBox();
		final TextBox tbVorname = new TextBox();
		final TextBox tbBeruf = new TextBox();
		final ListBox listOrg = new ListBox();
		final Label lbKenntnisse = new Label("Kenntnisse");
		final TextBox tbGroesse = new TextBox();
		final TextBox tbArbeitsfeld = new TextBox();
		final TextBox tbGeschform = new TextBox();
		final TextBox tbGeschfeld = new TextBox();

		final ArrayList<Eigenschaft> eig = new ArrayList<Eigenschaft>();

		listOrg.addItem("Person");
		listOrg.addItem("Team");
		listOrg.addItem("Unternehmen");

		tbName.getElement().setPropertyString("placeholder", "Name");
		tbVorname.getElement().setPropertyString("placeholder", "Vorname");
		tbBeruf.getElement().setPropertyString("placeholder", "Beruf");

		tbGroesse.getElement().setPropertyString("placeholder", "Groesse");
		tbGroesse.setVisible(false);

		tbArbeitsfeld.getElement().setPropertyString("placeholder", "Arbeitsfeld");
		tbArbeitsfeld.setVisible(false);

		tbGeschform.getElement().setPropertyString("placeholder", "Geschaeftsform");
		tbGeschform.setVisible(false);

		tbGeschfeld.getElement().setPropertyString("placeholder", "Geschaeftsfeld");
		tbGeschfeld.setVisible(false);

		vpKopf.add(listOrg);
		vpKopf.add(tbName);
		vpKopf.add(tbVorname);

		vpKopf.add(tbGroesse);
		vpKopf.add(tbArbeitsfeld);

		vpKopf.add(tbGeschform);
		vpKopf.add(tbGeschfeld);

		vpKopf.add(tbBeruf);

		// **********************************************

		/*
		 * <p>Kenntnisse Bereich </p>
		 */
		// Merke: bei dynamisch auslagern
		final VerticalPanel kBereich = new VerticalPanel();
		final FlexTable ftKenntnis = new FlexTable();
		final FlexTable ftKenntnisListe = new FlexTable();
		final TextBox tbKenntnis = new TextBox();
		final TextBox tbJahr = new TextBox();

		tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
		tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");
		ftKenntnis.setWidget(0, 0, tbKenntnis);
		ftKenntnis.setWidget(0, 1, tbJahr);
		ftKenntnis.setText(0, 2, "Jahr");

		kBereich.add(ftKenntnis);

		ftKenntnisListe.setWidget(0, 0, new Label("Kenntnisse"));
		ftKenntnisListe.setWidget(0, 1, new Label("Jahre"));
		ftKenntnisListe.setWidget(0, 2, new Label("ID"));
		// **********************************************
		VerticalPanel vpUnten = new VerticalPanel();

		Button btSpeichern = new Button("Speichern");

//		Button btAdd = new Button("+");
//		btAdd.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				TextBox tbKenntnis = new TextBox();
//				TextBox tbJahr = new TextBox();
//				int zeile = ftKenntnis.getRowCount() + 1;
//
//
//				ftKenntnis.setWidget(zeile, 0, tbKenntnis);
//				ftKenntnis.setWidget(zeile, 1, tbJahr);
//				ftKenntnis.setText(zeile, 2, "Jahr");
//
//				kBereich.add(ftKenntnis);
//			}
//		});

		listOrg.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub

				switch (listOrg.getSelectedItemText()) {

				case "Person":
					tbVorname.setVisible(true);
					tbGroesse.setVisible(false);
					tbArbeitsfeld.setVisible(false);
					tbBeruf.setVisible(true);
					tbGeschform.setVisible(false);
					tbGeschfeld.setVisible(false);

					break;

				case "Team":
					tbVorname.setVisible(false);
					tbGroesse.setVisible(true);
					tbBeruf.setVisible(false);
					tbArbeitsfeld.setVisible(true);
					tbGeschform.setVisible(false);
					tbGeschfeld.setVisible(false);
					tbKenntnis.getElement().setPropertyString("placeholder", "Spezifikation");
					break;

				case "Unternehmen":
					tbVorname.setVisible(false);
					tbGroesse.setVisible(false);
					tbArbeitsfeld.setVisible(false);
					tbBeruf.setVisible(false);
					tbGeschform.setVisible(true);
					tbGeschfeld.setVisible(true);
					tbKenntnis.getElement().setPropertyString("placeholder", "Spezialisierung");
					break;

				default:
					break;
				}
			}
		});

		btSpeichern.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int ppid = Integer.parseInt(Cookies.getCookie("partnerprofilid"));
				Organisationseinheit o = new Organisationseinheit();
				Partnerprofil pp = new Partnerprofil();
				pp.setId(ppid);
				// o.setId(2);
				o.setName(tbName.getText());
				// p.setId(id);
				o.setPartnerprofil(pp);
				o.setEmail(Cookies.getCookie("email"));
				Person person = null;
				Team team = null;
				Unternehmen unternehmen = null;
				Eigenschaft ei = new Eigenschaft();

//				 final DialogBox dialogBox = new DialogBox();
//				// TextBox ttb = (TextBox) ftKenntnis.getWidget(0, 0);
//				// TextBox ttb2 = (TextBox) ftKenntnis.getWidget(0, 1);
//				 dialogBox.setText("Anzahl " + ftKenntnis.getRowCount());
//				 Button closeButton = new Button("OK", new ClickHandler() {
//				
//				 @Override
//				 public void onClick(ClickEvent event) {
//				 // TODO Auto-generated method stub
//				 dialogBox.hide();
//				 }
//				 });
//				
//				 dialogBox.add(closeButton);
//				 dialogBox.show();
				
					 
					
					 ei.setBezeichnung(tbKenntnis.getText());
					 ei.setWert(tbJahr.getText());
					 ei.setPartnerprofil(pp);
					
					 eig.add(ei);

				switch (listOrg.getSelectedItemText()) {
				case "Person":

					person = new Person();
					person.setBeruf(tbBeruf.getText());
					person.setVorname(tbVorname.getText());
					person.setErfahrung(Float.parseFloat(tbJahr.getText()));
					person.setOrganisationseinheit(o);

					team = null;
					unternehmen = null;
					break;

				case "Team":

					team = new Team();
					team.setArbeitsfeld(tbArbeitsfeld.getText());
					team.setGroesse(Integer.parseInt(tbGroesse.getText()));
					team.setOrganisationseinheit(o);
					person = null;
					unternehmen = null;
					break;

				case "Unternehmen":

					unternehmen = new Unternehmen();
					unternehmen.setGeschaeftsform(tbGeschform.getText());
					unternehmen.setGeschaeftsfeld(tbGeschfeld.getText());
					unternehmen.setOrganisationseinheit(o);
					person = null;
					team = null;
					break;
				default:
					break;
				}

				if (!person.equals(null)) {

					projektService.insertPerson(person, new AsyncCallback<Person>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							final DialogBox dialogBox = new DialogBox();
							dialogBox.setText("Speichern hat nicht geklappt " + caught.getLocalizedMessage());
							Button closeButton = new Button("OK", new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub
									dialogBox.hide();
								}
							});

							dialogBox.add(closeButton);
							dialogBox.show();
						}

						@Override
						public void onSuccess(Person result) {
							// TODO Auto-generated method stub
							final DialogBox dialogBox = new DialogBox();
							dialogBox.setText("Erfolgreich gespeichert");
							Button closeButton = new Button("OK", new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub
									dialogBox.hide();
								}
							});

							dialogBox.add(closeButton);
							dialogBox.show();
						}
					});
				}

				projektService.insertEigenschaft(eig, new AsyncCallback<Eigenschaft>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						final DialogBox dialogBox = new DialogBox();
						dialogBox.setText("Fehler beim Speichern von Eigenschaften " + caught.getLocalizedMessage());
						Button closeButton = new Button("OK", new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								// TODO Auto-generated method stub
								dialogBox.hide();
							}
						});

						dialogBox.add(closeButton);
						dialogBox.show();

					}

					@Override
					public void onSuccess(Eigenschaft result) {
						// TODO Auto-generated method stub
						// final DialogBox dialogBox = new DialogBox();
						// dialogBox.setText("Erfolgreich gespeichert");
						// Button closeButton = new Button("OK", new
						// ClickHandler() {
						//
						// @Override
						// public void onClick(ClickEvent event) {
						// // TODO Auto-generated method stub
						// dialogBox.hide();
						// }
						// });
						//
						// dialogBox.add(closeButton);
						// dialogBox.show();

					}
				});
			}
		});
//		vpUnten.add(btAdd);
		vpUnten.add(ftKenntnisListe); 
		vpUnten.add(btSpeichern);

		this.add(vpKopf);
		vpKopf.add(lbKenntnisse);
		vpKopf.add(kBereich);
		vpKopf.add(vpUnten);
	}

}
