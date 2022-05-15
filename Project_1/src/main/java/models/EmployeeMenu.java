package models;

import java.util.Scanner;

import services.CLI_Menu_Service;

public class EmployeeMenu {
	private static final User User = null;

	public static void displayEmployeeMenu() {
		//reimbursement_employee_class EmReim = new asdjadsj();
		//EmReim.whatever the void is called();
		//EmReim.whatever the void for request is called();
		CLI_Menu_Service EP = new CLI_Menu_Service();
		
		
		boolean employeePortal = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~Welcome to the Employee Portal~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
		while (employeePortal) {
			
			System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
			System.out.println("1 -> View Previous Requests");
			System.out.println("2 -> Submit a Reimbursement");
			System.out.println("0 -> Return to Main Menu");
			
		
				String firstChoice = scan.nextLine();
			
				switch (firstChoice) {
					case "1":
						
						break;
					case "2":
						//EP.submitReimbursement();
						break;
					case "0":
						System.out.println("Returning to Main Menu...");
						employeePortal = false;
						break;
					default:
						System.out.println("Invalid Entry");
						System.out.println();
						System.out.println();
				}	
		}
	}

//	//privatestaticvoiddisplayPreviousRequests() {
//		// return displayPrevious REquests;
//		
//	}


}
