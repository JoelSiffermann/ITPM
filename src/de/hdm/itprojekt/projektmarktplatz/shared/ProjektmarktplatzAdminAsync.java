package de.hdm.itprojekt.projektmarktplatz.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Eigenschaft;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Team;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Unternehmen;
/**
 * 
 * @author samina
 *
 */
public interface ProjektmarktplatzAdminAsync {

	void getTest(AsyncCallback<String> callback);
	/**
	 * einf�gen von Organisationseinheit
	 * @param org Organisationseinheit
	 * @param callback Organisationseinheit
	 */

	void insertOrg(Organisationseinheit org, AsyncCallback<Organisationseinheit> callback);

	void updateOrg(Organisationseinheit org,
			AsyncCallback<Organisationseinheit> callback);
	
//	void updateOrg2(Organisationseinheit org, Team t, Person p, Unternehmen u,
//			AsyncCallback<Organisationseinheit> callback);


	/**
	 * speichern von Organisationseinheit
	 * @param org Organisationseinheit
	 * @param callback Organisationseinheit
	 */
//	void updateOrg(Organisationseinheit org, AsyncCallback<Organisationseinheit> callback);
	/**
	 * auslesen von OrganisationseinheitID
	 * @param org Organisationseinheit
	 * @param callback Organisationseinheit
	 */

	void readByIdOrg(Organisationseinheit org, AsyncCallback<Organisationseinheit> callback);
	/**
	 * auslesen von allen Organisationseinheiten
	 * @param callback Organisationseinheit
	 */
	void readAllOrg(AsyncCallback<ArrayList<Organisationseinheit>> callback);
	/**
	 * l�schen von Organisationseinheit
	 * @param org Organisationseinheit
	 * @param callback
	 */
	void deleteOrg(Organisationseinheit org, AsyncCallback<Void> callback);
	/**
	 * einf�gen von Ausschreibung
	 * @param a Ausschreibung
	 * @param callback Ausschreibung
	 */
	void insertAusschreibung(Ausschreibung a, AsyncCallback<Ausschreibung> callback);
	/**
	 * speichern von Ausschreibung
	 * @param a Ausschreibung
	 * @param callback Ausschreibung
	 */
	void updateAusschreibung(Ausschreibung a, AsyncCallback<Ausschreibung> callback);
	/**
	 * auslesen von AusschreibungID
	 * @param a Ausschreibung
	 * @param callback Ausschreibung
	 */
	void readByIdAusschreibung(Ausschreibung a, AsyncCallback<Ausschreibung> callback);
	/**
	 * auslesen von allen Ausschreibungen
	 * @param callback Ausschreibung
	 */
	void readAllAusschreibung(AsyncCallback<ArrayList<Ausschreibung>> callback);
	/**
	 * l�schen von Ausschreibung
	 * @param a Ausschreibung
	 * @param callback Ausschreibung
	 */
	void deleteAusschreibung(Ausschreibung a, AsyncCallback<Void> callback);
	/**
	 * anlegen von Bewerbung
	 * @param b Bewerbung
	 * @param callback Bewerbung
	 */
	void insertBewerbung(Bewerbung b, AsyncCallback<Bewerbung> callback);
	/**
	 * speichern von Bewerbung
	 * @param b Bewerbung
	 * @param callback Bewerbung
	 */
	void updateBewerbung(Bewerbung b, AsyncCallback<Bewerbung> callback);
	/**
	 * auslesen von BewerbungID
	 * @param b Bewerbung
	 * @param callback Bewerbung
	 */
	void readByIdBewerbung(Bewerbung b, AsyncCallback<Bewerbung> callback);
	/**
	 * alle Bewerbungen auslesen
	 * @param callback Bewerbung
	 */
	void readAllBewerbung(AsyncCallback<ArrayList<Bewerbung>> callback);
	/**
	 * l�schen von Bewerbung
	 * @param b Bewerbung
	 * @param callback Bewerbung
	 */
	void deleteBewerbung(Bewerbung b, AsyncCallback<Void> callback);

	

	void insertBewertung(Bewertung bt, AsyncCallback<Bewertung> callback);


	/**
	 * anlegen von Bewertung
	 * @param bt Bewertung
	 * @param id String
	 * @param callback Bewertung
	 */
//	void insertBewertung(Bewertung bt, String id, AsyncCallback<Bewertung> callback);
	/**
	 * speichern von Bewertung
	 * @param bt Bewertung
	 * @param callback Bewertung
	 */

