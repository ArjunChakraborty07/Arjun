package com.bridgelabz.basicprogramming;

public class Stopwatch {
	public static void main(String args[]) {
		long start = System.currentTimeMillis();// Using inbuilt method
		long s = 0;
		System.out.println(" Hello, welcome to my coding ");
		for (long i = 1; i <= 1000000; i++) {// Compiling a dummy program
			s++;
		}
		System.out.println(s);
		long end = System.currentTimeMillis();// Using inbuilt function
		System.out.println(end - start);// Printing the difference of start and end to get the exact time of compilation
										// in milliseconds
	}
}
