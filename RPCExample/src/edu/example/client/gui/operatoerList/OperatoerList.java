package edu.example.client.gui.operatoerList;

import java.sql.SQLException;
import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.models.OperatorDTO;
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
	static Grid opTable=new Grid(1,7);
	Button delButton =new Button("Delete");
	
	
	
	public static void addOp(OperatorDTO operator) {
		opTable.getRowCount();
		opTable.resize(opTable.getRowCount()+1, 7);
		opTable.setText(opTable.getRowCount()-1, 0, ""+operator.getOprID());
		opTable.setText(opTable.getRowCount()-1, 1, operator.getName());
		opTable.setText(opTable.getRowCount()-1, 2, operator.getIni());
		opTable.setText(opTable.getRowCount()-1, 3, ""+operator.getRank());
		opTable.setText(opTable.getRowCount()-1, 4, ""+operator.getCpr());
		opTable.setText(opTable.getRowCount()-1, 5, ""+operator.getPassword());
		opTable.setWidget(opTable.getRowCount()-1, 6, new Button("Delete"));
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
		serverComm.getOpList();
		
		 myLbl.getElement().setPropertyString("id", "opLabel");
		 
		 
		 
		hPanel.add(myLbl);
		vPanel.add(hPanel);
		 TextBox normalText = new TextBox();
		 hPanel.add(normalText);
		 normalText.setText("Dette er et soegefelt");
		 Button SoegBtn =new Button("Soeg");
		 hPanel.add(SoegBtn);
		
		 opTable.setText(0, 0, "ID");
		 opTable.setText(0, 1, "Navn");
		 opTable.setText(0, 2, "Ini");
		 opTable.setText(0, 3, "Rank");
		 opTable.setText(0, 4, "CPR");
		 opTable.setText(0, 5, "Password");
		 opTable.setText(0, 6, "Slet og rediger");
		 
		 opTable.setBorderWidth(1);
		 vPanel.add(opTable);
		 opTable.setCellPadding(10);
		 opTable.getRowCount();
		 
		 
//		RootPanel.get().add(vPanel);
		
		
	}
	/**
	 * @param result
	 */
	public static void getOperatoerList(List<OperatorDTO> result) {
		for (int i=0;i<result.size();i++){
			addOp(result.get(i));
			
		}
		
	}
}
