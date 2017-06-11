package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class BeteiligungPanel extends HorizontalPanel {

	public BeteiligungPanel() {
		
		final VerticalPanel vpBeteiligung = new VerticalPanel();
		final VerticalPanel vpBeteiligung2 = new VerticalPanel();
		final Label lbBeteiligungMeineProjekte = new Label("Beteiligungen an meinen Projekten");
		final Label lbBeteiligungAndereProjekte = new Label("Beteiligungen an anderen Projekten");
		TextCell textCell = new TextCell();
		
		final List<String> BETEILIGUNGMEINEPROJEKTE = Arrays.asList("Projekt 1", "Projekt 3", "Projekt 4");
		final List<String> BETEILIGUNGANDEREPROJEKTE = Arrays.asList("Projekt 1", "Projekt 2", "Projekt 3", "Projekt 4", "Projekt5");

		// Create a CellList that uses the cell.
		CellList<String> clMeineProjekte = new CellList<String>(textCell);
		clMeineProjekte.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Add a selection model to handle user selection.
		final SingleSelectionModel<String> selectionModelMeineProjekte = new SingleSelectionModel<String>();
		clMeineProjekte.setSelectionModel(selectionModelMeineProjekte);
		selectionModelMeineProjekte.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				String selected = selectionModelMeineProjekte.getSelectedObject();

				switch (selected) {
				case "Projekt 1":
					ProjektForm pmForm1 = new ProjektForm();
					vpBeteiligung2.clear();
					vpBeteiligung.add(pmForm1.BeteiligungAnMeineProjekte());
					break;

				case "Projekt 3":
					ProjektForm pmForm3 = new ProjektForm();
					vpBeteiligung2.clear();
					vpBeteiligung.add(pmForm3.BeteiligungAnMeineProjekte());
					break;

				default:
					break;
				}

			}
		});
		
		// Create a CellList that uses the cell.
		CellList<String> clAlleProjekte = new CellList<String>(textCell);
		clAlleProjekte.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Add a selection model to handle user selection.
		final SingleSelectionModel<String> selectionModelAlleProjekte = new SingleSelectionModel<String>();
		clAlleProjekte.setSelectionModel(selectionModelAlleProjekte);
		selectionModelAlleProjekte.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				String selected = selectionModelAlleProjekte.getSelectedObject();

				switch (selected) {
				case "Projekt 1":
					ProjektForm pmForm1 = new ProjektForm();
					vpBeteiligung.clear();
					vpBeteiligung2.add(pmForm1.BeteiligungAnAndereProjekte());
					break;

				case "Projekt 2":
					ProjektForm pmForm2 = new ProjektForm();
					vpBeteiligung.clear();
					vpBeteiligung2.add(pmForm2.BeteiligungAnAndereProjekte());
					break;
					
				case "Projekt 3":
					ProjektForm pmForm3 = new ProjektForm();
					vpBeteiligung.clear();
					vpBeteiligung2.add(pmForm3.BeteiligungAnAndereProjekte());
					break;
					
				default:
					break;
				}

			}
		});

		clMeineProjekte.setRowCount(BETEILIGUNGMEINEPROJEKTE.size(), true);
		clAlleProjekte.setRowCount(BETEILIGUNGANDEREPROJEKTE.size(), true);

		clMeineProjekte.setRowData(0, BETEILIGUNGMEINEPROJEKTE);
		clAlleProjekte.setRowData(0, BETEILIGUNGANDEREPROJEKTE);

		vpBeteiligung.add(lbBeteiligungMeineProjekte);
		vpBeteiligung.add(clMeineProjekte);
		vpBeteiligung2.add(lbBeteiligungAndereProjekte);
		vpBeteiligung2.add(clAlleProjekte);
		this.add(vpBeteiligung);
		this.add(vpBeteiligung2);

	}

}
