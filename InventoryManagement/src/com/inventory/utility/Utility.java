package com.inventory.utility;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	
	
	
	

}
