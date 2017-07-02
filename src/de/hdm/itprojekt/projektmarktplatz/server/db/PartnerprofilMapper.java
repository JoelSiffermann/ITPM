package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;
//@author samina
public class PartnerprofilMapper {


	private static PartnerprofilMapper partnerprofilMapper = null;
	
	protected PartnerprofilMapper(){
		
	}

	/**
	 * 
	 * @return partnerprofilMapper
	 */
	public static PartnerprofilMapper partnerprofilMapper() {
		if (partnerprofilMapper == null) {
			partnerprofilMapper = new PartnerprofilMapper();
		}

		return partnerprofilMapper;
	}	

	/**
	 * F�gt ein Partnerprofil hinzu
	 * @param p Partnerprofil
	 * @return p
	 * @throws Exception
	 */
	
	public Partnerprofil einfuegen(Partnerprofil p) throws Exception {
		Connection con = DBConnection.connection();
		String datum = "";
		String datum2 = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(p.getAenderungsdatum());
		datum2 = dateFormat.format(p.getErstelldatum());

		String sql = "";
		//System.out.println(p.getAusschreibung());
		if (p.getAusschreibung().getId() != 0){
			sql = "INSERT INTO `partnerprofil` (`Partnerprofil_ID`, `Erstelldatum`, `Aenderungsdatum`, "
					+ "`orga_id`, `ausschreibung_id`) "
					+ "VALUES (" + p.getId() + "', '"+datum2+"', '"+datum+"', NULL, '"+p.getAusschreibung().getId() +"');";
		} else if (!p.getOrganisationseinheit().equals(null)){
			sql = "INSERT INTO `partnerprofil` (`Partnerprofil_ID`, `Erstelldatum`, `Aenderungsdatum`, "
					+ "`orga_id`, `ausschreibung_id`) "
					+ "VALUES (" + p.getId() + "', '"+datum2+"', '"+datum+"', '"+p.getOrganisationseinheit().getId() +"', NULL);";
		}
		System.out.println(sql);

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(`Partnerprofil_ID`) AS maxid FROM partnerprofil");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				p.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
//				stmt.executeUpdate("INSERT INTO `partnerprofil` (`Partnerprofil_ID`, `Erstelldatum`, `Aenderungsdatum`, `orga_id`) VALUES (NULL, '"+p.getErstelldatum()+"', '"+p.getAenderungsdatum()+"', '"+p.getOrganisationseinheit().getId());
			//}
				stmt.executeUpdate(sql);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	
	}
	
	/**
	 * Speichert �nderungen an einem Partnerprofil
	 * @param p Partnerprofil
	 * @return p
	 * @throws Exception
	 */

	public Partnerprofil speichern(Partnerprofil p) throws Exception {
		Connection con = DBConnection.connection();
		String datum = "";
		String datum2 = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(p.getAenderungsdatum());
		datum2 = dateFormat.format(p.getErstelldatum());
		
		String sql = "";
		if(!p.getAusschreibung().equals(null)){
			sql = "UPDATE `partnerprofil` SET `Erstelldatum` = '"+datum2+"', `Aenderungsdatum` = '"+datum+"', `ausschreibung_id` = '"+p.getAusschreibung().getId()+"' WHERE `partnerprofil`.`Partnerprofil_ID` = "+p.getId();
		}else if (!p.getOrganisationseinheit().equals(null)){
			sql = "UPDATE `partnerprofil` SET `Erstelldatum` = '"+datum2+"', `Aenderungsdatum` = '"+datum+"', `orga_id` = '"+p.getOrganisationseinheit().getId()+"' WHERE `partnerprofil`.`Partnerprofil_ID` = "+p.getId();
		}
		System.out.println(sql);
		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate(sql);

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
	
	/**
	 * Loescht ein Partnerprofil
	 * @param p Partnerprofil
	 * @throws Exception
	 */
	
	public void loeschen(Partnerprofil p) throws Exception {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `partnerprofil` WHERE `Partnerprofil_ID` = "+p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	/**
	 * Liest Partnerprofile zur Id
	 * @param p Partnerprofil
	 * @return null
	 * @throws Exception
	 */
	
	
	public Partnerprofil getById(Partnerprofil p) throws Exception{
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT * FROM `partnerprofil` WHERE `Partnerprofil_ID` = " + p.getId());
		      
		      if(rs.next()){
		    	  Partnerprofil pp = new Partnerprofil();//default Konstruktor in Partnerprofil.java einf�gen damit es kein Fehler anzeigt
		          pp.setId(rs.getInt("Partnerprofil_ID"));
		          pp.setErstelldatum(rs.getDate("Erstelldatum"));
		          pp.setAenderungsdatum(rs.getDate("Aenderungsdatum"));
		          
		          
				  
				  
				  if(rs.getInt("orga_id") > 0){
					  Organisationseinheit o = new Organisationseinheit();
					  o.setId(rs.getInt("orga_id"));
					  pp.setOrganisationseinheit(o);
				  } else if (rs.getInt("ausschreibung_id") > 0){
					  Ausschreibung a = new Ausschreibung();
					  a.setId(rs.getInt("ausschreibung_id"));
					  pp.setAusschreibung(a); 
				  }
				  
					// a.setId(rs.getInt("") + 1);
					return pp;
		      }
		    }
		    catch (SQLException e) {
		    	
		    }
		    return null;
	}
	/**
	 * Liest alle Partnerprofile zu Ausschreibungen 
	 * @param aId Ausschreibungen
	 * @return null
	 * @throws Exception
	 */
	
	public Partnerprofil getByOrgId(Organisationseinheit p) throws Exception{
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT * FROM `partnerprofil` WHERE `orga_id` = " + p.getId());
		      
		      if(rs.next()){
		    	  Partnerprofil pp = new Partnerprofil();//default Konstruktor in Partnerprofil.java einf�gen damit es kein Fehler anzeigt
		          pp.setId(rs.getInt("Partnerprofil_ID"));
		          pp.setErstelldatum(rs.getDate("Erstelldatum"));
		          pp.setAenderungsdatum(rs.getDate("Aenderungsdatum"));
				  
				  if(rs.getInt("orga_id") > 0){
					  Organisationseinheit o = new Organisationseinheit();
					  o.setId(rs.getInt("orga_id"));
					  pp.setOrganisationseinheit(o);
				  } else if (rs.getInt("ausschreibung_id") > 0){
					  Ausschreibung a = new Ausschreibung();
					  a.setId(rs.getInt("ausschreibung_id"));
					  pp.setAusschreibung(a); 
				  }
				  
					// a.setId(rs.getInt("") + 1);
					return pp;
		      }
		    }
		    catch (SQLException e) {
		    	
		    }
		    return null;
	}
	
