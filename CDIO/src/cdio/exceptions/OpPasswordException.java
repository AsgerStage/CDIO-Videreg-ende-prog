package cdio.exceptions;

public class OpPasswordException extends Exception{
    private static final long serialVersionUID = 4L;
    private String password;

    public OpPasswordException(String password) {
        super("Koden overholder ikke reglerne for kodeord");
        this.password = password;
    }
}