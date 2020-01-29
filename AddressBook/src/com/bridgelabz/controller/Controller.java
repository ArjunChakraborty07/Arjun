package com.bridgelabz.controller;

import com.addressbook.utility.Utility;
import com.bridgelabz.service.Service;

public class Controller {
	public static void main(String args[]) throws Exception {

		Service obj=new Service();
		int s = 0;
		while (s == 0) {
			System.out.print("1. Add address 2. Edit Address 3. Delete Address 4. Display 5. ZIPSort 6. NameSort"
					+ "\nEnter a choice of operation:");
			int ch = Utility.returnInt();
			Utility.returnString();
			switch (ch) {
			case 1:
				System.out.print(" Enter the First Name: ");
				String fname = Utility.returnString();
				System.out.print(" Enter the Last Name: ");
				String lname = Utility.returnString();
				System.out.print(" Enter Address: ");
				String address = Utility.returnString();
				System.out.print(" Enter City: ");
				String city = Utility.returnString();
				System.out.print(" Enter State: ");
				String state =Utility.returnString();
				System.out.print(" Enter ZIP: ");
				int zip = Utility.returnInt();
				Utility.returnString();
				System.out.print(" Enter Phone Number: ");
				String phone = Utility.returnString();
				obj.addAddress(fname, lname, address, city, state, zip, phone);
				obj.display();
				break;
			case 2:
				System.out.print(" Enter the First Name: ");
				fname = Utility.returnString();

				obj.editAddress(fname);
				obj.display();
				break;
			case 3:
				System.out.print(" Enter the First Name: ");
				fname = Utility.returnString();
				obj.deleteAddress(fname);
				obj.display();
				break;
			case 4:
				obj.display();
				break;
			case 5:
				obj.sortZIP();
				obj.display();
			case 6:
				obj.	sortName();
				obj.display();
			default:
				s++;
			}
		}
	}
}
