package cdio.models;

public class OperatorDTO 
{
    private int oprId;
    private String oprNavn;
    private String ini;
    private long cpr;
    private String password;
    private int rank;

    public OperatorDTO(int opr)
    {
            oprId = opr;
    }

    public OperatorDTO(int oprId, String oprNavn, String ini, long cpr, String password, int rank) {
        this.oprId = oprId;
        this.oprNavn = oprNavn;
        this.ini = ini;
        this.cpr = cpr;
        this.password = password;
        this.rank = rank;
    }
    
    public void setIni(String ini)
    {
            this.ini = ini;

    }

    public String getIni()
    {
            return this.ini;

    }

    public void setRank(int rank)
    {
            this.rank = rank;

    }

    public int getRank() 
    {
            return this.rank;

    }

    public void setoprId(int oprId) 
    {
            this.oprId = oprId;

    }

    public int getoprId() 
    {
            return this.oprId;

    }

    public void setName(String name)
    {
            this.oprNavn = name;

    }

    public void setCpr(long cpr) 
    {
            this.cpr = cpr;

    }

    public void setPassword(String password)
    {
            this.password = password;

    }

    public String getName()
    {
            return this.oprNavn;

    }

    public long getCpr()
    {
            return this.cpr;

    }

    public String getPassword() 
    {
            return this.password;

    }
}