package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class ProjektCell extends AbstractCell<Projekt> {
	@Override
	public void render(Context context,
			Projekt value, SafeHtmlBuilder sb) {
		if (value == null) {
			return;
		}
		sb.appendHtmlConstant("<div>");
	    sb.appendEscaped(value.getName());
	    sb.appendHtmlConstant("</div>");
	}
}
