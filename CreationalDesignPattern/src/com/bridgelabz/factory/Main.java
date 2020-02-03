package com.bridgelabz.factory;

import utility.Utility;

public class Main {
	public static void main(String[] args) {
		ComputerFactory obj = new ComputerFactory();
		System.out.println("Access Input:");
		String input = Utility.returnString();
		obj.call(input);
	}
}
