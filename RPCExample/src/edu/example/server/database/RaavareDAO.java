package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.RaavareDTO;

public interface RaavareDAO {
	RaavareDTO getRaavare(int raavareID) throws DALException;
	List<RaavareDTO> getRaavareList() throws DALException;
	void createRaavare(RaavareDTO raavare) throws DALException;
	void updateRaavare(RaavareDTO raavare) throws DALException;
	void deleteRaavare(int raavareID) throws DALException;
}