package cdio3.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cdio3.client.service.CDIOService;

public class ServerServiceImpl extends RemoteServiceServlet implements CDIOService{

	@Override
	public String asd(String name) {
		
		return ("virker");
	}

	@Override
	public int asd2(int num1, int num2) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
