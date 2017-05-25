package de.hdm.itprojekt.projektmarktplatz.server;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.projektmarktplatz.server.db.AusschreibungMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.BewerbungMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.BewertungMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.EigenschaftMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.OrganisationseinheitMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.PartnerprofilMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.PersonMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.ProjektMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.ProjektbeteiligungMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.ProjektmarktplatzMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.TeamMapper;
import de.hdm.itprojekt.projektmarktplatz.server.db.UnternehmenMapper;
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
	private BewerbungMapper bMapper = null;
	private BewertungMapper bwMapper = null;
	private EigenschaftMapper eMapper = null;
	private PartnerprofilMapper pPMapper = null;
	private PersonMapper persMapper = null;
	private ProjektbeteiligungMapper projBetMapper = null;
	private ProjektMapper projMapper = null;
	private ProjektmarktplatzMapper projMarkMapper = null;
	private TeamMapper tMapper = null;
	private UnternehmenMapper uMapper = null;

	  public ProjektmarktplatzAdminImpl() throws IllegalArgumentException {
		  
	  }

	@Override
	  public void init() throws IllegalArgumentException {
	      /*
	       * Ganz wesentlich ist, dass die BankAdministration einen vollständigen Satz
	       * von Mappern besitzt, mit deren Hilfe sie dann mit der Datenbank
	       * kommunizieren kann.
	       */
	      this.aMapper = AusschreibungMapper.ausschreibungMapper();
	      this.orgMapper = OrganisationseinheitMapper.orgMapper();
	      this.bMapper = BewerbungMapper.bewerbungMapper();
	      this.bwMapper = BewertungMapper.bewertungMapper();
	      this.eMapper = EigenschaftMapper.eigenschaftMapper();
	      this.pPMapper = PartnerprofilMapper.partnerprofilMapper();
	      this.persMapper = PersonMapper.personMapper();
	      this.projBetMapper = ProjektbeteiligungMapper.projektbeteilitungMapper();
	      this.projMarkMapper = ProjektmarktplatzMapper.projektmarktplatzMapper();
	      this.tMapper = TeamMapper.teamMapper();
	      this.uMapper = UnternehmenMapper.unternehmenMapper();
	      
	      
	    }
	public String getTest() throws IllegalArgumentException{
			
			return "TEST";
		}
	//TEST
	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden für Ausschreibung-Objekte
	   * ***************************************************************************
	   */
	public Ausschreibung erstellen() throws Exception{

		Ausschreibung a = new Ausschreibung();
		a.setBezeichnung("test");
		a.setFrist(null);
		a.setInhalt("testetst");
		aMapper.einfuegen(a);
		return a;
	}
	
	
	//Bearbeiten einer Ausschreibung ---> SQL Statement anpassen nachdem DB-Schicht committet hat!
	public void save(Ausschreibung a) throws IllegalArgumentException {
		aMapper.update(a);
	}
	
	//////////////////////Löschung einer Ausschreibung --> je nach Mapper, anpassen! 
	
//public void löschen (Ausschreibung a) throws IllegalArgumentException {
//    Vector<Ausschreibung> ausschreibung = this.getAccountsOf(c);
//
//    if (ausschreibung != null) {
//      for (Ausschreibung c : ausschreibung) {
//        this.löschen(a);
//        
//      }
//    }

//    /////////////////////// Anschließend den Kunden entfernen
//    this.aMapper.delete(a);
//  }
	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden für Organisationseinheit-Objekte
	   * ***************************************************************************
	   */
	public Organisationseinheit insert() throws IllegalArgumentException{
		
		Organisationseinheit org = new Organisationseinheit("", "");
		
		try {
			orgMapper.speichern(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	


}
