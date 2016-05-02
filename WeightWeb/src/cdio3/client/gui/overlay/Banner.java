package cdio3.client.gui.overlay;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.client.service.ServiceClientImpl;


public class Banner extends Composite { //implements EntryPoint {
	
	//--------- LAVET OM TIL COMPOSITE ------------
	private VerticalPanel vPanel= new VerticalPanel(); //Hovedpanelet som indeholder hPanel1 og hPanel2
	HorizontalPanel hPanel4;
	private ServiceClientImpl serverComm;
	
	public Banner(ServiceClientImpl serverComm) {
		initWidget(this.vPanel);
		this.serverComm = serverComm;
		onModuleLoad();
		
	}
	//---------------------------------------------

	public void onModuleLoad() {

		MenuWidget MW = new MenuWidget(this);

		
		vPanel.setBorderWidth(1);

		HorizontalPanel hPanel1= new HorizontalPanel(); // Panelet som indeholder billedet
		hPanel1.setBorderWidth(1);
		
		HorizontalPanel hPanel2= new HorizontalPanel(); // Skal indeholde to mindre paneler et med menu og et med et tomt vindue
		hPanel2.setBorderWidth(1);
		hPanel2.setWidth("100%");

		hPanel4 = new HorizontalPanel(); // skal indeholde tomt vindue
		hPanel4.setWidth("100%");
		
		
		
		Image img = new Image("Billeder/B.png");  

		img.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				xx.openHjemSide();				
			}
		}
				);
		

		vPanel.add(hPanel1);
		hPanel1.add(img);
		vPanel.add(hPanel2);
		hPanel2.add(MW);
		hPanel2.add(hPanel4);

//		RootPanel.get().add(hPanel);
//		RootPanel.get().add(page);
	}
	
	public void setContentPanel(Composite Content){
		hPanel4.clear();
		hPanel4.add(Content);
	}
}
