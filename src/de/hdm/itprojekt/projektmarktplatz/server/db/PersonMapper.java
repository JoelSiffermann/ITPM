package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;

//@autor �mer
public class PersonMapper {

	public static PersonMapper personMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Person einfuegen(Person p) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("INSERT INTO `person` (`Vorname`, `Beruf`, `Erfahrung`, `ID`, `o_id`) VALUES ('Florian', 'Bankkaufmann', '5', NULL, '1');");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				p.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO `person` (`Vorname`, `Nachname`, `Beruf`, `Erfahrung`, `ID`, `o_id`) VALUES ('Hans ', 'M�ller', 'Bankkaufmann', '10', NULL, '2');");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public Person speichern(Person p) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `person` SET `Erfahrung` = '7' WHERE `person`.`ID` = 5;");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public void loeschen(Person p) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `person` WHERE ID = 1");
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	public Person getById(Person p){
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("");
		    }
		    catch (SQLException e) {
		    	
		    }
		    return p;
	}
	public Ausschreibung getAll(){
		
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

