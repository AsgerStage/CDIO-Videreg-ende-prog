package edu.example.server.database.connector;

public abstract class Constant
{
	public static final String
		server					= "nasie.diskstation.me",  // database-serveren
		database				=  "DTU",  //"jdbcdatabase", // navnet paa din database = dit studienummer
		username				= "DTU", // dit brugernavn = dit studienummer 
		password				= "Gruppe16"; // dit password som du har valgt til din database
	
	public static final int	port = 3306;
}