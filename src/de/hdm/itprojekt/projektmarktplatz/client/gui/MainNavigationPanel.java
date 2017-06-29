package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainNavigationPanel extends VerticalPanel{
	HorizontalPanel nav = new HorizontalPanel();
	HorizontalPanel info = new HorizontalPanel();

	public void onLoad() {
		super.onLoad();
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
		Button btMeineProjekte = new Button("Meine Projekte");
		Button btAndereProjekte = new Button("Andere Projekte");
		btMeineProjekte.addClickHandler(new MeineProjekteClickHandler());
		projektstack.add(btMeineProjekte);
		projektstack.add(btAndereProjekte);
		return projektstack;
	}
	
	private class MeineProjekteClickHandler implements ClickHandler {
	@Override
	public void onClick(ClickEvent event) {
		MeineProjekteList mpl = new MeineProjekteList();
		info.clear();
		info.add(mpl);
	}
	}
}
