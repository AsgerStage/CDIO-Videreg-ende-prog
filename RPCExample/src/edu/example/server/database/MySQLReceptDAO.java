package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.server.database.connector.Connector;
import edu.example.server.database.dto.ReceptDTO;

public class MySQLReceptDAO implements ReceptDAO 
{
	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM recept WHERE receptId = " + receptId);
	    try {
	    	if (!rs.first()) throw new DALException("recepten " + receptId + " findes ikke");
	    	return new ReceptDTO (rs.getInt("receptId"), rs.getString("receptNavn"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		List<ReceptDTO> list = new ArrayList<ReceptDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recept");
		try {
			while (rs.next()) {
				list.add(new ReceptDTO(rs.getInt("receptId"), rs.getString("receptNavn")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}
	
	@Override
	public void createRecept(ReceptDTO recept) throws DALException {		
			Connector.doUpdate(
				"INSERT INTO recept(receptId, receptNavn) VALUES " +
				"(" + recept.getReceptId() + ", '" + recept.getReceptNavn() + "',)"
			);
	}

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate("UPDATE recept SET  receptId = '" + recept.getReceptId() + "', receptNavn =  '"
				+ recept.getReceptNavn() + "' WHERE receptId = " + recept.getReceptId());
	}

}
