package de.hdm.itprojekt.projektmarktplatz.shared.bo;
import java.util.Date;

public class Beteiligung extends BusinessObjekt  {

	private static final long serialVersionUID = 1L;

	private Date start;
	private Date ende; 
	private int umfang;
	
	public Beteiligung(Date start, Date ende, int umfang){
		
		this.start=start;
		this.ende=ende;
		this.umfang=umfang;
	}
	
	// Auslesen wann die Beteiligung gestartet hat
	
	public Date getStart(){
		
		return start;
	}
	
	//Auslesen wann die Betiligung beendet wird
	
	public Date getEnde(){
		
		return ende;
	}
	
	// Auslesen der Personentagen
	
	public int getUmfang(){
		
		return umfang;
	}
	
	// Setzt den Start einer Beteiligung
	public void setStart(Date date){
		
		start=date; 
	}
	//Setzt das Ende einer Beteiligung
	public void setEnde(Date date){
		
		ende=date; 
	}
	
	//Setzt den Umfang in Personentagen
	
	public void setUmfang(int u){
		
		umfang=u; 
	}
}
