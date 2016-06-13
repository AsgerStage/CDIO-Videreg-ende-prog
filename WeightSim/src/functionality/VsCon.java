package functionality;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class VsCon
{
    private static Thread userInputThread;
    private static Scanner userInputScanner = new Scanner(System.in);
    private static ServerSocket listener;
    private static double weight = 0;
    private static String inline;
    private static String indtDisp = "";
    private static int portdst = 8000;
    private static Socket sock;
    private static BufferedReader instream;
    private static DataOutputStream outstream;
    
    private static boolean setup(String[] args) {
        if(args.length != 0 && args[0] != null) {
            try {
                final int newPort = Integer.parseInt(args[0]);                
                if(newPort > -1 && newPort < 65536)
                    portdst = Integer.parseInt(args[0]);
                else
                    throw new IllegalArgumentException("Port number must in the range 0 - 65535. Using default port " + portdst);
            } 
            catch(NumberFormatException e) {
                System.err.println("Port number must be an integer between 0 and 65535. Using default port " + portdst);
                e.printStackTrace();
            }
            catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Venter paa connection på port " + portdst);
        printmenu();
        
        userInputThread = new Thread(new User());
        userInputThread.setDaemon(true);
        userInputThread.start();
        
        try {
            listener = new ServerSocket(portdst);
            sock = listener.accept();
            instream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            outstream = new DataOutputStream(sock.getOutputStream());
        } 
        catch (IOException e) {
            System.err.println("Could not start the server: " + e);
            return false;
        }
        
        return true;
    }
    
    private static void server() {
        try {
            while (!(inline = instream.readLine().toUpperCase()).isEmpty()) { //her ventes på input
                if (inline.startsWith("S")) {
                    outstream.writeBytes(""+weight);
                    
                
                    
                    
                }
               
                printmenu();
                listener.close();
                sock.close();
                instream.close();
                outstream.close();
                listener = new ServerSocket(portdst);
                sock = listener.accept();
                instream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                outstream = new DataOutputStream(sock.getOutputStream());
            }
        }
        catch (Exception e){
            System.out.println(e);
            quit();
        }
    }
    
    public static void main(String[] args){
        if(setup(args))       
            server();
        else
            System.out.println("Weight running without server");
    }
    
    private static void printmenu() {
        for(int i = 0; i < 2; i++)
            System.out.println("                                                 ");
        System.out.println("*************************************************");
        System.out.println("Weight: " + (weight) + " kg"                );
        System.out.println("Instruktionsdisplay: " +  indtDisp                );
        System.out.println("*************************************************");
        System.out.println("                                                 ");
        System.out.println("                                                 ");
        System.out.println("Debug info:                                      ");
        if(sock != null)
            System.out.println("Hooked up to " + sock.getInetAddress()        );
        System.out.println("Weight: " + (weight)+ " kg"                       );
        System.out.println("Streng modtaget: " + inline                       );
        System.out.println("                                                 ");
        System.out.println("Denne vægt simulator lytter på ordrene           ");
        System.out.println("S, T, D 'TEST', DW, RM20 8 .... , B og Q         ");
        System.out.println("på kommunikationsporten.                         ");
        System.out.println("******"                                           );
        System.out.println("Tast T for tara (svarende til knaptryk paa vegt)" );
        System.out.println("Tast B for ny brutto (svarende til at belastningen paa vegt �ndres)");
        System.out.println("Tast Q for at afslutte program program"           );
        System.out.println("Indtast (T/B/Q for knaptryk / brutto ændring / quit)");
        System.out.print  ("Tast her: "                                       );
    }
    
  
    
    private static void quit() {
        try {
            System.out.println("");
            System.out.println("Program stoppes");
            
            if(sock != null)
                sock.close();
            
            userInputThread.stop();
            instream.close();
            
            outstream.flush();
            outstream.close();
            
            System.out.flush();
            System.out.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.exit(0);
        }
    }
    
    private static double setWeight(double newWeight) {
        if (newWeight >= 0.0 && newWeight <= 6.0)
            weight = newWeight;
        else
            throw new IllegalArgumentException("Weight skal være mellem 0.0 og 6.0 kg");
        return weight;
    }
    private static class User implements Runnable
    {
        @Override
        public void run() {
            String userInput;
            while(!(userInput = userInputScanner.nextLine().toUpperCase()).isEmpty() || userInputScanner.hasNext()) {
                try {
                   
                    if (userInput.startsWith("B")) {
                        setWeight(Double.parseDouble(userInput.substring(2, userInput.length())));
                    }
                    else if (userInput.startsWith("Q")) {
                        quit();
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                printmenu();
            }
        }
        
    }
}
