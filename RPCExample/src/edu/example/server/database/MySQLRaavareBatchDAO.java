package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.RaavareBatchDTO;
import edu.example.server.database.connector.Connector;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO 
{	
	public RaavareBatchDTO getRaavareBatch(int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE raavare_id = " + raavareId);
	    try {
	    	if (!rs.first()) throw new DALException("RaavareBatch " + raavareId + " findes ikke");
			return new RaavareBatchDTO (rs.getInt("rbId"), rs.getInt("raavareId"), rs.getDouble("maengde"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}
	
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {		
			Connector.doUpdate(
				"INSERT INTO raavarebatch(raavare_id, rb_id, maengde) VALUES " +
				"(" + raavarebatch.getRaavareID() + ", '" + raavarebatch.getRbID() + ", '" + raavarebatch.getMaengde() + "')"
			);
	}
	
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate(
				"UPDATE raavarebatch SET  raavare_id = '" + raavarebatch.getRaavareID() + "', rb_id =  '" + raavarebatch.getRbID() + 
				"', maengde = '" + raavarebatch.getMaengde()
		);
	}
	
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new RaavareBatchDTO(rs.getInt("rbId"), rs.getInt("raavareId"), rs.getDouble("maengde")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new RaavareBatchDTO(rs.getInt("rbId"), rs.getInt("raavareId"), rs.getDouble("maengde")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
		
}
	
