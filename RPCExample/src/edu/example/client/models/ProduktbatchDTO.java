package edu.example.client.models;

import java.io.Serializable;

import edu.example.client.exceptions.DALException;

public class ProduktbatchDTO implements Serializable
{
	private static final long serialVersionUID = 8533525616049826629L;
	private static final int STATUS_NOT_STARTET = 0;
	private static final int STATUS_STARTET = 1;
	private static final int STATUS_COMPLETE = 2;	
	
	private int pbID;		// i omraadet 1-99999999
	private int status;		// 0: ikke paabegyndt, 1: under produktion, 2: afsluttet
	private int receptID;
	
	public ProduktbatchDTO() {
		
	}
	
	public ProduktbatchDTO(int pbID, int status, int receptID) {
		this.pbID = pbID;
		this.status = status;
		this.receptID = receptID;
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
	
	public int getStatus() { 
		return status; 
	}
	
	public void setStatus(int status) throws DALException { 
		if(status < 0 || status > 2)
    		throw new DALException("Status skal være mellem 0 og 2, den var " + status);
    	else
    		this.status = status;
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
	
	public static String statusToString(int status) {
		switch (status) {
			case STATUS_NOT_STARTET:
				return "Ikke påbegyndt";
			case STATUS_STARTET:
				return "Under produktion";
			case STATUS_COMPLETE:
				return "Afsluttet";
			default:
				return "Ikke defineret";
		}
	}

	@Override
	public String toString() { 
		return "{ID=" + pbID + ", ReceptID=" + receptID + ", Status=" + status + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) 
            return false;
        final ProduktbatchDTO other = (ProduktbatchDTO) obj;
        
        return this.pbID == other.pbID &&
        		this.receptID == other.receptID &&
        		this.status == other.status;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}