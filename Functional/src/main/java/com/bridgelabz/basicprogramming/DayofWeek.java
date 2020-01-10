package com.bridgelabz.basicprogramming;

import utility.Utility;

public class DayofWeek {

	public static void main(String args[]) {

		System.out.println(" Day of Week ");
		System.out.print("Enter the day, month and year(accordingly):");
		int d = Utility.returnInt();
		int m = Utility.returnInt();
		int y = Utility.returnInt();
		Utility.displayweek(d, m, y);
	}
}
