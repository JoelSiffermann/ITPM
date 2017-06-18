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
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Person;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projektmarktplatz;

public class ProjektForm extends HorizontalPanel {
	
	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);


	public HorizontalPanel BeteiligungAnMeineProjekte() {

		final List<String> BETEILIGUNGPERSONEN = Arrays.asList("Person 1", "Person 2",
				"Person 3", "Person 4");
		final VerticalPanel vpProjektform = new VerticalPanel();
		final Label lblPerson = new Label();
		final TextArea taInhalt = new TextArea();
		final TextBox tbProjektName = new TextBox();
		final ListBox lbProjektListe = new ListBox();
		final Grid gridProjektForm = new Grid(7, 2);
		final Label lblProjektmarktplatz = new Label("Projektmarktplatz: ");

		final TextBox tbProjektmarktplatz = new TextBox();

		final DatePicker startPicker = new DatePicker();
		final DatePicker endPicker = new DatePicker();

		final Button btBeteiligungEntfernen = new Button("Beteiligung entfernen");
		final Label lblName = new Label("Projektname: ");
		final Label lblStart = new Label("Start: ");
		final Label lblEnde = new Label("Ende: ");
		final Label lblInhalt = new Label("Inhalt: ");

		// Create a cell to render each value.
		TextCell textCell = new TextCell();

		// Create a CellList that uses the cell.
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);


		taInhalt.setWidth("1000px");
		taInhalt.setHeight("300px");
		taInhalt.setEnabled(false);
		
		btBeteiligungEntfernen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (tbProjektName.isVisible()) {
					tbProjektName.setVisible(false);
					lbProjektListe.setVisible(true);
					gridProjektForm.setWidget(0, 1, lbProjektListe);
				} else if (!tbProjektName.isVisible()) {
					tbProjektName.setVisible(true);
					lbProjektListe.setVisible(false);
					gridProjektForm.setWidget(0, 1, tbProjektName);
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
					// Window.alert("You selected: " + selected);
					lblPerson.setText(selected.toString());
				}

			}
		});

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

		endPicker.setValue(new Date(), true);

		cellList.setRowCount(BETEILIGUNGPERSONEN.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, BETEILIGUNGPERSONEN);

		tbProjektName.setVisible(false);
		lbProjektListe.setVisible(true);

		gridProjektForm.setWidget(0, 0, lblProjektmarktplatz);
		gridProjektForm.setWidget(0, 1, tbProjektmarktplatz);
		gridProjektForm.setWidget(1, 0, lblName);
		gridProjektForm.setWidget(1, 1, lbProjektListe);
		// grid.setWidget(0, 1, projektName);
		gridProjektForm.setWidget(2, 0, lblStart);
		gridProjektForm.setWidget(2, 1, startPicker);
		gridProjektForm.setWidget(3, 0, lblEnde);
		gridProjektForm.setWidget(3, 1, endPicker);
		gridProjektForm.setWidget(4, 0, lblInhalt);
		gridProjektForm.setWidget(4, 1, taInhalt);

		gridProjektForm.setWidget(5, 0, btBeteiligungEntfernen);

		vpProjektform.add(lblPerson);
		vpProjektform.add(gridProjektForm);

		this.add(cellList);
		this.add(vpProjektform);
		return this;

	}
	
	public HorizontalPanel BeteiligungAnAndereProjekte() {

		final List<String> BETEILIGUNGPROJEKTE = Arrays.asList("Projekt 1", "Projekt 2",
				"Projekt 3", "Projekt 4");
		final VerticalPanel vpProjektform = new VerticalPanel();
		final Label lblPerson = new Label();
		final TextArea taInhalt = new TextArea();
		final TextBox tbProjektName = new TextBox();
		final ListBox lbProjektListe = new ListBox();
		final Grid gridProjektForm = new Grid(7, 2);
		final Label lblProjektmarktplatz = new Label("Projektmarktplatz: ");

		final TextBox tbProjektmarktplatz = new TextBox();

		final DatePicker startPicker = new DatePicker();
		final DatePicker endPicker = new DatePicker();

		final Button btBeteiligungEntfernen = new Button("Beteiligung entfernen");
		final Label lblStart = new Label("Start: ");
		final Label lblEnde = new Label("Ende: ");
		final Label lblInhalt = new Label("Inhalt: ");

		// Create a cell to render each value.
		TextCell textCell = new TextCell();
		
		taInhalt.setWidth("1000px");
		taInhalt.setHeight("300px");
		taInhalt.setEnabled(false);

		// Create a CellList that uses the cell.
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		btBeteiligungEntfernen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (tbProjektName.isVisible()) {
					tbProjektName.setVisible(false);
					lbProjektListe.setVisible(true);
					gridProjektForm.setWidget(0, 1, lbProjektListe);
				} else if (!tbProjektName.isVisible()) {
					tbProjektName.setVisible(true);
					lbProjektListe.setVisible(false);
					gridProjektForm.setWidget(0, 1, tbProjektName);
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
					// Window.alert("You selected: " + selected);
					lblPerson.setText(selected.toString());
				}

			}
		});

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

		endPicker.setValue(new Date(), true);

		cellList.setRowCount(BETEILIGUNGPROJEKTE.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, BETEILIGUNGPROJEKTE);

		tbProjektName.setVisible(false);
		lbProjektListe.setVisible(true);

		gridProjektForm.setWidget(0, 0, lblProjektmarktplatz);
		gridProjektForm.setWidget(0, 1, tbProjektmarktplatz);
		gridProjektForm.setWidget(2, 0, lblStart);
		gridProjektForm.setWidget(2, 1, startPicker);
		gridProjektForm.setWidget(3, 0, lblEnde);
		gridProjektForm.setWidget(3, 1, endPicker);
		gridProjektForm.setWidget(4, 0, lblInhalt);
		gridProjektForm.setWidget(4, 1, taInhalt);

		gridProjektForm.setWidget(5, 0, btBeteiligungEntfernen);

		vpProjektform.add(lblPerson);
		vpProjektform.add(gridProjektForm);

		this.add(cellList);
		this.add(vpProjektform);
		return this;

	}

	public HorizontalPanel getMeineProjekte(final ArrayList<Projektmarktplatz> result) {

//		final List<String> PROJEKTMARKTPLATZ = Arrays.asList("Projektmarktplatz 1", "Projektmarktplatz 3",
//				"Projektmarktplatz 4");
		final List<String> meineProjekte = new ArrayList<String>();

		for(Projektmarktplatz pr : result){
			meineProjekte.add(pr.getBezeichnung());
			Cookies.setCookie(pr.getBezeichnung(), pr.getId()+""); 

		}
		
		final VerticalPanel vpProjektform = new VerticalPanel();
		final Label lblProjektmarktplatz = new Label("Projektmarktplatz:");
		final TextArea taInhalt = new TextArea();
		final TextBox tbProjektName = new TextBox();
		final ListBox lbProjektListe = new ListBox();
		final Grid gridProjektForm = new Grid(7, 2);
		final DatePicker startPicker = new DatePicker();
		final DatePicker endPicker = new DatePicker();

		final Button btProjektSpeichern = new Button("Projekt speichern");
		final Button btProjektEntfernen = new Button("Projekt entfernen");
		final Button btProjektAnlegen = new Button("Projekt anlegen");
		final Button btAusschreibungAnlegen = new Button("Ausschreibung anlegen");
		final Button btAusschreibungAnzeigen = new Button("Ausschreibung anzeigen");

		final Label lblName = new Label("Projektname: ");
		final Label lblStart = new Label("Start: ");
		final Label lblEnde = new Label("Ende: ");
		final Label lblInhalt = new Label("Inhalt: ");

		// Create a cell to render each value.
		TextCell textCell = new TextCell();

		taInhalt.setWidth("1000px");
		taInhalt.setHeight("300px");

		// add text to text area
		taInhalt.setText("");
		taInhalt.getElement().setPropertyString("placeholder", "Projektbeschreibung");

		// Create a CellList that uses the cell.
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		btProjektAnlegen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				
				Projekt projekt = new Projekt();
				projekt.setName(tbProjektName.getText());
				projekt.setStart(startPicker.getFirstDate());
				projekt.setEnde(endPicker.getLastDate());
				projekt.setInhalt(taInhalt.getText());
				
				if (tbProjektName.isVisible()) {
					tbProjektName.setVisible(false);
					lbProjektListe.setVisible(true);
					gridProjektForm.setWidget(0, 1, lbProjektListe);
				} else if (!tbProjektName.isVisible()) {
					tbProjektName.setVisible(true);
					lbProjektListe.setVisible(false);
					gridProjektForm.setWidget(0, 1, tbProjektName);
				}
				
				if (!projekt.equals(null)) {

					projektService.insertProjekt(projekt, new AsyncCallback<Projekt>() {

						@Override
						public void onFailure(Throwable caught) {
							
							final DialogBox dialogBox = new DialogBox();
							dialogBox.setText("Speichern hat nicht geklappt " + caught.getLocalizedMessage());
							Button closeButton = new Button("OK", new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {
									
									dialogBox.hide();
								}
							});

							dialogBox.add(closeButton);
							dialogBox.show();
						}

						@Override
						public void onSuccess(Projekt result) {
							
							final DialogBox dialogBox = new DialogBox();
							dialogBox.setText("Erfolgreich gespeichert");
							Button closeButton = new Button("OK", new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {
								
									dialogBox.hide();
								}
							});

							dialogBox.add(closeButton);
							dialogBox.show();
						}
					});
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
					// Window.alert("You selected: " + selected);
					
					lblProjektmarktplatz.setText(selected.toString());
				}

			}
		});

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

		btAusschreibungAnlegen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AusschreibungPanel ap = new AusschreibungPanel();
				vpProjektform.clear();
				vpProjektform.add(ap.getAusschreibungAnlegen());

			}
		});

		btAusschreibungAnzeigen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AusschreibungPanel ap = new AusschreibungPanel();
				vpProjektform.clear();
				vpProjektform.add(ap.getAusschreibungAnzeigen());

			}
		});

		// Set the default value
		endPicker.setValue(new Date(), true);

		// Set the total row count. This isn't strictly necessary, but it
		// affects
		// paging calculations, so its good habit to keep the row count up to
		// date.
		cellList.setRowCount(meineProjekte.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, meineProjekte);

		// *************************** Form für Verwaltung Projekte
		// *****************************************************************************

		tbProjektName.setVisible(false);
		lbProjektListe.setVisible(true);

		gridProjektForm.setWidget(0, 0, lblName);
		gridProjektForm.setWidget(0, 1, lbProjektListe);
		gridProjektForm.setWidget(1, 0, lblStart);
		gridProjektForm.setWidget(1, 1, startPicker);
		gridProjektForm.setWidget(2, 0, lblEnde);
		gridProjektForm.setWidget(2, 1, endPicker);
		gridProjektForm.setWidget(3, 0, lblInhalt);
		gridProjektForm.setWidget(3, 1, taInhalt);
		gridProjektForm.setWidget(4, 0, btProjektSpeichern);
		gridProjektForm.setWidget(4, 1, btProjektEntfernen);
		gridProjektForm.setWidget(5, 0, btProjektAnlegen);
		gridProjektForm.setWidget(6, 0, btAusschreibungAnlegen);
		gridProjektForm.setWidget(6, 1, btAusschreibungAnzeigen);

		vpProjektform.add(lblProjektmarktplatz);
		// form.add(projektListe);
		// form.add(projektName);
		// form.add(startPicker);
		// form.add(endPicker);
		// form.add(taInhalt);
		vpProjektform.add(gridProjektForm);

		this.add(cellList);
		this.add(vpProjektform);

		return this;
	}

	public HorizontalPanel getAlleProjekte(ArrayList<Projektmarktplatz> result) {

		final List<String> alleProjekte = new ArrayList<String>();
		
		for(Projektmarktplatz pr : result){
			alleProjekte.add(pr.getBezeichnung());
			Cookies.setCookie(pr.getBezeichnung(), pr.getId()+""); 

		}
		
//		final List<String> PROJEKTMARKTPLATZ = Arrays.asList("Projektmarktplatz 1", "Projektmarktplatz 2",
//				"Projektmarktplatz 3", "Projektmarktplatz 4", "PM5");

		final VerticalPanel vpProjektform = new VerticalPanel();
		final Label lblProjektmarktplatz = new Label("Projektmarktplatz:");
		final TextArea taInhalt = new TextArea();
		final TextBox tbProjektName = new TextBox();
		final ListBox lbProjektListe = new ListBox();
		final Grid gridProjektForm = new Grid(7, 2);
		DatePicker startPicker = new DatePicker();
		DatePicker endPicker = new DatePicker();

		final Button btProjektAnlegen = new Button("Projekt anlegen");
		final Button btAusschreibungAnlegen = new Button("Ausschreibung anlegen");
		final Button btAusschreibungAnzeigen = new Button("Ausschreibung anzeigen");

		final Label lblName = new Label("Projektname: ");
		final Label lblStart = new Label("Start: ");
		final Label lblEnde = new Label("Ende: ");
		final Label lblInhalt = new Label("Inhalt: ");

		// Create a cell to render each value.
		TextCell textCell = new TextCell();
		
		taInhalt.setWidth("1000px");
		taInhalt.setHeight("300px");
		taInhalt.setEnabled(false);

		// add text to text area
		taInhalt.setText("");
		taInhalt.getElement().setPropertyString("placeholder", "Projektbeschreibung");

		// Create a CellList that uses the cell.
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		btProjektAnlegen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (tbProjektName.isVisible()) {
					tbProjektName.setVisible(false);
					lbProjektListe.setVisible(true);
					gridProjektForm.setWidget(0, 1, lbProjektListe);
				} else if (!tbProjektName.isVisible()) {
					tbProjektName.setVisible(true);
					lbProjektListe.setVisible(false);
					taInhalt.setEnabled(true);

					gridProjektForm.setWidget(0, 1, tbProjektName);
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
					// Window.alert("You selected: " + selected);
					lblProjektmarktplatz.setText(selected.toString());
					//TODO Alle Projektmarktplaetze die Id rauslesen beim Selektieren
//					Cookies.getCookie(selected);
					int id = Integer.parseInt(Cookies.getCookie(selected));
					Projektmarktplatz proj = new Projektmarktplatz();
					proj.setId(id);
					proj.setBezeichnung(Cookies.getCookie(selected)); 
					lbProjektListe.clear();
					projektService.readByIdProjektProjektmarktplatz(proj, new AsyncCallback<ArrayList<Projekt>>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(ArrayList<Projekt> result) {
							// TODO Auto-generated method stub
							
							for(Projekt p : result){
								lbProjektListe.addItem(p.getName(), p.getId()+"");
							}
						}
					});
				}

			}
		});

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

		btAusschreibungAnlegen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AusschreibungPanel ap = new AusschreibungPanel();
				vpProjektform.clear();
				vpProjektform.add(ap.getAusschreibungAnlegen());

			}
		});

		btAusschreibungAnzeigen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AusschreibungPanel ap = new AusschreibungPanel();
				vpProjektform.clear();
				vpProjektform.add(ap.getAusschreibungBewerben());

			}
		});

		// Set the default value
		endPicker.setValue(new Date(), true);

		// Set the total row count. This isn't strictly necessary, but it
		// affects
		// paging calculations, so its good habit to keep the row count up to
		// date.
		cellList.setRowCount(alleProjekte.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, alleProjekte);

		// *************************** Form für Verwaltung Projekte
		// *****************************************************************************

		tbProjektName.setVisible(false);
		lbProjektListe.setVisible(true);

		gridProjektForm.setWidget(0, 0, lblName);
		gridProjektForm.setWidget(0, 1, lbProjektListe);
		gridProjektForm.setWidget(1, 0, lblStart);
		gridProjektForm.setWidget(1, 1, startPicker);
		gridProjektForm.setWidget(2, 0, lblEnde);
		gridProjektForm.setWidget(2, 1, endPicker);
		gridProjektForm.setWidget(3, 0, lblInhalt);
		gridProjektForm.setWidget(3, 1, taInhalt);
		gridProjektForm.setWidget(4, 0, btProjektAnlegen);
		gridProjektForm.setWidget(4, 1, btAusschreibungAnzeigen);

		vpProjektform.add(lblProjektmarktplatz);
		// form.add(projektListe);
		// form.add(projektName);
		// form.add(startPicker);
		// form.add(endPicker);
		// form.add(taInhalt);
		vpProjektform.add(gridProjektForm);

		this.add(cellList);
		this.add(vpProjektform);

		return this;
	}
}
