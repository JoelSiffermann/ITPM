package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Person extends BusinessObjekt {

	private static final long serialVersionUID = 1L;
	private String vorname; 
	private String beruf;
	private float erfahrung;
	
	public Person(){
		
	}

	
	public Person(String name, String email, String vorname, String beruf, float erfahrung){
//		super(name, email);
		this.vorname=vorname;
		this.beruf=beruf;
		this.erfahrung=erfahrung;
		
	}
	
	public String getVorname(){
		
		return vorname;
	}
	
	public String getBeruf(){
		
		return beruf;
	}
	
	public float getErfahrung(){
		
		return erfahrung;
	}
	
	public void setVorname(String string){
		
		vorname=string;
	}
	public void setBeruf(String string){
		
		beruf=string;
	}
	public void setErfahrung(float Float){
		
		erfahrung=Float;
	}
}

