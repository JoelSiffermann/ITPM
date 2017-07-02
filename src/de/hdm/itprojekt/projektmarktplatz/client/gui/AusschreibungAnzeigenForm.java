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

import de.hdm.itprojekt.projektmarktplatz.client.ClientSideSettings;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Ausschreibung;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class AusschreibungAnzeigenForm extends HorizontalPanel {

	/*
	 * Neues Design
	 */
	ProjektmarktplatzAdminAsync projektService = ClientSideSettings.getProjektmarktplatzVerwaltung();

	VerticalPanel vpAusschreibungAnzeigenForm1 = new VerticalPanel();
	VerticalPanel vpAusschreibungAnzeigenForm2 = new VerticalPanel();
	HorizontalPanel hpAusschreibungAnzeigenForm = new HorizontalPanel();

	TextBox tbPartnerProfilBeschreibung = new TextBox();
	TextBox tbPartnerProfilWert = new TextBox();
	DatePicker dpFrist = new DatePicker();
	TextArea taAusschreibungInhalt = new TextArea();
	Label lblAusschreibungName = new Label("Ausschreibungbezeichnung");
	Label lblAusschreibungInhalt = new Label("Ausschreibungsbeschreibung:");
	Label lblFrist = new Label("Frist:");
	Label lblGesucht = new Label("Gesucht:");
	Label lblPartnerProfilBeschreibung = new Label("Beschreibung:");
	Label lblPartnerProfilWert = new Label("Wert:");

	Button btAusschreibungBearbeiten = new Button("Ausschreibung bearbeiten");
	Button btAusschreibungEntfernen = new Button("Ausschreibung entfernen");
	TextCell textCell = new TextCell();

	Projekt projekt = new Projekt();
	
	public AusschreibungAnzeigenForm(Projekt p) {
		this.projekt = p;
	}
	public void onLoad() {
		
		super.onLoad();
		
		tbPartnerProfilWert.setEnabled(false);
		tbPartnerProfilBeschreibung.setEnabled(false);
		taAusschreibungInhalt.setEnabled(false);
		taAusschreibungInhalt.setHeight("300px");
		taAusschreibungInhalt.setWidth("300px");
		// Create a CellList that uses the cell.
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
//					lblAusschreibungName.setText(selected.toString());
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
//		cellList.setRowCount(AUSSCHREIBUNG.size(), true);
//
//		// Push the data into the widget.
//		cellList.setRowData(0, AUSSCHREIBUNG);
		
		dpFrist.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat().format(date);
				// Window.alert("You selected " +dateString);
			}
		});

		// Set the default value
		dpFrist.setValue(new Date(), true);
		
		btAusschreibungBearbeiten.addClickHandler(new ClickHandler() {
			
			AusschreibungNeuForm ausschreibungNeu = new AusschreibungNeuForm();

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hpAusschreibungAnzeigenForm.clear();
				hpAusschreibungAnzeigenForm.add(ausschreibungNeu);
			}
			
		});

		vpAusschreibungAnzeigenForm1.add(lblAusschreibungName);
		vpAusschreibungAnzeigenForm1.add(lblAusschreibungInhalt);
		vpAusschreibungAnzeigenForm1.add(taAusschreibungInhalt);
		vpAusschreibungAnzeigenForm1.add(lblFrist);
		vpAusschreibungAnzeigenForm1.add(dpFrist);
		vpAusschreibungAnzeigenForm1.add(lblGesucht);
		vpAusschreibungAnzeigenForm1.add(lblPartnerProfilBeschreibung);
		vpAusschreibungAnzeigenForm1.add(tbPartnerProfilBeschreibung);
		vpAusschreibungAnzeigenForm1.add(lblPartnerProfilWert);
		vpAusschreibungAnzeigenForm1.add(tbPartnerProfilWert);

		vpAusschreibungAnzeigenForm2.add(btAusschreibungBearbeiten);
		vpAusschreibungAnzeigenForm2.add(btAusschreibungEntfernen);

		hpAusschreibungAnzeigenForm.add(vpAusschreibungAnzeigenForm1);
		hpAusschreibungAnzeigenForm.add(vpAusschreibungAnzeigenForm2);

		this.clear();
//		this.add(cellList);
		this.add(hpAusschreibungAnzeigenForm);

	}

}
