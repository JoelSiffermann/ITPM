package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Team extends BusinessObjekt{

	private static final long serialVersionUID = 1L;
	
	private int groesse;
	private String arbeitsfeld;
	private Organisationseinheit organisationseinheit;
	

	public Team() {
		
	}
	/**
	 *Konstruktor
	 * @param name String
	 * @param email String
	 * @param groesse int
	 * @param arbeitsfeld String
	 */
	public Team (String name, String email, int groesse, String arbeitsfeld) {
//		super(name, email);
		this.groesse = groesse;
		this.arbeitsfeld = arbeitsfeld;
	}
	/**
	 * auslesen von Groesse
	 * @return groesse
	 */
	public int getGroesse(){
		return groesse;
	}
	/**
	 * auslesen von Arbeitsfeld
	 * @return arbeitsfeld
	 */
	public String getArbeitsfeld(){
		return arbeitsfeld;
	}
	/**
	 * setzen von Groesse
	 * @param integer int
	 */
	public void setGroesse(int integer){
		groesse = integer;
	}
	/**
	 * setzen von Arbeitsfeld
	 * @param string String
	 */
	public void setArbeitsfeld(String string){
		arbeitsfeld = string;
	}
	/**
	 * auslesen von Organisationseinheit
	 * @return organisationseinheit
	 */
	public Organisationseinheit getOrganisationseinheit() {
		return organisationseinheit;
	}
	/**
	 * setzen von Organisationseinheit
	 * @param organisationseinheit Organisationseinheit
	 */
	public void setOrganisationseinheit(Organisationseinheit organisationseinheit) {
		this.organisationseinheit = organisationseinheit;
	}
	
}

