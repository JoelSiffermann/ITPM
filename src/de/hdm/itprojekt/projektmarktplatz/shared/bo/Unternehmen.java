package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Unternehmen extends BusinessObjekt{
	
	private static final long serialVersionUID = 1L;

	private String geschaeftsform; 
	private String geschaeftsfeld;
	private Organisationseinheit organisationseinheit;
	
	/*Konstruktor */
	
	public Unternehmen () {
		
	}
	/**
	 * Konstruktor
	 * @param name String
	 * @param email String
	 * @param geschaeftsform String
	 * @param geschaeftsfeld String
	 */
	public Unternehmen (String name, String email,String geschaeftsform, String geschaeftsfeld){

//		super(name, email);
		this.geschaeftsform = geschaeftsform;
		this.geschaeftsfeld = geschaeftsfeld;
	}

	/**
	 * auslesen von geschaeftsform
	 * @return geschaeftsform
	 */
	public String getGeschaeftsform(){
		return geschaeftsform;
	}
	/**
	 * auslesen von geschaeftsfeld
	 * @return geschaeftsfeld
	 */
	public String getGeschaeftsfeld(){
		return geschaeftsfeld;
	}
	/**
	 * setzen von geschaeftsform
	 * @param string String
	 */
	public void setGeschaeftsform(String string){
		geschaeftsform = string;
	}
	/**
	 * setzen von geschaeftsfeld
	 * @param string String
	 */
	public void setGeschaeftsfeld(String string){
		geschaeftsfeld = string;
	}

	/**
	 * auslesen von organisationseinheit
	 * @return organisationseinheit
	 */
	public Organisationseinheit getOrganisationseinheit() {
		return organisationseinheit;
	}

	/**
	 * setzen von organisationseinheit
	 * @param organisationseinheit organisationseinheit
	 */
	public void setOrganisationseinheit(Organisationseinheit organisationseinheit) {
		this.organisationseinheit = organisationseinheit;
	}
	
}

