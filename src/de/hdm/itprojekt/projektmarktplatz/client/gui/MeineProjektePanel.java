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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class MeineProjektePanel extends HorizontalPanel {
	
	/*
	 * Neues Design
	 * (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onLoad()
	 */
	
//	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	
	Projekt projekt; // = new Projekt();
	
	public MeineProjektePanel(Projekt p){
		this.projekt = p;
	}
	
	VerticalPanel vpMeineProjekteForm1 = new VerticalPanel();
	VerticalPanel vpMeineProjekteForm2 = new VerticalPanel();
	HorizontalPanel hpMeineProjekteForm = new HorizontalPanel();

	TextArea taProjektBeschreibung = new TextArea();

	DatePicker startPicker = new DatePicker();
	DatePicker endPicker = new DatePicker();
		
	Label lblProjektmarktplatz = new Label("Projektmarktplatz:");
	Label lblProjektName = new Label("Projektbezeichnung");
	Label lblStart = new Label("Start:");
	Label lblEnde = new Label("Ende:");
	Label lblProjektBeschreibung = new Label("Projektbeschreibung:");

	Button btProjektBearbeiten = new Button("Projekt bearbeiten");
	Button btProjektEntfernen = new Button("Projekt entfernen");
	Button btAusschreibungAnzeigen = new Button("Ausschreibungen anzeigen");
	Button btAusschreibungErstellen = new Button("Ausschreibung erstellen");

	public void onLoad() {
		
		super.onLoad();
		if(this.projekt!=null){
			lblProjektName.setText(projekt.getName());
			taProjektBeschreibung.setText(projekt.getInhalt());
			taProjektBeschreibung.setValue(projekt.getInhalt());
		}
		
//		final List<String> PROJEKTE = Arrays.asList("Projekt 1", "Projekt 2", "Projekt 3", "Projekt 4");
		
		
		// Create a cell to render each value.
//		TextCell textCell = new TextCell();

		// Create a CellList that uses the cell.
//		CellList<String> cellList = new CellList<String>(textCell);
//		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Add a selection model to handle user selection.
//		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
//		cellList.setSelectionModel(selectionModel);
//		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//			public void onSelectionChange(SelectionChangeEvent event) {
//				String selected = selectionModel.getSelectedObject();
//
//				if (selected != null) {
//					// Window.alert("You selected: " + selected);
//					lblProjektName.setText(selected.toString());
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

		// Push the data into the widget.
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
		startPicker.setValue(projekt.getStart(), true);

		// Set the value in the text box when the user selects a date
		endPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});
		
		
		btProjektBearbeiten.addClickHandler(new ClickHandler() {

			ProjektNeuForm projektNeu = new ProjektNeuForm();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hpMeineProjekteForm.clear();
				hpMeineProjekteForm.add(projektNeu);
			}
					
		});
		
		btProjektEntfernen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.alert("Button entfernen noch herstellen");
			}
			
		});
		
		btAusschreibungAnzeigen.addClickHandler(new ClickHandler() {

			AusschreibungAnzeigenForm ausschreibungAnzeigen = new AusschreibungAnzeigenForm(null);

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hpMeineProjekteForm.clear();
				hpMeineProjekteForm.add(ausschreibungAnzeigen);
			}
			
		});
		
		btAusschreibungErstellen.addClickHandler(new ClickHandler() {
			
			AusschreibungNeuForm ausschreibungNeu = new AusschreibungNeuForm();
			@Override
			public void onClick(ClickEvent event) {
				
				hpMeineProjekteForm.clear();
				hpMeineProjekteForm.add(ausschreibungNeu);
			}
			
		});

		endPicker.setValue(projekt.getEnde(), true);

		vpMeineProjekteForm1.add(lblProjektmarktplatz);
		vpMeineProjekteForm1.add(lblProjektName);
		vpMeineProjekteForm1.add(lblStart);
		vpMeineProjekteForm1.add(startPicker);
		vpMeineProjekteForm1.add(lblEnde);
		vpMeineProjekteForm1.add(endPicker);
		vpMeineProjekteForm1.add(lblProjektBeschreibung);
		vpMeineProjekteForm1.add(taProjektBeschreibung);

		vpMeineProjekteForm2.add(btProjektBearbeiten);
		vpMeineProjekteForm2.add(btProjektEntfernen);
		vpMeineProjekteForm2.add(btAusschreibungAnzeigen);
		vpMeineProjekteForm2.add(btAusschreibungErstellen);

		hpMeineProjekteForm.add(vpMeineProjekteForm1);
		hpMeineProjekteForm.add(vpMeineProjekteForm2);

		this.clear();
//		this.add(cellList);
		this.add(hpMeineProjekteForm);
		
	}

}
