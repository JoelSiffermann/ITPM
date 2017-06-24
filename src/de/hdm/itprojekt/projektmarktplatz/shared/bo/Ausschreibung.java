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
	   *  Konstruktur:  fügt dem Objekt Eigenschaften hinzu 
	   */ 
	
	public Ausschreibung(String bezeichnung, String inhalt, Date frist)
	{
		this.bezeichnung=bezeichnung; 
		this.inhalt=inhalt;
		this.frist=frist;
	}
	// Auslesen der Bezeichhnung
	
	 public String getBezeichnung() {
		    return bezeichnung;
		  }
	 
	 //Auslesen des Inhalts
	 
	 public String getInhalt() {
		 
		 return inhalt;
	 }
	 
	 //Auslesen der Frist
	 
	 public Date getFrist(){
		 return frist;
	 }
	 // Setzen der Bezeichnung einer Ausschreibung
	public void setBezeichnung(String string) {
	    bezeichnung = string;
	}
	
	// Setzt den Inhalt einer Ausschreibung 
	
	public void setInhalt(String string){
		inhalt = string;
	}
	
	// Setzt die Frist fï¿½r die Gï¿½ltigkeit einer Ausschreibung bzw. wie lange man sich bewerben kann
	public void setFrist(Date date){
		frist= date;
	}




	//Auslesen von Projekten

	public Projekt getProjekt() {
		return projekt;
	}




	//Auslesen von Partnerprofilen

	public Partnerprofil getPartnerprofil() {
		return partnerprofil;
	}




	//Setzt die Werte eines Projekts 

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}



	//Legt ein neues Partnerprofil an


	public void setPartnerprofil(Partnerprofil partnerprofil) {
		this.partnerprofil = partnerprofil;
	}
	
	
	
}
