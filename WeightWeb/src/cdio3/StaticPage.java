package cdio3;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

public class StaticPage implements EntryPoint {

	public void onModuleLoad() {

		StaticPage2 page = new StaticPage2();

		HorizontalPanel hPanel= new HorizontalPanel();
		hPanel.setBorderWidth(1);

		Image img = new Image("Billeder/B.png"); // det er muligt at klikke på billedet/banner,
		//hvor meningen er at man skal henvises til hjem skærmen


		img.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				xx.openHome();				
			}
		}
				);

		hPanel.add(img);

		RootPanel.get().add(hPanel);
		RootPanel.get().add(page);
	}
}
