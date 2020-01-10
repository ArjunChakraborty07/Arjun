package com.bridgelabz.basicprogramming;

public class Permutation {
	public static void iteration(String str) {
		System.out.println(str);
		char[] a = str.toCharArray();
		int n = a.length;
		int[] p = new int[n];
		int i = 1;
		while (i < n) {
			if (p[i] < i) {
				int j;
				if (i % 2 == 0) {
					j = 0;
				} else {
					j = p[i];
				}
				swap(a, i, j);
				System.out.println(join(a));
				p[i]++;
				i = 1;
			} else {
				p[i] = 0;
				i++;
			}
		}
	}

	private static String join(char[] a) {
		StringBuilder builder = new StringBuilder();
		builder.append(a);
		return builder.toString();
	}

	private static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void permuteRecursion(String str, int l, int r)
	{
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap1(str, l, i);
				permuteRecursion(str, l + 1, r);
				str = swap1(str, l, i);
			}
		}
	}

	public static String swap1(String a, int i, int j)
	{
		char[] charArray = a.toCharArray();
		swap(charArray, i, j);
		return String.valueOf(charArray);
	}

	public static void main(String args[]) {
		System.out.println("Permutation");
		String str = "ABC";
		System.out.println(" Permutation with Iteration\n");
		iteration(str);
		System.out.println("\n Permutation with Recursion\n");
		int n = str.length();
		permuteRecursion(str, 0, n - 1);
	}

}
