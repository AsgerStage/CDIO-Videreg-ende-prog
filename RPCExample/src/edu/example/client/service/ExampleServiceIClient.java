package edu.example.client.service;

import edu.example.client.models.OperatorDTO;

public interface ExampleServiceIClient 
{
	void getOpList();
	
	void getRaavareList();
	
	void getOperator(int oprID);
	
	void createOperator(OperatorDTO opr);
	
	void updateOperator(OperatorDTO opr);
	
	void getPassword(int oprID);
}