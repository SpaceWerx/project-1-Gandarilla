package com.models;

public enum Roles {
	Employee_1, 
	Employee_2, 
	Employee_3, 
	Manager_1, 
	Manager_2, 
	Manager_3;
	
	public String getUser() {

	    // this will refer to the object SMALL
	    switch(this) {
	      case Employee_1:
	        return "Welcome, Employee 1";

	      case Employee_2:
	        return "Welcome, Employee 2";

	      case Employee_3:
	        return "Welcome, Employee 3";

	      case Manager_1:
	        return "Welcome, Manager 1";
	        
	      case Manager_2:
		        return "Welcome, Manager 2";
	      
	      case Manager_3:
		        return "Welcome, Manager 3";
	      default:
	        return null;
	      }
	   }

	 public static void main(String[] args) {

		 // call getUser()
		 //Example using the user Employee1
		    System.out.println( Roles.Employee_1.getUser());
		  }

}

