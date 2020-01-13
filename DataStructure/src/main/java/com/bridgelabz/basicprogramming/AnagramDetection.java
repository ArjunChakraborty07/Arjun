package com.bridgelabz.basicprogramming;

import utility.Utility;

public class AnagramDetection {
	public static void main(String args[]) {
		System.out.print("Enter String1: ");
		String string1 = Utility.returnString(); // Taking
		System.out.println(); // two strings as
		System.out.print("Enter String1: "); // Input
		String string2 = Utility.returnString();
		boolean b = Utility.AnagramStrings(string1, string2); // Calling method from Utility class which is returning a
																// boolean value
		if (b == true) { // checking whether the strings are anagram or not
			System.out.println("The words are Anagram");
		} else { // Output statements
			System.out.println("The words are not Anagram");
		}
	}
}
