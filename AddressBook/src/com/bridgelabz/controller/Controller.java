package com.bridgelabz.controller;

import com.addressbook.utility.Utility;
import com.bridgelabz.service.Service;

public class Controller {
	public static void main(String args[]) {
		try
		{
		Service obj=new Service();
		int s = 0;
		while (s == 0) {
		
			int ch = Utility.returnInt();
			Utility.returnString();
			
			switch (ch) {
			case 1:
				
				obj.addAddress();
				
				break;
			case 2:				

				obj.editAddress();
				
				break;
			case 3:
				
				obj.deleteAddress();
				
				break;
			case 4:
				
				obj.display();
				break;
			case 5:
				
				obj.sortZIP();
				
				break;
			case 6:
				
				obj.sortName();
				
				break;
			case 7:
				
				s++;
				break;
			default:
				
				s=0;
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input");
		}			
	}
}
