package com.bridgelabz.basicprogramming;

import java.io.IOException;

import utility.Utility;

public class GuessGame {

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(args[0]); // Input argument N
		System.out.println("Guess a number between 0 to " + (N - 1));
		System.in.read();
		int arr[] = new int[N - 1]; // Creating an array of N-1 size
		for (int i = 0; i < N - 1; i++) {
			arr[i] = i;
		}
		int beg = 0;
		int end = N - 1;
		Utility.message(arr, beg, end); // Calling utility class method
	}

}