	void updateBewertung(Bewertung bt, AsyncCallback<Bewertung> callback);
	/**
	 * alle Bewertungen auslesen
	 * @param callback Bewertung
	 */
	void readAllBewertung(AsyncCallback<ArrayList<Bewertung>> callback);
	/**
	 * auslesen von BewertungID
	 * @param bt Bewertung
	 * @param callback Bewertung
	 */
	void readByIdBewertung(Bewertung bt, AsyncCallback<Bewertung> callback);
	/**
	 * l�schen von Bewertung
	 * @param bt Bewertung
	 * @param callback Bewertung
	 */
	void deleteBewertung(Bewertung bt, AsyncCallback<Void> callback);
	/**
	 * anlegen von Eigenschaft
	 * @param eg Eigenschaft
	 * @param callback Eigenschaft
	 */
	void insertEigenschaft(ArrayList<Eigenschaft> eg, AsyncCallback<Eigenschaft> callback);
	/**
	 * speichern von Eigenschaft
	 * @param eg Eigenschaft
	 * @param callback Eigenschaft
	 */
	void updateEigenschaft(Eigenschaft eg, AsyncCallback<Eigenschaft> callback);
	/**
	 * auslesen von EigenschaftID
	 * @param eg Eigenschaft
	 * @param callback Eigenschaft
	 */
	void readByIdEigenschaft(Eigenschaft eg, AsyncCallback<Eigenschaft> callback);
	/**
	 * alle Eigenschaften auslesen
	 * @param p Partnerprofil
	 * @param callback Eigenschaft
	 */
	void readAllEigenschaft(Partnerprofil p, AsyncCallback<ArrayList<Eigenschaft>> callback);
	/**
	 * l�schen von Eigenschaft
	 * @param eg Eigenschaft
	 * @param callback Eigenschaft
	 */
	void deleteEigenschaft(Eigenschaft eg, AsyncCallback<Void> callback);
	/**
	 * anlegen von Partnerprofil
	 * @param pp Partnerprofil
	 * @param callback Partnerprofil
	 */
	void insertPartnerprofil(Partnerprofil pp, AsyncCallback<Partnerprofil> callback);
	/**
	 * speichern von Partnerprofil
	 * @param pp Partnerprofil
	 * @param callback Partnerprofil
	 */
	void updatePartnerprofil(Partnerprofil pp, AsyncCallback<Partnerprofil> callback);
	/**
	 * auslesen von allen Partnerprofilen
	 * @param callback Partnerprofil
	 */
	void readAllPartnerprofil(AsyncCallback<ArrayList<Partnerprofil>> callback);
	/**
	 * auslesen von PartnerprofilID
	 * @param pp Partnerprofil
	 * @param callback Partnerprofil
	 */
	void readByIdPartnerprofil(Partnerprofil pp, AsyncCallback<Partnerprofil> callback);
	/**
	 * l�schen von Partnerprofil
	 * @param pp Partnerprofil
	 * @param callback Partnerprofil
	 */
	void deletePartnerprofil(Partnerprofil pp, AsyncCallback<Void> callback);
	/**
	 * anlegen von Beteiligung
	 * @param projBet Beteiligung
	 * @param callback Beteiligung
	 */
	void insertBeteiligung(Beteiligung projBet,AsyncCallback<Beteiligung> callback );
	/**
	 * speichern Beteiligung
	 * @param projBet Beteiligung
	 * @param callback Beteiligung
	 */
	void updateBeteiligung (Beteiligung projBet,AsyncCallback<Beteiligung> callback );
	/**Beteiligung
	 * auslesen on BeteiligungID
	 * @param projBet Beteiligung
	 * @param callback Beteiligung
	 */
	void readByIdBeteiligung(Beteiligung projBet,AsyncCallback<Beteiligung> callback);
	/**
	 * alle Beteiligungen auslesen
	 * @param callback Beteiligung
	 */
	void readAllBeteiligung(AsyncCallback<ArrayList<Beteiligung>> callback);
	/**
	 * l�schen von Beteiligungen
	 * @param projBet Beteiligung
	 * @param callback Beteiligung
	 */
	void deleteBeteiligung (Beteiligung projBet,AsyncCallback<Void> callback );
	
