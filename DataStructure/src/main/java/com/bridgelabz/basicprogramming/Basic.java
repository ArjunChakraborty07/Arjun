package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Basic {
	public static void main(String[] args) {
		String str = "Hello <<username>>, how are you?";
		System.out.println(str); // Taking input from the user
		System.out.print("Enter Your Name : ");
		String name = Utility.returnString();
		str = str.replace("<<username>>", name); // Replacing <<username>> with name
		System.out.println(str); // printing the modified string
	}
}
