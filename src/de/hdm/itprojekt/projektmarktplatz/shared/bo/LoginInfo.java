package de.hdm.itprojekt.projektmarktplatz.shared.bo;

import java.io.Serializable;

public class LoginInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

  private boolean loggedIn = false;
  private String loginUrl;
  private String logoutUrl;
  private String emailAddress;
  private String nickname;

  /**
   * Login wird ausgelesen
   * @return loggedIn
   */
  public boolean isLoggedIn() {
    return loggedIn;
  }

  /**
   * Login wird gesetzt 
   * @param loggedIn boolean
   */
  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  /**
   * auslesen der loginUrl
   * @return loginUrl
   */
  public String getLoginUrl() {
    return loginUrl;
  }
  /**
   * setzt die LoginUrl
   * @param loginUrl String
   */
  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }

  /**
   * auslesen der LogoutUrl
   * @return logoutUrl
   */
  public String getLogoutUrl() {
    return logoutUrl;
  }

  /**
   * setzt die LogoutUrl
   * @param logoutUrl String
   */
  public void setLogoutUrl(String logoutUrl) {
    this.logoutUrl = logoutUrl;
  }
  
  /**
   * auslesen der Email Adresse
   * @return emailAdress
   */
  public String getEmailAddress() {
    return emailAddress;
  }
  /**
   * setzt die Email Adresse
   * @param emailAddress String
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
  /**
   * auslesen vom Nickname
   * @return nickname
   */

  public String getNickname() {
    return nickname;
  }

  /**
   * setzt den Nicknamen
   * @param nickname String
   */
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}
