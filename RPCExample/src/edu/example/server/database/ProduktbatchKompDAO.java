package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchKompDTO;

public interface ProduktbatchKompDAO {
	ProduktbatchKompDTO getProduktbatchKomp(int pbId, int rbId) throws DALException;
	List<ProduktbatchKompDTO> getProduktbatchKompList() throws DALException;
	List<ProduktbatchKompDTO> getProduktbatchKompListByRBID(int pbID) throws DALException;
	int createProduktbatchKomp(ProduktbatchKompDTO produktbatchkomponent) throws DALException;
	int updateProduktbatchKomp(ProduktbatchKompDTO produktbatchkomponent) throws DALException;
	int deleteProduktbatchKomp(int pbID, int rbID) throws DALException;
}