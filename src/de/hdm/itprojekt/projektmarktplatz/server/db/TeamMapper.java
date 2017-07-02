package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Team;

//@autor �mer
public class TeamMapper {
	private static TeamMapper teamMapper = null;

	protected TeamMapper() {

	}
	/**
	 * @return teamMapper
	 */
	

	public static TeamMapper teamMapper() {
		if (teamMapper == null) {
			teamMapper = new TeamMapper();
		}
		return teamMapper;
	}
	/**
	 * F�gt ein neues Team hinzu
	 * @param t Team
	 * @return t
	 * @throws Exception
	 */

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
	
	/**
	 * F�gt �nderungen an einem Team hinzu
	 * @param t Team
	 * @return t
	 * @throws Exception
	 */

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
	
	/**
	 * Loescht ein Team
	 * @param t Team
	 * @throws Exception
	 */

	public void loeschen(Team t) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `team` WHERE ID = " + t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Liest ein Team 
	 * @param t Team
	 * @return t
	 * @throws Exception
	 */

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

	/**
	 * Zeigt alle Teams an
	 * @return null
	 * @throws Exception
	 */
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
	
	/**
	 * Liest ein Team aus einer Organisationseinheit
	 * @param org Organisationseinheit
	 * @return null
	 * @throws Exception
	 */
	
	public Team getByOrgId(Organisationseinheit org) throws Exception {
		Connection con = DBConnection.connection();
		String sql = "SELECT * FROM `team` WHERE `o_id` = " + org.getId();
		System.out.println(sql);
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `team` WHERE `o_id` = " + org.getId());
			if (rs.next()) {
				Team t = new Team();
				t.setGroesse(rs.getInt("Groesse"));
				t.setArbeitsfeld(rs.getString("Arbeitsfeld"));
				t.setId(rs.getInt("ID"));
				Organisationseinheit o = new Organisationseinheit();
				o.setId(rs.getInt("o_id"));
				t.setOrganisationseinheit(o);

				return t;
			}
		} catch (SQLException e) {
		}
		return null;
	}
}
