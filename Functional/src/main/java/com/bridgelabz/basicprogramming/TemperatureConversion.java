package com.bridgelabz.basicprogramming;

import utility.Utility;

public class TemperatureConversion {

	public static void main(String args[])
	{
		System.out.println(" Temperature conversion ");
		System.out.print("Enter the preference (1.Celcius to Farhenheit) / (2.Farhenheit to Celcius):");
		int ch=Utility.returnInt();
		System.out.print("Enter the temperature:");
		double T=Utility.returnInt();
		Utility.temperatureConversion(ch,T);
	}
}
