package com.bridgelabz.basicprogramming;

import utility.Utility;

public class Basic {
	public static void main(String[] args) {
		String str="Hello <<username>>, how are you?";
		System.out.println(str);
		System.out.print("Enter Your Name : ");
		String name=Utility.returnString();
	    str=str.replace("<<username>>",name);
	    System.out.println(str);
		}
}
