package de.hdm.itprojekt.projektmarktplatz.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public interface ProjektmarktplatzReportAdminAsync {

	void getAllAusschreibung(AsyncCallback<ArrayList<Ausschreibung>> callback);

	void getAllPersProfile(AsyncCallback<ArrayList<Organisationseinheit>> callback);

	void getAnzahlAusschreibungen(Projekt p, AsyncCallback<Integer> callback);

	void getAnzahlBewerbungen(Organisationseinheit o, AsyncCallback<Integer> callback);

	void getAuschreibungenByPartnerprofil(Partnerprofil p,
			AsyncCallback<ArrayList<Ausschreibung>> callback);

	void getAusschreibungByBewerbung(Bewerbung b,
			AsyncCallback<Ausschreibung> callback);

	void getAusschreibungenByNutzer(Organisationseinheit o,
			AsyncCallback<ArrayList<Ausschreibung>> callback);

	void getBeteiligungByNutzer(Organisationseinheit o,
			AsyncCallback<ArrayList<Beteiligung>> callback);

	void getBewerbungenByAusschreibung(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);

	void getBewerbungenByNutzer(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);

	void getTest(AsyncCallback<String> callback);


	void init(AsyncCallback<Void> callback);

	void getEmpfAusschreibungen(Organisationseinheit o,
			AsyncCallback<ArrayList<Ausschreibung>> callback);

	void getBeteiligungByProjektteilnehmer(Organisationseinheit o, Projekt p,
			AsyncCallback<Beteiligung> callback);

	void getPersonenByProjekt(Projekt p,
			AsyncCallback<ArrayList<Organisationseinheit>> callback);

	void getAnzahlBeteiligungen(Projekt p, AsyncCallback<Integer> callback);


}
