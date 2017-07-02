package de.hdm.itprojekt.projektmarktplatz.shared.bo;
import java.util.Date;

public class Bewerbung extends BusinessObjekt {

	private static final long serialVersionUID = 1L;

	private String inhalt;
	private Date erstelldatum;
	private Ausschreibung ausschreibung;
	private Organisationseinheit bewerber;
	
	/**
	 * auslesen der Ausschreibung
	 * @return Ausschreibung
	 */
	
	public Ausschreibung getAusschreibung(){
		return this.ausschreibung;
	}
	/**
	 * setzt die Ausschreibung
	 * @param a Ausschreibung
	 */
	public void setAusschreibung(Ausschreibung a){
		this.ausschreibung=a;
	}
	/**
	 * gibt den Inhalt zurück
	 * @return Inhalt
	 */
	public String getInhalt(){
		
		return inhalt;
	}
	
	/**
	 * gibt das erstelldatum zurück
	 * @return erstelldatum
	 */
	public Date getErstelldatum(){
		
		return erstelldatum;
	}
	/**
	 * setzt den Inhalt
	 * @param string String
	 */
	public void setInhalt(String string){
		
		inhalt=string;
	}
	/**
	 * setzt das Erstelldatum
	 * @param date Date
	 */
	
	public void setErstelldatum(Date date){
		
		erstelldatum=date;
	}

	/**
	 *auslesen des Bewerbers
	 * @return bewerber
	 */
	public Organisationseinheit getBewerber() {
		return bewerber;
	}

	/**
	 * setzt den Bewerber
	 * @param bewerber Organisationseinheit
	 */
	public void setBewerber(Organisationseinheit bewerber) {
		this.bewerber = bewerber;
	}
	
}

