package edu.example.server;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;
import edu.example.client.service.ExampleService;
import edu.example.server.database.MySQLOperatoerDAO;
import edu.example.server.database.MySQLRaavareDAO;
import edu.example.server.database.connector.Connector;

public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService
{
	private static final long serialVersionUID = 5550980922485907926L;
	
	//Operators
	private final MySQLOperatoerDAO opDAO = new MySQLOperatoerDAO();
	
	@Override
	public ArrayList<OperatorDTO> getOpList() {
		Connector con = null;
		ArrayList<OperatorDTO> result = null;
		
		try {
			con = new Connector();
			result = new ArrayList<OperatorDTO>(opDAO.getOperatorList());
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		
		return result;
	}

	@Override
	public OperatorDTO getOperator(int oprID) {
		OperatorDTO result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			result = opDAO.getOperator(oprID);
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		
		return result;
	}
	
	@Override
	public boolean createOperator(OperatorDTO opr) {
		boolean result = false;
		Connector con = null;
		
		try {
			con = new Connector();
			opDAO.createOperator(opr);
			result = true;
		}
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		return result;
	}
	
	@Override
	public boolean updateOperator(OperatorDTO opr) {
		boolean result = false;
		Connector con = null;
		
		try {
			con = new Connector();
			opDAO.updateOperator(opr);
			result = true;
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		
		return result;
	}
	
	@Override
	public String getPassword(int oprID) {
		String result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			result = opDAO.getOperator(oprID).getPassword();
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		return result;
	}

	//Raavarer
	private final MySQLRaavareDAO raDAO = new MySQLRaavareDAO();
	
	@Override
	public ArrayList<RaavareDTO> getRaavareList() {
		Connector con = null;
		ArrayList<RaavareDTO> result = null;
		
		try {
			con = new Connector();
			result = new ArrayList<RaavareDTO>(raDAO.getRaavareList());
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		
		return result;
	}

	@Override
	public boolean createRaavare(RaavareDTO raavare) {
		boolean result = false;
		Connector con = null;
		
		try {
			con = new Connector();
			raDAO.createRaavare(raavare);
			result = true;
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		
		return result;
	}

	@Override
	public boolean updateRaavare(RaavareDTO raavare) {
		boolean result = false;
		Connector con = null;
		
		try {
			con = new Connector();
			raDAO.updateRaavare(raavare);
			result = true;
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		
		return result;
	}

	@Override
	public boolean deleteRaavare(RaavareDTO raavare) {
		boolean result = false;
		Connector con = null;
		
		try {
			con = new Connector();
			raDAO.deleteRaavare(raavare);
			result = true;
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
			e.printStackTrace();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		
		return result;
	}
}