package edu.example.server.database;

import java.util.List;

import edu.example.server.database.exceptions.DALException;

public interface OperatoerDAO {
	OperatorDTO getOperator(int oprId) throws DALException;
	List<OperatorDTO> getOperatorList() throws DALException;
	void createOperator(OperatorDTO opr) throws DALException;
	void updateOperator(OperatorDTO opr) throws DALException;
}
