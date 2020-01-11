package com.bridgelabz.basicprogramming;

import java.io.PrintWriter;

import utility.Utility;

public class TwoDArray {
	public static void main(String args[]) {
		System.out.println(" Two Dimentional Array ");
		int r = Utility.returnInt();//User setting row and column of the 2-D array
		int c = Utility.returnInt();
		int[][] arr1 = new int[r][c];//Integer array
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr1[i][j] = Utility.returnInt();//Input from user
			}
		}
		PrintWriter p = new PrintWriter(System.out);//Printwriter for printing the values
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				p.print(arr1[i][j] + " ");//Output statement
				p.flush();
			}
			System.out.println();
		}
		double[][] arr2 = new double[r][c];//Double array
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr2[i][j] = Utility.returnDouble();//Input from user
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				p.print(arr2[i][j] + " ");//Output statement
				p.flush();
			}
			System.out.println();
		}
		boolean[][] arr3 = new boolean[r][c];//Boolean array
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr3[i][j] = Utility.returnBoolean();//Input from user
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				p.print(arr3[i][j] + " ");//Output statement
				p.flush();
			}
			System.out.println();
		}
	}
}
