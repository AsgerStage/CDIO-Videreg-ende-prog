package cdio.view;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DialogTest
 * @author Lasse
 * @version 26-02-2016
 */
public class ViewTest {
    
    public ViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Test of dialog method, of class View.
     */
    @Test
    public void testDialog() {
        System.out.println("dialog");
        View instance = null;
        instance.dialog();
        fail("The test case is a prototype.");
    }

    /**
     * Test of exit method, of class View.
     */
    @Test
    public void testExit() {
        System.out.println("exit");
        View instance = null;
        instance.exit();
        fail("The test case is a prototype.");
    }
    
}
