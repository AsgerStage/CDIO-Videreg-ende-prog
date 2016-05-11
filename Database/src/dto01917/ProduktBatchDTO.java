package dto01917;

public class ProduktBatchDTO
{
    int pbId;           // i omraadet 1-99999999
    int status;		// 0: ikke paabegyndt, 1: under produktion, 2: afsluttet
    int receptId;
    
    public ProduktBatchDTO(int pbId, int status, int receptId) {
        this.pbId = pbId;
        this.status = status;
        this.receptId = receptId;
    }
    
    public int getPbId() { return pbId; }
    public void setPbId(int pbId) { this.pbId = pbId; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public int getReceptId() { return receptId; }
    public void setReceptId(int receptId) { this.receptId = receptId; }
    @Override
    public String toString() {return "[" + pbId + ", " + status + ", " + receptId + ']'; }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.pbId;
        hash = 23 * hash + this.status;
        hash = 23 * hash + this.receptId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        final ProduktBatchDTO other = (ProduktBatchDTO) obj;
        
        return this.pbId == other.pbId &&
                this.status == other.status &&
                this.receptId == other.receptId;
    }
}