package edu.example.client.models;

import java.io.Serializable;
import java.util.Objects;

import edu.example.client.exceptions.DALException;

public class RaavarebatchDTO implements Serializable
{
	private static final long serialVersionUID = -5690218368376087354L;
	private int rbID;			// i omraadet 1-99999999
	private RaavareDTO raavare;	// i omraadet 1-99999999
	private double maengde;		// kan vaere negativ 
	
	public RaavarebatchDTO() {
		
	}
	
	public RaavarebatchDTO(int rbID, RaavareDTO raavare, double maengde)	{
		this.rbID = rbID;
		this.raavare = raavare;
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
	
	public RaavareDTO getRaavare() {
		return raavare; 
	}
	
	public void setRaavare(RaavareDTO raavare) throws DALException {		
		if(raavare.getRaavareID() < 1 || raavare.getRaavareID() > 99999999)
    		throw new DALException("Råvare ID skal være mellem 1 og 99999999, den var " + raavare);
    	else
    		this.raavare = raavare; 
	}
	
	public double getMaengde() {
		return maengde; 
	}
	
	public void setMaengde(double maengde) {
		this.maengde = maengde;
	}
	
	@Override
	public String toString() { 
		return "{ID=" + rbID + ", Råvare=" + raavare + ", Mængde=" + maengde + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) 
            return false;
        final RaavarebatchDTO other = (RaavarebatchDTO) obj;
        
        return this.rbID == other.rbID &&
        		Objects.equals(this.raavare, other.raavare) &&
        		this.maengde == other.maengde;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
