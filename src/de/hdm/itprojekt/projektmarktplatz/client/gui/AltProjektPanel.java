package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class AltProjektPanel extends VerticalPanel {

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public AltProjektPanel() {

		// muss hier dynamisch sein
		final VerticalPanel vpProjektPanel = new VerticalPanel();

		Button btMeineProjekte = new Button("Meine Projekte");
		btMeineProjekte.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Window.alert("vor clear clickhandler");
				int id = Integer.parseInt(Cookies.getCookie("userid"));
				Organisationseinheit o = new Organisationseinheit();
				o.setId(id);
				projektService.readAllProjektmarktplatzByOrg(o, new AsyncCallback<ArrayList<Projektmarktplatz>>() {

					@Override
					public void onSuccess(ArrayList<Projektmarktplatz> result) {
						// TODO Auto-generated method stub
						final DialogBox dialogBox = new DialogBox();
						dialogBox.setText("Erfolgreich gespeichert");
						Button closeButton = new Button("OK", new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								// TODO Auto-generated method stub
								dialogBox.hide();
							}
						});

						dialogBox.add(closeButton);
						dialogBox.show();
						clear(vpProjektPanel);
						// Window.alert("clickhandler");
//						ProjektForm pfMeineProjekte = new ProjektForm();
//						addProjektPanel(pfMeineProjekte);
						// Window.alert("ende clickhandler");
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						final DialogBox dialogBox = new DialogBox();
						dialogBox.setText("Fehler " + caught.getLocalizedMessage());
						Button closeButton = new Button("OK", new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								// TODO Auto-generated method stub
								dialogBox.hide();
							}
						});

						dialogBox.add(closeButton);
						dialogBox.show();
					}
				});

			}
		});

		Button btAlleProjekte = new Button("Alle Projekte");
		btAlleProjekte.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Window.alert("vor clear clickhandler");
				clear(vpProjektPanel);

				// Window.alert("clickhandler");
//				ProjektForm pfAlleProjekte = new ProjektForm();
//				addProjektPanel(pfAlleProjekte);
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
