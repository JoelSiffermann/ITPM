package de.hdm.itprojekt.projektmarktplatz.client;

import de.hdm.itprojekt.projektmarktplatz.client.gui.MainPanel;
import de.hdm.itprojekt.projektmarktplatz.shared.LoginService;
import de.hdm.itprojekt.projektmarktplatz.shared.LoginServiceAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Eigenschaft;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.LoginInfo;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjektmarktplatzProjekt implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label(
	      "Please sign in to your Google Account to access the StockWatcher application.");
	private Anchor signInLink = new Anchor("Sign In");
//	private Anchor signOutLink = new Anchor("Sign Out");
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		


		Ausschreibung a = new Ausschreibung();
		Partnerprofil p = new Partnerprofil();
		Projekt proj = new Projekt();
		Date date = new Date();
		Bewerbung b = new Bewerbung();
		Organisationseinheit org = new Organisationseinheit();
		Eigenschaft eg = new Eigenschaft();
		Bewertung bt = new Bewertung ();
		Person pers = new Person ();
		Beteiligung projBet = new Beteiligung ();
		
//		eg.setBezeichnung("test_bearbeiten");
//		eg.setId(2);
//		eg.setPartnerprofil(p);
//		eg.setWert("test");
		
		p.setId(11);
		p.setAenderungsdatum(date);
		p.setErstelldatum(date);
		
		a.setId(0);
		org.setId(13);
		proj.setId(23);
		
//		p.setAusschreibung(a);
//		p.setOrganisationseinheit(org);
		
