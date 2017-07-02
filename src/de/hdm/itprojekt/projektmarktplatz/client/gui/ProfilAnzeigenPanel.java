package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.thirdparty.javascript.rhino.head.ast.SwitchCase;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Team;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Unternehmen;

public class ProfilAnzeigenPanel extends HorizontalPanel {

	/*
	 * Neues Design
	 */

	VerticalPanel vpProfilForm1 = new VerticalPanel();
	VerticalPanel vpProfilForm2 = new VerticalPanel();
	TextBox tbName = new TextBox();
	TextBox tbVorname = new TextBox();
	TextBox tbBeruf = new TextBox();
	TextBox tbJahreszahl = new TextBox();
	TextBox tbGroesse = new TextBox();
	TextBox tbArbeitsfeld = new TextBox();
	TextBox tbGform = new TextBox();
	TextBox tbGfeld = new TextBox();
	Grid gridProfil = new Grid(1, 2);

	final ListBox lbOrg = new ListBox();
	Organisationseinheit org = new Organisationseinheit();
	Button btProfilBearbeiten = new Button("Profil bearbeiten");
	//Button btProfilEntfernen = new Button("Profil entfernen");

	
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	public void onLoad() {

		super.onLoad();
		org.setEmail(Cookies.getCookie("email"));
		tbName.getElement().setPropertyString("placeholder", "Name");
		tbVorname.getElement().setPropertyString("placeholder", "Vorname");
		tbBeruf.getElement().setPropertyString("placeholder", "Beruf");
		tbJahreszahl.getElement().setPropertyString("placeholder", "Berufserfahrung in Jahre");

		tbGfeld.getElement().setPropertyString("placeholder", "Gesch�ftsfeld");
		tbGform.getElement().setPropertyString("placeholder", "Gesch�ftsform");
		tbArbeitsfeld.getElement().setPropertyString("placeholder", "Arbeitsfeld");
		tbGroesse.getElement().setPropertyString("placeholder", "Gr�sse");

		lbOrg.addItem("Person", "person");
		lbOrg.addItem("Unternehmen", "unternehmen");
		lbOrg.addItem("Team", "Team");

		tbVorname.setVisible(false); 
		tbBeruf.setVisible(false);
		tbJahreszahl.setVisible(false); 
		gridProfil.setVisible(false);
		tbGfeld.setVisible(false);
		tbGform.setVisible(false);
		tbArbeitsfeld.setVisible(false);
		tbGroesse.setVisible(false);
		
		vpProfilForm1.add(lbOrg);
		vpProfilForm1.add(tbName);
		vpProfilForm1.add(tbVorname);
		vpProfilForm1.add(tbBeruf);
		vpProfilForm1.add(tbJahreszahl); 
		vpProfilForm1.add(gridProfil);

		vpProfilForm1.add(tbGfeld);
		vpProfilForm1.add(tbGform);

		vpProfilForm1.add(tbArbeitsfeld);
		vpProfilForm1.add(tbGroesse);

		gridProfil.setWidget(0, 0, tbJahreszahl);
//
		vpProfilForm2.add(btProfilBearbeiten);
//		vpProfilForm2.add(btProfilEntfernen);
		lbOrg.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				switch (lbOrg.getSelectedItemText()) {
				case "Person":
					tbVorname.setVisible(true); 
					tbBeruf.setVisible(true);
					tbJahreszahl.setVisible(true); 
					gridProfil.setVisible(true);
					tbGfeld.setVisible(false);
					tbGform.setVisible(false);
					tbArbeitsfeld.setVisible(false);
					tbGroesse.setVisible(false);
					break;
				case "Unternehmen":
					tbVorname.setVisible(false); 
					tbBeruf.setVisible(false);
					tbJahreszahl.setVisible(false); 
					gridProfil.setVisible(false);
					tbGfeld.setVisible(true);
					tbGform.setVisible(true);
					tbArbeitsfeld.setVisible(false);
					tbGroesse.setVisible(false);
					break;
				case "Team":
					tbVorname.setVisible(false); 
					tbBeruf.setVisible(false);
					tbJahreszahl.setVisible(false); 
					gridProfil.setVisible(false);
					tbGfeld.setVisible(false);
					tbGform.setVisible(false);
					tbArbeitsfeld.setVisible(true);
					tbGroesse.setVisible(true);
					break;
				default:
					break;
				}

			}
		});
		
		btProfilBearbeiten.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Starte Update");
				Organisationseinheit o = new Organisationseinheit();
				Partnerprofil p = new Partnerprofil();
				o.setId(Integer.parseInt(Cookies.getCookie("orgid")));
				o.setEmail(Cookies.getCookie("email")); 
				o.setName(tbName.getText());
				
				p.setId(Integer.parseInt(Cookies.getCookie("profilid")));
				o.setPartnerprofil(p); 
				Window.alert("Starte Update");
				switch (lbOrg.getSelectedItemText()) {
				case "Person":
					
					Person pers = new Person();
					
					pers.setBeruf(tbBeruf.getText());
					pers.setErfahrung(Float.parseFloat(tbJahreszahl.getText()));
					pers.setVorname(tbVorname.getText());
					pers.setOrganisationseinheit(o); 
					
					projektService.insertPerson(pers, new AsyncCallback<Person>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Person result) {
							Window.alert("Sie haben sich als Person gespeichert"); 
							
						}
					});
					
					break;
				case "Unternehmen":
					tbGfeld.setVisible(true);
					tbGform.setVisible(true);
					
					Unternehmen u = new Unternehmen();
					u.setGeschaeftsfeld(tbGfeld.getText());
					u.setGeschaeftsform(tbGform.getText());
					
					u.setOrganisationseinheit(o);
					
					projektService.insertUnternehmen(u, new AsyncCallback<Unternehmen>() {
						
						@Override
						public void onSuccess(Unternehmen result) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}
					});
					
					
					break;
				case "Team":
					
					tbArbeitsfeld.setVisible(true);
					tbGroesse.setVisible(true);
					
					Team t = new Team();
					t.setArbeitsfeld(tbArbeitsfeld.getText());
					t.setGroesse(Integer.parseInt(tbGroesse.getText()));
					
					t.setOrganisationseinheit(o);
					
					projektService.insertTeam(t, new AsyncCallback<Team>() {
						
						@Override
						public void onSuccess(Team result) {
							// TODO Auto-generated method stub
						}
						
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
						}
					});

					break;
				default:
					break;
				}
				
			}
		});

		this.clear();// nicht nötig, weil frisch angelegt wurde
		
		this.add(vpProfilForm1);
		this.add(vpProfilForm2);

		pruefeUser(this);
	}

	public void pruefeUser(HorizontalPanel hp) {
		Organisationseinheit o = new Organisationseinheit();
		o.setEmail(Cookies.getCookie("email"));

		projektService.readByEmail(o, new pruefeUserCallback());

	}

	private class pruefeUserCallback implements AsyncCallback<Organisationseinheit> {

		HorizontalPanel hp = new HorizontalPanel();

		public pruefeUserCallback() {

		}

		public pruefeUserCallback(HorizontalPanel hp) {

			this.hp = hp;
			// setHp(hp);
		}

		public void setHp(HorizontalPanel hp) {
			this.hp = hp;
		}

		public HorizontalPanel getHp() {
			return this.hp;
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Keine Orga");
		}

		@Override
		public void onSuccess(Organisationseinheit result) {

			// Window.alert("Orga " + result.getEmail());

			Person pers = new Person();
			pers.setOrganisationseinheit(result);

			Team t = new Team();
			t.setOrganisationseinheit(result);

			Unternehmen u = new Unternehmen();
			u.setOrganisationseinheit(result);

			Cookies.setCookie("orgid", result.getId() + "");
			projektService.readUserByOrg(result, new AsyncCallback<ArrayList<String>>() {

				@Override
				public void onSuccess(ArrayList<String> result) {
					String obj = result.get(0);
					
//					Window.alert(obj);
					VerticalPanel vpProfilForm1 = new VerticalPanel();
					VerticalPanel vpProfilForm2 = new VerticalPanel();
					final TextBox tbName = new TextBox();
					final TextBox tbVorname = new TextBox();
					final TextBox tbBeruf = new TextBox();
					final TextBox tbJahreszahl = new TextBox();
					final TextBox tbGroesse = new TextBox();
					final TextBox tbArbeitsfeld = new TextBox();
					final TextBox tbGform = new TextBox();
					final TextBox tbGfeld = new TextBox();
					final Grid gridProfil = new Grid(1, 2);

					Button btProfilBearbeiten = new Button("Profil bearbeiten");
//					Button btProfilEntfernen = new Button("Profil entfernen");

					tbName.getElement().setPropertyString("placeholder", "Name");
					tbVorname.getElement().setPropertyString("placeholder", "Vorname");
					tbBeruf.getElement().setPropertyString("placeholder", "Beruf");
					tbJahreszahl.getElement().setPropertyString("placeholder", "Berufserfahrung in Jahre");

					tbGfeld.getElement().setPropertyString("placeholder", "Gesch�ftsfeld");
					tbGform.getElement().setPropertyString("placeholder", "Gesch�ftsform");
					tbArbeitsfeld.getElement().setPropertyString("placeholder", "Arbeitsfeld");
					tbGroesse.getElement().setPropertyString("placeholder", "Gr�sse");

//					vpProfilForm1.add(lbOrg); 
					vpProfilForm1.add(tbName);
					
					gridProfil.setWidget(0, 0, tbJahreszahl);

					vpProfilForm2.add(btProfilBearbeiten);
//					vpProfilForm2.add(btProfilEntfernen);

					// this.clear();// nicht nötig, weil frisch angelegt wurde
					//
					// this.add(vpProfilForm1);
					// this.add(vpProfilForm2);
					Cookies.setCookie("orgobjekt", obj);
					if (obj == "Unternehmen") {
						tbName.setText(result.get(3));
						tbGform.setText(result.get(1));
						tbGfeld.setText(result.get(2)); 
						Cookies.setCookie("putid", result.get(4));
						vpProfilForm1.add(tbGfeld);
						vpProfilForm1.add(tbGform);

					} else if (obj == "Person") {
						tbName.setText(result.get(4));
						tbVorname.setText(result.get(1));
						tbBeruf.setText(result.get(2));
						tbJahreszahl.setText(result.get(3));
						vpProfilForm1.add(tbVorname);
						vpProfilForm1.add(tbBeruf);
						vpProfilForm1.add(gridProfil);
						Cookies.setCookie("putid", result.get(5));

					} else if (obj == "Team") {
						tbName.setText(result.get(3));
						tbGroesse.setText(result.get(1));
						tbArbeitsfeld.setText(result.get(2)); 
						Cookies.setCookie("putid", result.get(4));
						vpProfilForm1.add(tbArbeitsfeld);
						vpProfilForm1.add(tbGroesse);
					} else {

						
						
//						tbJahreszahl.setVisible(false); 
//						tbName.setVisible(true);
//						tbVorname.setVisible(false); 
//						tbBeruf.setVisible(false);
//						gridProfil.setVisible(false);
//						tbGfeld.setVisible(false);
//						tbGform.setVisible(false);
//						tbArbeitsfeld.setVisible(false);
//						tbGroesse.setVisible(false);
//						
//						vpProfilForm1.add(tbName);
//						vpProfilForm1.add(tbBeruf);
//						vpProfilForm1.add(tbJahreszahl); 
//						vpProfilForm1.add(gridProfil);
//
//						vpProfilForm1.add(tbGfeld);
//						vpProfilForm1.add(tbGform);
//
//						vpProfilForm1.add(tbArbeitsfeld);
//						vpProfilForm1.add(tbGroesse);
						
					}

					btProfilBearbeiten.addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
//							Window.alert("Starte Update TEST "+ Cookies.getCookie("putid"));
							int id = 9;// Integer.parseInt(Cookies.getCookie("putid"));
							
							Organisationseinheit oeinheit = new Organisationseinheit();
							Organisationseinheit o = new Organisationseinheit();
							Unternehmen u = new Unternehmen();
							Person p = new Person();
							Team t = new Team();
							Partnerprofil partner = new Partnerprofil();
							int orid = Integer.parseInt(Cookies.getCookie("orgid"));
							int partnerid = Integer.parseInt(Cookies.getCookie("profilid"));
							oeinheit.setId(orid);
							oeinheit.setEmail(Cookies.getCookie("email"));
							oeinheit.setName(tbName.getText());

							partner.setId(partnerid);

							oeinheit.setPartnerprofil(partner);
//							Window.alert("Starte Update");
							if (Cookies.getCookie("orgobjekt") == "Unternehmen") {

								
								t = null;
								p = null;

								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));

								o.setId(orgid);
								u.setId(id);
								;
								u.setGeschaeftsfeld(tbGfeld.getText());
								u.setGeschaeftsform(tbGform.getText());
								u.setOrganisationseinheit(oeinheit);

							} else if (Cookies.getCookie("orgobjekt") == "Person") {
//								Organisationseinheit o = new Organisationseinheit();
								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));
								o.setId(orgid);

//								Window.alert(o.getId()+""); 
								
								u = null;
								t = null;
								p.setBeruf(tbBeruf.getText());
								p.setId(id);
								p.setErfahrung(Integer.parseInt(tbJahreszahl.getText()));
								p.setVorname(tbVorname.getText());
								p.setOrganisationseinheit(oeinheit);

							} else if (Cookies.getCookie("orgobjekt") == "Team") {
								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));
								o.setId(orgid);

								u = null;
								p = null;
								t.setArbeitsfeld(tbArbeitsfeld.getText());
								t.setGroesse(Integer.parseInt(tbGroesse.getText()));
								t.setId(id);
								t.setOrganisationseinheit(oeinheit);

							}
							
							projektService.updateOrg2(oeinheit, t, p, u, new AsyncCallback<Organisationseinheit>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									Window.alert("Org konnte nicht aktualisiert werden");
								}

								@Override
								public void onSuccess(Organisationseinheit result) {
									// TODO Auto-generated method stub
									Window.alert("Org update");
								}
							});

