package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

//@author samina
public class BewerbungMapper {

	public static BewerbungMapper bewerbungMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	public Bewerbung einfuegen(Bewerbung b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			// ResultSet rs = stmt.executeQuery("");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// b.setId(rs.getInt("") + 1);

			stmt = con.createStatement();

			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate(
					"INSERT INTO `bewerbung` (`Bewerbung_ID`, `Inhalt`, `Erstelldatum`, `ausschreibung_id`) VALUES (NULL, '"
							+ b.getInhalt() + "','" + b.getErstelldatum() + "', '" + b.getAusschreibung().getId());
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public Bewerbung speichern(Bewerbung b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `bewerbung` SET `Inhalt` = '" + b.getInhalt()
					+ "' WHERE `bewerbung`.`Bewerbung_ID` = " + b.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public void loeschen(Bewerbung b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM `bewerbung` WHERE Bewerbung_ID = " + b.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Bewerbung getById(Bewerbung b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("SELECT * FROM `bewerbung` WHERE `Bewerbung_ID` = " + b.getId());
		}

		catch (SQLException e) {

		}
		return b;
	}

	public ArrayList<Bewerbung> getAll() {

		Connection con = DBConnection.connection();
		ArrayList<Bewerbung> result = new ArrayList<Bewerbung>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `bewerbung`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */

				while (rs.next()) {
					Bewerbung b = new Bewerbung();
					b.setId(rs.getInt("Bewerbung_ID"));
					b.setInhalt(rs.getString("Inhalt"));
					b.setErstelldatum(rs.getDate("Erstelldatum"));
					Ausschreibung a = new Ausschreibung();
					a.setId(rs.getInt("ausschreibung_id"));
					b.setAusschreibung(a);
					// a.setId(rs.getInt("") + 1);
					result.add(b);
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
