package dto01917;

public class ProduktBatchKompDTO
{
    int pbId; 	  // produktbatchets id
    int rbId;        // i omraadet 1-99999999
    double tara;
    double netto;
    int oprId;					// operatoer-nummer
    
    
    public ProduktBatchKompDTO(int pbId, int rbId, double tara, double netto, int oprId)
    {
        this.pbId = pbId;
        this.rbId = rbId;
        this.tara = tara;
        this.netto = netto;
        this.oprId = oprId;
    }
    
    public int getPbId() { return pbId; }
    public void setPbId(int pbId) { this.pbId = pbId; }
    public int getRbId() { return rbId; }
    public void setRbId(int rbId) { this.rbId = rbId; }
    public double getTara() { return tara; }
    public void setTara(double tara) { this.tara = tara; }
    public double getNetto() { return netto; }
    public void setNetto(double netto) { this.netto = netto; }
    public int getOprId() { return oprId; }
    public void setOprId(int oprId) { this.oprId = oprId; }
    public String toString() {
        return "[" + pbId + ", " + rbId +", " + tara +", " + netto + ", " + oprId + ']';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.pbId;
        hash = 97 * hash + this.rbId;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.tara) ^ (Double.doubleToLongBits(this.tara) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.netto) ^ (Double.doubleToLongBits(this.netto) >>> 32));
        hash = 97 * hash + this.oprId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        final ProduktBatchKompDTO other = (ProduktBatchKompDTO) obj;
        
        return this.pbId == other.pbId &&
                this.rbId == other.rbId &&
                Double.doubleToLongBits(this.tara) == Double.doubleToLongBits(other.tara) &&
                Double.doubleToLongBits(this.netto) == Double.doubleToLongBits(other.netto) &&
                this.oprId == other.oprId;
    }
}