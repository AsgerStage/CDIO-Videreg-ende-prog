package cdio.functionality;
import cdio.data.OperatorDAO;
import cdio.data.OperatorDTO;
import cdio.exceptions.DALException;
import cdio.exceptions.OpIdException;
import cdio.exceptions.OpNameException;
import cdio.exceptions.OpPasswordException;
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
        Functionality instance = new Functionality(new OperatorDAO());
        
        //Positiv
        String oprNavn = "Test Bruger";
        String ini = "TB";
        long cpr = 1234567890L;
        int rank = 1;
        
        int id = instance.createOpr(oprNavn, ini, cpr, rank);
        assertTrue(id >= 11 && id <= 99);
        
        OperatorDTO opr = instance.readOpr(id);
        assertEquals(id, opr.getOprID());
        assertEquals(ini, opr.getIni());
        assertEquals(cpr, opr.getCpr());
        assertEquals(rank, opr.getRank());
        assertNotNull(opr.getPassword());
                
        oprNavn = "Test Bruger";
        ini = null;
        cpr = -1;
        rank = 1;
        
        id = instance.createOpr(oprNavn, ini, cpr, rank);
        assertTrue(id >= 11 && id <= 99);
        
        opr = instance.readOpr(id);
        assertEquals(id, opr.getOprID());
        assertEquals(ini, opr.getIni());
        assertEquals(cpr, opr.getCpr());
        assertEquals(rank, opr.getRank());
        assertNotNull(opr.getPassword());
        
        //Negativ
        oprNavn = "A";
        id = instance.createOpr(oprNavn, ini, cpr, rank);
        assertEquals(-1, id);
        
        rank = -1;
        id = instance.createOpr(oprNavn, ini, cpr, rank);
        assertEquals(-1, id);
    }

    /**
     * Test of deleteOpr method, of class Functionality.
     */
    @Test
    public void testDeleteOpr() {
        System.out.println("deleteOpr");
        Functionality instance = new Functionality(new OperatorDAO());
        int oprID;
        boolean expResult, result;
        
        //Positiv
        oprID = instance.createOpr("Ny Bruger", "NB", 1234567890, 1);
        expResult = true;
        result = instance.deleteOpr(oprID);
        assertEquals(expResult, result);
        
        //Negativ
        oprID = -1;
        expResult = false;
        result = instance.deleteOpr(oprID);
        assertEquals(expResult, result);
        
        oprID = 12;
        expResult = false;
        result = instance.deleteOpr(oprID);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateOpr method, of class Functionality.
     */
    @Test
    public void testUpdateOpr() {
        System.out.println("updateOpr");
        Functionality instance = new Functionality(new OperatorDAO());
        OperatorDTO opr;
        String name;
        int oprID, rank;
        long cpr;
        boolean expResult, result;
        
        //Positiv
        try {
            oprID = 99;
            name = null;
            cpr = -1;
            rank = -1;
            expResult = true;
            opr = instance.readOpr(oprID);
            
            result = instance.updateOpr(oprID, name, cpr, rank);
            assertEquals(expResult, result);
            assertEquals(opr, instance.readOpr(oprID));
        } catch (OpNameException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            oprID = 99;
            name = "New Admin";
            cpr = -1;
            rank = -1;
            expResult = true;
            opr = instance.readOpr(oprID);
            opr.setName(name);
            
            result = instance.updateOpr(oprID, name, cpr, rank);
            assertEquals(expResult, result);
            assertEquals(opr, instance.readOpr(oprID));
        } catch (OpNameException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            oprID = 99;
            name = null;
            cpr = 11112222;
            rank = -1;
            expResult = true;
            opr = instance.readOpr(oprID);
            opr.setCpr(cpr);
            
            result = instance.updateOpr(oprID, name, cpr, rank);
            assertEquals(expResult, result);
            assertEquals(opr, instance.readOpr(oprID));
        } catch (OpNameException ex) {
            throw new AssertionError(ex);
        }
        
        try {
            oprID = 99;
            name = null;
            cpr = -1;
            rank = 0;
            expResult = true;
            opr = instance.readOpr(oprID);
            opr.setRank(rank);
            
            result = instance.updateOpr(oprID, name, cpr, rank);
            assertEquals(expResult, result);
            assertEquals(opr, instance.readOpr(oprID));
        } catch (OpNameException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        //Negativ
        try {
            oprID = 99;
            name = "A";
            cpr = -1;
            rank = -1;
            expResult = false;
            
            result = instance.updateOpr(oprID, name, cpr, rank);
            assertEquals(expResult, result);
            assertFalse(true);
        } catch (OpNameException ex) {
            assertTrue(true);
        }
        
        try {
            oprID = 99;
            name = null;
            cpr = -1;
            rank = -2;
            expResult = false;
            
            result = instance.updateOpr(oprID, name, cpr, rank);
            assertEquals(expResult, result);
        } catch (OpNameException ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Test of changePass method, of class Functionality.
     */
    @Test
    public void testChangePass() {
        System.out.println("changePass");
        Functionality instance = new Functionality(new OperatorDAO());
        boolean expResult, result;
        String oldPassword, newPassword, newPassword1, newPassword2;
        int oprID;
        
        //Positiv
        try {
            oprID = instance.createOpr("Ny Bruger", "NB", 654783902, 0);
            oldPassword = instance.readOpr(oprID).getPassword();
            
            newPassword1 = "123Abc";
            newPassword2 = "123Abc";
            
            expResult = true;
            result = instance.changePass(oprID, oldPassword, newPassword1, newPassword2);
            newPassword = instance.readOpr(oprID).getPassword();
            assertEquals(expResult, result);
            assertEquals(newPassword1, newPassword);
        } catch (OpPasswordException ex) {
            throw new AssertionError(ex);
        }
        
        //Negativ
        try {
            oprID = instance.createOpr("Ny Bruger", "NB", 654783902, 0);
            oldPassword = instance.readOpr(oprID).getPassword();
            
            newPassword1 = "aA1+";
            newPassword2 = "aA1+";
            
            expResult = false;
            result = instance.changePass(oprID, oldPassword, newPassword1, newPassword2);
            newPassword = instance.readOpr(oprID).getPassword();
            assertEquals(expResult, result);
            assertNotSame(newPassword1, newPassword);
        } catch (OpPasswordException ex) {
            assertTrue(true);
        }
        
        try {
            oprID = instance.createOpr("Ny Bruger", "NB", 654783902, 0);
            oldPassword = instance.readOpr(oprID).getPassword();
            
            newPassword1 = "abc123";
            newPassword2 = "abc123";
            
            expResult = false;
            result = instance.changePass(oprID, oldPassword, newPassword1, newPassword2);
            newPassword = instance.readOpr(oprID).getPassword();
            assertEquals(expResult, result);
            assertNotSame(newPassword1, newPassword);
        } catch (OpPasswordException ex) {
            assertTrue(true);
        }
        
        try {
            oprID = instance.createOpr("Ny Bruger", "NB", 654783902, 0);
            oldPassword = instance.readOpr(oprID).getPassword();
            
            newPassword1 = "abC+123";
            newPassword2 = "abc123";
            
            expResult = false;
            result = instance.changePass(oprID, oldPassword, newPassword1, newPassword2);
            newPassword = instance.readOpr(oprID).getPassword();
            assertEquals(expResult, result);
            assertNotSame(newPassword1, newPassword);
        } catch (OpPasswordException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of measure method, of class Functionality.
     */
    @Test
    public void testMeasure() {
        System.out.println("measure");
        Functionality instance = new Functionality(new OperatorDAO());
        double tara, brutto, expResult, result;
        
        //Positiv
        tara = 5.5;
        brutto = 12.0;
        expResult = 6.5;
        result = instance.measure(tara, brutto);
        assertEquals(expResult, result, 0.0);
        
        tara = 15.0;
        brutto = 12.5;
        expResult = -2.5;
        result = instance.measure(tara, brutto);
        assertEquals(expResult, result, 0.0);
        
        tara = -3.0;
        brutto = -1.0;
        expResult = 2.0;
        result = instance.measure(tara, brutto);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of login method, of class Functionality.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Functionality instance = new Functionality(new OperatorDAO());
        boolean expResult, result;
        String password;
        int oprID;
        
        //Positiv
        oprID = instance.createOpr("Ny Bruger", "NB", 654783902, 0);
        password = instance.readOpr(oprID).getPassword();
        expResult = true;
        result = instance.login(oprID, password);
        assertEquals(expResult, result);
        
        //Negativ
        oprID = instance.createOpr("Ny Bruger", "NB", 654783902, 0);
        password = instance.readOpr(oprID).getPassword();
        oprID = 11;
        expResult = false;
        result = instance.login(oprID, password);
        assertEquals(expResult, result);
        
        oprID = instance.createOpr("Ny Bruger", "NB", 654783902, 0);
        password = "abcD1234";
        expResult = false;
        result = instance.login(oprID, password);
        assertEquals(expResult, result);
        
        oprID = instance.createOpr("Ny Bruger", "NB", 654783902, 0);
        password = "abc";
        expResult = false;
        result = instance.login(oprID, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of readOpr method, of class Functionality.
     */
    @Test
    public void testReadOpr() {
        System.out.println("readOpr");
        Functionality instance = new Functionality(new OperatorDAO());
        OperatorDTO expResult, result;
        int oprID;
        
        //Positiv
        try {
            oprID = 99;
            expResult = new OperatorDTO(99, "Admin", "ADM", 0000000000L, "Abc0234", 1);
            result = instance.readOpr(oprID);
            assertEquals(expResult, result);
        } catch (OpPasswordException | OpNameException | OpIdException | DALException ex) {
            throw new AssertionError(ex);
        }
        
        oprID = 44;
        expResult = null;
        result = instance.readOpr(oprID);
        assertEquals(expResult, result);
        
        //Negativ
        oprID = -1;
        expResult = null;
        result = instance.readOpr(oprID);
        assertEquals(expResult, result);
    }
}