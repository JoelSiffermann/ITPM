package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;
import de.hdm.itprojekt.projektmarktplatz.server.db.DBConnection;

//@autor �mer
public class ProjektMapper {
	private static ProjektMapper projektMapper = null;

	protected ProjektMapper() {

	}
	
	/**
	 * @return projektMapper
	 */ 

	public static ProjektMapper projektMapper() {
		if (projektMapper == null) {
			projektMapper = new ProjektMapper();
		}
		return projektMapper;
	}
	/**
	 * F�gt ein neues Projekt hinzu
	 * @param p Projekt
	 * @return p
	 * @throws Exception
	 */
	public Projekt einfuegen(Projekt p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			String datum = "";
			String datum2 = "";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			datum = dateFormat.format(p.getStart());
			datum2 = dateFormat.format(p.getEnde());
			ResultSet rs = stmt.executeQuery("SELECT MAX(`Projekt_ID`) AS maxid FROM projekt");
			if (rs.next()){
				p.setId(rs.getInt("maxid") + 1);
				
			stmt = con.createStatement();
			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate("INSERT INTO `projekt` (`Projekt_ID`, `Name`, `Start`, `Ende`, `Inhalt`, "
					+ "`projektmarktplatz_id`, `person_id`) VALUES " + "('" + p.getId() + "', '" + p.getName() + "', '"
					+ datum + "', '" + datum2 + "', " + "'" + p.getInhalt() + "', '"
					+ p.getProjektmarktplatz().getId() + "', '" + p.getProjektleiter().getId() + "');");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	/**
	 * Speichert �nderungen an einem Projekt
	 * @param p Projekt
	 * @return p
	 * @throws Exception
	 */

	public Projekt speichern(Projekt p) throws Exception {
		String datum = "";
		String datum2 = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(p.getStart());
		datum2 = dateFormat.format(p.getEnde());
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE `projekt` SET `Projekt_ID` = '" + p.getId() + "', `Name` = '" + p.getName()
					+ "', " + "`Start` = '" + datum + "', `Ende` = '" + datum2 + "', `Inhalt` = '"
					+ p.getInhalt() + "', " + "`projektmarktplatz_id` = '" + p.getProjektmarktplatz().getId()
					+ "', `person_id` = '" + p.getProjektleiter().getId() + "" + "' WHERE `projekt`.`Projekt_ID` = "
					+ p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Loescht ein Projekt
	 * @param p Projekt
	 * @throws Exception
	 */

	public void loeschen(Projekt p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `projekt` WHERE `Projekt_ID` = " + p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Liest ein Projekt aus
	 * @param p Projekt
	 * @return p
	 * @throws Exception
	 */
	

	public Projekt getById(Projekt p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projekt` WHERE `Projekt_ID` = " + p.getId());
			if (rs.next()) {
				Projekt pr = new Projekt();
				pr.setId(rs.getInt("Projekt_ID"));
				pr.setName(rs.getString("Name"));
				pr.setInhalt(rs.getString("Inhalt"));
				pr.setStart(rs.getDate("Start"));
				pr.setEnde(rs.getDate("Ende"));
				Projektmarktplatz pm = new Projektmarktplatz();
				Organisationseinheit o = new Organisationseinheit();
				pm.setId(rs.getInt("projektmarktplatz_id"));
				pr.setProjektmarktplatz(pm);

				o.setId(rs.getInt("person_id"));

				pr.setProjektleiter(o);
				return pr;
			}
		} catch (SQLException e) {
		}
		return p;
	}
	
	/**
	 * Liest alle Projekte zu einem Projektmarktplatz 
	 * @param pr Projektmarktplatz 
	 * @return result
	 * @throws Exception
	 */
	
	

	public ArrayList<Projekt> getAllByProjektmarktplatz(Projektmarktplatz pr) throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Projekt> result = new ArrayList<Projekt>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projekt` WHERE `projektmarktplatz_id` = " + pr.getId());
				while (rs.next()) {
					Projekt p = new Projekt();
					p.setId(rs.getInt("Projekt_ID"));
					p.setName(rs.getString("Name"));
					p.setInhalt(rs.getString("Inhalt"));
					p.setStart(rs.getDate("Start"));
					p.setEnde(rs.getDate("Ende"));
					Projektmarktplatz pm = new Projektmarktplatz();
					Organisationseinheit ps = new Organisationseinheit();
					pm.setId(rs.getInt("projektmarktplatz_id"));
					p.setProjektmarktplatz(pm);

					ps.setId(rs.getInt("person_id"));

					p.setProjektleiter(ps);
					result.add(p);
				}
				stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * Liest alle Projekte  
	 * @return result
	 * @throws Exception
	 */
	
	
	
	public ArrayList<Projekt> getAll() throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Projekt> result = new ArrayList<Projekt>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projekt`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Projekt p = new Projekt();
					p.setId(rs.getInt("Projekt_ID"));
					p.setName(rs.getString("Name"));
					//System.out.println("Datum Start "+rs.getString("Start"));
					p.setInhalt(rs.getString("Inhalt"));
					p.setStart(rs.getDate("Start"));
					p.setEnde(rs.getDate("Ende"));
					Projektmarktplatz pm = new Projektmarktplatz();
					pm.setId(rs.getInt("projektmarktplatz_id"));
					p.setProjektmarktplatz(pm);;
					Organisationseinheit o = new Organisationseinheit();
					o.setId(rs.getInt("person_id"));
					p.setProjektleiter(o);
					result.add(p);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Liest alle Projekte eines Nutzers 
	 * @param o Organisationseinheit 
	 * @return result
	 * @throws Exception
	 */
	
	public ArrayList<Projekt> getAllbyNutzer(Organisationseinheit o) throws Exception {
		
		//TODO
		
		Connection con = DBConnection.connection();
		ArrayList<Projekt> result = new ArrayList<Projekt>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projekt` WHERE `person_id` ='" + o.getId() + "'");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Projekt p = new Projekt();
					p.setId(rs.getInt("Projekt_ID"));
					p.setName(rs.getString("Name"));
					p.setInhalt(rs.getString("Inhalt"));
					p.setStart(rs.getDate("Start"));
					p.setEnde(rs.getDate("Ende"));
					Projektmarktplatz pm = new Projektmarktplatz();
					pm.setId(rs.getInt("projektmarktplatz_id"));
					p.setProjektmarktplatz(pm);;
					p.setProjektleiter(o);
					result.add(p);
				}
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
	 * Liest alle Projekte von einem andere Nutzer
	 * @param o Organisationseinheit
	 * @param pm Projektmarktplatz
	 * @return result
	 * @throws Exception
	 */
	public ArrayList<Projekt> getByAndereNutzer(Organisationseinheit o, Projektmarktplatz pm) throws Exception {
		
		Connection con = DBConnection.connection();
		ArrayList<Projekt> result = new ArrayList<Projekt>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projekt` WHERE `person_id` !='" + o.getId() + "' AND `projektmarktplatz_id` ='" + pm.getId() + "'");
				while (rs.next()) {
					Projekt p = new Projekt();
					p.setId(rs.getInt("Projekt_ID"));
					p.setName(rs.getString("Name"));
					p.setInhalt(rs.getString("Inhalt"));
					p.setStart(rs.getDate("Start"));
					p.setEnde(rs.getDate("Ende"));
					Projektmarktplatz pa = new Projektmarktplatz();
					pa.setId(rs.getInt("projektmarktplatz_id"));
					p.setProjektmarktplatz(pm);;
					p.setProjektleiter(o);
					result.add(p);
				}
				stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
