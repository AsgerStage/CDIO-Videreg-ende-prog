/**
 * 
 */
package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.ReceptkompDTO;
import edu.example.server.database.connector.Connector;

public class MYSQLReceptkompDAO implements ReceptkompDAO
{
	@Override
	public ReceptkompDTO getReceptkomp(int receptID, int raavareID) throws DALException {
		try	{ 
			ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id = " + receptID + " AND raavare_id = " + raavareID);
			if(!rs.first()) 
				throw new DALException("Recept komponent" + receptID + "Findes ikke");
			return new ReceptkompDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance"));
		}
		catch(SQLException e){ 
			throw new DALException(e); 
		}
	}

	@Override
	public List<ReceptkompDTO> getReceptkompList() throws DALException {
		List<ReceptkompDTO> list;
		try	{
			list = new ArrayList<ReceptkompDTO>();
			ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
			while (rs.next()) {
				list.add(new ReceptkompDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { 
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public List<ReceptkompDTO> getReceptkompListByReceptID(int receptID) throws DALException {
		List<ReceptkompDTO> list;
		try	{
			list = new ArrayList<ReceptkompDTO>();
			ResultSet rs = Connector.doQuery("CALL `get_receptkompByReceptID`(?)", receptID);
			while (rs.next()) {
				list.add(new ReceptkompDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { 
			throw new DALException(e); 
		}
		return list;
	}

	@Override
	public int createReceptkomp(ReceptkompDTO receptkomp) throws DALException {
		return Connector.doUpdate("CALL `create_receptkomp`(?, ?, ?, ?)",
				receptkomp.getReceptID(), receptkomp.getRaavareID(), receptkomp.getNomNetto(), receptkomp.getTolerance());
	}

	@Override
	public int updateReceptkomp(ReceptkompDTO receptkomp) throws DALException {
		return Connector.doUpdate("CALL `update_receptkomp`(?, ?, ?, ?)",
				receptkomp.getReceptID(), receptkomp.getRaavareID(), receptkomp.getNomNetto(), receptkomp.getTolerance());
	}

	@Override
	public int deleteReceptkomp(int receptID, int raavareID) throws DALException {
		return Connector.doUpdate("CALL `delete_receptkomp`(?, ?)",
				receptID, raavareID);
	}
}