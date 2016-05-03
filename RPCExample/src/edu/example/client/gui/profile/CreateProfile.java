package edu.example.client.gui.profile;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import edu.example.client.service.ExampleServiceClientImpl;
import edu.example.client.temp.OperatorDTO;
import edu.example.server.database.dto.OperatoerDTO;

public class CreateProfile extends ProfilePage 
{
	private ExampleServiceClientImpl serverComm;
	
	private InfoBox nameField;
	private InfoBox initialsField;
	private InfoBox cprField;
	private InfoBox idField;
	private InfoBox rankField;
	
	private Button saveButton;
	private Button cancelButton;

	public CreateProfile(String title, ExampleServiceClientImpl serverComm) {
		super(title);
		this.serverComm = serverComm;

		init();
	}
	
	private void init() {
		//Content
		nameField = new InfoBox("Navn", new TextBox());
		initialsField = new InfoBox("Initialer", new TextBox());
		cprField = new InfoBox("CPR Nr.", new TextBox());
		idField = new InfoBox("ID", new TextBox());
		
		ListBox rankList = new ListBox();
		rankList.addItem(OperatorDTO.rankToString(OperatorDTO.RANK_OPR));
		rankList.addItem(OperatorDTO.rankToString(OperatorDTO.RANK_ADMIN));
		rankField = new InfoBox("Rank", rankList);
		
		contentPanel.add(nameField);
		contentPanel.add(initialsField);
		contentPanel.add(cprField);
		contentPanel.add(idField);
		contentPanel.add(rankField);
		contentPanel.add(new InfoBox("Password", new Button("Skift Password")));

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
	public void setContent(String name, String initials, long cpr, int id, String rank) {
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
	public long getCPR() {
		TextBox tbCPR = (TextBox) cprField.getWidget();
		return Long.parseLong(tbCPR.getText());
	}

	@Override
	public void setCPR(long cpr) {
		TextBox tbCPR = (TextBox) cprField.getWidget();
		tbCPR.setText(cpr + "");
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
	
	private class SaveClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			serverComm.createOperatoer(new OperatoerDTO());
		}
	}
	
	private class CancelClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			//TODO: Cancel
		}
	}
}