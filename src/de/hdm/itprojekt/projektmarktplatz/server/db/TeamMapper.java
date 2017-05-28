package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Team;

//@autor �mer
public class TeamMapper {
	private static TeamMapper teamMapper = null;

	protected TeamMapper() {

	}

	public static TeamMapper bewerbungMapper() {
		if (teamMapper == null) {
			teamMapper = new TeamMapper();
		}
		return teamMapper;
	}

	public Team einfuegen(Team t) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			// ResultSet rs = stmt.executeQuery("INSERT INTO `team` (`Groesse`,
			// `Arbeitsfeld`, `ID`, `o_id`) VALUES ('5', 'Teamleiter', NULL,
			// '2');");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// t.setId(rs.getInt("") + 1);
			stmt = con.createStatement();
			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate("INSERT INTO `team` (`Groesse`, `Arbeitsfeld`, `ID`, `o_id`) VALUES ('" + t.getGroesse()
					+ "', '" + t.getArbeitsfeld() + "', " + t.getId() + ", '" + t.getOrganisationseinheit().getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public Team speichern(Team t) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE `team` SET `Groesse` = '" + t.getGroesse() + "', `Arbeitsfeld` = '"
					+ t.getArbeitsfeld() + "', `ID` = '" + t.getId() + "', `o_id` = '"
					+ t.getOrganisationseinheit().getId() + "' WHERE `team`.`ID` = " + t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public void loeschen(Team t) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `team` WHERE ID = " + t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Team getById(Team t) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `team` WHERE `ID` = " + t.getId());
			if (rs.next()) {
				Team tm = new Team();
				tm.setGroesse(rs.getInt("Groesse"));
				tm.setArbeitsfeld(rs.getString("Arbeitsfeld"));
				tm.setId(rs.getInt("ID"));
				Organisationseinheit o = new Organisationseinheit();
				o.setId(rs.getInt("o_id"));
				tm.setOrganisationseinheit(o);

				return tm;
			}
		} catch (SQLException e) {
		}
		return t;
	}

	public ArrayList<Team> getAll() throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Team> result = new ArrayList<Team>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `team`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Team t = new Team();
					t.setGroesse(rs.getInt("Groesse"));
					t.setArbeitsfeld(rs.getString("Arbeitsfeld"));
					t.setId(rs.getInt("ID"));
					Organisationseinheit o = new Organisationseinheit();
					o.setId(rs.getInt("o_id"));
					t.setOrganisationseinheit(o);
					result.add(t);
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
