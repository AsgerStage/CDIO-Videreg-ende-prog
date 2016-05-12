package dto01917;

/**
 * Raavare Data Objekt
 * 
 * @author mn/sh/tb
 * @version 1.2
 */

public class RaavareDTO 
{
    /** i omraadet 1-99999999 vaelges af brugerne */
    int raavareId;                     
    /** min. 2 max. 20 karakterer */
    String raavareNavn;                
    /** min. 2 max. 20 karakterer */
    String leverandoer;         
	
	public RaavareDTO(int raavareId, String raavareNavn, String leverandoer)
	{
		this.raavareId = raavareId;
		this.raavareNavn = raavareNavn;
		this.leverandoer = leverandoer;
	}
	
    public int getRaavareId() { return raavareId; }
    public void setRaavareId(int raavareId) { this.raavareId = raavareId; }
    public String getRaavareNavn() { return raavareNavn; }
    public void setRaavareNavn(String raavareNavn) { this.raavareNavn = raavareNavn; }
    public String getLeverandoer() { return leverandoer; }
    public void setLeverandoer(String leverandoer) { this.leverandoer = leverandoer; }
    public String toString() { 
		return raavareId + "\t" + raavareNavn +"\t" + leverandoer; 
	}
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        final RaavareDTO other = (RaavareDTO) obj;
        
        return this.raavareId == other.raavareId &&
                this.raavareNavn.equals(other.raavareNavn) &&
                this.leverandoer.equals(other.leverandoer);

    }
}
