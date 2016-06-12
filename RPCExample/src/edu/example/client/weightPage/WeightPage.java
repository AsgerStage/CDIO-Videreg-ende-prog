package edu.example.client.weightPage;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import edu.example.client.service.RPCServiceClientImpl;


public class WeightPage extends Composite 
{
	VerticalPanel vPanel = new VerticalPanel();
	private RPCServiceClientImpl serverComm;
	List<String> test = new ArrayList<String>();
	Label LabelWeightDisplay;
	TextBox LabelTextDisplay;
	
	public WeightPage(RPCServiceClientImpl serverComm) {
		
		
		this.serverComm = serverComm;
		initWidget(vPanel);
		
		init();
	}

	public void init() {
		
		LabelWeightDisplay = new Label();
		LabelTextDisplay = new TextBox();
		LabelWeightDisplay.setText("0.0000 KG");
		LabelTextDisplay.setText("Weight Text");
		LabelWeightDisplay.addStyleName("WeightDisplay");
		LabelTextDisplay.addStyleName("TextDisplay");
		vPanel.add(LabelWeightDisplay);
		vPanel.add(LabelTextDisplay);
		
		
		

		Grid grid = new Grid(4, 3);
		Button bt0 = new Button("0");
		Button bt1 = new Button("1");
		Button bt2 = new Button("2");
		Button bt3 = new Button("3");
		Button bt4 = new Button("4");
		Button bt5 = new Button("5");
		Button bt6 = new Button("6");
		Button bt7 = new Button("7");
		Button bt8 = new Button("8");
		Button bt9 = new Button("9");
		Button btClear = new Button("Clear");
		Button btEnter = new Button("Enter");
		grid.setWidget(0, 0, bt7);
		grid.setWidget(0, 1, bt8);
		grid.setWidget(0, 2, bt9);
		grid.setWidget(1, 0, bt4);
		grid.setWidget(1, 1, bt5);
		grid.setWidget(1, 2, bt6);
		grid.setWidget(2, 0, bt1);
		grid.setWidget(2, 1, bt2);
		grid.setWidget(2, 2, bt3);
		grid.setWidget(3, 0, btClear);
		grid.setWidget(3, 1, bt0);
		grid.setWidget(3, 2, btEnter);
		vPanel.add(grid);
		btEnter.addClickHandler(new Button0ClickHandler());
		
	}	
	private class Button0ClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {	
			LabelWeightDisplay.setText("SENDER1");
			test.add("");
			LabelWeightDisplay.setText("SENDER2");
			serverComm.getData(LabelTextDisplay.getText(), test);
			LabelWeightDisplay.setText("SENDT");
		}
	
}
	
	public void displayData(String input){
		LabelWeightDisplay.setText(input);
		
	}
}