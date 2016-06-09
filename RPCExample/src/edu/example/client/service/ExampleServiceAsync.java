package edu.example.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;

public interface ExampleServiceAsync 
{
	//operators
	void getOpList(AsyncCallback callback);
	
	void getOperator(int oprID, AsyncCallback callback);
	
	void createOperator(OperatorDTO opr, AsyncCallback callback);
	
	void updateOperator(OperatorDTO opr, AsyncCallback callback);
	
	void getPassword(int oprID, AsyncCallback callback);
	
	//Raavarer
	void getRaavareList(AsyncCallback callback);
	
	void createRaavare(RaavareDTO raavare, AsyncCallback callback);
	
	void updateRaavare(RaavareDTO raavare, AsyncCallback callback);
	
	void deleteRaavare(int raavareID, AsyncCallback callback);
}