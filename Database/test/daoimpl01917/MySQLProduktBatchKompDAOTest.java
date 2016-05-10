package daoimpl01917;
import connector01917.Connector;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MySQLProduktBatchKompDAOTest
 * @author Lasse Holm Nielsen
 * @version 10-05-2016
 */
public class MySQLProduktBatchKompDAOTest 
{
    /**
     * Test of getProduktBatchKomp method, of class MySQLProduktBatchKompDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProduktBatchKomp() throws Exception {
        System.out.println("getProduktBatchKomp");
        MySQLProduktBatchKompDAO instance;
        Connector con = null;
        ProduktBatchKompDTO result = null, expResult = null;
        int pbId = 2;
        int rbId = 5;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchKompDAO();
            result = instance.getProduktBatchKomp(pbId, rbId);
            expResult = new ProduktBatchKompDTO(2, 5, 0.5, 1.47, 2);
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

    /**
     * Test of getProduktBatchKompList method, of class MySQLProduktBatchKompDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProduktBatchKompList_int() throws Exception {
        System.out.println("getProduktBatchKompList");
        MySQLProduktBatchKompDAO instance;
        Connector con = null;
        List<ProduktBatchKompDTO> expResult = null, result = null;
        int pbId = 3;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchKompDAO();
            result = instance.getProduktBatchKompList(pbId);
            
            expResult = new ArrayList<>();
            expResult.add(new ProduktBatchKompDTO(pbId, 1, 0.5, 10.07, 1));
            expResult.add(new ProduktBatchKompDTO(pbId, 3, 0.5, 2.06, 2));
            expResult.add(new ProduktBatchKompDTO(pbId, 4, 0.5, 1.55, 1));
            expResult.add(new ProduktBatchKompDTO(pbId, 6, 0.5, 1.53, 2));
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

    /**
     * Test of getProduktBatchKompList method, of class MySQLProduktBatchKompDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProduktBatchKompList_0args() throws Exception {
        System.out.println("getProduktBatchKompList");
        MySQLProduktBatchKompDAO instance;
        Connector con = null;
        List<ProduktBatchKompDTO> result = null;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchKompDAO();
            result = instance.getProduktBatchKompList();
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
        assertTrue(result.size() >= 14);
        for (ProduktBatchKompDTO pbkDTO : result) {
            assertFalse(pbkDTO == null);
        }
    }

    /**
     * Test of createProduktBatchKomp method, of class MySQLProduktBatchKompDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateProduktBatchKomp() throws Exception {
        System.out.println("createProduktBatchKomp");
        MySQLProduktBatchKompDAO instance;
        Connector con = null;
        int pbId = 1;
        int rbId = 3;
        ProduktBatchKompDTO expResult = new ProduktBatchKompDTO(pbId, rbId, 99.99, 9.99, 25);
        ProduktBatchKompDTO result = null;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchKompDAO();
            instance.createProduktBatchKomp(expResult);
            result = instance.getProduktBatchKomp(pbId, rbId);
            
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

    /**
     * Test of updateProduktBatchKomp method, of class MySQLProduktBatchKompDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateProduktBatchKomp() throws Exception {
        System.out.println("updateProduktBatchKomp");
        MySQLProduktBatchKompDAO instance;
        Connector con = null;
        int pbId = 2;
        int rbId = 3;
        ProduktBatchKompDTO expResult = new ProduktBatchKompDTO(pbId, rbId, 11.11, 1.11, 25);
        ProduktBatchKompDTO result = null;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchKompDAO();
            instance.createProduktBatchKomp(new ProduktBatchKompDTO(pbId, rbId, 22.22, 2.22, 1));
            instance.updateProduktBatchKomp(expResult);
            result = instance.getProduktBatchKomp(pbId, rbId);
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