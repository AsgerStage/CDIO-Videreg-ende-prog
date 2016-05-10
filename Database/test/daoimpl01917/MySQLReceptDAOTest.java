package daoimpl01917;
import dto01917.ReceptDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MySQLReceptDAOTest
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MySQLReceptDAOTest 
{

    /**
     * Test of getRecept method, of class MySQLReceptDAO.
     */
    @Test
    public void testGetRecept() throws Exception {
        System.out.println("getRecept");
        int receptId = 0;
        MySQLReceptDAO instance = new MySQLReceptDAO();
        ReceptDTO expResult = null;
        ReceptDTO result = instance.getRecept(receptId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReceptList method, of class MySQLReceptDAO.
     */
    @Test
    public void testGetReceptList() throws Exception {
        System.out.println("getReceptList");
        MySQLReceptDAO instance = new MySQLReceptDAO();
        List<ReceptDTO> expResult = null;
        List<ReceptDTO> result = instance.getReceptList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createRecept method, of class MySQLReceptDAO.
     */
    @Test
    public void testCreateRecept() throws Exception {
        System.out.println("createRecept");
        ReceptDTO recept = null;
        MySQLReceptDAO instance = new MySQLReceptDAO();
        instance.createRecept(recept);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecept method, of class MySQLReceptDAO.
     */
    @Test
    public void testUpdateRecept() throws Exception {
        System.out.println("updateRecept");
        ReceptDTO recept = null;
        MySQLReceptDAO instance = new MySQLReceptDAO();
        instance.updateRecept(recept);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}