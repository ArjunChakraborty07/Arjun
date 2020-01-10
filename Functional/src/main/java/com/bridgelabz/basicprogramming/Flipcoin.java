package com.bridgelabz.basicprogramming;

import java.util.Random;

public class Flipcoin {
	public static void main(String[] args) {
		System.out.println(" Flip Coin ");
		Random rand = new Random();
		double a = rand.nextDouble();
		if (a < 0.5)
			System.out.println("head");
		else
			System.out.println("tail");
	}
}
