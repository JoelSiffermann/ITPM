package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjektPanel extends VerticalPanel {

	public ProjektPanel() {

		// muss hier dynamisch sein
		final VerticalPanel vp = new VerticalPanel();

		Button btP1 = new Button("Projekt 1");
		btP1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Window.alert("vor clear clickhandler");
				clear(vp);

				// Window.alert("clickhandler");
				AusschreibungPanel ap = new AusschreibungPanel();
				addAusschreibungPanel(ap);
				// Window.alert("ende clickhandler");
			}
		});
		vp.add(btP1);

		Button btP2 = new Button("Projekt 2");
		vp.add(btP2);

		this.add(vp);

	}

	public void clear(Panel p) {
		// Window.alert("clickhandler clear");
		p.clear();
	}

	public void addAusschreibungPanel(Panel p) {
		this.add(p);
	}

}
