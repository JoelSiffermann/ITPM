package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Unternehmen extends BusinessObjekt{
	
	private static final long serialVersionUID = 1L;

	private String geschaeftsform; 
	private String geschaeftsfeld;
	private Organisationseinheit organisationseinheit;
	
	/*Konstruktor */
	
	public Unternehmen () {
		
	}

	public Unternehmen (String name, String email,String geschaeftsform, String geschaeftsfeld){

//		super(name, email);
		this.geschaeftsform = geschaeftsform;
		this.geschaeftsfeld = geschaeftsfeld;
	}

	
	public String getGeschaeftsform(){
		return geschaeftsform;
	}
	public String getGeschaeftsfeld(){
		return geschaeftsfeld;
	}
	public void setGeschaeftsform(String string){
		geschaeftsform = string;
	}
	public void setGeschaeftsfeld(String string){
		geschaeftsfeld = string;
	}


	public Organisationseinheit getOrganisationseinheit() {
		return organisationseinheit;
	}


	public void setOrganisationseinheit(Organisationseinheit organisationseinheit) {
		this.organisationseinheit = organisationseinheit;
	}
	
}

