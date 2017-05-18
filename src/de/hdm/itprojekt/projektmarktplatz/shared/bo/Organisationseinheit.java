package de.hdm.itprojekt.projektmarktplatz.shared.bo;

public class Organisationseinheit extends BusinessObjekt {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	
	public Organisationseinheit(){
		
	}
	public Organisationseinheit(String name, String email){
		
		this.name=name;
		this.email=email;
		
	}

	public String getName(){
		
		return name;
	}
	
	public String getEmail(){
		
		return email;
	}
	
	public void setName(String string){
		
		name=string;
	}
	public void setEmail(String string){
		
		email=string;
	}
	
}

