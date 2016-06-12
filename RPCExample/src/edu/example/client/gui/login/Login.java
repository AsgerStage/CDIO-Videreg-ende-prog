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
import edu.example.client.misc.Utils;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.RPCServiceClientImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;


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
	private RPCServiceClientImpl serverComm;
	private MenuWidget parent;
	
    class User {
        public String user;
        public String hash;
        public String salt;
        public User(String username, String salt, String hash) {
            this.user = username;
            this.hash = hash;
            this.salt = salt;
        }
    }

	/**
	 * This is the entry point method.
	 */
	public Login(MenuWidget parent, RPCServiceClientImpl serverComm) {
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

		//Add a button
		Button Authenticate = new Button("Log ind");
		Authenticate.addClickHandler(new LoginClickHandler());
		vPanel.add(Authenticate);
		Authenticate.setStyleName("loginbutton");
		
		lbltest.setVisible(false);


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

	public void CompareLogin(OperatorDTO opr) {
		String pw = normalPassword.getText();
		

		boolean pwMatch = opr.getHash().equals(Utils.getMD5Hash(pw));

		if (pwMatch == true) {
			//lbltest.setText("rigtigt password");
			ViewProfile viewPanel = new ViewProfile("Se Profil", Integer.parseInt(normalText.getText()), parent, serverComm);
			parent.gotoPanel(viewPanel);
		} 
		else if (pwMatch == false) {
			lbltest.setVisible(true);
			lbltest.setText("Forkert password");
			normalPassword.setFocus(true);
		}
	}
} 

