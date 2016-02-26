package cdio.exceptions;

public class OpNameException extends Exception 
{
    private static final long serialVersionUID = 3L;
    private final String name;

    public OpNameException(String name) {
        super("Navnet overholder ikke reglerne for et navn.");
        this.name = name;
    }
}