//		pers.setBeruf("Student");
//		pers.setErfahrung(1.1f);
//		pers.setId(4);
//		pers.setOrganisationseinheit(org);
//		pers.setVorname("Ersin");
		
		projBet.setEnde(date);
		projBet.setId(1);
		projBet.setOrganisationseinheit(org);
		projBet.setProjekt(proj);
		projBet.setStart(date);
		projBet.setUmfang(16);
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, Anfang: Testen der Methoden für Projektbeteiligung-Objekte
		   * ***************************************************************************
		   */
		
		projektService.insertBeteiligung(projBet, new AsyncCallback<Beteiligung>() {
			
			@Override
			public void onSuccess(Beteiligung result) {
				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat funktioniert");
//				dialogBox.show();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, Anfang: Testen der Methoden für Person-Objekte
		   * ***************************************************************************
		   */
		//----> Löschen einer Person 
		
//		projektService.deletePerson(pers, new AsyncCallback<Void>() {
//			
//			@Override
//			public void onSuccess(Void result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt - Person ");
//				dialogBox.show();
//
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		
		
		//----> lesen aller Personen 
		
//		projektService.readAllPerson(new AsyncCallback<ArrayList<Person>>() {
//			
//			@Override
//			public void onSuccess(ArrayList<Person> result) {
//				// TODO Auto-generated method stub
//				String id = "";
//				for (Person pers : result){
//					id = id + " " + pers.getId();
//				}
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt" + id);
//				dialogBox.show();
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//		});

		
		//-------> Lesen einer Person 
//		projektService.readByIdPerson(pers, new AsyncCallback<Person>() {
//			
//			@Override
//			public void onSuccess(Person result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt - Person " + result.getVorname());
//				dialogBox.show();
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, Anfang: Testen der Methoden für Partnerprofil-Objekte
		   * ***************************************************************************
		   */
		
//				projektService.updatePartnerprofil(p, new AsyncCallback<Partnerprofil>() {
//		
//		@Override
//		public void onSuccess(Partnerprofil result) {
//			// TODO Auto-generated method stub
//			final DialogBox dialogBox = new DialogBox();
//			dialogBox.setText("hat geklappt ");
//			dialogBox.show();
//		}
//		
//		@Override
//		public void onFailure(Throwable caught) {
//			// TODO Auto-generated method stub
//			
//		}
//	});
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, Anfang: Testen der Methoden für Eigenschaft-Objekte
		   * ***************************************************************************
		   */
		
	
		//-------> Lesen einer Eigenschaft    
		

//		projektService.readByIdEigenschaft(eg, new AsyncCallback<Eigenschaft>() {
//	
//		@Override
//		public void onFailure(Throwable caught) {
//			// TODO Auto-generated method stub
//			final DialogBox d = new DialogBox();
//			d.setText(caught.getMessage());
//			d.show();
//		}
//		@Override
//		public void onSuccess(Eigenschaft result) {
//			// TODO Auto-generated method stub
//			final DialogBox dialogBox = new DialogBox();
//			dialogBox.setText("hat geklappt " + result.getBezeichnung());
//			dialogBox.show();
//		}
//	});
	
		//         --------> Lesen ALLER Eigenschaften
//
//		projektService.readAllEigenschaft(new AsyncCallback<ArrayList<Eigenschaft>>() {
//			
//			@Override
//			public void onSuccess(ArrayList<Eigenschaft> result) {
//				// TODO Auto-generated method stub
//				String id = "";
//				for (Eigenschaft eg : result){
//					id = id + " " + eg.getId(); 
//				}
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt" + id);
//				dialogBox.show();
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
//		//BEWERTUNG
//		bt.setId(3);
//		bt.setInhalt("test test test - update_Test");
//		bt.setSkala(3.64f);
//		pers.setVorname("Ersin");
//		pers.setBeruf("Student");
//		pers.setErfahrung(3.64f);
//		bt.setPerson(pers);
//		
//		
//		org.setId(3);
//		org.setEmail("email@test.de");
//		org.setName("HdM 3.0");
//		org.setPartnerprofil(p);
//		
//		p.setId(0); 
//		org.setPartnerprofil(p);
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, Anfang: Testen der Methoden für Bewertung-Objekte --> Lesen aller Bewertungen
		   * ***************************************************************************
		   */
//		projektService.readAllBewertung(new AsyncCallback<ArrayList<Bewertung>>() {
//			
//			@Override
//			public void onSuccess(ArrayList<Bewertung> result) {
//				// TODO Auto-generated method stub
//				String id = "";
//				for(Bewertung bt : result){
//					id = id + " " + bt.getId();
//				}
//				
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt " + id );
//				dialogBox.show();
//				
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat nicht geklappt " + caught.getMessage() );
//				dialogBox.show();
//			}
//		});
		
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, ENDE: Testen der Methoden für Bewertung-Objekte --> Lesen aller Bewertungen
		   * ***************************************************************************
		   */		
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, ANFANG: Testen der Methoden für Bewerbung-Objekte --> Einfügen einer Bewerbung
		   * ***************************************************************************
		   */

		
		
		//BEWERBUNG--
//		b.setId(31);
//		b.setInhalt("Neuer Test von Ersin");
//		b.setErstelldatum(date);
//		
//		a.setId(666);
//		
//		b.setAusschreibung(a);
//		
		
		//--> Erstellen einer Bewerbung
		
/*		projektService.insertBewerbung(b, new AsyncCallback<Bewerbung>() {
			
			@Override
			public void onSuccess(Bewerbung result) {
				// TODO Auto-generated method stub
				final DialogBox dialogBox = new DialogBox();
				dialogBox.setText("hat geklappt ");
				dialogBox.show();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		
		//--> Bearbeiten einer Bewerbung

		
//		projektService.updateBewerbung(b, new AsyncCallback<Bewerbung>() {
//			
//			@Override
//			public void onSuccess(Bewerbung result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt!! ");
//				dialogBox.show();
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		
		//--> Lesen einer Bewerbung
		
//		projektService.readByIdBewerbung(b, new AsyncCallback<Bewerbung>() {
//			
//			@Override
//			public void onSuccess(Bewerbung result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt " + result.getInhalt());
//				dialogBox.show();
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//		});

		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, ANFANG: Testen der Methoden für Ausschreibung-Objekte
		   * ***************************************************************************
		   */

		
		
//		p.setId(1);
//		proj.setId(1);
//		a.setBezeichnung("Hdm Bezeichnung"); 
//		a.setFrist(date);
//		a.setId(4);
//		a.setInhalt("Suche Programmierer 2");
//		a.setPartnerprofil(p);
//		a.setProjekt(proj); 
	
		//--> Lesen aller Ausschreibungen

//		projektService.readAllAusschreibung(new AsyncCallback<ArrayList<Ausschreibung>>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(ArrayList<Ausschreibung> result) {
//				// TODO Auto-generated method stub
//				String id = "";
//				for(Ausschreibung a : result){
//					id = id + " " + a.getId();
//				}
//				
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt " + id );
//				dialogBox.show();
//			}
//		});
		
		//--> Lesen einer Ausschreibung
		
//		projektService.readByIdAusschreibung(a, new AsyncCallback<Ausschreibung>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(Ausschreibung result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt " + result.getBezeichnung());
//				dialogBox.show();
//			}
//		});
		
		//--> Löschen einer Ausschreibung
		
//		projektService.deleteAusschreibung(a, new AsyncCallback<Void>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(Void result) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		//--> Erstellen einer Ausschreibung

//		projektService.insertAusschreibung(a, new AsyncCallback<Ausschreibung>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(Ausschreibung result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt ");
//				dialogBox.show();
//			}
//		});
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, Ende: Testen der Methoden für Ausschreibung-Objekte
		   * ***************************************************************************
		   */
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, ANFANG: Testen der Methoden für Organisationseinheit-Objekte
		   * ***************************************************************************
		   */
		
		
//		org.setId(3);
//		org.setEmail("email@test.de");
//		org.setName("HdM 3.0");
//		org.setPartnerprofil(p);
		
//		p.setId(0); 
//		org.setPartnerprofil(p);
		
		//--> Lesen einer Organisationseinheit

//		projektService.readByIdOrg(org, new AsyncCallback<Organisationseinheit>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("Fehler " + caught.getMessage());
//				dialogBox.show();
//				
//			}
//
//			@Override
//			public void onSuccess(Organisationseinheit result) {
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText("hat geklappt " + result.getEmail());
//				dialogBox.show();
//				
//			}
//		});
		loadGUI();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Check login status using login service.
		
		
//	    LoginServiceAsync loginService = GWT.create(LoginService.class);
//	    loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
//	      public void onFailure(Throwable error) {
//	      }
//
//	      public void onSuccess(LoginInfo result) {
//	        loginInfo = result;
//	        if(loginInfo.isLoggedIn()) {
//	          //TODO: Wenn Login Erfolgreich dann Gui aufrufen.
//	        	loadGUI();
//	        } else {
//	          loadLogin();
//	        }
//	      }
//	    });
	    
	    
		// We can add style names to widgets
//		sendButton.addStyleName("sendButton");
//		projektService.getTest(new AsyncCallback<String>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(String result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText(result);
//				dialogBox.show();
//			}
//		});
//		projektService.getTest(new AsyncCallback<String>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(String result) {
//				// TODO Auto-generated method stub
//				final DialogBox dialogBox = new DialogBox();
//				dialogBox.setText(result);
//			}
//		});
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
//		RootPanel.get("nameFieldContainer").add(nameField);
//		RootPanel.get("sendButtonContainer").add(sendButton);
//		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		
	}
	
	private void loadGUI(){
		MainPanel mp = new MainPanel();
		RootPanel.get("main").add(mp);
	
	}
	
	private void loadLogin() {
	    // Assemble login panel.
	    signInLink.setHref(loginInfo.getLoginUrl());
	    loginPanel.add(loginLabel);
	    loginPanel.add(signInLink);
	    RootPanel.get("main").add(loginPanel);
	  }
}
