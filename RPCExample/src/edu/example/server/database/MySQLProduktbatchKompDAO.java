package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ProduktbatchkompDTO;
import edu.example.server.database.connector.Connector;

public class MySQLProduktbatchKompDAO implements ProduktbatchKompDAO
{
	@Override
	public ProduktbatchkompDTO getProduktbatchKomp(int pbId, int rbId) throws DALException {
		try	{
			ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id=" + pbId + " AND rb_id=" + rbId);
			if(!rs.first()) 
				throw new DALException("Produktbatchkomponent" + pbId + " + " + rbId + "Findes ikke");
			return new ProduktbatchkompDTO (rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id"));
		}
		catch(SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<ProduktbatchkompDTO> getProduktbatchKompList() throws DALException {
		List<ProduktbatchkompDTO> list;
		try	{
			list = new ArrayList<ProduktbatchkompDTO>();
			ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
			while (rs.next()) {
				list.add(new ProduktbatchkompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { 
			throw new DALException(e); 
		}
		return list;
	}

	@Override
	public List<ProduktbatchkompDTO> getProduktbatchKompListByRBID(int pbID) throws DALException {
		List<ProduktbatchkompDTO> list;
		try	{
			list = new ArrayList<ProduktbatchkompDTO>();
			ResultSet rs = Connector.doQuery("CALL `get_pbkompByPbID`(?)", pbID);
			while (rs.next()) {
				list.add(new ProduktbatchkompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { 
			throw new DALException(e); 
		}
		return list;
	}

	@Override
	public int createProduktbatchKomp(ProduktbatchkompDTO produktbatchKomp) throws DALException {
		return Connector.doUpdate("CALL `create_pbKomp`(?, ?, ?, ?, ?)",
				produktbatchKomp.getPbID(), produktbatchKomp.getRbID(), produktbatchKomp.getTara(), produktbatchKomp.getNetto(), produktbatchKomp.getOprID());
		}

	@Override
	public int updateProduktbatchKomp(ProduktbatchkompDTO produktbatchKomp) throws DALException {
		return Connector.doUpdate("CALL `update_pbKomp`(?, ?, ?, ?, ?)",
				produktbatchKomp.getPbID(), produktbatchKomp.getRbID(), produktbatchKomp.getTara(), produktbatchKomp.getNetto(), produktbatchKomp.getOprID());
	}

	@Override
	public int deleteProduktbatchKomp(int pbID, int rbID) throws DALException {
		return Connector.doUpdate("CALL `delete_pbKomp`(?, ?)",
				pbID, rbID);
	}
}