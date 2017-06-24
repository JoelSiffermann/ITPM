package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Eigenschaft;
//@author samina

public class EigenschaftMapper {
	
	  private static EigenschaftMapper eigenschaftMapper = null;
	  
	  protected EigenschaftMapper(){
		  
	  }

		public static EigenschaftMapper eigenschaftMapper() {
			if (eigenschaftMapper == null) {
				eigenschaftMapper = new EigenschaftMapper();
			}

			return eigenschaftMapper;
		}
	


	public ArrayList<Eigenschaft> einfuegen(ArrayList<Eigenschaft> eg) throws Exception {//c f�r character
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

				for(Eigenschaft c : eg){
				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
					stmt.executeUpdate("INSERT INTO `eigenschaft` (`Eigenschaft_ID`, `Bezeichnung`, `Wert`, `partner_id`) VALUES (NULL, '"+c.getBezeichnung()+"', '"+c.getWert()+"', '"+c.getPartnerprofil().getId()+"');");
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eg;
	}

	public Eigenschaft speichern(Eigenschaft c) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `eigenschaft` SET `Eigenschaft_ID` = '"+c.getId()+"', `Bezeichnung` = '"+c.getBezeichnung()+"', `Wert` = '"+c.getWert()+"', `partner_id` = '"+c.getPartnerprofil().getId()+"' WHERE `eigenschaft`.`Eigenschaft_ID` = "+c.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}
	
	public void loeschen(Eigenschaft c) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `eigenschaft` WHERE Eigenschaft_ID = "+c.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	public Eigenschaft getById(Eigenschaft ch) throws Exception{
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft` WHERE `Eigenschaft_ID` = " + ch.getId());
		      if (rs.next()){
		    	  Eigenschaft c = new Eigenschaft();//default Konstruktor in Eigenscgaft.java einf�gen damit es kein Fehler anzeigt
		          Partnerprofil p = new Partnerprofil();
		          System.out.println("Ausgabe 1");
		    	  c.setId(rs.getInt("Eigenschaft_ID"));
		          c.setBezeichnung(rs.getString("Bezeichnung"));
		          c.setWert(rs.getString("Wert"));
		          
				  p.setId(rs.getInt("partner_id"));
				  c.setPartnerprofil(p);
				  System.out.println("Ausgabe 2" + c.getId());    
				  return c;
		      }
		    }
		    catch (SQLException e) {
		    	
		    }
		    return null;
	}
	public ArrayList<Eigenschaft> getAll() throws Exception{
		
		Connection con = DBConnection.connection();
		ArrayList<Eigenschaft> result = new ArrayList<Eigenschaft>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			//if (rs.next()) {
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
					  p.setId(rs.getInt("partner_id"));
					  c.setPartnerprofil(p);
						// a.setId(rs.getInt("") + 1);
						result.add(c);
					}

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
//				stmt.executeUpdate("");
//				return result;
		//}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public ArrayList<Eigenschaft> getEigenschaftenByPartnerprofil(Partnerprofil p) throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Eigenschaft> result = new ArrayList<Eigenschaft>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft` WHERE `partner_id` = " + p.getId());
			while (rs.next()) {
				Eigenschaft c = new Eigenschaft();
		        c.setId(rs.getInt("Eigenschaft_ID"));
		        c.setBezeichnung(rs.getString("Bezeichnung"));
		        c.setWert(rs.getString("Wert"));
		        Partnerprofil pp = new Partnerprofil();
				pp.setId(rs.getInt("partner_id"));
				c.setPartnerprofil(pp);
				result.add(c);
				}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Eigenschaft> equals(String s) throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Eigenschaft> result = new ArrayList<Eigenschaft>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft` WHERE `Wert` LIKE '%" + s + "%'");
			while (rs.next()) {
				Eigenschaft c = new Eigenschaft();
		        c.setId(rs.getInt("Eigenschaft_ID"));
		        c.setBezeichnung(rs.getString("Bezeichnung"));
		        c.setWert(rs.getString("Wert"));
		        Partnerprofil pp = new Partnerprofil();
				pp.setId(rs.getInt("partner_id"));
				c.setPartnerprofil(pp);
				result.add(c);
				}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}
