package cdio.data;
import cdio.models.OperatorDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * OperatorDAOTest
 * @author Lasse
 * @version 26-02-2016
 */
public class OperatorDAOTest 
{
    /**
     * Test of getOperator method, of class OperatorDAO.
     */
    @Test
    public void testGetOperator() throws Exception {
        System.out.println("getOperator");
        int oprId = 0;
        OperatorDAO instance = new OperatorDAO();
        OperatorDTO expResult = null;
        OperatorDTO result = instance.getOperator(oprId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperatorList method, of class OperatorDAO.
     */
    @Test
    public void testGetOperatorList() throws Exception {
        System.out.println("getOperatorList");
        OperatorDAO instance = new OperatorDAO();
        List<OperatorDTO> expResult = null;
        List<OperatorDTO> result = instance.getOperatorList();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOperatoer method, of class OperatorDAO.
     */
    @Test
    public void testCreateOperatoer() throws Exception {
        System.out.println("createOperatoer");
        OperatorDTO opr = null;
        OperatorDAO instance = new OperatorDAO();
        instance.createOperatoer(opr);
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOperatoer method, of class OperatorDAO.
     */
    @Test
    public void testUpdateOperatoer() throws Exception {
        System.out.println("updateOperatoer");
        OperatorDTO opr = null;
        OperatorDAO instance = new OperatorDAO();
        instance.updateOperatoer(opr);
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteOperatoer method, of class OperatorDAO.
     */
    @Test
    public void testDeleteOperatoer() throws Exception {
        System.out.println("deleteOperatoer");
        OperatorDTO opr = null;
        OperatorDAO instance = new OperatorDAO();
        instance.deleteOperatoer(opr);
        fail("The test case is a prototype.");
    }
}