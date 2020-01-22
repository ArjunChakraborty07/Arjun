package com.bridgelabz.json;

import java.io.*;
import java.lang.reflect.Array;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class InventoryData {
	
	public static JSONArray readFile() throws JSONException, IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		JSONArray inventory=new JSONArray();
		FileReader reader = new FileReader("/home/admin1/Desktop/Inventory.json");
		inventory = new JSONArray(jsonParser.parse(reader).toString());
		return inventory;
	}
	
	public static void add(JSONArray inventory) throws JSONException	
	{
		JSONObject obj=new JSONObject();
		int weight, price;
		String name;
		System.out.println(" Enter a name:");
		name=utility.Utility.returnString();
		obj.put("Name", name);
		System.out.println(" Enter a weight:");
		weight=utility.Utility.returnInt();
		obj.put("Weight", weight);
		System.out.println(" Enter a price:");
		price=utility.Utility.returnInt();					    
	    obj.put("Price", price);
		inventory.put(obj);	    	 	    
	}
	
	public static void delete(String name, JSONArray inventory) throws JSONException
	{
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
		
	public static void edit(String name, JSONArray inventory) throws JSONException
	{
		JSONObject obj=null;
		for(int i=0;i<inventory.length();i++)
		{
			obj=(JSONObject) inventory.get(i);
			if(obj.get("Name").equals(name))
			{
				int ch;
				System.out.print(" Enter the change for"+name+" (1.weight/2.Price) ");
				ch=utility.Utility.returnInt();
				System.out.print(" Enter the updated value: ");
				if(ch==1)
				{	
					int value=utility.Utility.returnInt();
					obj.remove("Weight");
					obj.put("Weight", value);
				}
				else
				{
					int value=utility.Utility.returnInt();
					obj.put("Price", value);
				}
				
			}
		}
	}
	public static void display(JSONObject obj, JSONArray inventory) throws JSONException
	{
		int grandtotal=0;
		for(int i=0;i< inventory.length();i++)// Processing the array
		{
			System.out.println(inventory.get(i));
			obj=(JSONObject) inventory.get(i);
			int weight=obj.getInt("Weight");
			int price=obj.getInt("Price");
			int Total=weight*price;
			System.out.println("Total Price: " +Total);
			grandtotal+=Total;
		}
		System.out.println("Grand Total Price: " +grandtotal);
	}
		
	public static void writeFile(JSONArray inventory) throws IOException
	{
		FileWriter file = new FileWriter("/home/admin1/Desktop/Inventory.json");
        file.append((inventory).toString());
        file.close();        
	}	
	
	public static void main(String[] args) throws JSONException, IOException, ParseException {
		
		JSONObject obj=null;									
		JSONArray inventory = readFile();					
		//add( inventory);			
		//writeFile(inventory);  
		display(obj,inventory);	
		add( inventory);			
		//delete("s",inventory);
		//delete("q",inventory);
		//edit("Rice", inventory);
		writeFile(inventory); 
		display(obj,inventory);	
	}

}
