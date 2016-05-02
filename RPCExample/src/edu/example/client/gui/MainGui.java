package edu.example.client.gui;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.service.ExampleServiceClientImpl;

public class MainGui extends Composite 
{
	private VerticalPanel vPanel = new VerticalPanel();
	private TextBox txtBox;
	private Label lbl;
	
	private ExampleServiceClientImpl serverComm;
	
	public MainGui(ExampleServiceClientImpl serverComm) {
		initWidget(this.vPanel);
		this.serverComm = serverComm;
		
		this.txtBox = new TextBox();
		this.vPanel.add(txtBox);
		
		Button btn = new Button("Say Hello");
		btn.addClickHandler(new ButtonHandler());
		this.vPanel.add(btn);
		
		this.lbl = new Label("Result");
		this.vPanel.add(lbl);
	}
	
	public void updateLabel(String text) {
		lbl.setText(text);
	}
	
	private class ButtonHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			serverComm.sayHello(txtBox.getText());
		}
	}
}