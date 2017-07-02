package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Bewertung extends BusinessObjekt {
	
	private static final long serialVersionUID = 1L;

	private String inhalt;
	private float skala;
	private Organisationseinheit person;
	
	
	
	public Bewertung(){
		
	}
	/**
	 * Konstruktor
	 * @param inhalt String
	 * @param skala float
	 */
	public Bewertung(String inhalt, float skala){
		
		this.inhalt=inhalt;
		this.skala=skala;
	}

	/**
	 * auslesen des Inhalts
	 * @return inhalt
	 */
	public String getInhalt(){
		
		return inhalt;
	}
	/**
	 * auslesen der Skala
	 * @return skala
	 */
	
	public float getSkala(){
		
		return skala;
	}
	/**
	 * setzt den Inhalt
	 * @param string String
	 */
	public void setInhalt(String string){
		
		inhalt=string;
	}
	/**
	 * setzt die Skala
	 * @param skala float
	 */
	public void setSkala(float skala){
		
		this.skala= skala;
	}
/**
 * auslesen der Person
 * @return person
 */
	public Organisationseinheit getPerson(){
		return this.person;
	}
	/**
	 * setzt die Person
	 * @param p Organisationseinheit
	 */
	public void setPerson (Organisationseinheit p){
		this.person=p;
	}
	
}


