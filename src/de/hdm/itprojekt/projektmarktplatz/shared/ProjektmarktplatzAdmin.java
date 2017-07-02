package de.hdm.itprojekt.projektmarktplatz.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
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

@RemoteServiceRelativePath("projektmarktplatz")
public interface ProjektmarktplatzAdmin extends RemoteService {

	public String getTest() throws IllegalArgumentException;
	/**
	 * Organisationseinheit anlegen
	 * @param org Organisationseinheit
	 * @return Organisationseinheit
	 * @throws IllegalArgumentException
	 */
	public Organisationseinheit insertOrg(Organisationseinheit org) throws IllegalArgumentException;
	/**
	 * speichern von Organisationseinheit
	 * @param org Organisationseinheit
	 * @return Organisationseinheit
	 * @throws IllegalArgumentException
	 */
	public Organisationseinheit updateOrg(Organisationseinheit org ) throws IllegalArgumentException;
	/**
	 * lesen von OrganisationseinheitID
	 * @param org Organisationseinheit
	 * @return Organisationseinheit
	 * @throws IllegalArgumentException
	 */
	public Organisationseinheit readByIdOrg(Organisationseinheit org ) throws IllegalArgumentException;
	/**
	 * auslesen von allen Organisationseinheiten
	 * @return Organisationseinheit
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Organisationseinheit> readAllOrg() throws IllegalArgumentException;
	/**
	 * löschen von Organisationseinheit
	 * @param org Organisationseinheit
	 * @throws IllegalArgumentException
	 */
	public void deleteOrg(Organisationseinheit org) throws IllegalArgumentException;
	/**
	 * lesen von Email der Organisationseinheit
	 * @param o Organisationseinheit
	 * @return Organisationseinheit
	 */
	public Organisationseinheit readByEmail(Organisationseinheit o);
	/**
	 * Ausschreibung anlegen
	 * @param a Ausschreibung
	 * @return Ausschreibung
	 * @throws IllegalArgumentException
	 */
	public Ausschreibung insertAusschreibung(Ausschreibung a) throws IllegalArgumentException;
	/**
	 * speichern von Ausschreibung
	 * @param a Ausschreibung
	 * @return Ausschreibung
	 * @throws IllegalArgumentException
	 */
	public Ausschreibung updateAusschreibung (Ausschreibung a) throws IllegalArgumentException;
	/**
	 * lesen von AusschreibungID
	 * @param a Ausschreibung
	 * @return Ausschreibung
	 * @throws IllegalArgumentException
	 */
	public Ausschreibung readByIdAusschreibung (Ausschreibung a) throws IllegalArgumentException;
	/**
	 * lesen von allen Ausschreibungen
	 * @return Ausschreibung
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Ausschreibung> readAllAusschreibung () throws IllegalArgumentException;
	/**
	 * löschen von Ausschreibung
	 * @param a Ausschreibung
	 * @throws IllegalArgumentException
	 */
	public void deleteAusschreibung(Ausschreibung a) throws IllegalArgumentException;
	/**
	 * Bewerbung anlegen
	 * @param b Bewerbung
	 * @return Bewerbung
	 * @throws IllegalArgumentException
	 */
	public Bewerbung insertBewerbung(Bewerbung b) throws IllegalArgumentException;
	/**
	 * speichern von Bewerbung
	 * @param b Bewerbung
	 * @return Bewerbung
	 * @throws IllegalArgumentException
	 */
	public Bewerbung updateBewerbung (Bewerbung b) throws IllegalArgumentException;
	/**
	 *  lesen von BewerbungID
	 * @param b Bewerbung
	 * @return Bewerbung
	 * @throws IllegalArgumentException
	 */
	public Bewerbung readByIdBewerbung (Bewerbung b) throws IllegalArgumentException;
	/**
	 * lesen von allen Bewerbungen
	 * @return Bewerbung
	 * @throws IllegalArgumentException
	 */
	public ArrayList <Bewerbung> readAllBewerbung() throws IllegalArgumentException;
	/**
	 * löschen von Bewerbung
	 * @param b Bewerbung
	 * @throws IllegalArgumentException
	 */
	public void deleteBewerbung (Bewerbung b) throws IllegalArgumentException;
	/**
	 * Bewertung anlegen
	 * @param bt Bewertung
	 * @param id String
	 * @return Bewertung
	 * @throws IllegalArgumentException
	 */
	public Bewertung insertBewertung (Bewertung bt, String id) throws IllegalArgumentException;
	/**
	 * speichern von Bewertung
	 * @param bt Bewertung
	 * @return Bewertung
	 * @throws IllegalArgumentException
	 */
	public Bewertung updateBewertung (Bewertung bt) throws IllegalArgumentException;
	/**
	 * auslesen von BewertungID
	 * @param bt Bewertung
	 * @return Bewertung
	 * @throws IllegalArgumentException
	 */
	public Bewertung readByIdBewertung (Bewertung bt) throws IllegalArgumentException;
	/**
	 * alle Bewertungen auslesen
	 * @return Bewertung
	 * @throws IllegalArgumentException
	 */
	public ArrayList <Bewertung> readAllBewertung() throws IllegalArgumentException;
	/**
	 * löschen von Bewertung
	 * @param bt Bewertung
	 * @throws IllegalArgumentException
	 */
	public void deleteBewertung (Bewertung bt) throws IllegalArgumentException;
	/**
	 * Alle Bewerbungen anhand der AusschreibungID auslesen
	 * @param id String
	 * @return Bewerbung
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Bewerbung> readAllBewerbungByAusschreibungId(String id) throws IllegalArgumentException;
	/**
	 * Eigenschaft anlegen
	 * @param eg Eigenschaft
	 * @return Eigenschaft
	 * @throws IllegalArgumentException
	 */
	public Eigenschaft insertEigenschaft (ArrayList<Eigenschaft> eg) throws IllegalArgumentException;
	/**
	 * speichern von Eigenschaft
	 * @param eg Eigenschaft
	 * @return Eigenschaft
	 * @throws IllegalArgumentException
	 */
	public Eigenschaft updateEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	/**
	 * auslesen von EigenschaftID
	 * @param eg Eigenschaft
	 * @return Eigenschaft
	 * @throws IllegalArgumentException
	 */
	public Eigenschaft readByIdEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	/**
	 * alle Eigenschaften auslesen
	 * @return Eigenschaft
	 * @throws IllegalArgumentException
	 */
	public ArrayList <Eigenschaft> readAllEigenschaft() throws IllegalArgumentException;
	/**
	 * Eigenschaft löschen
	 * @param eg Eigenschaft
	 * @throws IllegalArgumentException
	 */
	public void deleteEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	/**
	 * Alle Eigenschaften anhand der Partnerprofile auslesen
	 * @param p Partnerprofil
	 * @return Eigenschaft
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Eigenschaft> readAllEigenschaft(Partnerprofil p) throws IllegalArgumentException;
	/**
	 * Partnerprofil anlegen
	 * @param pp Partnerprofil
	 * @return Partnerprofil
	 * @throws IllegalArgumentException
	 */
	public Partnerprofil insertPartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	/**
	 * speichern von Partnerprofil
	 * @param pp Partnerprofil
	 * @return Partnerprofil
	 * @throws IllegalArgumentException
	 */
	public Partnerprofil updatePartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	/**
	 * auslesen von PartnerprofilID
	 * @param pp Partnerprofil
	 * @return Partnerprofil
	 * @throws IllegalArgumentException
	 */
	public Partnerprofil readByIdPartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	/**
	 * alle Partnerprofile auslesen
	 * @return Partnerprofil
	 * @throws IllegalArgumentException
	 */
	public ArrayList <Partnerprofil> readAllPartnerprofil() throws IllegalArgumentException;
	/**
	 * löschen von Partnerprofil
	 * @param pp Partnerprofil
	 * @throws IllegalArgumentException
	 */
	public void deletePartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	/**
	 * Person anlegen
	 * @param pers Person
	 * @return Person
	 * @throws IllegalArgumentException
	 */
	public Person insertPerson (Person pers) throws IllegalArgumentException;
	/**
	 * speichern von Person
	 * @param pers Person
	 * @return Person
	 * @throws IllegalArgumentException
	 */
	public Person updatePerson (Person pers) throws IllegalArgumentException;
	/**
	 * auslesen von PersonID
	 * @param pers Person
	 * @return Person
	 * @throws IllegalArgumentException
	 */
	public Person readByIdPerson (Person pers) throws IllegalArgumentException;
	/**
	 * alle Personen auslesen
	 * @return Person
	 * @throws IllegalArgumentException
	 */
	public ArrayList <Person> readAllPerson() throws IllegalArgumentException;
	/**
	 * löschen von Person
	 * @param pers Person
	 * @throws IllegalArgumentException
	 */
	public void deletePerson (Person pers) throws IllegalArgumentException;
	/**
	 * User auslesen
	 * @param o Organisationseinheit
	 * @return Organisarionseinheit
	 */
	public ArrayList<String> readUserByOrg(Organisationseinheit o);

