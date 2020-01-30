package com.inventory.service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import com.inventory.repository.Repository;
import com.inventory.utility.Utility;

public class InventoryServiceClass implements InventoryServiceInterface{
	
	public void add() throws JSONException, IOException, ParseException	
	{
											
		JSONArray inventory = Repository.readFile();	
		JSONObject obj=new JSONObject();
		int weight, price;
		String name;
		System.out.print(" Enter a name:");
		name=Utility.returnString();
		obj.put("Name", name);
		System.out.print(" Enter a weight:");
		weight=Utility.returnInt();
		obj.put("Weight", weight);
		System.out.print(" Enter a price:");
		price=Utility.returnInt();					    
	    obj.put("Price", price);
		inventory.put(obj);	    	 	    
	}
	
	public void delete() throws JSONException, IOException, ParseException
	{
		System.out.print("Enter item to delete: ");	
		String name=Utility.returnString();
		JSONArray inventory = Repository.readFile();	
		JSONObject obj=null;
		for(int i=0;i<inventory.length();i++)
		{
			obj=(JSONObject) inventory.get(i);
			if(obj.get("Name").equals(name))
			{
				inventory.remove(i);
			}
		}
	}
		
	public void edit() throws JSONException, IOException, ParseException
	{
		System.out.print("Enter item to edit: ");	
		String name=Utility.returnString();								
		JSONArray inventory = Repository.readFile();	
		JSONObject obj=null;
		for(int i=0;i<inventory.length();i++)
		{
			obj=(JSONObject) inventory.get(i);
			if(obj.get("Name").equals(name))
			{
				int ch;
				System.out.print(" Enter the change for"+name+" (1.weight/2.Price) ");
				ch=Utility.returnInt();
				System.out.print(" Enter the updated value: ");
				if(ch==1)
				{	
					int value=Utility.returnInt();
					obj.remove("Weight");
					obj.put("Weight", value);
				}
				else
				{
					int value=Utility.returnInt();
					obj.put("Price", value);
				}
				
			}
		}
	}
	public void display() throws JSONException, IOException, ParseException
	{
		JSONObject obj=new JSONObject();									
		JSONArray inventory = Repository.readFile();	
		int grandtotal=0;
		for(int i=0;i< inventory.length();i++)// Processing the array
		{
			
			obj=(JSONObject) inventory.get(i);
			System.out.println("_______________________________________");
			System.out.println("|Name: "+obj.get("Name"));
			System.out.println("|Weight: "+obj.get("Weight"));
			System.out.println("|Price: "+obj.get("Price"));
			int weight=obj.getInt("Weight");
			int price=obj.getInt("Price");
			int Total=weight*price;
			System.out.println("|Total Price: " +Total);
			System.out.println("_______________________________________");
			grandtotal+=Total;
		}
		System.out.println("----------------------------------------");
		System.out.println("|Grand Total Price: " +grandtotal);
		System.out.println("----------------------------------------");
	}

	@Override
	public void writeFile(JSONArray inventory) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
