package cdio3.client.gui.profile;
import com.google.gwt.user.client.ui.*;

public class InfoBox extends HorizontalPanel {
	private final Label lblTitle = new Label();
	private Widget widget;
	
//	public InfoBox() {
//		addStyleName("infoBox_panel");
//		
//		lblTitle.addStyleName("infoBox_label");
//
//		this.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
//		
//		widget = new Label();
//		
//		add(lblTitle);
//		add(widget);
//	}
	
	public InfoBox(String title, Widget widget) {
		addStyleName("infoBox_panel");
		setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
		setTitle(title);
		
		lblTitle.addStyleName("infoBox_label");
		setWidget(widget);
		
		add(lblTitle);
		add(widget);
	}
	
	public void setTitle(String title) {
		this.lblTitle.setText(title);
	}
	
	public String getTitle() {
		return lblTitle.getText();
	}
	
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	
	public Widget getWidget() {
		return widget;
	}
}