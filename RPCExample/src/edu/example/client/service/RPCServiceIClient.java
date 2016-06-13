package edu.example.client.service;

import java.util.List;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.ProduktbatchDTO;
import edu.example.client.models.ProduktbatchkompDTO;
import edu.example.client.models.RaavareDTO;
import edu.example.client.models.RaavarebatchDTO;
import edu.example.client.models.ReceptDTO;
import edu.example.client.models.ReceptkompDTO;

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
	void getRaavarebatch(int rbID);
	
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
	
	void createPbkomp(ProduktbatchkompDTO pbkomp);
	
	void updatePbkomp(ProduktbatchkompDTO pbkomp);
	
	void deletePbkomp(int pbID, int rbID);
	
	//Produktbatch
	void getProduktbatch(int pbID);
	
	void getProduktbatchList();
	
	void createProduktbatch(ProduktbatchDTO produktbatch);
	
	void updateProduktbatch(ProduktbatchDTO produktbatch);
	
	void deleteProduktbatch(int pbID);
	
	//Recepter
	void getRecept(int receptID);
	
	void getReceptList();
	
	void createRecept(ReceptDTO recept);
	
	void updateRecept(ReceptDTO recept);
	
	void deleteRecept(int receptID);
	
	//Recept komponent
	void getReceptkompListByReceptID(int receptID);
	
	void createReceptkomp(ReceptkompDTO receptkomp);
	
	void updateReceptkomp(ReceptkompDTO receptkomp);
	
	void deleteReceptkomp(int receptID, int raavareID);
	
	//Telnet Client
	void getDataList(String command, int expectedReplies, List<String> params);
	void getData(String command, List<String> params);
	
}