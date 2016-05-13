package dto01917;

public class RaavareBatchDTO
{
    int rbId;                   // i omraadet 1-99999999
    int raavareId;              // i omraadet 1-99999999
    double maengde;             // kan vaere negativ
    
    public RaavareBatchDTO(int rbId, int raavareId, double maengde)
    {
        this.rbId = rbId;
        this.raavareId = raavareId;
        this.maengde = maengde;
    }
    
    public int getRbId() { return rbId; }
    public void setRbId(int rbId) { this.rbId = rbId; }
    public int getRaavareId() { return raavareId; }
    public void setRaavareId(int raavareId) { this.raavareId = raavareId; }
    public double getMaengde() { return maengde; }
    public void setMaengde(double maengde) { this.maengde = maengde; }
    @Override
    public String toString() {
        return rbId + "\t" + raavareId +"\t" + maengde;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.rbId;
        hash = 43 * hash + this.raavareId;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.maengde) ^ (Double.doubleToLongBits(this.maengde) >>> 32));
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        final RaavareBatchDTO other = (RaavareBatchDTO) obj;
        
        return this.rbId == other.rbId &&
                this.raavareId == other.raavareId &&
                Double.doubleToLongBits(this.maengde) == Double.doubleToLongBits(other.maengde);
    }
}
