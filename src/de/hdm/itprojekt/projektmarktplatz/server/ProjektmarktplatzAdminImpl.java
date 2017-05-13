package de.hdm.itprojekt.projektmarktplatz.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;

public class ProjektmarktplatzAdminImpl  extends RemoteServiceServlet implements ProjektmarktplatzAdmin{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4685023405692030606L;

	public String getTest() throws IllegalArgumentException{
			
			return "TEST";
		}
	//TEST

}
