package edu.example.client.gui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.example.client.gui.MenuWidget;
import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.misc.Session;
import edu.example.client.misc.Utils;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.RPCServiceClientImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Login extends Composite {
	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}

	VerticalPanel vPanel = new VerticalPanel();
	private Label lbltest;
	int username;
	String pass;
	private RPCServiceClientImpl serverComm;
	private MenuWidget parent;

	@UiField
	TextBox normalText;
	@UiField
	PasswordTextBox normalPassword;
	@UiField
	Button Authenticate;

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

		initWidget(uiBinder.createAndBindUi(this));
		this.parent = parent;
		this.serverComm = serverComm;
		onModuleLoad();

	}

	public void onModuleLoad() {

	}

	@UiHandler("Authenticate")
	void HandleClick(ClickEvent e) {
		int ID = Integer.parseInt(normalText.getText());
		serverComm.getOperator(ID);
		pass = normalPassword.getText();
	}

	public void CompareLogin(OperatorDTO opr) {
		String pw = normalPassword.getText();

		boolean pwMatch = opr.getHash().equals(Utils.getMD5Hash(pw));

		if (pwMatch == true) {
			// lbltest.setText("rigtigt password");
			Session.CURRENT_USER = opr;
			MenuWidget.updateMenu(opr.getRank());
			ViewProfile viewPanel = new ViewProfile("Se Profil", opr.getOprID(), parent, serverComm);
			parent.gotoPanel(viewPanel);
		} else if (pwMatch == false) {
			Window.alert("Forkert kode");
			normalPassword.setFocus(true);
		}
	}
}
