package edu.example.client.service;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;
import edu.example.client.models.RaavarebatchDTO;
import edu.example.client.models.ReceptDTO;

public interface RPCServiceIClient 
{
	//operators
	void getOpList();
	
	void getOperator(int oprID);
	
	void createOperator(OperatorDTO opr);
	
	void updateOperator(OperatorDTO opr);
	
	void getPassword(int oprID);
	
	void deleteOperator(int oprID);
	
	//Raavarer
	void getRaavareList();
	
	void createRaavare(RaavareDTO raavare);
	
	void updateRaavare(RaavareDTO raavare);
	
	void deleteRaavare(int raavareID);
	
	//Råvarebatch
	void getRaavarebatchList();
	
	void createRaavarebatch(RaavarebatchDTO raavarebatch);
	
	void updateRaavarebatch(RaavarebatchDTO raavarebatch);
	
	void deleteRaavarebatch(int rbID);
	
	//Recepter
	void getReceptList();
	
	void createRecept(ReceptDTO recept);
	
	void updateRecept(ReceptDTO recept);
	
	void deleteRecept(int receptID);
	
}