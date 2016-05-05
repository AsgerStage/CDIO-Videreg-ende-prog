package edu.example.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.example.client.models.OperatorDTO;

public interface ExampleServiceAsync 
{
//	void sayHello(String name, AsyncCallback callback);
//	
//	void addTwonumbers(int num1, int num2, AsyncCallback callback);
	
	void getOpList(AsyncCallback callback);
	
	void getOperator(int oprID, AsyncCallback callback);
	
	void createOperator(OperatorDTO opr, AsyncCallback callback);
	
	void updateOperator(OperatorDTO opr, AsyncCallback callback);
	
	void getPassword(int oprID, AsyncCallback callback);
}