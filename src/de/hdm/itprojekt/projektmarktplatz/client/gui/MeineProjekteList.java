package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class MeineProjekteList extends HorizontalPanel{

	ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	HorizontalPanel hpList = new HorizontalPanel();
	HorizontalPanel hpInfo = new HorizontalPanel();
	Projekt selectedProjekt = null;
	
	public void onLoad() {
		super.onLoad();
		String[] liste = {};
		List<String> MEINEPROJEKTE = Arrays.asList(liste);
//		TextCell textCell = new TextCell();
		ClickableTextCell  textCell = new ClickableTextCell();
		CellList<String> cellList = new CellList<String>(textCell);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		cellList.addStyleName("scrollable");
		cellList.setPageSize(20);
		cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);
		cellList.setRowCount(MEINEPROJEKTE.size(), true);
		cellList.setRowData(0, MEINEPROJEKTE);
		//TODO: ClickHandler
		cellList.addHandler(new ListClickHandler(), DoubleClickEvent.getType());
		getData(cellList);
		hpList.add(cellList);
		this.add(hpList);
		this.add(hpInfo);
	}
	
	private class ListClickHandler implements DoubleClickHandler {

		@Override
		public void onDoubleClick(DoubleClickEvent event) {
			ProjektNeuForm pf = new ProjektNeuForm();
			hpInfo.add(pf);
			Window.alert("ok");
		}
		
	}
	
	public void getData(CellList<String> clist) {
		projektService.readAllProjekt(new MeineProjekteCallback(clist));
	}
	
	private class MeineProjekteCallback extends VerticalPanel implements AsyncCallback<ArrayList<Projekt>> {

		String[] l;
		CellList<String> clist;
		List<String> MEINEPROJEKTE;
		
		public MeineProjekteCallback(CellList clist) {
			this.clist = clist;
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<Projekt> result) {
			// TODO Auto-generated method stub
//			Window.alert("klappt");
			this.l = new String[result.size()];
			int i = 0;
			for(Projekt p : result) {
				l[i] = p.getName();
				i++;
			}
			MEINEPROJEKTE = Arrays.asList(l);
			clist.setRowData(0, MEINEPROJEKTE);
		}
		
	}
}
