package com.bridgelabz.basic;

import java.util.Scanner;

public class Basic {
	public static void main(String[] args) {

	String str="Hello <<username>>, how are you?";
	System.out.println(str);
	Scanner Input=new Scanner(System.in);
	System.out.println("enter the value");
    String name=Input.next();
    str=str.replace("<<username>>",name);
    System.out.println(str);
    Input.close();
	}
}