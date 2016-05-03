package edu.example.client.gui.profile;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import edu.example.client.service.ExampleServiceClientImpl;
import edu.example.server.database.OperatorDTO;

public class EditProfile extends ProfilePage 
{
	private ExampleServiceClientImpl serverComm;
	private OperatorDTO user;
	
	private InfoBox nameField;
	private InfoBox initialsField;
	private InfoBox cprField;
	private InfoBox idField;
	private InfoBox rankField;
	private InfoBox passwordField;
	
	private Button saveButton;
	private Button cancelButton;
	
	public EditProfile(String title, int userID, ExampleServiceClientImpl serverComm) {
		super(title);
		this.serverComm = serverComm;

		user = this.serverComm.getOperator(userID);
		
		init();
		
		setContent(user.getName(), user.getIni(), user.getCpr(), user.getOprID(), OperatorDTO.rankToString(user.getRank()));
		if(user.getRank() != OperatorDTO.RANK_ADMIN) {
			TextBox tbID = (TextBox) idField.getWidget();
			tbID.setEnabled(false);
			
			ListBox lbRank = (ListBox) rankField.getWidget();
			lbRank.setEnabled(false);
		}
		
	}
	
	private final void init() {
		//Content
		nameField = new InfoBox("Navn", new TextBox());
		initialsField = new InfoBox("Initialer", new TextBox());
		cprField = new InfoBox("CPR Nr.", new TextBox());
		idField = new InfoBox("ID", new TextBox());
		
		ListBox rankList = new ListBox();
		rankList.addItem(OperatorDTO.rankToString(OperatorDTO.RANK_OPR));
		rankList.addItem(OperatorDTO.rankToString(OperatorDTO.RANK_ADMIN));
		rankField = new InfoBox("Rank", rankList);
		
		Button passwordButton = new Button();
		passwordButton.setText("Change Password");
//		passwordButton.setStyleName("button");
		passwordButton.addClickHandler(new PasswordClickHandler());
		passwordField = new InfoBox("Password", passwordButton);
		
		contentPanel.add(nameField);
		contentPanel.add(initialsField);
		contentPanel.add(cprField);
		contentPanel.add(idField);
		contentPanel.add(rankField);
		contentPanel.add(passwordField);

		//Buttons
		saveButton = new Button();
		cancelButton = new Button();
		
		saveButton.setText("Gem");
		saveButton.setStyleName("button");
		saveButton.addClickHandler(new SaveClickHandler());
		cancelButton.setText("Annuler");
		cancelButton.setStyleName("button");
		cancelButton.addClickHandler(new CancelClickHandler());
		
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);
	}

	@Override
	protected void onLoad() {
		rankField.getWidget().setWidth(nameField.getWidget().getOffsetWidth() + "px");
		super.onLoad();
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
		TextBox tbName = (TextBox) nameField.getWidget();
		return tbName.getText();
	}

	@Override
	public void setName(String name) {
		TextBox tbName = (TextBox) nameField.getWidget();
		tbName.setText(name);
	}

	@Override
	public String getInitials() {
		TextBox tbInitials = (TextBox) initialsField.getWidget();
		return tbInitials.getText();
	}

	@Override
	public void setInitials(String initials) {
		TextBox tbInitials = (TextBox) initialsField.getWidget();
		tbInitials.setText(initials);
	}

	@Override
	public String getCPR() {
		TextBox tbCPR = (TextBox) cprField.getWidget();
		return tbCPR.getText();
	}

	@Override
	public void setCPR(String cpr) {
		TextBox tbCPR = (TextBox) cprField.getWidget();
		tbCPR.setText(cpr);
	}

	@Override
	public int getID() {
		TextBox tbID = (TextBox) idField.getWidget();
		return Integer.parseInt(tbID.getText());
	}

	@Override
	public void setID(int id) {
		TextBox tbID = (TextBox) idField.getWidget();
		tbID.setText(id + "");
	}

	@Override
	public String getRank() {
		ListBox lbRank = (ListBox) rankField.getWidget();
		return lbRank.getSelectedItemText();
	}

	@Override
	public void setRank(String rank) {
		//TODO: Write method!
	}
	
	public OperatorDTO getUser() {
		return user;
	}
	
	private class PasswordClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
		}
	}
	
	private class SaveClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			serverComm.updateOperator(new OperatorDTO(getID(), getName(), getInitials(), getCPR(), "MISSING EDIT PROFILE PANEL", -1));
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