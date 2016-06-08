package edu.example.client.gui.operatoerList;

import java.sql.SQLException;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.exceptions.DALException;
import edu.example.client.exceptions.OpIdException;
import edu.example.client.exceptions.OpNameException;
import edu.example.client.exceptions.OpPasswordException;
import edu.example.client.gui.profile.EditProfile;
import edu.example.client.gui.profile.ProfilePage;
import edu.example.client.gui.profile.ViewProfile;
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
	static TextBox searchBox=new TextBox();
	 static Button editButton = new Button("Rediger");
	 
	 static List<OperatorDTO> currentDisp; //Indeholder den liste af personer der bliver displayet
	
	
	public static void addOp(OperatorDTO operator) {
		opTable.getRowCount();
		opTable.resize(opTable.getRowCount()+1, 7);
		opTable.setText(opTable.getRowCount()-1, 0, ""+operator.getOprID());
		opTable.setText(opTable.getRowCount()-1, 1, operator.getName());
		opTable.setText(opTable.getRowCount()-1, 2, operator.getIni());
		opTable.setText(opTable.getRowCount()-1, 3, ""+operator.getRank());
		opTable.setText(opTable.getRowCount()-1, 4, ""+operator.getCpr());
		opTable.setText(opTable.getRowCount()-1, 5, ""+operator.getPassword());
		opTable.setWidget(opTable.getRowCount()-1, 6,  editButton);
		
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
		 
		
			editButton.addClickHandler(new EditClickHandler(this));
		 
		hPanel.add(myLbl);
		vPanel.add(hPanel);
		 
		 hPanel.add(searchBox);
		 searchBox.setText("Dette er et soegefelt");
		 searchBox.addClickHandler(new SearchClickHandler());
		 Button SoegBtn =new Button("Soeg");
		 hPanel.add(SoegBtn);
		
		 opTable.setText(0, 0, "ID");
		 opTable.setText(0, 1, "Navn");
		 opTable.setText(0, 2, "Ini");
		 opTable.setText(0, 3, "Rank");
		 opTable.setText(0, 4, "CPR");
		 opTable.setText(0, 5, "Password");
		 opTable.setText(0, 6, "Rediger");
		 
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
		clear();
		if (searchBox.getText().equals("Dette er et soegefelt")|| searchBox.getText().equals("")){
		for (int i=0;i<result.size();i++){
			addOp(result.get(i));
		}
		currentDisp=result;
		}
		else {
			try{
				int searchBoxInt;
				for(int i=0;i<result.size();i++){
					searchBoxInt=Integer.parseInt(searchBox.getText());
					if(!(result.get(i).getOprID()==searchBoxInt)){
						result.remove(i);
						i=-1;
					}
				}
				
			}
			catch(Exception e){
			for (int i=0;i<result.size();i++)
			{
				if (!(result.get(i).getName().contains(searchBox.getText()) || result.get(i).getIni().contains(searchBox.getText()) || result.get(i).getCpr().contains(searchBox.getText()))){
					result.remove(i);
					i=-1;
				}				
			}
			}
			for (int j=0;j<result.size();j++){
				addOp(result.get(j));
			}	
			currentDisp=result;
		}
		
		
	}
	
	public static void clear(){
		opTable.resize(1, 7);
	}
	private class SearchClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			serverComm.getOpList();
		}
	}
	
	 public static class EditClickHandler implements ClickHandler 
	{
	
			private OperatoerList parent;
			OperatorDTO user;
			private EditClickHandler(OperatoerList parent) {
				this.parent = parent;
			}
	
	 public void onClick(ClickEvent event) {   
	           
		            user = currentDisp.get(opTable.getCellForEvent(event).getRowIndex()-1);

		            ProfilePage editProfilePanel = new EditProfile("Rediger Profil", user, parent, serverComm);
		            parent.parent.gotoPanel(editProfilePanel);
		            
		            

		        }
		    };
	}



