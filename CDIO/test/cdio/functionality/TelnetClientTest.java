package cdio.functionality;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TelnetClientTest
 * @author Lasse
 * @version 08-04-2016
 */
public class TelnetClientTest 
{

    /**
     * Test of connect method, of class TelnetClient.
     * <br><b>THIS TEST REQUIRES THAT WEAIGHT SERVER IS RUNNING ON LOCAL HOST PORT 8000</b>
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        String bruttoStr;
        TelnetClient instance;
        try {
            instance = new TelnetClient("localhost", 8000);
            instance.connect();
            
            bruttoStr = instance.getData(TelnetClient.CMD_WEIGHT_GET);
            assertEquals("S S 0.0 kg ", bruttoStr);
            
            instance.close();
        } catch (IOException ex) {
            throw new AssertionError(ex);
        }
    }
}