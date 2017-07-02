package de.hdm.itprojekt.projektmarktplatz.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

@RemoteServiceRelativePath("projektmarktplatzreport")

public interface ProjektmarktplatzReportAdmin extends RemoteService {
	/**
	 *  auslesen von Alle Ausschreibungen
	 * @return 
	 * @throws IllegalArgumentException
	 */
	ArrayList<Ausschreibung> getAllAusschreibung()
			throws IllegalArgumentException;

//	ArrayList<Ausschreibung> getAuschreibungenByPartnerprofil(Partnerprofil p)
//			throws IllegalArgumentException;
	/**
	 * auslesen von Bewerbungen durch Nutzer
	 * @param o Organisationseinheit
	 * @return
	 * @throws IllegalArgumentException
	 */
	ArrayList<Bewerbung> getBewerbungenByNutzer(Organisationseinheit o)
			throws IllegalArgumentException;
	/**
	 * auslesen von Bewerbungen durch Ausschreibung
	 * @param o Organisationseinheit
	 * @return
	 * @throws IllegalArgumentException
	 */
	ArrayList<Bewerbung> getBewerbungenByAusschreibung(Organisationseinheit o)
			throws IllegalArgumentException;

//	Ausschreibung getAusschreibungByBewerbung(Bewerbung b)
//			throws IllegalArgumentException;

//	ArrayList<Beteiligung> getBeteiligungByNutzer(Organisationseinheit o)
//			throws IllegalArgumentException;
//
//	ArrayList<Ausschreibung> getAusschreibungenByNutzer(Organisationseinheit o)
//			throws IllegalArgumentException;
//
//	ArrayList<Organisationseinheit> getAllPersProfile()
//			throws IllegalArgumentException;

//	int getAnzahlBewerbungen(Organisationseinheit o) throws IllegalArgumentException;
//
//	int getAnzahlAusschreibungen(Projekt p) throws IllegalArgumentException;
//	
//	int getAnzahlBeteiligungen(Projekt p) throws IllegalArgumentException;
	/**
	 * 
	 * @throws IllegalArgumentException
	 */
	void init() throws IllegalArgumentException;
	/**
	 * auslesen von empfangene Ausschreibungen
	 * @param o Organisationseinheit
	 * @return
	 * @throws IllegalArgumentException
	 */
	ArrayList<Ausschreibung> getEmpfAusschreibungen(Organisationseinheit o)
			throws IllegalArgumentException;
	/**
	 * auslesen von Beteiligungen durch Projektteilnehmer
	 * @param o Organisationseinheit
	 * @param p Projekt
	 * @return
	 */
	Beteiligung getBeteiligungByProjektteilnehmer(Organisationseinheit o,
			Projekt p);
	/**
	 * auslesen von Organisationseinheit
	 * @param p Projekt
	 * @return
	 */
	ArrayList<Organisationseinheit> getPersonenByProjekt(Projekt p);

//	int getAnzahlBeteiligungen(Organisationseinheit o)
//			throws IllegalArgumentException;
	/**
	 * auslesen von fan analyse
	 * @return
	 * @throws IllegalArgumentException
	 */
	ArrayList<String> getFanAnalyse() throws IllegalArgumentException;
	/**
	 * auslesen von Projekten durch Nutzer
	 * @param o Organisationseinheit
	 * @return
	 * @throws IllegalArgumentException
	 */
	ArrayList<Projekt> getProjekteByNutzer(Organisationseinheit o)
			throws IllegalArgumentException;
	/**
	 * auslesen von Organisationseinheit durch NutzerEmail
	 * @param o Organisationseinheit
	 * @return
	 */
	Organisationseinheit getNutzerByEmail(Organisationseinheit o);
	/**
	 * auslesen von Bewerbung durch nutzer
	 * @param o Organisationseinheit
	 * @return
	 * @throws IllegalArgumentException
	 */
	ArrayList<Bewerbung> getBewerbungByNutzer(Organisationseinheit o)
			throws IllegalArgumentException;


}
