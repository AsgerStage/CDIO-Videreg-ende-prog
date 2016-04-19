package cdio.view;
import cdio.functionality.IFunctionality;

/**
 * <b>View</b>
 * <p>Brugergrænseflade - Implimenterer IView.
 * @author Lasse Holm Nielsen - S123954
 * @version 24-02-2016
 */
public class View implements IView
{
    private final IFunctionality functionality;
    private Dialog dialog;
    private Thread dialogThread;
    
    public View(IFunctionality functionality) {
        this.functionality = functionality;
    }

    @Override
    public void dialog() {
        dialog = new Dialog(functionality);
        
        dialog.start();
        
//        dialogThread = new Thread(dialog);
//        dialogThread.setDaemon(false);
//        dialogThread.start();
    }

    @Override
    public void exit() {
        dialog.running = false;
        dialog.loggedIn = false;
        
//        try {
//            Thread.sleep(3000);
//            if(dialogThread.isAlive())
//                throw new ThreadDeath();
//        } 
//        catch (InterruptedException | ThreadDeath ex) {
//            System.err.println("Dialogen sluttede ikke normalt. Afslutter dialogen" + ex);
//            dialogThread.stop();
//        }
//        
//        if(dialogThread.isAlive())
//            System.err.println("Kunne ikke stoppe dialogen i brugergrænsefladen.");
    }
}