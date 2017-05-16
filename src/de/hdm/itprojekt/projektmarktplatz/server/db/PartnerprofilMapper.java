package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
//@author samina
public class PartnerprofilMapper {

	public static PartnerprofilMapper partnerprofilMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Partnerprofil einfuegen(Partnerprofil p) {
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
				//p.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO `partnerprofil` (`Partnerprofil_ID`, `Erstelldatum`, `Aenderungsdatum`, `orga_id`) VALUES (NULL, '2017-05-17', '2017-05-18', '12345');");
			//}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public Partnerprofil speichern(Partnerprofil p) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `partnerprofil` SET `orga_id` = '123456' WHERE `partnerprofil`.`Partnerprofil_ID` = 2;");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public void loeschen(Partnerprofil p) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `partnerprofil` WHERE Partnerprofil_ID = 1");
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	public Partnerprofil getById(Partnerprofil p){
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("");
		    }
		    catch (SQLException e) {
		    	
		    }
		    return p;
	}
	public ArrayList<Partnerprofil> getAll(){
		
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
