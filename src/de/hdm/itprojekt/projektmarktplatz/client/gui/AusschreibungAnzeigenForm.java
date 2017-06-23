package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;

public class AusschreibungAnzeigenForm extends HorizontalPanel {

	/*
	 * Neues Design
	 */
	
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);

	public void onLoad() {
		final List<String> BETEILIGUNGPERSONEN = Arrays.asList("Projekt 1", "Projekt 2", "Projekt 3", "Projekt 4");
		final VerticalPanel vpAusschreibungAnzeigenform1 = new VerticalPanel();
		final VerticalPanel vpAusschreibungAnzeigenform2 = new VerticalPanel();
		final HorizontalPanel hpAusschreibungAnzeigenForm = new HorizontalPanel();

		final TextBox tbAusschreibung = new TextBox();
		final TextBox tbPartnerProfilBeschreibung = new TextBox();
		final TextBox tbPartnerProfilWert = new TextBox();
		final TextBox tbFrist = new TextBox();
		final TextArea taAusschreibungInhalt = new TextArea();
		final Label lblAusschreibungName = new Label("Ausschreibungbezeichnung:");
		final Label lblAusschreibungInhalt = new Label("Ausschreibungsbeschreibung:");
		final Label lblFrist = new Label("Frist:");
		final Label lblGesucht = new Label("Gesucht:");
		final Label lblPartnerProfilBeschreibung = new Label("Beschreibung:");
		final Label lblPartnerProfilWert = new Label("Wert:");

		final Button btAusschreibungBearbeiten = new Button("Ausschreibung bearbeiten");
		final Button btAusschreibungEntfernen = new Button("Ausschreibung entfernen");

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

				if (selected != null) {
					// Window.alert("You selected: " + selected);
					lblAusschreibungName.setText(selected.toString());
				}

			}
		});

		cellList.addStyleName("scrollable");
		cellList.setPageSize(30);
	    cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
	    cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		cellList.setRowCount(BETEILIGUNGPERSONEN.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, BETEILIGUNGPERSONEN);

		vpAusschreibungAnzeigenform1.add(lblAusschreibungName);
		vpAusschreibungAnzeigenform1.add(tbAusschreibung);
		vpAusschreibungAnzeigenform1.add(lblAusschreibungInhalt);
		vpAusschreibungAnzeigenform1.add(taAusschreibungInhalt);
		vpAusschreibungAnzeigenform1.add(lblFrist);
		vpAusschreibungAnzeigenform1.add(tbFrist);
		vpAusschreibungAnzeigenform1.add(lblGesucht);
		vpAusschreibungAnzeigenform1.add(lblPartnerProfilBeschreibung);
		vpAusschreibungAnzeigenform1.add(lblPartnerProfilWert);

		vpAusschreibungAnzeigenform2.add(btAusschreibungBearbeiten);
		vpAusschreibungAnzeigenform2.add(btAusschreibungEntfernen);

		hpAusschreibungAnzeigenForm.add(vpAusschreibungAnzeigenform1);
		hpAusschreibungAnzeigenForm.add(vpAusschreibungAnzeigenform2);

		this.add(cellList);
		this.add(hpAusschreibungAnzeigenForm);

	}

}