	/**
	 * Beteiligung anlegen
	 * @param projBet Beteiligung
	 * @return Beteiligung
	 * @throws IllegalArgumentException
	 */
	public Beteiligung insertBeteiligung(Beteiligung projBet ) throws IllegalArgumentException;
	/**
	 * speichern von Beteiligung
	 * @param projBet Beteiligung
	 * @return Beteiligung
	 * @throws IllegalArgumentException
	 */
	public Beteiligung updateBeteiligung (Beteiligung projBet) throws IllegalArgumentException;
	/**
	 * auslesen von BeteiligungID
	 * @param projBet Beteiligung
	 * @return Beteiligung
	 * @throws IllegalArgumentException
	 */
	public Beteiligung readByIdBeteiligung(Beteiligung projBet) throws IllegalArgumentException;
	/**
	 * alle Beteiligungen auslesen
	 * @return Beteiligung
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Beteiligung> readAllBeteiligung() throws IllegalArgumentException;
	/**
	 * löschen von Beteiligung
	 * @param projBet Beteiligung
	 * @throws IllegalArgumentException
	 */
	public void deleteBeteiligung (Beteiligung projBet) throws IllegalArgumentException;
	
	/**
	 * Projekt anlegen
	 * @param proj Projekt
	 * @return Projekt
	 * @throws IllegalArgumentException
	 */
	public Projekt insertProjekt(Projekt proj ) throws IllegalArgumentException;
	/**
	 * speichern von Projekt
	 * @param proj Projekt
	 * @return Projekt
	 * @throws IllegalArgumentException
	 */
	public Projekt updateProjekt (Projekt proj) throws IllegalArgumentException;
	/**
	 * auslesen von ProjektID
	 * @param proj Projekt
	 * @return Projekt
	 * @throws IllegalArgumentException
	 */
	public Projekt readByIdProjekt(Projekt proj) throws IllegalArgumentException;
	/**
	 * auslesen von allen Projekten
	 * @return Projekt
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Projekt> readAllProjekt() throws IllegalArgumentException;
	/**
	 * löschen von Projekt
	 * @param proj Projekt
	 * @throws IllegalArgumentException
	 */
	public void deleteProjekt (Projekt proj) throws IllegalArgumentException;
	
