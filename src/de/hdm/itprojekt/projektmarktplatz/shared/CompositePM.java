package de.hdm.itprojekt.projektmarktplatz.shared;

import java.util.ArrayList;
import java.util.Vector;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class CompositePM {
	private static final long serialVersionUID = 1L;

	  /**
		 * Die Menge der Teil-Reports.
		 */
		private ArrayList<Projektmarktplatz> subPM = new ArrayList<Projektmarktplatz>();

		/**
		 * Hinzufügen eines Teil-Reports.
		 * @param r der hinzuzufügende Teil-Report.
		 */
		public void addSubPM(Projektmarktplatz r) {
			this.subPM.add(r);
		}

		/**
		 * Entfernen eines Teil-Reports.
		 * @param r der zu entfernende Teil-Report.
		 */
		public void removeSubPM(Projektmarktplatz r) {
			this.subPM.remove(r);
		}

		/**
		 * Auslesen der Anzahl von Teil-Reports.
		 * @return int Anzahl der Teil-Reports.
		 */
		public int getNumSubPM() {
			return this.subPM.size();
		}

		/**
		 * Auslesen eines einzelnen Teil-Reports.
		 * @param i Position des Teilreports. Bei n Elementen läuft der Index i von 0
		 * bis n-1.
		 * 
		 * @return Position des Teil-Reports.
		 */	
		public Projektmarktplatz getSubPMAt(int i) {
			return this.subPM.get(i);
		}
}