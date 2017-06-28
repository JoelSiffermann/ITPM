package de.hdm.itprojekt.projektmarktplatz.client.report;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;

public class ReportGenerator implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final ProjektmarktplatzReportAdminAsync reportService = GWT.create(ProjektmarktplatzReportAdmin.class);
	HorizontalPanel hpHeader = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();
	
	@Override
	public void onModuleLoad() {
		
		loadGUI();
		
	}

	private void loadGUI() {
//		home h = new home();
//		RootPanel.get("mainReport").add(h);
		ReportNavPanel repnav = new ReportNavPanel();
		RootPanel.get("nav").add(repnav);
	}
	
//	private class home extends VerticalPanel {
//		public void onLoad() {
//			ReportNavPanel repnav = new ReportNavPanel();
//			RootPanel.get("nav").clear();
//			RootPanel.get("nav").add(repnav);
//			RootPanel.get("mainReport").clear();
//			RootPanel.get("header").clear();
//			RootPanel.get("header").add(hpHeader);
//			RootPanel.get("mainReport").add(hpInfo);
//		}
//	}

}
