package com.bridgelabz.basicprogramming;

public class Permutation {

	private static void swap(char[] a, int i, int j) {// Method for swapping
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static String join(char[] a) { // Method to join a char array to string
		StringBuilder builder = new StringBuilder();
		builder.append(a);
		return builder.toString();
	}

	public static void iteration(String str) { // Permuting with iteration
		System.out.println(str);
		char[] a = str.toCharArray(); // Breaking the string into char array
		int n = a.length;
		int[] p = new int[n]; // Creating an integer array that is of the same size of the char array
		int i = 1;
		while (i < n) {
			if (p[i] < i) { // Checking for the non-swapped combinations using iteration
				int j;
				if (i % 2 == 0) {
					j = 0;
				} else {
					j = p[i];
				}
				swap(a, i, j);
				System.out.println(join(a));// Printing the new combination
				p[i]++;
				i = 1;
			} else {
				p[i] = 0;
				i++;
			}
		}
	}

	public static void permuteRecursion(String str, int l, int r) {// Permutation using Recursive method
		if (l == r) // Condition for new combination
			System.out.println(str);// Printing the new combination
		else {
			for (int i = l; i <= r; i++) {
				str = swap1(str, l, i); // Calling swap function
				permuteRecursion(str, l + 1, r);// Method calling itself
				str = swap1(str, l, i);
			}
		}
	}

	public static String swap1(String a, int i, int j) {// Method for Swapping
		char[] charArray = a.toCharArray();
		swap(charArray, i, j);
		return String.valueOf(charArray);// Returning the string value of the char array
	}

	public static void main(String args[]) {
		System.out.println("Permutation");
		String str = "ABC";// Input String
		System.out.println(" Permutation with Iteration\n");
		iteration(str);// Iteration method calling
		System.out.println("\n Permutation with Recursion\n");
		int n = str.length();
		permuteRecursion(str, 0, n - 1);// Recursion method calling
	}

}
