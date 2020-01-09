package com.bridgelabz.basicprogramming;

import utility.Utility;

public class PrimeThousand {
	public static void prime(int n, int arr[])
	{
		int c=0;
		for(int i=2;i<=n;i++)
		{
			
			int ctr=0;
			for(int j=2;j<=i;j++)
			{
				if(i%j==0)
					ctr++;
			}
			if(ctr==1)
			{
				arr[c]=i;
				c++;
			}
		}
	}
	public static void palindrome(int arr[],int arr1[])
	{
		int ctr=0;
		for(int i=0;i<arr.length;i++)
		{
			int tmp=0;
			int x=arr[i];
			while(x>0)
			{
				tmp=tmp*10+x%10;	
				x=x/10;
			}
			if(tmp==arr[i])
			{
				
				arr1[ctr]=tmp;
				ctr++;
			}
		}
	}
	public static void anagram(int arr[], String arr1[], String arr2[])
	{
		int ctr=0;
		for(int i=0;i<arr.length;i++)
		{
			String x=Integer.toString(arr[i]);
			for(int j=i+1;j<arr.length;j++)
			{
				String y=Integer.toString(arr[j]);
				boolean b=Utility.AnagramStrings(x, y);
				if(b==true)
				{
					arr1[ctr]=x;
					arr2[ctr]=y;
				}
			}
		}
	}
	public static void main(String args[])
	{
		System.out.print("Enter the range(limit is 1000):");
		int n=Utility.returnInt();
		int arr[]=new int[n];
		int arr1[]=new int[n];
		String str[]=new String[n];
		String str1[]=new String[n];
		for(int i=0;i<n;i++)
		{
			prime(n,arr);
			if(arr[i]!=0)
				System.out.print(arr[i]+" ");
		}
		System.out.println("\nPalindrome");
		for(int i=0;i<arr.length;i++)
		{
			palindrome(arr,arr1);
			if(arr1[i]!=0)
			{
				System.out.print(arr1[i]+" ");
			}
		}
		for(int i=0;i<n;i++)
		{
			anagram(arr,str,str1);
			if(str[i]!=null)
			{
				System.out.print(str[i]+" ");
				System.out.print(str1[i]+" ");
			}
		}
		
	}
}