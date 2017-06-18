package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Organisationseinheit;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class MainPanel extends HorizontalPanel {

	public MainPanel() {

		final VerticalPanel navi = new VerticalPanel();
		final VerticalPanel info = new VerticalPanel();
		final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
		final List<String> NAVI = Arrays.asList("Profil", "Projektmarktplatz", "Beteiligung", "Report", "Logout");
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
					// if (selected != null) {
					// Window.alert("You selected: " + selected);
					// }
					int id = Integer.parseInt(Cookies.getCookie("userid"));
					Organisationseinheit o = new Organisationseinheit();
					o.setId(id);
					projektService.readAllProjektmarktplatzByOrg(o, new AsyncCallback<ArrayList<Projektmarktplatz>>() {
						
						@Override
						public void onSuccess(ArrayList<Projektmarktplatz> result) {
							// TODO Auto-generated method stub
							ProjektmarktplatzForm pmForm = new ProjektmarktplatzForm(result);
							info.clear();
							info.add(pmForm);
						}
						
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}
					});
					
					break;

				case "Beteiligung":

					BeteiligungPanel beteiligung = new BeteiligungPanel();
					info.clear();
					info.add(beteiligung);
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
