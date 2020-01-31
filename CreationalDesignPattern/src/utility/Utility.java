package utility;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utility {
	private static final Scanner sc = new Scanner(System.in);// Scanner object to take input for all programs

	public static int returnInt() {// Method returning integer value
		return sc.nextInt();
	}

	public static int returnLong() {// Method returning integer value
		return (int) sc.nextLong();
	}

	public static double returnDouble() {// Method returning double value
		return sc.nextDouble();
	}

	public static char returnChar() {// Method returning char value
		return sc.next().charAt(0);
	}

	public static boolean returnBoolean() {// Method returning boolean value
		return sc.nextBoolean();
	}

	public static String returnString() {// Method returning string value
		return sc.nextLine();
	}

	public static void monthlyPayment(int P, int Y, double R) {// Method for monthy payment
		double n = 12 * Y;
		double end = R / (12 * 100);
		double payment = (P * end) / (1 - Math.pow((1 + end), (-n)));
		System.out.print("\nPayment: " + payment);
	}

	public static int displayweek(int d, int m, int y) {// Method to display week
		int y0 = y - (14 - m) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = m + 12 * ((14 - m) / 12) - 2;
		int d0 = (d + x + (31 * m0) / 12) % 7;
		return d0;
	}

	public static boolean leapYear(int year) {
		if (year % 100 == 0) { // Checking the input year for leap year
			if (year % 400 == 0)
				return true;
			else
				return false;
		} else if (year % 4 == 0)
			return true; // return statement
		else
			return false;
	}

	public static void temperatureConversion(int ch, double T) {// Method for temperature conversion
		if (ch == 1) {
			double F = (T * 9 / 5) + 32; // Converting from celcius to fahrenheit
			System.out.println("fahrenheit: " + F);
		} else {
			double C = (T - 32) * 5 / 9; // Converting from fahrenheit to celcius
			System.out.println("Celcius: " + C);

		}
	}

	public static double sqrt(int c) { // Method for epsison square root
		int t = c;
		double epsilon = Math.pow(Math.E, -15); // Calculating the epsilon
		while (Math.abs(t - (c / t)) > epsilon * t) {
			t = ((c / t) + t) / 2;
		}
		return t;// Returning the square root

	}

	public static int[] toBinary(int n) {// Method for integer to binary
		int[] binary = new int[8];
		int index = 7;
		while (n > 0) {
			binary[index] = n % 2;// Storing the binary value in a integer array
			n = n / 2;
			index--;
		}
		return binary;// returning the binary value in integer array
	}

	public static int binarySearch(String arr[], int beg, int end, String str) {// Method for binary search
		while (beg <= end) {// binary search using iteration
			int mid = (beg + end) / 2;
			if (arr[mid].compareToIgnoreCase(str) < 0) {
				beg = mid + 1;
			} else if (arr[mid].compareToIgnoreCase(str) > 0) {
				end = mid - 1;
			} else {
				return mid;// returning the index of the word after search
			}
		}
		System.out.println("Word not found!!");
		return -1;// returning -1 as the word not found
	}

	public static <T extends Comparable<? super T>> T[] Mysortgeneric(T s[]) {// Sorting using generic
		T tmp;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if (s[i].compareTo(s[j]) < 1) {// comparable ? super T to define the compareTo function for generic T
					tmp = s[i];
					s[i] = s[j];
					s[j] = tmp;
				}
			}
		}
		return s;// returning the sorted array
	}

	public static String[] insertionSort(String arr[]) {// Method for insertion sort for a string
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			String temp = arr[i];
			int j = i - 1;
			while (j >= 0 && (arr[j].compareToIgnoreCase(temp) > 0)) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;
		}
		return arr;// Returning the sorted array
	}

	public static int[] insertion(int arr[]) {// Method for insertion sort for an integer array
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;// Returning the sorted array
	}

	public static String[] bubbleSort(String arr[]) {// Method for bubble sort of a string array
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].compareToIgnoreCase(arr[j + 1]) > 0) {
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;// Returning the sorted array
	}

	static void merge(String arr[], int beg, int mid, int end) {// Method for merging the string arrays using iteration
		int n1 = mid - beg + 1;
		int n2 = end - mid;
		String L[] = new String[n1];
		String R[] = new String[n2];
		for (int i = 0; i < n1; ++i) {
			L[i] = arr[beg + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = arr[mid + 1 + j];
		}
		int i = 0, j = 0;
		int k = beg;
		while (i < n1 && j < n2) {
			if (L[i].compareTo(R[j]) <= 0) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static String[] mergeSort(String arr[], int beg, int end) {// Method which is to be called for merge sort in
																		// the
																		// main method for a string
		if (beg < end) {
			int mid = (beg + end) / 2;

			mergeSort(arr, beg, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, beg, mid, end);
		}
		return arr;
	}

	public static boolean AnagramStrings(String string1, String string2) {// Method for anagram strings of a boolean
																			// return type
		char ar1[] = string1.toCharArray();// String converted into char array
		char ar2[] = string2.toCharArray();
		String a = String.valueOf(charsort(ar1));// Char array stored as a string after sorting
		String b = String.valueOf(charsort(ar2));

		if (a.compareToIgnoreCase(b) == 0) {
			return true; // Return statement
		}
		return false; // Return statement
	}

	public static char[] charsort(char arr[]) {// Method for character sort
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (Character.compare(arr[i], arr[j]) > 0) {
					char temp = arr[j];
					arr[j] = arr[i];// Sorting statements
					arr[i] = temp;
				}
			}
		}
		return arr;// Returning the sorted array
	}

	public static <T extends Comparable<? super T>> void selectionSortgeneric(T[] arr) {// Method for selection sort
																						// using generic
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {// Iterative technique to sort
				if (arr[j].compareTo(arr[min]) < 0) {
					min = j;
				}
			}
			T temp = arr[i];
			arr[i] = arr[min];// Swapping values
			arr[min] = temp;
		}
	}

	public static <T extends Comparable<? super T>> int binarySearchgeneric(T arr[], int beg, int end, T str) {// Binary
																												// search
																												// method
																												// using
																												// generic
		while (beg <= end) {// Binary search using iteration
			int mid = (beg + end) / 2;
			if (arr[mid].compareTo(str) < 0) {
				beg = mid + 1;
			} else if (arr[mid].compareTo(str) > 0) {
				end = mid - 1;
			} else {
				return mid;// returning the index of the word after searching
			}
		}
		System.out.println("Item not found!!");
		return -1;// returning -1 if word not found
	}

	public static <T extends Comparable<? super T>> T[] insertionSortgeneric(T[] arr) {// Method for insertion sort
																						// using generic
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			T temp = arr[i];
			int j = i - 1;
			while (j >= 0 && (arr[j].compareTo(temp) > 0)) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;// Sorting statement
		}
		return arr;// Returning the sorted array
	}

	static int ctr = 0;// counter which is till now used only in the guess game

	public static void message(int arr[], int beg, int end) {// Method for the guess game
		ctr++;
		int mid = (beg + end) / 2;// Searching for the number using binary search
		System.out.println(" CPU guesses your number is " + arr[mid]);// Printing the searched number
		System.out.println(" If the guess is high press 1");
		System.out.println(" If the guess is low press 2");// Message for the user for further operations
		System.out.println(" If the guess is correct press 3");
		System.out.print(" Enter your choice:");
		int ch = Utility.returnInt();
		switch (ch) {// Switch case implemented for recursion
		case 1:
			System.out.println(" Number is too high, guess again");
			end = mid;
			message(arr, beg, end);// Method calling itself
			break;
		case 2:
			System.out.println(" Number is too low, guess again");
			beg = mid;
			message(arr, beg, end);// Method calling itself
			break;
		case 3:
			System.out.print(" You guessed it right, good job CPU");// Statement after the number is found
			System.out.print(" ,You took " + ctr + " chances");
			break;
		}
	}

	public static String regexPassageReplace(String fullName, String name, String phNumber, String date) {// Method for
																											// Customized
																											// message
																											// program

		String str = "Hello <<name>>, We have your\n"
				+ "full name as <<full name>> in our system, your contact number is\n"// Message stored as a string type
				+ "91-xxxxxxxxxx. Please,let us know in case of any clarification \n"
				+ "Thank you BridgeLabz 01/01/2016.";
		Pattern p = Pattern.compile("<<name>>");// Using regex pattern
		Matcher m = p.matcher(str);// Using regex matcher
		str = m.replaceAll(name);// Replacing all the undesirable words with the user input
		p = Pattern.compile("<<full name>>");// Using regex pattern
		m = p.matcher(str);// Using regex matcher
		str = m.replaceAll(fullName);// Replacing all the undesirable words with the user input
		p = Pattern.compile("[x]{10}");// Using regex pattern
		m = p.matcher(str);// Using regex matcher
		str = m.replaceAll(phNumber);// Replacing all the undesirable words with the user input
		p = Pattern.compile("01/01/2016");// Using regex pattern
		m = p.matcher(str);// Using regex matcher
		str = m.replaceAll(date);// Replacing all the undesirable words with the user input

		return str;// Returning the replaced string
	}

	public static void prime(int n, int arr[]) {// Method to find prime number from an array storing numbers from 1 to n
		int c = 0;
		for (int i = 2; i <= n; i++) {

			int ctr = 0;
			for (int j = 2; j <= i; j++) {// Iterative method to find the prime numbers in the given array
				if (i % j == 0)
					ctr++;
			}
			if (ctr == 1) {
				arr[c] = i;// Storing the prime numbers in the array
				c++;
			}
		}
	}

	public static void palindrome(int arr[], int arr1[]) {// Method to find the palindrome numbers in a given array
		int ctr = 0;
		for (int i = 0; i < arr.length; i++) {
			int tmp = 0;
			int x = arr[i];
			while (x > 0) {
				tmp = tmp * 10 + x % 10;// Iterative method to find palindrome numbers
				x = x / 10;
			}
			if (tmp == arr[i]) {

				arr1[ctr] = tmp;// storing the palindrome numbers in the array
				ctr++;
			}
		}
	}

	public static void anagram(int arr[]) {// Method to find the anagram pairs in an integer array
		for (int i = 0; arr[i] != 0; i++) {
			String x = String.valueOf(arr[i]);// Converting the char array into a string

			for (int j = i + 1; arr[j] != 0; j++) {
				String y = String.valueOf(arr[j]);
				boolean b = AnagramStrings(x, y);// Calling the anagram method to check the pairs as a anagram
				{
					if (b == true) {
						System.out.println(x + " " + y);// Printing the anagram couples
					}
				}
			}
		}
	}

	public static void triplet(int arr[]) {// Method to find the triplets in given array
		int n = arr.length;
		int x = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {// Iterative method is used to find the triplets
				for (int k = j + 1; k < n; k++) {
					if (i != j && j != k) {
						if (arr[i] + arr[j] + arr[k] == 0) {
							System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);// Printing the desired triplets
							x++;
						}
					}
				}
			}
		}
		if (x == 0)
			System.out.println("No triplets to print!!!");// Output statement if there is no desired triplet present in
															// the array
	}

	public static void change(int N) {// method for vending machine
		int arr[] = { 1, 2, 5, 10, 50, 100, 500, 1000 };// Array representing the notes that are used
		int sum = 0;

		for (int i = 7; i >= 0; i--) {// Iterative method to find the minimum number of notes needed
			if (N >= arr[i]) {
				int no = N / arr[i];
				N = N % arr[i];
				System.out.print(arr[i] + "-" + no + "\n");// Output statement representing use of each note to print
															// the change of a given amount
				sum = sum + no;
			}
		}
		System.out.println("Total number of notes needed are " + sum);// Output statement presenting the total number of
																		// notes needed
	}

	public static int[][] primeRange(int N) {
		int arr[][] = new int[10][100];
		int ar1[] = new int[1000];
		utility.Utility.prime(N, ar1);
		int c = 0;
		for (int i = 0; i < 10; i++) {
			int k = 0;
			for (int j = 0; j < 100; j++) {
				if (ar1[c] <= j + i * 100) {
					arr[i][k] = ar1[c];
					c++;
					k++;
				}
			}
		}
		return arr;
	}

	public static void printTwoPrime(int arr[][]) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 0)
					System.out.print(arr[i][j] + "    ");
				else
					System.out.print(arr[i][j] + "  ");
			}
			System.out.println("\n");
		}
	}

	
	
}
