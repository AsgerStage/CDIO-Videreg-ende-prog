package daoimpl01917;
import dto01917.ProduktBatchKompDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MySQLProduktBatchKompDAOTest
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MySQLProduktBatchKompDAOTest 
{

    /**
     * Test of getProduktBatchKomp method, of class MySQLProduktBatchKompDAO.
     */
    @Test
    public void testGetProduktBatchKomp() throws Exception {
        System.out.println("getProduktBatchKomp");
        int pbId = 0;
        int rbId = 0;
        MySQLProduktBatchKompDAO instance = new MySQLProduktBatchKompDAO();
        ProduktBatchKompDTO expResult = null;
        ProduktBatchKompDTO result = instance.getProduktBatchKomp(pbId, rbId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduktBatchKompList method, of class MySQLProduktBatchKompDAO.
     */
    @Test
    public void testGetProduktBatchKompList_int() throws Exception {
        System.out.println("getProduktBatchKompList");
        int pbId = 0;
        MySQLProduktBatchKompDAO instance = new MySQLProduktBatchKompDAO();
        List<ProduktBatchKompDTO> expResult = null;
        List<ProduktBatchKompDTO> result = instance.getProduktBatchKompList(pbId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduktBatchKompList method, of class MySQLProduktBatchKompDAO.
     */
    @Test
    public void testGetProduktBatchKompList_0args() throws Exception {
        System.out.println("getProduktBatchKompList");
        MySQLProduktBatchKompDAO instance = new MySQLProduktBatchKompDAO();
        List<ProduktBatchKompDTO> expResult = null;
        List<ProduktBatchKompDTO> result = instance.getProduktBatchKompList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProduktBatchKomp method, of class MySQLProduktBatchKompDAO.
     */
    @Test
    public void testCreateProduktBatchKomp() throws Exception {
        System.out.println("createProduktBatchKomp");
        ProduktBatchKompDTO produktbatchkomponent = null;
        MySQLProduktBatchKompDAO instance = new MySQLProduktBatchKompDAO();
        instance.createProduktBatchKomp(produktbatchkomponent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProduktBatchKomp method, of class MySQLProduktBatchKompDAO.
     */
    @Test
    public void testUpdateProduktBatchKomp() throws Exception {
        System.out.println("updateProduktBatchKomp");
        ProduktBatchKompDTO produktbatchkomponent = null;
        MySQLProduktBatchKompDAO instance = new MySQLProduktBatchKompDAO();
        instance.updateProduktBatchKomp(produktbatchkomponent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}