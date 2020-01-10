package com.bridgelabz.basicprogramming;

import java.io.PrintWriter;
import java.util.Scanner;

import utility.Utility;

public class TwoDArray {
	public static void main(String args[]) {
		System.out.println(" Two Dimentional Array ");
		Scanner input = new Scanner(System.in);
		int r = Utility.returnInt();
		int c = Utility.returnInt();
		int[][] arr1 = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr1[i][j] = Utility.returnInt();
			}
		}
		PrintWriter p = new PrintWriter(System.out);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				p.print(arr1[i][j] + " ");
				p.flush();
			}
			System.out.println();
		}
		double[][] arr2 = new double[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr2[i][j] = Utility.returnDouble();
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				p.print(arr2[i][j] + " ");
				p.flush();
			}
			System.out.println();
		}
		boolean[][] arr3 = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr3[i][j] = Utility.returnBoolean();
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				p.print(arr3[i][j] + " ");
				p.flush();
			}
			System.out.println();
		}
		input.close();
	}
}