	/**
	 * Projektmarktplatz anlegen
	 * @param projMark Projektmarktplatz
	 * @return Projektmarktplatz
	 * @throws IllegalArgumentException
	 */
	public Projektmarktplatz insertProjektmarktplatz(Projektmarktplatz projMark ) throws IllegalArgumentException;
	/**
	 * speichern von Projektmarktplatz
	 * @param projMark Projektmarktplatz
	 * @return Projektmarktplatz
	 * @throws IllegalArgumentException
	 */
	public Projektmarktplatz updateProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException;
	/**
	 * auslesen von ProjektmarktplatzID
	 * @param projMark Projektmarktplatz
	 * @return Projektmarktplatz
	 * @throws IllegalArgumentException
	 */
	public Projektmarktplatz readByIdProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException;
	/**
	 * alle Projektmarktplaetze auslesen
	 * @return Projektmarktplatz
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Projektmarktplatz> readAllProjektmarktplatz() throws IllegalArgumentException;
	/**
	 * löschen von Projektmarktplatz
	 * @param projMark Projektmarktplatz
	 * @throws IllegalArgumentException
	 */
	public void deleteProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException;
	/**
	 * alle Projektmarktplätze anhand der Organisationseinheit auslesen
	 * @param o Organisationseinheit
	 * @return Projektmarktplatz
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Projektmarktplatz> readAllProjektmarktplatzByOrg(Organisationseinheit o) throws IllegalArgumentException;
	/**
	 * auslesen von ProjektID Projektmarktplatz
	 * @param proj Projektmarktplatz
	 * @return Projektmarktplatz
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Projekt>  readByIdProjektProjektmarktplatz(Projektmarktplatz proj) throws IllegalArgumentException;	
	/**
	 * Team anlegen
	 * @param t Team
	 * @return Team
	 * @throws IllegalArgumentException
	 */
	public Team insertTeam(Team t) throws IllegalArgumentException;
	/**
	 * speichern von team
	 * @param t Team
	 * @return Team
	 * @throws IllegalArgumentException
	 */
	public Team updateTeam(Team t) throws IllegalArgumentException;
	/**
	 * auslesen von TeamID
	 * @param t Team
	 * @return Team
	 * @throws IllegalArgumentException
	 */
	public Team readByIdTeam(Team t) throws IllegalArgumentException;
	/**
	 * alle Teams auslesen
	 * @return Team
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Team> readAllTeam() throws IllegalArgumentException;
	/**
	 * Team löschen
	 * @param t Team
	 * @throws IllegalArgumentException
	 */
	public void deleteTeam(Team t) throws IllegalArgumentException;
	/**
	 * Unternehmen anlegen
	 * @param u Unternehmen
	 * @return Unternehmen
	 * @throws IllegalArgumentException
	 */
	public Unternehmen insertUnternehmen(Unternehmen u) throws IllegalArgumentException;
	/**
	 * speichern von Unternehmen
	 * @param u Unternehmen
	 * @return Unternehmen
	 * @throws IllegalArgumentException
	 */
	public Unternehmen updateUnternehmen(Unternehmen u) throws IllegalArgumentException;
	/**
	 * auslesen von UnternehmenID
	 * @param u Unternehmen
	 * @return Unternehmen
	 * @throws IllegalArgumentException
	 */
	public Unternehmen readByIdUnternehmen(Unternehmen u) throws IllegalArgumentException;
	/**
	 * alle Unternehmen auslesen
	 * @return Unternehmen
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Unternehmen> readAllUnternehmen() throws IllegalArgumentException;
	/**
	 * löschen von Unternehmen
	 * @param u Unternehmen
	 * @throws IllegalArgumentException
	 */
	public void deleteUnternehmen(Unternehmen u) throws IllegalArgumentException;
	/**
	 * gesuchtes Partnerprofil wird zurückgegeben
	 * @param p Partnerprofil
	 * @return Partnerprofil
	 * @throws IllegalArgumentException
	 */
	Eigenschaft getGesuchtesProf(Partnerprofil p)
			throws IllegalArgumentException;
	/**
	 * Ausschreibung wird zurückgegeben
	 * @param a Ausschreibung 
	 * @return Ausschreibung
	 * @throws IllegalArgumentException
	 */
	Partnerprofil getProfilbyAusschreibung(Ausschreibung a)
			throws IllegalArgumentException;
	/**
	 * Beteiligung an Projekt wird zurückgegeben
	 * @param p Projekt
	 * @return Projekt
	 * @throws IllegalArgumentException
	 */
	ArrayList<Beteiligung> getBeteiligungBy(Projekt p)
			throws IllegalArgumentException;
	/**
	 * Beteiligung wird zurückgegeben
	 * @param b Beteiligung
	 * @return Beteiligung
	 * @throws IllegalArgumentException
	 */
	Organisationseinheit getOrgaByBeteiligung(Beteiligung b)
			throws IllegalArgumentException;
	/**
	 * Projekte werden ausgelesen
	 * @param o Organisationseinheit
	 * @return Organisationseinheit
	 * @throws IllegalArgumentException
	 */
	ArrayList<Projekt> getMeineProjekte(Organisationseinheit o)
			throws IllegalArgumentException;
	/**
	 * Andere Projekte werden ausgelesen
	 * @param o Organisationseinheit
	 * @param pm Projektmarktplatz
	 * @return Projekte
	 * @throws IllegalArgumentException
	 */
	ArrayList<Projekt> getAndereProjekte(Organisationseinheit o, Projektmarktplatz pm)
			throws IllegalArgumentException;
	
}
