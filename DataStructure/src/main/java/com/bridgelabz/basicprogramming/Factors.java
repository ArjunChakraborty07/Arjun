package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Factors {
	public static void main(String args[]) {
		System.out.println(" Prime Factors");
		System.out.print("Entet a value:"); // Taking input from user
		int N = Utility.returnInt();
		for (int i = 2; i * i <= N; i++) {
			while (N % i == 0) { // Generating prime factors
				System.out.print(i + " ");
				N = N / (i);
			}
		}
		if (N > 2)
			System.out.print(N); // Output statement
	}
}
