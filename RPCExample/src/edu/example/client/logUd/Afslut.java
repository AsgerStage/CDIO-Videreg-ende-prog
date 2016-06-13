package edu.example.client.logUd;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import edu.example.client.gui.MenuWidget;
import edu.example.client.gui.login.Login;
import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.service.RPCServiceClientImpl;



public class Afslut extends Composite {

	VerticalPanel vPanel = new VerticalPanel();
	private MenuWidget parent;
	private RPCServiceClientImpl serverComm;
	
	/**
	 * This is the entry point method.
	 */
	public Afslut(MenuWidget parent, RPCServiceClientImpl serverComm){
		initWidget(vPanel);
		this.parent = parent;
		this.serverComm = serverComm;
		onModuleLoad();
		
	}



	public void onModuleLoad() {

		Button btn_logUd = new Button("Log ud");
		btn_logUd.addClickHandler(new ButtonClickHandler());
		vPanel.add(btn_logUd);



	}

	private class ButtonClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
						Window.alert("Du er nu logget ud af systemet");
						Login viewPanel = new Login(parent, serverComm);
						parent.gotoPanel(viewPanel);
						MenuWidget.updateMenu(0);
			// Når man trykker på log ud skal man sendes til den side som hedder loggetOut
	
						

		}

	}

}
