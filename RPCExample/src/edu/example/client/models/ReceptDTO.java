package edu.example.client.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * Recept Data Objekt
 * 
 * @author mn/tb
 * @version 1.2
 */

public class ReceptDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7970032674348618324L;
	/** Recept nr i omraadet 1-99999999 */
	private int receptId;
	/** Receptnavn min. 2 max. 20 karakterer */
	private	String receptNavn;
	/** liste af kompenenter i recepten */
	
    public ReceptDTO(){
    }
    
	public ReceptDTO(int receptId, String receptNavn)
	{
        this.receptId = receptId;
        this.receptNavn = receptNavn;
    }

    public int getReceptId() { return receptId; }
	public void setReceptId(int receptId) { this.receptId = receptId; }
	public String getReceptNavn() { return receptNavn; }
	public void setReceptNavn(String receptNavn) { this.receptNavn = receptNavn; }
	public String toString() { 
		return receptId + "\t" + receptNavn; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) 
            return false;
        final ReceptDTO other = (ReceptDTO) obj;
        
        return this.receptId == other.receptId &&
               Objects.equals(this.receptNavn, other.receptNavn);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
