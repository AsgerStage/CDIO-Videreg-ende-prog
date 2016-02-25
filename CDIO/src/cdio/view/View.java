package cdio.view;

import cdio.exceptions.DALException;
import cdio.functionality.IFunctionality;
import cdio.models.OperatorDTO;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        
        dialogThread = new Thread(dialog);
        dialogThread.setDaemon(false);
        dialogThread.start();
    }

    @Override
    public void exit() {
        dialog.running = false;
        dialog.loggedIn = false;
        
        try {
            Thread.sleep(3000);
            if(dialogThread.isAlive())
                throw new ThreadDeath();
        } 
        catch (InterruptedException | ThreadDeath ex) {
            System.err.println("Dialogen sluttede ikke normalt. Afslutter dialogen" + ex);
            dialogThread.stop();
        }
        
        if(dialogThread.isAlive())
            System.err.println("Kunne ikke stoppe dialogen i brugergrænsefladen.");
    }
}

/**
 * <b>Dialog</b>
 * <p>Kører brugergrænsefladen - Implimenterer Runable.
 * @author Lasse Holm Nielsen - S123954
 * @version 24-02-2016
 */
class Dialog implements Runnable
{
    protected boolean running = true;
    protected boolean loggedIn = false;
    
    private final IFunctionality functionality;
    private OperatorDTO currUser;
    private Scanner scanner;
    private final int MENUOPTION_EXIT = 0;
    private final int MENUOPTION_MEASURE = 1;
    private final int MENUOPTION_PROFILE = 2;
    private final int MENUOPTION_CHANGE_PASSWORD = 3;
    private final int MENUOPTION_READ_USER = 4;
    private final int MENUOPTION_CREATE_USER = 5;
    private final int MENUOPTION_UPDATE_USER = 6;
    private final int MENUOPTION_DELETE_USER = 7;

    public Dialog(IFunctionality functionality) {
        currUser = null;
        this.functionality = functionality;
    }
    
    @Override
    public void run() {
        while(running) {
            scanner = new Scanner(System.in);
            System.out.println("\n*******************************************");
            System.out.print("\nLogin");
            System.out.print("\n\tUser Name:\t");
            String userName = scanner.nextLine();
            System.out.print("\tPassword:\t");
            String password = scanner.nextLine();
            
            currUser = login(userName, password);
            
            if(currUser != null) {
//                switch(currUser.rank) {
                switch(1) {
                    case 1: { //Administrator
                        loggedIn = true;
                        menu(true);
                        break;
                    }
                    case 0: { //Operatør
                        loggedIn = true;
                        menu(false);
                        break;
                    }
                    default:
                    case -1: { //Uautorisret bruger
                        System.out.println("Du har ikke tilladelse til denne funktion");
                        break;
                    }
                }
            }
            else
                System.out.println("Bruger eller password er inkorrekt");
        }
    }
    
    private OperatorDTO login(String user, String password) {
//        try {
//            return functionality.login(user, password);
//        } catch (DALException e) {
//            return null;
//        }
//        return null;
        return new OperatorDTO(10);
    }
    
    private void menu(boolean isAdmin) {
        while(loggedIn) {
            System.out.println("\n*******************************************");
            System.out.println("Menu");
            System.out.println("\t" + MENUOPTION_MEASURE + ". Lav måling");
            System.out.println("\t" + MENUOPTION_PROFILE + ". Se profil");
            System.out.println("\t" + MENUOPTION_CHANGE_PASSWORD + ". Skift password");
            if(isAdmin) {
                System.out.println("\t" + MENUOPTION_READ_USER + ". Læs bruger");
                System.out.println("\t" + MENUOPTION_CREATE_USER + ". Opret bruger");
                System.out.println("\t" + MENUOPTION_UPDATE_USER + ". Opdater bruger");
                System.out.println("\t" + MENUOPTION_DELETE_USER + ". Slet bruger");
            }
            System.out.println("\n\t" + MENUOPTION_EXIT + ". Afslut");

            System.out.print("\nIndtast ønskede handling: ");
            int action;
            try {
                action = scanner.nextInt();
            } 
            catch (InputMismatchException e) {
                action = -1;
                scanner.next();
                scanner.reset();
                System.err.println(e);
            }
            
            switch(action) {
                
                case MENUOPTION_MEASURE: {
                    try {
                        measure();
                    } 
                    catch (DALException ex) {
                        System.out.println("Kunne ikke foretage afvejningen: " + ex);
                    } 
                    catch (InputMismatchException ex) {
                        scanner.next();
                        scanner.reset();
                        System.out.println("Ugyldig indtastning: " + ex);
                    }
                    break;
                }
                
                case MENUOPTION_PROFILE: {
                    try {
                        viewProfile(currUser);
                    } 
                    catch (DALException ex) {
                        System.out.println("Kunne ikke læse din profil: " + ex);
                    }
                    break;
                }
                
                case MENUOPTION_CHANGE_PASSWORD: {
                    try {
                        changePassword(currUser);
                    } 
                    catch (DALException ex) {
                        System.out.println("Kunne ikke skifte dit password: " + ex);
                    } 
                    catch (InputMismatchException ex) {
                        scanner.next();
                        scanner.reset();
                        System.out.println("Ugyldig indtastning: " + ex);
                    }
                    break;
                }
                
                case MENUOPTION_READ_USER: {
                    if(isAdmin) {
                        try {
                            readUser();
                        } 
                        catch (DALException ex) {
                            System.out.println("Kunne ikke læse brugeren: " + ex);
                        } 
                        catch (InputMismatchException ex) {
                            scanner.next();
                            scanner.reset();
                            System.out.println("Ugyldig indtastning: " + ex);
                        }
                    }
                    else
                        System.out.println("Du har ikke rettigheder til at læse andre brugeres data");
                    
                    break;
                }
                
                case MENUOPTION_CREATE_USER: {
                    if(isAdmin) {
                        try {
                            createUser();
                        } 
                        catch (DALException ex) {
                            System.out.println("Kunne ikke oprette brugeren: " + ex);
                        } 
                        catch (InputMismatchException ex) {
                            scanner.next();
                            scanner.reset();
                            System.out.println("Ugyldig indtastning: " + ex);
                        }
                    }
                    else
                        System.out.println("Du har ikke rettigheder til at oprette brugere");
                    break;
                }
                
                case MENUOPTION_UPDATE_USER: {
                    if(isAdmin) {
                        try {
                            updateUser();
                        } 
                        catch (DALException ex) {
                            System.out.println("Kunne ikke opdatere brugeren: " + ex);
                        } 
                        catch (InputMismatchException ex) {
                            scanner.next();
                            scanner.reset();
                            System.out.println("Ugyldig indtastning: " + ex);
                        }
                    }
                    else
                        System.out.println("Du har ikke rettigheder til at ændre andre brugeres data");                    
                    break;
                }
                
                case MENUOPTION_DELETE_USER: {
                    if(isAdmin) {
                        try {
                            deleteUser();
                        } 
                        catch (DALException ex) {
                            System.out.println("Kunne ikke slette brugeren: " + ex);
                        } 
                        catch (InputMismatchException ex) {
                            scanner.next();
                            scanner.reset();
                            System.out.println("Ugyldig indtastning: " + ex);
                        }
                    }
                    else
                        System.out.println("Du har ikke rettigheder til at slette brugere");                    
                    break;
                }
                
                case MENUOPTION_EXIT: {
                    loggedIn = false;
                    currUser = null;
                    System.out.println("Du er nu logget ud");
                    break;
                }
                
                default: 
                case -1: {
                    System.out.println("Ukendt kommando: " + action);
                    break;
                }
            }
        }
    }
    
