package daoimpl01917;
import dto01917.ProduktBatchDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MYSQLProduktBatchDAOTest
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MYSQLProduktBatchDAOTest 
{

    /**
     * Test of getProduktBatch method, of class MYSQLProduktBatchDAO.
     */
    @Test
    public void testGetProduktBatch() throws Exception {
        System.out.println("getProduktBatch");
        int pbId = 0;
        MYSQLProduktBatchDAO instance = new MYSQLProduktBatchDAO();
        ProduktBatchDTO expResult = null;
        ProduktBatchDTO result = instance.getProduktBatch(pbId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduktBatchList method, of class MYSQLProduktBatchDAO.
     */
    @Test
    public void testGetProduktBatchList() throws Exception {
        System.out.println("getProduktBatchList");
        MYSQLProduktBatchDAO instance = new MYSQLProduktBatchDAO();
        List<ProduktBatchDTO> expResult = null;
        List<ProduktBatchDTO> result = instance.getProduktBatchList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProduktBatch method, of class MYSQLProduktBatchDAO.
     */
    @Test
    public void testCreateProduktBatch() throws Exception {
        System.out.println("createProduktBatch");
        ProduktBatchDTO produktbatch = null;
        MYSQLProduktBatchDAO instance = new MYSQLProduktBatchDAO();
        instance.createProduktBatch(produktbatch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProduktBatch method, of class MYSQLProduktBatchDAO.
     */
    @Test
    public void testUpdateProduktBatch() throws Exception {
        System.out.println("updateProduktBatch");
        ProduktBatchDTO produktbatch = null;
        MYSQLProduktBatchDAO instance = new MYSQLProduktBatchDAO();
        instance.updateProduktBatch(produktbatch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}