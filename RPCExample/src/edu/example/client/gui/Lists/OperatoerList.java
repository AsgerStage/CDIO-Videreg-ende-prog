package edu.example.client.gui.Lists;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.gui.MenuWidget;
import edu.example.client.gui.profile.EditProfile;
import edu.example.client.gui.profile.ProfilePage;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.ExampleServiceClientImpl;

public class OperatoerList extends Composite 
{
	public MenuWidget parent;
	private VerticalPanel vPanel = new VerticalPanel();
	private ExampleServiceClientImpl serverComm;
	
	private Label myLbl = new Label("Operatoer");
	private Grid opTable = new Grid(1,7);
	private TextBox searchBox = new TextBox();
	private final String searchBoxDefaultText = "Dette er et soegefelt";
	
	private List<OperatorDTO> currentDisp; //Indeholder den liste af personer der bliver displayet
	
	public OperatoerList(MenuWidget parent, ExampleServiceClientImpl serverComm) {
		this.parent = parent;
		this.serverComm = serverComm;
		initWidget(this.vPanel);
		onModuleLoad();
	}
	
	public void onModuleLoad() {
		HorizontalPanel hPanel = new HorizontalPanel();
		serverComm.getOpList();
		
		myLbl.getElement().setPropertyString("id", "opLabel");
	 
		hPanel.add(myLbl);
		vPanel.add(hPanel);

		searchBox.setText(searchBoxDefaultText);
		hPanel.add(searchBox);
		Button SoegBtn = new Button("Soeg");
		SoegBtn.addClickHandler(new SearchClickHandler());
		hPanel.add(SoegBtn);
		
		Button refreshButton = new Button("Opdater");
		refreshButton.addClickHandler(new RefreshClickHandler());
		hPanel.add(refreshButton);
		
		opTable.setText(0, 0, "ID");
		opTable.setText(0, 1, "Navn");
		opTable.setText(0, 2, "Ini");
		opTable.setText(0, 3, "Rank");
		opTable.setText(0, 4, "CPR");
		opTable.setText(0, 5, "Password");
		opTable.setText(0, 6, "Rediger");
		 
		opTable.setBorderWidth(1);
		vPanel.add(opTable);
		opTable.setCellPadding(10);
		opTable.getRowCount();		
	}
	
	public void addOp(OperatorDTO operator) {		
		opTable.resize(opTable.getRowCount() + 1, 7);
		int rowIndex = opTable.getRowCount() - 1;
		
		opTable.setText(rowIndex, 0, "" + operator.getOprID());
		opTable.setText(rowIndex, 1, operator.getName());
		opTable.setText(rowIndex, 2, operator.getIni());
		opTable.setText(rowIndex, 3, "" + operator.getRank());
		opTable.setText(rowIndex, 4, "" + operator.getCpr());
		opTable.setText(rowIndex, 5, "" + operator.getPassword());
		
		Button editButton = new Button("Rediger");
		editButton.addClickHandler(new EditClickHandler(this));
		opTable.setWidget(rowIndex, 6, editButton);
	}	
	
	public void updateOperatoerList(List<OperatorDTO> result) {
		clear();
		
		if (searchBox.getText().equals(searchBoxDefaultText) || searchBox.getText().equals("")) {
			for (int i = 0; i < result.size(); i++){
				addOp(result.get(i));
			}
			
			currentDisp = result;
		}
		else {
			try {
				int searchBoxInt;
				
				for(int i = 0; i < result.size(); i++) {
					searchBoxInt=Integer.parseInt(searchBox.getText());
					
					if(!(result.get(i).getOprID() == searchBoxInt)){
						result.remove(i);
						i = -1;
					}
				}
			}
			catch(Exception e) {
				for (int i = 0; i < result.size(); i++) {
					if (!(result.get(i).getName().contains(searchBox.getText()) || result.get(i).getIni().contains(searchBox.getText()) || result.get(i).getCpr().contains(searchBox.getText()))) {
						result.remove(i);
						i = -1;
					}				
				}
			}
			
			for (int j = 0; j < result.size(); j++){
				addOp(result.get(j));
			}	
			currentDisp = result;
		}
	}
	
	public void clear() {
		opTable.resize(1, 7);
	}
	
	private class RefreshClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			searchBox.setText(searchBoxDefaultText);
			serverComm.getOpList();
		}
	}
	
	private class SearchClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			serverComm.getOpList();
		}
	}
	
	public class EditClickHandler implements ClickHandler 
	{
		private OperatoerList parent;
		private EditClickHandler(OperatoerList parent) {
			this.parent = parent;
		}
	
		@Override
		public void onClick(ClickEvent event) {      
			OperatorDTO user = currentDisp.get(opTable.getCellForEvent(event).getRowIndex()-1);

            ProfilePage editProfilePanel = new EditProfile("Rediger Profil", user, parent, serverComm);
            parent.parent.gotoPanel(editProfilePanel);
        }
	};
}