package edu.example.client.models;

import java.io.Serializable;

import edu.example.client.exceptions.DALException;

public class RaavareBatchDTO implements Serializable
{
	private static final long serialVersionUID = -5690218368376087354L;
	private int rbID;			// i omraadet 1-99999999
	private int raavareID;		// i omraadet 1-99999999
	private double maengde;		// kan vaere negativ 
	
	public RaavareBatchDTO() {
		
	}
	
	public RaavareBatchDTO(int rbId, int raavareId, double maengde)	{
		this.rbID = rbId;
		this.raavareID = raavareId;
		this.maengde = maengde;
	}
	
	public int getRbID() {
		return rbID; 
	}
	
	public void setRbID(int rbID) throws DALException {
		if(rbID < 1 || rbID > 99999999)
    		throw new DALException("Råvarebatch ID skal være mellem 1 og 99999999, den var " + rbID);
    	else
    		this.rbID = rbID; 
	}
	
	public int getRaavareID() {
		return raavareID; 
	}
	
	public void setRaavareID(int raavareID) throws DALException {		
		if(raavareID < 1 || raavareID > 99999999)
    		throw new DALException("Råvare ID skal være mellem 1 og 99999999, den var " + raavareID);
    	else
    		this.raavareID = raavareID; 
	}
	
	public double getMaengde() {
		return maengde; 
	}
	
	public void setMaengde(double maengde) {
		this.maengde = maengde;
	}
	
	public String toString() { 
		return "{ID=" + rbID + ", RåvareID=" + raavareID + ", Mængde=" + maengde + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) 
            return false;
        final RaavareBatchDTO other = (RaavareBatchDTO) obj;
        
        return this.rbID == other.rbID &&
        		this.raavareID == other.raavareID &&
        		this.maengde == other.maengde;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
