package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

//@author samina
public class BewerbungMapper {

	private static BewerbungMapper bewerbungMapper = null;

	protected BewerbungMapper(){
		
	}
	
	public static BewerbungMapper bewerbungMapper() {
		if (bewerbungMapper == null) {
			bewerbungMapper = new BewerbungMapper();
		}

		return bewerbungMapper;
	}

	public Bewerbung einfuegen(Bewerbung b) throws Exception {
		Connection con = DBConnection.connection();
		//1
		String datum = "";

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(b.getErstelldatum());
		//1
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
					"INSERT INTO `bewerbung` (`Bewerbung_ID`, `Inhalt`, `Erstelldatum`, `ausschreibung_id`)" + "VALUES (NULL, '"
							+ b.getInhalt() + "','" +datum+ "', '" + b.getAusschreibung().getId()+"');");
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public Bewerbung speichern(Bewerbung b) throws Exception {
		Connection con = DBConnection.connection();
		String datum = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datum = dateFormat.format(b.getErstelldatum());
		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `bewerbung` SET `Bewerbung_ID` = '"+b.getId()+"', `Inhalt` = '"+b.getInhalt()+"', `Erstelldatum` = '"+ datum +"', `ausschreibung_id` = '"+b.getAusschreibung().getId()+"' WHERE `bewerbung`.`Bewerbung_ID` = "+b.getId()+";");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public void loeschen(Bewerbung b) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM `bewerbung` WHERE Bewerbung_ID = " + b.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Bewerbung getById(Bewerbung b) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM `bewerbung` WHERE `Bewerbung_ID` = " + b.getId());
			if (rs.next()){
				Bewerbung bw = new Bewerbung();
				bw.setId(rs.getInt("Bewerbung_ID"));
				bw.setInhalt(rs.getString("Inhalt"));
				bw.setErstelldatum(rs.getDate("Erstelldatum"));
				Ausschreibung a = new Ausschreibung();

				a.setId(rs.getInt("ausschreibung_id"));

				bw.setAusschreibung(a);
				
				return bw;
			}
		}

		catch (SQLException e) {

		}
		return b;
	}

	public ArrayList<Bewerbung> getAll() throws Exception {

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