//							if (Cookies.getCookie("orgobjekt") == "Unternehmen") {
//
//								Organisationseinheit o = new Organisationseinheit();
//								Unternehmen u = new Unternehmen();
//
//								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));
//
//								o.setId(orgid);
//								u.setId(id);
//								;
//								u.setGeschaeftsfeld(tbGfeld.getText());
//								u.setGeschaeftsform(tbGform.getText());
//								u.setOrganisationseinheit(oeinheit);
//
//								projektService.updateUnternehmen(u, new AsyncCallback<Unternehmen>() {
//
//									@Override
//									public void onSuccess(Unternehmen result) {
//										// TODO Auto-generated method stub
//
//									}
//
//									@Override
//									public void onFailure(Throwable caught) {
//										// TODO Auto-generated method stub
//
//									}
//								});
//
//							} else if (Cookies.getCookie("orgobjekt") == "Person") {
//								Organisationseinheit o = new Organisationseinheit();
//								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));
//								o.setId(orgid);
//
//								Window.alert(o.getId()+""); 
//								Person p = new Person();
//
//								p.setBeruf(tbBeruf.getText());
//								p.setId(id);
//								p.setErfahrung(Integer.parseInt(tbJahreszahl.getText()));
//								p.setVorname(tbVorname.getText());
//								p.setOrganisationseinheit(oeinheit);
//
//								projektService.updatePerson(p, new AsyncCallback<Person>() {
//
//									@Override
//									public void onFailure(Throwable caught) {
//										// TODO Auto-generated method stub
//										Window.alert("Fehler Person");
//									}
//
//									@Override
//									public void onSuccess(Person result) {
//										// TODO Auto-generated method stub
//										Window.alert("Kein Fehler beim Speichern"); 
//									}
//								});
//
//							} else if (Cookies.getCookie("orgobjekt") == "Team") {
//								Organisationseinheit o = new Organisationseinheit();
//								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));
//								o.setId(orgid);
//
//								Team t = new Team();
//								t.setArbeitsfeld(tbArbeitsfeld.getText());
//								t.setGroesse(Integer.parseInt(tbGroesse.getText()));
//								t.setId(id);
//								t.setOrganisationseinheit(oeinheit);
//
//								projektService.updateTeam(t, new AsyncCallback<Team>() {
//
//									@Override
//									public void onSuccess(Team result) {
//										// TODO Auto-generated method stub
//
//									}
//
//									@Override
//									public void onFailure(Throwable caught) {
//										// TODO Auto-generated method stub
//
//									}
//								});
//
//							}

