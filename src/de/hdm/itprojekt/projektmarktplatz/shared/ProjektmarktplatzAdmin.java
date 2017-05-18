package de.hdm.itprojekt.projektmarktplatz.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

@RemoteServiceRelativePath("projektmarktplatz")
public interface ProjektmarktplatzAdmin extends RemoteService {

	public String getTest() throws IllegalArgumentException;
	public Ausschreibung speichern() throws IllegalArgumentException;
	public Organisationseinheit insert() throws IllegalArgumentException;
	
}
