package edu.example.client.service;

import edu.example.client.models.OperatorDTO;

public interface ExampleServiceIClient 
{
//	void sayHello(String name);
//	
//	void addTwonumbers(int num1, int num2);
//
	void getOpList();
	
	void getOperator(int oprID);
	
	void createOperator(OperatorDTO opr);
	
	void updateOperator(OperatorDTO opr);
	
	void getPassword(int oprID);
}