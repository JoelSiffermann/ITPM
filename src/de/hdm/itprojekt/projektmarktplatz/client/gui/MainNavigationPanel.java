package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

public class MainNavigationPanel extends VerticalPanel {
	HorizontalPanel nav = new HorizontalPanel();
	HorizontalPanel info = new HorizontalPanel();


//	Organisationseinheit o;
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
	
//	public MainNavigationPanel(){
//		
//	}
	
//	public MainNavigationPanel(Organisationseinheit o) {
//		// TODO Auto-generated constructor stub
//		this.o = o;
//	}

	public void onLoad() {
		super.onLoad();

		Organisationseinheit o = new Organisationseinheit();
		o.setEmail(Cookies.getCookie("email"));
		projektService.readByEmail(o, new AsyncCallback<Organisationseinheit>() {
			
			@Override
			public void onSuccess(Organisationseinheit result) {

				Cookies.setCookie("profilid", result.getPartnerprofil().getId()+"");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});

		
//		projektService.readByEmail(o, new CheckUser(o));
	    StackPanel panel = new StackPanel();
	    panel.add(profilStack(), "Mein Profil");
	    panel.add(projektStack(), "Projekte");
	    panel.add(beteiligungStack(), "Beteiligung");
	    panel.add(bewerbungStack(), "Bewerbung");
	    panel.add(projektmarktplatzStack(), "Projektmarktplatz");
	    panel.add(reportStack(), "Report");
	    nav.add(panel);
	    RootPanel.get("nav").add(nav);
	    RootPanel.get("main").clear();
	    RootPanel.get("main").add(info);
	  }
	
	private VerticalPanel profilStack(){
		VerticalPanel profilstack = new VerticalPanel();
		Button btMeinProfil = new Button("Anzeigen");
		btMeinProfil.addClickHandler(new MeinProfilClickHandler());
		profilstack.add(btMeinProfil);
		return profilstack;
	}

	private VerticalPanel projektStack() {
		VerticalPanel projektstack = new VerticalPanel();
		Button btMeineProjekte = new Button("Meine Projekte");
		Button btAndereProjekte = new Button("Andere Projekte");
		Button btProjektAnlegen = new Button("Projekt anlegen");
		btProjektAnlegen.addClickHandler(new ProjektAnlegenClickHandler());
		btMeineProjekte.addClickHandler(new MeineProjekteClickHandler());
		btAndereProjekte.addClickHandler(new AndereProjekteClickHandler());
		projektstack.add(btMeineProjekte);
		projektstack.add(btAndereProjekte);
		projektstack.add(btProjektAnlegen);
		return projektstack;
	}

	private VerticalPanel beteiligungStack() {
		VerticalPanel beteiligungstack = new VerticalPanel();
		Button btMeineBeteiligung = new Button("Meine Beteiligungen");
		Button btAndereBeteiligung = new Button("Andere Beteiligungen");
		btMeineBeteiligung.addClickHandler(new MeineBeteiligungClickHandler());
		btAndereBeteiligung.addClickHandler(new AndereBeteiligungClickHandler());
		beteiligungstack.add(btMeineBeteiligung);
		beteiligungstack.add(btAndereBeteiligung);
		return beteiligungstack;
	}

	private VerticalPanel bewerbungStack() {
		VerticalPanel bewerbungstack = new VerticalPanel();
		Button btMeineBewerbung = new Button("Meine Bewerbungen");
		Button btEingegangeneBewerbung = new Button("Eingegangene Bewerbungen");
		btMeineBewerbung.addClickHandler(new MeineBewerbungClickHandler());
		btEingegangeneBewerbung.addClickHandler(new EingegangeneBewerbungClickHandler());
		bewerbungstack.add(btMeineBewerbung);
		bewerbungstack.add(btEingegangeneBewerbung);
		return bewerbungstack;
	}

	private VerticalPanel projektmarktplatzStack() {
		VerticalPanel projektmarktplatzStack = new VerticalPanel();
		Button btErstellen = new Button("Erstellen");
		Button btAnzeigen = new Button("Anzeigen");
		btErstellen.addClickHandler(new PMErstellenClickHandler());
		btAnzeigen.addClickHandler(new PMAnzeigenClickHandler());
		projektmarktplatzStack.add(btErstellen);
		projektmarktplatzStack.add(btAnzeigen);
		return projektmarktplatzStack;
	}

	private VerticalPanel reportStack() {
		VerticalPanel reportstack = new VerticalPanel();
		Button btReport = new Button("Zum ReportGenerator wechseln");
		btReport.addClickHandler(new ReportClickHandler());
		reportstack.add(btReport);
		return reportstack;
	}

	private class MeinProfilClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			ProfilAnzeigenPanel pp = new ProfilAnzeigenPanel();
			info.clear();
			info.add(pp);
		}
	}

	private class MeineProjekteClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MeineProjekteList mpl = new MeineProjekteList();
			info.clear();
			info.add(mpl);
		}
	}

	private class AndereProjekteClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AndereProjektmarktplatzList pml = new AndereProjektmarktplatzList();
			info.clear();
			info.add(pml);
		}
	}

	private class ProjektAnlegenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			ProjektNeuForm pn = new ProjektNeuForm();
			info.clear();
			info.add(pn);
		}
	}

	private class MeineBeteiligungClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MeineBeteiligungList mbl = new MeineBeteiligungList();
			info.clear();
			info.add(mbl);
		}
	}

	private class AndereBeteiligungClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AndereBeteiligungList abl = new AndereBeteiligungList();
			info.clear();
			info.add(abl);
		}
	}

	private class MeineBewerbungClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MeineBeteiligungList mbl = new MeineBeteiligungList();
			info.clear();
			info.add(mbl);
		}
	}

	private class EingegangeneBewerbungClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			// TODO
			info.clear();
			Window.alert("Panel fehlt");
			// info.add(m);
		}
	}

	private class PMAnzeigenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AlleProjektmarktplatzList apml = new AlleProjektmarktplatzList();
			info.clear();
			info.add(apml);
		}
	}

	private class PMErstellenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			ProjektmarktplatzAnlegen pma = new ProjektmarktplatzAnlegen();
			info.clear();
			info.add(pma);
		}
	}

	private class ReportClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			Window.open(GWT.getHostPageBaseURL() + "ProjektmarktplatzProjektReport.html", "_self", "enable");
		}

		}
	
//	private class CheckUser implements AsyncCallback<Organisationseinheit>{
//
//		Organisationseinheit org;
//		public CheckUser() {
//			// TODO Auto-generated constructor stub
//		}
//		public CheckUser(Organisationseinheit org) {
//			// TODO Auto-generated constructor stub
//			this.org = org;
//		}
//		@Override
//		public void onFailure(Throwable caught) {
//			// TODO Auto-generated method stub
//			Window.alert("Fehler " +caught); 
//			ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();
//			projektService.insertOrg(org, new AsyncCallback<Organisationseinheit>() {
//
//				@Override
//				public void onFailure(Throwable caught) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void onSuccess(Organisationseinheit result) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//		}
//
//		@Override
//		public void onSuccess(Organisationseinheit result) {
//			Window.alert("User existiert " + result.getEmail()); 
//			
//		}
//		
//	}
}
