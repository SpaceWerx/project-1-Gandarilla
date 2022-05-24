package com.revature;

import java.sql.Connection;		
//import java.sql.Connection;
import java.sql.SQLException;

import controller.AuthController;
import controller.ReimbursementController;
import controller.UserController;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import models.User;
import services.CLI_Menu_Service;
import utilities.ConnectionFactoryUtility;

public class Driver {
	public static void main(String[] args) {
		AuthController authController = new AuthController();
		UserController userController = new UserController();
		ReimbursementController reimbursementController = new ReimbursementController();
		//DELETE IF NECESSARY
	try(Connection conn = ConnectionFactoryUtility.getConnection()){
		System.out.println("Connection Successful!");
	} catch(SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
	}
		
		
//		CLI_Menu_Service options = new CLI_Menu_Service();
//		options.displayLoginMenu();
//		options.displayMenu();
	

	//LEAVE IT JUST IN CASE
	Javalin app = Javalin.create(
		config -> {
			config.enableCorsForAllOrigins(); //This is what allows the server to process JS
		}	
			).start(3000);
	
		app.get("/employee", userController.getEmployeesHandler);
	
		app.post("/employee", userController.insertEmployeesHandler);
		
	    app.post("/login", authController.loginHandler);
	    
	    app.get("/status", reimbursementController.handleGetReimbursmentByStatus);
	   
	}

		
}
	
	

	
	
	

	
	
	
	
	
	
	
	

