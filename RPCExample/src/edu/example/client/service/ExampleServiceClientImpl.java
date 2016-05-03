package edu.example.client.service;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import edu.example.client.gui.Banner;

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
	
	@Override
	public void sayHello(String name) {
		this.service.sayHello(name, new DefaultCallback());
	}

	@Override
	public void addTwonumbers(int num1, int num2) {
		this.service.addTwonumbers(num1, num2, new DefaultCallback());
	}
	@Override
	public void getOpList()
	{
			this.service.getOpList(new DefaultCallback());
		
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
			
//			if(result instanceof String)
//				mainGui.updateLabel((String) result);
		}
	}
}