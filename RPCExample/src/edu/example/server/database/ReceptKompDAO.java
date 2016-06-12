package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ReceptkompDTO;

public interface ReceptKompDAO {
	ReceptkompDTO getReceptKomp(int receptId, int raavareId) throws DALException;
	List<ReceptkompDTO> getReceptKompList(int receptId) throws DALException;
	List<ReceptkompDTO> getReceptKompList() throws DALException;
		void createReceptKomp(ReceptkompDTO receptkomponent) throws DALException;
	void updateReceptKomp(ReceptkompDTO receptkomponent) throws DALException;
}