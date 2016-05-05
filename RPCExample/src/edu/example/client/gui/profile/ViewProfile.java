package edu.example.client.gui.profile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

import edu.example.client.gui.MenuWidget;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.ExampleServiceClientImpl;

public class ViewProfile extends ProfilePage 
{
//	private ViewProfile me = this;
	protected MenuWidget parent;
	private ExampleServiceClientImpl serverComm;
	private OperatorDTO user;
	
	private InfoBox nameField;
	private InfoBox initialsField;
	private InfoBox cprField;
	private InfoBox idField;
	private InfoBox rankField;
	
	private Button editButton;
	private Button cancelButton;
	
	public ViewProfile(String title, int userID, MenuWidget parent, ExampleServiceClientImpl serverComm) {
		super(title);
		this.parent = parent;
		this.serverComm = serverComm;
		this.serverComm.getOperator(userID);
		
		init();
	}
	
	public void updateUser(OperatorDTO user) {		
		this.user = user;
		setContent(this.user.getName(), this.user.getIni(), this.user.getCpr(), this.user.getOprID(), OperatorDTO.rankToString(this.user.getRank()));
	}
	
	private void init() {
		//Content
		nameField = new InfoBox("Navn", new Label("Loading.."));
		initialsField = new InfoBox("Initialer", new Label("Loading.."));
		cprField = new InfoBox("CPR Nr.", new Label("Loading.."));
		idField = new InfoBox("ID", new Label("Loading.."));
		rankField = new InfoBox("Rank", new Label("Loading.."));
		
		contentPanel.add(nameField);
		contentPanel.add(initialsField);
		contentPanel.add(cprField);
		contentPanel.add(idField);
		contentPanel.add(rankField);

		//Buttons
		editButton = new Button();
		cancelButton = new Button();
		
		editButton.setText("Rediger");
		editButton.setStyleName("button");
		editButton.addClickHandler(new EditClickHandler(this));
		cancelButton.setText("Tilbage");
		cancelButton.setStyleName("button");
		cancelButton.addClickHandler(new CancelClickHandler());
		
		buttonPanel.add(editButton);
		buttonPanel.add(cancelButton);
	}
	
	@Override
	public void setContent(String name, String initials, String cpr, int id, String rank) {
		setName(name);
		setInitials(initials);
		setCPR(cpr);
		setID(id);
		setRank(rank);
	}

	@Override
	public String getName() {
		Label lblName = (Label) nameField.getWidget();
		return lblName.getText();
	}

	@Override
	public void setName(String name) {
		Label lblName = (Label) nameField.getWidget();
		lblName.setText(name);
	}

	@Override
	public String getInitials() {
		Label lblInitials = (Label) initialsField.getWidget();
		return lblInitials.getText();
	}

	@Override
	public void setInitials(String initials) {
		Label lblInitials = (Label) initialsField.getWidget();
		lblInitials.setText(initials);
	}

	@Override
	public String getCPR() {
		Label lblCpr = (Label) cprField.getWidget();
		return lblCpr.getText();
	}

	@Override
	public void setCPR(String cpr) {
		Label lblCpr = (Label) cprField.getWidget();
		lblCpr.setText(cpr);
	}

	@Override
	public int getID() {
		Label lblID = (Label) idField.getWidget();
		return Integer.parseInt(lblID.getText());
	}

	@Override
	public void setID(int id) {
		Label lblID = (Label) idField.getWidget();
		lblID.setText(id + "");
	}

	@Override
	public String getRank() {
		Label lblRank = (Label) rankField.getWidget();
		return lblRank.getText();
	}

	@Override
	public void setRank(String rank) {
		Label lblRank = (Label) rankField.getWidget();
		lblRank.setText(rank);
	}
	
	private class EditClickHandler implements ClickHandler 
	{
		private ViewProfile parent;
		
		private EditClickHandler(ViewProfile parent) {
			this.parent = parent;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			ProfilePage editProfilePanel = new EditProfile("Rediger Profil", user, parent, serverComm);
			parent.parent.gotoPanel(editProfilePanel);
		}
	}
	
	private class CancelClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
		}
	}
}
