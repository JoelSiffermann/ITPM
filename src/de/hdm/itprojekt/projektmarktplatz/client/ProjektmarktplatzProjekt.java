package de.hdm.itprojekt.projektmarktplatz.client;

import de.hdm.itprojekt.projektmarktplatz.client.gui.MainNavigationPanel;
import de.hdm.itprojekt.projektmarktplatz.shared.LoginService;
import de.hdm.itprojekt.projektmarktplatz.shared.LoginServiceAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.LoginInfo;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
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
	private Label loginLabel = new Label("Bitte mit Ihrem Google-Account einloggen.");
	private Anchor signInLink = new Anchor("Sign In");
//	private Anchor signOutLink = new Anchor("Sign Out");
	
	VerticalPanel vpNavigation = new VerticalPanel();
	Button btStartseite = new Button("Startseite");
	Button btPost = new Button("Post");
	Button btImpressum = new Button("Impressum");
	Button btAusloggen = new Button("Ausloggen");
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

	    LoginServiceAsync loginService = GWT.create(LoginService.class);
	    
//	    loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
//	      public void onFailure(Throwable error) {
//	      }
//
//	      public void onSuccess(LoginInfo result) {
//	        loginInfo = result;
//	        if(loginInfo.isLoggedIn()) {
//	          //TODO: Wenn Login Erfolgreich dann Gui aufrufen.
////	        	Window.alert("Login erfolgt.");
//	        	Cookies.setCookie("email", loginInfo.getEmailAddress());
////	        	Cookies.setCookie("email", "email@test.de");
////	    		org.setEmail(Cookies.getCookie("email")); 
////	        	Organisationseinheit o = new Organisationseinheit();
////	        	o.setEmail(loginInfo.getEmailAddress());
////	        	loadGUI(o);
//	        	loadGUI();
//	        } else {
//	          loadLogin();
//	        }
//	      }
//	    });

	    Cookies.setCookie("email", "hdm@hdm.de");
//	    Cookies.setCookie("profilid", "2");
//	    Cookies.setCookie("userid", "3");
	   
		loadGUI();

		
	}
	
	private void loadGUI(){
		Organisationseinheit o = new Organisationseinheit();
		
		
		
		o.setEmail(Cookies.getCookie("email")); 
	    projektService.readByEmail(o, new AsyncCallback<Organisationseinheit>() {
			
			@Override
			public void onSuccess(Organisationseinheit result) {
//				Window.alert("ID  " + result.getId());
				Cookies.setCookie("userid", result.getId()+"");
				Cookies.setCookie("profilid", result.getPartnerprofil().getId()+"");
			}
			
			@Override
			public void onFailure(Throwable caught) {

				Window.alert("Fehler aufgetreten"); 
			}
		});
	    
//		Home mp = new Home();
		btImpressum.addClickHandler(new ImpressumClickHandler());
		MainNavigationPanel mainnav = new MainNavigationPanel();
		RootPanel.get("nav").add(mainnav);
		RootPanel.get("footer").add(btImpressum);
//		RootPanel.get("main").add(mp);
	
	}
	
	private void loadLogin() {
	    // Assemble login panel.
	    signInLink.setHref(loginInfo.getLoginUrl());
	    loginPanel.add(loginLabel);
	    loginPanel.add(signInLink);
	    RootPanel.get("main").add(loginPanel);
	  }
	
	private class ImpressumClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			Impressum imp = new Impressum();
			RootPanel.get("main").clear();
			RootPanel.get("main").add(imp);
		}
		
	}
}
