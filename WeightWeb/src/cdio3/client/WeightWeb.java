package cdio3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WeightWeb implements EntryPoint {
	Label myLbl;
	Grid opTable;
	Button delButton;
	public void addOp(int ID, String name, String ini, int Rank){
		opTable.getRowCount();
		opTable.resize(opTable.getRowCount()+1, 5);
		opTable.setText(opTable.getRowCount()+1, 0, ""+ID);
		opTable.setText(opTable.getRowCount()+1, 1, name);
		opTable.setText(opTable.getRowCount()+1, 2, ini);
		opTable.setText(opTable.getRowCount()+1, 3, ""+Rank);
		opTable.setWidget(opTable.getRowCount()+1, 4, delButton);
	}
	/**
	 * This is the entry point method.
	 */
	
	
	public void onModuleLoad() {
		VerticalPanel vPanel=new VerticalPanel();
		HorizontalPanel hPanel=new HorizontalPanel();
		
		myLbl =new Label("Operatoer");
		 myLbl.getElement().setPropertyString("id", "opLabel");
		 delButton =new Button("Delete");
	
		 
		hPanel.add(myLbl);
		vPanel.add(hPanel);
		 TextBox normalText = new TextBox();
		 hPanel.add(normalText);
		 normalText.setText("Dette er et soegefelt");
		
		 opTable =new Grid(1,5);
		 opTable.setText(0, 0, "ID");
		 opTable.setText(0, 1, "Navn");
		 opTable.setText(0, 2, "Ini");
		 opTable.setText(0, 3, "Rank");
		 opTable.setText(0, 4, "Slet og rediger");
		 opTable.resize(2, 5);
		 opTable.setText(1, 0, "1");
		 opTable.setText(1, 1, "Asger");
		 opTable.setText(1, 2, "AS");
		 opTable.setText(1, 3, "1");
		 opTable.setWidget(1, 4, delButton);
		 
		 opTable.setBorderWidth(1);
		 vPanel.add(opTable);
		 opTable.setCellPadding(10);
		 opTable.getRowCount();
		 //addOp(2,"Test","T",2);
		RootPanel.get().add(vPanel);
		
		
	}
}
