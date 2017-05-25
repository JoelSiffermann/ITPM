package de.hdm.itprojekt.projektmarktplatz.shared.bo;
import java.util.Date;

public class Bewerbung extends BusinessObjekt {

	private static final long serialVersionUID = 1L;

	private String inhalt;
	private Date erstelldatum;
	private Ausschreibung ausschreibung;
	
	
	public Ausschreibung getAusschreibung(){
		return this.ausschreibung;
	}
	
	public void setAusschreibung(Ausschreibung a){
		this.ausschreibung=a;
	}
	
	public String getInhalt(){
		
		return inhalt;
	}
	
	public Date getErstelldatum(){
		
		return erstelldatum;
	}
	
	public void setInhalt(String string){
		
		inhalt=string;
	}
	
	public void setErstelldatum(Date date){
		
		erstelldatum=date;
	}
	
}

