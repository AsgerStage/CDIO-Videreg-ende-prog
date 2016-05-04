package edu.example.client.exceptions;

import java.io.Serializable;
import java.sql.SQLException;

public class DALException extends Throwable implements Serializable
{
    private static final long serialVersionUID = 2L;
    private final String DALEx;

    public DALException(String DALEx) {
        super("Data exception");
        this.DALEx = DALEx;
    }
    public DALException(Exception e){
    	super(e.getMessage());
    	this.DALEx=e.getMessage();
    }
    
}
