package cdio.functionality;

import cdio.models.OperatorDTO;


public interface IFunctionality {
	public void createOpr(String oprNavn, int cpr);
	public boolean deleteOpr(int oprId);
	public void updateOpr(int oprId);
	OperatorDTO readOpr(OperatorDTO opr); //er det korrekt forst�et at den skal returnere et operat�r objekt??
	public boolean changePass(int oprId);
	double measure(double tara, double netto);
	void login(String password);

}



