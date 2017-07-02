package de.hdm.itprojekt.projektmarktplatz.shared.bo;
import java.io.Serializable;

/** in Anlehnung an Bankprojekt
 * Autor: Peter Thies & Christian Rathke
 */

public abstract class BusinessObjekt implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private int id = 0;
	
	  /*
     * Abfragen, ob ein Objekt ungleich NULL ist und ob ein Objekt gecastet
     * werden kann, sind immer wichtig!
     */
//	public boolean equals(Object obj) {
//		if (obj != null && obj instanceof BusinessObjekt) {
//		      BusinessObjekt bo = (BusinessObjekt) obj;
//		      try {
//		        if (bo.getId() == this.id)
//		          return true;
//		      }
//		      catch (IllegalArgumentException e) {
//		      
//		        return false;
//		     }
//		  }
//		    return false;
//	}
	
	public String toString(){
		return this.getClass().getName()+"#"+this.id;
	}
	/**
	 * auslesen der Id
	 * @return id
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * setzt die ID
	 * @param id int
	 */
	public void setId(int id){
		this.id = id;
	}
	
	
	public int hashCode() {
		  return this.id;
	 }

	
}


