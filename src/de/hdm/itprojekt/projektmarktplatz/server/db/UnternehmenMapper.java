package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Unternehmen;

//@autor �mer
public class UnternehmenMapper {
	private static UnternehmenMapper unternehmenMapper = null;

	protected UnternehmenMapper() {

	}

	public static UnternehmenMapper unternehmenMapper() {
		if (unternehmenMapper == null) {
			unternehmenMapper = new UnternehmenMapper();
		}
		return unternehmenMapper;
	}

	public Unternehmen einfuegen(Unternehmen u) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			// ResultSet rs = stmt.executeQuery("INSERT INTO `unternehmen`
			// (`Geschaeftsform`, `Geschaeftsfeld`, `ID`, `o_id`) VALUES
			// ('Hochschule', 'IT', NULL, '2');");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// u.setId(rs.getInt("") + 1);
			stmt = con.createStatement();
			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate("INSERT INTO `unternehmen` (`Geschaeftsform`, `Geschaeftsfeld`, `ID`, `o_id`) VALUES ('"
					+ u.getGeschaeftsform() + "', '" + u.getGeschaeftsfeld() + "', '" + u.getId() + "', '"
					+ u.getOrganisationseinheit().getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public Unternehmen speichern(Unternehmen u) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE `unternehmen` SET `Geschaeftsform` = '" + u.getGeschaeftsform()
					+ "', `Geschaeftsfeld` = '" + u.getGeschaeftsfeld() + "', `ID` = '" + u.getId() + "', `o_id` = '"
					+ u.getOrganisationseinheit().getId() + "' WHERE `unternehmen`.`ID` = " + u.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public void loeschen(Unternehmen u) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `unternehmen` WHERE ID = " + u.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Unternehmen getById(Unternehmen u) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `unternehmen` WHERE `ID` = " + u.getId());
			if (rs.next()) {
				Unternehmen un = new Unternehmen();
				un.setGeschaeftsform(rs.getString("Geschaeftsform"));
				un.setGeschaeftsfeld(rs.getString("Geschaeftsfeld"));
				un.setId(rs.getInt("ID"));
				Organisationseinheit o = new Organisationseinheit();
				o.setId(rs.getInt("o_id"));
				un.setOrganisationseinheit(o);

				return un;
			}
		} catch (SQLException e) {
		}
		return u;
	}

	public ArrayList<Unternehmen> getAll() throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Unternehmen> result = new ArrayList<Unternehmen>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `unternehmen`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Unternehmen u = new Unternehmen();
					u.setGeschaeftsform(rs.getString("Geschaeftsform"));
					u.setGeschaeftsfeld(rs.getString("Geschaeftsfeld"));
					u.setId(rs.getInt("ID"));
					Organisationseinheit o = new Organisationseinheit();
					o.setId(rs.getInt("o_id"));
					u.setOrganisationseinheit(o);
					result.add(u);
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
	
	public Unternehmen getByOrgId(Organisationseinheit org) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `unternehmen` WHERE `o_id` = " + org.getId());
			if (rs.next()) {
				Unternehmen u = new Unternehmen();
				u.setGeschaeftsfeld(rs.getString("Geschaeftsfeld"));
				u.setGeschaeftsform(rs.getString("Geschaeftsform"));
				u.setId(rs.getInt("ID"));
				Organisationseinheit o = new Organisationseinheit();
				o.setId(rs.getInt("o_id"));
				u.setOrganisationseinheit(o);

				return u;
			}
		} catch (SQLException e) {
		}
		return null;
	}
}
