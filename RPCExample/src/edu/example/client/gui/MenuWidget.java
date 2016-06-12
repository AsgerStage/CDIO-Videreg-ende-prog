package edu.example.client.gui;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

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
	private MenuWidget me = this;
	private HorizontalPanel hPanel= new HorizontalPanel();
	private Banner parent;
	private Object currentPanel = null;
	private RPCServiceClientImpl serverComm;

	public MenuWidget(Banner banner, RPCServiceClientImpl serverComm) {
		initWidget(this.hPanel);
		parent = banner;
		this.serverComm = serverComm;
		
		
		MenuBar menu = new MenuBar(true);
		menu.addItem(new MenuItem("Ny afvejning", cmd_NyAfvejning));
		menu.addItem(new MenuItem("Min side", cmd_MinSide));
		menu.addItem(new MenuItem("Soeg", cmd_Soeg));
		
		MenuItem miRaavere = new MenuItem("", cmd_Raavare);
		miRaavere.setHTML("R&aring;varer");
		menu.addItem(miRaavere);
		

		MenuItem miRaaverebatch = new MenuItem("", cmd_Raavarebatch);
		miRaaverebatch.setHTML("R&aring;varebatchs");
		menu.addItem(miRaaverebatch);
		
		menu.addItem(new MenuItem("Pruduktbatchs", cmd_Produktbatch));
		
		MenuItem receptList = new MenuItem("Recepter",cmd_Recept);
		menu.addItem(receptList);
		
		menu.addItem(new MenuItem("Login", cmd_Login));
		menu.addItem(new MenuItem("Afslut", cmd_Afslut));
		
		hPanel.add(menu);
		menu.setHeight("100%");
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