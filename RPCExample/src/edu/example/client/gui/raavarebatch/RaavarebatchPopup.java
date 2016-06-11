package edu.example.client.gui.raavarebatch;

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

import edu.example.client.models.RaavarebatchDTO;

public class RaavarebatchPopup extends DialogBox 
{	
	private TextBox idBox = new TextBox();
	private TextBox raavareIDBox = new TextBox();
	private TextBox meangdeBox = new TextBox();
	
	private Button cancel = new Button("Anuller");
	private Button execute = new Button();
	
	private boolean isCreate = false;
	
	protected RaavarebatchPopup(RaavarebatchDTO raavarebatch) {
		super();
		VerticalPanel mainPanel = new VerticalPanel();
		
		HTML title = new HTML();
		
		if(raavarebatch == null) {
			isCreate = true;
			
			this.setTitle("Opret Raavarebatch");
			this.setText("Opret Raavarebatch");
			
			title.setHTML("Opret R&aring;varebatch");
			
			idBox.addKeyPressHandler(new IntegerValidator());
			
			execute.setText("Opret");
		}
		else {
			this.setTitle("Rediger Raavarebatch");
			this.setText("Rediger Raavarebatch");
			
			title.setHTML("Rediger R&aring;varebatch");
			idBox.setText("" + raavarebatch.getRbID());
			idBox.setEnabled(false);
			raavareIDBox.setText("" + raavarebatch.getRaavare().getRaavareID());
			meangdeBox.setText("" + raavarebatch.getMaengde());
			execute.setText("Gem");
		}
		
		raavareIDBox.addKeyPressHandler(new IntegerValidator());			
		meangdeBox.addKeyPressHandler(new KeyPressHandler() {				
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(!(Character.isDigit(event.getCharCode()) || event.getUnicodeCharCode() == 46))
					idBox.cancelKey();
			}
		});
		
		HTML labelID = new HTML("R&aring;varebatch ID");
		HTML labelRaavareID = new HTML("R&aring;vare ID");
		HTML labelMaengde = new HTML("M&aelig;ngde");
		
		FlexTable flxTable = new FlexTable();
        flxTable.setWidget(0, 0, labelID);
        flxTable.setWidget(0, 1, idBox);
        flxTable.setWidget(1, 0, labelRaavareID);
        flxTable.setWidget(1, 1, raavareIDBox);
        flxTable.setWidget(2, 0, labelMaengde);
        flxTable.setWidget(2, 1, meangdeBox);
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(10);
        buttonPanel.add(execute);
        buttonPanel.add(cancel);
        
        mainPanel.add(title);
        mainPanel.add(flxTable);
        mainPanel.add(buttonPanel);
        
        this.setWidget(mainPanel);
	}

	protected int getRaavarebatchID() {
		return Integer.parseInt(idBox.getText());
	}

	protected int getRaavareID() {
		return Integer.parseInt(raavareIDBox.getText());
	}

	protected double getMaengde() {
		return Double.parseDouble(meangdeBox.getText());
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
			if(!Character.isDigit(event.getCharCode()))
				idBox.cancelKey();
		}
	};
}