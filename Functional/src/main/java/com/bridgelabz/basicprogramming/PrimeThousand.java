package com.bridgelabz.basicprogramming;

import java.util.ArrayList;

import utility.Utility;

public class PrimeThousand {
	public static void main(String args[])
	{
		System.out.println("Enter the range(limit is 1000):");
		int n=Utility.returnInt();
		ArrayList<Integer> arraylist=new ArrayList<Integer>();
		for(int j=2;j<=n;j++)
		{int c=0;
		for(int i=2;i<=j;i++)
		{
			if(j%i==0)
				c++;
		}
		if(c==1)
		arraylist.add(j);
		}		
		System.out.println(arraylist);
	}
}
