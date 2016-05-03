package edu.example.server.database;
import java.util.Objects;

import edu.example.server.database.exceptions.DALException;
import edu.example.server.database.exceptions.OpIdException;
import edu.example.server.database.exceptions.OpNameException;
import edu.example.server.database.exceptions.OpPasswordException;

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
    private String cpr;
    private String password;
    private int rank;

    public OperatorDTO(int oprID, String oprNavn, String ini, String cpr, String password, int rank) throws OpPasswordException, OpNameException, OpIdException, DALException {
        setOprID(oprID);
        setName(oprNavn);
        setIni(ini);
        setCpr(cpr);
        setPassword(password);
        setRank(rank);
    }
    
    /**
	 * @param int1
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
     * @throws OpNameException 
     * @throws OpIdException 
     * @throws OpPasswordException 
	 */
	public OperatorDTO(int oprID, String oprNavn, String ini, String cpr, String password) throws OpNameException, OpIdException, OpPasswordException {
		setOprID(oprID);
		setName(oprNavn);
		setIni(ini);
		setCpr(cpr);
		setPassword(password);
	}
	
	
	public void setIni(String ini) {
        this.ini = ini;
    }

    public String getIni() {
        return this.ini;
    }

    public void setRank(int rank) throws DALException {
        if(rank >= RANK_MINIMUM_VALUE && rank <= RANK_MAXIMUM_VALUE)
            this.rank = rank;
        else 
            throw new DALException("Operatørens rank overholder ikke kravende");
    }

    public int getRank() {
        return this.rank;
    }

    public void setOprID(int oprID) throws OpIdException {
        if(oprID >= ID_MINIMUM_VALUE && oprID <= ID_MAXIMUM_VALUE)
            this.oprID = oprID;
        else
            throw new OpIdException(oprID);
    }

    public int getOprID() {
        return this.oprID;
    }

    public void setName(String name) throws OpNameException {
        if(name != null) {
            if(name.length() >= NAME_MINIMUM_LENGTH)
                this.oprNavn = name;
            else
                throw new OpNameException("Operatør navnet overholder ikke kravende");
            }
        else
            throw new OpNameException("Operatør navnet overholder ikke kravende");
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public void setPassword(String password) throws OpPasswordException {
        if(valPass(password))
            this.password = password;
        else
            throw new OpPasswordException("Passwordet overholder ikke de opstillede krav");
    }

    public String getName() {
        return this.oprNavn;
    }

    public String getCpr() {
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
    
    public static String rankToString(int rank) {
    	switch (rank) {
		case RANK_OPR:
			return "Operator";
		case RANK_ADMIN:
			return "Administrator";
		default:
			return "Undefined";
		}
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
        hash = 61 * hash + Objects.hashCode(this.cpr);
        hash = 61 * hash + Objects.hashCode(this.password);
        hash = 61 * hash + this.rank;
        return hash;
    }
}