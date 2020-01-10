package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Quadratic {
	public static void main(String args[]) {
		System.out.println(" Quadratic Equation" + "\naX*X+bX+c");
		System.out.print("Enter the values of a, b and c:");
		int a = Utility.returnInt();
		int b = Utility.returnInt();
		int c = Utility.returnInt();
		int D = b * b - 4 * a * c;
		double root1 = (-b + Math.sqrt(D)) / (2 * a);
		double root2 = (-b - Math.sqrt(D)) / (2 * a);
		System.out.print("\nRoot 1=" + root1 + " and Root2=" + root2);
	}
}
