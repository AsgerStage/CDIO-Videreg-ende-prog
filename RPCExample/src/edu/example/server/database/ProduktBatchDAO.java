package edu.example.server.database;

import java.util.List;

import edu.example.server.database.dto.ProduktBatchDTO;
import edu.example.server.database.exceptions.DALException;

public interface ProduktBatchDAO {
	ProduktBatchDTO getProduktBatch(int pbId) throws DALException;
	List<ProduktBatchDTO> getProduktBatchList() throws DALException;
	void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException;
	void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException;
}