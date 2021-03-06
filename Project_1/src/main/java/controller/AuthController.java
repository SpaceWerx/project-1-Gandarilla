package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;
import models.User;
import repositories.UserDAO;
import services.AuthService;

public class AuthController {
UserDAO userDAO = new UserDAO();
ObjectMapper Mapper = new ObjectMapper();
User user = new User();
public static int currentUser;
User CurrentUser;
	
	public Handler getRegisterHandler = (ctx) -> {
		String body = ctx.body();
		Gson gson = new Gson();
		
		User user = gson.fromJson(body, User.class);
		if(user!= null) {
			userDAO.create(user);
		
			ctx.result("User successfully added");
			ctx.status(201);
		}else {
			ctx.result("User not created");
			ctx.status(400);
		}
	};
	
	
	
	AuthService as = new AuthService();
	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		//I recommend you make this an employee object 
		User u = gson.fromJson(body, User.class);

		CurrentUser = userDAO.getByUsername(user.getUsername());
		if(as.login(u.getUsername(), u.getPassword()) == 1) {
			ctx.status(201);
			ctx.result("Manager Login Sucessful!");
		}
		else if(as.login(u.getUsername(), u.getPassword()) == 2) {
			ctx.status(202);
			ctx.result("Employee Login Sucessful!");
		}
		else {
		ctx.result("Login Failed!");
		ctx.status(401);
		}
	};
	
	
}
