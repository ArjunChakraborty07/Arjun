package com.bridgelabz.basicprogramming;

import java.io.*;

import utility.Utility;

public class WordFromFile {

	public static void main(String args[]) {
		try { // Try invoked
			System.out.println("Word From File");
			String str = "great.";
			File file = new File("/home/admin1/Desktop/simple.txt");// Taking the path of the file
			BufferedReader br = new BufferedReader(new FileReader(file));// Buffer reader and file reader to read the
																			// file passed by the path
			String st = br.readLine();// Storing the text in a string variable
			System.out.println(st);// Printing the text
			String s[] = st.split(" ");// Splitting the words and stored it into a string array
			System.out.println(s.length);
			s = Utility.bubbleSort(s);// Calling bubble sort method from utility class to sort the string
			for (int i = 0; i < s.length; i++) {
				System.out.print(s[i] + " ");// Printing the sorted string
			}
			System.out.println();
			int beg = 0, end = s.length - 1;
			int gotcha = Utility.binarySearch(s, beg, end, str);// Calling the binary search method from utility class
			System.out.println(gotcha);// Printing the index of the searched word
			br.close();
		} catch (Exception e) { // Catching the exception
			System.out.println(e); // Printing the exception
		}
	}
}
