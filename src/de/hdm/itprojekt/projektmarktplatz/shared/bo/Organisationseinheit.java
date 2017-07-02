package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Organisationseinheit extends BusinessObjekt {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private Partnerprofil partnerprofil;
	

public Organisationseinheit(){
		
	}
	/**
	 * Konstruktor
	 * @param name String
	 * @param email String
	 */
	public Organisationseinheit(String name, String email){
		
		this.name=name;
		this.email=email;
		
	}
	/**
	 * auslesen vom Name
	 * @return name
	 */
	public String getName(){
		
		return name;
	}
	/**
	 * auslesen von Email
	 * @return email
	 */
	public String getEmail(){
		
		return email;
	}
	/**
	 * setzt den Namen
	 * @param string String
	 */
	public void setName(String string){
		
		name=string;
	}
	/**
	 * setzt die Email
	 * @param string String
	 */
	public void setEmail(String string){
		
		email=string;
	}
	/**
	 * auslesen von Partnerprofil
	 * @return partnerprofil
	 */

	public Partnerprofil getPartnerprofil() {
		return partnerprofil;
	}
	/**
	 * setzt das Partnerprofil
	 * @param partnerprofil Partnerprofil
	 */
	public void setPartnerprofil(Partnerprofil partnerprofil) {
		this.partnerprofil = partnerprofil;
	}
	
}

