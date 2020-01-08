package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Binary {
	public static void main(String args[]) {
		int N;
		System.out.print("Enter a number to convert :");
		N=Utility.returnInt();
		int binary[]=Utility.toBinary(N);
		System.out.print("Binary of "+N+" is ");
		for(int i=0;i<8;i++)
		{
			System.out.print(binary[i]);
		}
		int newbinary[]=new int[8];
		for(int i=0;i<4;i++)
		{
			newbinary[i+4]=binary[i];
		}
		System.out.println();
		for(int i=4;i<8;i++)
		{
			newbinary[i-4]=binary[i];
		}
		System.out.print("Binary after nibble swapping is ");
		for(int i=0;i<8;i++)
		{
			System.out.print(newbinary[i]);
		}
		int newdecimal=0;
		for(int i=0;i<8;i++)
		{
			newdecimal+=newbinary[i]*Math.pow(2, 7-i);
		}
		System.out.print("\nDecimal of the new binary is "+newdecimal);
	}
}
