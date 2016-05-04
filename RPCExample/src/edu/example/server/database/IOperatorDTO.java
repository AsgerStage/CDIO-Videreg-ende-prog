package edu.example.server.database;

import edu.example.server.database.exceptions.DALException;
import edu.example.server.database.exceptions.OpIdException;
import edu.example.server.database.exceptions.OpNameException;
import edu.example.server.database.exceptions.OpPasswordException;

public interface IOperatorDTO 
{
	public void setIni(String ini);

    public String getIni();

    public void setRank(int rank) throws DALException;

    public int getRank();

    public void setOprID(int oprID) throws OpIdException;

    public int getOprID();

    public void setName(String name) throws OpNameException;

    public void setCpr(String cpr);

    public void setPassword(String password) throws OpPasswordException;

    public String getName();

    public String getCpr();

    public String getPassword();
}