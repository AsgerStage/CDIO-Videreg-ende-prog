package daoimpl01917;
import connector01917.Connector;
import daointerfaces01917.DALException;
import dto01917.RaavareBatchDTO;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MySQLRaavareBatchDAOTest
 * @author Lasse H Nielsen
 * @version 10-05-2016
 */
public class MySQLRaavareBatchDAOTest 
{

    /**
     * Test of getRaavareBatch method, of class MySQLRaavareBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRaavareBatch() throws Exception {
        System.out.println("getRaavareBatch");
        MySQLRaavareBatchDAO instance;
        Connector con = null;
        RaavareBatchDTO expResult, result;
        int rb_id = 4;
        
        try {
            con = new Connector();
            instance = new MySQLRaavareBatchDAO();
            result = instance.getRaavareBatch(rb_id);
            expResult = new RaavareBatchDTO(rb_id, 5, 100);
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
     * Test of createRaavareBatch method, of class MySQLRaavareBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateRaavareBatch() throws Exception {
        System.out.println("createRaavareBatch");
        MySQLRaavareBatchDAO instance;
        Connector con = null;
        int rb_id = 9;
        RaavareBatchDTO expResult = new RaavareBatchDTO(rb_id, 6, 999);
        RaavareBatchDTO result;
        
        try {
            con = new Connector();
            instance = new MySQLRaavareBatchDAO();
            instance.createRaavareBatch(expResult);
            result = instance.getRaavareBatch(rb_id);
            
            assertEquals(expResult, result);
            
            instance.deleteRaavareBatch(rb_id);
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
     * Test of updateRaavareBatch method, of class MySQLRaavareBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateRaavareBatch() throws Exception {
        System.out.println("updateRaavareBatch");
        MySQLRaavareBatchDAO instance;
        Connector con = null;
        int rb_id = 8;
        RaavareBatchDTO expResult = new RaavareBatchDTO(rb_id, 7, 888);
        RaavareBatchDTO result;
        
        try {
            con = new Connector();
            instance = new MySQLRaavareBatchDAO();
            instance.createRaavareBatch(new RaavareBatchDTO(rb_id, 4, 444));
            instance.updateRaavareBatch(expResult);
            result = instance.getRaavareBatch(rb_id);
            
            assertEquals(expResult, result);
            
            instance.deleteRaavareBatch(rb_id);
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
     * Test of getRaavareBatchList method, of class MySQLRaavareBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRaavareBatchList() throws Exception {
        System.out.println("getRaavareBatchList");
        MySQLRaavareBatchDAO instance;
        Connector con = null;
        List<RaavareBatchDTO> result = null;
        
        try {
            con = new Connector();
            instance = new MySQLRaavareBatchDAO();
            result = instance.getRaavareBatchList();
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
        assertTrue(result.size() >= 7);
        for (RaavareBatchDTO pbkDTO : result) {
            assertFalse(pbkDTO == null);
        }
        result.contains(new RaavareBatchDTO(1, 1, 1000));
        result.contains(new RaavareBatchDTO(4, 5, 100));
        result.contains(new RaavareBatchDTO(7, 7, 100));
    }

    /**
     * Test of getRaavareBatchList method, of class MySQLRaavareBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRaavareBatchList_int() throws Exception {
        System.out.println("getRaavareBatchList");
        MySQLRaavareBatchDAO instance;
        Connector con = null;
        List<RaavareBatchDTO> result = null;
        int raavareId = 5;
        
        try {
            con = new Connector();
            instance = new MySQLRaavareBatchDAO();
            result = instance.getRaavareBatchList(raavareId);
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
        assertTrue(result.size() >= 2);
        for (RaavareBatchDTO pbkDTO : result) {
            assertFalse(pbkDTO == null);
        }
        result.contains(new RaavareBatchDTO(4, raavareId, 100));
        result.contains(new RaavareBatchDTO(5, raavareId, 100));
    }
}