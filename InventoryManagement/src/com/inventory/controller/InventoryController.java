package com.inventory.controller;

import java.io.IOException;


import org.json.JSONException;

import org.json.simple.parser.ParseException;

import com.inventory.service.InventoryServiceClass;
import com.inventory.utility.Utility;

public class InventoryController {
	public static void main(String[] args) throws JSONException, IOException, ParseException {
		
		InventoryServiceClass obj= new InventoryServiceClass();
		int ctr=0;
		while(ctr==0)
		{
			
			
			System.out.println("_______________");
			System.out.println("|1.Add Item   |");
			System.out.println("|2.Edit Item  |");
			System.out.println("|3.Remove Item|");
			System.out.println("|4.Display    |");
			System.out.println("---------------");
			int ch=Utility.returnInt();
			switch(ch)
			{
				case 1:
					obj.add();
				case 2:
					obj.edit();
				case 3:
					obj.delete();
				case 4:
					obj.display();	
				default:
					ctr++;
			}
				
		}
	}

}
