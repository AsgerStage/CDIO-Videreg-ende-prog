package cdio;
import cdio.data.OperatorDAO;
import cdio.functionality.Functionality;
import cdio.view.View;
import cdio.view.IView;

public class Main 
{
    public static void main(String[] args) {
        final IView view = new View(new Functionality(new OperatorDAO()));
        view.dialog();
    }
}	