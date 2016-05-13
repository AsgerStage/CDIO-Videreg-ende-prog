package daoimpl01917;
import connector01917.Connector;
import daointerfaces01917.DALException;
import dto01917.RaavareBatchDTO;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

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
        int raavareId = 4;
        
        try {
            con = new Connector();
            instance = new MySQLRaavareBatchDAO();
            result = instance.getRaavareBatch(raavareId);
            expResult = new RaavareBatchDTO(raavareId, 5, 100);
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
    @Ignore
    public void testCreateRaavareBatch() throws Exception {
        System.out.println("createRaavareBatch");
        RaavareBatchDTO raavarebatch = null;
        MySQLRaavareBatchDAO instance = new MySQLRaavareBatchDAO();
        instance.createRaavareBatch(raavarebatch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRaavareBatch method, of class MySQLRaavareBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
    public void testUpdateRaavareBatch() throws Exception {
        System.out.println("updateRaavareBatch");
        RaavareBatchDTO raavarebatch = null;
        MySQLRaavareBatchDAO instance = new MySQLRaavareBatchDAO();
        instance.updateRaavareBatch(raavarebatch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaavareBatchList method, of class MySQLRaavareBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
    public void testGetRaavareBatchList_0args() throws Exception {
        System.out.println("getRaavareBatchList");
        MySQLRaavareBatchDAO instance = new MySQLRaavareBatchDAO();
        List<RaavareBatchDTO> expResult = null;
        List<RaavareBatchDTO> result = instance.getRaavareBatchList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaavareBatchList method, of class MySQLRaavareBatchDAO.
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
    public void testGetRaavareBatchList_int() throws Exception {
        System.out.println("getRaavareBatchList");
        int raavareId = 0;
        MySQLRaavareBatchDAO instance = new MySQLRaavareBatchDAO();
        List<RaavareBatchDTO> expResult = null;
        List<RaavareBatchDTO> result = instance.getRaavareBatchList(raavareId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}