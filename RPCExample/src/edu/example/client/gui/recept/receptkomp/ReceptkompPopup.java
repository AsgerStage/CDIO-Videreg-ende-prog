package edu.example.client.gui.recept.receptkomp;

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

import edu.example.client.models.ReceptkompDTO;

public class ReceptkompPopup extends DialogBox
{	
	private TextBox receptIDBox = new TextBox();
	private TextBox raavareIDBox = new TextBox();
	private TextBox nomNettoBox = new TextBox();
	private TextBox toleranceBox = new TextBox();
	
	private Button cancel = new Button("Anuller");
	private Button execute = new Button();
	
	private boolean isCreate = false;
	
	protected ReceptkompPopup(ReceptkompDTO receptkomp) {
		super();
		VerticalPanel mainPanel = new VerticalPanel();
		
		HTML title = new HTML();
		
		if(receptkomp == null) {
			isCreate = true;
			
			this.setTitle("Opret Recept Komponent");
			this.setText("Opret Recept Komponent");
			
			title.setHTML("Opret Recept Komponent");
						
			receptIDBox.addKeyPressHandler(new IntegerValidator());
			raavareIDBox.addKeyPressHandler(new IntegerValidator());
			
			execute.setText("Opret");
		}
		else {
			this.setTitle("Rediger Recept Komponent");
			this.setText("Rediger Recept Komponent");
			
			title.setHTML("Rediger Recept Komponent");
			receptIDBox.setText("" + receptkomp.getReceptID());
			receptIDBox.setEnabled(false);
			raavareIDBox.setText("" + receptkomp.getRaavareID());
			raavareIDBox.setEnabled(false);
			nomNettoBox.setText("" + receptkomp.getNomNetto());
			toleranceBox.setText("" + receptkomp.getTolerance());
			execute.setText("Gem");
		}
		
		nomNettoBox.addKeyPressHandler(new DoubleValidator());	
		toleranceBox.addKeyPressHandler(new DoubleValidator());
		
		HTML labelReceptID = new HTML("Recept ID");
		HTML labelRaavareID = new HTML("R&aring;vare ID");
		HTML labelNomNetto = new HTML("Nominelle V&aelig;gt");
		HTML labelTolerance = new HTML("Tolerance");
		
		FlexTable flxTable = new FlexTable();
        flxTable.setWidget(0, 0, labelReceptID);
        flxTable.setWidget(0, 1, receptIDBox);
        flxTable.setWidget(1, 0, labelRaavareID);
        flxTable.setWidget(1, 1, raavareIDBox);
        flxTable.setWidget(2, 0, labelNomNetto);
        flxTable.setWidget(2, 1, nomNettoBox);
        flxTable.setWidget(3, 0, labelTolerance);
        flxTable.setWidget(3, 1, toleranceBox);
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(10);
        buttonPanel.add(execute);
        buttonPanel.add(cancel);
        
        mainPanel.add(title);
        mainPanel.add(flxTable);
        mainPanel.add(buttonPanel);
        
        this.setWidget(mainPanel);
	}
	
	protected int getReceptID() {
		return Integer.parseInt(receptIDBox.getText());
	}

	protected int getRaavareID() {
		return Integer.parseInt(raavareIDBox.getText());
	}

	protected double getNomNetto() {
		return Double.parseDouble(nomNettoBox.getText());
	}

	protected double getTolerance() {
		return Double.parseDouble(toleranceBox.getText());
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
				receptIDBox.cancelKey();
				raavareIDBox.cancelKey();
			}
		}
	};
	
	private class DoubleValidator implements KeyPressHandler {
		@Override
		public void onKeyPress(KeyPressEvent event) {
			if(!(Character.isDigit(event.getCharCode()) || event.getUnicodeCharCode() == 46)) {
				nomNettoBox.cancelKey();
				toleranceBox.cancelKey();
			}
		}
	};
}