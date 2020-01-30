package com.bridgelabz.controller;

import com.addressbook.utility.Utility;
import com.bridgelabz.service.Service;

public class Controller {
	public static void main(String args[]) throws Exception {

		Service obj=new Service();
		int s = 0;
		while (s == 0) {
			System.out.println("___________________");
			System.out.println("|1. Add address   |");
			System.out.println("|2. Edit Address  |");
			System.out.println("|3. Delete Address|");
			System.out.println("|4. Display       |");
			System.out.println("|5. ZIPSort       |");
			System.out.println("|6. NameSort      |");
			System.out.println("-------------------");
			int ch = Utility.returnInt();
			Utility.returnString();
			switch (ch) {
			case 1:
				
				obj.addAddress();
				obj.display();
				break;
			case 2:				

				obj.editAddress();
				obj.display();
				break;
			case 3:
				
				obj.deleteAddress();
				obj.display();
				break;
			case 4:
				
				obj.display();
				break;
			case 5:
				
				obj.sortZIP();
				obj.display();
				break;
			case 6:
				
				obj.sortName();
				obj.display();
				break;
			default:
				
				s++;
			}
		}
	}
}
