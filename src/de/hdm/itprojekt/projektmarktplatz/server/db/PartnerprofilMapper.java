package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
//@author samina
public class PartnerprofilMapper {

	public static PartnerprofilMapper partnerprofilMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Partnerprofil einfuegen(Partnerprofil p) throws Exception {
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
				stmt.executeUpdate("INSERT INTO `partnerprofil` (`Partnerprofil_ID`, `Erstelldatum`, `Aenderungsdatum`, `orga_id`) VALUES (NULL, '"+p.getErstelldatum()+"', '"+p.getAenderungsdatum()+"', '"+p.getOrganisationseinheit().getId());
			//}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public Partnerprofil speichern(Partnerprofil p) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `partnerprofil` SET `orga_id` = '"+p.getOrganisationseinheit().getId()+"' WHERE `partnerprofil`.`Partnerprofil_ID` = "+p.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public void loeschen(Partnerprofil p) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `partnerprofil` WHERE Partnerprofil_ID = "+p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	public Partnerprofil getById(Partnerprofil p){
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("SELECT * FROM `partnerprofil` WHERE `Partnerprofil_ID` = " + p.getId());
		    }
		    catch (SQLException e) {
		    	
		    }
		    return p;
	}
	public ArrayList<Partnerprofil> getAll(){
		ArrayList<Partnerprofil> result = new ArrayList<Partnerprofil>();
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
				while (rs.next()) {
			          Partnerprofil p = new Partnerprofil();//default Konstruktor in Partnerprofil.java einf�gen damit es kein Fehler anzeigt
			          p.setId(rs.getInt("Partnerprofil_ID"));
			          p.setErstelldatum(rs.getDate("Erstelldatum"));
			          p.setAenderungsdatum(rs.getDate("Aenderungsdatum"));
			          Organisationseinheit o = new Organisationseinheit();
					  p.setId(rs.getInt("orga_id"));
					  p.setOrganisationseinheit(o);
						// a.setId(rs.getInt("") + 1);
						result.add(p);
					}
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
			//	a.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("");
				return result;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
