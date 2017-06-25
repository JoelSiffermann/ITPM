package de.hdm.itprojekt.projektmarktplatz.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

public interface ProjektmarktplatzReportAdminAsync {

	void getAllAusschreibung(AsyncCallback<ArrayList<Ausschreibung>> callback);

	void getAllPersProfile(AsyncCallback<ArrayList<Partnerprofil>> callback);

	void getAnzahlAusschreibungen(AsyncCallback<Integer> callback);

	void getAnzahlBewerbungen(AsyncCallback<Integer> callback);

	void getAuschreibungenByPartnerprofil(Partnerprofil p,
			AsyncCallback<ArrayList<Ausschreibung>> callback);

	void getAusschreibungByBewerbung(Bewerbung b,
			AsyncCallback<Ausschreibung> callback);

	void getAusschreibungenByNutzer(Organisationseinheit o,
			AsyncCallback<ArrayList<Ausschreibung>> callback);

	void getBeteiligungByNutzer(Partnerprofil p,
			AsyncCallback<ArrayList<Beteiligung>> callback);

	void getBewerbungenByAusschreibung(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);

	void getBewerbungenByNutzer(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);

	void getTest(AsyncCallback<String> callback);

	void getEmpfAusschreibungen(Organisationseinheit o,
			AsyncCallback<ArrayList<Ausschreibung>> callback);

}
