package edu.example.client.misc;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	public static String getMD5Hash(final String password) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			
			m.reset();
			m.update(password.getBytes());
			
			BigInteger bigInt = new BigInteger(1, m.digest());
			String hashtext = bigInt.toString(16);
			
			while(hashtext.length() < 32 ) {
				hashtext = "0" + hashtext;
			}
			
			return hashtext;
		} 
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}