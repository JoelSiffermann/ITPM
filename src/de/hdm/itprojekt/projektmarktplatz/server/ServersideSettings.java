package de.hdm.itprojekt.projektmarktplatz.server;

import java.util.logging.Logger;

import de.hdm.itprojekt.projektmarktplatz.shared.CommonSettings;

public class ServersideSettings extends CommonSettings {

	private static final String LOGGER_NAME = "ProjektMarktplatz Server";
	private static final Logger log = Logger.getLogger(LOGGER_NAME);
	
	public static Logger getLogger() {
	   return log;
	}
}
