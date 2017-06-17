package de.hdm.itprojekt.projektmarktplatz.client.report;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class BewerbungReportNav extends HorizontalPanel{
	
	public BewerbungReportNav() {
		
		final VerticalPanel navi = new VerticalPanel();
		final VerticalPanel info = new VerticalPanel();

		final List<String> NAVI = Arrays.asList("Eigene Bewerbungen abfragen", "Bewerbungen auf Ausschreibungen abfragen");
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

				switch (selected) {
				case "Eigene Bewerbungen abfragen":
					EigBewerbungenReport ebr = new EigBewerbungenReport();
					info.clear();
					info.add(ebr);
					break;

				case "Bewerbungen auf Ausschreibungen abfragen":

					AusBewerbungenReport abr = new AusBewerbungenReport();
					info.clear();
					info.add(abr);
					break;

				default:
					break;
				}

			}
		});

		// Set the total row count. This isn't strictly necessary, but it
		// affects
		// paging calculations, so its good habit to keep the row count up to
		// date.
		cellList.setRowCount(NAVI.size(), true);

		// Push the data into the widget.
		cellList.setRowData(0, NAVI);

		navi.add(cellList);
		this.add(navi);
		this.add(info);
	}

}
