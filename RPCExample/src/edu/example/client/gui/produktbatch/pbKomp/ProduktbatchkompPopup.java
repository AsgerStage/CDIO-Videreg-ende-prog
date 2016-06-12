package edu.example.client.gui.produktbatch.pbKomp;

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

import edu.example.client.models.ProduktbatchkompDTO;

public class ProduktbatchkompPopup extends DialogBox
{	
	private TextBox pbIDBox = new TextBox();
	private TextBox rbIDBox = new TextBox();
	private TextBox taraBox = new TextBox();
	private TextBox nettoBox = new TextBox();
	private TextBox oprIDBox = new TextBox();
	
	private Button cancel = new Button("Anuller");
	private Button execute = new Button();
	
	private boolean isCreate = false;
	
	protected ProduktbatchkompPopup(ProduktbatchkompDTO pbkomp) {
		super();
		VerticalPanel mainPanel = new VerticalPanel();
		
		HTML title = new HTML();
		
		if(pbkomp == null) {
			isCreate = true;
			
			this.setTitle("Opret Produktbatch Komponent");
			this.setText("Opret Produktbatch Komponent");
			
			title.setHTML("Opret Produktbatch Komponent");
						
			pbIDBox.addKeyPressHandler(new IntegerValidator());
			rbIDBox.addKeyPressHandler(new IntegerValidator());
			
			execute.setText("Opret");
		}
		else {
			this.setTitle("Rediger Produktbatch Komponent");
			this.setText("Rediger Produktbatch Komponent");
			
			title.setHTML("Rediger Produktbatch Komponent");
			pbIDBox.setText("" + pbkomp.getPbID());
			pbIDBox.setEnabled(false);
			rbIDBox.setText("" + pbkomp.getRbID());
			rbIDBox.setEnabled(false);
			taraBox.setText("" + pbkomp.getTara());
			nettoBox.setText("" + pbkomp.getNetto());
			oprIDBox.setText("" + pbkomp.getOprID());
			execute.setText("Gem");
		}
		
		taraBox.addKeyPressHandler(new DoubleValidator());	
		nettoBox.addKeyPressHandler(new DoubleValidator());			
		oprIDBox.addKeyPressHandler(new IntegerValidator());
		
		HTML labelPBID = new HTML("Produktbatch ID");
		HTML labelRBID = new HTML("R&aring;varebatch ID");
		HTML labelTara = new HTML("Tara");
		HTML labelNetto = new HTML("Netto");
		HTML labelOprID = new HTML("Operat&oslash;r ID");
		
		FlexTable flxTable = new FlexTable();
        flxTable.setWidget(0, 0, labelPBID);
        flxTable.setWidget(0, 1, pbIDBox);
        flxTable.setWidget(1, 0, labelRBID);
        flxTable.setWidget(1, 1, rbIDBox);
        flxTable.setWidget(2, 0, labelTara);
        flxTable.setWidget(2, 1, taraBox);
        flxTable.setWidget(3, 0, labelNetto);
        flxTable.setWidget(3, 1, nettoBox);
        flxTable.setWidget(4, 0, labelOprID);
        flxTable.setWidget(4, 1, oprIDBox);
		
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
		return Integer.parseInt(pbIDBox.getText());
	}

	protected int getRaavarebatchID() {
		return Integer.parseInt(rbIDBox.getText());
	}

	protected double getTara() {
		return Double.parseDouble(taraBox.getText());
	}

	protected double getNetto() {
		return Double.parseDouble(nettoBox.getText());
	}

	protected int getOperatoerID() {
		return Integer.parseInt(oprIDBox.getText());
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
				pbIDBox.cancelKey();
				rbIDBox.cancelKey();
				oprIDBox.cancelKey();
			}
		}
	};
	
	private class DoubleValidator implements KeyPressHandler {
		@Override
		public void onKeyPress(KeyPressEvent event) {
			if(!(Character.isDigit(event.getCharCode()) || event.getUnicodeCharCode() == 46)) {
				taraBox.cancelKey();
				nettoBox.cancelKey();
			}
		}
	};
}