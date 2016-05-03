package edu.example.client.gui.operatoerList;

import java.sql.SQLException;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.service.ExampleServiceClientImpl;




/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OperatoerList extends Composite { //implements EntryPoint {
	
	
	//--------- LAVET OM TIL COMPOSITE ------------
	private VerticalPanel vPanel=new VerticalPanel();
	private ExampleServiceClientImpl serverComm;
	public OperatoerList(ExampleServiceClientImpl serverComm)  {
		initWidget(this.vPanel);
		this.serverComm=serverComm;
		onModuleLoad();
	}
	//---------------------------------------------
	
	Label myLbl =new Label("Operatoer");
	Grid opTable=new Grid(1,5);
	Button delButton =new Button("Delete");
	
	public void addOp(int ID, String name, String ini, int Rank) {
		opTable.getRowCount();
		opTable.resize(opTable.getRowCount()+1, 5);
		opTable.setText(opTable.getRowCount()-1, 0, ""+ID);
		opTable.setText(opTable.getRowCount()-1, 1, name);
		opTable.setText(opTable.getRowCount()-1, 2, ini);
		opTable.setText(opTable.getRowCount()-1, 3, ""+Rank);
		opTable.setWidget(opTable.getRowCount()-1, 4, new Button("Delete"));
	}
	/**
	 * This is the entry point method.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws DALException 
	 */
	
	
	public void onModuleLoad() {
		
		HorizontalPanel hPanel=new HorizontalPanel();
		//serverComm.getOpList();
		
		 myLbl.getElement().setPropertyString("id", "opLabel");
		 
	
		 
		hPanel.add(myLbl);
		vPanel.add(hPanel);
		 TextBox normalText = new TextBox();
		 hPanel.add(normalText);
		 normalText.setText("Dette er et soegefelt");
		
		 opTable.setText(0, 0, "ID");
		 opTable.setText(0, 1, "Navn");
		 opTable.setText(0, 2, "Ini");
		 opTable.setText(0, 3, "Rank");
		 opTable.setText(0, 4, "Slet og rediger");
		 
		 opTable.setBorderWidth(1);
		 vPanel.add(opTable);
		 opTable.setCellPadding(10);
		 opTable.getRowCount();
		 addOp(2,"Test","T1",0);
		 addOp(3,"Test2","T2",1);
		 addOp(4,"Test3","T3",0);
		 addOp(5,"Test4","T4",0);
		 
//		RootPanel.get().add(vPanel);
		
		
	}
}
