/**
 * 
 */
package edu.example.server.database;

import java.sql.SQLException;

import edu.example.server.database.connector.Connector;

/**
 * @author Asger
 *
 * 03/05/2016
 */
public class DatabaseConnection {

	
public static void connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	
	Connector.connectToDatabase("jdbc:mysql:///nasie.diskstation.me", "DTU", "Gruppe16");
}
	/**
	 * 
	 */
	public DatabaseConnection() {
		
	}

}
