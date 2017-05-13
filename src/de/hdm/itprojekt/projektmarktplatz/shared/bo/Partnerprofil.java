package de.hdm.itprojekt.projektmarktplatz.shared.bo;

import java.util.Date;

public class Partnerprofil {
	
	private static final long serialVersionUID = 1L;

	private Date erstelldatum;
	private Date aenderungsdatum;
	
	public Partnerprofil (Date erstelldatum, Date aenderungsdatum){
		this.aenderungsdatum = aenderungsdatum;
		this.erstelldatum = erstelldatum;
	}
	public Date getErstelldatum (){
		return erstelldatum;
	}
	public Date getAenderungsdatum (){
		return aenderungsdatum;
	}
	public void setErstelldatum (Date ed){
		erstelldatum = ed;
	}
	public void setAenderungsdatum (Date ad){
		aenderungsdatum = ad;
	}

}

