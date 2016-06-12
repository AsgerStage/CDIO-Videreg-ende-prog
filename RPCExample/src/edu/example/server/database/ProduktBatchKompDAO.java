package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchKompDTO;

public interface ProduktBatchKompDAO {
	ProduktbatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException;
	List<ProduktbatchKompDTO> getProduktBatchKompList(int pbId) throws DALException;
	List<ProduktbatchKompDTO> getProduktBatchKompList() throws DALException;
	void createProduktBatchKomp(ProduktbatchKompDTO produktbatchkomponent) throws DALException;
	void updateProduktBatchKomp(ProduktbatchKompDTO produktbatchkomponent) throws DALException;	
}