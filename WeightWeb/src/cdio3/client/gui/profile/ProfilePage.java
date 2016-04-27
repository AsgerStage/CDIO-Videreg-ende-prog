package cdio3.client.gui.profile;
import com.google.gwt.user.client.ui.*;

public abstract class ProfilePage extends Composite implements ProfilePanel 
{
	protected final VerticalPanel mainPanel;
	protected final Label pageTitle;
	protected final VerticalPanel contentPanel;
	private final HorizontalPanel buttonContainerPanel;
	protected final HorizontalPanel buttonPanel;
	
	public ProfilePage(String title) {		
		mainPanel = new VerticalPanel();
		initWidget(this.mainPanel);
		
		pageTitle = new Label(title);
		contentPanel = new VerticalPanel();
		buttonContainerPanel = new HorizontalPanel();
		buttonPanel = new HorizontalPanel();
		
		ini();
		
		mainPanel.add(pageTitle);
		mainPanel.add(contentPanel);
		buttonContainerPanel.add(buttonPanel);
		mainPanel.add(buttonContainerPanel);
	}
	
	private void ini() {
		mainPanel.setSize("100%", "100%");

		pageTitle.addStyleName("h1");
		
		contentPanel.addStyleName("paddedVerticalPanel");
		
		buttonContainerPanel.setWidth("100%");
		buttonContainerPanel.setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
		
		buttonPanel.addStyleName("paddedVerticalPanel");
	}
}
