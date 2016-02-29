package cdio.functionality;
import java.io.*;
import java.net.*;	
public class TelnetClient {
private String host;
Socket s = new Socket();
PrintWriter s_out =null;
BufferedReader s_in = null;

	public TelnetClient(String host) {
		this.host=host;
		try {
			s.connect(new InetSocketAddress("localhost",8000));
			System.out.println("Connected");
			s_out = new PrintWriter(s.getOutputStream(), true);
			s_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void getData(String msg){
	
		
	s_out.println(msg);
	System.out.println("Message sent");
	String response;
	try{
		//while((response= s_in.readLine()) !=null){
			System.out.println(s_in.readLine());
		//System.out.println(response);
		//}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	}
	

