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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

//@author samina
public class BewerbungMapper {

	private static BewerbungMapper bewerbungMapper = null;

	protected BewerbungMapper(){
		
	}
	/**
	 * 
	 * @return bewerbungMapper
	 */
	public static BewerbungMapper bewerbungMapper() {
		if (bewerbungMapper == null) {
			bewerbungMapper = new BewerbungMapper();
		}

		return bewerbungMapper;
	}

	/**
	 * F�gt eine Bewerbung hinzu
	 * @param b Bewerbung
	 * @return bewerbungMapper
	 * @throws Exception
	 */
	public Bewerbung einfuegen(Bewerbung b) throws Exception {
		Connection con = DBConnection.connection();
		//1
		String datum = "";

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(b.getErstelldatum());
		//1
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			 ResultSet rs = stmt.executeQuery("SELECT MAX(`Bewerbung_ID`) AS maxid FROM bewerbung");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			 if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			 b.setId(rs.getInt("maxid") + 1);

			stmt = con.createStatement();

			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate(
					"INSERT INTO `bewerbung` (`Bewerbung_ID`, `Inhalt`, `Erstelldatum`, `ausschreibung_id`, `bewerber_id`)" + "VALUES ('" + b.getId() + "', '"
							+ b.getInhalt() + "','" +datum+ "', '" + b.getAusschreibung().getId()+"', '" + b.getBewerber().getId()+"');");
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Speicherung aller �nderung einer Bewerbung
	 * @param b Bewerbung
	 * @return bewerbungMapper
	 * @throws Exception
	 */
	public Bewerbung speichern(Bewerbung b) throws Exception {
		System.out.println("" + b.getInhalt());
		Connection con = DBConnection.connection();
		String datum = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(b.getErstelldatum());
		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `bewerbung` SET `Bewerbung_ID` = '"+b.getId()+"', `Inhalt` = '"+b.getInhalt()+"', `Erstelldatum` = '"+ datum +"', `ausschreibung_id` = '"+b.getAusschreibung().getId()+"', `bewerber_id` = '"+ b.getBewerber().getId() +"' WHERE `bewerbung`.`Bewerbung_ID` = "+b.getId()+";");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	/**
	 * Loescht eine Bewerbung
	 * @param b Bewerbung
	 * @throws Exception
	 */

	public void loeschen(Bewerbung b) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM `bewerbung` WHERE `Bewerbung_ID` = " + b.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Liest die Id der Bewerbungen
	 * @param b Bewerbung
	 * @return bewerbungMapper
	 * @throws Exception
	 */
	public Bewerbung getById(Bewerbung b) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM `bewerbung` WHERE `Bewerbung_ID` = " + b.getId());
			if (rs.next()){
				Bewerbung bw = new Bewerbung();
				bw.setId(rs.getInt("Bewerbung_ID"));
				bw.setInhalt(rs.getString("Inhalt"));
				bw.setErstelldatum(rs.getDate("Erstelldatum"));
				Ausschreibung a = new Ausschreibung();
				Organisationseinheit o = new Organisationseinheit();
				o.setId(rs.getInt("bewerber_id"));
				a.setId(rs.getInt("ausschreibung_id"));
				b.setBewerber(o);
				bw.setAusschreibung(a);
				
				return bw;
			}
		}

		catch (SQLException e) {

		}
		return b;
	}

	/**
	 * Zeigt alle Bewerbungen an
	 * @return result
	 * @throws Exception
	 */
	public ArrayList<Bewerbung> getAll() throws Exception {

		Connection con = DBConnection.connection();
		ArrayList<Bewerbung> result = new ArrayList<Bewerbung>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `bewerbung`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */

				while (rs.next()) {
					Bewerbung b = new Bewerbung();
					b.setId(rs.getInt("Bewerbung_ID"));
					b.setInhalt(rs.getString("Inhalt"));
					b.setErstelldatum(rs.getDate("Erstelldatum"));
					Ausschreibung a = new Ausschreibung();
					Organisationseinheit o = new Organisationseinheit();
					o.setId(rs.getInt("bewerber_id"));
					a.setId(rs.getInt("ausschreibung_id"));
					b.setBewerber(o);
					b.setAusschreibung(a);
					result.add(b);
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
	 * Ruft alle Bewerbungen mit Hilfe der AusschreibungId
	 * @param id AusschreibungId
	 * @return result
	 * @throws Exception
	 */
	public ArrayList<Bewerbung> getAllByAusschreibung(Ausschreibung a) throws Exception {

		Connection con = DBConnection.connection();
		ArrayList<Bewerbung> result = new ArrayList<Bewerbung>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `bewerbung` WHERE `ausschreibung_id` = " + a.getId());
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */

				while (rs.next()) {
					Bewerbung b = new Bewerbung();
					b.setId(rs.getInt("Bewerbung_ID"));
					b.setInhalt(rs.getString("Inhalt"));
					b.setErstelldatum(rs.getDate("Erstelldatum"));
					Organisationseinheit o = new Organisationseinheit();
					o.setId(rs.getInt("bewerber_id"));
					b.setBewerber(o);
					b.setAusschreibung(a);
					result.add(b);
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
	 * Liest alle Bewerbungen eines Bewerbers 
	 * @param o Organisationseinheit
	 * @return result
	 * @throws Exception
	 */
	public ArrayList<Bewerbung> getBewerbungenByBewerber(Organisationseinheit o) throws Exception {

		Connection con = DBConnection.connection();
		ArrayList<Bewerbung> result = new ArrayList<Bewerbung>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `bewerbung` WHERE `bewerber_id` = " + o.getId());
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */

				while (rs.next()) {
					Bewerbung b = new Bewerbung();
					b.setId(rs.getInt("Bewerbung_ID"));
					b.setInhalt(rs.getString("Inhalt"));
					b.setErstelldatum(rs.getDate("Erstelldatum"));
					Ausschreibung a = new Ausschreibung();
					a.setId(rs.getInt("ausschreibung_id"));
					b.setAusschreibung(a);
					b.setBewerber(o);
					result.add(b);
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
	
	public Ausschreibung getAusschreibung(Bewerbung b) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM `ausschreibung` WHERE `Auschhreibung_ID` = " + b.getAusschreibung().getId());
			if (rs.next()){
				Ausschreibung as = new Ausschreibung();
		    	  Partnerprofil pp = new Partnerprofil();
		    	  Projekt p = new Projekt();
		    	  as.setId(rs.getInt("Ausschreibung_ID"));
		    	  as.setBezeichnung(rs.getString("Bezeichnung"));
		    	  as.setFrist(rs.getDate("Frist"));
		    	  as.setInhalt(rs.getString("Inhalt"));
		    	  
		    	  
		    	  pp.setId(rs.getInt("partnerprofil_id"));
		    	  
		    	  as.setPartnerprofil(pp);
		    	  
		    	  p.setId(rs.getInt("projekt_id"));
		    	  
		    	  as.setProjekt(p);
		    	  
		    	  return as;
			}
		}

		catch (SQLException e) {

		}
		return null;
	}

}
