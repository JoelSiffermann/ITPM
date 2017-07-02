package de.hdm.itprojekt.projektmarktplatz.shared.bo;
/**
 * 
 * @author samina
 *
 */
public class Projektmarktplatz extends BusinessObjekt {
	
	private static final long serialVersionUID = 1L;

	private String bezeichnung = "";

	public Projektmarktplatz (){

	} 
	/**
	 * Konstruktor
	 * @param bezeichnung String
	 */
	public Projektmarktplatz (String bezeichnung){
		this.bezeichnung = bezeichnung;
	}
	/**
	 * auslesen von Bezeichnung
	 * @return bezeichnung
	 */
	public String getBezeichnung (){
		return bezeichnung;
	}
	/**
	 * setzen von Bezeichnung
	 * @param string String
	 */
	public void setBezeichnung (String string){
		this.bezeichnung = string;
	}
}

