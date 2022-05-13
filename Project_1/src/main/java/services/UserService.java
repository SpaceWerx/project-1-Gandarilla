package services;

import java.util.ArrayList;
import java.util.List;

import models.Role;
import models.User;

public class UserService {
	
	static List<User> users = new ArrayList();
	
	public User getUserByUsername(String Username) {
		
		for(User user : users) {
			if(user.getUsername().equals(Username)) {
				return user;
			}
		}
		return null;
	}
	
	public List<User> getAllUsers(List<User> users) {
		
		return users;
	}
	
	public void idExists(int Id) {
		for(User user : users) {
			if(user.getId()==Id) {
				System.out.println("The Id already exists");
				break;
			}
		}
		System.out.println("The Id doesn't exist");
	}
	public static List<User> getByRoles(Role role){
		for(User user:users) {
			if(user.getRole()==role) {
				users.add(user);
			}
		}
		return users;
	}

	public static User getUserById(int userChoice) {
		for(User user: users) {
			if(user.getId()== userChoice) {
				return user;
			}
		}
		return null;
	}

	public void getById(int id) {
		// TODO Auto-generated method stub
		
	}


	
}

