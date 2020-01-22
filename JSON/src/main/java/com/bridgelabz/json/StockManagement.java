package com.bridgelabz.json;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockManagement {

	public static JSONArray readFile(File path) throws JSONException, ParseException, Throwable
	{
		FileReader file=new FileReader(path);
		JSONArray array=new JSONArray();
		JSONParser jparser=new JSONParser();
		array = new JSONArray(jparser.parse(file).toString());
		return array;
	}
	public static void writeFile( File path,JSONArray array) throws IOException
	{
		FileWriter file = new FileWriter(path);
        file.append((array).toString());
        file.close();        
	}	
	public static void customerFile(JSONArray array) throws JSONException
	{
		System.out.print(" Enter the customer name: ");
		String name=utility.Utility.returnString();
		System.out.print(" Desired company:");
		String company=utility.Utility.returnString();
		System.out.print(" Desired number of shares:");
		int shares=utility.Utility.returnInt();
		JSONObject obj=new JSONObject();
		int t=array.length();
		obj.put("Name",name);
		obj.put("Company",company);
		obj.put("Shares",shares);
		array.put(obj);
	}
	public static void initialStockMarket(JSONArray array) throws JSONException
	{
		JSONObject obj=new JSONObject();
		System.out.print(" Enter the Company name: ");
		String name=utility.Utility.returnString();
		obj.put("Company",name);
		System.out.print(" Number of shares:");
		int shareNo=utility.Utility.returnInt();
		obj.put("Shares", shareNo);
		System.out.print(" Price of each share:");
		int price=utility.Utility.returnInt();		
		utility.Utility.returnString();
		obj.put("Price", price);
		array.put(obj);
	}
	public static void adjust(JSONArray array)
	{
		JSONObject obj=null;
		
	}
	public static void display(JSONArray array)
	{
		System.out.println(array);
	}
	public static void main(String[] args) throws Throwable {
		JSONObject obj=null;
		
		
		File path1=new File("/home/admin1/Desktop/StockDetails.json");
		File path2=new File("/home/admin1/Desktop/CustomerDetails.json");
		JSONArray array1=readFile(path1);
		JSONArray array2=readFile(path2);
		//display(array1);
		//writeFile(path1,array1);
		//display(array1);	
		customerFile(array2);
		writeFile(path2,array2);
		display(array2);
	}
}
