package edu.example.client.gui.profile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.exceptions.DALException;
import edu.example.client.exceptions.OpIdException;
import edu.example.client.exceptions.OpNameException;
import edu.example.client.exceptions.OpPasswordException;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.ExampleServiceClientImpl;

public class EditProfile extends ProfilePage 
{
	private ViewProfile parent;
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
	
	public EditProfile(String title, OperatorDTO user, ViewProfile parent, ExampleServiceClientImpl serverComm) {
		super(title);
		this.parent = parent;
		this.serverComm = serverComm;
		this.user = user;
		
		init();
		
		setContent(user.getName(), user.getIni(), user.getCpr(), user.getOprID(), OperatorDTO.rankToString(user.getRank()));
		setRank(user.getRank());
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
	
	public void setRank(int rank) {
		ListBox lbRank = (ListBox) rankField.getWidget();
		lbRank.setSelectedIndex(rank);
	}
	
	public OperatorDTO getUser() {
		return user;
	}

	private class PasswordClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) 
		{			
			PasswordInputBox passwordPopup = new PasswordInputBox();
			passwordPopup.setExecuteClickHandler(new UpdatePassword(passwordPopup));
			passwordPopup.setCancelClickHandler(new ClosePasswordBox(passwordPopup));
			passwordPopup.show();
		}
	}
	
	private class UpdatePassword implements ClickHandler 
	{
		private PasswordInputBox passwordBox;
		
		private UpdatePassword(PasswordInputBox passwordBox) {
			this.passwordBox = passwordBox;
		}

		@Override
		public void onClick(ClickEvent event) {
			String oldPass = passwordBox.getOldPassword();
			String newPass1 = passwordBox.getNewPassword1();
			String newPass2 = passwordBox.getNewPassword2();
			
			if(!(oldPass.isEmpty() || newPass1.isEmpty() || newPass2.isEmpty())) {
				if(newPass1.endsWith(newPass2) && oldPass.equals(user.getPassword())) {
					try {
						user.setPassword(newPass1);
						passwordBox.hide();
					} catch (OpPasswordException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private class ClosePasswordBox implements ClickHandler 
	{
		private PasswordInputBox passwordBox;
		
		private ClosePasswordBox(PasswordInputBox passwordBox) {
			this.passwordBox = passwordBox;
		}

		@Override
		public void onClick(ClickEvent event) {
			passwordBox.hide();
		}
	}
	
	private class SaveClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			try {
				serverComm.updateOperator(new OperatorDTO(getID(), getName(), getInitials(), getCPR(), user.getPassword(), 0));
				
				ViewProfile viewPanel = new ViewProfile("Se Profil", getID(), parent.parent, serverComm);
				parent.parent.gotoPanel(viewPanel);
			} catch (OpPasswordException | OpNameException | OpIdException | DALException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class CancelClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			parent.parent.gotoPanel(parent);
		}
	}
}