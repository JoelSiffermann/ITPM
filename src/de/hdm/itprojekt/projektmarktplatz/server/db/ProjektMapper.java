package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;
import de.hdm.itprojekt.projektmarktplatz.server.db.DBConnection;

//@autor �mer
public class ProjektMapper {
	private static ProjektMapper projektMapper = null;

	protected ProjektMapper() {

	}

	public static ProjektMapper projektMapper() {
		if (projektMapper == null) {
			projektMapper = new ProjektMapper();
		}
		return projektMapper;
	}

	public Projekt einfuegen(Projekt p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			// ResultSet rs = stmt.executeQuery("INSERT INTO `projekt`
			// (`Projekt_ID`, `Name`, `Start`, `Ende`, `Inhalt`,
			// `projektmarktplatz_id`, `person_id`) VALUES (NULL, 'Excel',
			// '2017-05-01', '2017-05-05', 'Tabellen anlegen', '1', '1');");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// p.setId(rs.getInt("") + 1);
			stmt = con.createStatement();
			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate("INSERT INTO `projekt` (`Projekt_ID`, `Name`, `Start`, `Ende`, `Inhalt`, "
					+ "`projektmarktplatz_id`, `person_id`) VALUES " + "('" + p.getId() + "', '" + p.getName() + "', '"
					+ p.getStart() + "', '" + p.getEnde() + "', " + "'" + p.getInhalt() + "', '"
					+ p.getProjektmarktplatz().getId() + "', '" + p.getPerson().getId() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public Projekt speichern(Projekt p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE `projekt` SET `Projekt_ID` = '" + p.getId() + "', `Name` = '" + p.getName()
					+ "', " + "`Start` = '" + p.getStart() + "', `Ende` = '" + p.getEnde() + "', `Inhalt` = '"
					+ p.getInhalt() + "', " + "`projektmarktplatz_id` = '" + p.getProjektmarktplatz().getId()
					+ "', `person_id` = '" + p.getPerson().getId() + "" + "' WHERE `projekt`.`Projekt_ID` = "
					+ p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public void loeschen(Projekt p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `projekt` WHERE Projekt_ID = " + p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Projekt getById(Projekt p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projekt` WHERE `Projekt_ID` = " + p.getId());
			if (rs.next()) {
				Projekt pr = new Projekt();
				pr.setId(rs.getInt("Projekt_ID"));
				pr.setName(rs.getString("Name"));
				pr.setStart(rs.getDate("Start"));
				pr.setEnde(rs.getDate("Ende"));
				Projektmarktplatz pm = new Projektmarktplatz();
				Person ps = new Person();
				pm.setId(rs.getInt("projektmarktplatz_id"));
				pr.setProjektmarktplatz(pm);

				ps.setId(rs.getInt("person_id"));

				pr.setPerson(ps);
				return pr;
			}
		} catch (SQLException e) {
		}
		return p;
	}

	public ArrayList<Projekt> getAllByProjektmarktplatz(Projektmarktplatz pr) throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Projekt> result = new ArrayList<Projekt>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projekt` WHERE `projektmarktplatz_id` = " + pr.getId());
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Projekt p = new Projekt();
					p.setId(rs.getInt("Projekt_ID"));
					p.setName(rs.getString("Name"));
					p.setStart(rs.getDate("Start"));
					p.setEnde(rs.getDate("Ende"));
					Projektmarktplatz pm = new Projektmarktplatz();
					Person ps = new Person();
					pm.setId(rs.getInt("projektmarktplatz_id"));
					p.setProjektmarktplatz(pm);

					ps.setId(rs.getInt("person_id"));

					p.setPerson(ps);
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
	
	public ArrayList<Projekt> getAll() throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Projekt> result = new ArrayList<Projekt>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `projekt`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Projekt p = new Projekt();
					p.setId(rs.getInt("Projekt_ID"));
					p.setName(rs.getString("Name"));
					p.setStart(rs.getDate("Start"));
					p.setEnde(rs.getDate("Ende"));
					Projektmarktplatz pm = new Projektmarktplatz();
					Person ps = new Person();
					pm.setId(rs.getInt("projektmarktplatz_id"));
					p.setProjektmarktplatz(pm);

					ps.setId(rs.getInt("person_id"));

					p.setPerson(ps);
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