	/**
	 * anlegen von Projekt
	 * @param proj Projekt
	 * @param callback Projekt
	 */
	void insertProjekt(Projekt proj,AsyncCallback<Projekt> callback );
	/**
	 * speichern von Projekt
	 * @param proj Projekt
	 * @param callback Projekt
	 */
	void updateProjekt (Projekt proj,AsyncCallback<Projekt> callback );
	/**
	 * auslesen von ProjektID
	 * @param proj Projekt
	 * @param callback Projekt
	 */
	void readByIdProjekt(Projekt proj,AsyncCallback<Projekt> callback);
	/**
	 * auslesen von allen Projekten
	 * @param callback Projekt
	 */
	void readAllProjekt(AsyncCallback<ArrayList<Projekt>> callback);
	/**
	 * l�schen von Projekt
	 * @param proj Projekt
	 * @param callback Projekt
	 */
	void deleteProjekt (Projekt proj,AsyncCallback<Void> callback );
	
	/**
	 * anlegen von Projektmarktplatz
	 * @param projMark Projektmarktplatz
	 * @param callback Projektmarktplatz
	 */
	void insertProjektmarktplatz(Projektmarktplatz projMark,AsyncCallback<Projektmarktplatz> callback );
	/**
	 * speichern von Projektmarktplatz
	 * @param projMark Projektmarktplatz
	 * @param callback Projektmarktplatz
	 */
	void updateProjektmarktplatz (Projektmarktplatz projMark,AsyncCallback<Projektmarktplatz> callback );
	/**
	 * auslesen von ProjektmarktplatzID
	 * @param projMark Projektmarktplatz
	 * @param callback Projektmarktplatz
	 */
	void readByIdProjektmarktplatz(Projektmarktplatz projMark,AsyncCallback<Projektmarktplatz> callback);
	/**
	 * alle Projektmarktplaetze auslesen
	 * @param callback Projektmarktplatz
	 */
	void readAllProjektmarktplatz(AsyncCallback<ArrayList<Projektmarktplatz>> callback);
	/**
	 * l�schen von Projektmarktplatz
	 * @param projMark Projektmarktplatz
	 * @param callback Projektmarktplatz
	 */
	void deleteProjektmarktplatz (Projektmarktplatz projMark,AsyncCallback<Void> callback );
	
	
	/**
	 * anlegen von Team
	 * @param t Team
	 * @param callback Team
	 */
	void insertTeam(Team t,AsyncCallback<Team> callback );
	/**
	 * speichern von Team
	 * @param t Team
	 * @param callback Team
	 */
	void updateTeam(Team t,AsyncCallback<Team> callback );
	/**
	 * auslesen von TeamID
	 * @param t Team
	 * @param callback Team
	 */
	void readByIdTeam( Team t,AsyncCallback<Team> callback);
	/**
	 * auslesen von allen Teams
	 * @param callback Team
	 */
	void readAllTeam(AsyncCallback<ArrayList<Team>> callback);
	/**
	 * l�schen von Team
	 * @param t Team
	 * @param callback Team
	 */
	void deleteTeam(Team t,AsyncCallback<Void> callback );
	
	/**
	 * anlegen von Unternehmen
	 * @param u Unternehmen
	 * @param callback Unternehmen
	 */
	void insertUnternehmen(Unternehmen u,AsyncCallback<Unternehmen> callback );
	/**
	 * speichern von Unternehmen
	 * @param u Unternehmen
	 * @param callback Unternehmen
	 */
	void updateUnternehmen(Unternehmen u,AsyncCallback<Unternehmen> callback );
	/**
	 * auslesen von UnternehmenID
	 * @param u Unternehmen
	 * @param callback Unternehmen
	 */
	void readByIdUnternehmen( Unternehmen u,AsyncCallback<Unternehmen> callback);
	/**
	 * auslesen von allen Unternehmen
	 * @param callback Unternehmen
	 */
	void readAllUnternehmen(AsyncCallback<ArrayList<Unternehmen>> callback);
	/**
	 * l�schen von Unternehmen
	 * @param u Unternehmen
	 * @param callback Unternehmen
	 */
	void deleteUnternehmen(Unternehmen u,AsyncCallback<Void> callback );
	/**
	 * l�schen von Person
	 * @param pers Person
	 * @param callback Person
	 */
	void deletePerson(Person pers, AsyncCallback<Void> callback);
	/**
	 * anlegen von Person
	 * @param pers Person
	 * @param callback Person
	 */
	void insertPerson(Person pers, AsyncCallback<Person> callback);
	/**
	 * auslesen von Allen Personen
	 * @param callback Person
	 */
	void readAllPerson(AsyncCallback<ArrayList<Person>> callback);
	/**
	 * auslesen von PersonID
	 * @param pers Person
	 * @param callback Person
	 */
	void readByIdPerson(Person pers, AsyncCallback<Person> callback);
	/**
	 * speichern von Person
	 * @param pers Person
	 * @param callback Person
	 */
	void updatePerson(Person pers, AsyncCallback<Person> callback);


