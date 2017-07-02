package de.hdm.itprojekt.projektmarktplatz.shared.bo;
import java.util.Date;
/**
 * 
 * @author samina
 *
 */
public class Projekt extends BusinessObjekt{

	private static final long serialVersionUID = 1L;

	private String name;
	private Date start;
	private Date ende;
	private String inhalt;
	private Person person;
	private Projektmarktplatz projektmarktplatz;
	private Organisationseinheit projektleiter;
	
	public Projekt(){
		
	}
	/**
	 * auslesen von Name
	 * @return name
	 */
	public String getName(){
		return name;
	}
	/**
	 * auslesen von Start
	 * @return Start
	 */
	public Date getStart (){
		return start;
	}
	/**
	 * auslesen von Ende
	 * @return ende
	 */
	public Date getEnde(){
		return ende;
	}
	/**
	 * auslesen von Inhalt
	 * @return inhalt
	 */
	public String getInhalt(){
		return inhalt;
	}
	/**
	 * setzen von Name
	 * @param string String
	 */
	public void setName(String string){
		name = string;
	}
	/**
	 * setzen von Start
	 * @param start Date
	 */
	public void setStart(Date start){
		this.start = start;
	}
	/**
	 * setzen von Ende
	 * @param ende Date
	 */
	public void setEnde(Date ende){
		this.ende = ende;
	}
	/**
	 * setzen von Inhalt
	 * @param inhalt String
	 */
	public void setInhalt(String inhalt){
		this.inhalt = inhalt;
	}
	/**
	 * auslesen von Person
	 * @return person
	 */

	public Person getPerson() {
		return person;
	}
	/**
	 * setzen von Person
	 * @param person Person
	 */

	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * auslesen von Projektmarktplatz
	 * @return projektmarktplatz
	 */
	public Projektmarktplatz getProjektmarktplatz() {
		return projektmarktplatz;
	}
	/**
	 * setzen von Projektmarktplatz
	 * @param projektmarktplatz Projektmarktplatz
	 */
	public void setProjektmarktplatz(Projektmarktplatz projektmarktplatz) {
		this.projektmarktplatz = projektmarktplatz;
	}
/**
 * auslesen von Projektleiter
 * @return projektleiter
 */
	public Organisationseinheit getProjektleiter() {
		return projektleiter;
	}
/**
 * setzen von Projektleiter
 * @param projektleiter Organisationseinheit
 */
	public void setProjektleiter(Organisationseinheit projektleiter) {
		this.projektleiter = projektleiter;
	}
}

