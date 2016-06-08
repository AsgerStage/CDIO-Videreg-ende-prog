package edu.example.client.service;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;

public interface ExampleServiceIClient 
{
	//operators
	void getOpList();
	
	void getOperator(int oprID);
	
	void createOperator(OperatorDTO opr);
	
	void updateOperator(OperatorDTO opr);
	
	void getPassword(int oprID);
	
	//Raavarer
	void getRaavareList();
	
	void createRaavare(RaavareDTO raavare);
	
	void updateRaavare(RaavareDTO raavare);
	
	void deleteRaavare(RaavareDTO raavare);
}