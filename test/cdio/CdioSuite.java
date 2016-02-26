package cdio;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * CdioSuite
 * @author Lasse
 * @version 26-02-2016
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cdio.data.DataSuite.class,cdio.view.ViewSuite.class,cdio.MainTest.class,cdio.exceptions.ExceptionsSuite.class,cdio.functionality.FunctionalitySuite.class,cdio.models.ModelsSuite.class})
public class CdioSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

}