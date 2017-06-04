package de.hdm.itprojekt.projektmarktplatz.server;

import java.util.ArrayList;
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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Eigenschaft;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

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
	private PartnerprofilMapper ppMapper = null;
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
	       * Ganz wesentlich ist, dass die Projektmarktplatzadministration einen vollständigen Satz
	       * von Mappern besitzt, mit deren Hilfe sie dann mit der Datenbank
	       * kommunizieren kann.
	       */
	      this.aMapper = AusschreibungMapper.ausschreibungMapper();
	      this.orgMapper = OrganisationseinheitMapper.organisationseinheitMapper();
	      this.bMapper = BewerbungMapper.bewerbungMapper();
	      this.bwMapper = BewertungMapper.bewertungMapper();
	      this.eMapper = EigenschaftMapper.eigenschaftMapper();
	      this.ppMapper = PartnerprofilMapper.partnerprofilMapper();
	      this.persMapper = PersonMapper.personMapper();
	      this.projBetMapper = ProjektbeteiligungMapper.projektbeteilitungMapper();
	      this.projMarkMapper = ProjektmarktplatzMapper.projektmarktplatzMapper();
//	      this.tMapper = TeamMapper.teamMapper();
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
	public void save(Ausschreibung a) throws Exception {
		aMapper.speichern(a);
		
	}
	
	//////////////////////Löschung einer Ausschreibung --> je nach Mapper, anpassen! 
	// --> Methode muss noch geändert werden!!
	
