package edu.example.client.gui.produktbatch;

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

import edu.example.client.gui.MenuWidget;
import edu.example.client.gui.produktbatch.pbKomp.ProduktbatchkompPanel;
import edu.example.client.models.ProduktbatchDTO;
import edu.example.client.service.RPCServiceClientImpl;

public class ProduktbatchPanel extends Composite 
{
	public MenuWidget parent;
	private RPCServiceClientImpl serverComm;
	private VerticalPanel mainPanel = new VerticalPanel();
	
	private final String searchBoxDefaultText = "Soeg efter produktbatch";
	private final TextBox searchBox = new TextBox();
	
	private final int tableColumns = 4;
	private final Grid tableList;
	private List<ProduktbatchDTO> produktbatchList = null;
	private List<ProduktbatchDTO> dispProduktbatchList = null;
		
	public ProduktbatchPanel(MenuWidget parent, RPCServiceClientImpl serverComm) {
		this.parent = parent;
		this.serverComm = serverComm;
		
		mainPanel.setSize("100%", "100%");
		initWidget(mainPanel);
		tableList = new Grid(1, tableColumns);
		init();
		
		this.serverComm.getProduktbatchList();
	}
	
	private void init() {
		//Top panel
		HorizontalPanel topPanel = new HorizontalPanel();
		
		HTML pageTitle = new HTML("Produktbatchs");
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
		tableList.setHTML(0, 0, "ID");
		tableList.setHTML(0, 1, "Recept ID");
		tableList.setHTML(0, 2, "Status");
		tableList.setHTML(0, 3, "Handling");
		tableList.setBorderWidth(1);
		tableList.setCellPadding(10);
		tableList.setWidth("100%");
		
		//Buttom panel
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setWidth("100%");
		buttonPanel.setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
		buttonPanel.addStyleName("paddedVerticalPanel");
		
		Button createButton = new Button();		
		createButton.setHTML("Opret Produktbatch");
		createButton.setStyleName("button");
		createButton.addClickHandler(new ClickHandlerCreate());
		
		//Add widgets
		topPanel.add(pageTitle);
		topPanel.add(searchBox);
		topPanel.add(buttonSearch);
		topPanel.add(buttonUpdate);
		
		buttonPanel.add(createButton);
		
		mainPanel.add(topPanel);
		mainPanel.add(tableList);
		mainPanel.add(buttonPanel);
	}

	public void statusUpdate(String result) {
		Window.alert(result);
	}
	
	public void updateTable(List<ProduktbatchDTO> produktbatch) {
		produktbatchList = produktbatch;
		update(produktbatchList);
	}
	
	private void update(List<ProduktbatchDTO> produktbatchs) {
		dispProduktbatchList = produktbatchs;
		clearTable(produktbatchs.size() + 1);
		
		for (int i = 0; i < produktbatchs.size(); i++) {
			addProduktbatchToTable(i + 1, produktbatchs.get(i));
		}
	}
	
	private void addProduktbatchToTable(int rowIndex, ProduktbatchDTO produktbatch) {		
		tableList.setText(rowIndex, 0, "" + produktbatch.getPbID());
		tableList.setText(rowIndex, 1, "" + produktbatch.getReceptID());
		tableList.setText(rowIndex, 2, ProduktbatchDTO.statusToString(produktbatch.getStatus()));
		
		HorizontalPanel ButtonPanel = new HorizontalPanel();
		
		PushButton viewButton = new PushButton(new Image("Billeder/search-icon.png"));
		viewButton.addClickHandler(new ClickHandlerView(this));
		viewButton.setTitle("Se");
		ButtonPanel.add(viewButton);
		
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
		tableList.resize(size, tableColumns);
	}
	
	private void search(String searchText) {		
		if(produktbatchList != null) {
			ArrayList<ProduktbatchDTO> result = new ArrayList<>();
			if(searchText.length() > 0) {
				try {
					int searhInt = Integer.parseInt(searchText);
					
					for (ProduktbatchDTO produktbatch: produktbatchList) {
						if(produktbatch.getPbID() == searhInt || produktbatch.getReceptID() == searhInt || produktbatch.getStatus() == searhInt) {
							result.add(produktbatch);
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
				update(produktbatchList);
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
			serverComm.getProduktbatchList();
		}
	}
	
	private class ClickHandlerEdit implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			ProduktbatchDTO produktbatch = dispProduktbatchList.get(tableList.getCellForEvent(event).getRowIndex() - 1);
			
			ProduktbatchPopup editPopup = new ProduktbatchPopup(produktbatch);
			editPopup.setExecuteClickHandler(new PopupHandlerExecute(editPopup));
			editPopup.setCancelClickHandler(new PopupHandlerCancel(editPopup));
			editPopup.show();
		}
	}
	
	private class ClickHandlerCreate implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			ProduktbatchPopup createPopup = new ProduktbatchPopup(null);
			createPopup.setExecuteClickHandler(new PopupHandlerExecute(createPopup));
			createPopup.setCancelClickHandler(new PopupHandlerCancel(createPopup));
			createPopup.show();
		}
	}
	
	private class ClickHandlerDelete implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			ProduktbatchDTO produktbatch = dispProduktbatchList.get(tableList.getCellForEvent(event).getRowIndex() - 1);
			
			if(Window.confirm("Er du sikker paa at du vil slette raavarebatch " + produktbatch.getPbID() + '?'))
				serverComm.deleteProduktbatch(produktbatch.getPbID());
		}
	}
	
	private class ClickHandlerView implements ClickHandler
	{
		private ProduktbatchPanel parent;
		
		protected ClickHandlerView(ProduktbatchPanel parent) {
			this.parent = parent;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			ProduktbatchDTO produktbatch = dispProduktbatchList.get(tableList.getCellForEvent(event).getRowIndex() - 1);
			
			ProduktbatchkompPanel pbkompPanel = new ProduktbatchkompPanel(parent, serverComm, produktbatch.getPbID());
			parent.parent.gotoPanel(pbkompPanel);
		}
	}
	
	private class PopupHandlerExecute implements ClickHandler 
	{
		private final ProduktbatchPopup popup;
		
		protected PopupHandlerExecute(ProduktbatchPopup popup) {
			this.popup = popup;
		}

		@Override
		public void onClick(ClickEvent event) {
			int produktbatchID = popup.getProduktbatchID();
			int receptID = popup.getReceptID();
			int status = popup.getStatus();
			
			ProduktbatchDTO produktbatch = new ProduktbatchDTO(produktbatchID, status, receptID);
			
			popup.hide();
			if(popup.isCreate()) 
				serverComm.createProduktbatch(produktbatch);
			else 
				serverComm.updateProduktbatch(produktbatch);
		}
	}
	
	private class PopupHandlerCancel implements ClickHandler 
	{
		private ProduktbatchPopup popup;
		
		protected PopupHandlerCancel(ProduktbatchPopup popup) {
			this.popup = popup;
		}

		@Override
		public void onClick(ClickEvent event) {
			popup.hide();
		}
	}
}