package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

public class MYSQLProduktBatchDAO implements ProduktBatchDAO 
{
	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch WHERE pbId= "+pbId);
		try
		{
			if(!rs.first()) throw new DALException("Produktbatch"+pbId+"Findes ikke");
			return new ProduktBatchDTO (rs.getInt("pbId"),rs.getInt("status"),rs.getInt("receptId"));
		}
		catch(SQLException e){throw new DALException(e);}
	}
	
	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		List<ProduktBatchDTO> list = new ArrayList<ProduktBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchDTO(rs.getInt("PbId"), rs.getInt("status"), rs.getInt("receptId")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
	Connector.doUpdate(
			"INSERT INTO produktbatch(pbID,status,receptId) VALUES" +"("+produktbatch.getPbId()+", '"+produktbatch.getStatus()+"', '"+produktbatch.getReceptId()+"'"
			);
	}

	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		Connector.doUpdate(
				"UPDATE produktbatch SET  pbId = '" + produktbatch.getPbId() + "', status =  '" + produktbatch.getStatus() + 
				"', receptId = '" + produktbatch.getReceptId() + "' WHERE pbId = " +
				produktbatch.getPbId()
		);
	}
}