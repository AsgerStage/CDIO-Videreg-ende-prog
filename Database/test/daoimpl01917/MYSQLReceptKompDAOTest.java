package daoimpl01917;
import dto01917.ReceptKompDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MYSQLReceptKompDAOTest
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MYSQLReceptKompDAOTest 
{

    /**
     * Test of getReceptKomp method, of class MYSQLReceptKompDAO.
     */
    @Test
    public void testGetReceptKomp() throws Exception {
        System.out.println("getReceptKomp");
        int receptId = 0;
        int raavareId = 0;
        MYSQLReceptKompDAO instance = new MYSQLReceptKompDAO();
        ReceptKompDTO expResult = null;
        ReceptKompDTO result = instance.getReceptKomp(receptId, raavareId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReceptKompList method, of class MYSQLReceptKompDAO.
     */
    @Test
    public void testGetReceptKompList_int() throws Exception {
        System.out.println("getReceptKompList");
        int receptId = 0;
        MYSQLReceptKompDAO instance = new MYSQLReceptKompDAO();
        List<ReceptKompDTO> expResult = null;
        List<ReceptKompDTO> result = instance.getReceptKompList(receptId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReceptKompList method, of class MYSQLReceptKompDAO.
     */
    @Test
    public void testGetReceptKompList_0args() throws Exception {
        System.out.println("getReceptKompList");
        MYSQLReceptKompDAO instance = new MYSQLReceptKompDAO();
        List<ReceptKompDTO> expResult = null;
        List<ReceptKompDTO> result = instance.getReceptKompList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createReceptKomp method, of class MYSQLReceptKompDAO.
     */
    @Test
    public void testCreateReceptKomp() throws Exception {
        System.out.println("createReceptKomp");
        ReceptKompDTO receptkomponent = null;
        MYSQLReceptKompDAO instance = new MYSQLReceptKompDAO();
        instance.createReceptKomp(receptkomponent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateReceptKomp method, of class MYSQLReceptKompDAO.
     */
    @Test
    public void testUpdateReceptKomp() throws Exception {
        System.out.println("updateReceptKomp");
        ReceptKompDTO receptkomponent = null;
        MYSQLReceptKompDAO instance = new MYSQLReceptKompDAO();
        instance.updateReceptKomp(receptkomponent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}