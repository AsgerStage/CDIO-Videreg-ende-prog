package edu.example.client.gui;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.temp.OperatorDTO;

public class MenuWidget extends Composite{

	private HorizontalPanel hPanel= new HorizontalPanel();
	private Banner parent;
	public MenuWidget(){
//		initWidget(this.hPanel);
//
//		
//		hPanel.setBorderWidth(1);
//		hPanel.setWidth("100%");
//		
//		MenuBar menu = new MenuBar(true);
//		menu.addItem(new MenuItem("Ny afvejning", cmd_NyAfvejning));
//		menu.addItem(new MenuItem("Min side", cmd_MinSide));
//		menu.addItem(new MenuItem("Soeg", cmd_Soeg));
//		menu.addItem(new MenuItem("Hjem", cmd_Hjem));
//		menu.addItem(new MenuItem("Afslut", cmd_Afslut));
//
//		hPanel.add(menu);
////		menu.setHeight("100px");
		
	}

	public MenuWidget(Banner banner) {
		initWidget(this.hPanel);
		parent = banner;
		
		hPanel.setBorderWidth(1);
		hPanel.setWidth("100%");
		
		MenuBar menu = new MenuBar(true);
		menu.addItem(new MenuItem("Ny afvejning", cmd_NyAfvejning));
		menu.addItem(new MenuItem("Min side", cmd_MinSide));
		menu.addItem(new MenuItem("Soeg", cmd_Soeg));
		menu.addItem(new MenuItem("Hjem", cmd_Hjem));
		menu.addItem(new MenuItem("Afslut", cmd_Afslut));

		hPanel.add(menu);
		menu.setHeight("200px");
	}

	Command cmd_NyAfvejning = new Command(){

		public void execute() {
//			xx.openNyAfvejning();
		}
	};

	Command cmd_MinSide = new Command(){

		public void execute() {

			OperatorDTO user2 = new OperatorDTO(32, "Essal Mohl Lennise", "EML", 1990924321L, "cbA4321", 0);

			parent.setContentPanel(new ViewProfile("Se Profil", user2));
		}
	};
	Command cmd_Soeg = new Command(){

		public void execute() {
					
		}
	};
	Command cmd_Hjem = new Command(){

		public void execute() {
//			xx.openHjemSide();
		}
	};
	Command cmd_Afslut = new Command(){

		public void execute() {
//			xx.openAfslutSide();
		}
	};
}