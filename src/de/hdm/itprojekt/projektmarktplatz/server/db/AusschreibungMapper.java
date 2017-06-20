package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

//@author samina
public class AusschreibungMapper {

	private static AusschreibungMapper aMapper = null;
	
	protected AusschreibungMapper(){
		
	}

	public static AusschreibungMapper ausschreibungMapper() {
		if (aMapper == null) {
			aMapper = new AusschreibungMapper();
		}

		return aMapper;
	}
	


	public Ausschreibung einfuegen(Ausschreibung a) throws Exception {
		Connection con = DBConnection.connection();
		String datum = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(a.getFrist());
		
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
//			ResultSet rs = stmt.executeQuery("");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
//				a.setId(rs.getInt("Ausschreibung_ID") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation 
				stmt.executeUpdate("INSERT INTO `ausschreibung` (`Ausschreibung_ID`, `Bezeichnung`, `Inhalt`, `Frist`, `projekt_id`, `partnerprofil_id`) "
						+ "VALUES (NULL, '"+a.getBezeichnung()+"', '"+a.getInhalt()+"', '"+datum+"', '"+a.getProjekt().getId()+"', '"+a.getPartnerprofil().getId()+"');");
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Ausschreibung speichern(Ausschreibung a) throws Exception {
		Connection con = DBConnection.connection();
		String datum = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(a.getFrist());
		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `ausschreibung` SET `Bezeichnung` = '"+a.getBezeichnung()+"', `Inhalt` = '"+a.getInhalt()+"', `Frist` = '"+datum+"', `projekt_id` = '"+a.getProjekt().getId()+"', `partnerprofil_id` = '"+a.getPartnerprofil().getId()+"' WHERE `ausschreibung`.`Ausschreibung_ID` = "+a.getId()+";");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}
	
	public void loeschen(Ausschreibung a) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `ausschreibung` WHERE Ausschreibung_ID = "+a.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	public Ausschreibung getById(Ausschreibung a) throws Exception{
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT * FROM `ausschreibung` WHERE `Ausschreibung_ID` = " + a.getId());
		      
		      if(rs.next()){
		    	  Ausschreibung as = new Ausschreibung();
		    	  Partnerprofil pp = new Partnerprofil();
		    	  Projekt p = new Projekt();
		    	  as.setId(rs.getInt("Ausschreibung_ID"));
		    	  as.setBezeichnung(rs.getString("Bezeichnung"));
		    	  as.setFrist(rs.getDate("Frist"));
		    	  as.setInhalt(rs.getString("Inhalt"));
		    	  
		    	  
		    	  pp.setId(rs.getInt("partnerprofil_id"));
		    	  
		    	  as.setPartnerprofil(pp);
		    	  
		    	  p.setId(rs.getInt("projekt_id"));
		    	  
		    	  as.setProjekt(p);
		    	  
		    	  return as;
		      }
		      
		      
		    }
		    catch (SQLException e) {
		    	
		    }
		    return a;
	}

	public ArrayList<Ausschreibung> getAll() throws Exception{
		
		Connection con = DBConnection.connection();
		ArrayList<Ausschreibung> result = new ArrayList<Ausschreibung>();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `ausschreibung`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
			//	a.setId(rs.getInt("") + 1);

			      while (rs.next()) {
			          Ausschreibung a = new Ausschreibung();
			          Partnerprofil pp = new Partnerprofil();
			    	  Projekt p = new Projekt();
			    	  
			          a.setId(rs.getInt("Ausschreibung_ID"));
			          a.setBezeichnung(rs.getString("Bezeichnung"));
			          a.setInhalt(rs.getString("Inhalt"));
			          a.setFrist(rs.getDate("Frist"));
			    	  
			    	  pp.setId(rs.getInt("partnerprofil_id"));
			    	  
			    	  a.setPartnerprofil(pp);
			    	  
			    	  p.setId(rs.getInt("projekt_id"));
			    	  
			    	  a.setProjekt(p);
			          // Hinzufügen des neuen Objekts zum Ergebnisvektor
			          result.add(a);
			        }
//				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
//				stmt.executeUpdate("");
//				return result;
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public Ausschreibung getAusschreibungByPartnerprofil(Partnerprofil p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `ausschreibung` WHERE `partnerprofil_id` = " + p.getId());
			if(rs.next()){
			Ausschreibung a = new Ausschreibung();
			Partnerprofil pp = new Partnerprofil();
	    	Projekt proj = new Projekt();
			a.setId(rs.getInt("Ausschreibung_ID"));
			a.setBezeichnung(rs.getString("Bezeichnung"));
			a.setInhalt(rs.getString("Inhalt"));
			a.setFrist(rs.getDate("Frist"));
			pp.setId(rs.getInt("partnerprofil_id"));
	    	a.setPartnerprofil(pp);
	    	proj.setId(rs.getInt("projekt_id"));
	    	a.setProjekt(proj);
			return a;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
