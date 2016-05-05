package edu.example.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.service.ExampleServiceClientImpl;


public class Banner extends Composite { //implements EntryPoint {
	
	//--------- LAVET OM TIL COMPOSITE ------------
	private VerticalPanel vPanel = new VerticalPanel(); //Hovedpanelet som indeholder hPanel1 og hPanel2
	private HorizontalPanel contentPanel;
	private ExampleServiceClientImpl serverComm;
	private MenuWidget menuWidget;
	
	public Banner(ExampleServiceClientImpl serverComm) {
		initWidget(this.vPanel);
		vPanel.setSize("100%", "100%");
		
		this.serverComm = serverComm;
		
		init();
	}

	public void init() {

		menuWidget = new MenuWidget(this, serverComm);
		menuWidget.setWidth("15%");

		vPanel.setBorderWidth(1);

		HorizontalPanel bannerPanel = new HorizontalPanel(); // Panelet som indeholder billedet
		bannerPanel.setWidth("100%");
		bannerPanel.setBorderWidth(1);
		
		HorizontalPanel contentHolderPanel= new HorizontalPanel(); // Skal indeholde to mindre paneler et med menu og et med et tomt vindue
		contentHolderPanel.setBorderWidth(1);
//		contentHolderPanel.setWidth("100%");

		contentPanel = new HorizontalPanel(); // skal indeholde tomt vindue
		contentPanel.setSize("100%", "100%");
		
		Image img = new Image("Billeder/B.png");  

		img.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				xx.openHjemSide();				
			}
		});

		bannerPanel.add(img);
		vPanel.add(bannerPanel);
		
		contentHolderPanel.add(menuWidget);
		contentHolderPanel.add(contentPanel);
		contentHolderPanel.setCellWidth(menuWidget, "10%");
		vPanel.add(contentHolderPanel);
	}
	
	public Object getCurrentPanel() {
		return menuWidget.getCurrentPanel();
	}
	
	public void setContentPanel(Composite Content){
		contentPanel.clear();
		contentPanel.add(Content);
	}
}
