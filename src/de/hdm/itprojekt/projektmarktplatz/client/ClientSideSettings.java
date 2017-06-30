package de.hdm.itprojekt.projektmarktplatz.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.hdm.itprojekt.projektmarktplatz.shared.CommonSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdminAsync;


/**
 * Klasse mit Eigenschaften und Diensten, die für alle Client-seitigen Klassen
 * relevant sind.
 * 
 * @author thies
 * @version 1.0
 * @since 28.02.2012
 * 
 */

public class ClientSideSettings extends CommonSettings{

	  private static ProjektmarktplatzAdminAsync projektService = null;

	  private static ProjektmarktplatzReportAdminAsync reportService = null;
	  
	  private static final String LOGGER_NAME = "Projektmarktplatz Web Client";
	  
	  private static final Logger log = Logger.getLogger(LOGGER_NAME);

	  public static Logger getLogger() {
		    return log;
		  }
	  
	  public static ProjektmarktplatzAdminAsync getProjektmarktplatzVerwaltung() {
		    // Gab es bislang noch keine PMAdministration-Instanz, dann...
		    if (projektService == null) {
		      // Zunächst instantiieren wir BankAdministration
		    	projektService = GWT.create(ProjektmarktplatzAdmin.class);
		    }
		    return projektService;
	  }
	  
	  public static ProjektmarktplatzReportAdminAsync getReportGenerator() {
		    // Gab es bislang noch keine ReportGenerator-Instanz, dann...
		    if (reportService == null) {
		      // Zunächst instantiieren wir ReportGenerator
		    	reportService = GWT.create(ProjektmarktplatzReportAdmin.class);

//		      final AsyncCallback<Void> initReportGeneratorCallback = new AsyncCallback<Void>() {
//		        @Override
//				public void onFailure(Throwable caught) {
//		          ClientSideSettings.getLogger().severe(
//		              "Der ReportGenerator konnte nicht initialisiert werden!");
//		        }
//
//		        @Override
//				public void onSuccess(Void result) {
//		          ClientSideSettings.getLogger().info(
//		              "Der ReportGenerator wurde initialisiert.");
//		        }
//		      };
//
//		      reportService.init(initReportGeneratorCallback);
		    }

		    // So, nun brauchen wir den ReportGenerator nur noch zurückzugeben.
		    return reportService;
		  }


	  
	  
	  
	  
	  
}
