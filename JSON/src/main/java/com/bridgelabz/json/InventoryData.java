package com.bridgelabz.json;

import java.io.*;
import java.lang.reflect.Array;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class InventoryData {
	
	
	public static void main(String[] args) throws IOException, ParseException, JSONException {
		
		JSONObject obj=null;
		JSONParser jsonParser = new JSONParser();
		JSONArray inventory = null;
		try {
		FileReader reader = new FileReader("/home/admin1/Desktop/Inventory.json");
		// Read JSON file
		
		inventory = new JSONArray(jsonParser.parse(reader).toString());
		//Array object storing the text as an array
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
		
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} catch (ParseException e) {
		e.printStackTrace();
		}
  
        
	}

}
