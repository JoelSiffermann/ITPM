package de.hdm.itprojekt.projektmarktplatz.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("projektmarktplatz")
public interface ProjektmarktplatzAdmin extends RemoteService {

	public String getTest() throws IllegalArgumentException;
	
}
