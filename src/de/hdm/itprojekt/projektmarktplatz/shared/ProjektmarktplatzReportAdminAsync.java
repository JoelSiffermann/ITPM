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
	/**
	 * auslesen von allen Ausschreibungen
	 * @param callback Ausschreibung
	 */
	void getAllAusschreibung(AsyncCallback<ArrayList<Ausschreibung>> callback);

//	void getAllPersProfile(AsyncCallback<ArrayList<Organisationseinheit>> callback);
//
//	void getAnzahlAusschreibungen(Projekt p, AsyncCallback<Integer> callback);
//
//	void getAnzahlBewerbungen(Organisationseinheit o, AsyncCallback<Integer> callback);
//
//	void getAuschreibungenByPartnerprofil(Partnerprofil p,
//			AsyncCallback<ArrayList<Ausschreibung>> callback);
//
//	void getAusschreibungByBewerbung(Bewerbung b,
//			AsyncCallback<Ausschreibung> callback);
//
//	void getAusschreibungenByNutzer(Organisationseinheit o,
//			AsyncCallback<ArrayList<Ausschreibung>> callback);
//
//	void getBeteiligungByNutzer(Organisationseinheit o,
//			AsyncCallback<ArrayList<Beteiligung>> callback);

	//
	/**
	 * auslesen von bewerbungen durch ausschreibung
	 * @param o Organisationseinheit
	 * @param callback Bewerbung
	 */
	void getBewerbungenByAusschreibung(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);

	//
	/**
	 * auslesen von Bewerbungen durch Nutzer
	 * @param o Organisationseinheit
	 * @param callback Bewerbung
	 */
	void getBewerbungenByNutzer(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);
	
	//
	/**
	 * 
	 * @param callback void
	 */
	void init(AsyncCallback<Void> callback);

	//
	/**
	 * auslesen von empfangene Ausschreibungen
	 * @param o Organisationseinheit
	 * @param callback Ausschreibung
	 */
	void getEmpfAusschreibungen(Organisationseinheit o,
			AsyncCallback<ArrayList<Ausschreibung>> callback);

	//
	/**
	 * auslesen von Beteiligungen durch Projektteilnehmer
	 * @param o Organisationseinheit
	 * @param p Projekt
	 * @param callback Beteiligung
	 */
	void getBeteiligungByProjektteilnehmer(Organisationseinheit o, Projekt p,
			AsyncCallback<Beteiligung> callback);

	//
	/**
	 * auslesen von personen anhand von Projekt
	 * @param p Projekt
	 * @param callback Organisationseinheit
	 */
	void getPersonenByProjekt(Projekt p,
			AsyncCallback<ArrayList<Organisationseinheit>> callback);

//	void getAnzahlBeteiligungen(Projekt p, AsyncCallback<Integer> callback);
//
//	void getAnzahlBeteiligungen(Organisationseinheit o,
//			AsyncCallback<Integer> callback);

	//
	/**
	 * auslesen von fan analyse
	 * @param callback String
	 */
	void getFanAnalyse(AsyncCallback<ArrayList<String>> callback);

	//
	/**
	 * auslesen von Projekte anhand von Nutzer
	 * @param o Organisationseinheit
	 * @param callback Projekt
	 */
	void getProjekteByNutzer(Organisationseinheit o,
			AsyncCallback<ArrayList<Projekt>> callback);
	/**
	 * auslesen von Nutzer anhand der Email
	 * @param o Organisationseinheit
	 * @param callback Organisationseinheit
	 */
	void getNutzerByEmail(Organisationseinheit o,
			AsyncCallback<Organisationseinheit> callback);
	/**
	 * auslesen von Bewerbunge anhand von Nutzer
	 * @param o Organisationseinheit
	 * @param callback Bewerbung
	 */
	void getBewerbungByNutzer(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);

}
