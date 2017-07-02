package de.hdm.itprojekt.projektmarktplatz.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;

//@autor �mer
public class PersonMapper {
	private static PersonMapper personMapper = null;

	protected PersonMapper() {

	}

	
	/**
	 * @return personMapper
	 */
	
	
	public static PersonMapper personMapper() {
		if (personMapper == null) {
			personMapper = new PersonMapper();
		}
		return personMapper;
	}

	/**
	 * F�gt eine Person hinzu
	 * @param p Person
	 * @return p
	 * @throws Exception
	 */
	
	public Person einfuegen(Person p) throws Exception {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			// ResultSet rs = stmt.executeQuery("INSERT INTO `person`
			// (`Vorname`, `Beruf`, `Erfahrung`, `ID`, `o_id`) VALUES
			// ('Florian', 'Bankkaufmann', '5', NULL, '1');");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// p.setId(rs.getInt("") + 1);
			stmt = con.createStatement();
			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			stmt.executeUpdate("INSERT INTO `person` (`Vorname`, `Beruf`, `Erfahrung`, `ID`, `o_id`) VALUES " + "('"
					+ p.getVorname() + " ', '" + p.getBeruf() + "', '" + p.getErfahrung() + "', NULL, '"
					+ p.getOrganisationseinheit().getId() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
	/**
	 * Speichert alle �nderungen an einer Person
	 * @param p Person
	 * @return p
	 * @throws Exception
	 */
	
	
	public Person speichern(Person p) throws Exception {
		Connection con = DBConnection.connection();
		System.out.println("Person speichern"); 
		String sql = "UPDATE `person` SET `Vorname` = '" + p.getVorname() + "', `Beruf` = '" + p.getBeruf()
		+ "', " + "`Erfahrung` = '" + p.getErfahrung() + "', `ID` = '" + p.getId() + "', " + "`o_id` = '"
		+ p.getOrganisationseinheit().getId() + "' WHERE `person`.`ID` = " + p.getId()+";";
		System.out.println(sql); 
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE `person` SET `Vorname` = '" + p.getVorname() + "', `Beruf` = '" + p.getBeruf()
					+ "', " + "`Erfahrung` = '" + p.getErfahrung() + "', `ID` = '" + p.getId() + "', " + "`o_id` = '"
					+ p.getOrganisationseinheit().getId() + "' WHERE `person`.`ID` = " + p.getId()+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	/**
	 * Loescht eine Person 
	 * @param p Person
	 * @throws Exception
	 */

	public void loeschen(Person p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `person` WHERE ID = " + p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Liest alle Personen zur Id 
	 * @param p Person
	 * @return p
	 * @throws Exception
	 */

	public Person getById(Person p) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `person` WHERE `ID` = " + p.getId());
			if (rs.next()) {
				Person ps = new Person();
				ps.setVorname(rs.getString("Vorname"));
				ps.setBeruf(rs.getString("Beruf"));
				ps.setErfahrung(rs.getFloat("Erfahrung"));
				ps.setId(rs.getInt("ID"));
				Organisationseinheit o = new Organisationseinheit();
				o.setId(rs.getInt("o_id"));
				ps.setOrganisationseinheit(o);

				return ps;
			}
		} catch (SQLException e) {
		}
		return p;
	}
	
	/**
	 * Liest alle Personen einer Organisationseinheit
	 * @param org Organisationseinheit
	 * @return null
	 * @throws Exception
	 */

	public Person getByOrgId(Organisationseinheit org) throws Exception {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `person` WHERE `o_id` = " + org.getId());
			if (rs.next()) {
				Person ps = new Person();
				ps.setVorname(rs.getString("Vorname"));
				ps.setBeruf(rs.getString("Beruf"));
				ps.setErfahrung(rs.getFloat("Erfahrung"));
				ps.setId(rs.getInt("ID"));
				Organisationseinheit o = new Organisationseinheit();
				o.setId(rs.getInt("o_id"));
				ps.setOrganisationseinheit(o);

				return ps;
			}
		} catch (SQLException e) {
		}
		return null;
	}
	
	/**
	 * Liest alle Personen
	 * @return result
	 * @throws Exception
	 */
	
	public ArrayList<Person> getAll() throws Exception {
		Connection con = DBConnection.connection();
		ArrayList<Person> result = new ArrayList<Person>();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `person`");
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// 								fehler -----> if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				while (rs.next()) {
					Person p = new Person();
					p.setVorname(rs.getString("Vorname"));
					p.setBeruf(rs.getString("Beruf"));
					p.setErfahrung(rs.getFloat("Erfahrung"));
					p.setId(rs.getInt("ID"));
					Organisationseinheit o = new Organisationseinheit();
					o.setId(rs.getInt("o_id"));
					p.setOrganisationseinheit(o);
					result.add(p);
				}
				//fehler -----> 				stmt = con.createStatement();
				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				//fehler ----> 					stmt.executeUpdate("");
				//-----> 						fehler return result;
		//fehler ---> 							}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
