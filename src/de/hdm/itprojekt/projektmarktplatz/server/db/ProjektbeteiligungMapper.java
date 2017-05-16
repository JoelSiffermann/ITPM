package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
//@author samina
public class ProjektbeteiligungMapper {

	public static ProjektbeteiligungMapper projektbeteilitungMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Beteiligung einfuegen(Beteiligung b) {
		Connection con = DBConnection.connection();

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
				stmt.executeUpdate("INSERT INTO `beteiligung` (`Beteilgung_ID`, `Start`, `Ende`, `Umfang`, `projekt_ID`, `orga_id`) VALUES (NULL, '2017-06-01', '2017-05-31', '30', '458', '999');");
			//}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public Beteiligung speichern(Beteiligung b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `beteiligung` SET `Umfang` = '20' WHERE `beteiligung`.`Beteilgung_ID` = 1;");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	public void loeschen(Beteiligung b) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `beteiligung` WHERE Beteilgung_ID = 1");
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	public Beteiligung getById(Beteiligung b){
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("");
		    }
		    catch (SQLException e) {
		    	
		    }
		    return b;
	}
	public ArrayList<Beteiligung> getAll(){
		
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
