package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Beteiligung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

//@autor �mer
public class OrganisationseinheitMapper {
	private static OrganisationseinheitMapper organisationseinheitMapper = null;

	protected OrganisationseinheitMapper() {
	}

	public static OrganisationseinheitMapper organisationseinheitMapper() {
		if (organisationseinheitMapper == null) {
			organisationseinheitMapper = new OrganisationseinheitMapper();
		}
		return organisationseinheitMapper;
	}

	public Organisationseinheit einfuegen(Organisationseinheit o) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			// ResultSet rs = stmt.executeQuery("INSERT INTO
			// `organisationseinheit` (`Organisationseinheit_ID`, `Name`,
			// `E-Mail`, `partnerprofil_id`)"
			// + " VALUES ('"+o.getId()+"', '"+o.getName()+"',
			// '"+o.getEmail()+"', '"+o.getPartnerprofil().getId()+"');");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// o.setId(rs.getInt("") + 1);
			stmt = con.createStatement();
			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			// stmt.executeUpdate("INSERT INTO `organisationseinheit`
			// (`Organisationseinheit_ID`, `Name`, `E-Mail`) VALUES (NULL,
			// '"+o.getName()+"', '"+o.getEmail()+"');");
			stmt.executeUpdate(
					"INSERT INTO `organisationseinheit` (`Organisationseinheit_ID`, `Name`, `E-Mail`, `partnerprofil_id`)"
							+ " VALUES ('" + o.getId() + "', '" + o.getName() + "', '" + o.getEmail() + "', '"
							+ o.getPartnerprofil().getId() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	public Organisationseinheit speichern(Organisationseinheit o) throws Exception {
		Connection con = DBConnection.connection();
		String sql = "UPDATE `organisationseinheit` SET `Organisationseinheit_ID` = '" + o.getId() + "', "
				+ "`Name` = '" + o.getName() + "', `E-Mail` = '" + o.getEmail() + "', `partnerprofil_id` = '"
				+ o.getPartnerprofil().getId() + "' " + "WHERE `organisationseinheit`.`Organisationseinheit_ID` = "
				+ o.getId();
		System.out.println(sql); 
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE `organisationseinheit` SET `Organisationseinheit_ID` = '" + o.getId() + "', "
					+ "`Name` = '" + o.getName() + "', `E-Mail` = '" + o.getEmail() + "', `partnerprofil_id` = '"
					+ o.getPartnerprofil().getId() + "' " + "WHERE `organisationseinheit`.`Organisationseinheit_ID` = "
					+ o.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	public void loeschen(Organisationseinheit o) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `organisationseinheit` WHERE Organisationseinheit_ID = " + o.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Organisationseinheit getById(Organisationseinheit o) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM `organisationseinheit` WHERE `Organisationseinheit_ID` = " + o.getId());
			if (rs.next()) {
				Organisationseinheit or = new Organisationseinheit();
				or.setId(rs.getInt("Organisationseinheit_ID"));
				or.setName(rs.getString("Name"));
				or.setEmail(rs.getString("E-Mail"));
				Partnerprofil p = new Partnerprofil();
				p.setId(rs.getInt("partnerprofil_id"));
				or.setPartnerprofil(p);
				return or;
			}
		} catch (SQLException e) {
		}
		return o;
	}

	public Organisationseinheit getByEmail(Organisationseinheit o) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			System.out.println("SELECT * FROM organisationseinheit WHERE `E-Mail` = '" + o.getEmail() + "'"); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM organisationseinheit WHERE `E-Mail` = '" + o.getEmail() + "'");
			if (rs.next()) {
				Organisationseinheit or = new Organisationseinheit();
				or.setId(rs.getInt("Organisationseinheit_ID"));
				or.setName(rs.getString("Name"));
				or.setEmail(rs.getString("E-Mail"));
				Partnerprofil p = new Partnerprofil();
				p.setId(rs.getInt("partnerprofil_id"));
				or.setPartnerprofil(p);
				return or;
			}
		} catch (SQLException e) {
		}
		return null;
	}
	
	public Organisationseinheit getByPartnerprofilId(Partnerprofil pp) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM `organisationseinheit` WHERE `partnerprofil_id` = " + pp.getId());
			if (rs.next()) {
				Organisationseinheit or = new Organisationseinheit();
				or.setId(rs.getInt("Organisationseinheit_ID"));
				or.setName(rs.getString("Name"));
				or.setEmail(rs.getString("E-Mail"));
				Partnerprofil p = new Partnerprofil();
				p.setId(rs.getInt("partnerprofil_id"));
				or.setPartnerprofil(p);
				return or;
			}
		} catch (SQLException e) {
		}
		return null;
	}
	
	public ArrayList<Organisationseinheit> getAll() throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Organisationseinheit> result = new ArrayList<Organisationseinheit>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `organisationseinheit`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */

				while (rs.next()) {
					Organisationseinheit o = new Organisationseinheit();
					o.setId(rs.getInt("Organisationseinheit_ID"));
					o.setName(rs.getString("Name"));
					o.setEmail(rs.getString("E-Mail"));
					Partnerprofil p = new Partnerprofil();
					p.setId(rs.getInt("partnerprofil_id"));
					o.setPartnerprofil(p);
					result.add(o);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
