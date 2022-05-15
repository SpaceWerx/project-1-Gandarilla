package com.revature;

//import java.sql.Connection;
import java.sql.SQLException;

import models.User;
import services.CLI_Menu_Service;
import utilities.ConnectionFactoryUtility;

public class Driver {


	public static void main(String[] args) {
	
		//DELETE IF NECESSARY
//	try(Connection conn = ConnectionFactoryUtility.getConnection()){
//		System.out.println("Connection Successful!");
//	} catch(SQLException e) {
//		System.out.println("Connection Failed");
//		e.printStackTrace();
//	}
		
		
		CLI_Menu_Service options = new CLI_Menu_Service();
		options.displayMenu();
	
		
	}

		
		}
