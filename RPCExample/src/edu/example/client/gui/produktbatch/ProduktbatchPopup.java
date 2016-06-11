package edu.example.client.gui.produktbatch;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.models.ProduktbatchDTO;

public class ProduktbatchPopup extends DialogBox 
{	
	private TextBox idBox = new TextBox();
	private TextBox receptIDBox = new TextBox();
	private TextBox statusBox = new TextBox();
	
	private Button cancel = new Button("Anuller");
	private Button execute = new Button();
	
	private boolean isCreate = false;
	
	protected ProduktbatchPopup(ProduktbatchDTO produktbatch) {
		super();
		VerticalPanel mainPanel = new VerticalPanel();
		
		HTML title = new HTML();
		
		if(produktbatch == null) {
			isCreate = true;
			
			this.setTitle("Opret Produktbatch");
			this.setText("Opret Produktbatch");
			
			title.setHTML("Opret Produktbatch");
						
			idBox.addKeyPressHandler(new IntegerValidator());
			
			execute.setText("Opret");
		}
		else {
			this.setTitle("Rediger Produktbatch");
			this.setText("Rediger Produktbatch");
			
			title.setHTML("Rediger Produktbatch");
			idBox.setText("" + produktbatch.getPbID());
			idBox.setEnabled(false);
			receptIDBox.setText("" + produktbatch.getReceptID());
			statusBox.setText("" + produktbatch.getStatus());
			execute.setText("Gem");
		}
		
		receptIDBox.addKeyPressHandler(new IntegerValidator());			
		statusBox.addKeyPressHandler(new IntegerValidator());
		
		HTML labelID = new HTML("Produktbatch ID");
		HTML labelReceptID = new HTML("Recept ID");
		HTML labelStatus = new HTML("Status");
		
		FlexTable flxTable = new FlexTable();
        flxTable.setWidget(0, 0, labelID);
        flxTable.setWidget(0, 1, idBox);
        flxTable.setWidget(1, 0, labelReceptID);
        flxTable.setWidget(1, 1, receptIDBox);
        flxTable.setWidget(2, 0, labelStatus);
        flxTable.setWidget(2, 1, statusBox);
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(10);
        buttonPanel.add(execute);
        buttonPanel.add(cancel);
        
        mainPanel.add(title);
        mainPanel.add(flxTable);
        mainPanel.add(buttonPanel);
        
        this.setWidget(mainPanel);
	}

	protected int getProduktbatchID() {
		return Integer.parseInt(idBox.getText());
	}

	protected int getReceptID() {
		return Integer.parseInt(receptIDBox.getText());
	}

	protected int getStatus() {
		return Integer.parseInt(statusBox.getText());
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
	
	private class IntegerValidator implements KeyPressHandler {
		@Override
		public void onKeyPress(KeyPressEvent event) {
			if(!Character.isDigit(event.getCharCode())) {
					idBox.cancelKey();
					receptIDBox.cancelKey();
					statusBox.cancelKey();
			}
		}
	};
}