    private void measure() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        double tara, brutto;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Afvejning");
        try {
            System.out.print("\tTara vægt = ");
            tara = scanner.nextDouble();
            System.out.print("\tBrutto vægt = ");
            brutto = scanner.nextDouble();
        } 
        catch (InputMismatchException e) {
            throw e;
        }
        System.out.println("\tNettovægt = " + functionality.measure(tara, brutto));
    }
    
//    private void viewProfile(int userID) throws DALException {
//        OperatorDTO userDTO = functionality.readOpr(userID);
    private void viewProfile(OperatorDTO user) throws DALException {
        scanner = new Scanner(System.in);
        System.out.println("\n-------------------------------------------");
        System.out.println("Profil");
        
        final OperatorDTO userDTO = functionality.readOpr(user);
        if(userDTO != null) {
            System.out.println("\tNavn:\t" + userDTO.getName());
            System.out.println("\tID:\t" + userDTO.getoprId());
            System.out.println("\tCPR:\t" + userDTO.getCpr());
        }
        else
            System.out.println("Kunne ikke læse din profil");
    }
    
    private void changePassword(OperatorDTO user) throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        String oldPass, newPass1, newPass2;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Skift password");
        
        System.out.print("\tGammelt password: ");
        oldPass = scanner.nextLine();
        System.out.print("\tNyt password: ");
        newPass1 = scanner.nextLine();
        System.out.print("\tNyt password: ");
        newPass2 = scanner.nextLine();
        
//        functionality.changePass(oldPass, newPass1, newPass2);
        functionality.changePass(newPass1);
    }
    
    private void readUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        int userID;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Læs bruger");
        
        System.out.print("\tOperatør id: ");
        userID = scanner.nextInt();
        
        final OperatorDTO userDTO = null; // = functionality.readOpr(userID);
        if(userDTO != null) {
            System.out.println("\tNavn:\t" + userDTO.getName());
            System.out.println("\tID:\t" + userDTO.getoprId());
            System.out.println("\tCPR:\t" + userDTO.getCpr());
            System.out.println("\tPassword:\t" + userDTO.getPassword());
        }
        else
            System.out.println("Kunne ikke finde operatøren med id " + userID);
    }
    
    private void createUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        String name;
        int cpr, oprId;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Opret bruger");
        
        System.out.print("\tNavn: ");
        name = scanner.nextLine();
        System.out.print("\tCPR: ");
        cpr = scanner.nextInt();
        
//        oprId = functionality.createOpr(name, cpr);
//        System.out.println("Bruger oprattet med operatør id: " + oprId);
        System.out.println("Fjern kommentering");
    }
    
    private void updateUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        String name, password;
        int cpr, oprId;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Opdater bruger");
        
        System.out.print("\tBruger ID: ");
        oprId = scanner.nextInt();
        System.out.print("\tNavn: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("\tCPR: ");
        cpr = scanner.nextInt();
        System.out.print("\tPassword: ");
        password = new Scanner(System.in).nextLine();
        
//        boolean isUpdate = functionality.updateOpr(new OperatorDTO(oprId, name, cpr, password));
//        if(isUpdate)
//            System.out.println("Brugeren " + oprId + " blev opdateret");
//        else
//            System.out.println("Kunne ikke opdatere brugeren");
        System.out.println("Fjern kommentering");
    }
    
    private void deleteUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        int oprId;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Slet bruger");
        
        System.out.print("\tBruger ID: ");
        oprId = scanner.nextInt();
        
//        boolean isDeleted = functionality.deleteOpr(oprId);
//        if(isDeleted)
//            System.out.println("Brugeren " + oprId + " blev fjernet");
//        else
//            System.out.println("Kunne ikke slette brugeren");
        System.out.println("Fjern kommentering");
    }
}