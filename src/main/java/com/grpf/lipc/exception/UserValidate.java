package com.grpf.lipc.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidate {
	public boolean validateUser(String email)
	{
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"; 
	    Pattern p = Pattern.compile(regex); 
	    if (email == null) { 
	        return false; 
	    } 
	    Matcher m = p.matcher(email); 
	    return m.matches();
	   
		
	}
	
	public boolean validatePassword(String password,String email)
	{
		 String regex = "^(?=.*[0-9])"
	             + "(?=.*[a-z])(?=.*[A-Z])"
	             + "(?=.*[@#$%^&+=])"
	             + "(?=\\S+$).{8,20}$"; 
		 Pattern p = Pattern.compile(regex); 
		// password.substring(0,5);
		    if (password == null ||  password.substring(0,6).equals(email.substring(0,6))) { 
		        return false; 
		    } 
//		    System.out.println(password.substring(0,6));
		    Matcher m = p.matcher(password); 
		    return m.matches();}

}