	void readAllBewerbungByAusschreibung(Ausschreibung a, AsyncCallback<ArrayList<Bewerbung>> callback);


	/**
	 * auslesen von allen Bewerbungen
	 * @param id String
	 * @param callback Bewerbung
	 */
//	void readAllBewerbungByAusschreibungId(String id, AsyncCallback<ArrayList<Bewerbung>> callback);
	/**
	 * auslesen von Email aus Organisationseinheit
	 * @param o Organisationseinheit
	 * @param callback Organisationseinheit
	 */

	void readByEmail(Organisationseinheit o, AsyncCallback<Organisationseinheit> callback);
	/**
	 * alle Projektmarktpl�tze anhand der Organiosationseiheit auslesen
	 * @param o Organisationseinheit
	 * @param callback Projektmarktplatz
	 */
	void readAllProjektmarktplatzByOrg(Organisationseinheit o, AsyncCallback<ArrayList<Projektmarktplatz>> callback);
	/**
	 * auslesen von ProjektID Projektmarktplatz
	 * @param proj Projektmarktplatz
	 * @param callback Projekt
	 */
	void readByIdProjektProjektmarktplatz(Projektmarktplatz proj, AsyncCallback<ArrayList<Projekt>> callback);
	/**
	 * alle Eigenschaften auslesen
	 * @param callback Eigenschaften
	 */
	void readAllEigenschaft(AsyncCallback<ArrayList<Eigenschaft>> callback);
	/**
	 * auslesen von User durch Organisationseinheit
	 * @param o Organisationseinheit
	 * @param callback String
	 */
	void readUserByOrg(Organisationseinheit o, AsyncCallback<ArrayList<String>> callback);
	/**
	 * gesuchtes Profil wird ausgelesen
	 * @param p Partnerprofil
	 * @param callback Eigenschaft
	 */
	void getGesuchtesProf(Partnerprofil p, AsyncCallback<Eigenschaft> callback);
	/**
	 * auslesen von Profil anhand der Ausschreibung
	 * @param a Ausschreibung
	 * @param callback Partnerprofil
	 */
	void getProfilbyAusschreibung(Ausschreibung a,
			AsyncCallback<Partnerprofil> callback);
	/**
	 * auslesen von Beteiligung
	 * @param p Projekt
	 * @param callback Beteiligung
	 */
	void getBeteiligungBy(Projekt p,
			AsyncCallback<ArrayList<Beteiligung>> callback);
	/**
	 * auslesen von Organisationseinheit anhand der Beteiligung
	 * @param b Beteiligung
	 * @param callback Organisationseinheit
	 */
	void getOrgaByBeteiligung(Beteiligung b,
			AsyncCallback<Organisationseinheit> callback);
	/**
	 * auslesen von Meine Projekte
	 * @param o Organisationseinheit
	 * @param callback Projekt
	 */
	void getMeineProjekte(Organisationseinheit o,
			AsyncCallback<ArrayList<Projekt>> callback);
	/**
	 *auslesen von andere Projekte
	 * @param o Organisationseinheit
	 * @param pm Projektmarktplatz
	 * @param callback Projekt
	 */
	void getAndereProjekte(Organisationseinheit o, Projektmarktplatz pm,
			AsyncCallback<ArrayList<Projekt>> callback);

	void getAndereProjekte(Organisationseinheit o,
			AsyncCallback<ArrayList<Projekt>> callback);

	void getEingegangeneBewerbungen(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);

	void getAusschreibungenByProjekt(Projekt p,
			AsyncCallback<ArrayList<Ausschreibung>> callback);

	void getBewertungByBewerber(Organisationseinheit o,
			AsyncCallback<Bewertung> callback);

	void getMeineBewerbung(Organisationseinheit o,
			AsyncCallback<ArrayList<Bewerbung>> callback);

	void getAusschreibungByBewerbung(Bewerbung b,
			AsyncCallback<Ausschreibung> callback);
	
	
}
