package daoimpl01917;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import connector01917.Connector;
import daointerfaces01917.DALException;

import static org.junit.Assert.*;

/**
 * MySQLRaavareDAOTest
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MySQLRaavareDAOTest 
{

    /**
     * Test of getRaavare method, of class MySQLRaavareDAO.
     */
    @Test
    public void testGetRaavare() throws Exception {
        System.out.println("getRaavare");
        
        int raavareId = 1;
        String raavareNavn = "dej";
        String leverandoer = "Wawelka";

		MySQLRaavareDAO instance;
		RaavareDTO expResult, result;

		Connector con = null;

		try {
			con = new Connector();
			instance = new MySQLRaavareDAO();
			result = instance.getRaavare(raavareId);
			expResult = new RaavareDTO(raavareId, raavareNavn, leverandoer);
		}

		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException
				| DALException e) {
			System.err.println(e);
			throw e;
		} finally {
			if (con != null)
				try {
					con.closeConnection();
				} catch (SQLException e) {
				}
		}
		assertEquals(expResult, result);

	}
    

    /**
     * Test of getRaavareList method, of class MySQLRaavareDAO.
     */
    @Test
    public void testGetRaavareList_int() throws Exception {
        System.out.println("getRaavareList");
        int raavareId = 1;
        String raavareNavn = "dej";
        String leverandoer = "Wawelka";
        MySQLRaavareDAO instance;
        Connector con = null;
        RaavareDTO expResult, result;
        try {
            con = new Connector();
            instance = new MySQLRaavareDAO();
            result = instance.getRaavareList().get(0);
            expResult = new RaavareDTO(raavareId, raavareNavn, leverandoer);
        } 
        
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
        assertEquals(expResult, result);
    }
    @Test
    public void testGetRaavareList_0args() throws Exception {
        System.out.println("getRaavareListarg");

        MySQLRaavareDAO instance;
        Connector con = null;
        List<RaavareDTO> result = null;
        
        try {
            con = new Connector();
            instance = new MySQLRaavareDAO();
            result = instance.getRaavareList();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
        
        assertFalse(result == null);
        assertTrue(result.size() >= 3);
        for (RaavareDTO rvDTO : result) {
            assertFalse(rvDTO == null);
        }
    }

    /**
     * Test of createRaavare method, of class MySQLRaavareDAO.
     */
    @Test
    public void testCreateRaavare() throws Exception {
        System.out.println("createRaavare");
        
        MySQLRaavareDAO instance;
		RaavareDTO expResult, result;
		int raavareId = 45;
		String raavareNavn = "Test";
		String leverandoer = "leverandoer";
		Connector con = null;
		
		
		try {
			con = new Connector();
			instance = new MySQLRaavareDAO();
			expResult = new RaavareDTO(raavareId, raavareNavn, leverandoer);
            instance.createRaavare(expResult);
            
			result = instance.getRaavare(raavareId);
			instance.deleteRaavare(raavareId);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException
				| DALException e) {
			System.err.println(e);
			throw e;
		} finally {
			if (con != null)
				try {
					con.closeConnection();
				} catch (SQLException e) {
				}
		}

		assertEquals(expResult, result);
	}

    /**
     * Test of updateRaavare method, of class MySQLRaavareDAO.
     */
    @Test
    public void testUpdateRaavare() throws Exception {
        System.out.println("updateRaavare");
        
        MySQLRaavareDAO instance;
		Connector con = null;
	
    	int raavareId = 78;
        String raavareNavn = "test";
        String leverandoer = "testleverandoer";
        

        RaavareDTO expResult, result;
        expResult = new RaavareDTO(raavareId,"updatedtest", "updatedtestleverandoer");
        result=null;
        try {
            con = new Connector();
            instance = new MySQLRaavareDAO();    
            instance.createRaavare(new RaavareDTO(raavareId, raavareNavn, leverandoer));
            instance.updateRaavare(expResult);
            result = instance.getRaavare(raavareId);
            instance.deleteRaavare(raavareId);
            
        } 
        
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
        assertEquals(expResult, result);
}
}