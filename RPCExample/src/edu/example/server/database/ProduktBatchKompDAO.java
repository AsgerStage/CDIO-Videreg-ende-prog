package edu.example.server.database;

import java.util.List;

import edu.example.server.database.dto.ProduktBatchKompDTO;
import edu.example.server.database.exceptions.DALException;

public interface ProduktBatchKompDAO {
	ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException;
	List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException;
	List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException;
	void createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException;
	void updateProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException;	
}

