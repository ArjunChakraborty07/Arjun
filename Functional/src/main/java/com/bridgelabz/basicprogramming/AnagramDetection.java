package com.bridgelabz.basicprogramming;

import utility.Utility;

public class AnagramDetection {
	public static void main(String args[]) {
		System.out.print("Enter String1: ");
		String string1 = Utility.returnString();
		System.out.println();
		System.out.print("Enter String1: ");
		String string2 = Utility.returnString();
		boolean b = Utility.AnagramStrings(string1, string2);
		if (b == true) {
			System.out.println("The words are Anagram");
		} else {
			System.out.println("The words are not Anagram");
		}
	}
}
