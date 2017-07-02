package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Bewertung extends BusinessObjekt {
	
	private static final long serialVersionUID = 1L;

	private String inhalt;
	private float skala;
	private Organisationseinheit person;
	
	
	
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
		
		this.skala= skala;
	}

	public Organisationseinheit getPerson(){
		return this.person;
	}
	
	public void setPerson (Organisationseinheit p){
		this.person=p;
	}
	
}


