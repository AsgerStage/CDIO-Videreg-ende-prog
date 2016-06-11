package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchDTO;
import edu.example.server.database.connector.Connector;

public class MYSQLProduktbatchDAO implements ProduktbatchDAO 
{
	@Override
	public ProduktbatchDTO getProduktbatch(int pbID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch WHERE pbId = " + pbID);
		try {
			if (!rs.first()) 
				throw new DALException("Produktbatch " + pbID + " Findes ikke");
			return new ProduktbatchDTO (rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
		}
		catch(SQLException e) {
			throw new DALException(e);
		}
	}
	
	@Override
	public List<ProduktbatchDTO> getProduktbatchList() throws DALException {
		List<ProduktbatchDTO> list;
		try	{
			list = new ArrayList<ProduktbatchDTO>();
			ResultSet rs = Connector.doQuery("CALL `get_produktbatchlist`()");
			
			while (rs.next()) {
				list.add(new ProduktbatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
			}
		}
		catch (SQLException e) { 
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public int createProduktbatch(ProduktbatchDTO produktbatch) throws DALException {
		return Connector.doUpdate("CALL `create_produktbatch`(?, ?, ?)",
				produktbatch.getPbID(), produktbatch.getStatus(), produktbatch.getReceptID());
	}

	@Override
	public int updateProduktbatch(ProduktbatchDTO produktbatch) throws DALException {
		return Connector.doUpdate("CALL `update_produktbatch`(?, ?, ?)",
				produktbatch.getPbID(), produktbatch.getStatus(), produktbatch.getReceptID());
	}

	@Override
	public int deleteProduktbatch(int pbID) throws DALException {
		return Connector.doUpdate("CALL `delete_produktbatch`(?)",
				pbID);
	}
}