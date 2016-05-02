package edu.example.server.database;

import java.util.List;

import edu.example.server.database.dto.OperatoerDTO;
import edu.example.server.database.exceptions.DALException;

public interface OperatoerDAO {
	OperatoerDTO getOperatoer(int oprId) throws DALException;
	List<OperatoerDTO> getOperatoerList() throws DALException;
	void createOperatoer(OperatoerDTO opr) throws DALException;
	void updateOperatoer(OperatoerDTO opr) throws DALException;
}
