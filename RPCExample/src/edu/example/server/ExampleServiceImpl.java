package edu.example.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.OperatorDTO;
import edu.example.client.service.ExampleService;
import edu.example.server.database.MySQLOperatoerDAO;

public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService
{
	private final MySQLOperatoerDAO opDAO = new MySQLOperatoerDAO();
	
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
			return opDAO.getOperator(oprID);
		} catch (DALException e) {
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