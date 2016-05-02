package edu.example.server.database;

import java.util.List;

import edu.example.server.database.dto.RaavareDTO;
import edu.example.server.database.exceptions.DALException;

public interface RaavareDAO {
	RaavareDTO getRaavare(int raavareId) throws DALException;
	List<RaavareDTO> getRaavareList() throws DALException;
	void createRaavare(RaavareDTO raavare) throws DALException;
	void updateRaavare(RaavareDTO raavare) throws DALException;
}
