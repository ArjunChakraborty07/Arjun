package com.bridgelabz.basic;

import java.util.Scanner;

public class Factors {
public static void main(String args[]) {
	Scanner input=new Scanner(System.in);
	System.out.print("Entet a value:");
	int N=input.nextInt();
	for(int i=2;i*i<=N;i++) {
		while(N%i==0) {
			System.out.print(i+" ");
		    N=N/(i);
		}		
	}
	if(N>2)
		System.out.print(N);
input.close();
}
}
