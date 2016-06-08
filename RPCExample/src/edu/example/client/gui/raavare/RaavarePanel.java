package edu.example.client.gui.raavare;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

import edu.example.client.gui.MenuWidget;
import edu.example.client.models.RaavareDTO;
import edu.example.client.service.ExampleServiceClientImpl;

public class RaavarePanel extends Composite
{
	public MenuWidget parent;
	private ExampleServiceClientImpl serverComm;
	private VerticalPanel mainPanel = new VerticalPanel();
	
	private final String searchBoxDefaultText = "Soeg efter raavare";
	private final TextBox searchBox = new TextBox();
	
	private final Grid tableList = new Grid(1, 4);
	private List<RaavareDTO> raavareList = null;
	private List<RaavareDTO> dispRaavareList = null;
	
	public RaavarePanel(MenuWidget parent, ExampleServiceClientImpl serverComm) {
		this.parent = parent;
		this.serverComm = serverComm;
		
		mainPanel.setSize("100%", "100%");
		initWidget(mainPanel);
		init();
		
		this.serverComm.getRaavareList();
	}
	
	private void init() {
		//Top panel
		HorizontalPanel topPanel = new HorizontalPanel();
		
		HTML pageTitle = new HTML("R&aring;varer");
		pageTitle.addStyleName("h1");
		
		searchBox.setText(searchBoxDefaultText);
		
		Button buttonSearch = new Button();
		buttonSearch.setHTML("S&oslash;g");
		buttonSearch.addClickHandler(new ClickHandlerSearch());
		
		Button buttonUpdate = new Button("Opdater");
		buttonUpdate.addClickHandler(new ClickHandlerUpdate());
		
		//Table
		tableList.setHTML(0, 0, "ID");
		tableList.setHTML(0, 1, "R&aring;vare Navn");
		tableList.setHTML(0, 2, "Levenrad&oslash;r");
		tableList.setHTML(0, 3, "Handling");
		tableList.setBorderWidth(1);
		tableList.setCellPadding(10);
		tableList.setWidth("100%");
		
		//Buttom panel
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setWidth("100%");
		buttonPanel.setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
		buttonPanel.addStyleName("paddedVerticalPanel");
		
		Button createButtom = new Button();		
		createButtom.setHTML("Opret R&aring;vare");
		createButtom.setStyleName("button");
		createButtom.addClickHandler(new ClickHandlerCreate());
		
		//Add widgets
		topPanel.add(pageTitle);
		topPanel.add(searchBox);
		topPanel.add(buttonSearch);
		topPanel.add(buttonUpdate);
		
		buttonPanel.add(createButtom);
		
		mainPanel.add(topPanel);
		mainPanel.add(tableList);
		mainPanel.add(buttonPanel);
	}

	public void statusUpdate(Boolean result) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateTable(List<RaavareDTO> raavarer) {
		raavareList = raavarer;
		update(raavareList);
	}
	
	private void update(List<RaavareDTO> raavarer) {
		dispRaavareList = raavarer;
		clearTable(raavarer.size() + 1);
		
		for (int i = 0; i < raavarer.size(); i++) {
			addRaavareToTable(i + 1, raavarer.get(i));
		}
	}
	
	private void addRaavareToTable(int rowIndex, RaavareDTO raavare) {
		tableList.setText(rowIndex, 0, "" + raavare.getRaavareID());
		tableList.setText(rowIndex, 1, raavare.getRaavareNavn());
		tableList.setText(rowIndex, 2, raavare.getLeverandoer());
		
		HorizontalPanel ButtonPanel = new HorizontalPanel();
		
		PushButton editButton = new PushButton(new Image("Billeder/edit-icon.png"));
		editButton.addClickHandler(new ClickHandlerEdit());
		editButton.setTitle("Rediger");
		ButtonPanel.add(editButton);
		
		PushButton deleteButton = new PushButton(new Image("Billeder/trash-icon.png"));
		deleteButton.addClickHandler(new ClickHandlerDelete());
		deleteButton.setTitle("Slet");
		ButtonPanel.add(deleteButton);
		
		tableList.setWidget(rowIndex, 3, ButtonPanel);
	}
	
	private void clearTable(int size) {
		tableList.resize(size, 4);
	}
	
	private class ClickHandlerSearch implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			String searchText = searchBox.getText();
			
			if(raavareList != null) {
				ArrayList<RaavareDTO> result = new ArrayList<>();
				
				try {
					int searhID = Integer.parseInt(searchText);
					
					for (RaavareDTO raavare : raavareList) {
						if(raavare.getRaavareID() == searhID) {
							result.add(raavare);
							break;
						}
					}
				}
				catch(NumberFormatException e) {
					for (RaavareDTO raavare : raavareList) {
						if(raavare.getRaavareNavn().contains(searchText) || raavare.getLeverandoer().contains(searchText)) {
							result.add(raavare);
						}
					}
				}
				finally {
					if(result != null)
						update(result);
				}
			}
			
			
		}
	}
	
	private class ClickHandlerUpdate implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			serverComm.getRaavareList();
		}
	}
	
	private class ClickHandlerEdit implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			RaavareDTO raavare = dispRaavareList.get(tableList.getCellForEvent(event).getRowIndex() - 1);
			
			RaavareInfoPopup editPopup = new RaavareInfoPopup(raavare);
			editPopup.setExecuteClickHandler(new PopupHandlerExecute(editPopup));
			editPopup.setCancelClickHandler(new PopupHandlerCancel(editPopup));
			editPopup.show();
		}
	}
	
	private class ClickHandlerCreate implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			RaavareInfoPopup createPopup = new RaavareInfoPopup(null);
			createPopup.setExecuteClickHandler(new PopupHandlerExecute(createPopup));
			createPopup.setCancelClickHandler(new PopupHandlerCancel(createPopup));
			createPopup.show();
		}
	}
	
	private class ClickHandlerDelete implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			
		}
	}
	
	private class PopupHandlerExecute implements ClickHandler 
	{
		private final RaavareInfoPopup popup;
		
		protected PopupHandlerExecute(RaavareInfoPopup popup) {
			this.popup = popup;
		}

		@Override
		public void onClick(ClickEvent event) {
			int raavareID = popup.getRaavareID();
			String raavareName = popup.getRaavareName();
			String leverandoer = popup.getRaavareLeverandoer();
			
			RaavareDTO raavare = new RaavareDTO(raavareID, raavareName, leverandoer);
			
			if(popup.isCreate()) 
				serverComm.createRaavare(raavare);
			else 
				serverComm.updateRaavare(raavare);
		}
	}
	
	private class PopupHandlerCancel implements ClickHandler 
	{
		private RaavareInfoPopup popup;
		
		protected PopupHandlerCancel(RaavareInfoPopup popup) {
			this.popup = popup;
		}

		@Override
		public void onClick(ClickEvent event) {
			popup.hide();
		}
	}
}