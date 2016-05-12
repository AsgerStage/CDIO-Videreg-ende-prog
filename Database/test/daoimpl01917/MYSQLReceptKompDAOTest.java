package daoimpl01917;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.ReceptKompDTO;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import connector01917.Connector;
import daointerfaces01917.DALException;

import static org.junit.Assert.*;

/**
 * MYSQLReceptKompDAOTest
 * @author SteamedCow
 * @version 10-05-2016
 */
public class MYSQLReceptKompDAOTest 
{

    /**
     * Test of getReceptKomp method, of class MySQLReceptKompDAO.
     */
    @Test
    public void testGetReceptKomp() throws Exception {
        System.out.println("getReceptKomp");
        int receptId = 1;
        int raavareId = 1;
        MySQLReceptKompDAO instance;
        Connector con = null;
        ReceptKompDTO expResult, result;
        try {
            con = new Connector();
            instance = new MySQLReceptKompDAO();
            result = instance.getReceptKomp(receptId,raavareId);
            expResult = new ReceptKompDTO(receptId,raavareId,10,0.1);
        } 
        
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
        assertEquals(expResult, result);
       
       
    }
    

    /**
     * Test of getReceptKompList method, of class MySQLReceptKompDAO.
     */
    @Test
    public void testGetReceptKompList_int() throws Exception {
        System.out.println("getReceptKompList");
        int receptId = 1;
        int raavareId = 1;
        MySQLReceptKompDAO instance;
        Connector con = null;
        ReceptKompDTO expResult, result;
        try {
            con = new Connector();
            instance = new MySQLReceptKompDAO();
            result = instance.getReceptKompList().get(0);
            expResult = new ReceptKompDTO(receptId,raavareId,10,0.1);
        } 
        
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
        assertEquals(expResult, result);
       
       
    }
    

    /**
     * Test of getReceptKompList method, of class MySQLReceptKompDAO.
     */
    @Test
    public void testGetReceptKompList_0args() throws Exception {
        System.out.println("getReceptKompList");

        MySQLReceptKompDAO instance;
        Connector con = null;
        List<ReceptKompDTO> result = null;
        
        try {
            con = new Connector();
            instance = new MySQLReceptKompDAO();
            result = instance.getReceptKompList();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
        
        assertFalse(result == null);
        assertTrue(result.size() >= 12);
        for (ReceptKompDTO rkDTO : result) {
            assertFalse(rkDTO == null);
        }
    }

    /**
     * Test of createReceptKomp method, of class MySQLReceptKompDAO.
     */
    @Test
    public void testCreateReceptKomp() throws Exception {
        System.out.println("createReceptKomp");
        int receptId = 3;
        int raavareId = 2;
        MySQLReceptKompDAO instance;
        Connector con = null;
        ReceptKompDTO expResult, result;
        try {
            con = new Connector();
            instance = new MySQLReceptKompDAO();
            
            expResult = new ReceptKompDTO(receptId,raavareId,10,0.2);
          instance.createReceptKomp(expResult);
            result = instance.getReceptKomp(receptId,raavareId);
            instance.deleteReceptKomp(receptId,raavareId);
        } 
        
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
        assertEquals(expResult, result);
       
       
    }
    

    /**
     * Test of updateReceptKomp method, of class MySQLReceptKompDAO.
     */
    @Test
    public void testUpdateReceptKomp() throws Exception {
    	int receptId = 1;
        int raavareId = 3;
        MySQLReceptKompDAO instance;
        Connector con = null;
        ReceptKompDTO expResult, result;
        expResult = new ReceptKompDTO(receptId,raavareId,2,0.1);
        result=null;
        try {
            con = new Connector();
            instance = new MySQLReceptKompDAO();    
            instance.createReceptKomp(new ReceptKompDTO(receptId,raavareId,4,0.2));
            instance.updateReceptKomp(expResult);
            result = instance.getReceptKomp(receptId,raavareId);
            instance.deleteReceptKomp(receptId, raavareId);
            
        } 
        
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            if(con != null)
                try {
                    con.closeConnection();
                } catch (SQLException e) { }
        }
        assertEquals(expResult, result);
}
}