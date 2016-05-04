package edu.example.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.example.server.database.OperatorDTO;





@RemoteServiceRelativePath("exampleservice")
public interface ExampleService extends RemoteService
{
	String sayHello(String name);
	
	int addTwonumbers(int num1, int num2);
	
//	List<OperatorDTO> getOpList();
	
	String getOperator(int oprID);
//	void createOperator(OperatorDTO opr);
//	void updateOperator(OperatorDTO opr);*/
}