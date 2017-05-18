package de.hdm.itprojekt.projektmarktplatz.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

public interface ProjektmarktplatzAdminAsync {

	void getTest(AsyncCallback<String> callback);

	void speichern(AsyncCallback<Ausschreibung> callback);

	void insert(AsyncCallback<Organisationseinheit> callback);

}
