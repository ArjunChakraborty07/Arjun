package com.bridgelabz.basic;

import java.util.Scanner;

public class TripletZero {
	public static void main(String args[]) {
		System.out.println("Triplet Zero");
		System.out.print("Enter the size of array:");
		Scanner Input=new Scanner(System.in);
		int n=Input.nextInt();
		int arr[]=new int[n];
		System.out.print("\nEnter the elements accordingly:");
		for(int i=0;i<n;i++)
		{
			arr[i]=Input.nextInt();
		}
	    for(int i=0;i<n;i++)
	    {
	    	for(int j=i+1;j<n;j++)
	    	{
	    		for(int k=j+1;k<n;k++)
	    		{
	    			if(i!=j && j!=k)
	    			{
	    				if(arr[i]+arr[j]+arr[k]==0)
	    				{
	    					System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
	    				}
	    			}
	    		}
	    	}
	    }
	    Input.close();
	}
}
