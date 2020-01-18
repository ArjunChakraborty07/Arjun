package com.bridgelabz.datastructure;

public class PrimeAnagramTwoD {
	public static String[][] primeAnagramTwoD(int N) {
		int x = 0;
		String arr1[] = new String[1000];
		int arr[][] = utility.Utility.primeRange(N);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 0) {
					arr1[i] = " ";
				} else {
					arr1[i] = Integer.toString(arr[i][j]);
				}
				x++;
			}
		}
		twoDAnagram(arr1);
		return arr1;
	}

	public static void twoDAnagram(String arr[]) {
		String arr1[][] = new String[10][100];
		int a = 0, c = 0;
		int ctr = 0;
		for (int i = 0; i < 1000; i++) {
			String x = arr[i];
			for (int j = i + 1; j < 1000; j++) {
				boolean b = utility.Utility.AnagramStrings(x, arr[j]);
				if (b == true) {
					ctr++;
					if (ctr == 1) {
						arr1[a][c] = x;
						ctr = 0;
						c++;
					}
					arr1[a][c] = arr[j];
					c++;
					if (c == 99) {
						c = 0;
						a++;
					}
				}
			}
		}
	}

	public static void main(String args[]) {

		System.out.print("Enter a Range: ");
		int N = utility.Utility.returnInt();

		String arr[][] = primeAnagramTwoD(N);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
