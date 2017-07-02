package de.hdm.itprojekt.projektmarktplatz.server;

import java.util.ArrayList;


import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.Window;
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

/**
 * @author Ayse Guelay
 * @author Ersin Barut
 */


public class ProjektmarktplatzAdminImpl extends RemoteServiceServlet implements ProjektmarktplatzAdmin {


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

	/**
	 *
	 * @throws IllegalArgumentException 
	 */
	public ProjektmarktplatzAdminImpl() throws IllegalArgumentException {

	}

	/**
	 *Beinhaltet alle Mapper- Klassen
	 * @throws IllegalArgumentException 
	 */
	@Override
	public void init() throws IllegalArgumentException {
		/*
		 * Ganz wesentlich ist, dass die Projektmarktplatzadministration einen
		 * vollständigen Satz von Mappern besitzt, mit deren Hilfe sie dann mit
		 * der Datenbank kommunizieren kann.
		 */
		this.aMapper = AusschreibungMapper.ausschreibungMapper();
		this.orgMapper = OrganisationseinheitMapper.organisationseinheitMapper();
		this.bMapper = BewerbungMapper.bewerbungMapper();
		this.bwMapper = BewertungMapper.bewertungMapper();
		this.eMapper = EigenschaftMapper.eigenschaftMapper();
		this.ppMapper = PartnerprofilMapper.partnerprofilMapper();
		this.persMapper = PersonMapper.personMapper();
		this.projBetMapper = ProjektbeteiligungMapper.projektbeteilitungMapper();
		this.projMapper = ProjektMapper.projektMapper();
		this.projMarkMapper = ProjektmarktplatzMapper.projektmarktplatzMapper();
		 this.tMapper = TeamMapper.teamMapper();
		this.uMapper = UnternehmenMapper.unternehmenMapper();

	}

	

	// TEST
	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden für Ausschreibung-Objekte
	 * *************************************************************************
	 * **
	 */
	
	/**
	 *Ausschreibung erstellen
	 * @return a
	 * @throws Exception 
	 */
	public Ausschreibung erstellen() throws Exception {

		Ausschreibung a = new Ausschreibung();
		a.setBezeichnung("test");
		a.setFrist(null);
		a.setInhalt("testetst");
		aMapper.einfuegen(a);
		return a;
	}

	// Bearbeiten einer Ausschreibung ---> SQL Statement anpassen nachdem
	// DB-Schicht committet hat!
	public void save(Ausschreibung a) throws Exception {
		aMapper.speichern(a);

	}

	////////////////////// Löschung einer Ausschreibung --> je nach Mapper,
	////////////////////// anpassen!
	// --> Methode muss noch geändert werden!!

	/*
	 * public void loeschen (Ausschreibung a) throws IllegalArgumentException {
	 * Vector<Ausschreibung> ausschreibung = this.getById(a);
	 * 
	 * if (ausschreibung != null) { for (Ausschreibung c : ausschreibung) {
	 * this.loeschen(a);
	 * 
	 * } }
	 * 
	 * /////////////////////// Anschließend den Kunden entfernen
	 * this.aMapper.loeschen(a); }
	 */

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden für Organisationseinheit-Objekte
	 * *************************************************************************
	 * **
	 */
	// 
	
