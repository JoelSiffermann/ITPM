package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
//@author samina
public class ProjektbeteiligungMapper {

	private static ProjektbeteiligungMapper projektbeteiligungMapper = null;
	
	protected ProjektbeteiligungMapper(){
		
	}

	
	/**
	 * @return projektbeteiligungMapper
	 */ 
	
	public static ProjektbeteiligungMapper projektbeteilitungMapper() {
		if (projektbeteiligungMapper == null) {
			projektbeteiligungMapper = new ProjektbeteiligungMapper();
		}

		return projektbeteiligungMapper;
	}
	
	/**
	 * F�gt eine Beteiligung hinzu
	 * @param b Beteiligung
	 * @return b
	 * @throws Exception
	 */

	public Beteiligung einfuegen(Beteiligung b) throws Exception {
		Connection con = DBConnection.connection();
		String datum = "";
		String datum2 = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(b.getEnde());
		datum2 = dateFormat.format(b.getStart());
		System.out.println("test "+b.getOrganisationseinheit().getId());
		String sql = "INSERT INTO `beteiligung` (`Beteilgung_ID`, `Start`, `Ende`, `Umfang`, `projekt_ID`, `orga_id`) "
				+ "VALUES (NULL, '"+datum2+"', '"+datum+"', '"+b.getUmfang()+"', '"+b.getProjekt().getId()+"', '"+b.getOrganisationseinheit().getId()+"');";
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			//ResultSet rs = stmt.executeQuery("");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			//if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				//b.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO `beteiligung` (`Beteilgung_ID`, `Start`, `Ende`, `Umfang`, `projekt_ID`, `orga_id`) VALUES (NULL, '"+datum2+"', '"+datum+"', '"+b.getUmfang()+"', '"+b.getProjekt().getId()+"', '"+b.getOrganisationseinheit().getId()+"');");
			//}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Speichert �nderungen der Beteiligungen 
	 * @param b Beteiligung
	 * @return b
	 * @throws Exception
	 */
	
	public Beteiligung speichern(Beteiligung b) throws Exception {
		Connection con = DBConnection.connection();
		String datum = "";
		String datum2 = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(b.getEnde());
		datum2 = dateFormat.format(b.getStart());
		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `beteiligung` SET `Beteilgung_ID` = '"+b.getId()+"', `Start` = '"+datum2+"', `Ende` = '"+datum+"', `Umfang` = '"+b.getUmfang()+"', `projekt_ID` = '"+b.getProjekt().getId()+"', `orga_id` = '"+b.getOrganisationseinheit().getId()+"' WHERE `beteiligung`.`Beteilgung_ID` = "+b.getId()+";");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	/**
	 * Loescht eine Beteiligung 
	 * @param b Beteiligung
	 * @throws Exception
	 */
	
	public void loeschen(Beteiligung b) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `beteiligung` WHERE Beteilgung_ID = "+b.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	/**
	 * Liest eine Beteiligung zur Id
	 * @param bt Beteiligung
	 * @return null
	 * @throws Exception
	 */
	
	
	public Beteiligung getById(Beteiligung bt) throws Exception{
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		     ResultSet rs =  stmt.executeQuery("SELECT * FROM `beteiligung` WHERE `Beteilgung_ID` = " + bt.getId());
		     if (rs.next()){
		    	 Beteiligung b = new Beteiligung();//default Konstruktor in Beteiligung.java einf�gen damit es kein Fehler anzeigt
		          b.setId(rs.getInt("Beteilgung_ID"));
		          b.setStart(rs.getDate("Start"));
		          b.setEnde(rs.getDate("Ende"));
		          b.setUmfang(rs.getInt("Umfang"));
		          Projekt p = new Projekt();
				  b.setId(rs.getInt("projekt_ID"));
				  b.setProjekt(p);
				  Organisationseinheit o = new Organisationseinheit();
				  b.setId(rs.getInt("orga_id"));
				  b.setOrganisationseinheit(o);
					// a.setId(rs.getInt("") + 1);
					
		     }
		    }
		    
		    catch (SQLException e) {
		    	
		    }
		    return null;
	}
	
	/**
	 * Liest alle Beteiligungen 
	 * @return return
	 * @throws Exception
	 */	
	
	public ArrayList<Beteiligung> getAll() throws Exception{
		ArrayList<Beteiligung> result = new ArrayList<Beteiligung>();
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `beteiligung`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				while (rs.next()) {
			          Beteiligung b = new Beteiligung();//default Konstruktor in Beteiligung.java einf�gen damit es kein Fehler anzeigt
			          b.setId(rs.getInt("Beteilgung_ID"));
			          b.setStart(rs.getDate("Start"));
			          b.setEnde(rs.getDate("Ende"));
			          b.setUmfang(rs.getInt("Umfang"));
			          Projekt p = new Projekt();
					  b.setId(rs.getInt("projekt_ID"));
					  b.setProjekt(p);
					  Organisationseinheit o = new Organisationseinheit();
					  b.setId(rs.getInt("orga_id"));
					  b.setOrganisationseinheit(o);
						// a.setId(rs.getInt("") + 1);
						result.add(b);
					}
				
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
			//	a.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
//				stmt.executeUpdate("");
//				return result;
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	/**
	 * Liest alle Beteiligungen zum Projekt
	 * @param p Projekt
	 * @return null
	 * @throws Exception
	 */

	public ArrayList<Beteiligung> getAllByProjekt(Projekt p) throws Exception {
		ArrayList<Beteiligung> result = new ArrayList<Beteiligung>();
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `beteiligung` WHERE `projekt_ID` = " + p.getId());
				while (rs.next()) {
			          Beteiligung b = new Beteiligung();//default Konstruktor in Beteiligung.java einf�gen damit es kein Fehler anzeigt
			          b.setId(rs.getInt("Beteilgung_ID"));
			          b.setStart(rs.getDate("Start"));
			          b.setEnde(rs.getDate("Ende"));
			          b.setUmfang(rs.getInt("Umfang"));
					  b.setProjekt(p);
					  Organisationseinheit o = new Organisationseinheit();
					  b.setId(rs.getInt("orga_id"));
					  b.setOrganisationseinheit(o);
					  result.add(b);
					}
				return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Liest alle Beteiligungen von einem Nutzer
	 * @param o Organisationseinheit
	 * @return null
	 * @throws Exception
	 */
	
	public ArrayList<Beteiligung> getAllByNutzer(Organisationseinheit o) throws Exception {
		ArrayList<Beteiligung> result = new ArrayList<Beteiligung>();
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `beteiligung` WHERE `orga_id` = " + o.getId());
				while (rs.next()) {
			          Beteiligung b = new Beteiligung();//default Konstruktor in Beteiligung.java einf�gen damit es kein Fehler anzeigt
			          b.setId(rs.getInt("Beteilgung_ID"));
			          b.setStart(rs.getDate("Start"));
			          b.setEnde(rs.getDate("Ende"));
			          b.setUmfang(rs.getInt("Umfang"));
			          Projekt p = new Projekt();
			          p.setId(rs.getInt("projekt_ID"));
			          b.setProjekt(p);
					  b.setOrganisationseinheit(o);
					  result.add(b);
					}
				return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *Gibt eine Beteiligung eines Nutzers an Projekten zur�ck
	 * @param o Organisationseinheit, p Projekt
	 * @return null
	 * @throws Exception
	 */
	
	public Beteiligung getByPersonAndProjekt(Organisationseinheit o, Projekt p) throws Exception{
		Connection con = DBConnection.connection();
	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs =  stmt.executeQuery("SELECT * FROM `beteiligung` WHERE `projekt_ID` = " + p.getId() + " AND `orga_id` = " + o.getId());
	     if (rs.next()){
	    	 Beteiligung b = new Beteiligung();//default Konstruktor in Beteiligung.java einf�gen damit es kein Fehler anzeigt
	          b.setId(rs.getInt("Beteilgung_ID"));
	          b.setStart(rs.getDate("Start"));
	          b.setEnde(rs.getDate("Ende"));
	          b.setUmfang(rs.getInt("Umfang"));
			  b.setProjekt(p);
			  b.setOrganisationseinheit(o);
			  return b;
	     }
	    }
	    catch (SQLException e) {
	    	
	    }
	    return null;
	}

}
