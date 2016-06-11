package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchDTO;

public interface ProduktbatchDAO {
	ProduktbatchDTO getProduktBatch(int pbId) throws DALException;
	List<ProduktbatchDTO> getProduktbatchList() throws DALException;
	void createProduktbatch(ProduktbatchDTO produktbatch) throws DALException;
	void updateProduktbatch(ProduktbatchDTO produktbatch) throws DALException;
}