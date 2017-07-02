package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class AltBeteiligungMeineProjekte extends VerticalPanel {
	
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	
	final VerticalPanel vpBeteiligung = new VerticalPanel();
	
}

//	public BeteiligungMeineProjekte() {
//		
//	final VerticalPanel vpBeteiligung2 = new VerticalPanel();
//	final TextCell textCell = new TextCell();
//
//	final List<String> BETEILIGUNGMEINEPROJEKTE = Arrays.asList("Projekt 1", "Projekt 3", "Projekt 4");
//
//	// Create a CellList that uses the cell.
//			CellList<String> clMeineProjekte = new CellList<String>(textCell);
//			clMeineProjekte.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
//
//			// Add a selection model to handle user selection.
//			final SingleSelectionModel<String> selectionModelMeineProjekte = new SingleSelectionModel<String>();
//			clMeineProjekte.setSelectionModel(selectionModelMeineProjekte);
//			selectionModelMeineProjekte.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//				public void onSelectionChange(SelectionChangeEvent event) {
//					String selected = selectionModelMeineProjekte.getSelectedObject();
//
//					switch (selected) {
//					case "Projekt 1":
//						ProjektForm pmForm1 = new ProjektForm();
//						vpBeteiligung.clear();
//						vpBeteiligung2.clear();
//
//						vpBeteiligung.add(pmForm1.BeteiligungAnMeineProjekte());
//						break;
//
//					default:
//						break;
//					}
//
//				}
//			});
//	}

