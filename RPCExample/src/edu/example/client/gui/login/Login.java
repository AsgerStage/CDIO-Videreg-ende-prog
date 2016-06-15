package edu.example.client.gui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import edu.example.client.gui.MenuWidget;
import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.misc.Session;
import edu.example.client.misc.Utils;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.RPCServiceClientImpl;

public class Login extends Composite
{
	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);
	private RPCServiceClientImpl serverComm;
	private MenuWidget parent;

	@UiField
	TextBox normalText;
	@UiField
	PasswordTextBox normalPassword;
	@UiField
	Button authenticate;

	interface LoginUiBinder extends UiBinder<Widget, Login> {

	}

	public Login(MenuWidget parent, RPCServiceClientImpl serverComm) {
		initWidget(uiBinder.createAndBindUi(this));
		this.parent = parent;
		this.serverComm = serverComm;
		
		authenticate.addStyleName("paddedVerticalPanel");
	}

	@UiHandler("authenticate")
	public void HandleClick(ClickEvent e) {
		int ID = Integer.parseInt(normalText.getText());
		serverComm.getOperator(ID);
	}

	public void CompareLogin(OperatorDTO opr) {
		String pw = normalPassword.getText();

		boolean pwMatch = opr.getHash().equals(Utils.getMD5Hash(pw));

		if (pwMatch == true) {
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