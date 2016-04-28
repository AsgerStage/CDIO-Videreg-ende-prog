package cdio3.client.login;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VaegtUsers implements EntryPoint {

	// private String brugerID;
	// private String password;
	
	private Label lbltest;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		VerticalPanel vPanel = new VerticalPanel();

		// Add a normal textbox
		Label bruger = new Label("Bruger ID:");
		vPanel.add(bruger);
		TextBox normalText = new TextBox();

		

		vPanel.add(normalText);

		// Add a normal password text box
		Label pass = new Label("Password:");
		vPanel.add(pass);
		PasswordTextBox normalPassword = new PasswordTextBox();
		vPanel.add(normalPassword);

		Button Authenticate = new Button("Log ind");
		Authenticate.addClickHandler(new ButtonClickHandler());
		vPanel.add(Authenticate);
		
		lbltest = new Label("Test:");
		vPanel.add(lbltest);
	

		RootPanel.get().add(vPanel);

	}

	private class ButtonClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
		
			lbltest.setText("!!");
			
		

		}

	}
}
