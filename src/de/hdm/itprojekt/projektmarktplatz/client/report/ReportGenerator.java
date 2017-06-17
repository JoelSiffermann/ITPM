package de.hdm.itprojekt.projektmarktplatz.client.report;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;

public class ReportGenerator implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final ProjektmarktplatzReportAdminAsync reportService = GWT.create(ProjektmarktplatzReportAdmin.class);
	
	@Override
	public void onModuleLoad() {
		
		loadGUI();
		
	}

	private void loadGUI() {
		ReportNavPanel repnav = new ReportNavPanel();
		RootPanel.get("mainReport").add(repnav);
	}

}
