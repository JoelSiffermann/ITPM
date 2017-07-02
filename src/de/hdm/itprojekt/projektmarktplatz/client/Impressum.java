package de.hdm.itprojekt.projektmarktplatz.client;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends VerticalPanel{
	
	final Label lbHeader = new Label("Impressum");
	final FlexTable table = new FlexTable();
	/**
	 * Impressum mit Namen befüllen
	 */
	public void onLoad(){
		super.onLoad();
		lbHeader.setStyleName("ImprHeader");
		table.setStyleName("ImprTable");
		table.setText(0, 0, "Gruppe");
		table.setText(1, 0, "Ayse Gulay");
		table.setText(2, 0, "Ersin Barut");
		table.setText(3, 0, "Joel Siffermann");
		table.setText(4, 0, "Omer Tunckasik");
		table.setText(5, 0, "Samina Ahmed");
		table.setText(6, 0, "Vi Quan Tran");
		table.setText(0, 1, "10");
		table.setText(1, 1, "(31168)");
		table.setText(2, 1, "(30462)");
		table.setText(3, 1, "(26495)");
		table.setText(4, 1, "(29524)");
		table.setText(5, 1, "(30356)");
		table.setText(6, 1, "(30691)");
		this.add(lbHeader);
		this.add(table);
	}
	
}
