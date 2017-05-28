package de.hdm.itprojekt.projektmarktplatz.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

@RemoteServiceRelativePath("projektmarktplatzreport")
public interface ProjektmarktplatzReportAdmin extends RemoteService {

	ArrayList<Ausschreibung> getAllAusschreibung()
			throws IllegalArgumentException;

	ArrayList<Ausschreibung> getAuschreibungenByPartnerprofil(Partnerprofil p)
			throws IllegalArgumentException;

	ArrayList<Bewerbung> getBewerbungenByNutzer(Partnerprofil p)
			throws IllegalArgumentException;

	ArrayList<Bewerbung> getBewerbungenByAusschreibung(Ausschreibung a)
			throws IllegalArgumentException;

	Ausschreibung getAusschreibungByBewerbung(Bewerbung b)
			throws IllegalArgumentException;

	ArrayList<Beteiligung> getBeteiligungByNutzer(Partnerprofil p)
			throws IllegalArgumentException;

	ArrayList<Ausschreibung> getAusschreibungenByNutzer(Partnerprofil p)
			throws IllegalArgumentException;

	ArrayList<Partnerprofil> getAllPersProfile()
			throws IllegalArgumentException;

	int getAnzahlBewerbungen() throws IllegalArgumentException;

	int getAnzahlAusschreibungen() throws IllegalArgumentException;

}
