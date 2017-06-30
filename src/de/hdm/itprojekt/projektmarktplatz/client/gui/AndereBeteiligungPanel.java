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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class AndereBeteiligungPanel extends HorizontalPanel {
	
	/*
	 * Neues Design
	 */

	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	
//	final List<String> PROJEKTE = Arrays.asList("Projekt 1", "Projekt 2", "Projekt 3", "Projekt 4");
	VerticalPanel vpAndereProjekteForm1 = new VerticalPanel();
	VerticalPanel vpAndereProjekteForm2 = new VerticalPanel();
	HorizontalPanel hpAndereProjekteForm = new HorizontalPanel();

	ListBox lbBeteiligung = new ListBox();
	TextBox tbBeruf = new TextBox();
	TextBox tbName = new TextBox();
	TextBox tbUmfang = new TextBox();
	TextBox tbErfahrung = new TextBox();

	DatePicker startPicker = new DatePicker();
	DatePicker endPicker = new DatePicker();
	
	Label lblName = new Label("Name:");
	Label lblStart = new Label("Start:");
	Label lblEnde = new Label("Ende:");
	Label lblBeruf = new Label("Beruf:");
	Label lblUmfang = new Label("Umfang:");
	Label lblJahre = new Label("Jahre");
	Label lblTage = new Label("Tage");
	Label lblErfahrung = new Label("Erfahrung:");

	Button btBewertungAnzeigen = new Button("Bewertung anzeigen");
	Button btBeteiligungBeenden = new Button("Beteiligung beenden");
	
	Grid gridErfahrung = new Grid(1, 2);
	Grid gridUmfang = new Grid(1, 2);
	TextCell textCell = new TextCell();

	Projekt projekt = new Projekt();
	
	public AndereBeteiligungPanel (Projekt p) {
		this.projekt = p;
	}
	
	public void onLoad() {
				
		super.onLoad();
		if(this.projekt!=null){
			lblName.setText(projekt.getName());
		}
		lbBeteiligung.addItem("Beteiligung 1");
		lbBeteiligung.addItem("Beteiligung 2");

//		// Create a CellList that uses the cell.
//		CellList<String> cellList = new CellList<String>(textCell);
//		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
//
//		// Add a selection model to handle user selection.
//		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
//		cellList.setSelectionModel(selectionModel);
//		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//			public void onSelectionChange(SelectionChangeEvent event) {
//				String selected = selectionModel.getSelectedObject();
//
//				if (selected != null) {
//					// Window.alert("You selected: " + selected);
//					//TODO listbox funktioniert nicht
////					lbBeteiligung.getText(selected.toString());
//				}
//
//			}
//		});
//
//		cellList.addStyleName("scrollable");
//		cellList.setPageSize(30);
//	    cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
//	    cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);
//
//		cellList.setRowCount(PROJEKTE.size(), true);
//
//		// Push the data into the widget.
//		cellList.setRowData(0, PROJEKTE);
		
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
				
		btBewertungAnzeigen.addClickHandler(new ClickHandler() {
			
			BewertungAnzeigen bewertungAnzeigen = new BewertungAnzeigen();
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hpAndereProjekteForm.clear();
				hpAndereProjekteForm.add(btBewertungAnzeigen);
			}
			
		});
		
		endPicker.setValue(new Date(), true);
		
		gridErfahrung.setWidget(0, 0, tbErfahrung);
		gridErfahrung.setWidget(0, 1, lblJahre);

		gridUmfang.setWidget(0, 0, tbUmfang);
		gridUmfang.setWidget(0, 1, lblTage);


		vpAndereProjekteForm1.add(lbBeteiligung);
		vpAndereProjekteForm1.add(lblName);
		vpAndereProjekteForm1.add(tbName);
		vpAndereProjekteForm1.add(lblBeruf);
		vpAndereProjekteForm1.add(tbBeruf);
		vpAndereProjekteForm1.add(lblErfahrung);
		vpAndereProjekteForm1.add(gridErfahrung);
		vpAndereProjekteForm1.add(lblStart);
		vpAndereProjekteForm1.add(startPicker);
		vpAndereProjekteForm1.add(lblEnde);
		vpAndereProjekteForm1.add(endPicker);
		vpAndereProjekteForm1.add(lblUmfang);
		vpAndereProjekteForm1.add(gridUmfang);

		vpAndereProjekteForm2.add(btBewertungAnzeigen);
		vpAndereProjekteForm2.add(btBeteiligungBeenden);

		this.clear();
//		this.add(cellList);
		this.add(vpAndereProjekteForm1);
		this.add(vpAndereProjekteForm2);
	}

}
