package cdio.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import dto01917.RaavareDTO;

public class MySQLRaavareDAO implements RaavareDAO {
	@Override
	public RaavareDTO getRaavare(int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM raavare WHERE raavareId = " + raavareId);
	    try {
	    	if (!rs.first()) throw new DALException("raavaren " + raavareId + " findes ikke");
	    	return new RaavareDTO (rs.getInt("raavareId"), rs.getString("raavareNavn"), rs.getString("leverandoer"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}

	@Override
	public List<RaavareDTO> getRaavareList() throws DALException {
		List<RaavareDTO> list = new ArrayList<RaavareDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM raavare");
		try {
			while (rs.next()) {
				list.add(new RaavareDTO(rs.getInt("raavareId"), rs.getString("raavareNavn"),
						rs.getString("leverandoer")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public void createRaavare(RaavareDTO raavare) throws DALException{		
			Connector.doUpdate(
				"INSERT INTO raavare(raavareId, raavareNavn, leverandoer) VALUES " +
				"(" + raavare.getRaavareId() + ", '" + raavare.getRaavareNavn() + "', '" + raavare.getLeverandoer() + "',)"
			);
	}

	@Override
	public void updateRaavare(RaavareDTO raavare) throws DALException {
		Connector.doUpdate("UPDATE ravaare SET  raavareNavn = '" + raavare.getRaavareNavn() + "', leverandoer =  '"
				+ raavare.getLeverandoer() + "', WHERE raavareId = " + raavare.getRaavareId());
	}

}
