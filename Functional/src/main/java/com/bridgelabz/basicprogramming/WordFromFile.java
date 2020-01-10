package com.bridgelabz.basicprogramming;

import java.io.*;

import utility.Utility;

public class WordFromFile {

	public static void main(String args[]) {
		try {
			System.out.println("Word From File");
			String str = "great.";
			File file = new File("/home/admin1/Desktop/simple.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st = br.readLine();
			System.out.println(st);
			String s[] = st.split(" ");
			System.out.println(s.length);
			s = Utility.bubbleSort(s);
			for (int i = 0; i < s.length; i++) {
				System.out.print(s[i] + " ");
			}
			System.out.println();
			int beg = 0, end = s.length - 1;
			int gotcha = Utility.binarySearch(s, beg, end, str);
			System.out.println(gotcha);
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
