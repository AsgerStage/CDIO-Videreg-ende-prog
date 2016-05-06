package edu.example.client.gui.profile;
import com.google.gwt.user.client.ui.*;

public class InfoBox extends HorizontalPanel {
	private final Label lblTitle = new Label();
	private Widget widget;
	
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
		this.widget.setWidth("100%");
	}
	
	public Widget getWidget() {
		return widget;
	}
}