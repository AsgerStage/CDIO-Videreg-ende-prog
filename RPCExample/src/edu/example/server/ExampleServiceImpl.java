package edu.example.server;

import java.util.ArrayList;

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
	
	@Override
	public ArrayList<OperatorDTO> getOpList(){
		try {
			return new ArrayList<OperatorDTO>(opDAO.getOperatorList());
		} catch (DALException e) {
			e.printStackTrace();
			return null;
		}
	}

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
	
	@Override
	public boolean createOperator(OperatorDTO opr) {
		try {
			opDAO.createOperator(opr);
			return true;
		} catch (DALException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateOperator(OperatorDTO opr) {
		try {
			opDAO.updateOperator(opr);
			return true;
		} catch (DALException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String getPassword(int oprID) {
		try {
			return opDAO.getOperator(oprID).getPassword();
		} catch (DALException e) {
			e.printStackTrace();
			return null;
		}
	}
}