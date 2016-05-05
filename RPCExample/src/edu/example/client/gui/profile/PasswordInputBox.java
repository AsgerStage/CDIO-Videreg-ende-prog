package edu.example.client.gui.profile;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PasswordInputBox extends DialogBox 
{
	private PasswordTextBox oldPassword = new PasswordTextBox();
	private PasswordTextBox newPassword1 = new PasswordTextBox();
	private PasswordTextBox newPassword2 = new PasswordTextBox();
	private Button cancel = new Button("Anuller");
	private Button execute = new Button("Gem");
	
	protected PasswordInputBox() {
		super();
		this.setTitle("Change Password");
		this.setText("Change Password");
 
		this.setGlassEnabled(true);
         
        Label label = new Label("Change Password");
        Label lblOldPass = new Label("Old Password:");
        Label lblNewPass1 = new Label("New Password:");
        Label lblNewPass2 = new Label("Repeat New:");
        FlexTable flxTable = new FlexTable();
        flxTable.setWidget(0, 0, lblOldPass);
        flxTable.setWidget(0, 1, oldPassword);
        flxTable.setWidget(1, 0, lblNewPass1);
        flxTable.setWidget(1, 1, newPassword1);
        flxTable.setWidget(2, 0, lblNewPass2);
        flxTable.setWidget(2, 1, newPassword2);

        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(10);
        buttonPanel.add(execute);
        buttonPanel.add(cancel);
        
        
        panel.add(label);
        panel.add(flxTable);
        panel.add(buttonPanel);
         
        this.setWidget(panel);
	}
	
	protected void setExecuteClickHandler(ClickHandler clickHandler) {
        execute.addClickHandler(clickHandler);
	}
	
	protected void setCancelClickHandler(ClickHandler clickHandler) {
        cancel.addClickHandler(clickHandler);
	}
	
	protected String getOldPassword() {
		return oldPassword.getText();
	}
	
	protected String getNewPassword1() {
		return newPassword1.getText();
	}
	
	protected String getNewPassword2() {
		return newPassword2.getText();
	}
}