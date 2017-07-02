package de.hdm.itprojekt.projektmarktplatz.shared.bo;

import java.util.Date;
/**
 * 
 * @author samina
 *
 */

public class Beteiligung extends BusinessObjekt {

	private static final long serialVersionUID = 1L;

	private Date start;
	private Date ende;
	private int umfang;
	private Projekt projekt;
	private Organisationseinheit organisationseinheit;

	public Beteiligung(){
		
	}
	/**
	 * gibt die Organisationseinheiten zurück
	 * @return organisationseinheit
	 */
	public Organisationseinheit getOrganisationseinheit() {
		return this.organisationseinheit;
	}
	/**
	 * setzt die Organisationseinheiten
	 * @param o Organisationseinheit
	 */

	public void setOrganisationseinheit(Organisationseinheit o) {
		this.organisationseinheit = o;
	}

	/**
	 * gibt die Projekte zurück
	 * @return projekt
	 */
	public Projekt getProjekt() {
		return this.projekt;
	}
/**
 * setzt die Projekte
 * @param p Projekt
 */
	public void setProjekt(Projekt p) {
		this.projekt = p;
	}
/**
 * Konstruktor
 * @param start Date
 * @param ende Date
 * @param umfang int
 */
	public Beteiligung(Date start, Date ende, int umfang) {

		this.start = start;
		this.ende = ende;
		this.umfang = umfang;
	}


	/**
	 * Auslesen wann die Beteiligung gestartet hat
	 * @return start
	 */

	public Date getStart() {

		return start;
	}


	/**
	 * Auslesen wann die Betiligung beendet wird
	 * @return ende
	 */

	public Date getEnde() {

		return ende;
	}

	
	/**
	 * Auslesen der Personentagen
	 * @return umfang
	 */

	public int getUmfang() {

		return umfang;
	}

	
	/**
	 * Setzt den Start einer Beteiligung
	 * @param date Date
	 */
	public void setStart(Date date) {

		start = date;
	}


	/**
	 * Setzt das Ende einer Beteiligung
	 * @param date Date
	 */
	public void setEnde(Date date) {

		ende = date;
	}

	/**
	 * Setzt den Umfang in Personentagen
	 * @param u int
	 */

	public void setUmfang(int u) {

		umfang = u;
	}
}
