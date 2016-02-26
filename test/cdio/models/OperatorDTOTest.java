package cdio.models;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * OperatorDTOTest
 * @author Lasse
 * @version 26-02-2016
 */
public class OperatorDTOTest {
    
    public OperatorDTOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Test of setIni method, of class OperatorDTO.
     */
    @Test
    public void testSetIni() {
        System.out.println("setIni");
        String ini = "";
        OperatorDTO instance = null;
        instance.setIni(ini);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIni method, of class OperatorDTO.
     */
    @Test
    public void testGetIni() {
        System.out.println("getIni");
        OperatorDTO instance = null;
        String expResult = "";
        String result = instance.getIni();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRank method, of class OperatorDTO.
     */
    @Test
    public void testSetRank() throws Exception {
        System.out.println("setRank");
        int rank = 0;
        OperatorDTO instance = null;
        instance.setRank(rank);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRank method, of class OperatorDTO.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        OperatorDTO instance = null;
        int expResult = 0;
        int result = instance.getRank();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setoprId method, of class OperatorDTO.
     */
    @Test
    public void testSetoprId() throws Exception {
        System.out.println("setoprId");
        int oprID = 0;
        OperatorDTO instance = null;
        instance.setoprId(oprID);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getoprID method, of class OperatorDTO.
     */
    @Test
    public void testGetoprID() {
        System.out.println("getoprID");
        OperatorDTO instance = null;
        int expResult = 0;
        int result = instance.getoprID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class OperatorDTO.
     */
    @Test
    public void testSetName() throws Exception {
        System.out.println("setName");
        String name = "";
        OperatorDTO instance = null;
        instance.setName(name);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCpr method, of class OperatorDTO.
     */
    @Test
    public void testSetCpr() {
        System.out.println("setCpr");
        long cpr = 0L;
        OperatorDTO instance = null;
        instance.setCpr(cpr);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class OperatorDTO.
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        String password = "";
        OperatorDTO instance = null;
        instance.setPassword(password);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class OperatorDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        OperatorDTO instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCpr method, of class OperatorDTO.
     */
    @Test
    public void testGetCpr() {
        System.out.println("getCpr");
        OperatorDTO instance = null;
        long expResult = 0L;
        long result = instance.getCpr();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class OperatorDTO.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        OperatorDTO instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class OperatorDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        OperatorDTO instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
