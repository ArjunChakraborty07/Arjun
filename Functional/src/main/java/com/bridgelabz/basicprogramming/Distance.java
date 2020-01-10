package com.bridgelabz.basicprogramming;

public class Distance {
	public static void main(String args[]) {
		System.out.println("Euclid Distance ");
		System.out.print("Enter the arguments:");
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		double distance = Math.sqrt(x * x + y * y);
		System.out.println("The Euclid Distance is " + distance);
	}

}
