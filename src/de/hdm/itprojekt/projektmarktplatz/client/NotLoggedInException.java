package de.hdm.itprojekt.projektmarktplatz.client;

import java.io.Serializable;

public class NotLoggedInException extends Exception implements Serializable {
	
  public NotLoggedInException() {
    super();
  }
  /**
   * 
   * @param message String
   */
  public NotLoggedInException(String message) {
    super(message);
  }

}
