package cdio.data;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * DataSuite
 * @author Lasse
 * @version 26-02-2016
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cdio.data.OperatorDAOTest.class})
public class DataSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

}