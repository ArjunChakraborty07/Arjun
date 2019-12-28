package com.bridgelabz.basic;

import java.util.Random;
import java.util.Scanner;

public class Coupons {
	static Random r=new Random();
	public static int generaterandom(int x)
	{
		int n=5;
		int y=r.nextInt(n)+1;
		if(x==y)
		{
			generaterandom(x);
		}
		return y;
	}
	
	public static void distinctCoupon(int N) {
		
		int arr[]=new int[N];
		int n=5;
		for(int i=0;i<N;i++)
		{
			arr[i]=r.nextInt(n)+1;
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(arr[i]==arr[j] && i!=j)
				{
					int P=generaterandom(arr[i]);
					for(int s=0;s<i;s++) 
					{
						if(P==arr[s])
						{
							P=generaterandom(arr[i]);
						}
					}
					arr[i]=P;					
				}
		    }
		}
		for(int i=0;i<N;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String args[]) {
		
		System.out.println("Coupon Numbers\n\n");
		Scanner Input=new Scanner(System.in);
		System.out.print("Enter the size of the array:");
		int N=Input.nextInt();
		distinctCoupon(N);
		Input.close();
	}

}
