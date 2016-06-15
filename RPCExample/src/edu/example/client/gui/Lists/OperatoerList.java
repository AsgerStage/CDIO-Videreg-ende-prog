/**
 * 
 */
package edu.example.client.gui.Lists;

/**
 * @author Asger
 *
 * 10/06/2016
 */

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
import edu.example.client.exceptions.OpIdException;
import edu.example.client.exceptions.OpNameException;
import edu.example.client.exceptions.OpPasswordException;
import edu.example.client.gui.MenuWidget;
import edu.example.client.models.OperatorDTO;
import edu.example.client.gui.Lists.OperatorPopup;
import edu.example.client.misc.Utils;
import edu.example.client.service.RPCServiceClientImpl;

public class OperatoerList extends Composite
{
	public MenuWidget parent;
	private RPCServiceClientImpl serverComm;
	private VerticalPanel mainPanel = new VerticalPanel();
	
	private final String searchBoxDefaultText = "Soeg efter operator";
	private final TextBox searchBox = new TextBox();
	
	private final Grid tableList = new Grid(1, 7);
	private List<OperatorDTO> operatorList = null;
	private List<OperatorDTO> dispOperatorList = null;
	
	public OperatoerList(MenuWidget parent, RPCServiceClientImpl serverComm) {
		this.parent = parent;
		this.serverComm = serverComm;
		
		mainPanel.setSize("100%", "100%");
		initWidget(mainPanel);
		init();
		
		this.serverComm.getOpList();
	}
	
	private void init() {
		//Top panel
		HorizontalPanel topPanel = new HorizontalPanel();
		
		HTML pageTitle = new HTML("Operat&oslash;rer");
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
		tableList.setHTML(0, 1, "CPR");
		tableList.setHTML(0, 2, "Navn");
		tableList.setHTML(0, 3, "Initialer");
		tableList.setHTML(0, 4, "Rank");
		tableList.setHTML(0, 5, "Password");
		tableList.setHTML(0, 6, "Handling");
		tableList.setBorderWidth(1);
		tableList.setCellPadding(10);
		tableList.setWidth("100%");
		
		//Buttom panel
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setWidth("100%");
		buttonPanel.setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
		buttonPanel.addStyleName("paddedVerticalPanel");
		
		Button createButtom = new Button();		
		createButtom.setHTML("Opret Operat&oslash;r");
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

	public void statusUpdate(String result) {
		String reply = "something went wrong!";
//		if(result == true)
//			reply = "Handlingen blev udfoert";
//		else
//			reply = "Handlingen kunne ikke udfoeres!";
		
		Window.alert(result);
	}
	
	public void updateTable(List<OperatorDTO> operator) {
		operatorList = operator;
		update(operatorList);
	}
	
	private void update(List<OperatorDTO> operator) {
		dispOperatorList = operator;
		clearTable(operator.size() + 1);
		
		for (int i = 0; i < operator.size(); i++) {
			addOperatorToTable(i + 1, operator.get(i));
		}
	}
	
	private void addOperatorToTable(int rowIndex, OperatorDTO operator) {
		tableList.setText(rowIndex, 0, "" + operator.getOprID());
		tableList.setText(rowIndex, 1, operator.getCpr());
		tableList.setText(rowIndex, 2, operator.getName());
		tableList.setText(rowIndex, 3, operator.getIni());
		tableList.setText(rowIndex, 4, ""+operator.getRank());
		tableList.setText(rowIndex, 5, operator.getPassword());
		HorizontalPanel ButtonPanel = new HorizontalPanel();
		
		PushButton editButton = new PushButton(new Image("Billeder/edit-icon.png"));
		editButton.addClickHandler(new ClickHandlerEdit());
		editButton.setTitle("Rediger");
		ButtonPanel.add(editButton);
		
		PushButton deleteButton = new PushButton(new Image("Billeder/trash-icon.png"));
		deleteButton.addClickHandler(new ClickHandlerDelete());
		deleteButton.setTitle("Slet");
		ButtonPanel.add(deleteButton);
		
		tableList.setWidget(rowIndex, 6, ButtonPanel);
	}
	
	private void clearTable(int size) {
		tableList.resize(size, 7);
	}
	
	private void search(String searchText) {		
		if(operatorList != null) {
			ArrayList<OperatorDTO> result = new ArrayList<>();
			
			try {
				int searchInt = Integer.parseInt(searchText);
				
				for (OperatorDTO operator : operatorList) {
					if(operator.getOprID() == searchInt || operator.getRank() == searchInt) {
						result.add(operator);
						break;
					}
				}
			}
			catch(NumberFormatException e) {
				searchText = searchText.toUpperCase();
				
				for (OperatorDTO operator : operatorList) {
					if(operator.getName().toUpperCase().contains(searchText) || operator.getCpr().toUpperCase().contains(searchText) || operator.getIni().toUpperCase().contains(searchText)) {
						result.add(operator);
					}
				}
			}
			finally {
				if(result != null)
					update(result);
			}
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
			serverComm.getOpList();
		}
	}
	
	private class ClickHandlerEdit implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			OperatorDTO operator = dispOperatorList.get(tableList.getCellForEvent(event).getRowIndex() - 1);
			
			OperatorPopup editPopup = new OperatorPopup(operator);
			editPopup.setExecuteClickHandler(new PopupHandlerExecute(editPopup));
			editPopup.setCancelClickHandler(new PopupHandlerCancel(editPopup));
			editPopup.show();
		}
	}
	
	private class ClickHandlerCreate implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			OperatorPopup createPopup = new OperatorPopup(null);
			createPopup.setExecuteClickHandler(new PopupHandlerExecute(createPopup));
			createPopup.setCancelClickHandler(new PopupHandlerCancel(createPopup));
			createPopup.show();
		}
	}
	
	private class ClickHandlerDelete implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			OperatorDTO operator = dispOperatorList.get(tableList.getCellForEvent(event).getRowIndex() - 1);
			
			if(Window.confirm("Er du sikker paa at du vil slette operatoren " + operator.getOprID() + ", " + operator.getName() +"?"))
				serverComm.deleteOperator(operator.getOprID());
		}
	}
	
	private class PopupHandlerExecute implements ClickHandler 
	{
		private final OperatorPopup popup;
		
		protected PopupHandlerExecute(OperatorPopup popup) {
			this.popup = popup;
		}

		@Override
		public void onClick(ClickEvent event) {
			int operatorID = popup.getOperatorID();
			String operatorName = popup.getOperatorName();
			String OperatorIni=popup.getOperatorIni();
			String operatorCPR =popup.getOperatorCpr();
			String OperatorPassword=popup.getOperatorPassword();
			int OperatorRank=popup.getOperatorRank();
	
			OperatorDTO operator;
			try {
				operator = new OperatorDTO(operatorID, operatorName, OperatorIni, operatorCPR, OperatorPassword, OperatorRank, Utils.getMD5Hash(OperatorPassword));
				popup.hide();
				if(popup.isCreate()) 
					serverComm.createOperator(operator);
				else 
					serverComm.updateOperator(operator);
			} catch (OpPasswordException | OpNameException | OpIdException | DALException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	private class PopupHandlerCancel implements ClickHandler 
	{
		private OperatorPopup popup;
		
		protected PopupHandlerCancel(OperatorPopup popup) {
			this.popup = popup;
		}

		@Override
		public void onClick(ClickEvent event) {
			popup.hide();
		}
	}
}