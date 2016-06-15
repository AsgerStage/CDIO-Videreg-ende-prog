package edu.example.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.gui.login.Login;
import edu.example.client.service.RPCServiceClientImpl;

public class Banner extends Composite {

	private VerticalPanel mainPanel = new VerticalPanel(); //Hovedpanelet
	private HorizontalPanel contentPanel;
	private RPCServiceClientImpl serverComm;
	private MenuWidget menuWidget;

	public Banner(RPCServiceClientImpl serverComm) {
		initWidget(this.mainPanel);
		mainPanel.setSize("100%", "100%");

		this.serverComm = serverComm;

		init();
	}

	public void init() {
		menuWidget = new MenuWidget(this, serverComm);

		mainPanel.setBorderWidth(1);

		HorizontalPanel bannerPanel = new HorizontalPanel(); // Panelet som indeholder billedet
		bannerPanel.setWidth("100%");

		HorizontalPanel contentHolderPanel= new HorizontalPanel(); // Skal indeholde to mindre paneler et med menu og et med et tomt vindue
		contentHolderPanel.setBorderWidth(1);

		contentPanel = new HorizontalPanel(); // skal indeholde tomt vindue
		contentPanel.setSize("100%", "100%");

		Image img = new Image("Billeder/B.png");  

		bannerPanel.add(img);
		mainPanel.add(bannerPanel);

		contentHolderPanel.add(menuWidget);
		contentHolderPanel.add(contentPanel);
		contentHolderPanel.setCellWidth(menuWidget, "11%");
		mainPanel.add(contentHolderPanel);
		
		menuWidget.gotoPanel(new Login(menuWidget, serverComm));
	}

	public Object getCurrentPanel() {
		return menuWidget.getCurrentPanel();
	}

	public void setContentPanel(Composite Content){
		contentPanel.clear();
		contentPanel.add(Content);
	}
}