package de.hdm.itprojekt.projektmarktplatz.shared.bo;
import java.util.Date;

/**
 * @author Thies & Rathke
 * @author Ayse
 */

public class Ausschreibung extends BusinessObjekt {
	

	private static final long serialVersionUID = 1L;
	
	/** Die Bezeichnung der Ausschreibung*/
	private String bezeichnung; 
	/** Der Inhalt der Ausschreibung */
	private String inhalt;
	/** Die Frist der Gï¿½ltigkeit einer Ausschreibung */
	private Date frist;
	
	private Projekt projekt;
	
	private Partnerprofil partnerprofil;
	
	 /**
	   * No Argument Constructor
	   */
	
	public Ausschreibung(){
		
	}
	
	 /**
	   *  Konstruktor:  fügt dem Objekt Eigenschaften hinzu 
	   */ 
	
	public Ausschreibung(String bezeichnung, String inhalt, Date frist)
	{
		this.bezeichnung=bezeichnung; 
		this.inhalt=inhalt;
		this.frist=frist;
	}
	
	/**
	 * Auslesen der Bezeichhnung
	 * @return bezeichnung
	 */
	
	 public String getBezeichnung() {
		    return bezeichnung;
		  }
	 
	 
	 /**
	  * Auslesen des Inhalts
	  * @return inhalt
	  */
	 
	 public String getInhalt() {
		 
		 return inhalt;
	 }
	 /**
	  * Auslesen der Frist
	  * @return frist
	  */
	 
	 public Date getFrist(){
		 return frist;
	 }
	 /**
	  * setzt die Bezeichnungen
	  * @param string String
	  */

	public void setBezeichnung(String string) {
	    bezeichnung = string;
	}
	
	 
	/**
	 * Setzt den Inhalt einer Ausschreibung
	 * @param string String
	 */
	public void setInhalt(String string){
		inhalt = string;
	}
	
	
	/**
	 * Setzt die Frist fuer die Guetigkeit einer Ausschreibung bzw. wie lange man sich bewerben kann
	 * @param date Date
	 */
	public void setFrist(Date date){
		frist= date;
	}





/**
 * Auslesen von Projekten
 * @return projekt
 */
	public Projekt getProjekt() {
		return projekt;
	}




	
	/**Auslesen von Partnerprofilen
	 * @return partnerprofil
	 */

	public Partnerprofil getPartnerprofil() {
		return partnerprofil;
	}




	
	/**
	 * Setzt die Werte eines Projekts 
	 * @param projekt Projekt
	 */

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}





/**
 * Legt ein neues Partnerprofil an
 * @param partnerprofil Partnerprofil
 */
	public void setPartnerprofil(Partnerprofil partnerprofil) {
		this.partnerprofil = partnerprofil;
	}
	
	
	
}
