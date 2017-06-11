package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjektPanel extends VerticalPanel {

	public ProjektPanel() {

		// muss hier dynamisch sein
		final VerticalPanel vpProjektPanel = new VerticalPanel();

		Button btMeineProjekte = new Button("Meine Projekte");
		btMeineProjekte.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Window.alert("vor clear clickhandler");
				clear(vpProjektPanel);

				// Window.alert("clickhandler");
				ProjektForm pfMeineProjekte = new ProjektForm();
				addProjektPanel(pfMeineProjekte);
				// Window.alert("ende clickhandler");
			}
		});

		Button btAlleProjekte = new Button("Alle Projekte");
		btAlleProjekte.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Window.alert("vor clear clickhandler");
				clear(vpProjektPanel);

				// Window.alert("clickhandler");
				ProjektForm pfAlleProjekte = new ProjektForm();
				addProjektPanel(pfAlleProjekte);
				// Window.alert("ende clickhandler");
			}
		});
		
		vpProjektPanel.add(btMeineProjekte);
		vpProjektPanel.add(btAlleProjekte);

		this.add(vpProjektPanel);

	}

	public void clear(Panel p) {
		// Window.alert("clickhandler clear");
		p.clear();
	}

	public void addProjektPanel(Panel p) {
		this.add(p);
	}

}
