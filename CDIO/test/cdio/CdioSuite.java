package cdio;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * CdioSuite
 * @author Lasse
 * @version 26-02-2016
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cdio.data.DataSuite.class, cdio.view.ViewSuite.class, cdio.MainTest.class, cdio.exceptions.ExceptionsSuite.class, cdio.functionality.FunctionalitySuite.class})
public class CdioSuite 
{
    
}