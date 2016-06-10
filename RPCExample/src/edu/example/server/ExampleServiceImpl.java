package edu.example.server;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.OperatorDTO;
import edu.example.client.models.RaavareDTO;
import edu.example.client.models.ReceptDTO;
import edu.example.client.service.ExampleService;
import edu.example.server.database.MySQLOperatoerDAO;
import edu.example.server.database.MySQLRaavareDAO;
import edu.example.server.database.MySQLReceptDAO;
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
		System.err.println("ID = " + oprID);
		OperatorDTO result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			result = opDAO.getOperator(oprID);
			System.err.println("Result = " + result.toString());
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
	public String createRaavare(RaavareDTO raavare) {
		String result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			raDAO.createRaavare(raavare);
			result = "R�vare " + raavare.toString() + " blev oprettet";
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			result = "R�vare " + raavare.toString() + " kunne ikke oprettes: " + e.getMessage();
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
	public String updateRaavare(RaavareDTO raavare) {
		String result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			raDAO.updateRaavare(raavare);
			result = "R�vare " + raavare.getRaavareID() + " blev opateret";
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			result = "R�vare " + raavare.getRaavareID() + " kunne ikke opdateres: " + e.getMessage();
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
	public String deleteRaavare(int raavareID) {
		String result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			raDAO.deleteRaavare(raavareID);
			result = "R�varen " + raavareID + " blev slettet";
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
			e.printStackTrace();
			result = "R�varen " + raavareID + " kunne ikke slettes: " + e.getMessage();
		}
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
		
		return result;
	}
	
	//Recepter
private final MySQLReceptDAO receptDAO = new MySQLReceptDAO();
	
	@Override
	public ArrayList<ReceptDTO> getReceptList() {
		Connector con = null;
		ArrayList<ReceptDTO> result = null;
		
		try {
			con = new Connector();
			result = new ArrayList<ReceptDTO>(receptDAO.getReceptList());
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
	public String createRecept(ReceptDTO recept) {
		String result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			receptDAO.createRecept(recept);
			result = "Recept " + recept.toString() + " blev oprettet";
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			result = "Recept " + recept.toString() + " kunne ikke oprettes: " + e.getMessage();
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
	public String updateRecept(ReceptDTO recept) {
		String result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			receptDAO.updateRecept(recept);
			result = "Recepten " + recept.getReceptId() + " blev opateret";
		} 
		catch (DALException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			result = "Recepten " + recept.getReceptId() + " kunne ikke opdateres: " + e.getMessage();
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
	public String deleteRecept(int receptID) {
		String result = null;
		Connector con = null;
		
		try {
			con = new Connector();
			receptDAO.deleteRecept(receptID);
			result = "Recepten " + receptID + " blev slettet";
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
			e.printStackTrace();
			result = "Recepten " + receptID + " kunne ikke slettes: " + e.getMessage();
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