package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.thirdparty.javascript.rhino.head.ast.SwitchCase;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class MainPanel extends HorizontalPanel {

	public MainPanel() {

		// MenuBarPanel menu = new MenuBarPanel();
		//
		// final VerticalPanel vpMainPanel = new VerticalPanel();
		//
		// this.add(menu.getMenuBarPanel(vpMainPanel));
		//
		// Button pmp1 = new Button("Projektmarktplatz 1");
		//
		// pmp1.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// // Window.alert("vor clear clickhandler");
		// clear(vpMainPanel);
		// // Window.alert("clickhandler");
		// ProjektPanel pp = new ProjektPanel();
		// addProjektPanel(pp);
		// // Window.alert("ende clickhandler");
		// }
		// });
		//
		// final HorizontalPanel hpNeuerProjektmarktplatz = new
		// HorizontalPanel();
		// final TextBox tbNeuerProjektmarktplatz = new TextBox();
		//
		// tbNeuerProjektmarktplatz.getElement().setPropertyString("placeholder",
		// "Neuer Projektmarktplatz");
		//
		// Button btAddProjektmarktplatz = new Button("+");
		// btAddProjektmarktplatz.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// // TODO Auto-generated method stub
		// Button btNeuerProjektmarktplatz = new
		// Button(tbNeuerProjektmarktplatz.getText());
		// vpMainPanel.add(btNeuerProjektmarktplatz);
		// }
		// });
		//
		// hpNeuerProjektmarktplatz.add(tbNeuerProjektmarktplatz);
		// hpNeuerProjektmarktplatz.add(btAddProjektmarktplatz);
		//
		// this.add(vpMainPanel);
		// vpMainPanel.add(hpNeuerProjektmarktplatz);
		// vpMainPanel.add(pmp1);

		VerticalPanel navi = new VerticalPanel();
		final VerticalPanel info = new VerticalPanel();

		final List<String> NAVI = Arrays.asList("Profil", "Projektmarktplatz", "Report", "Logout");
		// Create a cell to render each value.
		TextCell textCell = new TextCell();
		
		// Create a CellList that uses the cell.
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Add a selection model to handle user selection.
		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				String selected = selectionModel.getSelectedObject();
				
				switch (selected) {
				case "Profil":
					ProfilForm profilBearbeitenForm = new ProfilForm();
					info.clear();
					info.add(profilBearbeitenForm);
					break;

				case "Projektmarktplatz":
//					if (selected != null) {
//						Window.alert("You selected: " + selected);
//					}
					
					ProjektmarktplatzForm pmForm = new ProjektmarktplatzForm();
					info.clear();
					info.add(pmForm); 
					break;

				case "Report":

					break;

				case "Logout":

					break;

				default:
					break;
				}

				

			}
		});

		// Set the total row count. This isn't strictly necessary, but it
		// affects
		// paging calculations, so its good habit to keep the row count up to
		// date.
		cellList.setRowCount(NAVI.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, NAVI);

		navi.add(cellList);
		this.add(navi);
		this.add(info);

	}

	public void clear(Panel p) {
		// Window.alert("clickhandler clear");
		p.clear();
	}

	public void addProjektPanel(Panel p) {
		this.add(p);
	}

}
