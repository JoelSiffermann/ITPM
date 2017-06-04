package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AusschreibungForm extends VerticalPanel {

	public AusschreibungForm(){
		
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
	   
	    Label beschreibung = new Label("Beschreibung");
	    ausschreibungText.setHeight("200");
	    ausschreibungText.setWidth("200");
	      
	    //add text to text area
	    ausschreibungText.setText("");
	    ausschreibungText.getElement().setPropertyString("placeholder", "Ausschreibungstext");

	    // Add text boxes to the root panel.
	    ausschreibungTextPanel.add(beschreibung);
	    ausschreibungTextPanel.add(ausschreibungText);  
		
//		**********************************************
		VerticalPanel vpUnten = new VerticalPanel();
		
		Button btSpeichern = new Button("Speichern");
//		btSpeichern.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				Button bt = new Button(ausschreibungText.getText());
//				vpKopf.add(bt);
//			}
//		});
		
		vpUnten.add(btSpeichern); 
		
		this.add(vpKopf);
		vpKopf.add(ausschreibungTextPanel); 
		vpKopf.add(vpUnten);
	}

}
