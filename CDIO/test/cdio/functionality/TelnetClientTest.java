package cdio.functionality;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TelnetClientTest
 * @author SteamedCow
 * @version 08-04-2016
 */
public class TelnetClientTest 
{

    /**
     * Test of connect method, of class TelnetClient.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        TelnetClient instance = null;
        instance.connect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class TelnetClient.
     */
    @Test
    public void testGetData_String_StringArr() throws Exception {
        System.out.println("getData");
        String command = "";
        String[] params = null;
        TelnetClient instance = null;
        String expResult = "";
        String result = instance.getData(command, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class TelnetClient.
     */
    @Test
    public void testGetData_3args() throws Exception {
        System.out.println("getData");
        String command = "";
        int expectedReplies = 0;
        String[] params = null;
        TelnetClient instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getData(command, expectedReplies, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class TelnetClient.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        TelnetClient instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}