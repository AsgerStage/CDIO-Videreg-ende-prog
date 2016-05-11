package daoimpl01917;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchDTO;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import connector01917.Connector;
import daointerfaces01917.DALException;

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
        MySQLOperatoerDAO instance;
        Connector con = null;
        OperatoerDTO expResult, result;
        int oprId = 1;
        try {
            con = new Connector();
            instance = new MySQLOperatoerDAO();
            result = instance.getOperatoer(oprId);
            expResult = new OperatoerDTO(oprId,"Angelo A","AA","070770-7007","lKje4fa");
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
     * Test of createOperatoer method, of class MySQLOperatoerDAO.
     */
    @Test
    public void testCreateOperatoer() throws Exception {
        System.out.println("createOperatoer");
        MySQLOperatoerDAO instance;
        Connector con = null;
        OperatoerDTO expResult, result;
        int oprId = 55;
        try {
            con = new Connector();
            instance = new MySQLOperatoerDAO();
            expResult = new OperatoerDTO(oprId,"Asger","AS","170894-7777","TTje4fa");
            instance.createOperatoer(expResult);
            result = instance.getOperatoer(oprId);
            instance.deleteOperatoer(oprId);
            
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