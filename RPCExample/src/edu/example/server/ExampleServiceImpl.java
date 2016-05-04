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
	private final XStream xstream = new XStream();
	
	MySQLOperatoerDAO opDAO=new MySQLOperatoerDAO();
	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public int addTwonumbers(int num1, int num2) {
		return num1 + num2;
	}
	
	public String getOpList(){
		try {
			return xstream.toXML(opDAO.getOperatorList());
//			return opDAO.getOperatorList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	
	@Override
	public String getOperator(int oprID) {
		try {
			return xstream.toXML(opDAO.getOperator(oprID));
			
//			return opDAO.getOperator(oprID);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	
	@Override
	public boolean createOperator(String XMLopr) {
		try {
			opDAO.createOperator((OperatorDTO)xstream.fromXML(XMLopr));
			return true;
		} catch (DALException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	
	@Override
	public boolean updateOperator(String XMLopr) {
	try {
		
		opDAO.updateOperator((OperatorDTO)xstream.fromXML(XMLopr));
	return true;
	} catch (DALException e) {
		
		e.printStackTrace();
		return false;
	}
	}
	@Override
	public String getPassword(int oprID) {
	try {
		return xstream.toXML(opDAO.getOperator(oprID));
	} catch (DALException e) {
		
		e.printStackTrace();
		return null;
	}
	}
}