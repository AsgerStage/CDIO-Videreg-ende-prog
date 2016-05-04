package edu.example.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.example.client.models.OperatorDTO;

@RemoteServiceRelativePath("exampleservice")
public interface ExampleService extends RemoteService
{
//	String sayHello(String name);
//	
//	int addTwonumbers(int num1, int num2);
//	
//	String getOpList();
	
	OperatorDTO getOperator(int oprID);
	
//	boolean createOperator(String XMLopr);
//	
//	boolean updateOperator(String XMLopr);
//	
//	String getPassword(int oprID);
}