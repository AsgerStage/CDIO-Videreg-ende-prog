package edu.example.client.models;

import java.io.Serializable;
import java.util.Objects;

import edu.example.client.exceptions.DALException;

/**
 * Recept Data Objekt
 */
public class ReceptDTO implements Serializable
{
	private static final long serialVersionUID = -7970032674348618324L;
	/** Recept nr i omraadet 1-99999999 */
	private int receptID;
	/** Receptnavn min. 2 max. 20 karakterer */
	private	String receptNavn;
	
    public ReceptDTO() {
    }
    
	public ReceptDTO(int receptID, String receptNavn) {
        this.receptID = receptID;
        this.receptNavn = receptNavn;
    }

    public int getReceptID() {
    	return receptID;
    }
	
    public void setReceptID(int receptID) throws DALException {
    	if(receptID < 1 || receptID > 99999999)
    		throw new DALException("Recept ID skal være mellem 1 og 99999999, den var " + receptID);
    	else
    		this.receptID = receptID;
    }
	
    public String getReceptNavn() { 
    	return receptNavn; 
    }
	
    public void setReceptNavn(String receptNavn) throws DALException { 
    	int strLength = receptNavn.length();
    	
    	if(strLength < 2 || strLength > 20)
    		throw new DALException("Recept navnet skal være mellem 2 og 20 karakterer, den var " + strLength);
    	else
    		this.receptNavn = receptNavn;
    }
	
    @Override
    public String toString() {
		return "{receptID=" + receptID + ", receptNavn=" + receptNavn + '}'; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) 
            return false;
        final ReceptDTO other = (ReceptDTO) obj;
        
        return this.receptID == other.receptID &&
               Objects.equals(this.receptNavn, other.receptNavn);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
