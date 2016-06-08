package edu.example.client.models;

import edu.example.client.exceptions.DALException;

/**
 * Raavare Data Objekt
 * 
 * @author mn/sh/tb
 * @version 1.2
 */

public class RaavareDTO 
{
    private int raavareId; 		//i omraadet 1-99999999 vaelges af brugerne
    private String raavareNavn; //min. 2 max. 20 karakterer
    private String leverandoer; //min. 2 max. 20 karakterer
	
	public RaavareDTO(int raavareId, String raavareNavn, String leverandoer) {
		this.raavareId = raavareId;
		this.raavareNavn = raavareNavn;
		this.leverandoer = leverandoer;
	}
	
    public int getRaavareID() { 
    	return raavareId; 
    }
    
    public void setRaavareId(int raavareId) throws DALException { 
    	if(raavareId < 1 || raavareId > 99999999)
    		throw new DALException("Råvare ID skal være mellem 1 og 99999999, den var " + raavareId);
    	else
    		this.raavareId = raavareId; 
    }
    
    public String getRaavareNavn() { 
    	return raavareNavn; 
    }
    
    public void setRaavareNavn(String raavareNavn) throws DALException {
    	int strLength = raavareNavn.length();
    	
    	if(strLength < 2 || strLength > 20)
    		throw new DALException("Råvare navnet skal være mellem 1 og 99999999 karakterer, den var " + strLength);
    	else
    		this.raavareNavn = raavareNavn; 
    }
    
    public String getLeverandoer() { 
    	return leverandoer; 
    }
    
    public void setLeverandoer(String leverandoer) throws DALException {
    	int strLength = leverandoer.length();
    	
    	if(strLength < 2 || strLength > 20)
    		throw new DALException("Leverandørens navn skal være mellem 1 og 99999999 karakterer, den var " + strLength);
    	else
    		this.leverandoer = leverandoer; 
    }
    
    public String toString() { 
		return raavareId + "\t" + raavareNavn +"\t" + leverandoer; 
	}
}
