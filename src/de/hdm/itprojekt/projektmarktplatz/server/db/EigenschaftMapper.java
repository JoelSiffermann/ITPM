package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Eigenschaft;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
//@author samina

public class EigenschaftMapper {
	
	  private static EigenschaftMapper eigenschaftMapper = null;

	public static EigenschaftMapper eigenschaftMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Eigenschaft einfuegen(Eigenschaft c) {//c f�r character
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
				//c.setId(rs.getInt("") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO `eigenschaft` (`Eigenschaft_ID`, `Bezeichnung`, `Wert`, `partner_id`) VALUES (NULL, '"+c.getBezeichnung()+"', '"+c.getWert()+"', '"+c.getPartnerprofil().getId());
			//}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public Eigenschaft speichern(Eigenschaft c) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `eigenschaft` SET `Bezeichnung` = '"+c.getBezeichnung()+"' WHERE `eigenschaft`.`Eigenschaft_ID` = "+c.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}
	
	public void loeschen(Eigenschaft c) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `eigenschaft` WHERE Eigenschaft_ID = "+c.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	public Eigenschaft getById(Eigenschaft c){
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("SELECT * FROM `eigenschaft` WHERE `Eigenschaft_ID` = " + c.getId());
		    }
		    catch (SQLException e) {
		    	
		    }
		    return c;
	}
	public ArrayList<Eigenschaft> getAll(){
		
		Connection con = DBConnection.connection();
		ArrayList<Eigenschaft> result = new ArrayList<Eigenschaft>();
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
				while (rs.next()) {
			          Eigenschaft c = new Eigenschaft();//default Konstruktor in Eigenscgaft.java einf�gen damit es kein Fehler anzeigt
			          c.setId(rs.getInt("Eigenschaft_ID"));
			          c.setBezeichnung(rs.getString("Bezeichnung"));
			          c.setWert(rs.getString("Wert"));
			          Partnerprofil p = new Partnerprofil();
					  c.setId(rs.getInt("partner_id"));
					  c.setPartnerprofil(p);
						// a.setId(rs.getInt("") + 1);
						result.add(c);
					}


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
