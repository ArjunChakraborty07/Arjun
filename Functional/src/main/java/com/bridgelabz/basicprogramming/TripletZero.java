package com.bridgelabz.basicprogramming;

import utility.Utility;

public class TripletZero {
	public static void main(String args[]) {
		System.out.println(" Triplet Zero");
		System.out.print("Enter the size of array:");// User setting size of the array
		int n = Utility.returnInt();
		int arr[] = new int[n];
		System.out.print("\nEnter the elements accordingly:");// User input for number combination
		for (int i = 0; i < n; i++) {
			arr[i] = Utility.returnInt();
		}
		Utility.triplet(arr);// Calling triplet method from utility class for printing the triplets
	}
}
