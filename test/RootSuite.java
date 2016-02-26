import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * RootSuite
 * @author Lasse
 * @version 26-02-2016
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cdio.CdioSuite.class})
public class RootSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

}