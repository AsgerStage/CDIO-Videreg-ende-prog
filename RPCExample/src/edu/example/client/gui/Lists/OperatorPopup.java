/**
 * 
 */
package edu.example.client.gui.Lists;
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

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.ReceptDTO;


/**
 * @author Asger
 *
 * 10/06/2016
 */
public class OperatorPopup extends DialogBox 
{	
	private TextBox idBox = new TextBox();
	private TextBox nameBox = new TextBox();
	private TextBox cprBox = new TextBox();
	private TextBox iniBox = new TextBox();
	private TextBox rankBox = new TextBox();
	private TextBox passwordBox = new TextBox();
	
	private Button cancel = new Button("Anuller");
	private Button execute = new Button();
	
	private boolean isCreate = false;
	
	public OperatorPopup(OperatorDTO operator) {
		super();
		VerticalPanel mainPanel = new VerticalPanel();
		
		HTML title = new HTML();
		
		if(operator == null) {
			isCreate = true;
			
			this.setTitle("Opret Operator");
			this.setText("Opret Operator");
			
			title.setHTML("Opret Operator");
			
			idBox.addKeyPressHandler(new KeyPressHandler() {
				@Override
				public void onKeyPress(KeyPressEvent event) {
					if(!Character.isDigit(event.getCharCode()))
						idBox.cancelKey();
				}
			});
			
			execute.setText("Opret");
		}
		else {
			this.setTitle("Rediger Operator");
			this.setText("Rediger Operator");
			
			title.setHTML("Rediger Operator");
			idBox.setText("" + operator.getOprID());
			idBox.setEnabled(false);
			nameBox.setText(operator.getName());
			cprBox.setText(operator.getCpr());
			iniBox.setText(operator.getIni());
			rankBox.setText(""+operator.getRank());
			passwordBox.setText(operator.getPassword());
			execute.setText("Gem");
		}
		
		HTML labelID = new HTML("Operator ID");
		HTML labelNavn = new HTML("Operator Navn");
		HTML labelCpr = new HTML("Operator CPR");
		HTML labelIni = new HTML("Operator initialier");
		HTML labelRank = new HTML("Operator rank");
		HTML labelPassword = new HTML("Operator password");
		
		FlexTable flxTable = new FlexTable();
        flxTable.setWidget(0, 0, labelID);
        flxTable.setWidget(0, 1, idBox);
        flxTable.setWidget(1, 0, labelNavn);
        flxTable.setWidget(1, 1, nameBox);
        flxTable.setWidget(2, 0, labelCpr);
        flxTable.setWidget(2, 1, cprBox);
        flxTable.setWidget(3, 0, labelIni);
        flxTable.setWidget(3, 1, iniBox);
        flxTable.setWidget(4, 0, labelRank);
        flxTable.setWidget(4, 1, rankBox);
        flxTable.setWidget(5, 0, labelPassword);
        flxTable.setWidget(5, 1, passwordBox);

		
		HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(10);
        buttonPanel.add(execute);
        buttonPanel.add(cancel);
        
        mainPanel.add(title);
        mainPanel.add(flxTable);
        mainPanel.add(buttonPanel);
        
        this.setWidget(mainPanel);
	}

	public int getOperatorID() {
		return Integer.parseInt(idBox.getText());
	}
	
	protected String getOperatorName() {
		return nameBox.getText();
	}
	
	protected String getOperatorCpr() {
		return cprBox.getText();
	}
	
	protected String getOperatorIni() {
		return iniBox.getText();
	}
	
	protected int getOperatorRank() {
		return Integer.parseInt(rankBox.getText());
	}
	
	protected String getOperatorPassword() {
		return passwordBox.getText();
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
}