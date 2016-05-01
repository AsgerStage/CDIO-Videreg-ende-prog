package cdio3.client.gui.login;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Startskaerm extends Composite {

	
	private VerticalPanel vPanel = new VerticalPanel();
	private Label lbl1;
	
	public Startskaerm() {
		initWidget(vPanel);
		onModuleLoad();
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		
		
		lbl1 = new Label("Brugernavn");
		vPanel.add(lbl1);
		

		TextArea t1 = new TextArea();
		vPanel.add(t1);
		t1.setVisibleLines(5);
		t1.setEnabled(false);
		t1.setText("Velkommen\nHer er dine nyheder");
		t1.addStyleName("loginTextarea");
		

	}
}
