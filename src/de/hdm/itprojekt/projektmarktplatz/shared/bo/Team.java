package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Team extends BusinessObjekt{

	private static final long serialVersionUID = 1L;
	
	private int groesse;
	private String arbeitsfeld;
	
	public Team (String name, String email, int groesse, String arbeitsfeld) {
//		super(name, email);
		this.groesse = groesse;
		this.arbeitsfeld = arbeitsfeld;
	}

	public int getGroesse(){
		return groesse;
	}
	public String getArbeitsfeld(){
		return arbeitsfeld;
	}
	public void setGroesse(int integer){
		groesse = integer;
	}
	public void setArbeitsfeld(String string){
		arbeitsfeld = string;
	}
	
}

