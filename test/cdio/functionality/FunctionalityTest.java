package cdio.functionality;
import cdio.models.OperatorDTO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * FunctionalityTest
 * @author Lasse
 * @version 26-02-2016
 */
public class FunctionalityTest 
{
    /**
     * Test of createOpr method, of class Functionality.
     */
    @Test
    public void testCreateOpr() {
        System.out.println("createOpr");
        String oprNavn = "";
        String ini = "";
        long cpr = 0L;
        int rank = 0;
        Functionality instance = null;
        int expResult = 0;
        int result = instance.createOpr(oprNavn, ini, cpr, rank);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteOpr method, of class Functionality.
     */
    @Test
    public void testDeleteOpr() {
        System.out.println("deleteOpr");
        int oprID = 0;
        Functionality instance = null;
        boolean expResult = false;
        boolean result = instance.deleteOpr(oprID);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOpr method, of class Functionality.
     */
    @Test
    public void testUpdateOpr() throws Exception {
        System.out.println("updateOpr");
        int oprID = 0;
        String name = "";
        long cpr = 0L;
        int rank = 0;
        Functionality instance = null;
        boolean expResult = false;
        boolean result = instance.updateOpr(oprID, name, cpr, rank);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePass method, of class Functionality.
     */
    @Test
    public void testChangePass() throws Exception {
        System.out.println("changePass");
        int oprID = 0;
        String oldPassword = "";
        String newPassowrd1 = "";
        String newPassword2 = "";
        Functionality instance = null;
        boolean expResult = false;
        boolean result = instance.changePass(oprID, oldPassword, newPassowrd1, newPassword2);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of measure method, of class Functionality.
     */
    @Test
    public void testMeasure() {
        System.out.println("measure");
        double tara = 0.0;
        double brutto = 0.0;
        Functionality instance = null;
        double expResult = 0.0;
        double result = instance.measure(tara, brutto);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class Functionality.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        int userId = 0;
        String password = "";
        Functionality instance = null;
        boolean expResult = false;
        boolean result = instance.login(userId, password);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of readOpr method, of class Functionality.
     */
    @Test
    public void testReadOpr() {
        System.out.println("readOpr");
        int oprID = 0;
        Functionality instance = null;
        OperatorDTO expResult = null;
        OperatorDTO result = instance.readOpr(oprID);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}