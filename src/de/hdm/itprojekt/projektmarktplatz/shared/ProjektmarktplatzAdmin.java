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

	public Organisationseinheit insertOrg(Organisationseinheit org) throws IllegalArgumentException;
	public Organisationseinheit updateOrg(Organisationseinheit org ) throws IllegalArgumentException;
	public Organisationseinheit readByIdOrg(Organisationseinheit org ) throws IllegalArgumentException;
	public ArrayList<Organisationseinheit> readAllOrg() throws IllegalArgumentException;
	public void deleteOrg(Organisationseinheit org) throws IllegalArgumentException;
	public Organisationseinheit readByEmail(Organisationseinheit o);

	public Ausschreibung insertAusschreibung(Ausschreibung a) throws IllegalArgumentException;
	public Ausschreibung updateAusschreibung (Ausschreibung a) throws IllegalArgumentException;
	public Ausschreibung readByIdAusschreibung (Ausschreibung a) throws IllegalArgumentException;
	public ArrayList<Ausschreibung> readAllAusschreibung () throws IllegalArgumentException;
	public void deleteAusschreibung(Ausschreibung a) throws IllegalArgumentException;
	
	public Bewerbung insertBewerbung(Bewerbung b) throws IllegalArgumentException;
	public Bewerbung updateBewerbung (Bewerbung b) throws IllegalArgumentException;
	public Bewerbung readByIdBewerbung (Bewerbung b) throws IllegalArgumentException;
	public ArrayList <Bewerbung> readAllBewerbung() throws IllegalArgumentException;
	public void deleteBewerbung (Bewerbung b) throws IllegalArgumentException;
	
	public Bewertung insertBewertung (Bewertung bt, String id) throws IllegalArgumentException;
	public Bewertung updateBewertung (Bewertung bt) throws IllegalArgumentException;
	public Bewertung readByIdBewertung (Bewertung bt) throws IllegalArgumentException;
	public ArrayList <Bewertung> readAllBewertung() throws IllegalArgumentException;
	public void deleteBewertung (Bewertung bt) throws IllegalArgumentException;
	public ArrayList<Bewerbung> readAllBewerbungByAusschreibungId(String id) throws IllegalArgumentException;
	
	public Eigenschaft insertEigenschaft (ArrayList<Eigenschaft> eg) throws IllegalArgumentException;
	public Eigenschaft updateEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	public Eigenschaft readByIdEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	public ArrayList <Eigenschaft> readAllEigenschaft() throws IllegalArgumentException;
	public void deleteEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	public ArrayList<Eigenschaft> readAllEigenschaft(Partnerprofil p) throws IllegalArgumentException;
	
	public Partnerprofil insertPartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	public Partnerprofil updatePartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	public Partnerprofil readByIdPartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	public ArrayList <Partnerprofil> readAllPartnerprofil() throws IllegalArgumentException;
	public void deletePartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	
	public Person insertPerson (Person pers) throws IllegalArgumentException;
	public Person updatePerson (Person pers) throws IllegalArgumentException;
	public Person readByIdPerson (Person pers) throws IllegalArgumentException;
	public ArrayList <Person> readAllPerson() throws IllegalArgumentException;
	public void deletePerson (Person pers) throws IllegalArgumentException;
	
	public ArrayList<String> readUserByOrg(Organisationseinheit o);


	public Beteiligung insertBeteiligung(Beteiligung projBet ) throws IllegalArgumentException;
	public Beteiligung updateBeteiligung (Beteiligung projBet) throws IllegalArgumentException;
	public Beteiligung readByIdBeteiligung(Beteiligung projBet) throws IllegalArgumentException;
	public ArrayList<Beteiligung> readAllBeteiligung() throws IllegalArgumentException;
	public void deleteBeteiligung (Beteiligung projBet) throws IllegalArgumentException;
	
	
	public Projekt insertProjekt(Projekt proj ) throws IllegalArgumentException;
	public Projekt updateProjekt (Projekt proj) throws IllegalArgumentException;
	public Projekt readByIdProjekt(Projekt proj) throws IllegalArgumentException;
	public ArrayList<Projekt> readAllProjekt() throws IllegalArgumentException;
	public void deleteProjekt (Projekt proj) throws IllegalArgumentException;
	
	
	public Projektmarktplatz insertProjektmarktplatz(Projektmarktplatz projMark ) throws IllegalArgumentException;
	public Projektmarktplatz updateProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException;
	public Projektmarktplatz readByIdProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException;
	public ArrayList<Projektmarktplatz> readAllProjektmarktplatz() throws IllegalArgumentException;
	public void deleteProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException;
	public ArrayList<Projektmarktplatz> readAllProjektmarktplatzByOrg(Organisationseinheit o) throws IllegalArgumentException;
	public ArrayList<Projekt>  readByIdProjektProjektmarktplatz(Projektmarktplatz proj) throws IllegalArgumentException;	
	
	public Team insertTeam(Team t) throws IllegalArgumentException;
	public Team updateTeam(Team t) throws IllegalArgumentException;
	public Team readByIdTeam(Team t) throws IllegalArgumentException;
	public ArrayList<Team> readAllTeam() throws IllegalArgumentException;
	public void deleteTeam(Team t) throws IllegalArgumentException;
	
	public Unternehmen insertUnternehmen(Unternehmen u) throws IllegalArgumentException;
	public Unternehmen updateUnternehmen(Unternehmen u) throws IllegalArgumentException;
	public Unternehmen readByIdUnternehmen(Unternehmen u) throws IllegalArgumentException;
	public ArrayList<Unternehmen> readAllUnternehmen() throws IllegalArgumentException;
	public void deleteUnternehmen(Unternehmen u) throws IllegalArgumentException;

	Eigenschaft getGesuchtesProf(Partnerprofil p)
			throws IllegalArgumentException;

	Partnerprofil getProfilbyAusschreibung(Ausschreibung a)
			throws IllegalArgumentException;

	ArrayList<Beteiligung> getBeteiligungBy(Projekt p)
			throws IllegalArgumentException;
	
}
