package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Bewerbung;

public class AltBewerbungForm extends VerticalPanel {

//	private final ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
//
//	public AltBewerbungForm() {
//
//	}
//
//	public VerticalPanel getAufProjektBewerben() {
//
//		final VerticalPanel vpKopf = new VerticalPanel();
//		final ListBox lbTitel = new ListBox();
//		final VerticalPanel vpUnten = new VerticalPanel();
//		final Button btBewerbungVersenden = new Button("Bewerbung versenden");
//
//		final VerticalPanel bewerbungTextPanel = new VerticalPanel();
//		final TextArea bewerbungText = new TextArea();
//
//		projektService.readAllBewerbung(new AsyncCallback<ArrayList<Bewerbung>>() {
//
//			@Override
//			public void onSuccess(ArrayList<Bewerbung> result) {
//				// TODO Auto-generated method stub
//
//				for (Bewerbung b : result) {
//
//					lbTitel.addItem(b.getId() + "", b.getId() + "");
//
//				}
//
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		bewerbungText.setWidth("1000px");
//		bewerbungText.setHeight("300px");
//
//		bewerbungText.setText("");
//		bewerbungText.getElement().setPropertyString("placeholder", "Bewerbungstext");
//
//		bewerbungTextPanel.add(bewerbungText);
//
//		btBewerbungVersenden.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				clear(vpKopf);
//				Window.alert("Bewerbung versendet");
//
//			}
//		});
//
//		vpKopf.add(lbTitel);
//		vpUnten.add(btBewerbungVersenden);
//
//		this.add(vpKopf);
//		this.add(bewerbungTextPanel);
//		this.add(vpUnten);
//		return this;
//	}
//
//	public VerticalPanel getMeineProjekteBewerbungAnzeigen(String selectedValue) {
//
//		final VerticalPanel vpKopf = new VerticalPanel();
//		final HorizontalPanel hpUnten = new HorizontalPanel();
//		final VerticalPanel bewerbungTextPanel = new VerticalPanel();
//
//		final ListBox lbTitel = new ListBox();
//		final Button btBewertungSchreiben = new Button("Bewertung schreiben");
//		final Button btBewertungAnzeigen = new Button("Bewertung anzeigen");
//		final TextArea bewerbungText = new TextArea();
//
//		bewerbungText.setWidth("1000px");
//		bewerbungText.setHeight("300px");
//		bewerbungText.setEnabled(false);
//
//		bewerbungText.setText("");
//		bewerbungText.getElement().setPropertyString("placeholder", "Bewerbungstext");
//
//		bewerbungTextPanel.add(bewerbungText);
//
//		projektService.readAllBewerbungByAusschreibung(selectedValue, new AsyncCallback<ArrayList<Bewerbung>>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onSuccess(ArrayList<Bewerbung> result) {
//				// TODO Auto-generated method stub
//				for (Bewerbung b : result) {
//					lbTitel.addItem(b.getId() + "", b.getId() + "");
//				}
//			}
//		});
//
//		btBewertungSchreiben.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				vpKopf.clear();
//				bewerbungTextPanel.clear();
//				hpUnten.clear();
//				// Window.alert("clickhandler");
//				AltBewertungForm bewertungSchreiben = new AltBewertungForm();
//				vpKopf.add(bewertungSchreiben.getBewertungenSchreiben(lbTitel.getSelectedValue()));
//				// Window.alert("ende clickhandler");
//			}
//		});
//
//		btBewertungAnzeigen.addClickHandler(new ClickHandler() {
//
//			public void onClick(ClickEvent event) {
//				vpKopf.clear();
//				bewerbungTextPanel.clear();
//				hpUnten.clear();
//				AltBewertungForm bewertungAnzeigen = new AltBewertungForm();
//				vpKopf.add(bewertungAnzeigen.getBewertungenAnzeigen());
//
//			}
//		});
//
//		lbTitel.addChangeHandler(new ChangeHandler() {
//
//			@Override
//			public void onChange(ChangeEvent event) {
//				Bewerbung b = new Bewerbung();
//				int id = Integer.parseInt(lbTitel.getSelectedValue());
//
//				b.setId(id);
//
//				projektService.readByIdBewerbung(b, new AsyncCallback<Bewerbung>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onSuccess(Bewerbung result) {
//						// TODO Auto-generated method stub
//						bewerbungText.setText(result.getInhalt());
//					}
//				});
//			}
//		});
//
//		vpKopf.add(lbTitel);
//		hpUnten.add(btBewertungSchreiben);
//		hpUnten.add(btBewertungAnzeigen);
//
//		this.add(vpKopf);
//		this.add(bewerbungTextPanel);
//		this.add(hpUnten);
//		return this;
//	}
//
//	protected void clear(VerticalPanel vpUnten) {
//		// TODO Auto-generated method stub
//		vpUnten.clear();
//	}
//
//	public void addBewertungPanel(Panel p) {
//		this.add(p);
//	}

}
