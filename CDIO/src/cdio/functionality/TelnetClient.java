package cdio.functionality;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class TelnetClient
{
    private final Socket s = new Socket();
    private final String host;
    private final int port;
    private PrintWriter s_out;
    private BufferedReader s_in;
    
    public TelnetClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public void connect() throws IOException {
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
    
    public ArrayList<String> getData(String command, int expectedReplies, String... params) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        
        StringBuilder request = new StringBuilder(command);
        if(params.length > 0)
            for (String param : params) {
                request.append(' ').append(param);
            }
        
        String response = null;
        s_out.println(request.toString());
        System.out.println("Request:\t\"" + request.toString() + '\"');
        
        try {
            for (int i = 0; i < expectedReplies; i++) {
                response = s_in.readLine();
                result.add(response);
            }
////            while(!(response = s_in.readLine()).isEmpty()) {
//            while (true) {
//                System.out.println(s_in.readLine());
////                response = s_in.readLine();
////                System.out.println("Resp=" + response);
////                result.add(response);
//            }
        }
        catch(IOException e) {
            e.printStackTrace();
            System.err.println("Closing connection");
            close();
        }
        
        return result;
    }
    
    public void close() throws IOException {        
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