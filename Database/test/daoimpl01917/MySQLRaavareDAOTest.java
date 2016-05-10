package daoimpl01917;
import dto01917.RaavareDTO;
import java.util.List;
import org.junit.Test;
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
        int raavareId = 0;
        MySQLRaavareDAO instance = new MySQLRaavareDAO();
        RaavareDTO expResult = null;
        RaavareDTO result = instance.getRaavare(raavareId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaavareList method, of class MySQLRaavareDAO.
     */
    @Test
    public void testGetRaavareList() throws Exception {
        System.out.println("getRaavareList");
        MySQLRaavareDAO instance = new MySQLRaavareDAO();
        List<RaavareDTO> expResult = null;
        List<RaavareDTO> result = instance.getRaavareList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createRaavare method, of class MySQLRaavareDAO.
     */
    @Test
    public void testCreateRaavare() throws Exception {
        System.out.println("createRaavare");
        RaavareDTO raavare = null;
        MySQLRaavareDAO instance = new MySQLRaavareDAO();
        instance.createRaavare(raavare);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRaavare method, of class MySQLRaavareDAO.
     */
    @Test
    public void testUpdateRaavare() throws Exception {
        System.out.println("updateRaavare");
        RaavareDTO raavare = null;
        MySQLRaavareDAO instance = new MySQLRaavareDAO();
        instance.updateRaavare(raavare);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}