	/**
	 * Liest alle Partnerprofile  zur Ausschreibung
	 * @param aId AusschreibungID
	 * @return null
	 * @throws Exception
	 */
	
	public Partnerprofil getByAusschreibungId(Ausschreibung aId) throws Exception{
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT * FROM `partnerprofil` WHERE `ausschreibung_id` = " + aId.getId());
		      
		      if(rs.next()){
		    	  Partnerprofil pp = new Partnerprofil();//default Konstruktor in Partnerprofil.java einf�gen damit es kein Fehler anzeigt
		          pp.setId(rs.getInt("Partnerprofil_ID"));
		          pp.setErstelldatum(rs.getDate("Erstelldatum"));
		          pp.setAenderungsdatum(rs.getDate("Aenderungsdatum"));
		          
		          
				  
				  
				  if(rs.getInt("orga_id") > 0){
					  Organisationseinheit o = new Organisationseinheit();
					  o.setId(rs.getInt("orga_id"));
					  pp.setOrganisationseinheit(o);
				  } else if (rs.getInt("ausschreibung_id") > 0){
					  Ausschreibung a = new Ausschreibung();
					  a.setId(rs.getInt("ausschreibung_id"));
					  pp.setAusschreibung(a); 
				  }
				  
					// a.setId(rs.getInt("") + 1);
					return pp;
		      }
		    }
		    catch (SQLException e) {
		    	
		    }
		    return null;
	}
	
	/**
	 * Liest alle Partnerprofile
	 * @return null
	 * @throws Exception
	 */
	
	public ArrayList<Partnerprofil> getAll() throws Exception{
		ArrayList<Partnerprofil> result = new ArrayList<Partnerprofil>();
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `partnerprofil`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				while (rs.next()) {
			          Partnerprofil p = new Partnerprofil();//default Konstruktor in Partnerprofil.java einf�gen damit es kein Fehler anzeigt
			          p.setId(rs.getInt("Partnerprofil_ID"));
			          p.setErstelldatum(rs.getDate("Erstelldatum"));
			          p.setAenderungsdatum(rs.getDate("Aenderungsdatum"));
			          
			          
					  
					  
					  if(rs.getInt("orga_id") > 0){
						  Organisationseinheit o = new Organisationseinheit();
						  o.setId(rs.getInt("orga_id"));
						  p.setOrganisationseinheit(o);
					  } else if (rs.getInt("ausschreibung_id") > 0){
						  Ausschreibung a = new Ausschreibung();
						  a.setId(rs.getInt("ausschreibung_id"));
						  p.setAusschreibung(a); 
					  }
					  
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
	
//	public Partnerprofil getByAusschreibung(Ausschreibung a) throws Exception {
//		Connection con = DBConnection.connection();
//	    try {
//	      Statement stmt = con.createStatement();
//	      ResultSet rs = stmt.executeQuery("SELECT * FROM `partnerprofil` WHERE `ausschreibung_id` = " + a.getId());
//	      if(rs.next()){
//	    	  Partnerprofil pp = new Partnerprofil();//default Konstruktor in Partnerprofil.java einf�gen damit es kein Fehler anzeigt
//	          pp.setId(rs.getInt("Partnerprofil_ID"));
//	          pp.setErstelldatum(rs.getDate("Erstelldatum"));
//	          pp.setAenderungsdatum(rs.getDate("Aenderungsdatum"));
//	          pp.setAusschreibung(a);
//	          Organisationseinheit o = new Organisationseinheit();
//	          o.setId(rs.getInt("orga_id"));
//	          o = OrganisationseinheitMapper.organisationseinheitMapper().getById(o);
//	          pp.setOrganisationseinheit(o);
//	          return pp;
//	      }
//	    }
//	    catch (SQLException e) {
//	    	
//	    }
//	    return null;
//	}
}
