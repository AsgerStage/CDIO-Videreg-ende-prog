package cdio;
import cdio.functionality.Functionality;
import cdio.view.View;
import edu.example.server.database.OperatorDAO;
import cdio.view.IView;

public class Main 
{
    public static void main(String[] args) {
        final IView view = new View(new Functionality(new OperatorDAO()));
        view.dialog();
    }
}	