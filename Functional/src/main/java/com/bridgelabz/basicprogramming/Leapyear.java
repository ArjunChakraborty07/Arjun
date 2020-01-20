package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Leapyear {
	public static void main(String[] args) {
		int year;
		System.out.println("Leap Year");
		System.out.print("Enter a year for checking:");// Taking input from user
		year = Utility.returnInt();
		boolean b=utility.Utility.leapYear(year); // Checking the input year for leap year
		if(b==true)
		{
			System.out.println(" The year is a leap year");//Output Statement
		}
		else
		{
			System.out.println(" The year is not a leap year");//Output Statement
		}
	}

}
