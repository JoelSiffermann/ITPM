package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

//@autor �mer
public class ProjektmarktplatzMapper {
	private static ProjektmarktplatzMapper projektmarktplatzMapper = null;

	protected ProjektmarktplatzMapper() {

	}

	public static ProjektmarktplatzMapper projektmarktplatzMapper() {
		if (projektmarktplatzMapper == null) {
			projektmarktplatzMapper = new ProjektmarktplatzMapper();
		}
		return projektmarktplatzMapper;
	}

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
			stmt = con.createStatement();
			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate("INSERT INTO `projektmarktplatz` (`Projektmarktplatz_ID`, `Bezeichnung`) VALUES ('"
					+ p.getId() + "', '" + p.getBezeichnung() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

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

	public void loeschen(Projektmarktplatz p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `projektmarktplatz` WHERE Projektmarktplatz_ID =" + p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
			if (rs.next()) {
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
				stmt.executeUpdate("");
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
