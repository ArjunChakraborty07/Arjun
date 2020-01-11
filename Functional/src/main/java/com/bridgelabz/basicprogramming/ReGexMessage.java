package com.bridgelabz.basicprogramming;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.Utility;

public class ReGexMessage {
	public static String regexPassageReplace(String str, String fullName, String name, String phNumber, String date) {

		Pattern p = Pattern.compile("<<name>>");
		Matcher m=p.matcher(str);
		str = m.replaceAll(name);
		p = Pattern.compile("<<full name>>");
		m = p.matcher(str);
		str = m.replaceAll(fullName);
		p = Pattern.compile("[x]{10}");
		m = p.matcher(str);
		str = m.replaceAll(phNumber);
		p = Pattern.compile("01/01/2016");
		m = p.matcher(str);
		str = m.replaceAll(date);

		return str;
	}

	public static void main(String[] args) {
		String str = " Hello <<name>>, We have your\n "
				+ "full name as <<full name>> in our system, your contact number is\n "
				+ "91-xxxxxxxxxx. Please,let us know in case of any clarification \n"
				+ " Thank you BridgeLabz 01/01/2016.";

		System.out.print("Enter the Name: ");
		String fullName = Utility.returnString();
		// System.out.println("Enter the Full Name");
		String name[] = fullName.split(" ");
		System.out.println("Enter the Phone Number: ");
		String phNumber = Utility.returnString();
		System.out.println("Enter the Date: ");
		String date = Utility.returnString();
		String replacedStr = regexPassageReplace(str, fullName, name[0], phNumber, date);
		System.out.println(replacedStr);

	}

}
