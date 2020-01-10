package com.bridgelabz.basicprogramming;


import utility.Utility;

public class GuessGame {
	
	public static void main(String[] args)
	{
		int N=Integer.parseInt(args[0]);
		System.out.println("Guess a number between 0 to "+ (N-1));
		int a=Utility.returnInt();
		int arr[]=new int [N-1];
		for(int i=0;i<N-1;i++)
		{
			arr[i]=i;
		}
		int beg=0;
		int end=N-1;
		Utility.message(arr,beg,end);
    }
	
}
