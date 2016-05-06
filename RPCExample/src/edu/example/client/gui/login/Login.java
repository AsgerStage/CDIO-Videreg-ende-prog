package edu.example.client.gui.login;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.gui.MenuWidget;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.ExampleService;
import edu.example.client.service.ExampleServiceAsync;
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
	
	
		
	/**
	 * This is the entry point method.
	 */
	public Login(ExampleServiceClientImpl serverComm)  {
		initWidget(this.vPanel);
		this.serverComm=serverComm;
		onModuleLoad();
	}

	public void onModuleLoad() {
		final ExampleServiceAsync a1 = GWT.create(ExampleService.class);

		// Add a normal textbox
		Label bruger = new Label("Bruger ID:");
		vPanel.add(bruger);
		
		//TextBox normalText = new TextBox();
		vPanel.add(normalText);



		// Add a normal password text box
		Label pass = new Label("Password:");
		vPanel.add(pass);
		//PasswordTextBox normalPassword = new PasswordTextBox();
		vPanel.add(normalPassword);

		Button Authenticate = new Button("Log ind");
		Authenticate.addClickHandler(new ButtonClickHandler());
		vPanel.add(Authenticate);

		lbltest = new Label("Test:");
		vPanel.add(lbltest);


	}

	private class ButtonClickHandler implements ClickHandler {
		@Override
			public void onClick(ClickEvent e)
            {
			int ID = Integer.parseInt(normalText.getText());
			serverComm.getOperator(ID);
		
			pass = normalPassword.getText();
			
			//serverComm.getOperator(25);
            }
	}

	public void CompareLogin(OperatorDTO result) {
		if(result.getPassword().equals(normalPassword.getText())== true){
			
		}
		
		
		
	}
}
 
