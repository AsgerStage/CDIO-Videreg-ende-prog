package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchkompDTO;

public interface ProduktbatchKompDAO {
	ProduktbatchkompDTO getProduktbatchKomp(int pbId, int rbId) throws DALException;
	List<ProduktbatchkompDTO> getProduktbatchKompList() throws DALException;
	List<ProduktbatchkompDTO> getProduktbatchKompListByRBID(int pbID) throws DALException;
	int createProduktbatchKomp(ProduktbatchkompDTO produktbatchkomponent) throws DALException;
	int updateProduktbatchKomp(ProduktbatchkompDTO produktbatchkomponent) throws DALException;
	int deleteProduktbatchKomp(int pbID, int rbID) throws DALException;
}