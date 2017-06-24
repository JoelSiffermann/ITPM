package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface MainNavigation extends Constants {
	
	/*
	 * Neues Design test
	 */
	
    String[] cwStackPanelContacts();

    String[] cwStackPanelContactsEmails();

    String cwStackPanelContactsHeader();

    String cwStackPanelDescription();

    String[] cwStackPanelFilters();

    String cwStackPanelFiltersHeader();

    String[] cwStackPanelMailFolders();

    String cwStackPanelMailHeader();

    String cwStackPanelName();

	void add(VerticalPanel vpMainNavigation);
    
  }

