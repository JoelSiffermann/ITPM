package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

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
			ResultSet rs = stmt.executeQuery("");

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

	public Partnerprofil speichern(Partnerprofil p) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public void loeschen(Partnerprofil p) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("");
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

}
