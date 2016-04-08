package functionality;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class VsCon
{
    private static ServerSocket listener;
    private static double brutto = 0;
    private static double tara = 0;
    private static String inline;
    private static String indtDisp = "";
    private static int portdst = 8000;
    private static Socket sock;
    private static BufferedReader instream;
    private static DataOutputStream outstream;
    private static boolean rm20flag = false;
    
    public static void main(String[] args) throws IOException {
        listener = new ServerSocket(portdst);
        System.out.println("Venter paa connection på port " + portdst );
        System.out.println("Indtast eventuel portnummer som 1. argument");
        portdst = new Scanner(System.in).nextInt();
        System.out.println("paa kommando linien for andet portnr");
        sock = listener.accept();
        instream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        outstream = new DataOutputStream(sock.getOutputStream());
        printmenu();
        
        try {
            while (!(inline = instream.readLine().toUpperCase()).isEmpty()) { //her ventes på input
                if (inline.startsWith("RM20 8")){
                    indtDisp = inline.substring(8, inline.indexOf("\"", 8));
                    outstream.writeBytes("RM20 B\r\n");
                    
                    Scanner scanner = new Scanner(System.in);
                    String userinput = scanner.nextLine();
                    outstream.writeBytes("RM20 A " + userinput + "\r\n");
                }
                else if (inline.startsWith("D")) {
                    if (inline.equals("DW"))
                        indtDisp = "";
                    else
                        indtDisp = (inline.substring(2, inline.length())); //her skal anførselstegn udm.
                    printmenu();
                    outstream.writeBytes("DB" + "\r\n");
                }
                else if (inline.startsWith("T")) {
                    outstream.writeBytes("T S " + (tara) + " kg " + "\r\n");        //HVOR MANGE SPACE?
                    tara = brutto;
                    printmenu();
                }
                else if (inline.startsWith("S")) {
                    printmenu();
                    outstream.writeBytes("S S " + (brutto-tara) + " kg " + "\r\n");//HVOR MANGE SPACE?
                }
                else if (inline.startsWith("B")) { //denne ordre findes ikke p� en fysisk v�gt
                    String temp = inline.substring(2, inline.length());
                    brutto = Double.parseDouble(temp);
                    printmenu();
                    outstream.writeBytes("DB" + "\r\n");
                }
                else if (inline.startsWith("Q")) {
                    System.out.println("");
                    System.out.println("Program stoppet Q modtaget paa com port");
                    System.in.close();
                    System.out.close();
                    instream.close();
                    outstream.close();
                    System.exit(0);
                }
                else {
                    printmenu();
                    outstream.writeBytes("ES" + "\r\n");
                }
            }
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        
        changeMeasurement();
        resetWeight();
    }
    public static void printmenu(){
        for(int i = 0; i < 2; i++)
            System.out.println("                                                 ");
        System.out.println("*************************************************");
        System.out.println("Netto: " + (brutto-tara)+ " kg"                   );
        System.out.println("Instruktionsdisplay: " +  indtDisp                );
        System.out.println("*************************************************");
        System.out.println("                                                 ");
        System.out.println("                                                 ");
        System.out.println("Debug info:                                      ");
        System.out.println("Hooked up to " + sock.getInetAddress()            );
        System.out.println("Brutto: " + (brutto)+ " kg"                       );
        System.out.println("Streng modtaget: "+inline                         );
        System.out.println("                                                 ");
        System.out.println("Denne vægt simulator lytter p� ordrene           ");
        System.out.println("S, T, D 'TEST', DW, RM20 8 .... , B og Q         ");
        System.out.println("på kommunikationsporten.                         ");
        System.out.println("******"                                           );
        System.out.println("Tast T for tara (svarende til knaptryk paa vegt)" );
        System.out.println("Tast B for ny brutto (svarende til at belastningen paa vegt �ndres)");
        System.out.println("Tast Q for at afslutte program program"           );
        System.out.println("Indtast (T/B/Q for knaptryk / brutto ændring / quit)");
        System.out.print  ("Tast her: "                                       );
    }
    
    /**
     * @author Mariam
     * @return Her �ndres og retuneres brutto v�gten, efter at en kommando er indsatet og det er kontrolleret at
     * kommandoen starter med et stort B og at den indtastet v�gt ligger imellem 0-6.00 kg.
     */
    static double changeMeasurement() {
        resetWeight();
        System.out.println("Indtast en kommando");
        Scanner scan = new Scanner (System.in);
        String userStr = scan.nextLine();
        
        String newBrutto = userStr;
        if (userStr.startsWith("B")) {
            newBrutto = newBrutto.substring(2);
            if (newBrutto.endsWith("kg"))
                newBrutto = newBrutto.substring(0, newBrutto.length() - 2).trim();
        }
        else 
            System.out.println("Den indtastet kommando er ikke gyldig, prøv igen");
        
        double brutto = Double.parseDouble(newBrutto);
        
        if (brutto >= 0 && brutto <= 6.00)
            System.out.println("Brutto " + brutto + " kg ligger inden for det godkendte interval (0-6 kg)");
        else 
            System.out.println("Det indtastet brutto ligger udenfor det godkendte interval");
        
        return brutto;
    }
    
    /**
     * @author Mariam
     * @return
     * 	Her bliver v�gten tareret og der retuneres et 0, ved at brugerne taster T vha. scanner
     */
    static double resetWeight() {
        System.out.println("Indtast T for at nulstille v�gten");
        Scanner scan2 = new Scanner (System.in);
        String userInput = scan2.nextLine();
        
        if (userInput.equals("T"))
            System.out.println("V�gten er nu nulstillet: " + "TS " + tara + " kg");
        else
            resetWeight();
        
        return VsCon.tara=0;
    }
}