package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchKompDTO;
import edu.example.server.database.connector.Connector;

public class MySQLProduktBatchKompDAO implements ProduktBatchKompDAO
{
	@Override
	public ProduktbatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id= "+pbId+" AND rb_id="+rbId);
		try
		{
			if(!rs.first()) throw new DALException("Produktbatchkomponent"+pbId+"Findes ikke");
			return new ProduktbatchKompDTO (rs.getInt("pb_id"),rs.getInt("rb_id"),rs.getDouble("tara"),rs.getDouble("netto"),rs.getInt("opr_id"));
		}
		catch(SQLException e){throw new DALException(e);}
	}

	@Override
	public List<ProduktbatchKompDTO> getProduktBatchKompList(int pbId) throws DALException {
		List<ProduktbatchKompDTO> list = new ArrayList<ProduktbatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id="+pbId);
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktbatchKompDTO(rs.getInt("pb_id"),rs.getInt("rb_id"),rs.getDouble("tara"),rs.getDouble("netto"),rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProduktbatchKompDTO> getProduktBatchKompList() throws DALException {
		List<ProduktbatchKompDTO> list = new ArrayList<ProduktbatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktbatchKompDTO(rs.getInt("pb_id"),rs.getInt("rb_id"),rs.getDouble("tara"),rs.getDouble("netto"),rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatchKomp(ProduktbatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate(
				"INSERT INTO produktbatchkomponent(pb_id,rb_id,tara,netto,opr_id) VALUES" +"("+produktbatchkomponent.getPbID()+", '"+produktbatchkomponent.getRbID()+"', '"+produktbatchkomponent.getTara()+"', '"+produktbatchkomponent.getNetto()+"', '"+produktbatchkomponent.getOprID()+"'"
				);
		}

	@Override
	public void updateProduktBatchKomp(ProduktbatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate(
				"UPDATE produktbatch SET  pbId = '" + produktbatchkomponent.getPbID() + "', rb_id =  '" + produktbatchkomponent.getRbID() + 
				"', tara = '" + produktbatchkomponent.getTara() + "', netto='"+produktbatchkomponent.getNetto()+"', opr_id= '"+produktbatchkomponent.getOprID()+ "' WHERE pbId = " +
				produktbatchkomponent.getPbID()
		);
	}

	
}
