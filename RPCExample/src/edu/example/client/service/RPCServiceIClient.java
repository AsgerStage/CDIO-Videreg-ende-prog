package edu.example.client.service;

import java.util.List;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.ProduktbatchDTO;
import edu.example.client.models.ProduktbatchKompDTO;
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
	
	//Produktbatch komponent
	void getPbkompListByPbID(int pbID);
	
	void createPbkomp(ProduktbatchKompDTO pbkomp);
	
	void updatePbkomp(ProduktbatchKompDTO pbkomp);
	
	void deletePbkomp(int pbID, int rbID);
	
	//Produktbatch
	void getProduktbatchList();
	
	void createProduktbatch(ProduktbatchDTO produktbatch);
	
	void updateProduktbatch(ProduktbatchDTO produktbatch);
	
	void deleteProduktbatch(int pbID);
	
	//Recepter
	void getReceptList();
	
	void createRecept(ReceptDTO recept);
	
	void updateRecept(ReceptDTO recept);
	
	void deleteRecept(int receptID);
	
	//Telnet Client
	void getDataList(String command, int expectedReplies, List<String> params);
	void getData(String command, List<String> params);
	
}