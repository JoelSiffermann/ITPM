package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainNavigationPanel extends VerticalPanel{
	

	public void onLoad() {
	    // Create a stack panel containing three labels.
	    StackPanel panel = new StackPanel();
	    panel.add(new Label("Foo"), "foo");
	    panel.add(new Label("Bar"), "bar");
	    panel.add(new Label("Baz"), "baz");

	    this.add(panel);
	  }
}
