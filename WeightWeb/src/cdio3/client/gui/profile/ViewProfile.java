package cdio3.client.gui.profile;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

import cdio3.client.temp.OperatorDTO;

public class ViewProfile extends ProfilePage 
{
	private OperatorDTO user;
	private InfoBox nameField;
	private InfoBox initialsField;
	private InfoBox cprField;
	private InfoBox idField;
	private InfoBox rankField;
	
	private Button editButton;
	private Button cancelButton;
	
	public ViewProfile(String title, OperatorDTO user) {
		super(title);

		this.user = user;
		
		init();
	}
	
	private void init() {
		//Content
		nameField = new InfoBox("Navn", new Label(user.getName()));
		initialsField = new InfoBox("Initialer", new Label(user.getIni()));
		cprField = new InfoBox("CPR Nr.", new Label(user.getCpr() + ""));
		idField = new InfoBox("ID", new Label(user.getOprID() + ""));
		rankField = new InfoBox("Rank", new Label(OperatorDTO.rankToString(user.getRank())));
		
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
		editButton.addClickHandler(new EditClickHandler());
		cancelButton.setText("Tilbage");
		cancelButton.setStyleName("button");
		cancelButton.addClickHandler(new CancelClickHandler());
		
		buttonPanel.add(editButton);
		buttonPanel.add(cancelButton);
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
	public long getCPR() {
		Label lblCpr = (Label) cprField.getWidget();
		return Long.parseLong(lblCpr.getText());
	}

	@Override
	public void setCPR(long cpr) {
		Label lblCpr = (Label) cprField.getWidget();
		lblCpr.setText(cpr + "");
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
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
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
