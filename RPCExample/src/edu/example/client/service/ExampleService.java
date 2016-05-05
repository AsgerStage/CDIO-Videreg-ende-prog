package edu.example.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.example.client.models.OperatorDTO;

@RemoteServiceRelativePath("exampleservice")
public interface ExampleService extends RemoteService
{
//	String sayHello(String name);
//	
//	int addTwonumbers(int num1, int num2);
	
	ArrayList<OperatorDTO> getOpList();
	
	OperatorDTO getOperator(int oprID);
	
	boolean createOperator(OperatorDTO opr);
	
	boolean updateOperator(OperatorDTO opr);
	
	String getPassword(int oprID);
}