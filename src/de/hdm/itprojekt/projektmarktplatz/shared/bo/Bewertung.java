package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Bewertung extends BusinessObjekt {
	
	private static final long serialVersionUID = 1L;

	private String inhalt;
	private float skala;
	private Person person;
	
	
	
	public Bewertung(){
		
	}
	
	public Bewertung(String inhalt, float skala){
		
		this.inhalt=inhalt;
		this.skala=skala;
	}

	public String getInhalt(){
		
		return inhalt;
	}
	
	public float getSkala(){
		
		return skala;
	}
	
	public void setInhalt(String string){
		
		inhalt=string;
	}
	
	public void setSkala(float skala){
		
		skala= skala;
	}

	public Person getPerson(){
		return this.person;
	}
	
	public void setPerson (Person p){
		this.person=p;
	}
	
}


