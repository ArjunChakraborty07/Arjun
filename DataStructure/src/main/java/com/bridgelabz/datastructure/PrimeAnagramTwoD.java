package com.bridgelabz.datastructure;

public class PrimeAnagramTwoD {
	public static String[][] primeAnagramTwoD(int N) {
		String arr1[][] = new String[10][100];
		int arr[][] = utility.Utility.primeRange(N);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 0) {
					arr1[i][j] = " ";
				} else {
					arr1[i][j] = Integer.toString(arr[i][j]);
				}
			}
		}
		String arr2[][] = twoDAnagram(arr1);
		return arr2;
	}

	public static String[][] twoDAnagram(String arr[][]) {
		String arr2[][] = new String[10][30];
		int ctr1 = 0, ctr2 = 0;
		/*
		 * for(int i=0;i<10;i++) { for(int j=0;j<30;j++) { String x=arr[i][j]; for(int
		 * k=0;k<10;k++) { for(int l=j;l<30;l++) { if(x!=arr[k][l]) { String
		 * y=arr[k][l]; if(utility.Utility.AnagramStrings(x, y)==true ) {
		 * if(Integer.parseInt(x)>j+100*(i+1)) { ctr1++; ctr2=0; } arr2[ctr1][ctr2]=x;
		 * ctr2++; } } } } } }
		 */
		int ar[] = new int[500];
		String ar2[] = new String[2000];
		int t = 0;
		utility.Utility.prime(1000, ar);
		for (int i = 0; ar[i] != 0; i++) {
			String x = String.valueOf(ar[i]);
			for (int j = 0; ar[j] != 0; j++) {
				String y = String.valueOf(ar[j]);
				boolean b = utility.Utility.AnagramStrings(x, y);
				if (b == true) {
					ar2[t] = x;
					t++;
				}
			}
		}
		String ar3[] = new String[100];

		for (int i = 0; i < 200; i++) {
			int x = 0;
			int ctr = 0;
			for (int j = 0; j < 200; j++) {
				if (ar2[i] == ar2[j]) {
					ctr++;
				}
			}
			if (ctr > 1) {
				ar3[x] = ar2[i];
				x++;
			}
		}
		for (int i = 0; i < 200; i++) {
			if (ar3[i] == null)
				ar3[i] = " ";
		}
		for (int i = 0; i < 100; i++) {
			System.out.print(ar3[i] + " ");
		}

		/*
		 * for(int i=0;i<10;i++) { for(int j=0;j<30;j++) { if(arr2[i][j]==null)
		 * arr2[i][j]=" "; } }
		 */
		return arr2;
	}

	public static void main(String args[]) {

		System.out.print("Enter a Range: ");
		int N = utility.Utility.returnInt();

		String arr[][] = primeAnagramTwoD(N);

		/*
		 * for(int i=0;i<10;i++) { for(int j=0;j<30;j++) {
		 * System.out.print(arr[i][j]+" "); } System.out.println(); }
		 */

	}
}
