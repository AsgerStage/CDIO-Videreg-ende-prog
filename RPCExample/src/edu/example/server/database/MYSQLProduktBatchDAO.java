package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchDTO;
import edu.example.server.database.connector.Connector;

public class MYSQLProduktBatchDAO implements ProduktbatchDAO 
{
	@Override
	public ProduktbatchDTO getProduktBatch(int pbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch WHERE pbId= "+pbId);
		try
		{
			if(!rs.first()) throw new DALException("Produktbatch"+pbId+"Findes ikke");
			return new ProduktbatchDTO (rs.getInt("pbId"),rs.getInt("status"),rs.getInt("receptId"));
		}
		catch(SQLException e){throw new DALException(e);}
	}
	
	@Override
	public List<ProduktbatchDTO> getProduktBatchList() throws DALException {
		List<ProduktbatchDTO> list = new ArrayList<ProduktbatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktbatchDTO(rs.getInt("PbId"), rs.getInt("status"), rs.getInt("receptId")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatch(ProduktbatchDTO produktbatch) throws DALException {
	Connector.doUpdate(
			"INSERT INTO produktbatch(pbID,status,receptId) VALUES" +"("+produktbatch.getPbID()+", '"+produktbatch.getStatus()+"', '"+produktbatch.getReceptID()+"'"
			);
	}

	@Override
	public void updateProduktBatch(ProduktbatchDTO produktbatch) throws DALException {
		Connector.doUpdate(
				"UPDATE produktbatch SET  pbId = '" + produktbatch.getPbID() + "', status =  '" + produktbatch.getStatus() + 
				"', receptId = '" + produktbatch.getReceptID() + "' WHERE pbId = " +
				produktbatch.getPbID()
		);
	}
}