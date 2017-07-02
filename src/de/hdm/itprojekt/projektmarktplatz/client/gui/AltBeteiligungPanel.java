package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.logging.client.DefaultLevel.Info;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class AltBeteiligungPanel extends HorizontalPanel {

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	
	public AltBeteiligungPanel() {

		final VerticalPanel vpBeteiligung = new VerticalPanel();
		final VerticalPanel vpBeteiligung2 = new VerticalPanel();
	
		final TextCell textCell = new TextCell();

		final List<String> BETEILIGUNGPROJEKTE = Arrays.asList("Beteiligungen an anderen Projekten", "Beteiligungen an meinen Projekten");
		CellList<String> clBeteiligungProjekte = new CellList<String>(textCell);
		clBeteiligungProjekte.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		final SingleSelectionModel<String> selectionModelBeteiligungProjekte = new SingleSelectionModel<String>();
		clBeteiligungProjekte.setSelectionModel(selectionModelBeteiligungProjekte);
		selectionModelBeteiligungProjekte.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				String selected = selectionModelBeteiligungProjekte.getSelectedObject();
				
				switch (selected) {
				case "Beteiligungen an anderen Projekten":
//					BeteiligungAndereProjekte beteiligungAndereProjekte = new BeteiligungAndereProjekte();
					vpBeteiligung.clear();
//					vpBeteiligung.add(beteiligungAndereProjekte);
					break;
					
				case "Beteiligung an meinen Projekten":
//					BeteiligungMeineProjekte beteiligungMeineProjekte = new BeteiligungMeineProjekte();
					vpBeteiligung.clear();
//					vpBeteiligung.add(beteiligungMeineProjekte);
					break;
					
				default:
					break;
					
				}
			}
		});
		
		clBeteiligungProjekte.setRowCount(BETEILIGUNGPROJEKTE.size(), true);
		
		clBeteiligungProjekte.setRowData(0, BETEILIGUNGPROJEKTE);
		
		vpBeteiligung2.add(clBeteiligungProjekte);
		this.add(vpBeteiligung2);
		this.add(vpBeteiligung);
		
	}

}
				
//
//		// Create a CellList that uses the cell.
//		
//		
//
//		// Add a selection model to handle user selection.

//
//				switch (selected) {
//				case "Projekt 1":
//					ProjektForm pmForm1 = new ProjektForm();
//					vpBeteiligung.clear();
//					vpBeteiligung2.clear();
//
//					vpBeteiligung2.add(pmForm1.BeteiligungAnAndereProjekte());
//					break;
//
//				default:
//					break;
//				}
//
//			}
//		});
//
//		BeteiligungMeineProjekte bmp = new BeteiligungMeineProjekte();
//		
//		clAlleProjekte.setRowCount(BETEILIGUNGANDEREPROJEKTE.size(), true);
////
////		bmp.setRowData(0, bmp);
////		clAlleProjekte.setRowData(0, BETEILIGUNGANDEREPROJEKTE);
//
//		vpBeteiligung.add(lbBeteiligungMeineProjekte);
////		vpBeteiligung.add(bmp);
//		vpBeteiligung.add(bmp);
//
//		vpBeteiligung2.add(lbBeteiligungAndereProjekte);
//		vpBeteiligung2.add(clAlleProjekte);
//		this.add(vpBeteiligung);
//		this.add(vpBeteiligung2);
//
//	}
//
//	protected void clear(VerticalPanel vpUnten) {
//		// TODO Auto-generated method stub
//		vpUnten.clear();

