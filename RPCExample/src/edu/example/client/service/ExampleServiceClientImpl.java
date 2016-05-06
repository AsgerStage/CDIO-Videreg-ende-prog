package edu.example.client.service;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import edu.example.client.gui.Banner;
import edu.example.client.gui.login.Login;
import edu.example.client.gui.operatoerList.OperatoerList;
import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.models.OperatorDTO;

public class ExampleServiceClientImpl implements ExampleServiceIClient
{
	private ExampleServiceAsync service;
	private Banner mainGui;
	
	public ExampleServiceClientImpl(String url) {
		System.out.println("URL: " + url);
		
		this.service = GWT.create(ExampleService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service;
		endPoint.setServiceEntryPoint(url);
		
		this.mainGui = new Banner(this);
	}
	
	public Banner getMainGUI() {
		return mainGui;
	}
	
//	@Override
//	public void sayHello(String name) {
//		this.service.sayHello(name, new DefaultCallback());
//	}
//
//	@Override
//	public void addTwonumbers(int num1, int num2) {
//		this.service.addTwonumbers(num1, num2, new DefaultCallback());
//	}
	
	@Override
	public void getOpList()
	{
		this.service.getOpList(new DefaultCallback());
	}
	
	@Override
	public void getOperator(int oprID){
		this.service.getOperator(oprID, new DefaultCallback());
	}
	
	@Override
	public void createOperator(OperatorDTO opr){
		this.service.createOperator(opr, new DefaultCallback());
	}
	
	@Override
	public void updateOperator(OperatorDTO opr){
		this.service.updateOperator(opr, new DefaultCallback());
	}
	
	@Override
	public void getPassword(int oprID){
		this.service.getPassword(oprID, new DefaultCallback());
	}
	
	private class DefaultCallback implements AsyncCallback 
	{
		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			System.out.println("Response received");
			Object currentPanel = mainGui.getCurrentPanel();
			
			if(currentPanel instanceof ViewProfile) {
				ViewProfile viewProfile = (ViewProfile) currentPanel;
				viewProfile.updateUser((OperatorDTO) result);
			}
			if(currentPanel instanceof OperatoerList) {
				OperatoerList oplist = (OperatoerList) currentPanel;
				oplist.getOperatoerList((List<OperatorDTO>) result);
			}
			if(currentPanel instanceof Login) {
				Login viewProfile = (Login) currentPanel;
				viewProfile.CompareLogin((OperatorDTO) result);
			}
		}
	}
}