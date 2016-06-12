package edu.example.client.gui.recept.receptkomp;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.exceptions.DALException;
import edu.example.client.gui.MenuWidget;
import edu.example.client.gui.produktbatch.ProduktbatchPanel;
import edu.example.client.gui.recept.ReceptPanel;
import edu.example.client.models.ProduktbatchDTO;
import edu.example.client.models.ProduktbatchkompDTO;
import edu.example.client.models.ReceptkompDTO;
import edu.example.client.service.RPCServiceClientImpl;

public class ReceptkompPanel extends Composite 
{
	public ReceptPanel parent;
	private RPCServiceClientImpl serverComm;
	private VerticalPanel mainPanel = new VerticalPanel();
	
	private final String searchBoxDefaultText = "Soeg efter recept komponenter";
	private final TextBox searchBox = new TextBox();
	
	private final int tableColumns = 5;
	private final Grid tableList;
	private List<ReceptkompDTO> receptkompList = null;
	private List<ReceptkompDTO> dispReceptkompList = null;
	
	private int currReceptID;
		
	public ReceptkompPanel(ReceptPanel parent, RPCServiceClientImpl serverComm, int receptID) {
		this.parent = parent;
		this.serverComm = serverComm;
		this.currReceptID = receptID;
		
		mainPanel.setSize("100%", "100%");
		initWidget(mainPanel);
		tableList = new Grid(1, tableColumns);
		init();
		
//		this.serverComm.getReceptkompListByReceptID(currReceptID);
	}
	
	private void init() {
		//Top panel
		HorizontalPanel topPanel = new HorizontalPanel();
		
		HTML pageTitle = new HTML("Receptbatch komponenter");
		pageTitle.addStyleName("h1");
		
		searchBox.setText(searchBoxDefaultText);
		searchBox.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getUnicodeCharCode() == 13)
					search(searchBox.getText());
			}
		});
		searchBox.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				if(searchBox.getText().equals(searchBoxDefaultText))
					searchBox.setText("");
			}
		});
		
		Button buttonSearch = new Button();
		buttonSearch.setHTML("S&oslash;g");
		buttonSearch.addClickHandler(new ClickHandlerSearch());
		
		Button buttonUpdate = new Button("Opdater");
		buttonUpdate.addClickHandler(new ClickHandlerUpdate());
		
		//Table
		tableList.setHTML(0, 0, "Recept ID");
		tableList.setHTML(0, 1, "R&aring;vare ID");
		tableList.setHTML(0, 2, "Nominelle V&aelig;gt (kg)");
		tableList.setHTML(0, 3, "Tolerance (%)");
		tableList.setHTML(0, 5, "Handling");
		tableList.setBorderWidth(1);
		tableList.setCellPadding(10);
		tableList.setWidth("100%");
		
		//Buttom panel
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setWidth("100%");
		buttonPanel.setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
		buttonPanel.addStyleName("paddedVerticalPanel");
		
		Button createButton = new Button();		
		createButton.setHTML("Opret Recept Komponent");
		createButton.setStyleName("button");
		createButton.addClickHandler(new ClickHandlerCreate());
		
		Button backButton = new Button();		
		backButton.setHTML("Tilbage");
		backButton.setStyleName("button");
		backButton.addClickHandler(new ClickHandlerBack(this));
		
		//Add widgets
		topPanel.add(pageTitle);
		topPanel.add(searchBox);
		topPanel.add(buttonSearch);
		topPanel.add(buttonUpdate);
		
		buttonPanel.add(createButton);
		buttonPanel.add(backButton);
		
		mainPanel.add(topPanel);
		mainPanel.add(tableList);
		mainPanel.add(buttonPanel);
	}
	
	public void statusUpdate(String message) {
		Window.alert(message);
	}
	
	public void updateTable(List<ReceptkompDTO> receptkomp) {
		receptkompList = receptkomp;
		update(receptkompList);
	}
	
	private void update(List<ReceptkompDTO> receptkomps) {
		dispReceptkompList = receptkomps;
		clearTable(receptkomps.size() + 1);
		
		for (int i = 0; i < receptkomps.size(); i++) {
			addReceptkompToTable(i + 1, receptkomps.get(i));
		}
	}
	
	private void addReceptkompToTable(int rowIndex, ReceptkompDTO receptKomp) {		
		tableList.setText(rowIndex, 0, "" + receptKomp.getReceptID());
		tableList.setText(rowIndex, 1, "" + receptKomp.getRaavareID());
		tableList.setText(rowIndex, 2, "" + receptKomp.getNomNetto());
		tableList.setText(rowIndex, 3, "" + receptKomp.getTolerance());
		
		HorizontalPanel ButtonPanel = new HorizontalPanel();
		
		PushButton editButton = new PushButton(new Image("Billeder/edit-icon.png"));
		editButton.addClickHandler(new ClickHandlerEdit());
		editButton.setTitle("Rediger");
		ButtonPanel.add(editButton);
		
		PushButton deleteButton = new PushButton(new Image("Billeder/trash-icon.png"));
		deleteButton.addClickHandler(new ClickHandlerDelete());
		deleteButton.setTitle("Slet");
		ButtonPanel.add(deleteButton);
		
		tableList.setWidget(rowIndex, tableColumns - 1, ButtonPanel);
	}
	
	private void clearTable(int size) {
		tableList.resize(size, tableColumns);
	}
	
	private void search(String searchText) {
		if(receptkompList != null) {
			ArrayList<ReceptkompDTO> result = new ArrayList<>();
			if(searchText.length() > 0) {
				try {
					int searhInt = Integer.parseInt(searchText);
					
					for (ReceptkompDTO receptkomp: receptkompList) {
						if(receptkomp.getReceptID() == searhInt || receptkomp.getRaavareID() == searhInt) {
							result.add(receptkomp);
						}
					}
				}
				catch(NumberFormatException e) { }
				finally {
					if(result != null)
						update(result);
				}
			}
			else
				update(receptkompList);
		}
	}
	
	private class ClickHandlerSearch implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			search(searchBox.getText());			
		}
	}
	
	private class ClickHandlerUpdate implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
