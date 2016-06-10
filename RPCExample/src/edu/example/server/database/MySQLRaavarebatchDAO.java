package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.RaavareDTO;
import edu.example.client.models.RaavarebatchDTO;
import edu.example.server.database.connector.Connector;

public class MySQLRaavarebatchDAO implements RaavarebatchDAO 
{	
	@Override
	public RaavarebatchDTO getRaavarebatch(int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE raavare_id = " + raavareId);
	    try {
	    	if (!rs.first()) throw new DALException("RaavareBatch " + raavareId + " findes ikke");
			return new RaavarebatchDTO(rs.getInt("rb_id"), new RaavareDTO(rs.getInt("raavare_id"), rs.getString("raavare_navn"), rs.getString("leverandoer")), rs.getDouble("maengde"));
	    }
	    catch (SQLException e) {
	    	throw new DALException(e); 
	    }
	}
	
	@Override
	public List<RaavarebatchDTO> getRaavarebatchlist() throws DALException {
		List<RaavarebatchDTO> list;
		try	{
			list = new ArrayList<RaavarebatchDTO>();
			ResultSet rs = Connector.doQuery("CALL `get_raavarebatchlist`()");
			
			while (rs.next()) {
				list.add(new RaavarebatchDTO(rs.getInt("rbId"), new RaavareDTO(rs.getInt("raavare_id"), rs.getString("raavare_navn"), rs.getString("leverandoer")), rs.getDouble("maengde")));
			}
		}
		catch (SQLException e) { 
			throw new DALException(e); 
		}
		return list;
	}
	
	@Override
	public void createRaavarebatch(RaavarebatchDTO raavarebatch) throws DALException {		
		Connector.doUpdate("CALL `DTU`.`create_raavarebatch`(<{IN rb_id_in INT(9)}>, <{raavare_id_in INT(9)}>, <{IN maengde DOUBLE}>) ",
				raavarebatch.getRbID(), raavarebatch.getRaavare().getRaavareID(), raavarebatch.getMaengde());
	}
	
	@Override
	public void updateRaavarebatch(RaavarebatchDTO raavarebatch) throws DALException {
		Connector.doUpdate("CALL `update_raavarebatch`(?, ?, ?)",
				raavarebatch.getRbID(), raavarebatch.getRaavare().getRaavareID(), raavarebatch.getMaengde());
	}

	@Override
	public void deleteRaavarebatch(int raavareId) throws DALException {
		Connector.doUpdate("CALL `delete_raavarebatch`(?)",
				raavareId);
	}
}