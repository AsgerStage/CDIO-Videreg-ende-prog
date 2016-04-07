package cdio.view;
import cdio.data.OperatorDTO;
import cdio.exceptions.DALException;
import cdio.exceptions.OpNameException;
import cdio.exceptions.OpPasswordException;
import cdio.functionality.IFunctionality;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Dialog</b>
 * <p>Kører brugergrænsefladen - Implimenterer Runable.
 * @author Lasse Holm Nielsen - S123954
 * @version 24-02-2016
 */
public class Dialog
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
    
    public void start() {
        while(running) {
            scanner = new Scanner(System.in);
            int userID;
            String password;
            
            System.out.println("\n*******************************************");
            System.out.print("\nLogin");
            
            try {
                System.out.print("\n\tBruger ID:\t");
                userID = scanner.nextInt();
                System.out.print("\tPassword:\t");
                password = new Scanner(System.in).nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("Ugyldigt input!");
                continue;
            }
            
            currUserID = login(userID, password);
            int userRank = -1;
            if(currUserID != -1)
                userRank = functionality.readOpr(currUserID).getRank();
            
            if(userRank != -1) {
                switch(userRank) {
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
    
    /**
     * <b>Login</b>
     * <p>Undersøger om det angivne operatør ID matcher passwordet.
     * @param userID
     *      Operatørens ID.
     * @param password
     *      Operatørens password.
     * @return 
     *      Returnerer 1 hvis brugeren er administrator
     *      <p>0 hvis brugeren er operatør
     *      <p>-1 hvis operatør ID og passwordet matcher eller operatøren ikke har rettigheder til programet.
     */
    private int login(int userID, String password) {
        if(functionality.login(userID, password))
            return functionality.readOpr(userID).getOprID();
        else
            return -1;
    }
    
    /**
     * <b>Menu</b>
     * <p>Viser brugergrænsefladens top menu.
     * @param isAdmin 
     *      Angiver om brugeren er administrator (administratoren har flere muligheder i menu'en)
     */
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
                    catch (OpPasswordException ex) {
                        System.out.println("Kunne ikke skifte dit password da det ikke overholder reglerne for passwords");
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
                        } catch (OpNameException ex) {
                            System.out.println("Navnet overholder ikke reglerne for operatør navne");
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
    
    /**
     * <b>Afvejning</b>
     * <p>Måler nettovægten for en pakke.
     * @throws DALException
     *      Smider en Data Access Layer exception hvis der opstår en fejl i funktions eller data laget.
     * @throws InputMismatchException 
     *      Smider en input mismatch exception hvis brugeren indtaster ugyldig data.
     */
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
    
    /**
     * <b>Vis profil</b>
     * <p>Henter brugerens data ud fra det angivne operatør ID.
     * @param oprID
     *      Brugerens operatør ID.
     * @throws DALException 
     *      Smider en Data Access Layer exception hvis der opstår en fejl i funktions eller data laget.
     */
    private void viewProfile(int oprID) throws DALException {
        scanner = new Scanner(System.in);
        System.out.println("\n-------------------------------------------");
        System.out.println("Profil");
        
        final OperatorDTO userDTO = functionality.readOpr(oprID);
        if(userDTO != null) {
            System.out.println("\tNavn:\t\t" + userDTO.getName());
            System.out.println("\tID:\t\t" + userDTO.getOprID());
            System.out.println("\tInitialer:\t" + userDTO.getIni());
            System.out.println("\tCPR:\t\t" + userDTO.getCpr());
            System.out.println("\tRank:\t\t" + userDTO.getRank());
        }
        else
            System.out.println("Kunne ikke læse din profil");
    }
    
    /**
     * <b>Skift password</b>
     * <p>Skifter brugerens password.
     * @param oprID
     *      Brugerens operatør ID.
     * @throws DALException
     *      Smider en Data Access Layer exception hvis der opstår en fejl i funktions eller data laget.
     * @throws InputMismatchException 
     *      Smider en input mismatch exception hvis brugeren indtaster ugyldig data.
     */
    private void changePassword(int oprID) throws DALException, OpPasswordException {
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
        
        
        if(functionality.changePass(oprID, oldPass, newPass1, newPass2))
            System.out.println("Dit password blev ændret");
        else
            System.out.println("Kunne ikke ændre dit password");
    }
    
    /**
     * <b>Læs operatør</b>
     * <p>Henter en operatørs data ud fra det data som brugeren indtaster.
     * @throws DALException
     *      Smider en Data Access Layer exception hvis der opstår en fejl i funktions eller data laget.
     * @throws InputMismatchException 
     *      Smider en input mismatch exception hvis brugeren indtaster ugyldig data.
     */
    private void readUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        int userID;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Læs bruger");
        
        System.out.print("\tOperatør id: ");
        userID = scanner.nextInt();
        
        final OperatorDTO userDTO = functionality.readOpr(userID);
        if(userDTO != null) {
            System.out.println("\tNavn:\t\t" + userDTO.getName());
            System.out.println("\tID:\t\t" + userDTO.getOprID());
            System.out.println("\tInitialer:\t" + userDTO.getIni());
            System.out.println("\tCPR:\t\t" + userDTO.getCpr());
            System.out.println("\tRank:\t\t" + userDTO.getRank());
            System.out.println("\tPassword:\t" + userDTO.getPassword());
        }
        else
            System.out.println("Kunne ikke finde operatøren med id " + userID);
    }
    
    /**
     * <b>Opret operatør</b>
     * <p>Opretter en ny operatør ud fra det data som brugeren indtater.
     * @throws DALException
     *      Smider en Data Access Layer exception hvis der opstår en fejl i funktions eller data laget.
     * @throws InputMismatchException 
     *      Smider en input mismatch exception hvis brugeren indtaster ugyldig data.
     */
    private void createUser() throws DALException, InputMismatchException {
        scanner = new Scanner(System.in);
        String name, ini;
        int oprId, rank;
        long cpr;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Opret bruger");
        
        System.out.print("\tNavn: ");
        name = scanner.nextLine();
        System.out.print("\tInitialer: ");
        ini = scanner.nextLine();
        System.out.print("\tCPR: ");
        cpr = scanner.nextLong();
        System.out.print("\tRank: ");
        rank = scanner.nextInt();
        
        oprId = functionality.createOpr(name, ini, cpr, rank);
        
        if(oprId != -1)
            System.out.println("Bruger oprettet med operatør id: " + oprId);
        else
            System.out.println("Kunne ikke oprette operatøren");
    }
    
    /**
     * <b>Opdater operatør</b>
     * <p>Opdaterer en operatørs data ud fra den data som brugeren indtater. 
     * <p>Opdaterer ikke felter der angives med en null værdi.
     * @throws DALException
     *      Smider en Data Access Layer exception hvis der opstår en fejl i funktions eller data laget.
     * @throws InputMismatchException 
     *      Smider en input mismatch exception hvis brugeren indtaster ugyldig data.
     */
    private void updateUser() throws DALException, InputMismatchException, OpNameException {
        scanner = new Scanner(System.in);
        String name;
        int cpr, oprId, rank;
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Opdater bruger");
        System.out.println("Lad navne feltet stå tomt hvis det ikke skal opdateres og angiv -1 for de andre felter hvis de ikke skal opdateres.");
        
        System.out.print("\tBruger ID: ");
        oprId = scanner.nextInt();
        System.out.print("\tNavn: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("\tCPR: ");
        cpr = scanner.nextInt();
        System.out.print("\tRank: ");
        rank = new Scanner(System.in).nextInt();
        
        if(name.length() < 1)
            name = null;
        
        boolean isUpdate = functionality.updateOpr(oprId, name, cpr, rank);
        if(isUpdate)
            System.out.println("Brugeren " + oprId + " blev opdateret");
        else
            System.out.println("Kunne ikke opdatere brugeren");
    }
    
    /**
     * <b>Slet operatør</b>
     * <p>Sletter operatøren med det angivne operatør ID.
     * @throws DALException
     *      Smider en Data Access Layer exception hvis der opstår en fejl i funktions eller data laget.
     * @throws InputMismatchException 
     *      Smider en input mismatch exception hvis brugeren indtaster ugyldig data.
     */
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