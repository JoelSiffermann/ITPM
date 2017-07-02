package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Person extends BusinessObjekt {

	private static final long serialVersionUID = 1L;
	private String vorname; 
	private String beruf;
	private float erfahrung;
	private Organisationseinheit organisationseinheit;
	
	public Person(){
		
	}

	/**
	 * 
	 * @param name String
	 * @param email String
	 * @param vorname String
	 * @param beruf String
	 * @param erfahrung float
	 */
	public Person(String name, String email, String vorname, String beruf, float erfahrung){
//		super(name, email);
		this.vorname=vorname;
		this.beruf=beruf;
		this.erfahrung=erfahrung;
		
	}
	/**
	 * auslesen von Vorname
	 * @return vorname
	 */
	public String getVorname(){
		
		return vorname;
	}
	/**
	 * auslesen von Beruf
	 * @return beruf
	 */
	public String getBeruf(){
		
		return beruf;
	}
	/**
	 * auslesen der Erfahrung
	 * @return erfahrung
	 */
	public float getErfahrung(){
		
		return erfahrung;
	}
	/**
	 * setzt den Vornamen
	 * @param string String
	 */
	public void setVorname(String string){
		
		vorname=string;
	}
	/**
	 * setzt den Beruf
	 * @param string String
	 */
	public void setBeruf(String string){
		
		beruf=string;
	}
	/**
	 * setzen von Erfahrung
	 * @param Float float
	 */
	public void setErfahrung(float Float){
		
		erfahrung=Float;
	}

	/**
	 * auslesen von Organisationseinheit
	 * @return organisationseinheit
	 */
	public Organisationseinheit getOrganisationseinheit() {
		return organisationseinheit;
	}

	/**
	 * setzen von Organisationseinheit
	 * @param organisationseinheit Organisationseinheit
	 */
	public void setOrganisationseinheit(Organisationseinheit organisationseinheit) {
		this.organisationseinheit = organisationseinheit;
	}
}

