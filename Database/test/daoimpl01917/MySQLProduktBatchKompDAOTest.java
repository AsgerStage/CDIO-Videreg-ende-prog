package daoimpl01917;
import connector01917.Connector;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * MySQLProduktBatchKompDAOTest
 * @author Lasse Holm Nielsen
 * @version 10-05-2016
 */
public class MySQLProduktBatchKompDAOTest 
{
    /**
     * Test of getProduktBatchKomp method, of class MySQLProduktBatchKompDAO.
     */
    @Test
    public void testGetProduktBatchKomp() {
        System.out.println("getProduktBatchKomp");
        MySQLProduktBatchKompDAO instance;
        ProduktBatchKompDTO result = null, expResult = null;
        Connector con = null;
        int pbId = 2;
        int rbId = 5;
        
        try {
            con = new Connector();
            instance = new MySQLProduktBatchKompDAO();
            result = instance.getProduktBatchKomp(pbId, rbId);
            expResult = new ProduktBatchKompDTO(2, 5, 0.5, 1.47, 2);
        } 
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            e.printStackTrace();
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        
        System.out.println("RESULT = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProduktBatchKompList method, of class MySQLProduktBatchKompDAO.
     */
    @Test
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
    public void testUpdateProduktBatchKomp() throws Exception {
        System.out.println("updateProduktBatchKomp");
        ProduktBatchKompDTO produktbatchkomponent = null;
        MySQLProduktBatchKompDAO instance = new MySQLProduktBatchKompDAO();
        instance.updateProduktBatchKomp(produktbatchkomponent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}