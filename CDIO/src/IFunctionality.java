
public interface IFunctionality {
void createOpr(OperatoerDTO opr);
void deleteOpr(OperatoerDTO opr);
void updateOpr(OperatoerDTO opr);
OperatoerDTO readOpr(OperatoerDTO opr); //er det korrekt forstået at den skal returnere et operatør objekt??
void changePass(String newPassword);
double measure(double tara, double netto);
void login(String password);
	
}
