package edu.example.client.logUd;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import edu.example.client.gui.MenuWidget;
import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.service.RPCServiceClientImpl;



public class Afslut extends Composite {

	VerticalPanel vPanel = new VerticalPanel();
	/**
	 * This is the entry point method.
	 */
	public Afslut(){
		initWidget(vPanel);
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
			// Når man trykker på log ud skal man sendes til den side som hedder loggetOut
	


		}

	}

}
