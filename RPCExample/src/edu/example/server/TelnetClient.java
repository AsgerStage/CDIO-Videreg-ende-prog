package edu.example.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetClient
{
    public static final String CMD_WEIGHT_GET = "S";
    public static final String CMD_WEIGHT_SET = "B";
    public static final String CMD_TARA = "T";
    public static final String CMD_DISPLAY_WRITE = "D";
    public static final String CMD_DISPLAY_CLEAR = "DW";
    public static final String CMD_DISPLAY_AND_WAIT = "RM20 8";
    public static final String CMD_QUIT = "Q";
    
    private final Socket s = new Socket();
    private final String host;
    private final int port;
    private PrintWriter s_out;
    private BufferedReader s_in;
    
    public TelnetClient(){
    	host="127.0.0.1";
    	port=8000;
    }
    
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
    
    protected String getData(String command, List<String> params) throws IOException {
        return getData(command, 1, params).get(0);
    }
    
    protected ArrayList<String> getData(String command, int expectedReplies, List<String> params) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        
        StringBuilder request = new StringBuilder(command);
        if(params.size() > 0)
            for (int i=0;i<params.size();i++) {
                request.append(' ').append(params.get(i));
            }
        
        String response = null;
        s_out.println(request.toString());
        System.out.println("Request:\t\"" + request.toString() + '\"');
        
        try {
            for (int i = 0; i < expectedReplies; i++) {
                response = s_in.readLine();
                result.add(response);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
            System.err.println("Closing connection");
            close();
        }
        
        return result;
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