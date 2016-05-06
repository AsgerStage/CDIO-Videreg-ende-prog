package edu.example.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.example.server.database.connector.Connector;
import edu.example.client.exceptions.DALException;
import edu.example.client.exceptions.OpIdException;
import edu.example.client.exceptions.OpNameException;
import edu.example.client.exceptions.OpPasswordException;
import edu.example.client.models.OperatorDTO;


public class MySQLOperatoerDAO implements OperatoerDAO
{
	@Override
	public OperatorDTO getOperator(int oprId) {//throws DALException {
	    try {
			new Connector("nasie.diskstation.me", 3306, "DTU", "DTU", "Gruppe16");
			ResultSet rs = Connector.doQuery("SELECT * FROM operatoer WHERE opr_id = " + oprId);
			
	    	if (!rs.first()) 
	    		throw new DALException("Operatoeren " + oprId + " findes ikke");
	    	
	    	return new OperatorDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
	    }
//	    catch (SQLException e)  {throw new DALException(e); }
	    catch (SQLException | OpNameException | OpIdException | OpPasswordException | InstantiationException | IllegalAccessException | ClassNotFoundException | DALException e) {
	    	e.printStackTrace();
	    	return null;
//	    	throw new DALException(e); 
	    }
		
	}
	
	@Override
	public void createOperator(OperatorDTO opr) throws DALException {		
			Connector.doUpdate(
				"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password) VALUES " +
				"(" + opr.getOprID() + ", '" + opr.getName() + "', '" + opr.getIni() + "', '" + 
				opr.getCpr() + "', '" + opr.getPassword() + "')"
			);
	}
	
	@Override
	public void updateOperator(OperatorDTO opr) throws DALException {
		Connector.doUpdate(
			"UPDATE operatoer SET  opr_navn = '" + opr.getName() + "', ini =  '" + opr.getIni() + 
			"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "' WHERE opr_id = " +
			opr.getOprID()
		);
	}
	
	@Override
	public List<OperatorDTO> getOperatorList() throws DALException {
		List<OperatorDTO> list = new ArrayList<OperatorDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM operatoer");
		try
		{
			while (rs.next()) 
			{
				list.add(new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password")));
			}
		}
//		catch (SQLException e) { throw new DALException(e); }
		catch (SQLException | OpNameException | OpIdException | OpPasswordException e) { throw new DALException(e); }
		return list;
	}
}