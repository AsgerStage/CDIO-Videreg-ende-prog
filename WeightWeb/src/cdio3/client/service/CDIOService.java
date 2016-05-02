package cdio3.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("cdioservice")
public interface CDIOService extends RemoteService {
	String asd(String name);
	
	int asd2 (int num1, int num2);
}
