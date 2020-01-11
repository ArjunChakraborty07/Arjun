package com.bridgelabz.basicprogramming;

import utility.Utility;

public class VendingMachine {

	public static void main(String args[]) {
		System.out.println("Wending Machine");
		System.out.print("Enter the amount of Rupees:");
		int N = Utility.returnInt();// Taking input from user
		Utility.change(N);// Calling method from utility class for vending machine
	}

}
