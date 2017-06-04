package de.hdm.itprojekt.projektmarktplatz.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Eigenschaft;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

public interface ProjektmarktplatzAdminAsync {

	void getTest(AsyncCallback<String> callback);

	void insertOrg(Organisationseinheit org, AsyncCallback<Organisationseinheit> callback);

	void updateOrg(Organisationseinheit org, AsyncCallback<Organisationseinheit> callback);

	void readByIdOrg(Organisationseinheit org, AsyncCallback<Organisationseinheit> callback);

	void readAllOrg(AsyncCallback<ArrayList<Organisationseinheit>> callback);

	void deleteOrg(Organisationseinheit org, AsyncCallback<Void> callback);
	

	void insertAusschreibung(Ausschreibung a, AsyncCallback<Ausschreibung> callback);

	void updateAusschreibung(Ausschreibung a, AsyncCallback<Ausschreibung> callback);

	void readByIdAusschreibung(Ausschreibung a, AsyncCallback<Ausschreibung> callback);

	void readAllAusschreibung(AsyncCallback<ArrayList<Ausschreibung>> callback);

	void deleteAusschreibung(Ausschreibung a, AsyncCallback<Void> callback);
	

	void insertBewerbung(Bewerbung b, AsyncCallback<Bewerbung> callback);

	void updateBewerbung(Bewerbung b, AsyncCallback<Bewerbung> callback);

	void readByIdBewerbung(Bewerbung b, AsyncCallback<Bewerbung> callback);

	void readAllBewerbung(AsyncCallback<ArrayList<Bewerbung>> callback);

	void deleteBewerbung(Bewerbung b, AsyncCallback<Void> callback);
	

	void insertBewertung(Bewertung bt, AsyncCallback<Bewertung> callback);

	void updateBewertung(Bewertung bt, AsyncCallback<Bewertung> callback);

	void readAllBewertung(AsyncCallback<ArrayList<Bewertung>> callback);

	void readByIdBewertung(Bewertung bt, AsyncCallback<Bewertung> callback);

	void deleteBewertung(Bewertung bt, AsyncCallback<Void> callback);
	

	void insertEigenschaft(Eigenschaft eg, AsyncCallback<Eigenschaft> callback);

	void updateEigenschaft(Eigenschaft eg, AsyncCallback<Eigenschaft> callback);

	void readByIdEigenschaft(Eigenschaft eg, AsyncCallback<Eigenschaft> callback);

	void readAllEigenschaft(AsyncCallback<ArrayList<Eigenschaft>> callback);

	void deleteEigenschaft(Eigenschaft eg, AsyncCallback<Void> callback);
	

	void insertPartnerprofil(Partnerprofil pp, AsyncCallback<Partnerprofil> callback);

	void updatePartnerprofil(Partnerprofil pp, AsyncCallback<Partnerprofil> callback);

	void readAllPartnerprofil(AsyncCallback<ArrayList<Partnerprofil>> callback);

	void readByIdPartnerprofil(Partnerprofil pp, AsyncCallback<Partnerprofil> callback);

	void deletePartnerprofil(Partnerprofil pp, AsyncCallback<Void> callback);



}
