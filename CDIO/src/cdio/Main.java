package cdio;
import cdio.exceptions.DALException;
import cdio.data.OperatorDAO;
import cdio.functionality.Functionality;
import cdio.view.View;
import cdio.view.IView;

public class Main 
{
    public static void main(String[] args) throws DALException {
        final IView view = new View(new Functionality(new OperatorDAO()));
        view.dialog();
    }
}	