package cdio3.client.service;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import cdio3.client.gui.overlay.Banner;

public class ServiceClientImpl implements ClientInterface{
	private CDIOServiceAsync service;
	private Banner mainGui;
	
	public ServiceClientImpl(String url){
		//System.out.println();
		this.service = GWT.create(CDIOService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service;
		endPoint.setServiceEntryPoint(url);
		
		this.mainGui = new Banner(this);
	}
	
	public Banner getMainGUI(){
		return mainGui;
	}

	@Override
	public void asd(String name) {
		this.service.asd(name,new DefaultCallback());
		
	}

	@Override
	public void asd2(int num1, int num2) {
		this.service.asd2(num1, num2,new DefaultCallback());
		
	}
	
	private class DefaultCallback implements AsyncCallback{

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("Fejl");
			
		}

		@Override
		public void onSuccess(Object result) {
			System.out.println("Modtaget");
			if(result instanceof String);
				//mainGui.updateLabel((String) result);
			
		}
		
	}

}
