package daoimpl01917;
import dto01917.RaavareBatchDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MySQLRaavareBatchDAOTest
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MySQLRaavareBatchDAOTest 
{

    /**
     * Test of getRaavareBatch method, of class MySQLRaavareBatchDAO.
     */
    @Test
    public void testGetRaavareBatch() throws Exception {
        System.out.println("getRaavareBatch");
        int raavareId = 0;
        MySQLRaavareBatchDAO instance = new MySQLRaavareBatchDAO();
        RaavareBatchDTO expResult = null;
        RaavareBatchDTO result = instance.getRaavareBatch(raavareId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createRaavareBatch method, of class MySQLRaavareBatchDAO.
     */
    @Test
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
     */
    @Test
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
     */
    @Test
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
     */
    @Test
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