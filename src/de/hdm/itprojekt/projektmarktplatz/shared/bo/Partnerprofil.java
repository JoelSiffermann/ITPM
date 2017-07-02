package de.hdm.itprojekt.projektmarktplatz.shared.bo;

import java.util.Date;
/**
 * 
 * @author samina
 *
 */
public class Partnerprofil extends BusinessObjekt {

	private static final long serialVersionUID = 1L;

	private Date erstelldatum;
	private Date aenderungsdatum;
	private Organisationseinheit organisationseinheit;
	private Ausschreibung ausschreibung;
	/**
	 * auslesen der Organisationseinheit
	 * @return organisationseinheit
	 */
	public Organisationseinheit getOrganisationseinheit() {
		return this.organisationseinheit;
	}
	/**
	 * setzt die Organisationseinheit
	 * @param p Organisationseinheit
	 */
	public void setOrganisationseinheit(Organisationseinheit p) {
		this.organisationseinheit = p;
	}
	
	public Partnerprofil() {

	}
	/**
	 * Konstruktor
	 * @param erstelldatum Date
	 * @param aenderungsdatum Date
	 */
	public Partnerprofil(Date erstelldatum, Date aenderungsdatum) {
		this.aenderungsdatum = aenderungsdatum;
		this.erstelldatum = erstelldatum;
	}

	/**
	 * auslesen von Erstelldatum
	 * @return erstelldatum
	 */
	public Date getErstelldatum() {
		return erstelldatum;
	}
	/**
	 * auslesen von Aenderungsdatum
	 * @return aenerungsdatum
	 */
	public Date getAenderungsdatum() {
		return aenderungsdatum;
	}
	/**
	 * setzt das Erstelldatum
	 * @param ed Date
	 */
	public void setErstelldatum(Date ed) {
		erstelldatum = ed;
	}
	/**
	 * setzt das Aenderungsdatum
	 * @param ad Date
	 */
	public void setAenderungsdatum(Date ad) {
		aenderungsdatum = ad;
	}
	/**
	 * auslesen der Ausschreibung
	 * @return ausschreibung
	 */
	public Ausschreibung getAusschreibung() {
		return ausschreibung;
	}
	/**
	 * setzt die Ausschreibung
	 * @param ausschreibung Ausschreibung
	 */
	public void setAusschreibung(Ausschreibung ausschreibung) {
		this.ausschreibung = ausschreibung;
	}

}
