package edu.example.client.temp;
import java.util.Objects;

public final class OperatorDTO 
{
    public static final int RANK_OPR = 0;
	public static final int RANK_ADMIN = 1;
	
	private final int ID_MINIMUM_VALUE = 11;
    private final int ID_MAXIMUM_VALUE = 99;
    private final int RANK_MINIMUM_VALUE = -1;
    private final int RANK_MAXIMUM_VALUE = 1;
    private final int NAME_MINIMUM_LENGTH = 2;
    private final int PASSWORD_MINIMUM_LENGTH = 6;
    private final int NUMBER_OF_SPECIAL_CHARACTERS = 3;
    
    private int oprID;
    private String oprNavn;
    private String ini;
    private long cpr;
    private String password;
    private int rank;

    public OperatorDTO(int oprID, String oprNavn, String ini, long cpr, String password, int rank) {
        setOprID(oprID);
        setName(oprNavn);
        setIni(ini);
        setCpr(cpr);
        setPassword(password);
        setRank(rank);
    }
    
    public void setIni(String ini) {
        this.ini = ini;
    }

    public String getIni() {
        return this.ini;
    }

    public void setRank(int rank) {
        if(rank >= RANK_MINIMUM_VALUE && rank <= RANK_MAXIMUM_VALUE)
            this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    public void setOprID(int oprID) {
        if(oprID >= ID_MINIMUM_VALUE && oprID <= ID_MAXIMUM_VALUE)
            this.oprID = oprID;
    }

    public int getOprID() {
        return this.oprID;
    }

    public void setName(String name) {
        if(name != null) {
            if(name.length() >= NAME_MINIMUM_LENGTH)
                this.oprNavn = name;
            }
    }

    public void setCpr(long cpr) {
        this.cpr = cpr;
    }

    public void setPassword(String password) {
        if(valPass(password))
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
    
    private boolean valPass(String pass) {
        if(pass.length() < PASSWORD_MINIMUM_LENGTH)
            return false;
        
        byte lowerCase = 0;
        byte upperCase = 0;
        byte digit = 0;
        byte specialChar = 0;
        char[] passChar = pass.toCharArray();
        
        for (char c : passChar) {
            if(Character.isLowerCase(c)) 
                lowerCase = 1;
            else if(Character.isUpperCase(c))
                upperCase = 1;
            else if(Character.isDigit(c)) 
                digit = 1;
            else if(c == 46 || c == 45 || c == 95 || c == 43 || c ==33 || c == 63 || c == 61) 
                specialChar = 1;
            else 
                return false;
        }
        return (lowerCase + upperCase + digit + specialChar) >= NUMBER_OF_SPECIAL_CHARACTERS;
    }

    @Override
    public String toString() {
        return "OperatorDTO{" + "oprID=" + oprID + ", oprNavn=" + oprNavn + ", ini=" + ini + ", cpr=" + cpr + ", password=" + password + ", rank=" + rank + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        final OperatorDTO other = (OperatorDTO) obj;
        
        return this.oprID == other.oprID &&
               Objects.equals(this.oprNavn, other.oprNavn) &&
               Objects.equals(this.ini, other.ini) &&
               this.cpr == other.cpr &&
               Objects.equals(this.password, other.password) && 
               this.rank == other.rank;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.oprID;
        hash = 61 * hash + Objects.hashCode(this.oprNavn);
        hash = 61 * hash + Objects.hashCode(this.ini);
        hash = 61 * hash + (int) (this.cpr ^ (this.cpr >>> 32));
        hash = 61 * hash + Objects.hashCode(this.password);
        hash = 61 * hash + this.rank;
        return hash;
    }

	public static String rankToString(int rank) {
		switch (rank) {
		case RANK_OPR:
			return "Operator";
		case RANK_ADMIN:
			return "Administrator";		
		default:
			return null;
		}
	}
}