package dto01917;

/**
 * Recept Data Objekt
 * 
 * @author mn/tb
 * @version 1.2
 */

public class ReceptDTO 
{
	/** Recept nr i omraadet 1-99999999 */
	int receptId;
	/** Receptnavn min. 2 max. 20 karakterer */
	String receptNavn;
	/** liste af kompenenter i recepten */
	
    
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
                this.receptNavn.equals(other.receptNavn);

    }
}
