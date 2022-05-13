package com.revature;
import java.sql.Connection;  
import java.sql.DriverManager;  

public class ConnectionFactoryUtilityTest {

	        public static void main(String args[]) throws ClassNotFoundException  
	        {  
	            String url;  
	            Connection con = null;  
	            try {  
	                Class.forName("com.mysql.jdbc.Driver");  
	            url="jdbc:mysql://localhost:3306/spring";  
	                con = DriverManager.getConnection(url);  
	                System.out.println("Connection created");  
	                con.close();  
	                System.out.println("Connection closed");  
	                }  
	                catch (Exception e) {  
	                System.out.println(e.toString());  
	            }  
	    }  
	}  
	
	

