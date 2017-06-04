package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProfilForm extends VerticalPanel {

	public ProfilForm() {

		/**
		 * <p>
		 * Kopf für Name und Organisationseinheit
		 * </p>
		 * 
		 */

		final VerticalPanel vpKopf = new VerticalPanel();
		final TextBox tbName = new TextBox();
		final TextBox tbVorname = new TextBox();
		final TextBox tbOrg = new TextBox();
		final TextBox tbBeruf = new TextBox();
		final ListBox listOrg = new ListBox();

		listOrg.addItem("Person");
		listOrg.addItem("Team");
		listOrg.addItem("Unternehmen");

		tbName.getElement().setPropertyString("placeholder", "Name");
		tbVorname.getElement().setPropertyString("placeholder", "Vorname");
//		tbOrg.getElement().setPropertyString("placeholder", "Nickname");
		tbBeruf.getElement().setPropertyString("placeholder", "Beruf");
		vpKopf.add(tbName);
		vpKopf.add(tbVorname);
		vpKopf.add(tbOrg);
		vpKopf.add(listOrg);
		vpKopf.add(tbBeruf);

		// **********************************************

		/*
		 * <p>Kenntnisse Bereich </p>
		 */
		// Merke: bei dynamisch auslagern
		final VerticalPanel kBereich = new VerticalPanel();
		final FlexTable ftKenntnis = new FlexTable();
		final TextBox tbKenntnis = new TextBox();
		final TextBox tbJahr = new TextBox();

		tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
		tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");
		ftKenntnis.setWidget(0, 0, tbKenntnis);
		ftKenntnis.setWidget(0, 1, tbJahr);
		ftKenntnis.setText(0, 2, "Jahr");

		kBereich.add(ftKenntnis);

		// **********************************************
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

		listOrg.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub
				
				switch (listOrg.getSelectedItemText()) {
				case "Person":
					tbVorname.setVisible(true);
					
					break;
				case "Team":
					tbVorname.setVisible(false);
					
					break;
				case "Unternehmen":
					tbVorname.setVisible(false);
					break;
				default:
					break;
				}
			}
		});

		vpUnten.add(btAdd);
		vpUnten.add(btSpeichern);

		this.add(vpKopf);
		vpKopf.add(kBereich);
		vpKopf.add(vpUnten);
	}

}
