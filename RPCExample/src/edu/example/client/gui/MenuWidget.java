package edu.example.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

import edu.example.client.gui.Lists.OperatoerList;
//import edu.example.client.gui.login.Afslut;
import edu.example.client.gui.login.Login;
import edu.example.client.gui.produktbatch.ProduktbatchPanel;
import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.gui.raavare.RaavarePanel;
import edu.example.client.gui.raavarebatch.RaavarebatchPanel;
import edu.example.client.gui.recept.ReceptPanel;
import edu.example.client.logUd.Afslut;
import edu.example.client.misc.Session;
import edu.example.client.service.RPCServiceClientImpl;
import edu.example.client.weightPage.WeightPage;

public class MenuWidget extends Composite
{
	private static MenuWidgetUiBinder uiBinder = GWT.create(MenuWidgetUiBinder.class);
	interface MenuWidgetUiBinder extends UiBinder<Widget, MenuWidget> {}
	private MenuWidget me = this;
	private Banner parent;
	private Object currentPanel = null;
	private RPCServiceClientImpl serverComm;
    @UiField MenuBar mainMenu; 
    @UiField MenuItem item1; 
    @UiField MenuItem item2; 
    @UiField MenuItem item3; 
    @UiField MenuItem item4; 
    @UiField MenuItem item5; 
    @UiField MenuItem item6; 
    @UiField MenuItem item7; 
    @UiField MenuItem item8; 
    @UiField MenuItem item9; 
    


	public MenuWidget(Banner banner, RPCServiceClientImpl serverComm) {
		initWidget(uiBinder.createAndBindUi(this));
		
		item1.setScheduledCommand(cmd_NyAfvejning);
		item2.setScheduledCommand(cmd_MinSide);
		item3.setScheduledCommand(cmd_Soeg);
		item4.setScheduledCommand(cmd_Raavare);
		item5.setScheduledCommand(cmd_Raavarebatch);
		item6.setScheduledCommand(cmd_Produktbatch);
		item7.setScheduledCommand(cmd_Recept);
		item8.setScheduledCommand(cmd_Login);
		item9.setScheduledCommand(cmd_Afslut);
		
		parent = banner;
		this.serverComm = serverComm;
		

	}
	
	public Object getCurrentPanel() {
		return currentPanel;
	}
	
	public void gotoPanel(Composite panel) {
		currentPanel = panel;
		parent.setContentPanel(panel);
	}

	Command cmd_NyAfvejning = new Command() {
		public void execute() {			
			WeightPage  viewPanel = new WeightPage(serverComm);
			gotoPanel(viewPanel);
		}
	};

	Command cmd_MinSide = new Command() {
		public void execute() {
			ViewProfile viewPanel = new ViewProfile("Se Profil", Session.CURRENT_USER.getOprID(), me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	Command cmd_Soeg = new Command() {
		public void execute() {
			OperatoerList viewPanel = new OperatoerList(me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	Command cmd_Raavare = new Command() {
		public void execute() {
			RaavarePanel raavarePanel = new RaavarePanel(me, serverComm);
			gotoPanel(raavarePanel);
		}
	};
	
	Command cmd_Raavarebatch = new Command() {
		public void execute() {
			RaavarebatchPanel raavarebatchPanel = new RaavarebatchPanel(me, serverComm);
			gotoPanel(raavarebatchPanel);
		}
	};
	
	Command cmd_Produktbatch = new Command() {
		public void execute() {
			ProduktbatchPanel produktbatchPanel = new ProduktbatchPanel(me, serverComm);
			gotoPanel(produktbatchPanel);
		}
	};
	
	Command cmd_Recept = new Command() {
		public void execute() {
			ReceptPanel viewPanel = new ReceptPanel(me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	Command cmd_Login = new Command() {
		public void execute() {
			Login viewPanel = new Login(me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	Command cmd_Afslut = new Command() {
		public void execute() {
			Afslut viewPanel = new Afslut();
			gotoPanel(viewPanel);
		}
	};
}