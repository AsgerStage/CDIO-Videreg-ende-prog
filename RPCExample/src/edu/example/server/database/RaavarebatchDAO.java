package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.RaavarebatchDTO;

public interface RaavarebatchDAO {
	RaavarebatchDTO getRaavarebatch(int rbId) throws DALException;
	List<RaavarebatchDTO> getRaavarebatchlist() throws DALException;
	int createRaavarebatch(RaavarebatchDTO raavarebatch) throws DALException;
	int updateRaavarebatch(RaavarebatchDTO raavarebatch) throws DALException;
	int deleteRaavarebatch(int raavareId) throws DALException;
}