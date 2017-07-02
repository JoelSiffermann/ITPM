package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

//@autor �mer
public class ProjektmarktplatzMapper {
	private static ProjektmarktplatzMapper projektmarktplatzMapper = null;

	protected ProjektmarktplatzMapper() {

	}
	/**
	 * @return projektmarktplatzMapper
	 */ 
	public static ProjektmarktplatzMapper projektmarktplatzMapper() {
		if (projektmarktplatzMapper == null) {
			projektmarktplatzMapper = new ProjektmarktplatzMapper();
		}
		return projektmarktplatzMapper;
	}

	
	/**
	 * F�gt ein neuen Projektmarktplatz hinzu
	 * @param p Projektmarktplatz
	 * @return p
	 * @throws Exception
	 */
	
	public Projektmarktplatz einfuegen(Projektmarktplatz p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			// ResultSet rs = stmt.executeQuery("INSERT INTO `projektmarktplatz`
			// (`Projektmarktplatz_ID`, `Bezeichnung`) VALUES (NULL, 'HdM2');");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// p.setId(rs.getInt("") + 1);
			
			 ResultSet rs = stmt.executeQuery("SELECT MAX(`Projektmarktplatz_ID`) AS maxid "
			          + "FROM `projektmarktplatz` ");
			 
		      if (rs.next()) {
		          
		    	  p.setId(rs.getInt("maxid") + 1);

		          stmt = con.createStatement();

		      

			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate("INSERT INTO `projektmarktplatz` (`Projektmarktplatz_ID`, `Bezeichnung`) VALUES ('"
					+ p.getId() + "', '" + p.getBezeichnung() + "');");
		}
	}catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * F�gt ein neuen Projektmarktplatz hinzu
	 * @param p Projektmarktplatz
	 * @return p
	 * @throws Exception
	 */

	public Projektmarktplatz speichern(Projektmarktplatz p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"UPDATE `projektmarktplatz` SET `Projektmarktplatz_ID` = '" + p.getId() + "', `Bezeichnung` = '"
							+ p.getBezeichnung() + "' WHERE `projektmarktplatz`.`Projektmarktplatz_ID` = " + p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Loescht ein Projektmarktplatz 
	 * @param p Projektmarktplatz
	 * @return p
	 * @throws Exception
	 */

	public void loeschen(Projektmarktplatz p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `projektmarktplatz` WHERE Projektmarktplatz_ID =" + p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Liest ein Projektmarktplatz
	 * @param p Projektmarktplatz
	 * @return p
	 * @throws Exception
	 */

	public Projektmarktplatz getById(Projektmarktplatz p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM `projektmarktplatz` WHERE `Projektmarktplatz_ID` = " + p.getId());
			if (rs.next()) {
				Projektmarktplatz pp = new Projektmarktplatz();
				pp.setId(rs.getInt("Projektmarktplatz_ID"));
				pp.setBezeichnung(rs.getString("Bezeichnung"));

				return pp;
			}
		} catch (SQLException e) {
		}
		return p;
	}

	/**
	 * Liest alle Projektmarktpl�tze zu einer Organisationseinheit
	 * @param pm Projektmarktplatz
	 * @return result
	 * @throws Exception
	 */
	
	public ArrayList<Projektmarktplatz> getAllByOrg(Projektmarktplatz pm) throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Projektmarktplatz> result = new ArrayList<Projektmarktplatz>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projektmarktplatz` WHERE `Projektmarktplatz_ID` = " + pm.getId());
			
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Projektmarktplatz p = new Projektmarktplatz();
					p.setId(rs.getInt("Projektmarktplatz_ID"));
					p.setBezeichnung(rs.getString("Bezeichnung"));
					result.add(p);
				}
				stmt = con.createStatement();
				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
//				stmt.executeUpdate("");
//				return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Liest ein Projektmarktplatz zu einer Organisationseinheit
	 * @param p Projektmarktplatz
	 * @return result
	 * @throws Exception
	 */
	
	public ArrayList<Projektmarktplatz> getProjketmarkplatzByOrg(Organisationseinheit o) throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Projektmarktplatz> result = new ArrayList<Projektmarktplatz>();
		int projId = 0;
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */

			ResultSet rs = stmt.executeQuery("SELECT * FROM `orga_pmarkt` WHERE `orga_id` = " + o.getId());

				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Projektmarktplatz p = new Projektmarktplatz();
					p.setId(rs.getInt("pmarkt_id"));
					result.add(p);
				}
				stmt = con.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * Zeigt alle Projektmarktpl�tze an
	 * @return result
	 * @throws Exception
	 */
	
	
	public ArrayList<Projektmarktplatz> getAll() throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Projektmarktplatz> result = new ArrayList<Projektmarktplatz>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projektmarktplatz`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Projektmarktplatz p = new Projektmarktplatz();
					p.setId(rs.getInt("Projektmarktplatz_ID"));
					p.setBezeichnung(rs.getString("Bezeichnung"));
					result.add(p);
				}
				stmt = con.createStatement();
				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
//				stmt.executeUpdate("");
//				return result;
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
