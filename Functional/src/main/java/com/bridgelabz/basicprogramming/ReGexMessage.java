package com.bridgelabz.basicprogramming;

import utility.Utility;

public class ReGexMessage {

	public static void main(String[] args) {

		System.out.print("Enter the Name: ");
		String fullName = Utility.returnString(); // Taking name as an input
		String name[] = fullName.split(" "); // Splitting the full name to get the first name
		System.out.print("Enter the Phone Number: ");
		String phNumber = Utility.returnString(); // Taking phone number as an input
		System.out.print("Enter the Date: ");
		String date = Utility.returnString(); // taking date as an input
		String replacedStr = Utility.regexPassageReplace(fullName, name[0], phNumber, date); // calling function from
																								// utility class
		System.out.println("\n" + replacedStr); // Printing the output

	}

}
