package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
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
				stmt.executeUpdate("INSERT INTO `beteiligung` (`Beteilgung_ID`, `Start`, `Ende`, `Umfang`, `projekt_ID`, `orga_id`) VALUES (NULL, '"+b.getStart()+"', '"+b.getEnde()+"', '"+b.getUmfang()+"', '"+b.getProjekt().getId()+"', '"+b.getOrganisationseinheit().getId());
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

			stmt.executeUpdate("UPDATE `beteiligung` SET `Umfang` = '"+b.getUmfang()+"' WHERE `beteiligung`.`Beteilgung_ID` = "+b.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	public void loeschen(Beteiligung b) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `beteiligung` WHERE Beteilgung_ID = "+b.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	public Beteiligung getById(Beteiligung b){
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("SELECT * FROM `beteiligung` WHERE `Beteilgung_ID` = " + b.getId());
		    }
		    catch (SQLException e) {
		    	
		    }
		    return b;
	}
	public ArrayList<Beteiligung> getAll(){
		ArrayList<Beteiligung> result = new ArrayList<Beteiligung>();
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
			          Beteiligung b = new Beteiligung();//default Konstruktor in Beteiligung.java einf�gen damit es kein Fehler anzeigt
			          b.setId(rs.getInt("Beteilgung_ID"));
			          b.setStart(rs.getDate("Start"));
			          b.setEnde(rs.getDate("Ende"));
			          b.setUmfang(rs.getInt("Umfang"));
			          Projekt p = new Projekt();
					  b.setId(rs.getInt("projekt_ID"));
					  b.setProjekt(p);
					  Organisationseinheit o = new Organisationseinheit();
					  b.setId(rs.getInt("orga_id"));
					  b.setOrganisationseinheit(o);
						// a.setId(rs.getInt("") + 1);
						result.add(b);
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