//			serverComm.getRecptkompListByPbID(currReceptID);
		}
	}
	
	private class ClickHandlerEdit implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			ReceptkompDTO pbkomp = dispReceptkompList.get(tableList.getCellForEvent(event).getRowIndex() - 1);
			
			ReceptkompPopup editPopup = new ReceptkompPopup(pbkomp);
			editPopup.setExecuteClickHandler(new PopupHandlerExecute(editPopup));
			editPopup.setCancelClickHandler(new PopupHandlerCancel(editPopup));
			editPopup.show();
		}
	}
	
	private class ClickHandlerDelete implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			ReceptkompDTO receptkomp = dispReceptkompList.get(tableList.getCellForEvent(event).getRowIndex() - 1);
			
//			if(Window.confirm("Er du sikker paa at du vil slette produktbatch komponenten " + receptkomp.getReceptID() + " + " + receptkomp.getRaavareID() + '?'))
//				serverComm.deleteReceptkomp(receptkomp.getReceptID(), receptkomp.getRaavareID());
		}
	}
	
	private class ClickHandlerCreate implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			ReceptkompPopup createPopup = new ReceptkompPopup(null);
			createPopup.setExecuteClickHandler(new PopupHandlerExecute(createPopup));
			createPopup.setCancelClickHandler(new PopupHandlerCancel(createPopup));
			createPopup.show();
		}
	}
	
	private class ClickHandlerBack implements ClickHandler
	{
		ReceptkompPanel parent;
		
		protected ClickHandlerBack(ReceptkompPanel parent) {
			this.parent = parent;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			parent.parent.parent.gotoPanel(parent.parent);
		}
	}
	
	private class PopupHandlerExecute implements ClickHandler 
	{
		private final ReceptkompPopup popup;
		
		protected PopupHandlerExecute(ReceptkompPopup popup) {
			this.popup = popup;
		}

		@Override
		public void onClick(ClickEvent event) {
			int receptID = popup.getReceptID();
			int raavareID = popup.getRaavareID();
			double nomNetto = popup.getNomNetto();
			double tolerance = popup.getTolerance();
			
			try {
				ReceptkompDTO receptkomp = new ReceptkompDTO(receptID, raavareID, nomNetto, tolerance);

//				if(popup.isCreate())
//					serverComm.createReceptkomp(receptkomp);
//				else 
//					serverComm.updateReceptkomp(receptkomp);
			} 
			catch (DALException e) {
				statusUpdate(e.getMessage());
			}
			finally {
				popup.hide();
			}
		}
	}
	
	private class PopupHandlerCancel implements ClickHandler 
	{
		private ReceptkompPopup popup;
		
		protected PopupHandlerCancel(ReceptkompPopup popup) {
			this.popup = popup;
		}

		@Override
		public void onClick(ClickEvent event) {
			popup.hide();
		}
	}
}