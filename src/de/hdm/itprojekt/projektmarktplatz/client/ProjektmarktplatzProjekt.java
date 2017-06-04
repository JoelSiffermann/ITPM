package de.hdm.itprojekt.projektmarktplatz.client;

import de.hdm.itprojekt.projektmarktplatz.shared.LoginService;
import de.hdm.itprojekt.projektmarktplatz.shared.LoginServiceAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;
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
		
		
		Bewertung bt = new Bewertung ();
		Person pers = new Person ();
		
		//BEWERTUNG
		bt.setId(4);
		bt.setInhalt("test test test");
		bt.setPerson(pers);
		
		/*******----------------------------------------------------------------EINFÜGEN EINER BEWERTUNG -----******/

		
		projektService.insertBewertung(bt, new AsyncCallback<Bewertung>() {
			
			@Override
			public void onSuccess(Bewertung result) {
				// TODO Auto-generated method stub
				final DialogBox dialogBox = new DialogBox();
				dialogBox.setText("hat geklappt ");
				dialogBox.show();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		//BEWERBUNG--
		b.setId(31);
		b.setInhalt("Neuer Test von Ersin");
		b.setErstelldatum(date);
		
		a.setId(666);
		
		b.setAusschreibung(a);
		
		/*******----------------------------------------------------------------EINFÜGEN EINER BEWERBUNG -----******/
				
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
		
		//--------------------------------------------------------------- BEARBEITEN VON BWERBUNGEN------  --- ---------

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
		//----------------------------------------------------------------LESEN EINER BEWERBUNG--------------------------
		
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
		//--------------------------------------------------------------LESEN ALLER BEWERBUNGEN----------------
		
		
///////////////////////////////////////////////////////////////
//		p.setId(1);
//		proj.setId(1);
//		a.setBezeichnung("Hdm Bezeichnung"); 
//		a.setFrist(date);
//		a.setId(4);
//		a.setInhalt("Suche Programmierer 2");
//		a.setPartnerprofil(p);
//		a.setProjekt(proj); 
	
																	// ---- Lesen von allen Datensätzen Ausschreibung ---
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
		
																			// --- Lese ein Datensatz Ausschreibung --- 
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
		
																					// ---- Löschen Ausschreibung ---
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
		
																					//--- Einfügen von Ausschreibung --
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
		
																			// --- Ende Einfüngen von Ausschreibung --- 
		
		
		
//		org.setId(3);
//		org.setEmail("email@test.de");
//		org.setName("HdM 3.0");
//		org.setPartnerprofil(p);
		
//		p.setId(0); 
//		org.setPartnerprofil(p);
		
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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Check login status using login service.
	    LoginServiceAsync loginService = GWT.create(LoginService.class);
	    loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
	      public void onFailure(Throwable error) {
	      }

	      public void onSuccess(LoginInfo result) {
	        loginInfo = result;
	        if(loginInfo.isLoggedIn()) {
	          //TODO: Wenn Login Erfolgreich dann Gui aufrufen.

	        } else {
	          loadLogin();
	        }
	      }
	    });
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
	
	private void loadLogin() {
	    // Assemble login panel.
	    signInLink.setHref(loginInfo.getLoginUrl());
	    loginPanel.add(loginLabel);
	    loginPanel.add(signInLink);
	    RootPanel.get("main").add(loginPanel);
	  }
}
