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

@RemoteServiceRelativePath("projektmarktplatz")
public interface ProjektmarktplatzAdmin extends RemoteService {

	public String getTest() throws IllegalArgumentException;

	public Organisationseinheit insertOrg(Organisationseinheit org) throws IllegalArgumentException;
	public Organisationseinheit updateOrg(Organisationseinheit org ) throws IllegalArgumentException;
	public Organisationseinheit readByIdOrg(Organisationseinheit org ) throws IllegalArgumentException;
	public ArrayList<Organisationseinheit> readAllOrg() throws IllegalArgumentException;
	public void deleteOrg(Organisationseinheit org) throws IllegalArgumentException;
	

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
	
	public Bewertung insertBewertung (Bewertung bt) throws IllegalArgumentException;
	public Bewertung updateBewertung (Bewertung bt) throws IllegalArgumentException;
	public Bewertung readByIdBewertung (Bewertung bt) throws IllegalArgumentException;
	public ArrayList <Bewertung> readAllBewertung() throws IllegalArgumentException;
	public void deleteBewertung (Bewertung bt) throws IllegalArgumentException;
	
	public Eigenschaft insertEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	public Eigenschaft updateEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	public Eigenschaft readByIdEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	public ArrayList <Eigenschaft> readAllEigenschaft() throws IllegalArgumentException;
	public void deleteEigenschaft (Eigenschaft eg) throws IllegalArgumentException;
	
	public Partnerprofil insertPartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	public Partnerprofil updatePartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	public Partnerprofil readByIdPartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
	public ArrayList <Partnerprofil> readAllPartnerprofil() throws IllegalArgumentException;
	public void deletePartnerprofil (Partnerprofil pp) throws IllegalArgumentException;
}
