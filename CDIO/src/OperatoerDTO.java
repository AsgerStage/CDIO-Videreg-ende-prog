import java.util.List;
import java.util.Scanner;

public class OperatoerDTO implements IOperatoerDAO {
	int oprId;
	String oprNavn;
	String ini;
	int cpr;
	char[] password;

public static void main(String[] arg)
{
@SuppressWarnings("resource")
Scanner scanner = new Scanner(System.in);
System.out.println("Indtast CPR nr.");

int nr = scanner.nextInt();

	

}

@Override
public OperatoerDTO getOperatoer(int oprId) throws DALException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<OperatoerDTO> getOperatoerList() throws DALException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void createOperatoer(OperatoerDTO opr) throws DALException {
	// TODO Auto-generated method stub
	
}

@Override
public void updateOperatoer(OperatoerDTO opr) throws DALException {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteOperatoer(OperatoerDTO opr) throws DALException {
	// TODO Auto-generated method stub
	
}
}