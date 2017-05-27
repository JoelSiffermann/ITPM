package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

//@autor �mer
public class OrganisationseinheitMapper {

	public static OrganisationseinheitMapper organisationseinheitMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Organisationseinheit einfuegen(Organisationseinheit o) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("INSERT INTO `organisationseinheit` (`Organisationseinheit_ID`, `Name`, `E-Mail`) VALUES (NULL, 'HdM', 'hdm@hdm-stuttgart.de');");

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

	public Organisationseinheit speichern(Organisationseinheit o) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `organisationseinheit` SET `Name` = 'HdM2' WHERE `organisationseinheit`.`Organisationseinheit_ID` = 2;");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return o;
	}
	
	public void loeschen(Organisationseinheit o) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `organisationseinheit` WHERE Organisationseinheit_ID = 1");
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }


public Organisationseinheit getById(Organisationseinheit o) throws Exception{
	 Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("");
	    }
	    catch (SQLException e) {
	    	
	    }
	    return o;
}
public Organisationseinheit getAll() throws Exception{
	
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