//							////////////////////////////////////////////////////////////////
							
							// class BearbeitenUnternehmenAsync implements
							// AsyncCallback<Unternehmen> {
							//
							// public BearbeitenUnternehmenAsync() {
							// // TODO Auto-generated constructor stub
							// }
							// @Override
							// public void onFailure(Throwable caught) {
							// // TODO Auto-generated method stub
							//
							// }
							//
							// @Override
							// public void onSuccess(Unternehmen result) {
							// // TODO Auto-generated method stub
							//
							// }
							//
							//
							//
							// }
							//
							// class BearbeitenPersonAsync implements
							// AsyncCallback<Person> {
							//
							// @Override
							// public void onFailure(Throwable caught) {
							// // TODO Auto-generated method stub
							//
							// }
							//
							// @Override
							// public void onSuccess(Person result) {
							// // TODO Auto-generated method stub
							//
							// }
							//
							// }
							//
							// class BearbeitenTeamAsync implements
							// AsyncCallback<Team> {
							//
							// @Override
							// public void onFailure(Throwable caught) {
							// // TODO Auto-generated method stub
							//
							// }
							//
							// @Override
							// public void onSuccess(Team result) {
							// // TODO Auto-generated method stub
							//
							// }
							// }

							Window.alert("Speichern erfolgreich");
						}
					});

//					btProfilEntfernen.addClickHandler(new ClickHandler() {
//
//						@Override
//						public void onClick(ClickEvent event) {
//							
//							
//						}
//					});

					RootPanel.get("main").clear();
					RootPanel.get("main").add(vpProfilForm1);
					RootPanel.get("main").add(vpProfilForm2);
				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});

		}

	}

}
