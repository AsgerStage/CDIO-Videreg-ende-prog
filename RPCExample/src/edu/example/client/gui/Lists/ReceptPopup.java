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

import edu.example.client.models.ReceptDTO;


/**
 * @author Asger
 *
 * 10/06/2016
 */
public class ReceptPopup extends DialogBox 
{	
	private TextBox idBox = new TextBox();
	private TextBox nameBox = new TextBox();
	
	private Button cancel = new Button("Anuller");
	private Button execute = new Button();
	
	private boolean isCreate = false;
	
	public ReceptPopup(ReceptDTO recept) {
		super();
		VerticalPanel mainPanel = new VerticalPanel();
		
		HTML title = new HTML();
		
		if(recept == null) {
			isCreate = true;
			
			this.setTitle("Opret Recept");
			this.setText("Opret Recept");
			
			title.setHTML("Opret Recept");
			
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
			this.setTitle("Rediger Recept");
			this.setText("Rediger Recept");
			
			title.setHTML("Rediger Recept");
			idBox.setText("" + recept.getReceptID());
			idBox.setEnabled(false);
			nameBox.setText(recept.getReceptNavn());
			execute.setText("Gem");
		}
		
		HTML labelID = new HTML("Recept ID");
		HTML labelNavn = new HTML("Recept Navn");
		
		FlexTable flxTable = new FlexTable();
        flxTable.setWidget(0, 0, labelID);
        flxTable.setWidget(0, 1, idBox);
        flxTable.setWidget(1, 0, labelNavn);
        flxTable.setWidget(1, 1, nameBox);

		
		HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(10);
        buttonPanel.add(execute);
        buttonPanel.add(cancel);
        
        mainPanel.add(title);
        mainPanel.add(flxTable);
        mainPanel.add(buttonPanel);
        
        this.setWidget(mainPanel);
	}

	public int getReceptID() {
		return Integer.parseInt(idBox.getText());
	}
	
	protected String getReceptName() {
		return nameBox.getText();
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