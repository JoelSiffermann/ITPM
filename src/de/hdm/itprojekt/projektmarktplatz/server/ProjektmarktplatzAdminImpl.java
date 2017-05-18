package de.hdm.itprojekt.projektmarktplatz.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.projektmarktplatz.server.db.AusschreibungMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.OrganisationseinheitMapper;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;

public class ProjektmarktplatzAdminImpl  extends RemoteServiceServlet implements ProjektmarktplatzAdmin{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4685023405692030606L;

	
	private AusschreibungMapper aMapper = null;
	private OrganisationseinheitMapper orgMapper = null;
	  @Override
	  public void init() throws IllegalArgumentException {
	      /*
	       * Ganz wesentlich ist, dass die BankAdministration einen vollständigen Satz
	       * von Mappern besitzt, mit deren Hilfe sie dann mit der Datenbank
	       * kommunizieren kann.
	       */
	      this.aMapper = AusschreibungMapper.ausschreibungMapper();
	      this.orgMapper = OrganisationseinheitMapper.orgMapper();
	    }
	public String getTest() throws IllegalArgumentException{
			
			return "TEST";
		}
	//TEST
	
	public Ausschreibung speichern() throws IllegalArgumentException{

		Ausschreibung a = new Ausschreibung();
		a.setBezeichnung("test");
		a.setFrist(null);

		a.setInhalt("testetst");
		aMapper.einfuegen(a);
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	public Ausschreibung einfuegen() throws IllegalArgumentException {
		Ausschreibung a = new Ausschreibung ();
		a.setBezeichnung("Test");
		a.setInhalt("Testtest");
		a.setFrist(null);
		aMapper.einfuegen(a);
		return a;
	}
	
	
	public Organisationseinheit insert() throws IllegalArgumentException{
		
		Organisationseinheit org = new Organisationseinheit("", "");
		
		try {
			orgMapper.insert(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
