package cdio.exceptions;

public class DALException extends Throwable 
{
    private static final long serialVersionUID = 2L;
    private final String DALEx;

    public DALException(String DALEx) {
        super("Data exception");
        this.DALEx = DALEx;
    }
}