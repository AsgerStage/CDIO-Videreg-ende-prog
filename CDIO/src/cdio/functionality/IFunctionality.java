package cdio.functionality;

import cdio.models.OperatorDTO;


public interface IFunctionality {
	public int createOpr(String oprNavn, int cpr);
	public boolean deleteOpr(int oprID);
	public boolean updateOpr(int oprID, String name, int cpr, int rank);
	public OperatorDTO readOpr(OperatorDTO opr); //er det korrekt forst�et at den skal returnere et operat�r objekt??
	public boolean changePass(int oprID, String oldPass, String newPass1, String newPass2);
	public double measure(double tara, double brutto);
	public boolean login(int oprID, String password);

}



