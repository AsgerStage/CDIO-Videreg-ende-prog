package edu.example.client.models;

import java.io.Serializable;

import edu.example.client.exceptions.DALException;

public class ProduktbatchkompDTO implements Serializable
{
	private static final long serialVersionUID = -576200452760072531L;
	
	private int pbID;		// produktbatch id i området 1-99999999
	private int rbID;       // råvarebatch id i området 1-99999999
	private double tara;	// 
	private double netto;	// 
	private int oprID;		// operatoer id i området 1-99999999
	
	public ProduktbatchkompDTO() { 
		
	}
	
	public ProduktbatchkompDTO(int pbID, int rbID, double tara, double netto, int oprID) throws DALException {
		setPbID(pbID);
		setRbID(rbID);
		setTara(tara);
		setNetto(netto);
		setOprID(oprID);
	}
	
	public int getPbID() {
		return pbID;
	}
	
	public void setPbID(int pbID) throws DALException {
		if(pbID < 1 || pbID > 99999999)
    		throw new DALException("produktbatch ID skal være mellem 1 og 99999999, den var " + pbID);
    	else
    		this.pbID = pbID;
	}
	
	public int getRbID() {
		return rbID;
	}
	
	public void setRbID(int rbID) throws DALException {
		if(rbID < 1 || rbID > 99999999)
    		throw new DALException("Råvare ID skal være mellem 1 og 99999999, den var " + rbID);
    	else
    		this.rbID = rbID;
	}
	
	public double getTara() {
		return tara;
	}
	
	public void setTara(double tara) {
		this.tara = tara;
	}
	
	public double getNetto() {
		return netto;
	}
	
	public void setNetto(double netto) {
		this.netto = netto;
	}
	
	public int getOprID() {
		return oprID;
	}
	
	public void setOprID(int oprID) throws DALException {
		if(oprID < 1 || oprID > 99999999)
    		throw new DALException("Operatør ID skal være mellem 1 og 99999999, den var " + oprID);
    	else
    		this.oprID = oprID;
	}
	
	@Override
	public String toString() {
		return "{PBID=" + pbID + ", RBID=" + rbID + ", Tara=" + tara + ", Netto=" + netto + ", OprID=" + oprID + '}'; 
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) 
            return false;
        final ProduktbatchkompDTO other = (ProduktbatchkompDTO) obj;
        
        return this.pbID == other.pbID &&
        		this.rbID == other.rbID &&
                this.tara == other.tara &&
                this.netto == other.netto &&
                this.oprID == other.oprID;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
