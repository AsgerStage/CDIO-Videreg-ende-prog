package cdio.functionality;
import java.io.*;
import java.net.*;

public class TelnetClient
{
    private final Socket s = new Socket();
    private final String host;
    private final int port;
    private PrintWriter s_out;
    private BufferedReader s_in;
    
    protected TelnetClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    protected void connect() throws IOException {
        try {
            s.connect(new InetSocketAddress(host, port));
            System.out.println("Connected to " + host + " on port " + port);
            
            s_out = new PrintWriter(s.getOutputStream(), true);
            s_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Could not connect to " + host + " on port " + port);
        }
    }
    
    protected String getData(String msg) throws IOException {
        String response = null;
        s_out.println(msg);
        System.out.println("Request:\t\"" + msg + '\"');
        
        try {
//            while((response= s_in.readLine()) != null) {
            response = s_in.readLine();
            System.out.println("Response:\t\"" + response + '\"');
//            }
        }
        catch(IOException e) {
            e.printStackTrace();
            System.err.println("Closing connection");
            close();
        }
        
        return response;
    }
    
    protected void close() throws IOException {        
        try {
            if(s_out != null) {
                s_out.flush();
                s_out.close();
            }
            if(s_in != null)
                s_in.close();
        } 
        catch (IOException e) {
            System.out.println("Could not close reader or writer: " + e.getMessage());
            e.printStackTrace();
            throw new IOException("Could not close reader or writer");
        }
        finally {
            if(s != null)
                try {
                    s.close();
                } 
                catch (IOException e) {
                    System.out.println("Could not close connection: " + e.getMessage());
                    e.printStackTrace();
                    throw new IOException("Could not close connection");
                }
        }
    }
}