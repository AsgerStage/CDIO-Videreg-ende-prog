package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchDTO;

public interface ProduktbatchDAO {
	ProduktbatchDTO getProduktbatch(int pbId) throws DALException;
	List<ProduktbatchDTO> getProduktbatchList() throws DALException;
	int createProduktbatch(ProduktbatchDTO produktbatch) throws DALException;
	int updateProduktbatch(ProduktbatchDTO produktbatch) throws DALException;
	int deleteProduktbatch(int pbID) throws DALException;
}