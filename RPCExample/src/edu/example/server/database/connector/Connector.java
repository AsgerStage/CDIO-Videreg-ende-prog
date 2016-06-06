package edu.example.server.database.connector;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.example.client.exceptions.DALException;

public class Connector
{
	/**
	 * To connect to a MySQL-server
	 * 
	 * @param url must have the form
	 * "jdbc:mysql://<server>/<database>" for default port (3306)
	 * OR
	 * "jdbc:mysql://<server>:<port>/<database>" for specific port
	 * more formally "jdbc:subprotocol:subname"
	 * 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 */
	public static Connection connectToDatabase(String url, String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        // call the driver class' no argument constructor
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        // get Connection-object via DriverManager
        return (Connection) DriverManager.getConnection(url, username, password);
    }
	
	private static Connection conn;
	private static Statement stm;
	
	public Connector(String server, int port, String database, String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        conn = connectToDatabase("jdbc:mysql://"+server+":"+port+"/"+database, username, password);
        stm = conn.createStatement();
    }
	
	public Connector() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        this(Constant.server, Constant.port, Constant.database, Constant.username, Constant.password);
    }
    
    public void closeConnection() throws SQLException {
        if(conn != null)
            conn.close();
    }
	
  //Do query med statement.
    public static ResultSet doQuery(String cmd) throws DALException {
        try { 
            return stm.executeQuery(cmd); 
        }
        catch (SQLException e) { 
            throw new DALException(e); 
        }
    }
    
    //Do query med prepared statement.
    public static ResultSet doQuery(String cmd, Object... args) throws DALException {
        try { 
            PreparedStatement ps = createPreparedStatement(cmd, args);
            return ps.executeQuery(); 
        }
        catch (SQLException e) { 
            throw new DALException(e); 
        }
    }
	
  //Update query med statement.
    public static int doUpdate(String cmd) throws DALException {
        try { 
            return stm.executeUpdate(cmd); 
        }
        catch (SQLException e) { 
            throw new DALException(e); 
        }
    }
    
    //Update query med prepared statement.
    public static int doUpdate(String cmd, Object... args) throws DALException {
        try { 
            PreparedStatement ps = createPreparedStatement(cmd, args);
            return ps.executeUpdate(); 
        }
        catch (SQLException e) { 
            throw new DALException(e); 
        }
    }
    
    //Opretter et prepared statment ud fra et query og nogle parametre.
    private static PreparedStatement createPreparedStatement(String cmd, Object... args) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(cmd);
        
        int i = 1;
        for (Object arg : args) {
            if(arg instanceof String) 
                ps.setString(i, (String) arg);
            else if(arg instanceof Integer)
                ps.setInt(i, (Integer) arg);
            else if(arg instanceof Double)
                ps.setDouble(i, (Double) arg);
            else if(arg instanceof Array)
                ps.setArray(i, (Array) arg);
            i++;
        }
        
        return ps;
    }
}