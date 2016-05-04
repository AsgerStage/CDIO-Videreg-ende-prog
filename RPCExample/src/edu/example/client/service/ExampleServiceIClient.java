package edu.example.client.service;

import edu.example.server.database.OperatorDTO;

public interface ExampleServiceIClient 
{
	void sayHello(String name);
	
	void addTwonumbers(int num1, int num2);


	void getOpList();
	
	void getOperator(int oprID);
	void createOperator(String XMLopr);
	void updateOperator(String XMLopr);
	void getPassword(int oprID);
}