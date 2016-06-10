package edu.example.client.service;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;
import edu.example.client.models.ReceptDTO;

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
	
	void deleteRaavare(int raavareID);
	
	//Recepter
	void getReceptList();
	
	void createRecept(ReceptDTO recept);
	
	void updateRecept(ReceptDTO recept);
	
	void deleteRecept(int receptID);
	
}