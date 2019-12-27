package com.bridgelabz.basic;

import java.util.Scanner;

public class Leapyear {
	public static void main(String[] args) {
		int year;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a year for checking:");
		year=input.nextInt();
		if(year%100==0) {
			if(year%400==0)
				System.out.println("Leap Year");
			else
				System.out.println("Not a leap year");
		}
		else if(year%4==0)
			System.out.println("Leap Year");
		else
			System.out.println("Not a leap year");
		input.close();
	}

}
