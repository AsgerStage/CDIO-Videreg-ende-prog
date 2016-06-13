package edu.example.server.database;

import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ReceptkompDTO;

public interface ReceptkompDAO {
	ReceptkompDTO getReceptkomp(int receptID, int raavareID) throws DALException;
	List<ReceptkompDTO> getReceptkompList() throws DALException;
	List<ReceptkompDTO> getReceptkompListByReceptID(int receptId) throws DALException;
	int createReceptkomp(ReceptkompDTO receptkomp) throws DALException; 
	int updateReceptkomp(ReceptkompDTO receptkomp) throws DALException;
	int deleteReceptkomp(int receptID, int raavareID) throws DALException;
}