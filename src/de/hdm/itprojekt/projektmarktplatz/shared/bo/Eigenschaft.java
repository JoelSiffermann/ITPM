package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Eigenschaft extends BusinessObjekt {
	private static final long serialVersionUID = 1L;

	private String bezeichnung;
	private String wert;
	private Partnerprofil partnerprofil;
	
	public Eigenschaft(){
		
	}
	/**
	 * auslesen von Partnerprofil
	 * @return partnerprofil
	 */
	public Partnerprofil getPartnerprofil() {
		return this.partnerprofil;
	}
	/**
	 * setzt das Partnerprofil
	 * @param p Partnerprofil
	 */
	public void setPartnerprofil(Partnerprofil p) {
		this.partnerprofil = p;
	}
	/**
	 * Konstruktor
	 * @param bezeichnung String
	 * @param wert Strig
	 */
	public Eigenschaft(String bezeichnung, String wert) {

		this.bezeichnung = bezeichnung;
		this.wert = wert;

	}
	/**
	 * auslesen der Bezeichnung
	 * @return bezeichnung
	 */
	public String getBezeichnung() {

		return bezeichnung;
	}
	/**
	 * auslesen von Wert
	 * @return wert 
	 */
	public String getWert() {

		return wert;
	}
 /**
  * setzt die Bezeichnung
  * @param string String
  */
	public void setBezeichnung(String string) {

		bezeichnung = string;
	}
	/**
	 * setzt den Wert
	 * @param string String
	 */
	public void setWert(String string) {

		wert = string;
	}

}
