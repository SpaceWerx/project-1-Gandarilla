package services;

import models.User;

import repositories.UserDAO;

public class AuthService {

	public int register(User user) {
		
		if(UserDAO.getByUsername(user.getUsername()) != null) {
			
			throw new NullPointerException("Username is already taken");
		}
	
		return UserDAO.create(user);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public User login(String username, String password) {
		
		User user;
		
		try {
			
			user = UserDAO.getByUsername(username);
			
			if(user!=null && password.equals(user.getPassword())) {
				
				System.out.println("Logged In Successfully!");
				return user;
			} else if (user!=null && !password.equals(user.getPassword())) {
				
				System.out.println("Wrong Password");
				return null;
			} else {
				
				System.out.println("User Does Not Exist!");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Login Unsuccessful");
			e.printStackTrace();
		}
		
		return null;
		
		
		
	}

	public static Object login(int anyInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object update(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
//;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

