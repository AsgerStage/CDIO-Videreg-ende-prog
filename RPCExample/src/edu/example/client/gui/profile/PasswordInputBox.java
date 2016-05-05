package edu.example.client.gui.profile;

import com.google.gwt.dev.shell.SuperDevListener;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PasswordInputBox extends DialogBox 
{
	private Button cancel = new Button("Anuller");
	private TextBox oldPassword = new TextBox();
	private TextBox newPassword1 = new TextBox();
	private TextBox newPassword2 = new TextBox();
	
	protected PasswordInputBox() {
		super();
		this.setTitle("Change Password");
		this.setText("Change Password");
 
//		this.setAnimationEnabled(true);
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
        panel.setHeight("100");
        panel.setWidth("600");
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        panel.add(label);
        panel.add(flxTable);
        panel.add(cancel);
         
        this.setWidget(panel);
        this.setWidth("600");
	}
	
	protected void addClickHandler(ClickHandler clickHandler) {
        cancel.addClickHandler(clickHandler);
	}
}