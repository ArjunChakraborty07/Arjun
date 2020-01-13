package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Leapyear {
	public static void main(String[] args) {
		int year;
		System.out.println("Leap Year");
		System.out.print("Enter a year for checking:");// Taking input from user
		year = Utility.returnInt();
		if (year % 100 == 0) { // Checking the input year for leap year
			if (year % 400 == 0)
				System.out.println("Leap Year");
			else
				System.out.println("Not a leap year");
		} else if (year % 4 == 0)
			System.out.println("Leap Year"); // Printing the output statement
		else
			System.out.println("Not a leap year");
	}

}
