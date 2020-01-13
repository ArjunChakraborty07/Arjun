package com.bridgelabz.basicprogramming;

import java.util.ArrayList;
import java.util.Random;

import utility.Utility;

public class DistinctCoupons {
	public static void main(String args[]) {
		System.out.println(" Distinct Coupons using ArrayList ");
		System.out.print("Enter the numbers of needed coupon:"); // Taking input from user
		int size = Utility.returnInt();
		// int arr[]=new int[size];
		ArrayList<Integer> ar1 = new ArrayList<Integer>();

		// int x=ar1.get(0);
		// System.out.println(x);
		// ar1.add(50);
		// System.out.println(ar1);
		// ar1.add(2, 60);
		// System.out.println(ar1);
		// System.out.println(ar1.size());
		Random r = new Random();
		int temp = r.nextInt(size) + 1; // Generating random coupons
		int s = 0;
		int m = 0;
		// System.out.println(temp);
		// ar1.add(temp);
		// System.out.println(ar1);
		while (s < size - 1) { // Searching for distinct coupons
			if (ar1.size() == 0) {
				ar1.add(temp);
			} else {
				m++;
				temp = r.nextInt(size) + 1;
				int ctr = 0;
				for (int i = 0; i < ar1.size(); i++) {
					if (ar1.get(i) == temp)
						ctr++;
				}
				if (ctr == 0) {
					ar1.add(temp); // Adding the distinct coupons
					// arr[s]=temp;
					s++;
				}
			}
		}
		// ar1.remove(0);
		// for(int i=0;i<size;i++)
		// {
		System.out.print(ar1); // Printing the distinct coupons
		// }
		System.out.println();
		System.out.println("Total random numbers needed to generate distinct coupons are " + m); // Print the output
																									// statement
	}
}
