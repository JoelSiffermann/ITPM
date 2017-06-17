package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Partnerprofil;

public class ProfilForm extends VerticalPanel {
	
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
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
		final TextBox tbBeruf = new TextBox();
		final ListBox listOrg = new ListBox();
		final Label lbKenntnisse = new Label("Kenntnisse");
		final TextBox tbGroesse = new TextBox();
		final TextBox tbArbeitsfeld = new TextBox();
		final TextBox tbGeschform = new TextBox ();
		final TextBox tbGeschfeld = new TextBox ();

		
		listOrg.addItem("Person");
		listOrg.addItem("Team");
		listOrg.addItem("Unternehmen");

		tbName.getElement().setPropertyString("placeholder", "Name");
		tbVorname.getElement().setPropertyString("placeholder", "Vorname");
//		tbOrg.getElement().setPropertyString("placeholder", "Nickname");
		tbBeruf.getElement().setPropertyString("placeholder", "Beruf");
		
		tbGroesse.getElement().setPropertyString("placeholder", "Groesse");
		tbGroesse.setVisible(false);
		
		tbArbeitsfeld.getElement().setPropertyString("placeholder", "Arbeitsfeld");
		tbArbeitsfeld.setVisible(false);
		
		tbGeschform.getElement().setPropertyString("placeholder", "Geschaeftsform");
		tbGeschform.setVisible(false);
		
		tbGeschfeld.getElement().setPropertyString("placeholder", "Geschaeftsfeld");
		tbGeschfeld.setVisible(false);
		
		vpKopf.add(listOrg);
		vpKopf.add(tbName);
		vpKopf.add(tbVorname);
//		vpKopf.add(tbOrg);
		
		vpKopf.add(tbGroesse);
		vpKopf.add(tbArbeitsfeld);
		
		vpKopf.add(tbGeschform);
		vpKopf.add(tbGeschfeld);
		
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

				/*tbKenntnis.getElement().setPropertyString("placeholder", "Kenntnisse");
				tbJahr.getElement().setPropertyString("placeholder", "Anzahl der Jahre");*/
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
//				
//				switch (listOrg.getSelectedItemText()) {
//				case "Person":
//					tbVorname.setVisible(true);
//					tbGroesse.setVisible(false);;
//					tbArbeitsfeld.setVisible(false);
//					tbBeruf.setVisible(true);
//					tbGeschform.setVisible(false);
//					tbGeschfeld.setVisible(false);
//				    
//					break;
//				case "Team":
//					tbVorname.setVisible(false);
//					tbGroesse.setVisible(true);
//					tbBeruf.setVisible(false);
//					tbArbeitsfeld.setVisible(true);
//					
//					tbGeschform.setVisible(false);
//					tbGeschfeld.setVisible(false);
//				    tbKenntnis.getElement().setPropertyString("placeholder", "Spezifikation");
//					break;
//				case "Unternehmen":
//					tbVorname.setVisible(false);
//					tbGroesse.setVisible(false);;
//					tbArbeitsfeld.setVisible(false);
//					tbBeruf.setVisible(false);
//					tbGeschform.setVisible(true);
//					tbGeschfeld.setVisible(true);
//				    tbKenntnis.getElement().setPropertyString("placeholder", "Spezialisierung");
//					break;
//				default:
//					break;
//				}
			}
		});
		
		
		btSpeichern.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Organisationseinheit o = new Organisationseinheit();
				Partnerprofil p = new Partnerprofil();
				o.setId(2);
				o.setName(tbName.getText());
//				p.setId(id);
				o.setPartnerprofil(p);
				
				projektService.readByIdOrg(o, new AsyncCallback<Organisationseinheit>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Organisationseinheit result) {
						// TODO Auto-generated method stub
						
					}
				});
				
				projektService.updateOrg(o, new AsyncCallback<Organisationseinheit>() {
					
					@Override
					public void onSuccess(Organisationseinheit result) {
						// TODO Auto-generated method stub
						Window.alert("Daten wurden geändert");
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Fehler " + caught.getMessage());
					}
				});
			}
		});
		vpUnten.add(btAdd);
		vpUnten.add(btSpeichern);

		this.add(vpKopf);
		vpKopf.add(lbKenntnisse);
		vpKopf.add(kBereich);
		vpKopf.add(vpUnten);
	}

}
