package cdio.view;
import cdio.exceptions.DALException;
import cdio.functionality.IFunctionality;
import cdio.models.OperatorDTO;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Dialog</b>
 * <p>Kører brugergrænsefladen - Implimenterer Runable.
 * @author Lasse Holm Nielsen - S123954
 * @version 24-02-2016
 */
public class Dialog implements Runnable
{
    protected boolean running = true;
    protected boolean loggedIn = false;
    
    private final IFunctionality functionality;
    private int currUserID;
    private Scanner scanner;
    private final int MENUOPTION_EXIT = 0;
    private final int MENUOPTION_MEASURE = 1;
    private final int MENUOPTION_PROFILE = 2;
    private final int MENUOPTION_CHANGE_PASSWORD = 3;
    private final int MENUOPTION_READ_USER = 4;
    private final int MENUOPTION_CREATE_USER = 5;
    private final int MENUOPTION_UPDATE_USER = 6;
    private final int MENUOPTION_DELETE_USER = 7;

    protected Dialog(IFunctionality functionality) {
        currUserID = -1;
        this.functionality = functionality;
    }
    
    @Override
    public void run() {
        while(running) {
            scanner = new Scanner(System.in);
            System.out.println("\n*******************************************");
            System.out.print("\nLogin");
            System.out.print("\n\tBruger ID:\t");
            int userID = scanner.nextInt();
            System.out.print("\tPassword:\t");
            String password = new Scanner(System.in).nextLine();
            
            currUserID = login(userID, password);
            
            if(currUserID != -1) {
                switch(functionality.readOpr(userID).getRank()) {
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
                        System.out.println("Du har ikke tilladelse til denne menu");
                        break;
                    }
                }
            }
            else
                System.out.println("Bruger ID eller password er inkorrekt");
        }
    }
    
    private int login(int userID, String password) {
        if(functionality.login(userID, password))
            return functionality.readOpr(userID).getRank();
        else
            return -1;
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
                        viewProfile(currUserID);
                    } 
                    catch (DALException ex) {
                        System.out.println("Kunne ikke læse din profil: " + ex);
                    }
                    break;
                }
                
                case MENUOPTION_CHANGE_PASSWORD: {
                    try {
                        changePassword(currUserID);
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
                    currUserID = -1;
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
    
    private void viewProfile(int userID) throws DALException {
        scanner = new Scanner(System.in);
        System.out.println("\n-------------------------------------------");
        System.out.println("Profil");
        
        final OperatorDTO userDTO = functionality.readOpr(userID);
        if(userDTO != null) {
            System.out.println("\tNavn:\t" + userDTO.getName());
            System.out.println("\tID:\t" + userDTO.getoprId());
            System.out.println("\tCPR:\t" + userDTO.getCpr());
        }
        else
            System.out.println("Kunne ikke læse din profil");
    }
    
    private void changePassword(int oprID) throws DALException, InputMismatchException {
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
        
        functionality.changePass(oprID, oldPass, newPass1, newPass2);
    }
    
    private void readUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        int userID;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Læs bruger");
        
        System.out.print("\tOperatør id: ");
        userID = scanner.nextInt();
        
        final OperatorDTO userDTO = functionality.readOpr(userID);
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
        
        oprId = functionality.createOpr(name, cpr);
        System.out.println("Bruger oprattet med operatør id: " + oprId);
    }
    
    private void updateUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        String name;
        int cpr, oprId, rank;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Opdater bruger");
        
        System.out.print("\tBruger ID: ");
        oprId = scanner.nextInt();
        System.out.print("\tNavn: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("\tCPR: ");
        cpr = scanner.nextInt();
        System.out.print("\tPassword: ");
        rank = new Scanner(System.in).nextInt();
        
        boolean isUpdate = functionality.updateOpr(oprId, name, cpr, rank);
        if(isUpdate)
            System.out.println("Brugeren " + oprId + " blev opdateret");
        else
            System.out.println("Kunne ikke opdatere brugeren");
    }
    
    private void deleteUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        int oprId;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Slet bruger");
        
        System.out.print("\tBruger ID: ");
        oprId = scanner.nextInt();
        
        boolean isDeleted = functionality.deleteOpr(oprId);
        if(isDeleted)
            System.out.println("Brugeren " + oprId + " blev fjernet");
        else
            System.out.println("Kunne ikke slette brugeren");
    }
}