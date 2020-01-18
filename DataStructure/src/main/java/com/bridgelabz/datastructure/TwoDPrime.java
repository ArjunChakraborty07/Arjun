package com.bridgelabz.datastructure;

public class TwoDPrime {
	
	
	public static void main(String args[])
	{
		System.out.println(" 	Prime within range upto 1000 using 2D array");
		System.out.print("\nEnter a range: ");
		int N=utility.Utility.returnInt();
		System.out.println();
		int arr[][]=utility.Utility.primeRange(N);
		utility.Utility.printTwoPrime(arr);		
	}
}
