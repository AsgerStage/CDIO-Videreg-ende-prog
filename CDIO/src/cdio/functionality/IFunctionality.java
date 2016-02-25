package cdio.functionality;

import cdio.models.OperatorDTO;


public interface IFunctionality {
void createOpr(OperatorDTO opr);
void deleteOpr(OperatorDTO opr);
void updateOpr(OperatorDTO opr);
OperatorDTO readOpr(OperatorDTO opr); //er det korrekt forst�et at den skal returnere et operat�r objekt??
void changePass(String newPassword);
double measure(double tara, double netto);
void login(String password);
	
}
