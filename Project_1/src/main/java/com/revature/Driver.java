package com.revature;

import java.util.Scanner;

import static java.lang.System.exit;

public class Driver {
	

		public static void printMenu(String[] options) {
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~ Welcome to the Employee Reinbursement Entry System ~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~ Select your reinbursement type below ~~~~~~~~~~~~~~");
			System.out.println("~~ Input the number for your desired selection ~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
			System.out.println("1: LODGING");
			System.out.println("2: TRAVEL");
			System.out.println("3: FOOD");
			System.out.println("4: OTHER");
			System.out.println("5: EXIT the Program");
			System.out.println();
	}
	
		public static void main(String[] args) {
			String[] options = {"1- LODGING",
                    "2- TRAVEL",
                    "3- FOOD",
                    "4- OTHER",
                    "5- EXIT the program"
			};
		
		Scanner scanner = new Scanner(System.in);
		int option = 1;
		while (option!= 5) {
			printMenu(options);
			  try {
	                option = scanner.nextInt();
	                switch (option){
	                    case 1: Lodging(); break;
	                    case 2: Travel(); break;
	                    case 3: Food(); break;
	                    case 4: Other(); break;
	                    case 5: exit(0);
	                }
	            }
			  
	            catch (Exception ex){
	                System.out.println("Please enter an integer value between 1 and 5");
	                scanner.next();
	            }
	        }
	    }
	// Options
	    private static void Lodging() {
	        System.out.println("Thanks for choosing option 1");
	    }
	    private static void Travel() {
	        System.out.println("Thanks for choosing option 2");
	    }
	    private static void Food() {
	        System.out.println("Thanks for choosing option 3");
	    }
	    private static void Other() {
	        System.out.println("Thanks for choosing option 4");
	    }
	    
		
		
		}
