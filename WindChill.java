package com.bridgelabz.basic;

public class WindChill {
	public static void main(String args[]) {
		System.out.println("WindChill");
		System.out.print(" Enter the two commandline arguments t(in Farhenheit) and v(in miles per hour) accordingly:");
		double t=Integer.parseInt(args[0]);
		double v=Integer.parseInt(args[1]);
		double w=35.74+(0.6215*t)+(0.4275*t-35.75)*Math.pow(v, 0.16);
		System.out.print(" The windchill is "+ w);
	}

}
