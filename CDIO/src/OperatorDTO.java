import java.util.List;
import java.util.Scanner;

public class OperatorDTO {
	int oprId;
	String oprNavn;
	String ini;
	int cpr;
	char[] password;




public void setName(String name)
{
	this.oprNavn=name;
	
}
public void setCpr(int cpr)
{
	this.cpr=cpr;
	
}

public void setPassword(char[] password)
{
	this.password=password;
	
}
public String getName(int oprId)
{
	return this.oprNavn;
	
}
public int getCpr(int oprId)
{
	return this.cpr;
	
}

public char[] getPassword(int oprId)
{
	return this.password;
	
}

}