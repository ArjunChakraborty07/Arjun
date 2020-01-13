package com.bridgelabz.basicprogramming;

import utility.Utility;

public class PrimeThousand {

	public static void main(String args[]) {
		System.out.print("Enter the range(limit is 1000):");
		int n = Utility.returnInt();// Taking input from user
		int arr[] = new int[n];
		int arr1[] = new int[n];
		System.out.println("\nPrimes");
		Utility.prime(n, arr); // Calling method from utility class for prime numbers
		for (int i = 0; i < n; i++) {

			if (arr[i] != 0)
				System.out.print(arr[i] + " ");// Printing the prime numbers
		}
		System.out.println("\nPrime Palindromes");
		Utility.palindrome(arr, arr1); // Calling method from utility class for palindrome numbers
		for (int i = 0; i < arr.length; i++) {

			if (arr1[i] != 0) {
				System.out.print(arr1[i] + " "); // Printing the palindrome numbers
			}
		}
		System.out.println("\nPrime Anagram couples");
		Utility.anagram(arr); // Calling method from utility class for printing the Anagram couples

	}
}