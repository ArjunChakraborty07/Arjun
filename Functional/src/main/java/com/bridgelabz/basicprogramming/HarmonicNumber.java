package com.bridgelabz.basicprogramming;

import utility.Utility;

public class HarmonicNumber {
	public static void main(String args[]) {
		System.out.println(" Harmonic Number");
		System.out.print("Enter the value of N:");
		double sum=0.0;
		int N=Utility.returnInt();
		for(int i=1;i<=N;i++)
		{
			sum=sum+(double)(1.0/i);
		}
		System.out.println("Sum = "+sum);
	}
}