public class OpIdException extends Exception {

	private static final long serialVersionUID = 5L;
	private int oprId;

	public OpIdException(int oprId) {

		super("operat�r ID er forkert");
		this.oprId = oprId;
	}

}