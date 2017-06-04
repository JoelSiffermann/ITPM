package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

public class AusschreibungPanel extends VerticalPanel{

	public AusschreibungPanel(){
		// muss hier dynamisch sein Ausschreibung
		
		final FlexTable ftKenntnis = new FlexTable();
		final Grid grid = new Grid(7, 2);
		
		Button btAdd = new Button("+");
		Button btA1 = new Button("Ausschreibung speichern");
		Button btA2 = new Button("Ausschreibung entfernen");
		TextBox tbKenntnis = new TextBox();
		TextBox tbJahr = new TextBox();
		TextBox tbBeruf = new TextBox();
		
		TextBox bez = new TextBox();
		TextArea inhalt = new TextArea();
		DatePicker frist = new DatePicker();

		
		VerticalPanel vthis = this;
		
		grid.setWidget(0, 0, new Label("Bezeichnung"));
		grid.setWidget(0, 1, bez); 
		grid.setWidget(1, 0, new Label("Inhalt"));
		grid.setWidget(1, 1, inhalt);
		grid.setWidget(2, 0, new Label("Frist"));
		grid.setWidget(2, 1, frist);
		grid.setWidget(3, 0, btA1);
		grid.setWidget(3, 1, btA2);
		grid.setWidget(4, 0, new Label("Beruf: "));
		grid.setWidget(4, 1, tbBeruf);
		this.add(grid); 
//		*******************************************
		

		tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
		tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");
		
//		grid.setWidget(4, 0, tbKenntnis);
//		grid.setWidget(4, 1, tbJahr);
		ftKenntnis.setWidget(0, 0, tbKenntnis);
		ftKenntnis.setWidget(0, 1, tbJahr);
		
		this.add(ftKenntnis);
		this.add(btAdd);
		
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
//				ftKenntnis.setText(zeile, 2, "Jahr");

//				vthis.add(ftKenntnis);
			}
		});
		

	}
		
	public void clear(Panel p){
//		Window.alert("clickhandler clear");
		p.clear();
	}
	
}
