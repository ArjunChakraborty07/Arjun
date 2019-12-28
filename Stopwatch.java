package com.bridgelabz.basic;

public class Stopwatch {
public static void main(String args[]) {
	long start=System.currentTimeMillis();
	long s=0;
	System.out.println("Hello, welcome to my coding");
	for(int i=1;i<=1000000;i++)
	{
		 s++;
	}
	long end=System.currentTimeMillis();
	System.out.println(end-start);
}
}
