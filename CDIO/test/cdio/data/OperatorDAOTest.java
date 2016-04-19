package cdio.data;
import cdio.exceptions.DALException;
import cdio.exceptions.OpIdException;
import cdio.exceptions.OpNameException;
import cdio.exceptions.OpPasswordException;
import java.util.ArrayList;
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
    public void testGetOperator() {
        System.out.println("getOperator");
        OperatorDAO instance = new OperatorDAO();
        OperatorDTO expResult, result;
        int oprId;
        
        //Positiv
        try {
            oprId = 99;
            expResult = new OperatorDTO(99, "Admin", "ADM", 0000000000L, "Abc0234", 1);
            result = instance.getOperator(oprId);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        assertEquals(expResult, result);
        
        try {
            oprId = 55;
            expResult = null;
            result = instance.getOperator(oprId);
        } catch (DALException ex) {
            throw new AssertionError(ex);
        }
        assertEquals(expResult, result);
        
        //Negativ
        try {
            oprId = -1;
            expResult = null;
            result = instance.getOperator(oprId);
        } catch (DALException ex) {
            throw new AssertionError(ex);
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of getOperatorList method, of class OperatorDAO.
     */
    @Test
    public void testGetOperatorList() {
        System.out.println("getOperatorList");
        OperatorDAO instance = new OperatorDAO();
        List<OperatorDTO> expResult = new ArrayList<>();
        List<OperatorDTO> result;
        
        //Positiv
        try {
            expResult.add(new OperatorDTO(99, "Admin", "ADM", 0000000000L, "Abc0234", 1));
            expResult.add(new OperatorDTO(11, "Lasse H Nilesen", "LHN", 2909912191L, "123Abc", 0));
            result = instance.getOperatorList();
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of createOperatoer method, of class OperatorDAO.
     */
    @Test
    public void testCreateOperatoer() {
        System.out.println("createOperatoer");
        OperatorDAO instance = new OperatorDAO();
        OperatorDTO opr, expResult, result;
        
        //Positiv
        try {
            opr = new OperatorDTO(66, "Test Bruger", "TB", 1234567890, "Abc321", 0);
            expResult = opr;
            instance.createOperatoer(opr);
            result = instance.getOperator(opr.getOprID());
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        assertEquals(expResult, result);
        
        try {
            opr = new OperatorDTO(6, "Test Bruger", null, -1, "Abc321", 0);
            expResult = opr;
            instance.createOperatoer(opr);
            result = instance.getOperator(opr.getOprID());
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        assertEquals(expResult, result);
        
        //Negativ
        try {
            opr = new OperatorDTO(-1, "Test Bruger", "TB", 1234567890, "Abc321", 0);
            instance.createOperatoer(opr);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            opr = new OperatorDTO(6, "A", "TB", 1234567890, "Abc321", 0);
            instance.createOperatoer(opr);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            opr = new OperatorDTO(6, "Test Bruger", "TB", 1234567890, "abc1234", 0);
            instance.createOperatoer(opr);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            opr = new OperatorDTO(6, "Test Bruger", "TB", 1234567890, "Abc321", -1);
            instance.createOperatoer(opr);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of updateOperatoer method, of class OperatorDAO.
     */
    @Test
    public void testUpdateOperatoer() {
        System.out.println("updateOperatoer");
        OperatorDAO instance = new OperatorDAO();
        OperatorDTO opr, expResult, result;
        
        try {
            instance.createOperatoer(new OperatorDTO(77, "Test Operatør", "TO", 7654321L, "321Abc", 1));
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Positiv
        try {
            opr = new OperatorDTO(66, "Test Bruger", "TB", 1234567890, "Abc321", 0);
            expResult = opr;
            instance.updateOperatoer(opr);
            result = instance.getOperator(opr.getOprID());
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        assertEquals(expResult, result);
        
        try {
            opr = new OperatorDTO(6, "Test Bruger", null, -1, "Abc321", 0);
            expResult = opr;
            instance.updateOperatoer(opr);
            result = instance.getOperator(opr.getOprID());
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        assertEquals(expResult, result);
        
        //Negativ
        try {
            opr = new OperatorDTO(-1, "Test Bruger", "TB", 1234567890, "Abc321", 0);
            instance.updateOperatoer(opr);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            opr = new OperatorDTO(6, "A", "TB", 1234567890, "Abc321", 0);
            instance.updateOperatoer(opr);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            opr = new OperatorDTO(6, "Test Bruger", "TB", 1234567890, "abc1234", 0);
            instance.updateOperatoer(opr);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            opr = new OperatorDTO(6, "Test Bruger", "TB", 1234567890, "Abc321", -1);
            instance.updateOperatoer(opr);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of deleteOperatoer method, of class OperatorDAO.
     */
    @Test
    public void testDeleteOperatoer() {
        System.out.println("deleteOperatoer");
        OperatorDAO instance = new OperatorDAO();
        OperatorDTO opr, expResult, result;
        
        try {
            opr = new OperatorDTO(88, "Slet Mig", "SM", 123567, "12ABcd", 0);
            expResult = opr;

            instance.createOperatoer(opr);
            result = instance.getOperator(opr.getOprID());
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Positiv
        try {
            expResult = null;
            instance.deleteOperatoer(opr);
            result = instance.getOperator(opr.getOprID());
            assertEquals(expResult, result);
        } catch (DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Negativ
        try {
            opr = new OperatorDTO(22, "Ny Slet Mig", "NSM", 7654321, "AB12cd", 1);
            instance.deleteOperatoer(opr);
            assertTrue(true);
        } catch (DALException | OpPasswordException | OpNameException | OpIdException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            opr = null;
            instance.deleteOperatoer(opr);
            assertFalse(true);
        } catch (DALException ex) {
            throw new AssertionError(ex);
        } catch (NullPointerException ex) {
            assertTrue(true);
        }
    }
}