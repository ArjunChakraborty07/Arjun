package com.bridgelabz.basicprogramming;

import java.util.Random;

public class Flipcoin {
	public static void main(String[] args) {
		System.out.println(" Flip Coin ");
		Random rand = new Random();
		double a = rand.nextDouble(); // randomly generating numbers between 0 and 1
		if (a < 0.5)
			System.out.println("head"); // Condition of the toss and their respective output statement
		else
			System.out.println("tail");
	}
}
