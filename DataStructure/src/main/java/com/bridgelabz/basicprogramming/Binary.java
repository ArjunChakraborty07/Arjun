package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Binary {
	public static void main(String args[]) {
		int N;
		System.out.print("Enter a number to convert :");
		N = Utility.returnInt(); // Taking input from user
		int binary[] = Utility.toBinary(N); // Method invoked from utility class to return the binary value of the input
											// integer
		System.out.print("Binary of " + N + " is ");
		for (int i = 0; i < 8; i++) {
			System.out.print(binary[i]);// Printing the binary value
		}
		int newbinary[] = new int[8]; // breaking the binary into two nibbles
		for (int i = 0; i < 4; i++) {
			newbinary[i + 4] = binary[i]; // First nibble of the binary
		}
		System.out.println();
		for (int i = 4; i < 8; i++) {
			newbinary[i - 4] = binary[i]; // Second nibble of the binary
		}
		System.out.print("Binary after nibble swapping is ");
		for (int i = 0; i < 8; i++) {
			System.out.print(newbinary[i]); // Swapping the two nibbles and adding them into a single array and printing
											// it
		}
		int newdecimal = 0;
		for (int i = 0; i < 8; i++) {
			newdecimal += newbinary[i] * Math.pow(2, 7 - i); // Calculating the decimal value of the new binary value
		}
		System.out.print("\nDecimal of the new binary is " + newdecimal); // Printing the decimal value
	}
}
