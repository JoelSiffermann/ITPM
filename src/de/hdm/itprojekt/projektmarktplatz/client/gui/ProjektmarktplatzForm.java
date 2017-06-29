package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class ProjektmarktplatzForm extends HorizontalPanel {

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public ProjektmarktplatzForm(final ArrayList<Projektmarktplatz> result) {

		final List<String> PROJEKTMARKTPLATZ = Arrays.asList("Projektmarktplatz 1", "Projektmarktplatz 2",
				"Projektmarktplatz 3", "Projektmarktplatz 4");
		final VerticalPanel vpProjektmarktplatz = new VerticalPanel();
		final Label lblProjektmarktplatz = new Label("Projektmarktplatz:");
		final Button btMeineProjekte = new Button("Meine Projekte");
		final Button btAlleProjekte = new Button("Alle Projekte");
		final Button btProjektmarktplatzAnlegen = new Button("Projektmarktplatz anlegen");
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

				if (selected != null) {
					// Window.alert("You selected: " + selected);
					lblProjektmarktplatz.setText(selected.toString());

				}

			}
		});

		cellList.setRowCount(PROJEKTMARKTPLATZ.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, PROJEKTMARKTPLATZ);

		btMeineProjekte.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

//				ProjektForm pfMeineProjekte = new ProjektForm();
//				vpProjektmarktplatz.clear();
//				vpProjektmarktplatz.add(pfMeineProjekte.getMeineProjekte(result));

			}
		});

		btAlleProjekte.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				projektService.readAllProjektmarktplatz(new AsyncCallback<ArrayList<Projektmarktplatz>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<Projektmarktplatz> result) {

						for (Projektmarktplatz pm : result) {
//							ProjektForm pfMeineProjekte = new ProjektForm();
//							vpProjektmarktplatz.clear();
//							vpProjektmarktplatz.add(pfMeineProjekte.getAlleProjekte(result));

						}

					}
				});

			}
		});

		btProjektmarktplatzAnlegen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		vpProjektmarktplatz.add(lblProjektmarktplatz);

		vpProjektmarktplatz.add(btMeineProjekte);
		vpProjektmarktplatz.add(btAlleProjekte);
		vpProjektmarktplatz.add(btProjektmarktplatzAnlegen);

		this.add(vpProjektmarktplatz);

	}

	protected void clear(VerticalPanel bt) {

	}

	public void addProjektPanel(Panel p) {
		this.add(p);
	}
}
