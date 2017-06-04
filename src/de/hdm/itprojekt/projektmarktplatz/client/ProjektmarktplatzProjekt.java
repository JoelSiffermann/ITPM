package de.hdm.itprojekt.projektmarktplatz.client;

import de.hdm.itprojekt.projektmarktplatz.client.gui.MainPanel;
import de.hdm.itprojekt.projektmarktplatz.shared.LoginService;
import de.hdm.itprojekt.projektmarktplatz.shared.LoginServiceAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.LoginInfo;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

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
	        	loadGUI();
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
