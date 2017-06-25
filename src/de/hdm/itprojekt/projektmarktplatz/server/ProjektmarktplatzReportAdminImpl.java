package de.hdm.itprojekt.projektmarktplatz.server;

import java.util.ArrayList;

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
	// private OrganisationseinheitMapper orgMapper = null;
	private BewerbungMapper bMapper = null;
	// private BewertungMapper bwMapper = null;
	private EigenschaftMapper eMapper = null;
	private PartnerprofilMapper pPMapper = null;
	private PersonMapper persMapper = null;
	private ProjektbeteiligungMapper projBetMapper = null;
	// private ProjektMapper projMapper = null;
	// private ProjektmarktplatzMapper projMarkMapper = null;
	private TeamMapper tMapper = null;
	private UnternehmenMapper uMapper = null;

	public ProjektmarktplatzReportAdminImpl() throws IllegalArgumentException {

	}

	@Override
	public void init() throws IllegalArgumentException {
		/*
		 * Ganz wesentlich ist, dass die Projektmarktplatzadministration einen
		 * vollständigen Satz von Mappern besitzt, mit deren Hilfe sie dann mit
		 * der Datenbank kommunizieren kann.
		 */
		this.aMapper = AusschreibungMapper.ausschreibungMapper();
		// this.orgMapper =
		// OrganisationseinheitMapper.organisationseinheitMapper();
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

	// Abfrage einer Ausschreibung auf Basis der zugeh�rigen Bewerbung
	@Override
	public Ausschreibung getAusschreibungByBewerbung(Bewerbung b)
			throws IllegalArgumentException {
		// return this.aMapper.getByBewerbung();
		return null;
	}

	// Abfrage aller Beteiligungen eines Nutzers
	@Override
	public ArrayList<Beteiligung> getBeteiligungByNutzer(Partnerprofil p)
			throws IllegalArgumentException {
		// return this.projBetMapper.getByPartnerprofil();
		return null;
	}

	// Abfrage aller Ausschreibungen eines Nutzers
	@Override
	public ArrayList<Ausschreibung> getAusschreibungenByNutzer(Organisationseinheit o)
			throws IllegalArgumentException {
		Partnerprofil p = o.getPartnerprofil();
		try {
			return this.aMapper.getAusschreibungenByPartnerprofil(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public ArrayList<Partnerprofil> getAllPersProfile()
			throws IllegalArgumentException {
		try {
			return this.pPMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Abfrage der Anzahl aller Bewerbungen der Nutzer (Fan-In)
	@Override
	public int getAnzahlBewerbungen() throws IllegalArgumentException {
		ArrayList<Partnerprofil> p = this.getAllPersProfile();
		ArrayList<Bewerbung> b = new ArrayList<Bewerbung>();
		int count = 0;
		for (int i = 0; i < p.size(); i++) {
//			b.addAll(this.getBewerbungenByNutzer(p.get(i)));
			count = b.size();
		}
		return count;
	}

	// Abfrage der Anzahl aller Ausschreibungen der Nutzer (Fan-Out)
	@Override
	public int getAnzahlAusschreibungen() throws IllegalArgumentException {
		ArrayList<Partnerprofil> p = this.getAllPersProfile();
		ArrayList<Ausschreibung> a = new ArrayList<Ausschreibung>();
		int count = 0;
		for (int i = 0; i < p.size(); i++) {
//			a.addAll(this.getAusschreibungenByNutzer(p.get(i)));
			count = a.size();
		}
		return count;
	}

	public String getTest() throws IllegalArgumentException {
		return "TEST";
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
}
