package com.bridgelabz.basicprogramming;

import utility.Utility;

public class DayofWeek {

	public static void main(String args[]) {

		System.out.println(" Day of Week ");
		System.out.print("Enter the day, month and year(accordingly):");
		int d = Utility.returnInt(); // Taking Input from the user
		int m = Utility.returnInt();
		int y = Utility.returnInt();
		int d0=Utility.displayweek(d, m, y); // Calling method from utility class to print the day of the given date
		switch (d0) { // Switch case implemented for generating week day
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tueday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thrusday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 0:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("Invalid data Check Code");//In case of wrong algorithm
		}
	}
	
}
