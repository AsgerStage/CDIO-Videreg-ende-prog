package cdio.models;

public class OperatorDTO 
{
    private int oprID;
    private String oprNavn;
    private String ini;
    private long cpr;
    private String password;
    private int rank;

    public OperatorDTO(int opr) {
        oprID = opr;
    }

    public OperatorDTO(int oprID, String oprNavn, String ini, long cpr, String password, int rank) {
        this.oprID = oprID;
        this.oprNavn = oprNavn;
        this.ini = ini;
        this.cpr = cpr;
        this.password = password;
        this.rank = rank;
    }
    
    public void setIni(String ini) {
        this.ini = ini;
    }

    public String getIni() {
        return this.ini;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
            return this.rank;
    }

    public void setoprId(int oprID) {
            this.oprID = oprID;
    }

    public int getoprID() {
            return this.oprID;
    }

    public void setName(String name) {
            this.oprNavn = name;
    }

    public void setCpr(long cpr) {
            this.cpr = cpr;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getName() {
            return this.oprNavn;
    }

    public long getCpr() {
            return this.cpr;
    }

    public String getPassword() {
            return this.password;
    }

    @Override
    public String toString() {
        return "OperatorDTO{" + "oprID=" + oprID + ", oprNavn=" + oprNavn + ", ini=" + ini + ", cpr=" + cpr + ", password=" + password + ", rank=" + rank + '}';
    }
}