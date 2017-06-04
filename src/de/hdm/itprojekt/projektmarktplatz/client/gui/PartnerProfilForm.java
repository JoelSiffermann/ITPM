package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PartnerProfilForm extends VerticalPanel {

	public PartnerProfilForm(){
		
	/**
	 * <p>Kopf für Name und Organisationseinheit</p>
	 * 
	 */

		VerticalPanel vpKopf = new VerticalPanel();
		TextBox tbName = new TextBox();
		TextBox tbVorname = new TextBox();
		TextBox tbOrg = new TextBox();
		TextBox tbBeruf = new TextBox();
		
		tbName.getElement().setPropertyString("placeholder", "Name");
		tbVorname.getElement().setPropertyString("placeholder", "Vorname");
		tbOrg.getElement().setPropertyString("placeholder", "Organisation");
		tbBeruf.getElement().setPropertyString("placeholder", "Beruf");
		vpKopf.add(tbName);
		vpKopf.add(tbVorname);
		vpKopf.add(tbOrg);
		vpKopf.add(tbBeruf); 
		
//		**********************************************
		
	/*
	 * <p>Kenntnisse Bereich </p>
	 */
		// Merke: bei dynamisch auslagern
		final VerticalPanel kBereich = new VerticalPanel();
		final FlexTable ftKenntnis = new FlexTable();
		TextBox tbKenntnis = new TextBox();
		TextBox tbJahr = new TextBox();
		
		tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
		tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");
		
		ftKenntnis.setWidget(0, 0, tbKenntnis);
		ftKenntnis.setWidget(0, 1, tbJahr); 
		ftKenntnis.setText(0, 2, "Jahr");
		
		kBereich.add(ftKenntnis);
		
//		**********************************************
		VerticalPanel vpUnten = new VerticalPanel();
		
		Button btSpeichern = new Button("Speichern");
		Button btAdd = new Button("+");
		btAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				TextBox tbKenntnis = new TextBox();
				TextBox tbJahr = new TextBox();
				int zeile = ftKenntnis.getRowCount() + 1;
				
				tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
				tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");
				ftKenntnis.setWidget(zeile, 0, tbKenntnis);
				ftKenntnis.setWidget(zeile, 1, tbJahr); 
				ftKenntnis.setText(zeile, 2, "Jahr");
				
				kBereich.add(ftKenntnis);
			}
		});
		
		vpUnten.add(btAdd);
		vpUnten.add(btSpeichern); 
		
		this.add(vpKopf);
		this.add(kBereich); 
		this.add(vpUnten);
	}
	
	
}
