package de.hdm.itprojekt.projektmarktplatz.shared.bo;
import java.util.Date;

public class Bewerbung {

	private static final long serialVersionUID = 1L;

	private String inhalt;
	private Date erstelldatum;
	
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

