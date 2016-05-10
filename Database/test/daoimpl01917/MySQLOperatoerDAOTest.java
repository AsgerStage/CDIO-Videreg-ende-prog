package daoimpl01917;
import dto01917.OperatoerDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MySQLOperatoerDAOTest
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MySQLOperatoerDAOTest 
{

    /**
     * Test of getOperatoer method, of class MySQLOperatoerDAO.
     */
    @Test
    public void testGetOperatoer() throws Exception {
        System.out.println("getOperatoer");
        int oprId = 0;
        MySQLOperatoerDAO instance = new MySQLOperatoerDAO();
        OperatoerDTO expResult = null;
        OperatoerDTO result = instance.getOperatoer(oprId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOperatoer method, of class MySQLOperatoerDAO.
     */
    @Test
    public void testCreateOperatoer() throws Exception {
        System.out.println("createOperatoer");
        OperatoerDTO opr = null;
        MySQLOperatoerDAO instance = new MySQLOperatoerDAO();
        instance.createOperatoer(opr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOperatoer method, of class MySQLOperatoerDAO.
     */
    @Test
    public void testUpdateOperatoer() throws Exception {
        System.out.println("updateOperatoer");
        OperatoerDTO opr = null;
        MySQLOperatoerDAO instance = new MySQLOperatoerDAO();
        instance.updateOperatoer(opr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperatoerList method, of class MySQLOperatoerDAO.
     */
    @Test
    public void testGetOperatoerList() throws Exception {
        System.out.println("getOperatoerList");
        MySQLOperatoerDAO instance = new MySQLOperatoerDAO();
        List<OperatoerDTO> expResult = null;
        List<OperatoerDTO> result = instance.getOperatoerList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}