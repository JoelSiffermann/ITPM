package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;
//@author samina


public class BewertungMapper {

	private static BewertungMapper bwMapper = null;
	
	protected BewertungMapper(){
		
	}

	/**
	 * 
	 * @return bewertungMapper
	 */
	public static BewertungMapper bewertungMapper() {
		if (bwMapper == null) {
			bwMapper = new BewertungMapper();
		}

		return bwMapper;
	}
	

	/**
	 * 
	 * @param b Bewertung
	 * @return bwMapper
	 * @throws Exception
	 */

	public Bewertung einfuegen(Bewertung b) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(`Bewertung_ID`) AS maxid FROM bewertung");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				b.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO `bewertung` (`Bewertung_ID`, `Inhalt`, `Skala`, `person_id`) VALUES (" + b.getId() + "', '"+b.getInhalt()+"', '"+b.getSkala()+"', '"+b.getPerson().getId()+"');");
				//stmt.executeUpdate("INSERT INTO `bewertung` (`Bewertung_ID`, `Inhalt`, `Skala`, `person_id`) VALUES (NULL, '"+b.getInhalt()+"', '"+b.getSkala()+"');");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 
	 * @param b Bewertung
	 * @return bwMapper
	 * @throws Exception
	 */
	public Bewertung speichern(Bewertung b) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `bewertung` SET `Bewertung_ID` = '"+b.getId()+"', `Inhalt` = '"+b.getInhalt()+"', `Skala` = '"+b.getSkala()+"', `person_id` = '"+b.getPerson().getId()+"' WHERE `bewertung`.`Bewertung_ID` = "+b.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	/**
	 * 
	 * @param b Bewertung
	 * @throws Exception
	 */
	public void loeschen(Bewertung b) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `bewertung` WHERE `Bewertung_ID` = "+b.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	/**
	 * 
	 * @param bt Bewertung
	 * @return null
	 * @throws Exception
	 */
	public Bewertung getById(Bewertung bt) throws Exception{
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT * FROM `bewertung` WHERE `Bewertung_ID` = " + bt.getId());
		      if (rs.next()){
		    	  Bewertung b = new Bewertung();//default Konstruktor in Bewertung.java einf�gen damit es kein Fehler anzeigt
		          b.setId(rs.getInt("Bewertung_ID"));
		          b.setInhalt(rs.getString("Inhalt"));
		          b.setSkala(rs.getFloat("Skala"));
		          Organisationseinheit p = new Organisationseinheit();
					b.setId(rs.getInt("person_id"));
					b.setPerson(p);
					
					return b;
		      }
		    }
		    catch (SQLException e) {
		    	
		    }
		    return null;
	}
	/**
	 * 
	 * @return result
	 * @throws Exception
	 */
	public ArrayList<Bewertung> getAll() throws Exception{
		
		Connection con = DBConnection.connection();
		ArrayList<Bewertung> result = new ArrayList<Bewertung>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `bewertung`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
			//	a.setId(rs.getInt("") + 1);
				while (rs.next()) {
			          Bewertung b = new Bewertung();//default Konstruktor in Bewertung.java einf�gen damit es kein Fehler anzeigt
			          b.setId(rs.getInt("Bewertung_ID"));
			          b.setInhalt(rs.getString("Inhalt"));
			          b.setSkala(rs.getFloat("Skala"));
			          Organisationseinheit p = new Organisationseinheit();
						b.setId(rs.getInt("person_id"));
						b.setPerson(p);
						// a.setId(rs.getInt("") + 1);
						result.add(b);
					}

			          // Hinzufügen des neuen Objekts zum Ergebnisvektor
			         

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
//				stmt.executeUpdate("");
//				return result;
//			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

}
