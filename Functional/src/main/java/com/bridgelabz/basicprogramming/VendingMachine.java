package com.bridgelabz.basicprogramming;

import utility.Utility;

public class VendingMachine {

	static int arr[] = { 1, 2, 5, 10, 50, 100, 500, 1000 };

	public static void change(int N) {
		int sum = 0;

		for (int i = 7; i >= 0; i--) {
			if (N >= arr[i]) {
				int no = N / arr[i];
				N = N % arr[i];
				System.out.print(arr[i] + "-" + no + "\n");
				sum = sum + no;
			}
		}
		System.out.println("Total number of notes needed are " + sum);
	}

	public static void main(String args[]) {
		System.out.println("Wending Machine");
		System.out.print("Enter the amount of Rupees:");
		int N = Utility.returnInt();
		change(N);
	}

}
