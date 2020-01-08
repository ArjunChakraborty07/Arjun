package com.bridgelabz.basicprogramming;

import utility.Utility;

public class utilcheck {
	
public static void main(String args[]) {	
	String arr[]= {"Aditya","Sourav","varsha", "Rounak","rahul","Chitvan","Arjun","Bikas"};
	Utility.mergeSort(arr,0, arr.length-1);
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]+" ");
	}
	int arr1[]= {5, 3, 6, 8, 2};
	
	int arr2[]=Utility.insertion(arr1);
	for(int i=0;i<5;i++)
	{
		System.out.println(arr2[i]);
	}
}
}