/*public void loeschen (Ausschreibung a) throws IllegalArgumentException {
    Vector<Ausschreibung> ausschreibung = this.getById(a);

    if (ausschreibung != null) {
      for (Ausschreibung c : ausschreibung) {
        this.loeschen(a);
        
      }
    }

    /////////////////////// Anschließend den Kunden entfernen
    this.aMapper.loeschen(a);
  } */
	
	
	
	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden für Organisationseinheit-Objekte
	   * ***************************************************************************
	   */
	//Erstellen einer Organisationseinheit: Achtung, mit Fremdschlüssel.
	public Organisationseinheit insertOrg(Organisationseinheit org) throws IllegalArgumentException{
		
		try {
			orgMapper.einfuegen(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Organisationseinheit updateOrg(Organisationseinheit org ) throws IllegalArgumentException{
		
		try {
			orgMapper.speichern(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Organisationseinheit readByIdOrg(Organisationseinheit org ) throws IllegalArgumentException{
		Organisationseinheit org2 = null;
		
		try {
			org2 = orgMapper.getById(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return org2;
	}
	
	public ArrayList<Organisationseinheit> readAllOrg() throws IllegalArgumentException{

		try {
			return orgMapper.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void deleteOrg(Organisationseinheit org) throws IllegalArgumentException{
		try {
			orgMapper.loeschen(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden für Ausschreibung-Objekte
	   * ***************************************************************************
	   */
	
	//------->Erstellen einer Ausschreibung<--------
	

	@Override
	public Ausschreibung insertAusschreibung(Ausschreibung a) throws IllegalArgumentException {
	
		try{
			aMapper.einfuegen(a);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

//----------->Bearbeiten einer Ausschreibung<----------
	
	public Ausschreibung updateAusschreibung (Ausschreibung a) throws IllegalArgumentException {
		try {
			aMapper.speichern(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//-------->Auslesen einer Ausschreibung<---------
	
	public Ausschreibung readByIdAusschreibung (Ausschreibung a) throws IllegalArgumentException{
		
		try {
			return aMapper.getById(a);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Auslesen aller Ausschreibungen<--------
	

	public ArrayList<Ausschreibung> readAllAusschreibung() throws IllegalArgumentException{
		
		try{
			return aMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//----->Löschen einer Ausschreibung<--------

	
	public void deleteAusschreibung(Ausschreibung a) throws IllegalArgumentException{
		try {
			aMapper.loeschen(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden für Bewerbung-Objekte
	   * ***************************************************************************
	   */
	
	//------->Erstellen einer Bewerbung<--------
	
	public Bewerbung insertBewerbung (Bewerbung b) throws IllegalArgumentException {
		
		try{
			bMapper.einfuegen(b);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//------->Bearbeiten einer Bewerbung<--------
	
	public Bewerbung updateBewerbung (Bewerbung b) throws IllegalArgumentException {
		try{
			bMapper.speichern(b);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//------->Auslesen einer Bewerbung<--------
	
	
	public Bewerbung readByIdBewerbung (Bewerbung b) throws IllegalArgumentException {
		try {
			return bMapper.getById(b);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Auslesen aller Bewerbungen<--------


	public ArrayList<Bewerbung> readAllBewerbung() throws IllegalArgumentException {
		
		try{
			return bMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//------->Löschen einer Bewerbung<--------

	public void deleteBewerbung (Bewerbung b) throws IllegalArgumentException{
		try{ 
			bMapper.loeschen(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden für Bewertung-Objekte
	   * ***************************************************************************
	   */
	
	//------->Erstellen einer Bewertung<--------

	
	public Bewertung insertBewertung (Bewertung bt) throws IllegalArgumentException {
		
		try{
			bwMapper.einfuegen(bt);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//------->Bearbeiten einer Bewertung<--------
	
	public Bewertung updateBewertung (Bewertung bt) throws IllegalArgumentException {
		try{
			bwMapper.speichern(bt);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Auslesen einer Bewertung<--------
	
	
	public Bewertung readByIdBewertung (Bewertung bt) throws IllegalArgumentException {
		try {
			return bwMapper.getById(bt);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Auslesen aller Bewertungen<--------


	public ArrayList<Bewertung> readAllBewertung() throws IllegalArgumentException {
		
		try{
			return bwMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Löschen einer Bewerbung<--------

	public void deleteBewertung (Bewertung bt) throws IllegalArgumentException{
		try{ 
			bwMapper.loeschen(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden für Eigenschaft-Objekte
	   * ***************************************************************************
	   */
	
	//------->Einfügen einer Eigenschaft<--------

	
	public Eigenschaft insertEigenschaft (Eigenschaft eg) throws IllegalArgumentException{
		try{
			eMapper.einfuegen(eg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Bearbeiten einer Eigenschaft<--------

	public Eigenschaft updateEigenschaft (Eigenschaft eg) throws IllegalArgumentException{
		try{
			eMapper.speichern(eg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Lesen einer Eigenschaft<--------

	public Eigenschaft readByIdEigenschaft (Eigenschaft eg) throws IllegalArgumentException {
		try{
			eMapper.getById(eg);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Lesen aller Eigenschaften<--------

	
	public ArrayList<Eigenschaft> readAllEigenschaft() throws IllegalArgumentException{
		
		try{
			return eMapper.getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//------->Löschen einer Eigenschaft<--------


	public void deleteEigenschaft (Eigenschaft eg) throws IllegalArgumentException{
		try{ 
			eMapper.loeschen(eg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		/*
		   * ***************************************************************************
		   * ABSCHNITT, Anfang: Methoden für Partnerprofil-Objekte
		   * ***************************************************************************
		   */
		
	//------->Einfügen eines Partnerprofils<--------

		public Partnerprofil insertPartnerprofil (Partnerprofil pp) throws IllegalArgumentException{
			try{
				ppMapper.einfuegen(pp);
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}

		//------->Bearbeiten eines Partnerprofils<--------

		public Partnerprofil updatePartnerprofil (Partnerprofil pp) throws IllegalArgumentException{
			try{
				ppMapper.speichern(pp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Lesen eines Partnerprofils<--------

		public Partnerprofil readByIdPartnerprofil (Partnerprofil pp) throws IllegalArgumentException {
			try{ 
				ppMapper.getById(pp);
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Lesen aller Partnerprofile<--------
		
		public ArrayList <Partnerprofil> readAllPartnerprofil () throws IllegalArgumentException{
			try{
				return ppMapper.getAll();
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Löschen eines Partnerprofils<--------

		
		public void deletePartnerprofil (Partnerprofil pp) throws IllegalArgumentException{
			try{
				ppMapper.loeschen(pp);
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		/*
		   * ***************************************************************************
		   * ABSCHNITT, Anfang: Methoden für Person-Objekte
		   * ***************************************************************************
		   */
}
