package edu.example.client.service;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import edu.example.client.gui.Banner;
import edu.example.client.gui.login.Login;
import edu.example.client.gui.operatoerList.OperatoerList;
import edu.example.client.gui.profile.ViewProfile;
import edu.example.client.gui.raavare.RaavarePanel;
import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;

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
	
	//Operators
	@Override
	public void getOpList()	{
		this.service.getOpList(new DefaultCallback());
	}
	
	@Override
	public void getOperator(int oprID) {
		this.service.getOperator(oprID, new DefaultCallback());
	}
	
	@Override
	public void createOperator(OperatorDTO opr) {
		this.service.createOperator(opr, new DefaultCallback());
	}
	
	@Override
	public void updateOperator(OperatorDTO opr) {
		this.service.updateOperator(opr, new DefaultCallback());
	}
	
	@Override
	public void getPassword(int oprID) {
		this.service.getPassword(oprID, new DefaultCallback());
	}

	//Raavarer
	@Override
	public void getRaavareList() {
		this.service.getRaavareList(new DefaultCallback());
	}

	@Override
	public void createRaavare(RaavareDTO raavare) {
		this.service.createRaavare(raavare, new DefaultCallback());
	}

	@Override
	public void updateRaavare(RaavareDTO raavare) {
		this.service.updateRaavare(raavare, new DefaultCallback());
	}

	@Override
	public void deleteRaavare(RaavareDTO raavare) {
		this.service.deleteRaavare(raavare, new DefaultCallback());
	}
	
	/**
	 * Async Callback
	 */
	private class DefaultCallback implements AsyncCallback 
	{
		@Override
		public void onFailure(Throwable caught) {
			
		}

		@Override
		public void onSuccess(Object result) {
			Object currentPanel = mainGui.getCurrentPanel();
			
			if(currentPanel instanceof ViewProfile) {
				ViewProfile viewProfile = (ViewProfile) currentPanel;
				viewProfile.updateUser((OperatorDTO) result);
			}
			else if(currentPanel instanceof OperatoerList) {
				OperatoerList oplist = (OperatoerList) currentPanel;
				oplist.updateOperatoerList((List<OperatorDTO>) result);
			}
			else if(currentPanel instanceof Login) {
				Login viewProfile = (Login) currentPanel;
				viewProfile.CompareLogin((OperatorDTO) result);
			}
			else if (currentPanel instanceof RaavarePanel) {
				RaavarePanel raavarePanel = (RaavarePanel) currentPanel;
				
				if(result instanceof Boolean) 
					raavarePanel.statusUpdate((Boolean) result);
				else
					raavarePanel.updateTable((List<RaavareDTO>) result);
			}
		}
	}
}