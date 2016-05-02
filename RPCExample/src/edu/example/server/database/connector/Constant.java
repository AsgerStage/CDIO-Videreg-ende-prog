package edu.example.server.database.connector;


// erstat konstanterne nedenfor

public abstract class Constant
{
	public static final String
		server					= "127.0.0.1",  // database-serveren
		database				=  "raavarer",  //"jdbcdatabase", // navnet paa din database = dit studienummer
		username				= "s133284", // dit brugernavn = dit studienummer 
		password				= "1234"; // dit password som du har valgt til din database
	
	public static final int
		port					= 3306;
}
