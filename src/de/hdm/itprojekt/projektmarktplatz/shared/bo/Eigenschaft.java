package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Eigenschaft extends BusinessObjekt {
	private static final long serialVersionUID = 1L;

	private String bezeichnung;
	private String wert;
	private Partnerprofil partnerprofil;
	
	public Eigenschaft(){
		
	}

	public Partnerprofil getPartnerprofil() {
		return this.partnerprofil;
	}

	public void setPartnerprofil(Partnerprofil p) {
		this.partnerprofil = p;
	}

	public Eigenschaft(String bezeichnung, String wert) {

		this.bezeichnung = bezeichnung;
		this.wert = wert;

	}

	public String getBezeichnung() {

		return bezeichnung;
	}

	public String getWert() {

		return wert;
	}

	public void setBezeichnung(String string) {

		bezeichnung = string;
	}

	public void setWert(String string) {

		wert = string;
	}

}
