package cdio3.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class StaticPage extends Composite { //implements EntryPoint {
	
	//--------- LAVET OM TIL COMPOSITE ------------
	private HorizontalPanel hPanel= new HorizontalPanel();
	
	public StaticPage() {
		initWidget(this.hPanel);
		onModuleLoad();
	}
	//---------------------------------------------

	public void onModuleLoad() {

//		StaticPage2 page = new StaticPage2();

		
		hPanel.setBorderWidth(1);

		Image img = new Image("Billeder/B.png"); // det er muligt at klikke på billedet/banner,
		//hvor meningen er at man skal henvises til hjem skærmen


		img.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				xx.openHome();				
			}
		}
				);

		hPanel.add(img);

//		RootPanel.get().add(hPanel);
//		RootPanel.get().add(page);
	}
}
