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
import edu.example.client.models.OperatorDTO;
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
    @UiField static MenuBar mainMenu; 
    @UiField static MenuItem miAfvejning; 
    @UiField static MenuItem miProfile; 
    @UiField static MenuItem miOperators; 
    @UiField static MenuItem miRaavare; 
    @UiField static MenuItem miRB; 
    @UiField static MenuItem miPB; 
    @UiField static MenuItem miRecept; 
    @UiField static MenuItem miLogin; 
    @UiField static MenuItem miTerminate; 
    


	public MenuWidget(Banner banner, RPCServiceClientImpl serverComm) {
		initWidget(uiBinder.createAndBindUi(this));
		
		miAfvejning.setScheduledCommand(cmd_NyAfvejning);
		miProfile.setScheduledCommand(cmd_Profile);
		miOperators.setScheduledCommand(cmd_Operators);
		miRaavare.setScheduledCommand(cmd_Raavare);
		miRB.setScheduledCommand(cmd_Raavarebatch);
		miPB.setScheduledCommand(cmd_Produktbatch);
		miRecept.setScheduledCommand(cmd_Recept);
		miLogin.setScheduledCommand(cmd_Login);
		miTerminate.setScheduledCommand(cmd_Afslut);
		
		parent = banner;
		this.serverComm = serverComm;
		
		updateMenu(-1);
	}
	
	public Object getCurrentPanel() {
		return currentPanel;
	}
	
	public void gotoPanel(Composite panel) {
		currentPanel = panel;
		parent.setContentPanel(panel);
	}

	private Command cmd_NyAfvejning = new Command() {
		public void execute() {			
			WeightPage  viewPanel = new WeightPage(serverComm);
			gotoPanel(viewPanel);
		}
	};

	private Command cmd_Profile = new Command() {
		public void execute() {
			ViewProfile viewPanel = new ViewProfile("Se Profil", Session.CURRENT_USER.getOprID(), me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	private Command cmd_Operators = new Command() {
		public void execute() {
			OperatoerList viewPanel = new OperatoerList(me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	private Command cmd_Raavare = new Command() {
		public void execute() {
			RaavarePanel raavarePanel = new RaavarePanel(me, serverComm);
			gotoPanel(raavarePanel);
		}
	};
	
	private Command cmd_Raavarebatch = new Command() {
		public void execute() {
			RaavarebatchPanel raavarebatchPanel = new RaavarebatchPanel(me, serverComm);
			gotoPanel(raavarebatchPanel);
		}
	};
	
	private Command cmd_Produktbatch = new Command() {
		public void execute() {
			ProduktbatchPanel produktbatchPanel = new ProduktbatchPanel(me, serverComm);
			gotoPanel(produktbatchPanel);
		}
	};
	
	private Command cmd_Recept = new Command() {
		public void execute() {
			ReceptPanel viewPanel = new ReceptPanel(me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	private Command cmd_Login = new Command() {
		public void execute() {
			Login viewPanel = new Login(me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	private Command cmd_Afslut = new Command() {
		public void execute() {
			Afslut viewPanel = new Afslut(me, serverComm);
			gotoPanel(viewPanel);
		}
	};
	
	public static void updateMenu(int rank) {
		miAfvejning.setVisible(false);
		miProfile.setVisible(false);
		miOperators.setVisible(false);
		miRaavare.setVisible(false);
		miRB.setVisible(false);
		miPB.setVisible(false);
		miRecept.setVisible(false);
		miLogin.setVisible(false);
		miTerminate.setVisible(false);
		
		if(!(rank < OperatorDTO.RANK_ADMIN || rank > OperatorDTO.RANK_OPR)) {
			if(rank <= OperatorDTO.RANK_OPR) {
				miAfvejning.setVisible(true);
				miProfile.setVisible(true);
				miLogin.setVisible(true);
				miTerminate.setVisible(true);
			}
			if(rank <= OperatorDTO.RANK_VAERK) {
				miRB.setVisible(true);
				miPB.setVisible(true);
			}
			if(rank <= OperatorDTO.RANK_FARMA) {
				miRaavare.setVisible(true);
				miRecept.setVisible(true);
			}
			if(rank <= OperatorDTO.RANK_ADMIN) {
				miOperators.setVisible(true);
			}
		}
	}
}