package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

//@autor �mer
public class ProjektmarktplatzMapper {

	public static ProjektmarktplatzMapper projektmarktplatzMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Projektmarktplatz einfuegen(Projektmarktplatz p) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("INSERT INTO `projektmarktplatz` (`Projektmarktplatz_ID`, `Bezeichnung`) VALUES (NULL, 'HdM2');");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				p.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public Projektmarktplatz speichern(Projektmarktplatz p) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `projektmarktplatz` SET `Bezeichnung` = 'HdM3' WHERE `projektmarktplatz`.`Projektmarktplatz_ID` = 2");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public void loeschen(Projektmarktplatz p) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `projektmarktplatz` WHERE Projektmarktplatz_ID =1");
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	public Projektmarktplatz getById(Projektmarktplatz p){
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

