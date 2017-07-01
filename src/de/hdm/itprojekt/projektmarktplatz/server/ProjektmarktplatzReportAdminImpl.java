package de.hdm.itprojekt.projektmarktplatz.server;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.*;
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
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzReportAdmin;

public class ProjektmarktplatzReportAdminImpl extends RemoteServiceServlet
		implements ProjektmarktplatzReportAdmin {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4685023405692030606L;

	private AusschreibungMapper aMapper = null;
	private OrganisationseinheitMapper orgMapper = null;
	private BewerbungMapper bMapper = null;
	// private BewertungMapper bwMapper = null;
	private EigenschaftMapper eMapper = null;
	private PartnerprofilMapper pPMapper = null;
	private PersonMapper persMapper = null;
	private ProjektbeteiligungMapper projBetMapper = null;
	private ProjektMapper projMapper = null;
	// private ProjektmarktplatzMapper projMarkMapper = null;
	private TeamMapper tMapper = null;
	private UnternehmenMapper uMapper = null;

	public ProjektmarktplatzReportAdminImpl() throws IllegalArgumentException {

	}

	@Override
	public void init() throws IllegalArgumentException {
		/*
		 * Ganz wesentlich ist, dass die Projektmarktplatzadministration einen
		 * vollstÃ¤ndigen Satz von Mappern besitzt, mit deren Hilfe sie dann mit
		 * der Datenbank kommunizieren kann.
		 */
		this.aMapper = AusschreibungMapper.ausschreibungMapper();
		this.projMapper = ProjektMapper.projektMapper();
		this.orgMapper = OrganisationseinheitMapper.organisationseinheitMapper();
		this.bMapper = BewerbungMapper.bewerbungMapper();
		// this.bwMapper = BewertungMapper.bewertungMapper();
		 this.eMapper = EigenschaftMapper.eigenschaftMapper();
		this.pPMapper = PartnerprofilMapper.partnerprofilMapper();
		// this.persMapper = PersonMapper.personMapper();
		this.projBetMapper = ProjektbeteiligungMapper
				.projektbeteilitungMapper();
		// this.projMarkMapper =
		// ProjektmarktplatzMapper.projektmarktplatzMapper();
		// this.tMapper = TeamMapper.teamMapper();
		// this.uMapper = UnternehmenMapper.unternehmenMapper();
	}

	/*
	 * **********************************************************************************************
	 * ABSCHNITT, Anfang: Methoden fuer das Abfragen von Objekten die relevant
	 * fuer die Reports sind.
	 * ***************************************************
	 * *******************************************
	 */

	// Ausgabe aller Ausschreibungen
	@Override
	public ArrayList<Ausschreibung> getAllAusschreibung()
			throws IllegalArgumentException {
		try {
			return this.aMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Abfrage der Ausschreibungen die dem Partnerprofil des Nutzers entsprechen
	@Override
	public ArrayList<Ausschreibung> getAuschreibungenByPartnerprofil(
			Partnerprofil p) throws IllegalArgumentException {
		ArrayList<Partnerprofil> p2 = null; // this.pPMapper.getAll();
		ArrayList<Ausschreibung> result = new ArrayList<Ausschreibung>();
		for (int i = 0; i < p2.size(); i++) {
			if (p.equals(p2.get(i))) {
				// TODO: Methode zum Vergleich des Persoenlichen Profils und des
				// Suchprofils
				// result.add(this.aMapper.getByPartnerprofil(p2.get(i).getId()));
			}
		}
		return result;
	}

	// Abfrage aller Bewerbungen eines Nutzers
	@Override
	public ArrayList<Bewerbung> getBewerbungenByNutzer(Organisationseinheit o)
			throws IllegalArgumentException {
		try {
			return this.bMapper.getBewerbungenByBewerber(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Abfrage aller Bewerbungen auf eine Ausschreibung
	@Override
	public ArrayList<Bewerbung> getBewerbungenByAusschreibung(Organisationseinheit o)
			throws IllegalArgumentException {
		ArrayList<Ausschreibung> a = this.getAusschreibungenByNutzer(o);
		ArrayList<Bewerbung> result = new ArrayList<Bewerbung>();
		for(Ausschreibung a1 : a){
			try {
				result.addAll(this.bMapper.getAllByAusschreibungId(a1.getId() + ""));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	// Abfrage einer Ausschreibung auf Basis der zugehörigen Bewerbung
	@Override
	public Ausschreibung getAusschreibungByBewerbung(Bewerbung b)
			throws IllegalArgumentException {
		// return this.aMapper.getByBewerbung();
		return null;
	}

	// Abfrage aller Beteiligungen eines Nutzers
	@Override
	public ArrayList<Beteiligung> getBeteiligungByNutzer(Organisationseinheit o)
			throws IllegalArgumentException {
		try {
			return this.projBetMapper.getAllByNutzer(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Abfrage aller Ausschreibungen eines Nutzers
	@Override
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

	/*
	 * **********************************************************************************************
	 * ABSCHNITT, Anfang: Methoden fuer die Fan-In/Fan-Out Analyse.
	 * *************
	 * *************************************************************
	 * ********************
	 */

	// Abfrage aller Nutzer
	@Override
	public ArrayList<Organisationseinheit> getAllPersProfile()
			throws IllegalArgumentException {
		try {
			return this.orgMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Abfrage der Anzahl aller Bewerbungen pro Teilnehmer (Fan-In)
	@Override
	public int getAnzahlBewerbungen(Organisationseinheit o) throws IllegalArgumentException {
		ArrayList<Bewerbung> b = this.getBewerbungenByNutzer(o);
		int count = b.size();
		return count;
	}

	// Abfrage der Anzahl aller Ausschreibungen pro Projekt (Fan-Out)
	@Override
	public int getAnzahlAusschreibungen(Projekt p) throws IllegalArgumentException {
		ArrayList<Ausschreibung> a = this.getAusschreibungenByProjekt(p);
		int count = a.size();
		return count;
	}
	
	//Abfrage der Anzahl aller Beteiligungen pro Projekt (Fan-In)
	@Override
	public int getAnzahlBeteiligungen(Projekt p) throws IllegalArgumentException {
		ArrayList<Beteiligung> b = this.getBeteiligungenByProjekt(p);
		int count = b.size();
		return count;
	}
	
	@Override
	public int getAnzahlBeteiligungen(Organisationseinheit o) throws IllegalArgumentException {
		ArrayList<Beteiligung> b = this.getBeteiligungByNutzer(o);
		int count = b.size();
		return count;
	}

	//-------------------------------------------------------------------------------------------------------
	//------------------------------------------Neuer Abschnitt----------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	public String getVergleichswert(Organisationseinheit o)
			throws IllegalArgumentException {
		String s = null;
//		try {
//			Person p = this.persMapper.getByOrgId(o);
//			Team t = this.tMapper.getByOrgId(o);
//			Unternehmen u = this.uMapper.getByOrgId(o);
//			if (p != null) {
//				s = p.getBeruf();
//			} else if (t != null) {
//				s = t.getArbeitsfeld();
//			} else if (u != null) {
//				s = u.getGeschaeftsfeld();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		s = "Web";
		return s;
	}
	
//	public ArrayList<Eigenschaft> getAlleEigenschaftenByPartnerprofilen() throws IllegalArgumentException {
//		ArrayList<Ausschreibung> a = this.getAllAusschreibung();
//		ArrayList<Partnerprofil> p = new ArrayList<Partnerprofil>();
//		ArrayList<Eigenschaft> result = new ArrayList<Eigenschaft>();
//		for (int i = 0 ; i < a.size() ; i++) {
//			Partnerprofil pp = new Partnerprofil();
//			pp.setId(a.get(i).getPartnerprofil().getId());
//			p.add(pp);
//			for (int i2 = 0 ; i2<p.size() ; i2++) {
//				try {
//					result.addAll(this.eMapper.getEigenschaftenByPartnerprofil(pp));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
	
	@Override
	public ArrayList<Ausschreibung> getEmpfAusschreibungen(Organisationseinheit o) throws IllegalArgumentException {
		ArrayList<Ausschreibung> result = new ArrayList<Ausschreibung>();
		ArrayList<Eigenschaft> e = new ArrayList<Eigenschaft>();
//		ArrayList<Partnerprofil> p = new ArrayList<Partnerprofil>();
		String vglw = this.getVergleichswert(o);
		try {
			e = this.eMapper.equals(vglw);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for(int i = 0 ; i<e.size() ; i++) {
			Partnerprofil pp = new Partnerprofil();
			pp.setId(e.get(i).getPartnerprofil().getId());
			try {
				result.add(this.aMapper.getAusschreibungByPartnerprofil(pp));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<Ausschreibung> getAusschreibungenByProjekt(Projekt p){
		try {
			return this.aMapper.getAusschreibungenByProjekt(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Bewerbung> getBewerbungbyAusschreibung(Ausschreibung a){
		try {
			return this.bMapper.getAllByAusschreibungId(a.getId() + "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Beteiligung> getBeteiligungenByProjekt(Projekt p){
		try {
			return this.projBetMapper.getAllByProjekt(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Organisationseinheit> getPersonenByProjekt(Projekt p){
		ArrayList<Organisationseinheit> result = new ArrayList<Organisationseinheit>();
		ArrayList<Ausschreibung> a = this.getAusschreibungenByProjekt(p);
		for(Ausschreibung a1 : a){
			ArrayList<Bewerbung> b = new ArrayList<Bewerbung>();
			b = this.getBewerbungbyAusschreibung(a1);
			for(Bewerbung b1 : b){
				Organisationseinheit o = b1.getBewerber();
				result.add(o);
			}
		}
		ArrayList<Beteiligung> b = this.getBeteiligungenByProjekt(p);
		for(Beteiligung b1 : b){
			Organisationseinheit o = b1.getOrganisationseinheit();
			result.add(o);
		}
		return result;
	}
	
	@Override
	public Beteiligung getBeteiligungByProjektteilnehmer(Organisationseinheit o, Projekt p){
		try {
			return this.projBetMapper.getByPersonAndProjekt(o, p);
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
	
//	public ArrayList<Eigenschaft> getEquals(Organisationseinheit o) throws IllegalArgumentException {
//		String vglw = this.getVergleichswert(o);
//		try {
//			return this.eMapper.equals(vglw);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public ArrayList<String> getFanAnalyse() throws IllegalArgumentException {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Organisationseinheit> teilnehmer = this.getAllPersProfile();
		for(Organisationseinheit o : teilnehmer){
			int bewerbungen = this.getAnzahlBewerbungen(o);
			int beteiligungen = this.getBeteiligungByNutzer(o).size();
			result.add(o.getName() + " " + o.getEmail() + " " + bewerbungen + " " + beteiligungen);
		}
		return result;
	}
	
	@Override
	public ArrayList<Projekt> getProjekteByNutzer(Organisationseinheit o) throws IllegalArgumentException {
		try {
			return this.projMapper.getAllbyNutzer(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
