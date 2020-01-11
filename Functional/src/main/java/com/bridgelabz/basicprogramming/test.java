package com.bridgelabz.basicprogramming;

import utility.Utility;

public class test {
	public static void main(String[] args) {
		int a=100;
		int []d=Utility.toBinary(a);
		for(int i=0;i<8;i++)
		System.out.print(d[i]);
	}
}
