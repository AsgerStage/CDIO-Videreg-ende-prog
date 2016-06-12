package edu.example.client.models;

import java.io.Serializable;

import edu.example.client.exceptions.DALException;

public class ReceptkompDTO implements Serializable
{
	private static final long serialVersionUID = 938514113943474673L;
	private int receptID;		// i området 1-99999999   
	private int raavareID;		// i området 1-99999999
	private double nomNetto;	// i området 0.05 til 20.0 kg
	private double tolerance;	// i området 0.1 til 10.0 %
	
	public ReceptkompDTO() {
		
	}
	
	public ReceptkompDTO(int receptID, int raavareID, double nomNetto, double tolerance) throws DALException {
		setReceptID(receptID);
		setRaavareID(raavareID);
		setNomNetto(nomNetto);
		setTolerance(tolerance);
	}

	public int getReceptID() {
		return receptID; 
	}
	
	public void setReceptID(int receptID) throws DALException {
		if(receptID < 1 || receptID > 99999999)
    		throw new DALException("Receptens ID skal være mellem 1 og 99999999, den var " + receptID);
    	else
    		this.receptID = receptID;
	}
	
	public int getRaavareID() {
		return raavareID; 
	}
	
	public void setRaavareID(int raavareID) throws DALException {
		if(raavareID < 1 || raavareID > 99999999)
    		throw new DALException("Råvarens ID skal være mellem 1 og 99999999, den var " + raavareID);
    	else
    		this.raavareID = raavareID;
	}
	
	public double getNomNetto() { 
		return nomNetto;
	}
	
	public void setNomNetto(double nomNetto) throws DALException {
		if(nomNetto < 0.05 || nomNetto > 20.0)
    		throw new DALException("Den norminelle vægt skal være mellem 0.05 og 20.0 kg, den var " + nomNetto);
    	else
    		this.nomNetto = nomNetto;
	}
	
	public double getTolerance() { 
		return tolerance; 
	}
	
	public void setTolerance(double tolerance) throws DALException {
		if(tolerance < 0.1 || tolerance > 10.0)
    		throw new DALException("Tolerancen skal være mellem 0.1 og 10.0 %, den var " + tolerance);
    	else
    		this.tolerance = tolerance;
	}
	
	@Override
	public String toString() {
		return "{receptID=" + receptID + ", raavareId=" + raavareID + ", nomNetto=" + nomNetto + ", tolerance=" + tolerance + '}'; 
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) 
            return false;
        final ReceptkompDTO other = (ReceptkompDTO) obj;
        
        return this.receptID == other.receptID &&
        		this.raavareID == other.raavareID &&
                this.nomNetto == other.nomNetto &&
                this.tolerance == other.tolerance;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
