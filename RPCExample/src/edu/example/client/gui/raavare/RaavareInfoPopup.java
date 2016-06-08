package edu.example.client.gui.raavare;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.models.RaavareDTO;

public class RaavareInfoPopup extends DialogBox 
{	
	private TextBox nameBox = new TextBox();
	private TextBox leverandoerBox = new TextBox();
	
	private Button cancel = new Button("Anuller");
	private Button execute = new Button();
	
	private boolean isCreate = false;
	
	public RaavareInfoPopup(RaavareDTO raavare) {
		super();
		VerticalPanel mainPanel = new VerticalPanel();
		
		HTML title = new HTML();
		
		if(raavare == null) {
			isCreate = true;
			
			this.setTitle("Opret Raavare");
			this.setText("Opret Raavare");
			
			title.setHTML("Opret R&aring;vare");
			execute.setText("Opret");
		}
		else {
			this.setTitle("Rediger Raavare");
			this.setText("Rediger Raavare");
			
			title.setHTML("Rediger R&aring;vare");
			nameBox.setText(raavare.getRaavareNavn());
			leverandoerBox.setText(raavare.getLeverandoer());
			execute.setText("Gem");
		}
		
		HTML labelNavn = new HTML("R&aring;vare Navn");
		HTML labelLeverandoer = new HTML("Leverand&oslash;r");
		
		FlexTable flxTable = new FlexTable();
        flxTable.setWidget(0, 0, labelNavn);
        flxTable.setWidget(0, 1, nameBox);
        flxTable.setWidget(1, 0, labelLeverandoer);
        flxTable.setWidget(1, 1, leverandoerBox);
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(10);
        buttonPanel.add(execute);
        buttonPanel.add(cancel);
        
        mainPanel.add(title);
        mainPanel.add(flxTable);
        mainPanel.add(buttonPanel);
        
        this.setWidget(mainPanel);
	}
	
	protected String getRaavareName() {
		return nameBox.getText();
	}
	
	protected String getRaavareLeverandoer() {
		return leverandoerBox.getText();
	}
	
	protected boolean isCreate() {
		return isCreate;
	}
	
	protected void setExecuteClickHandler(ClickHandler clickHandler) {
        execute.addClickHandler(clickHandler);
	}
	
	protected void setCancelClickHandler(ClickHandler clickHandler) {
        cancel.addClickHandler(clickHandler);
	}

	public int getRaavareID() {
		// TODO Auto-generated method stub
		return 0;
	}
}