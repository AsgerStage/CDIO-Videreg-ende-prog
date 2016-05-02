package edu.example.server.database;

import java.util.List;

import edu.example.server.database.dto.ReceptDTO;
import edu.example.server.database.exceptions.DALException;

public interface ReceptDAO {
	ReceptDTO getRecept(int receptId) throws DALException;
	List<ReceptDTO> getReceptList() throws DALException;
	void createRecept(ReceptDTO recept) throws DALException;
	void updateRecept(ReceptDTO recept) throws DALException;
}
