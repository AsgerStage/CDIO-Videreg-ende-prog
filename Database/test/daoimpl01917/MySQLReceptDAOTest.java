package daoimpl01917;



import dto01917.OperatoerDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test; 
import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptDAO;

import static org.junit.Assert.*;

/**
 * MySQLReceptDAOTest
 * 
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MySQLReceptDAOTest {

	/**
	 * Test of getRecept method, of class MySQLReceptDAO.
	 */
	@Test
	public void testGetRecept() throws Exception {
		System.out.println("getRecept");
		int receptId = 1;
		MySQLReceptDAO instance;
		ReceptDTO expResult;
		ReceptDTO result;
		//assertEquals(expResult, result);
		Connector con = null;
		// TODO review the generated test code and remove the default call to
		// fail.
		// fail("The test case is a prototype.");

		try {
			con = new Connector();
			instance = new MySQLReceptDAO();
			result = instance.getRecept(receptId);
			expResult = new ReceptDTO(receptId, "margherita");
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
	 * Test of getReceptList method, of class MySQLReceptDAO.
	 */
	@Test
	public void testGetReceptList_int() throws Exception {
		System.out.println("getReceptList");
		
		int receptId = 1;
        String receptNavn = "margherita";
        MySQLReceptDAO instance;
        Connector con = null;
        ReceptDTO expResult, result;
        try {
            con = new Connector();
            instance = new MySQLReceptDAO();
            result = instance.getReceptList().get(0);
            expResult = new ReceptDTO(receptId,receptNavn);
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
    public void testGetReceptList_0args() throws Exception {
        System.out.println("getReceptListarg");

        MySQLReceptDAO instance;
        Connector con = null;
        List<ReceptDTO> result = null;
        
        try {
            con = new Connector();
            instance = new MySQLReceptDAO();
            result = instance.getReceptList();
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
        for (ReceptDTO rDTO : result) {
            assertFalse(rDTO == null);
        }
    }
	/**
	 * Test of createRecept method, of class MySQLReceptDAO.
	 */
	@Test
	public void testCreateRecept() throws Exception {
		System.out.println("createRecept");
		
		MySQLReceptDAO instance;
		ReceptDTO expResult, result;
		int receptId = 45;
		String receptNavn = "Test";
		Connector con = null;
		
		
		try {
			con = new Connector();
			instance = new MySQLReceptDAO();
			expResult = new ReceptDTO(receptId, receptNavn);
            instance.createRecept(expResult);
            
			result = instance.getRecept(receptId);
			instance.deleteRecept(receptId);
			
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
	 * Test of updateRecept method, of class MySQLReceptDAO.
	 */
	@Test
	public void testUpdateRecept() throws Exception {
		System.out.println("updateRecept");
		

		MySQLReceptDAO instance;
		Connector con = null;
	
		
		
		// TODO review the generated test code and remove the default call to
		// fail.

		int receptId = 55;
		String receptNavn = "sjovpizza";
		ReceptDTO expResult = new ReceptDTO(receptId, receptNavn);
		ReceptDTO result;

		try {
			con = new Connector();
			instance = new MySQLReceptDAO();
			instance.createRecept(new ReceptDTO(receptId, receptNavn));
			instance.updateRecept(expResult);
			result = instance.getRecept(receptId);
			instance.deleteRecept(receptId);
			
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

}
