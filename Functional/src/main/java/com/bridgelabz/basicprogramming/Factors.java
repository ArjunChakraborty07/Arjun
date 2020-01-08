package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Factors {
	public static void main(String args[]) {
		System.out.println(" Prime Factors");
		System.out.print("Entet a value:");
		int N = Utility.returnInt();
		for (int i = 2; i * i <= N; i++) {
			while (N % i == 0) {
				System.out.print(i + " ");
				N = N / (i);
			}
		}
		if (N > 2)
			System.out.print(N);
	}
}
