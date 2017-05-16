package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

//@autor �mer
public class OrganisationseinheitMapper {

	public static OrganisationseinheitMapper organisationseinheitMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Organisationseinheit einfuegen(Organisationseinheit o) {
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
				o.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
	//			stmt.executeUpdate("INSERT INTO `organisationseinheit` (`Organisationseinheit_ID`, `Name`, `E-Mail`) VALUES (NULL, '"+o.getName()+"', '"+o.getEmail()+"');");

				stmt.executeUpdate("INSERT INTO `organisationseinheit` (`Organisationseinheit_ID`, `Name`, `E-Mail`) VALUES (NULL, 'HdM', 'test@hdm-stuttgart.de');");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	public Organisationseinheit speichern(Organisationseinheit o) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return o;
	}
	
	public void loeschen(Organisationseinheit o) {
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
