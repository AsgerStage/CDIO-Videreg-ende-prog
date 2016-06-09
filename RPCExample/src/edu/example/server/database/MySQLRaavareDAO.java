package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.RaavareDTO;
import edu.example.server.database.connector.Connector;

public class MySQLRaavareDAO implements RaavareDAO 
{
	@Override
	public RaavareDTO getRaavare(int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM raavare WHERE raavare_id = " + raavareId);
	    try {
	    	if (!rs.first()) throw new DALException("raavaren " + raavareId + " findes ikke");
	    	return new RaavareDTO (rs.getInt("raavare_id"), rs.getString("raavare_navn"), rs.getString("leverandoer"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<RaavareDTO> getRaavareList() throws DALException {
		List<RaavareDTO> list ;
		
		try {
			list = new ArrayList<RaavareDTO>();
			ResultSet rs = Connector.doQuery("CALL get_raavarer()");
		
			while (rs.next()) {
				list.add(new RaavareDTO(rs.getInt("raavare_id"), rs.getString("raavare_navn"), rs.getString("leverandoer")));
			}
		} 
		catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public void createRaavare(RaavareDTO raavare) throws DALException {	
		Connector.doUpdate("CALL create_raavare(?, ?, ?)", 
				raavare.getRaavareID(), raavare.getRaavareNavn(), raavare.getLeverandoer());
	}

	@Override
	public void updateRaavare(RaavareDTO raavare) throws DALException {
		System.out.println(raavare.getRaavareNavn());
		System.out.println(raavare.getLeverandoer());
		System.out.println(raavare.getRaavareID());
		Connector.doUpdate("CALL `update_raavare`(?, ?, ?)",
				raavare.getRaavareID(), raavare.getRaavareNavn(), raavare.getLeverandoer());
	}

	public void deleteRaavare(int raavareID) throws DALException {
		Connector.doUpdate("CALL `delete_raavare`(?)", 
				raavareID);
	}
}
