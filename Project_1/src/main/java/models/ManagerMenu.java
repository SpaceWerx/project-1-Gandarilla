package models;

import java.util.Scanner;

public class ManagerMenu {

//	public void displayEmployeeMenu() {
//		// TODO Auto-generated method stub
//		
//		
//	}
	@SuppressWarnings("resource")
	public static void displayFinanceManagerMenu() {
		boolean managerPortal = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Welcome to the Manager Portal~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
		while(managerPortal) {
			System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
			System.out.println("1 -> View All Pending Reimbursements");
			System.out.println("2 -> View All Resolved Reimbursements");
			System.out.println("3 -> Process a Reimbursement");
			System.out.println("0 -> Return to Main Menu");
			
			
			String firstChoice = scan.nextLine();
			
			switch (firstChoice) {
			
				case "1":
					//displayPendingReimbursements();
					break;
				case "2":
					//displayResolvedReimbursements();
					break;
				case "3":
					//processReimbursement(manager);
					break;
				case "0":
					System.out.println("Returning to Main Menu...");
					managerPortal = false;
					break;
			}
			
		}
		
	}


}
