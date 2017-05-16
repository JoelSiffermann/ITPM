package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewertung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
//@author samina
public class BewertungMapper {

	public static BewertungMapper bewertungMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Bewertung einfuegen(Bewertung b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
		//	ResultSet rs = stmt.executeQuery("");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
		//	if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
			//	b.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO `bewertung` (`Bewertung_ID`, `Inhalt`, `Skala`, `person_id`) VALUES (NULL, 'sehr gut', '1', '123');");
		//	}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public Bewertung speichern(Bewertung b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `bewertung` SET `Inhalt` = 'naja' WHERE `bewertung`.`Bewertung_ID` = 1;");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	public void loeschen(Bewertung b) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `bewertung` WHERE Bewertung_ID = 1");
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	public Bewertung getById(Bewertung b){
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("");
		    }
		    catch (SQLException e) {
		    	
		    }
		    return b;
	}
	public ArrayList<Bewertung> getAll(){
		
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
			//	a.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
