package edu.example.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.client.exceptions.DALException;
import edu.example.client.exceptions.OpIdException;
import edu.example.client.exceptions.OpNameException;
import edu.example.client.exceptions.OpPasswordException;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.ExampleService;
import edu.example.server.database.MySQLOperatoerDAO;

public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService
{
	private final MySQLOperatoerDAO opDAO = new MySQLOperatoerDAO();
	
//	@Override
//	public String sayHello(String name) {
//		return "Hello " + name;
//	}

//	@Override
//	public int addTwonumbers(int num1, int num2) {
//		return num1 + num2;
//	}
	
//	@Override
//	public String getOpList(){
//		return null;
//		try {
//			return opDAO.getOperatorList();
//		} catch (DALException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	@Override
	public OperatorDTO getOperator(int oprID) {
		try {
			return new OperatorDTO(oprID, "Test Person", "TSP", "123456-7890", "Abc123", 1);
//			return opDAO.getOperator(oprID);
		} catch (DALException | OpPasswordException | OpNameException | OpIdException e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	@Override
//	public boolean createOperator(String XMLopr) {
//		return false;
//		try {
//			opDAO.createOperator((OperatorDTO) xstream.fromXML(XMLopr));
//			return true;
//		} catch (DALException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	
//	@Override
//	public boolean updateOperator(String XMLopr) {
//		return false;
//		try {
//			opDAO.updateOperator((OperatorDTO)xstream.fromXML(XMLopr));
//			return true;
//		} catch (DALException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	
//	@Override
//	public String getPassword(int oprID) {
//		return null;
//		try {
//			return xstream.toXML(opDAO.getOperator(oprID));
//		} catch (DALException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
}