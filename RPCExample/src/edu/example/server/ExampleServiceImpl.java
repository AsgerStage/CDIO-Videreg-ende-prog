package edu.example.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.thoughtworks.xstream.XStream;

import edu.example.client.service.ExampleService;
import edu.example.server.database.MySQLOperatoerDAO;
import edu.example.server.database.OperatorDTO;
import edu.example.server.database.exceptions.DALException;

public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService
{
	MySQLOperatoerDAO opDAO=new MySQLOperatoerDAO();
	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public int addTwonumbers(int num1, int num2) {
		return num1 + num2;
	}
	
//	public List<OperatorDTO> getOpList(){
//		try {
//			return opDAO.getOperatorList();
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		
//	}

	
	@Override
	public String getOperator(int oprID) {
		try {
			XStream xstream = new XStream();
			return xstream.toXML(opDAO.getOperator(oprID));
			
//			return opDAO.getOperator(oprID);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	/*
	@Override
	public void createOperator(OperatorDTO opr) {
		try {
			opDAO.createOperator(opr);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void updateOperator(OperatorDTO opr) {
	try {
		opDAO.updateOperator(opr);
	} catch (DALException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}*/
}