package edu.example.client.gui.login;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import edu.example.client.gui.MenuWidget;
import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.ExampleServiceClientImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Login extends Composite {

	VerticalPanel vPanel = new VerticalPanel();
	private Label lbltest;
	int username;
	String pass;
	TextBox normalText = new TextBox();
	PasswordTextBox normalPassword = new PasswordTextBox();
	private ExampleServiceClientImpl serverComm;
	private MenuWidget parent;

	/**
	 * This is the entry point method.
	 */
	public Login(MenuWidget parent, ExampleServiceClientImpl serverComm) {
		initWidget(this.vPanel);
		this.parent = parent;
		this.serverComm = serverComm;
		onModuleLoad();
	}

	public void onModuleLoad() {
		

		// Add a normal textbox
		Label bruger = new Label("Bruger ID:");
		vPanel.add(bruger);

		vPanel.add(normalText);
		normalText.addStyleName("usernamelogin");;

		// Add a normal password text box
		Label pass = new Label("Password:");
		vPanel.add(pass);

		vPanel.add(normalPassword);
		normalPassword.addStyleName("usernamelogin");
		
		//label for pass error
		lbltest = new Label("Fejl:");
		vPanel.add(lbltest);
		lbltest.setVisible(false);

		//Add a button
		Button Authenticate = new Button("Log ind");
		Authenticate.addClickHandler(new LoginClickHandler());
		vPanel.add(Authenticate);
		Authenticate.setStyleName("loginbutton");


	}
	//Clickhandler for login button
	private class LoginClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent e) {
			int ID = Integer.parseInt(normalText.getText());

			serverComm.getOperator(ID);
			pass = normalPassword.getText();

		}
	}

	public void CompareLogin(OperatorDTO result) {

		if (result.getPassword().equals(normalPassword.getText()) == true) {

			ViewProfile viewPanel = new ViewProfile("Se Profil", 25, parent, serverComm);
			parent.gotoPanel(viewPanel);
		} else if (result.getPassword().equals(normalPassword.getText()) == false) {
			lbltest.setVisible(true);
			lbltest.setText("Forkert password");
			normalPassword.setFocus(true);
		}
	}

} 

