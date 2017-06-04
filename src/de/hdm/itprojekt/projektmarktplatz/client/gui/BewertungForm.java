package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BewertungForm extends VerticalPanel {

	public BewertungForm(){
		
	/**
	 * <p>Kopf für Ausschreibungstitel</p>
	 * 
	 */

		VerticalPanel vpKopf = new VerticalPanel();
		TextBox tbTitel = new TextBox();
		
		tbTitel.getElement().setPropertyString("placeholder", "Name");
		vpKopf.add(tbTitel);

//		**********************************************
		
	/*
	 * <p>Kenntnisse Bereich </p>
	 */
		// Merke: bei dynamisch auslagern
	    VerticalPanel ausschreibungTextPanel = new VerticalPanel();
		//create RichTextArea elements
	    RichTextArea ausschreibungText = new RichTextArea(); 
	      
	    ausschreibungText.setHeight("200");
	    ausschreibungText.setWidth("200");
	      
	    //add text to text area
	    ausschreibungText.setText("");
	    ausschreibungText.getElement().setPropertyString("placeholder", "Ausschreibungstext");

	    // Add text boxes to the root panel.
	    ausschreibungTextPanel.add(ausschreibungText);  
		
//		**********************************************
		VerticalPanel vpUnten = new VerticalPanel();
		
		Button btSpeichern = new Button("Speichern");
		Button btAdd = new Button("+");
		
		vpUnten.add(btAdd);
		vpUnten.add(btSpeichern); 
		
		this.add(vpKopf);
		this.add(ausschreibungTextPanel); 
		this.add(vpUnten);
	}

}
