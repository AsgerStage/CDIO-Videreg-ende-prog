package daoimpl01917;
import connector01917.Connector;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MySQLProduktBatchDAOTest
 * @author Lasse Holm Nielsen
 * @version 10-05-2016
 */
public class MySQLProduktBatchDAOTest 
{

    /**
     * Test of getProduktBatch method, of class MySQLProduktBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProduktBatch() throws Exception {
        System.out.println("getProduktBatch");
        MySQLProduktBatchDAO instance;
        Connector con = null;
        ProduktBatchDTO expResult, result;
        int pbId = 4;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchDAO();
            result = instance.getProduktBatch(pbId);
            expResult = new ProduktBatchDTO(pbId, 1, 3);
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
     * Test of getProduktBatchList method, of class MySQLProduktBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProduktBatchList() throws Exception {
        System.out.println("getProduktBatchList");
        MySQLProduktBatchDAO instance;
        Connector con = null;
        List<ProduktBatchDTO> result;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchDAO();
            result = instance.getProduktBatchList();
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
        assertTrue(result.size() >= 5);
        for(ProduktBatchDTO pbkDTO : result) {
            assertFalse(pbkDTO == null);
        }
    }

    /**
     * Test of createProduktBatch method, of class MySQLProduktBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateProduktBatch() throws Exception {
        System.out.println("createProduktBatch");
        MySQLProduktBatchDAO instance;
        Connector con = null;
        int pbId = 6;
        ProduktBatchDTO expResult = new ProduktBatchDTO(pbId, 1, 2);
        ProduktBatchDTO result;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchDAO();
            instance.createProduktBatch(expResult);
            result = instance.getProduktBatch(pbId);
            
            assertEquals(expResult, result);
            
            instance.deleteProduktBatch(pbId);
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
    }

    /**
     * Test of updateProduktBatch method, of class MySQLProduktBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateProduktBatch() throws Exception {
        System.out.println("updateProduktBatch");
        MySQLProduktBatchDAO instance;
        Connector con = null;
        int pbId = 7;
        ProduktBatchDTO expResult = new ProduktBatchDTO(pbId, 0, 3);
        ProduktBatchDTO result;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchDAO();
            instance.createProduktBatch(new ProduktBatchDTO(pbId, 2, 1));
            instance.updateProduktBatch(expResult);
            result = instance.getProduktBatch(pbId);
            
            assertEquals(expResult, result);
            
            instance.deleteProduktBatch(pbId);
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
    }
}