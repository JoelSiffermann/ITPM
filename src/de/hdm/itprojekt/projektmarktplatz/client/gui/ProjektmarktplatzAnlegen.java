package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.List;

import com.gargoylesoftware.htmlunit.javascript.host.Text;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;




public class ProjektmarktplatzAnlegen extends VerticalPanel{
	
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	
	public void onLoad() {
		final HorizontalPanel hPanel = new HorizontalPanel();
		HorizontalPanel hPanel2 = new HorizontalPanel();
		VerticalPanel vPanel = new VerticalPanel();
		Label lblBez = new Label("Bezeichnung");
		final TextArea taName = new TextArea();
		Button btSpeichern = new Button("Speichern");
		Button btAbbrechen = new Button ("Abbrechen");
		
		
		btSpeichern.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btAbbrechen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hPanel.clear();
				ProjektmarktplatzAnzeigen pa = new ProjektmarktplatzAnzeigen();
				hPanel.add(pa);
			}
		});
		
		hPanel.add(vPanel);
		vPanel.add(lblBez);
		vPanel.add(taName);
		vPanel.add(hPanel2);
		hPanel2.add(btSpeichern);
		hPanel2.add(btAbbrechen);
		
		this.add(hPanel);

	
	
	}
}
