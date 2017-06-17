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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Team; 
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Unternehmen;

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
	
	public ArrayList<Bewerbung> readAllBewerbungByAusschreibungId(String id) throws IllegalArgumentException {
		
		try{
			
			return bMapper.getAllByAusschreibungId(id);
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

	
	public Bewertung insertBewertung (Bewertung bt, String id) throws IllegalArgumentException {
		
		try{
			Bewerbung b = new Bewerbung();
			Ausschreibung a = new Ausschreibung();
			Partnerprofil pp = new Partnerprofil();
			Organisationseinheit o = new Organisationseinheit();
			Person person = new Person();
			
			b.setId(Integer.parseInt(id));
			b.setAusschreibung(bMapper.getById(b).getAusschreibung());
			a.setId(b.getAusschreibung().getId());
			System.out.println("HIER Ausschreibung ID " + a.getId()); 
			pp.setId(ppMapper.getByAusschreibungId(a).getId()); 
			System.out.println("Partnerproifl ID " + pp.getId()); 
			o.setId(orgMapper.getByPartnerprofilId(pp).getId());
			
			person = persMapper.getByOrgId(o);
			bt.setPerson(person); 
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
			return eMapper.getById(eg);
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

		//------->Einfügen einer Person<--------
		public Person insertPerson (Person pers) throws IllegalArgumentException{
			Person p = new Person();
			try{
				
				p.setOrganisationseinheit(orgMapper.getByEmail(pers.getOrganisationseinheit()));
				pers.getOrganisationseinheit().setId(p.getOrganisationseinheit().getId()); 
				p = persMapper.getByOrgId(p.getOrganisationseinheit());
				if (p != null){
//					pers.getOrganisationseinheit().setId(p.getOrganisationseinheit().getId()); 
//					persMapper.getByOrgId(p.getOrganisationseinheit());
					pers.setId(p.getId()); 
					persMapper.speichern(pers);
				}else {
					persMapper.einfuegen(pers);
				}
//				try {
//					System.out.println("Einf�ngen von Person " + orgMapper.getByEmail(pers.getOrganisationseinheit()).getId());
//				pers.getOrganisationseinheit().setId(orgMapper.getByEmail(pers.getOrganisationseinheit()).getId());
//				persMapper.speichern(pers);
//				}catch (Exception e){
//					persMapper.einfuegen(pers);
//
//				}
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Bearbeiten einer Person<--------
		public Person updatePerson (Person pers) throws IllegalArgumentException{
			try{
				persMapper.speichern(pers);
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Lesen eines Partnerprofils<--------
		public Person readByIdPerson (Person pers) throws IllegalArgumentException {
			try{ 
				return persMapper.getById(pers);
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Lesen aller Personen<--------
		public ArrayList <Person> readAllPerson() throws IllegalArgumentException{
			try{
				return persMapper.getAll();
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Löschen eines Partnerprofils<--------
		public void deletePerson (Person pers) throws IllegalArgumentException{
			try{
				persMapper.loeschen(pers);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	
	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden fuer Projektbeteiligung-Objekte
	   * ***************************************************************************
	   */	
	
	//------->Einfuegen einer Projektbeteiligung<--------
	public Beteiligung insertBeteiligung(Beteiligung projBet ) throws IllegalArgumentException{
//		Organisationseinheit org = new Organisationseinheit();
//		org.setId(13);
		try{
//			System.out.println("test impl "+projBet.getOrganisationseinheit().getId());
//			projBet.setOrganisationseinheit(org);
		return projBetMapper.einfuegen(projBet);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Bearbeiten einer Projektbeteiligung<--------

	public Beteiligung updateBeteiligung (Beteiligung projBet) throws IllegalArgumentException{
		try{
			projBetMapper.speichern(projBet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	
	//------->Lesen einer Projektbeteiligung<--------
	public Beteiligung readByIdBeteiligung(Beteiligung projBet) throws IllegalArgumentException {
		try{
			return projBetMapper.getById(projBet);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Lesen aller Projektbeteiligung<--------

	
	public ArrayList<Beteiligung> readAllBeteiligung() throws IllegalArgumentException{
		
		try{
			return projBetMapper.getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	

	//------->Loeschen einer Projektbeteiligung<--------


	public void deleteBeteiligung (Beteiligung projBet) throws IllegalArgumentException{
		try{ 
			projBetMapper.loeschen(projBet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden fuer Projekt-Objekte
	   * ***************************************************************************
	   */
	
	//------->Einfuegene eines Projektes <--------
	
	
	public Projekt insertProjekt(Projekt proj ) throws IllegalArgumentException{
		
		try{
		projMapper.einfuegen(proj);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Bearbeiten eines Projektes<--------

	public Projekt updateProjekt (Projekt proj) throws IllegalArgumentException{
		try{
			projMapper.speichern(proj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//------->Lesen eines Projektes<--------
	
	public Projekt  readByIdProjekt(Projekt proj) throws IllegalArgumentException {
		try{
			projMapper.getById(proj);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Lesen aller Projekte<--------

	
	public ArrayList<Projekt> readAllProjekt() throws IllegalArgumentException{
		
		try{
			return projMapper.getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//------->Loeschen eines Projektes<--------

	public void deleteProjekt(Projekt proj) throws IllegalArgumentException{
			try{ 
				projMapper.loeschen(proj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/*
	   * ***************************************************************************
	   * ABSCHNITT, Anfang: Methoden fuer Projektmarktplatz-Objekte
	   * ***************************************************************************
	   */
	
	//------->Einfuegene eines Projektmarktplatzes <--------
	
	
		public Projektmarktplatz insertProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException{
			
			try{
			projMarkMapper.einfuegen(projMark);	
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}	
	
		//------->Bearbeiten eines Projektmarktplatzes<--------

		public Projektmarktplatz updateProjektmarktplatz (Projektmarktplatz projMark) throws IllegalArgumentException{
			try{
				projMarkMapper.speichern(projMark);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}	
	
		//------->Lesen eines Projektmarktplatzes<--------
		
		public Projektmarktplatz readByIdProjektmarktplatz (Projektmarktplatz projMark) throws IllegalArgumentException {
			try{
				return projMarkMapper.getById(projMark);
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Lesen aller Projektmarktpl�tze<--------

		
		public ArrayList<Projektmarktplatz> readAllProjektmarktplatz() throws IllegalArgumentException{
			
			try{
				return projMarkMapper.getAll();
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//------->Loeschen eines Projektmarktplatzes<--------

		public void deleteProjektmarktplatz (Projektmarktplatz projMark) throws IllegalArgumentException{
				try{ 
					projMarkMapper.loeschen(projMark);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	

		/*
		   * ***************************************************************************
		   * ABSCHNITT, Anfang: Methoden fuer Team-Objekte
		   * ***************************************************************************
		   */
		
		//------->Einfuegen eines Teams<--------
		
		
			public Team insertTeam(Team t) throws IllegalArgumentException{
				
				try{
				tMapper.einfuegen(t);	
				}catch(Exception e){
					e.printStackTrace();
				}
				return null;
			}	
		
			//------->Bearbeiten eines Teams<--------

			public Team updateTeam (Team t) throws IllegalArgumentException{
				try{
					tMapper.speichern(t);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}	
		
			//------->Lesen eines Teams<--------
			
			public Team readByIdTeam(Team t) throws IllegalArgumentException {
				try{
					tMapper.getById(t);
				} catch (Exception e){
					e.printStackTrace();
				}
				return null;
			}
			
			//------->Lesen aller Teams<--------

			
			public ArrayList<Team> readAllTeam() throws IllegalArgumentException{
				
				try{
					return tMapper.getAll();
				} catch (Exception e){
					e.printStackTrace();
				}
				return null;
			}
			
			//------->Loeschen eines Teams<--------

			public void deleteTeam (Team t) throws IllegalArgumentException{
					try{ 
						tMapper.loeschen(t);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			/*
			   * ***************************************************************************
			   * ABSCHNITT, Anfang: Methoden fuer Unternehmen-Objekte
			   * ***************************************************************************
			   */
			
			//------->Einfuegen eines UN<--------
			
			
				public Unternehmen insertUnternehmen(Unternehmen u) throws IllegalArgumentException{
					
					try{
					uMapper.einfuegen(u);	
					}catch(Exception e){
						e.printStackTrace();
					}
					return null;
				}	
			
				//------->Bearbeiten eines UN<--------

				public Unternehmen updateUnternehmen(Unternehmen u) throws IllegalArgumentException{
					try{
						uMapper.speichern(u);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}	
			
				//------->Lesen eines UN<--------
				
				public Unternehmen readByIdUnternehmen(Unternehmen u) throws IllegalArgumentException {
					try{
						uMapper.getById(u);
					} catch (Exception e){
						e.printStackTrace();
					}
					return null;
				}
				
				//------->Lesen aller UN<--------

				
				public ArrayList<Unternehmen> readAllUnternehmen() throws IllegalArgumentException{
					
					try{
						return uMapper.getAll();
					} catch (Exception e){
						e.printStackTrace();
					}
					return null;
				}
				
				//------->Loeschen eines UN<--------

				public void deleteUnternehmen (Unternehmen u) throws IllegalArgumentException{
						try{ 
							uMapper.loeschen(u);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

			
		
		
		
}
