package controller;

import java.util.List;

import com.google.gson.Gson;

import io.javalin.http.Handler;
import models.User;
import services.UserService;

public class UserController {
	UserService us = new UserService();

	public Handler getEmployeesHandler = (ctx) ->{
		
	 List<User> allUsers = us.getAllUsers();
	
	 Gson gson = new Gson();
	
	 String  JSONObject = gson.toJson(allUsers);
	 
	 ctx.result(JSONObject);
	 ctx.status(200);
		
	};
	
	public Handler insertEmployeesHandler = (ctx) ->{
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		User employee = gson.fromJson(body, User.class);
		
		us.addUser(employee);
		
		ctx.result("Employee successfully added!");
		ctx.status(201);

	
	};
	
	public Handler GetAllUsers;
	public Handler GetByUsername;
	public Handler GetById;
	
}
