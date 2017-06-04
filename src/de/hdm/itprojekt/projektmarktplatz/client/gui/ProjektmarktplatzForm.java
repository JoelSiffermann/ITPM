package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellList;
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

public class ProjektmarktplatzForm extends HorizontalPanel{

	
	public ProjektmarktplatzForm () {
		// aus DB
		final List<String> PROJ = Arrays.asList("Projektmarktplatz 1", "Projektmarktplatz 2", "Projektmarktplatz 3", "Projektmarktplatz 4");
		final VerticalPanel form = new VerticalPanel();
		final VerticalPanel auss = new VerticalPanel();
		final Label title = new Label("Title");
		final Label id = new Label ();
		final TextArea taInhalt = new TextArea();
		final TextBox projektName = new TextBox();
		final ListBox projektListe = new ListBox();
		final Grid grid = new Grid(7, 2);
		
		DatePicker startPicker = new DatePicker();
		DatePicker endPicker = new DatePicker();
		
		Button pmVerwalten = new Button("Projektmarktplatz verwalten");
		Button projSave = new Button("Projekt Speichern");
		Button projDel = new Button("Projekt entfernen");
		Button projAdd = new Button("Projekt anlegen");
		Button ausschreibungAdd = new Button("Ausschreibung anlegen");
		Button ausschreibungShow= new Button("Ausschreibung anzeigen");
		
		Label lName = new Label("Projektname: ");
		Label lStart = new Label("Start: ");
		Label lEnde = new Label("Ende: ");
		Label lInhalt = new Label("Inhalt: ");
		
		// Create a cell to render each value.
		TextCell textCell = new TextCell();
		
		// Create a CellList that uses the cell.
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		projAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub				
				
				if(projektName.isVisible()){
					projektName.setVisible(false);
					projektListe.setVisible(true);
					grid.setWidget(0, 1, projektListe); 
				}
				else if (!projektName.isVisible()){
					projektName.setVisible(true);
					projektListe.setVisible(false);
					grid.setWidget(0, 1, projektName); 
				}
			}
		});
		
		// Add a selection model to handle user selection.
		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				String selected = selectionModel.getSelectedObject();
				

					if (selected != null) {
//						Window.alert("You selected: " + selected);
						title.setText(selected.toString()); 
					}

			}
		});
		
		// Set the value in the text box when the user selects a date
	    startPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
	      public void onValueChange(ValueChangeEvent<Date> event) {
	        Date date = event.getValue();
	        String dateString = DateTimeFormat.getMediumDateFormat().format(date);
//	        Window.alert("You selected " +dateString);
	      }
	    });

	    // Set the default value
	    startPicker.setValue(new Date(), true);
	    
	    
		// Set the value in the text box when the user selects a date
	    endPicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
	      public void onValueChange(ValueChangeEvent<Date> event) {
	        Date date = event.getValue();
	        String dateString = DateTimeFormat.getMediumDateFormat().format(date);
//	        Window.alert("You selected " +dateString);
	      }
	    });
	    
	    ausschreibungAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				AusschreibungPanel ap = new AusschreibungPanel();
				auss.clear();
				auss.add(ap); 
				
			}
		});

	    // Set the default value
	    endPicker.setValue(new Date(), true);

		// Set the total row count. This isn't strictly necessary, but it
		// affects
		// paging calculations, so its good habit to keep the row count up to
		// date.
		cellList.setRowCount(PROJ.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, PROJ);
		
		
//		*************************** Form für Verwaltung Projekte *****************************************************************************
		
		projektName.setVisible(false);
		projektListe.setVisible(true);
		
		grid.setWidget(0, 0, lName);
		grid.setWidget(0, 1, projektListe); 
//		grid.setWidget(0, 1, projektName); 
		grid.setWidget(1, 0, lStart);
		grid.setWidget(1, 1, startPicker);
		grid.setWidget(2, 0, lEnde);
		grid.setWidget(2, 1, endPicker);
		grid.setWidget(3, 0, lInhalt);
		grid.setWidget(3, 1, taInhalt);
		
		grid.setWidget(4, 0, pmVerwalten);
		grid.setWidget(4, 1, projSave);
		grid.setWidget(5, 0, projDel);
		grid.setWidget(5, 1, projAdd);
		grid.setWidget(6, 0, ausschreibungAdd);
		grid.setWidget(6, 1, ausschreibungShow);

		form.add(title); 
//		form.add(projektListe);
//		form.add(projektName);
//		form.add(startPicker);
//		form.add(endPicker); 
//		form.add(taInhalt); 
		form.add(grid);

		
		this.add(cellList);
		this.add(form);
		this.add(auss); 
		
	}
}
