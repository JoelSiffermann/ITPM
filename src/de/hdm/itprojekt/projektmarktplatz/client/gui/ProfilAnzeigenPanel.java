package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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
	Organisationseinheit org = new Organisationseinheit();
	Button btProfilBearbeiten = new Button("Profil bearbeiten");
	Button btProfilEntfernen = new Button("Profil entfernen");

	

	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	public void onLoad(){
		
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

		vpProfilForm1.add(tbVorname);
		vpProfilForm1.add(tbName);
		vpProfilForm1.add(tbBeruf);
		vpProfilForm1.add(gridProfil);

		vpProfilForm1.add(tbGfeld);
		vpProfilForm1.add(tbGform);

		vpProfilForm1.add(tbArbeitsfeld);
		vpProfilForm1.add(tbGroesse);

		gridProfil.setWidget(0, 0, tbJahreszahl);

		vpProfilForm2.add(btProfilBearbeiten);
		vpProfilForm2.add(btProfilEntfernen);

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
//			setHp(hp);
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

			Cookies.setCookie("orgid", result.getId()+"");
			projektService.readUserByOrg(result, new AsyncCallback<ArrayList<String>>() {
				
				@Override
				public void onSuccess(ArrayList<String> result) {
					String obj = result.get(0);
					Cookies.setCookie("putid", result.get(3)); 
					Window.alert(obj); 
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
					Grid gridProfil = new Grid(1, 2);

					Button btProfilBearbeiten = new Button("Profil bearbeiten");
					Button btProfilEntfernen = new Button("Profil entfernen");
					
					tbName.getElement().setPropertyString("placeholder", "Name");
					tbVorname.getElement().setPropertyString("placeholder", "Vorname");
					tbBeruf.getElement().setPropertyString("placeholder", "Beruf");
					tbJahreszahl.getElement().setPropertyString("placeholder", "Berufserfahrung in Jahre");

					tbGfeld.getElement().setPropertyString("placeholder", "Gesch�ftsfeld");
					tbGform.getElement().setPropertyString("placeholder", "Gesch�ftsform");
					tbArbeitsfeld.getElement().setPropertyString("placeholder", "Arbeitsfeld");
					tbGroesse.getElement().setPropertyString("placeholder", "Gr�sse");

					vpProfilForm1.add(tbName);

					gridProfil.setWidget(0, 0, tbJahreszahl);

					vpProfilForm2.add(btProfilBearbeiten);
					vpProfilForm2.add(btProfilEntfernen);

//					this.clear();// nicht nötig, weil frisch angelegt wurde
//
//					this.add(vpProfilForm1);
//					this.add(vpProfilForm2);
					Cookies.setCookie("orgobjekt", obj);
					if (obj == "Unternehmen"){
						
						vpProfilForm1.add(tbGfeld);
						vpProfilForm1.add(tbGform);
						
					} else if (obj == "Person"){
						vpProfilForm1.add(tbVorname);
						vpProfilForm1.add(tbBeruf);
						vpProfilForm1.add(gridProfil);
						
					} else if (obj == "Team") {
						vpProfilForm1.add(tbArbeitsfeld);
						vpProfilForm1.add(tbGroesse);
					}
					else {
						vpProfilForm1.add(tbName);
						vpProfilForm1.add(tbBeruf);
						vpProfilForm1.add(gridProfil);
						
						vpProfilForm1.add(tbGfeld);
						vpProfilForm1.add(tbGform);
						
						vpProfilForm1.add(tbArbeitsfeld);
						vpProfilForm1.add(tbGroesse);
						
						
					}
					
					
					btProfilBearbeiten.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							int id = Integer.parseInt(Cookies.getCookie("putid"));
							
							Organisationseinheit oeinheit = new Organisationseinheit();
							Partnerprofil partner = new Partnerprofil();
							int orid = Integer.parseInt(Cookies.getCookie("orgid"));
							int partnerid = Integer.parseInt(Cookies.getCookie("profilid"));
							oeinheit.setId(orid);
							oeinheit.setEmail(Cookies.getCookie("email")); 
							oeinheit.setName(tbName.getText()); 

							partner.setId(partnerid);
							
							oeinheit.setPartnerprofil(partner);
							
							projektService.updateOrg(oeinheit, new AsyncCallback<Organisationseinheit>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Organisationseinheit result) {
									// TODO Auto-generated method stub
									
								}
							});
							
							if(Cookies.getCookie("orgobjekt") == "Unternehmen"){
								
								Organisationseinheit o = new Organisationseinheit();
								Unternehmen u = new Unternehmen();
								
								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));
								
								o.setId(orgid); 
								u.setId(id);;
								u.setGeschaeftsfeld(tbGfeld.getText());
								u.setGeschaeftsform(tbGform.getText()); 
								u.setOrganisationseinheit(o); 
								
								
								projektService.updateUnternehmen(u, new AsyncCallback<Unternehmen>() {
									
									@Override
									public void onSuccess(Unternehmen result) {
										// TODO Auto-generated method stub
										
									}
									
									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										
									}
								} );
								
								
							} else if(Cookies.getCookie("orgobjekt") == "Person"){
								Organisationseinheit o = new Organisationseinheit();
								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));
								o.setId(orgid);
								
								Person p = new Person();
								
								p.setBeruf(tbBeruf.getText());
								p.setId(id); 
								p.setErfahrung(Integer.parseInt(tbJahreszahl.getText()));
								p.setVorname(tbVorname.getText());
								p.setOrganisationseinheit(o);
								
								projektService.updatePerson(p, new AsyncCallback<Person>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										
									}

									@Override
									public void onSuccess(Person result) {
										// TODO Auto-generated method stub
										
									}
								});
								
							} else if(Cookies.getCookie("orgobjekt") == "Team"){
								Organisationseinheit o = new Organisationseinheit();
								int orgid = Integer.parseInt(Cookies.getCookie("orgid"));
								o.setId(orgid);
								
								Team t = new Team();
								t.setArbeitsfeld(tbArbeitsfeld.getText());
								t.setGroesse(Integer.parseInt(tbGroesse.getText()));
								t.setId(id);
								t.setOrganisationseinheit(o); 
								
								projektService.updateTeam(t, new AsyncCallback<Team>() {
									
									@Override
									public void onSuccess(Team result) {
										// TODO Auto-generated method stub
										
									}
									
									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										
									}
								});
								
								
							}
							
//							class BearbeitenUnternehmenAsync implements AsyncCallback<Unternehmen> {
//
//								public BearbeitenUnternehmenAsync() {
//									// TODO Auto-generated constructor stub
//								}
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Unternehmen result) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								
//								
//							}
//							
//							class BearbeitenPersonAsync implements AsyncCallback<Person> {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Person result) {
//									// TODO Auto-generated method stub
//									
//								}
//								
//							}
//							
//							class BearbeitenTeamAsync implements AsyncCallback<Team> {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Team result) {
//									// TODO Auto-generated method stub
//									
//								}
//							}
							
							Window.alert("Speichern erfolgreich"); 
						}
					});
					

					btProfilEntfernen.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							Window.alert("Entfernend");
							
						}
					});
					
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
