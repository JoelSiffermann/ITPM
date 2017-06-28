package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainNavigationPanel extends VerticalPanel{
	HorizontalPanel nav = new HorizontalPanel();
	HorizontalPanel info = new HorizontalPanel();

	public void onLoad() {
		super.onLoad();
	    // Create a stack panel containing three labels.
	    StackPanel panel = new StackPanel();
	    panel.add(new Label(""), "Mein Profil");
	    panel.add(projektStack(), "Projekte");
	    panel.add(new Label("Baz"), "Beteiligung");
	    panel.add(new Label(""), "Bewerbung");
	    panel.add(new Label(""), "Projektmarktplatz");
	    panel.add(new Label(""), "Report");
	    nav.add(panel);
	    RootPanel.get("nav").add(nav);
	    RootPanel.get("main").clear();
	    RootPanel.get("main").add(info);
	  }
	
	private VerticalPanel projektStack(){
		VerticalPanel projektstack = new VerticalPanel();
		Label lblMeineProjekte = new Label("Meine Projekte");
		Label lblAndereProjekte = new Label("Andere Projekte");
		lblMeineProjekte.addClickHandler(new MeineProjekteClickHandler());
		projektstack.add(lblMeineProjekte);
		projektstack.add(lblAndereProjekte);
		return projektstack;
	}
	
	private class MeineProjekteClickHandler implements ClickHandler {
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		MeineProjektePanel mp = new MeineProjektePanel();
		info.clear();
		info.add(mp);
	}
	}
}
