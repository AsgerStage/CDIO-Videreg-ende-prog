package cdio;
import cdio.data.DataSuite;
import cdio.exceptions.ExceptionsSuite;
import cdio.functionality.FunctionalitySuite;
import cdio.view.ViewSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * CdioSuite
 * @author Lasse
 * @version 26-02-2016
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DataSuite.class, ViewSuite.class, MainTest.class, FunctionalitySuite.class, ExceptionsSuite.class})
public class CdioSuite 
{
    
}