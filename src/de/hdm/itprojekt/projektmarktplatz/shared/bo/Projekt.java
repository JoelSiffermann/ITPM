package de.hdm.itprojekt.projektmarktplatz.shared.bo;
import java.util.Date;

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
	
	public String getName(){
		return name;
	}
	public Date getStart (){
		return start;
	}
	public Date getEnde(){
		return ende;
	}
	public String getInhalt(){
		return inhalt;
	}
	public void setName(String string){
		name = string;
	}
	public void setStart(Date start){
		this.start = start;
	}
	public void setEnde(Date ende){
		this.ende = ende;
	}
	public void setInhalt(String inhalt){
		this.inhalt = inhalt;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Projektmarktplatz getProjektmarktplatz() {
		return projektmarktplatz;
	}

	public void setProjektmarktplatz(Projektmarktplatz projektmarktplatz) {
		this.projektmarktplatz = projektmarktplatz;
	}

	public Organisationseinheit getProjektleiter() {
		return projektleiter;
	}

	public void setProjektleiter(Organisationseinheit projektleiter) {
		this.projektleiter = projektleiter;
	}
}

