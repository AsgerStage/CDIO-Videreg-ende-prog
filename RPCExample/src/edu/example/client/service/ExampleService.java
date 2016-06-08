package edu.example.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;

@RemoteServiceRelativePath("exampleservice")
public interface ExampleService extends RemoteService
{
	ArrayList<OperatorDTO> getOpList();
	
	ArrayList<RaavareDTO> getRaavareList();
	
	OperatorDTO getOperator(int oprID);
	
	boolean createOperator(OperatorDTO opr);
	
	boolean updateOperator(OperatorDTO opr);
	
	String getPassword(int oprID);
}