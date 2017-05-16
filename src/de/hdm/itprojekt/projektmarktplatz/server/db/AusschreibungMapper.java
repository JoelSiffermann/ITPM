package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
//@author samina
public class AusschreibungMapper {

	public static AusschreibungMapper ausschreibungMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public Ausschreibung einfuegen(Ausschreibung a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
//			ResultSet rs = stmt.executeQuery("");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
//				a.setId(rs.getInt("Ausschreibung_ID") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO `ausschreibung` (`Ausschreibung_ID`, `Bezeichnung`, `Inhalt`, `Frist`) VALUES (NULL, 'Bezeichnung test 1', 'test 1', '01012017');");
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Ausschreibung speichern(Ausschreibung a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `ausschreibung` SET `Inhalt` = 'test 12' WHERE `ausschreibung`.`Ausschreibung_ID` = 1;");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}
	
	public void loeschen(Ausschreibung a) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM `ausschreibung` WHERE Ausschreibung_ID = 1");
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	public Ausschreibung getById(Ausschreibung a){
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("");
		    }
		    catch (SQLException e) {
		    	
		    }
		    return a;
	}
	public ArrayList<Ausschreibung> getAll(){
		
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
			//	a.setId(rs.getInt("") + 1);
//TODO While Schleife und Objekt erzeugen wie bei Bank Projekt findAll() bei TransactionsMappers
				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
//				stmt.executeUpdate("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
