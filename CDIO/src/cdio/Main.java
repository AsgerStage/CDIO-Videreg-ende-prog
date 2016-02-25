package cdio;

import cdio.models.OperatorDTO;
import cdio.exceptions.DALException;
import cdio.data.OperatorDAO;
import cdio.functionality.Functionality;
import cdio.view.View;
import cdio.view.IView;


public class Main 
{
    public static void main(String[] args) throws DALException {
       
    	OperatorDAO ops =new OperatorDAO();
    	OperatorDTO op=new OperatorDTO(11);
    	ops.createOperatoer(op);
    	
        IView view = new View(new Functionality(new OperatorDAO()));
        view.dialog();
    	
    	
    	System.out.println(ops.getOperator(11)); 
    }
}	