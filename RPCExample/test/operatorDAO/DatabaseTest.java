/**
 * 
 */
package operatorDAO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Asger
 *
 * 04/05/2016
 */
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import edu.example.server.database.DatabaseConnection;
import edu.example.server.database.MySQLOperatoerDAO;
import edu.example.server.database.OperatorDTO;
import edu.example.server.database.exceptions.DALException;
import edu.example.server.database.exceptions.OpIdException;
import edu.example.server.database.exceptions.OpNameException;
import edu.example.server.database.exceptions.OpPasswordException;

public class DatabaseTest {

	@Test
	public void test() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, OpPasswordException, OpNameException, OpIdException {
		DatabaseConnection.connect();
		
		OperatorDTO opr =new OperatorDTO(55,"Asger","AS","1234","asd123",1);
		
		MySQLOperatoerDAO result1 =  new MySQLOperatoerDAO();
		result1.createOperator(opr);
			
		
		OperatorDTO expected = opr;
		OperatorDTO result = result1.getOperator(55);
		
		assertEquals(expected,result);

	
	}

}