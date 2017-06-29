package de.hdm.itprojekt.projektmarktplatz.client.gui;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdmin;
import de.hdm.itprojekt.projektmarktplatz.shared.ProjektmarktplatzAdminAsync;
import de.hdm.itprojekt.projektmarktplatz.shared.bo.Projekt;

public class MeineProjekteListTest implements TreeViewModel{

	private ProjektForm projektForm;
	
	private Projekt selectedProjekt;
	
	ProjektmarktplatzAdminAsync projektService = GWT.create(ProjektmarktplatzAdmin.class);
	private ListDataProvider<Projekt> projektDataProvider = null;
	
	private class ProjektKeyProvider implements ProvidesKey<Projekt> {
		@Override
		public Integer getKey(Projekt p) {
			if (p == null) {
				return null;
			}
			return new Integer(p.getId());
		}
	};
	
	private ProjektKeyProvider projektKeyProvider = null;
	private SingleSelectionModel<Projekt> selectionModel = null;
	
	private class SelectionChangeEventHandler implements SelectionChangeEvent.Handler {
		@Override
		public void onSelectionChange(SelectionChangeEvent event) {
			Projekt selection = selectionModel.getSelectedObject();
			setSelectedProjekt((Projekt) selection);
		}
	}
	
	public MeineProjekteListTest(){
		projektKeyProvider = new ProjektKeyProvider();
		selectionModel = new SingleSelectionModel<Projekt>(projektKeyProvider);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEventHandler());
	}
	
	Projekt getSelectedProjekt(){
		return selectedProjekt;
	}
	
	void setSelectedProjekt(Projekt p){
		selectedProjekt = p;
//		projektForm.setSelected(p);
	}
	
	void addProjekt(Projekt p){
		projektDataProvider.getList().add(p);
		selectionModel.setSelected(p, true);
	}
	
	void updateProjekt(Projekt p){
		List<Projekt> projektList = projektDataProvider.getList();
		int i = 0;
		for (Projekt p1 : projektList) {
			if(p1.getId() == p.getId()) {
				projektList.set(i, p);
				break;
			} else {
				i++;
			}
		}
		projektDataProvider.refresh();
	}
	
	void removeProjekt(Projekt p) {
		projektDataProvider.getList().remove(p);
	}
	
	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

}
