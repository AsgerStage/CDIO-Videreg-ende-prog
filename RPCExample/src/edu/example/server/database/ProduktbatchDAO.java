package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchDTO;

public interface ProduktbatchDAO {
	ProduktbatchDTO getProduktBatch(int pbId) throws DALException;
	List<ProduktbatchDTO> getProduktBatchList() throws DALException;
	void createProduktBatch(ProduktbatchDTO produktbatch) throws DALException;
	void updateProduktBatch(ProduktbatchDTO produktbatch) throws DALException;
}