package com.bridgelabz.basic;

import java.util.Scanner;

public class HarmonicNumber {
	public static void main(String args[]) {
		System.out.println("Harmonic Number");
		System.out.println("Enter the value of N:");
		Scanner Input=new Scanner(System.in);
		double sum=0.0;
		int N=Input.nextInt();
		for(int i=1;i<=N;i++)
		{
			sum=sum+(double)(1.0/i);
		}
		System.out.println("Sum="+sum);
		Input.close();
	}
}