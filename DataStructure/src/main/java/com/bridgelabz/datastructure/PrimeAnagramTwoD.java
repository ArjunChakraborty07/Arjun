package com.bridgelabz.datastructure;

public class PrimeAnagramTwoD {
	public static String[] primeAnagramTwoD(int N) {
		String arr1[] = new String[1000];
		int arr[][] = utility.Utility.primeRange(N);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 0) {
					arr1[i] = " ";
				} else {
					arr1[i] = Integer.toString(arr[i][j]);
				}
			}
		}
		twoDAnagram(arr1);
		return arr1;
	}

	public static String[][] twoDAnagram(String arr[]) {
		int arr1[] = new int[1000];
		int a = 0;
		
		for (int i = 0; arr[i]!=" "; i++) {
			int ctr=0;
			String x = arr[i];
			if(ctr>0)
			{
				arr1[a]=Integer.parseInt(x);
			}			
			for (int j = i + 1; arr[j]!=" "; j++) {
				boolean b = utility.Utility.AnagramStrings(x, arr[j]);
				if(b==true)
				{
					ctr++;
				}
			}
		}
		a=0;
		String arr2[][]=new String [10][1000];
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<1000;j++)
			{
				if(arr1[j]<100*(i+1))
				{
					arr2[i][j]=Integer.toString(arr1[a]);
					a++;
				}
			}
		}
		return arr2;
	}

	public static void main(String args[]) {

		System.out.print("Enter a Range: ");
		int N = utility.Utility.returnInt();

		String arr[] = primeAnagramTwoD(N);
		String arr1[][]=twoDAnagram(arr);
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<100;j++)
			{
				if(arr1[i][j]=="0")
					arr1[i][j]=" ";
			}
		}
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<100;j++)
			{
				System.out.print(arr1[i][j]);
			}
			System.out.println();
		}
		
	}
}
