package edu.example.client.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.ProduktbatchDTO;
import edu.example.client.models.ProduktbatchKompDTO;
import edu.example.client.models.RaavareDTO;
import edu.example.client.models.RaavarebatchDTO;
import edu.example.client.models.ReceptDTO;

@RemoteServiceRelativePath("exampleservice")
public interface RPCService extends RemoteService
{
	//operators
	ArrayList<OperatorDTO> getOpList();
	
	OperatorDTO getOperator(int oprID);
	
	boolean createOperator(OperatorDTO opr);
	
	boolean updateOperator(OperatorDTO opr);
	
	String getPassword(int oprID);
	
	void deleteOperator(int oprID);
	
	//Raavarer
	ArrayList<RaavareDTO> getRaavareList();
	
	String createRaavare(RaavareDTO raavare);
	
	String updateRaavare(RaavareDTO raavare);
	
	String deleteRaavare(int raavareID);
	
	//Råvarebatch
	ArrayList<RaavarebatchDTO> getRaavarebatchList();
	
	String createRaavarebatch(RaavarebatchDTO raavarebatch);
	
	String updateRaavarebatch(RaavarebatchDTO raavarebatch);
	
	String deleteRaavarebatch(int rbID);
	
	//Produktbatch komponent
	ArrayList<ProduktbatchDTO> getPbkompListByPbID(int pbID);
	
	String createPbkomp(ProduktbatchKompDTO pbkomp);
	
	String updatePbkomp(ProduktbatchKompDTO pbkomp);
	
	String deletePbkomp(int pbID, int rbID);
	
	//Produktbatch
	ArrayList<ProduktbatchDTO> getProduktbatchList();
	
	String createProduktbatch(ProduktbatchDTO produktbatch);
	
	String updateProduktbatch(ProduktbatchDTO produktbatch);
	
	String deleteProduktbatch(int pbID);
	
	//Recept
	ArrayList<ReceptDTO> getReceptList();
	
	String createRecept(ReceptDTO recept);
	
	String updateRecept(ReceptDTO recept);
	
	String deleteRecept(int receptID);
	
	//TelnetClient
	
	ArrayList<String> getDataList(String command, int expectedReplies, List<String> params);
	String getData(String command, List<String> params);
}