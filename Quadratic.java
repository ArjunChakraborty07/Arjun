package com.bridgelabz.basic;

import java.util.Scanner;

public class Quadratic {
	public static void main(String args[])
	{
		System.out.println("Quadratic Equation"+"\naX*X+bX+c");
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the values of a, b and c:");
		int a=input.nextInt();
		int b=input.nextInt();
		int c=input.nextInt();
		int D=b*b-4*a*c;
		double root1=(-b+Math.sqrt(D))/(2*a);
		double root2=(-b-Math.sqrt(D))/(2*a);
		System.out.print("\nRoot 1="+root1+" and Root2="+root2);
		input.close();
	}
}
