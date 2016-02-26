package cdio.models;
import cdio.exceptions.DALException;
import cdio.exceptions.OpIdException;
import cdio.exceptions.OpNameException;
import cdio.exceptions.OpPasswordException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * OperatorDTOTest
 * @author Lasse
 * @version 26-02-2016
 */
public class OperatorDTOTest 
{
    /**
     * Test of setIni method, of class OperatorDTO.
     */
    @Test
    public void testSetIni() {
        System.out.println("setIni");
        OperatorDTO instance;
        String ini, expResult, result;
        
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Positiv
        ini = "PMT";
        expResult = ini;
        instance.setIni(ini);
        result = instance.getIni();
        assertEquals(expResult, result);
        
        ini = "";
        expResult = ini;
        instance.setIni(ini);
        result = instance.getIni();
        assertEquals(expResult, result);
        
        ini = null;
        expResult = ini;
        instance.setIni(ini);
        result = instance.getIni();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIni method, of class OperatorDTO.
     */
    @Test
    public void testGetIni() {
        System.out.println("getIni");
        OperatorDTO instance;
        String expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        expResult = "TMP";
        result = instance.getIni();
        assertEquals(expResult, result);
        
        try {
            instance = new OperatorDTO(55, "Temp", "", 1234567890, "QWerty12", 0);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        expResult = "";
        result = instance.getIni();
        assertEquals(expResult, result);
        
        try {
            instance = new OperatorDTO(55, "Temp", null, 1234567890, "QWerty12", 0);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        expResult = null;
        result = instance.getIni();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRank method, of class OperatorDTO.
     */
    @Test
    public void testSetRank() {
        System.out.println("setRank");
        OperatorDTO instance;
        int rank, expResult, result;
        
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Positiv
        try {
            rank = 0;
            expResult = rank;
            instance.setRank(rank);
            result = instance.getRank();
            assertEquals(expResult, result);
        } catch (DALException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            rank = 1;
            expResult = rank;
            instance.setRank(rank);
            result = instance.getRank();
            assertEquals(expResult, result);
        } catch (DALException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            rank = -1;
            expResult = rank;
            instance.setRank(rank);
            result = instance.getRank();
            assertEquals(expResult, result);
        } catch (DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Negativ
        try {
            rank = 2;
            instance.setRank(rank);
            assertFalse(true);
        } catch (DALException ex) {
            assertTrue(true);
        }
        
        try {
            rank = -2;
            instance.setRank(rank);
            assertFalse(true);
        } catch (DALException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of getRank method, of class OperatorDTO.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        OperatorDTO instance;
        int expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 1);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        expResult = 1;
        result = instance.getRank();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOprID method, of class OperatorDTO.
     */
    @Test
    public void testSetOprId() {
        System.out.println("setOprId");
        OperatorDTO instance;
        int oprID, expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            oprID = 99;
            expResult = oprID;
            instance.setOprID(oprID);
            result = instance.getOprID();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            oprID = 11;
            expResult = oprID;
            instance.setOprID(oprID);
            result = instance.getOprID();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Negativ
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            oprID = 10;
            instance.setOprID(oprID);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            oprID = 100;
            instance.setOprID(oprID);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of getOprID method, of class OperatorDTO.
     */
    @Test
    public void testGetoprID() {
        System.out.println("getoprID");
        OperatorDTO instance;
        int expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            expResult = 55;
            result = instance.getOprID();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Test of setName method, of class OperatorDTO.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        OperatorDTO instance;
        String name, expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            name = "Ny";
            expResult = name;
            instance.setName(name);
            result = instance.getName();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Negativ
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            name = "N";
            instance.setName(name);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            name = null;
            instance.setName(name);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of setCpr method, of class OperatorDTO.
     */
    @Test
    public void testSetCpr() {
        System.out.println("setCpr");
        OperatorDTO instance;
        long cpr, expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            cpr = Long.MAX_VALUE;
            expResult = cpr;
            instance.setCpr(cpr);
            result = instance.getCpr();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            cpr = 0;
            expResult = cpr;
            instance.setCpr(cpr);
            result = instance.getCpr();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            cpr = Long.MIN_VALUE;
            expResult = cpr;
            instance.setCpr(cpr);
            result = instance.getCpr();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Test of setPassword method, of class OperatorDTO.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        OperatorDTO instance;
        String password, expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            password = "abc+12";
            expResult = password;
            instance.setPassword(password);
            result = instance.getPassword();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Negativ
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            password = "abc123";
            instance.setPassword(password);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
        
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            password = "a+A23";
            instance.setPassword(password);
            assertFalse(true);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of getName method, of class OperatorDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        OperatorDTO instance;
        String expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            expResult = "Temp";
            result = instance.getName();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Test of getCpr method, of class OperatorDTO.
     */
    @Test
    public void testGetCpr() {
        System.out.println("getCpr");
        OperatorDTO instance;
        long expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            expResult = 1234567890;
            result = instance.getCpr();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Test of getPassword method, of class OperatorDTO.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        OperatorDTO instance;
        String expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            expResult = "QWerty12";
            result = instance.getPassword();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Test of toString method, of class OperatorDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        OperatorDTO instance;
        String expResult, result;
        
        //Positiv
        try {
            instance = new OperatorDTO(55, "Temp", "TMP", 1234567890, "QWerty12", 0);
            System.out.println(instance.toString());
            expResult = "OperatorDTO{oprID=55, oprNavn=Temp, ini=TMP, cpr=1234567890, password=QWerty12, rank=0}";
            result = instance.toString();
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
    }
}