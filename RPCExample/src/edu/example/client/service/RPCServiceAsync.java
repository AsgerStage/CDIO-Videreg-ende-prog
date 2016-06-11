package edu.example.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;
import edu.example.client.models.RaavarebatchDTO;
import edu.example.client.models.ReceptDTO;

public interface RPCServiceAsync 
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
	
	//Råvarebatch
	void getRaavarebatchList(AsyncCallback callback);
	
	void createRaavarebatch(RaavarebatchDTO raavarebatch, AsyncCallback callback);
	
	void updateRaavarebatch(RaavarebatchDTO raavarebatch, AsyncCallback callback);
	
	void deleteRaavarebatch(int rbID, AsyncCallback callback);
	
	//Recept
	void getReceptList(AsyncCallback callback);
	
	void createRecept(ReceptDTO recept, AsyncCallback callback);
	
	void updateRecept(ReceptDTO recept, AsyncCallback callback);
	
	void deleteRecept(int receptID, AsyncCallback callback);
	
}