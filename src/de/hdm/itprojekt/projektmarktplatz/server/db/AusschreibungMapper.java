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
/**
 * 
 * @author student
 *
 */
public class AusschreibungMapper {

	private static AusschreibungMapper aMapper = null;
	
	protected AusschreibungMapper(){
		
	}
/**
 * 
 * @return aMapper
 */
	public static AusschreibungMapper ausschreibungMapper() {
		if (aMapper == null) {
			aMapper = new AusschreibungMapper();
		}

		return aMapper;
	}
	

/**
 * Die Methode einfuegen(Ausschreibung a)  f�gt eine Ausschreibung hinzu
 * @param a Ausschreibung
 * @return aMapper
 * @throws Exception
 */
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
			ResultSet rs = stmt.executeQuery("SELECT MAX(`Ausschreibung_ID`) AS maxid FROM ausschreibung");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				a.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation 
				stmt.executeUpdate("INSERT INTO `ausschreibung` (`Ausschreibung_ID`, `Bezeichnung`, `Inhalt`, `Frist`, `projekt_id`, `partnerprofil_id`) "
						+ "VALUES (" + a.getId() + "', '"+a.getBezeichnung()+"', '"+a.getInhalt()+"', '"+datum+"', '"+a.getProjekt().getId()+"', '"+a.getPartnerprofil().getId()+"');");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * Die Methode speichern(Ausschreibung a) speichert die vorgenommenen �nderungen 
	 * @param a Ausschreibung
	 * @return aMapper
	 * @throws Exception
	 */
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
	
	/**
	 *  Die Methode loeschen(Ausschreibung a) l�scht eine Ausschreibung
	 * @param a Ausschreibung
	 * @throws Exception
	 */
	public void loeschen(Ausschreibung a) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `ausschreibung` WHERE `Ausschreibung_ID` = "+a.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	/**
	 * Die Methode getById(Ausschreibung a) liest die Id der Ausschreibungen
	 * @param a Ausschreibung
	 * @return aMapper
	 * @throws Exception
	 */
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
/**
 * Die Methode getAll() zeigt alle vorhandenen Ausschreibungen an 
 * @return result
 * @throws Exception
 */
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
	/**
	 * Liest alle Ausschreibungen zum Partnerprofil
	 * @param p Partnerprofil
	 * @return null
	 * @throws Exception
	 */
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
	/**
	 * Liste aller Ausschreibungen f�r ein Projekt
	 * @param p Projekt
	 * @return result
	 * @throws Exception
	 */
	
	public ArrayList<Ausschreibung> getAusschreibungenByProjekt(Projekt p) throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Ausschreibung> result = new ArrayList<Ausschreibung>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `ausschreibung` WHERE `projekt_id` = " + p.getId());
			while(rs.next()){
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
			result.add(a);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}
