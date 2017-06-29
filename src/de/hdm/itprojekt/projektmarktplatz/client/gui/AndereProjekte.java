package de.hdm.itprojekt.projektmarktplatz.client.gui;

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
import com.google.gwt.user.client.ui.Button;
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

public class AndereProjekte extends HorizontalPanel {

	/*
	 * Neues Design
	 */

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	
	public void onLoad() {
		
		final List<String> PROJEKTMARKTPLATZ = Arrays.asList("Projektmarktplatz 1", "Projektmarktplatz 2", "Projektmarktplatz 3", "Projektmarktplatz 4");
		final VerticalPanel vpAndereProjekteForm1 = new VerticalPanel();
		final VerticalPanel vpAndereProjekteForm2 = new VerticalPanel();
		final HorizontalPanel hpAndereProjekteForm = new HorizontalPanel();

		final ListBox lbProjekte = new ListBox();
		final ListBox lbAusschreibung = new ListBox();

		final TextBox tbProjektName = new TextBox();
		final TextArea taProjektbeschreibung = new TextArea();
		
		final DatePicker startPicker = new DatePicker();
		final DatePicker endPicker = new DatePicker();
		
		final Label lblProjektName = new Label("Projektname:");
		final Label lblStart = new Label("Start:");
		final Label lblEnde = new Label("Ende:");
		final Label lblProjektBeschreibung = new Label("Beschreibung:");

		final Button btBewerbung = new Button("Sich Bewerben");
				
		lbProjekte.addItem("Projekte 1");
		lbProjekte.addItem("Projekte 2");

		lbAusschreibung.addItem("Ausschreibung 1");
		lbAusschreibung.addItem("Ausschreibung 2");
		lbAusschreibung.addItem("Ausschreibung 3");

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
					//TODO listbox funktioniert nicht
//					lbBeteiligung.getText(selected.toString());
				}

			}
		});

		cellList.addStyleName("scrollable");
		cellList.setPageSize(30);
	    cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
	    cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		cellList.setRowCount(PROJEKTMARKTPLATZ.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, PROJEKTMARKTPLATZ);
		
		// Set the value in the text box when the user selects a date
		startPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		startPicker.setValue(new Date(), true);

		// Set the value in the text box when the user selects a date
		endPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});
				
		btBewerbung.addClickHandler(new ClickHandler() {
			
			BewerbungNeuForm bewerben = new BewerbungNeuForm();
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hpAndereProjekteForm.clear();
				hpAndereProjekteForm.add(btBewerbung);
			}
			
		});
		
		endPicker.setValue(new Date(), true);
		
		vpAndereProjekteForm1.add(lbProjekte);
		vpAndereProjekteForm1.add(lblProjektName);
		vpAndereProjekteForm1.add(tbProjektName);
		vpAndereProjekteForm1.add(lblStart);
		vpAndereProjekteForm1.add(startPicker);
		vpAndereProjekteForm1.add(lblEnde);
		vpAndereProjekteForm1.add(endPicker);
		vpAndereProjekteForm1.add(lblProjektBeschreibung);
		vpAndereProjekteForm1.add(taProjektbeschreibung);

		vpAndereProjekteForm2.add(lbAusschreibung);
		vpAndereProjekteForm2.add(btBewerbung);

		this.clear();
		this.add(cellList);
		this.add(vpAndereProjekteForm1);
		this.add(vpAndereProjekteForm2);
		
	}
	
}