	/**
	 *Erstellen einer Organisationseinheit: Achtung, mit Fremdschlüssel.
	 *@param org Organisationseinheit
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Organisationseinheit insertOrg(Organisationseinheit org) throws IllegalArgumentException {

		try {
			orgMapper.einfuegen(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Bearbeiten einer Organisationseinheit
	 *@param org Organisationseinheit
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Organisationseinheit updateOrg(Organisationseinheit org) throws IllegalArgumentException {

		try {
			orgMapper.speichern(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Organisationseinheit updateOrg2(Organisationseinheit org, Team t, Person p, Unternehmen u) throws IllegalArgumentException {
		System.out.println("update Org2");
		try {

			orgMapper.speichern(org);

			if(t != null){
				tMapper.speichern(t);
			}else if (p != null){
				persMapper.speichern(p);
			}else if (u != null){
				uMapper.speichern(u);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			
		}

		return null;
	}
	/**
	 *Liest eine Organisationseinheit 
	 *@param org Organisationseinheit
	 * @return org2
	 * @throws IllegalArgumentException 
	 */
	public Organisationseinheit readByIdOrg(Organisationseinheit org) throws IllegalArgumentException {
		Organisationseinheit org2 = null;

		try {
			org2 = orgMapper.getById(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return org2;
	}
	/**
	 *Liest alle Organisationseinheiten
	 *@param org Organisationseinheit
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Organisationseinheit> readAllOrg() throws IllegalArgumentException {

		try {
			return orgMapper.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	/**
	 *Loescht eine Organisationseinheit 
	 *@param org Organisationseinheit
	 * @throws IllegalArgumentException 
	 */
	public void deleteOrg(Organisationseinheit org) throws IllegalArgumentException {
		try {
			orgMapper.loeschen(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden für Ausschreibung-Objekte
	 * *************************************************************************
	 * **
	 */

	
	/**
	 *Erstellen einer Ausschreibung
	 *@param a Ausschreibung
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	@Override
	public Ausschreibung insertAusschreibung(Ausschreibung a) throws IllegalArgumentException {

		try {
			aMapper.einfuegen(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ----------->Bearbeiten einer Ausschreibung<----------
	
	/**
	 * Bearbeiten einer Ausschreibung
	 *@param a Ausschreibung
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Ausschreibung updateAusschreibung(Ausschreibung a) throws IllegalArgumentException {
		try {
			aMapper.speichern(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * Auslesen einer Ausschreibung
	 *@param a Ausschreibung
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Ausschreibung readByIdAusschreibung(Ausschreibung a) throws IllegalArgumentException {

		try {
			return aMapper.getById(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Auslesen aller Ausschreibungen
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Ausschreibung> readAllAusschreibung() throws IllegalArgumentException {

		try {
			return aMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	/**
	 * >Loeschen einer Ausschreibung
	 *@param a Ausschreibung
	 * @throws IllegalArgumentException 
	 */

	public void deleteAusschreibung(Ausschreibung a) throws IllegalArgumentException {
		try {
			aMapper.loeschen(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden für Bewerbung-Objekte
	 * *************************************************************************
	 * **
	 */


	
	/**
	 * Erstellen einer Bewerbung
	 *@param b Bewerbung
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Bewerbung insertBewerbung(Bewerbung b) throws IllegalArgumentException {
		Organisationseinheit org = this.getNutzerByEmail(b.getBewerber());
		b.setBewerber(org);
		try {
			bMapper.einfuegen(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *Bearbeiten einer Bewerbung
	 *@param b Bewerbung
	 * @return null
	 * @throws IllegalArgumentException 
	 */


	public Bewerbung updateBewerbung(Bewerbung b) throws IllegalArgumentException {
		try {
			bMapper.speichern(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Auslesen einer Bewerbung
	 *@param b Bewerbung
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Bewerbung readByIdBewerbung(Bewerbung b) throws IllegalArgumentException {
		try {
			return bMapper.getById(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * Auslesen aller Bewerbungen
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public ArrayList<Bewerbung> readAllBewerbung() throws IllegalArgumentException {

		try {
			return bMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *Liest alle Bewerbungen einer Ausschreibung
	 *@param id String
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Bewerbung> readAllBewerbungByAusschreibung(Ausschreibung a) throws IllegalArgumentException {

		try {

			return bMapper.getAllByAusschreibung(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Loeschen einer Bewerbung<
	 *@param b Bewerbung 
	 * @throws IllegalArgumentException 
	 */

	
	public void deleteBewerbung(Bewerbung b) throws IllegalArgumentException {
		try {
			bMapper.loeschen(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden für Bewertung-Objekte
	 * *************************************************************************
	 * **
	 */


	// ------->Erstellen einer Bewertung<--------

	public Bewertung insertBewertung(Bewertung bt) throws IllegalArgumentException {

	
	/**
	 * Erstellen einer Bewertung
	 *@param id String
	 *@param bt Bewertung
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	


		try {
			bwMapper.einfuegen(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * Bearbeiten einer Bewertung
	 *@param bt Bewertung
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Bewertung updateBewertung(Bewertung bt) throws IllegalArgumentException {
		try {
			bwMapper.speichern(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	/**
	 * Auslesen einer Bewertung
	 *@param bt Bewertung
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Bewertung readByIdBewertung(Bewertung bt) throws IllegalArgumentException {
		try {
			return bwMapper.getById(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * Auslesung aller Bewertungen
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Bewertung> readAllBewertung() throws IllegalArgumentException {

		try {
			return bwMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Loeschen einer Bewertung
	 *@param bt Bewertung
	 * @throws IllegalArgumentException 
	 */

	public void deleteBewertung(Bewertung bt) throws IllegalArgumentException {
		try {
			bwMapper.loeschen(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden für Eigenschaft-Objekte
	 * *************************************************************************
	 * **
	 */


	/**
	 *Einfuegen einer Eigenschaft
	 *@param eg ArrayList<Eigenschaft>
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Eigenschaft insertEigenschaft(ArrayList<Eigenschaft> eg) throws IllegalArgumentException {
		try {
			eMapper.einfuegen(eg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	/**
	 *Bearbeiten einer Eigenschaft
	 *@param eg Eigenschaft
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Eigenschaft updateEigenschaft(Eigenschaft eg) throws IllegalArgumentException {
		try {
			eMapper.speichern(eg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Lesen einer Eigenschaft
	 *@param eg Eigenschaft
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Eigenschaft readByIdEigenschaft(Eigenschaft eg) throws IllegalArgumentException {
		try {
			return eMapper.getById(eg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 *Lesen aller Eigenschaften
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Eigenschaft> readAllEigenschaft() throws IllegalArgumentException {

		try {
			return eMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *Lesen aller Eigenschaften eines Partnerprofils
	 *@param p Partnerprofil
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Eigenschaft> readAllEigenschaft(Partnerprofil p) throws IllegalArgumentException {

		try {
			return eMapper.getEigenschaftenByPartnerprofil(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Loeschen einer Eigenschaft
	 *@param eg Eigenschaft
	 * @throws IllegalArgumentException 
	 */

	public void deleteEigenschaft(Eigenschaft eg) throws IllegalArgumentException {
		try {
			eMapper.loeschen(eg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden für Partnerprofil-Objekte
	 * *************************************************************************
	 * **
	 */


	/**
	 *Einfuegen eines Partnerprofil
	 *@param pp Partnerprofil
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Partnerprofil insertPartnerprofil(Partnerprofil pp) throws IllegalArgumentException {
		try {
			ppMapper.einfuegen(pp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Bearbeiten eines Partnerprofils
	 *@param pp Partnerprofil
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Partnerprofil updatePartnerprofil(Partnerprofil pp) throws IllegalArgumentException {
		try {
			ppMapper.speichern(pp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 *Lesen eines Partnerprofil
	 *@param pp Partnerprofil
	 * @return null
	 * @throws IllegalArgumentException 
	 */


	public Partnerprofil readByIdPartnerprofil(Partnerprofil pp) throws IllegalArgumentException {
		try {
			ppMapper.getById(pp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------->Lesen aller Partnerprofile<--------
	/**
	 *Lesen aller Partnerprofile
	 * @return null
	 * @throws IllegalArgumentException 
	 */


	public ArrayList<Partnerprofil> readAllPartnerprofil() throws IllegalArgumentException {
		try {
			return ppMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Loeschen eines Partnerprofils
	 *@param pp Partnerprofil
	 * @throws IllegalArgumentException 
	 */


	public void deletePartnerprofil(Partnerprofil pp) throws IllegalArgumentException {
		try {
			ppMapper.loeschen(pp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden für Person-Objekte
	 * *************************************************************************
	 * **
	 */


	
	/**
	 *Einfuegen eines Person
	 *@param pers Person
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	
	public Person insertPerson(Person pers) throws IllegalArgumentException {
		Person p = new Person();
		try {

			p.setOrganisationseinheit(orgMapper.getByEmail(pers.getOrganisationseinheit()));
			pers.getOrganisationseinheit().setId(p.getOrganisationseinheit().getId());
			p = persMapper.getByOrgId(p.getOrganisationseinheit());

			orgMapper.speichern(pers.getOrganisationseinheit());

			if (p != null) {
				// pers.getOrganisationseinheit().setId(p.getOrganisationseinheit().getId());
				// persMapper.getByOrgId(p.getOrganisationseinheit());
				pers.setId(p.getId());
				persMapper.speichern(pers);
			} else {
				persMapper.einfuegen(pers);
			}
			// try {
			// System.out.println("Einf�ngen von Person " +
			// orgMapper.getByEmail(pers.getOrganisationseinheit()).getId());
			// pers.getOrganisationseinheit().setId(orgMapper.getByEmail(pers.getOrganisationseinheit()).getId());
			// persMapper.speichern(pers);
			// }catch (Exception e){
			// persMapper.einfuegen(pers);
			//
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *Liest einen Nutzer von Organisationseinheit
	 *@param o Organisationseinheit
	 * @return null
	 * @throws IllegalArgumentException 
	 */


	public ArrayList<String> readUserByOrg(Organisationseinheit o) {
		ArrayList<String> arr = new ArrayList<String>();
		try {
			Person p = new Person();
			Organisationseinheit org = new Organisationseinheit();
			org = orgMapper.getById(o);
			p = persMapper.getByOrgId(o);
			Unternehmen u = new Unternehmen();
			Team t = new Team();
			if (p != null) {
				p.setOrganisationseinheit(o); 
				arr.add("Person");
				arr.add(p.getVorname());
				arr.add(p.getBeruf());
				arr.add(p.getErfahrung()+"");
				arr.add(org.getName());
				arr.add(p.getId()+"");
			} else {
				
				u = uMapper.getByOrgId(o);
				
				if (u != null) {
					u.setOrganisationseinheit(o); 
					arr.add("Unternehmen");
					arr.add(u.getGeschaeftsform());
					arr.add(u.getGeschaeftsfeld());
					arr.add(org.getName());
					arr.add(u.getId()+"");
				}
			}
		
			if (p == null && u == null) {
				
				t = tMapper.getByOrgId(o);
				
				if (t != null) {
					t.setOrganisationseinheit(o); 
					arr.add("Team");
					arr.add(t.getGroesse() + "");
					arr.add(t.getArbeitsfeld());
					arr.add(org.getName());
					arr.add(t.getId()+"");
				}
			}
			return arr;
		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	/**
	 *Liest eine Organisationseinheit von der E-Mail ab
	 *@param o Organisationseinheit
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Organisationseinheit readByEmail(Organisationseinheit o) {

		try {
			o.setId(orgMapper.getByEmail(o).getId());
			Organisationseinheit org = new Organisationseinheit();
			org = orgMapper.getByEmail(o);
			return org;
		} catch (Exception e) {

			try {
				
				Partnerprofil p = new Partnerprofil();
				Ausschreibung a = new Ausschreibung ();
				a.setId(0); 
				o.setPartnerprofil(p);
				
				orgMapper.einfuegen(o);
				
				o.setId(orgMapper.getByEmail(o).getId());
				p.setAenderungsdatum(new Date());
				p.setErstelldatum(new Date()); 
				p.setOrganisationseinheit(o); 
				p.setAusschreibung(a); 
				
				ppMapper.einfuegen(p);
				
				p.setId(ppMapper.getByOrgId(o).getId());
				
				o.setPartnerprofil(p); 
				
				orgMapper.speichern(o);

				return o;
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return null;
	}


	/**
	 *Bearbeiten einer Person
	 *@param pers Person
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Person updatePerson(Person pers) throws IllegalArgumentException {
		try {
			persMapper.speichern(pers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	/**
	 *Lesen einer Person
	 *@param pers Person
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Person readByIdPerson(Person pers) throws IllegalArgumentException {
		try {
			return persMapper.getById(pers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 *Liest alle Personen
	 *@param pers Person
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public ArrayList<Person> readAllPerson() throws IllegalArgumentException {
		try {
			return persMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 *Loescht alle Personen
	 *@param pers Person
	 * @throws IllegalArgumentException 
	 */
	public void deletePerson(Person pers) throws IllegalArgumentException {
		try {
			persMapper.loeschen(pers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden fuer Projektbeteiligung-Objekte
	 * *************************************************************************
	 * **
	 */

	
	/**
	 *Einfuegen einer Projektbeteiligung
	 *@param projBet Beteiligung
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Beteiligung insertBeteiligung(Beteiligung projBet) throws IllegalArgumentException {
		// Organisationseinheit org = new Organisationseinheit();
		// org.setId(13);
		try {
			// System.out.println("test impl
			// "+projBet.getOrganisationseinheit().getId());
			// projBet.setOrganisationseinheit(org);
			return projBetMapper.einfuegen(projBet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Bearbeiten einer Projektbeteiligung
	 *@param projBet Beteiligung
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Beteiligung updateBeteiligung(Beteiligung projBet) throws IllegalArgumentException {
		try {
			projBetMapper.speichern(projBet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Lesen einer Projektbeteiligung
	 *@param projBet Beteiligung
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Beteiligung readByIdBeteiligung(Beteiligung projBet) throws IllegalArgumentException {
		try {
			return projBetMapper.getById(projBet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------->Lesen aller Projektbeteiligung<--------
	
	/**
	 *Lesen aller Projektbeteiligung
	 *@param projBet Beteiligung
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Beteiligung> readAllBeteiligung() throws IllegalArgumentException {

		try {
			return projBetMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Loeschen einer Projektbeteiligung
	 *@param projBet Beteiligung
	 *@throws IllegalArgumentException 
	 */

	public void deleteBeteiligung(Beteiligung projBet) throws IllegalArgumentException {
		try {
			projBetMapper.loeschen(projBet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden fuer Projekt-Objekte
	 * *************************************************************************
	 * **
	 */

	
	/**
	 *Einfuegen eines Projektes
	 *@param proj Projekt
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Projekt insertProjekt(Projekt proj) throws IllegalArgumentException {

		try {
			projMapper.einfuegen(proj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Bearbeiten eines Projektes
	 *@param proj Projekt
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Projekt updateProjekt(Projekt proj) throws IllegalArgumentException {
		try {
			projMapper.speichern(proj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Lesen eines Projektes
	 *@param proj Projekt
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Projekt readByIdProjekt(Projekt proj) throws IllegalArgumentException {
		try {
			return projMapper.getById(proj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *Liest ein Projekt aus dem Projektmarktplatz
	 *@param proj Projektmarktplatz
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Projekt> readByIdProjektProjektmarktplatz(Projektmarktplatz proj) throws IllegalArgumentException {
		try {
			return projMapper.getAllByProjektmarktplatz(proj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------->Lesen aller Projekte<--------
	/**
	 *Lesen aller Projekte
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Projekt> readAllProjekt() throws IllegalArgumentException {

		try {
			return projMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Loeschen eines Projektes
	 *@param proj Projekt
	 * @throws IllegalArgumentException 
	 */

	public void deleteProjekt(Projekt proj) throws IllegalArgumentException {
		try {
			projMapper.loeschen(proj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden fuer Projektmarktplatz-Objekte
	 * *************************************************************************
	 * **
	 */

	/**
	 *Einfuegen eines Projektesmarktplatzes
	 *@param projMark Projektmarktplatz
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Projektmarktplatz insertProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException {

		try {
			projMarkMapper.einfuegen(projMark);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 *Bearbeiten eines Projektmarktplatzes
	 *@param projMark Projektmarktplatz
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Projektmarktplatz updateProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException {
		try {
			projMarkMapper.speichern(projMark);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	/**
	 *Lesen eines Projektmarktplatzes
	 *@param projMark Projektmarktplatz
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Projektmarktplatz readByIdProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException {
		try {
			return projMarkMapper.getById(projMark);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 *Lesen aller Projektmarktpl�tze
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Projektmarktplatz> readAllProjektmarktplatz() throws IllegalArgumentException {

		try {
			return projMarkMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *Lesen aller Projektmarktplaetze von Organisationseinheit
	 *@param o Organisationseinheit
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Projektmarktplatz> readAllProjektmarktplatzByOrg(Organisationseinheit o)
			throws IllegalArgumentException {
		ArrayList<Projektmarktplatz> result = new ArrayList<Projektmarktplatz>();
		try {
			for (Projektmarktplatz pm : projMarkMapper.getProjketmarkplatzByOrg(o)) {
				for (Projektmarktplatz pmp : projMarkMapper.getAllByOrg(pm)) {
					result.add(pmp);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Loeschen eines Projektmarktplatzes
	 *@param projMark Projektmarktplatz
	 * @throws IllegalArgumentException 
	 */
	public void deleteProjektmarktplatz(Projektmarktplatz projMark) throws IllegalArgumentException {
		try {
			projMarkMapper.loeschen(projMark);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden fuer Team-Objekte
	 * *************************************************************************
	 * **
	 */

	/**
	 *Einfuegen eines Teams
	 *@param t Team
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Team insertTeam(Team t) throws IllegalArgumentException {

		try {
			tMapper.einfuegen(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Bearbeiten eines Teams
	 *@param t Team
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Team updateTeam(Team t) throws IllegalArgumentException {
		try {
			tMapper.speichern(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Lesen eines Teams
	 *@param t Team
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Team readByIdTeam(Team t) throws IllegalArgumentException {
		try {
			System.out.println(t.getId());
			return tMapper.getById(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Einfuegen aller Teams
	 *@param t Team
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Team> readAllTeam() throws IllegalArgumentException {

		try {
			return tMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Loeschen eines Teams
	 *@param t Team
	 * @throws IllegalArgumentException 
	 */
	public void deleteTeam(Team t) throws IllegalArgumentException {
		try {
			tMapper.loeschen(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * *************************************************************************
	 * ** ABSCHNITT, Anfang: Methoden fuer Unternehmen-Objekte
	 * *************************************************************************
	 * **
	 */

	
	/**
	 *Einfuegen eines UN
	 *@param u Unternehmen
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Unternehmen insertUnternehmen(Unternehmen u) throws IllegalArgumentException {

		try {
			uMapper.einfuegen(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 *Bearbeiten eines UN
	 *@param u Unternehmen
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public Unternehmen updateUnternehmen(Unternehmen u) throws IllegalArgumentException {
		try {
			return uMapper.speichern(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	/**
	 *Lesen eines UN
	 *@param u Unternehmen
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	public Unternehmen readByIdUnternehmen(Unternehmen u) throws IllegalArgumentException {
		try {
			uMapper.getById(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *Lesen aller UN
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	public ArrayList<Unternehmen> readAllUnternehmen() throws IllegalArgumentException {

		try {
			return uMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------->Loeschen eines UN<--------
	
	/**
	 *Loeschen eines UN
	 *@param u Unternehmen
	 * @throws IllegalArgumentException 
	 */

	public void deleteUnternehmen(Unternehmen u) throws IllegalArgumentException {
		try {
			uMapper.loeschen(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *Liest ein Partnerprofil von Ausschreibungen
	 *@param a Ausschreibung
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	
	@Override
	public Partnerprofil getProfilbyAusschreibung(Ausschreibung a)  throws IllegalArgumentException {
		try {
			return this.ppMapper.getByAusschreibungId(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *Liest das GesuchteProfil
	 *@param p Partnerprofil
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	@Override
	public Eigenschaft getGesuchtesProf(Partnerprofil p) throws IllegalArgumentException {
		try {
			System.out.println("Partnerprofil suche " + p.getId());
			
			return this.eMapper.getByProfil(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *Liest ein Beteiligung an einem Projekt
	 *@param p Projekt
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	
	@Override
	public ArrayList<Beteiligung> getBeteiligungBy(Projekt p) throws IllegalArgumentException {
		try {
			return this.projBetMapper.getAllByProjekt(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *Liest die Organisationseinheit von Beteiligungen
	 *@param b Beteiligung
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	@Override
	public Organisationseinheit getOrgaByBeteiligung(Beteiligung b) throws IllegalArgumentException {
		Organisationseinheit o = new Organisationseinheit();
		o.setId(b.getOrganisationseinheit().getId());
		try {
			return this.orgMapper.getById(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *Liest die Projekte eines Nutzers 
	 *@param o Organisationseinheit
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	@Override
	public ArrayList<Projekt> getMeineProjekte(Organisationseinheit o) throws IllegalArgumentException {
		Organisationseinheit org = this.getNutzerByEmail(o);
		try {
			return this.projMapper.getAllbyNutzer(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *Liest andere Projekte einer Organisationseinheit auf dem Projektmarktplatz
	 *@param pm Projektmarktplatz
	 *@param o Organisationseinheit
	 *@param a Ausschreibung
	 * @return null
	 * @throws IllegalArgumentException 
	 */
	
	@Override
	public ArrayList<Projekt> getAndereProjekte(Organisationseinheit o, Projektmarktplatz pm) throws IllegalArgumentException {
		Organisationseinheit org = this.getNutzerByEmail(o);
		try {
			return this.projMapper.getByAndereNutzer(org, pm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public ArrayList<Projekt> getAndereProjekte(Organisationseinheit o) throws IllegalArgumentException {
		Organisationseinheit org = this.getNutzerByEmail(o);
		try {
			return this.projMapper.getByAndereNutzer(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Liest den Nutzer anhand der Email
	 *@param o Organisationseinheit
	 * @return null
	 * @throws IllegalArgumentException 
	 */

	
	public Organisationseinheit getNutzerByEmail(Organisationseinheit o){
		try {
			Organisationseinheit org = this.orgMapper.getByEmail(o);
			System.out.println(org.getId() + " " + org.getEmail());
			return org;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Bewerbung> getEingegangeneBewerbungen(Organisationseinheit o)
			throws IllegalArgumentException {
		Organisationseinheit org = this.getNutzerByEmail(o);
		ArrayList<Ausschreibung> a = this.getAusschreibungenByNutzer(org);
		ArrayList<Bewerbung> result = new ArrayList<Bewerbung>();
		ArrayList<Bewerbung> result2 = new ArrayList<Bewerbung>();
		for(Ausschreibung a1 : a){
			try {
				result2.addAll(this.bMapper.getAllByAusschreibung(a1));
				for(Bewerbung b : result2) {
					org = this.readByIdOrg(b.getBewerber());
					b.setBewerber(org);
					result.add(b);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<Ausschreibung> getAusschreibungenByNutzer(Organisationseinheit o)
			throws IllegalArgumentException {
		ArrayList<Projekt> p = new ArrayList<Projekt>();
		try {
			p = this.projMapper.getAllbyNutzer(o);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Projekt p1 : p){
		try {
			return this.aMapper.getAusschreibungenByProjekt(p1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return null;
	}

	@Override
	public ArrayList<Ausschreibung> getAusschreibungenByProjekt(Projekt p) throws IllegalArgumentException {
		try {
			return this.aMapper.getAusschreibungenByProjekt(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Bewertung getBewertungByBewerber(Organisationseinheit o) throws IllegalArgumentException {
		try {
			return this.bwMapper.getByBewerber(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Bewerbung> getMeineBewerbung(Organisationseinheit o) throws IllegalArgumentException {
		Organisationseinheit org = this.getNutzerByEmail(o);
		try {
			return this.bMapper.getBewerbungenByBewerber(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Ausschreibung getAusschreibungByBewerbung(Bewerbung b) throws IllegalArgumentException {
		try {
			return this.bMapper.getAusschreibung(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getTest() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
