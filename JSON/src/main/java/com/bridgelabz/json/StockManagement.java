package com.bridgelabz.json;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StockManagement {
	static File path1=new File("/home/admin1/Desktop/StockDetails.json");
	static File path2=new File("/home/admin1/Desktop/CustomerDetails.json");

	
	public static void add(JSONArray array1,JSONArray array2) throws JSONException, IOException
	{
		System.out.print(" Enter the customer name: ");
		String name=utility.Utility.returnString();
		System.out.print(" Desired company :");
		String company=utility.Utility.returnString();
		System.out.print(" Desired number of shares:");
		int shares=utility.Utility.returnInt();
		utility.Utility.returnString();
		JSONObject obj=new JSONObject();
		int ctr=0;
		for(int i=0;i<array2.length();i++)
		{
			obj=(JSONObject) array2.getJSONObject(i);
			if(obj.get("Name").equals(name))
			{
				ctr++;
				if(obj.get("Company").equals(company))
				{
					int bal=0;
					bal=obj.getInt("Shares")+shares;
					obj.remove("Shares");
					obj.put("Shares",bal);
				}
				else
				{
					obj=new JSONObject();
					obj.put("Company", company);
					obj.put("Shares", shares);
				}
			}
		}
		if(ctr==0)
		{
			obj=new JSONObject();
			obj.put("Name",name);
			obj.put("Company",company);
			obj.put("Shares",shares);
			array2.put(obj);
		}
		
		if(array2.length()==0)
		{
			obj.put("Name",name);
			obj.put("Company",company);
			obj.put("Shares",shares);
			array2.put(obj);
		}
		for(int i=0;i<array1.length();i++)
		{
			obj=(JSONObject) array1.getJSONObject(i);
			if(obj.get("Company").equals(company))
			{
				if(obj.getInt("Shares")-shares>=0)
				{
					int bal=obj.getInt("Shares")-shares;
					obj.remove("Shares");
					obj.put("Shares",bal);
				}
				else			
					System.out.print(" Insufficient shares");				
			}
		}
		utility.Utility.writeFile(path2,array2);
		utility.Utility.writeFile(path1,array1);
	}
	public static void initialStockMarket(JSONArray array1) throws JSONException, IOException
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
		array1.put(obj);
		utility.Utility.writeFile(path1,array1);
	}
	public static void sell(JSONArray array1,JSONArray array2, String name,String company, int shares) throws JSONException, IOException
	{
		JSONObject obj=null;	
		int ctr=0;
		for(int i=0;i<array2.length();i++)
		{
			obj=(JSONObject) array2.get(i);
			if(obj.get("Name").equals(name)&&obj.get("Company").equals(company))
			{
				ctr++;
				{
					if(obj.getInt("Shares")-shares>=0)
					{
						int bal=obj.getInt("Shares")-shares;
						obj.remove("Shares");
						obj.put("Shares",bal);
					}
					else	
					{
						System.out.print(" Insufficient shares");
						ctr=0;
					}
				}
			}			
		}	
		if(ctr==0)
		{
			System.out.println("Customer/Company Not Found");
		}
		if(ctr!=0)
		{
		for(int i=0;i<array1.length();i++)
		{
			obj=(JSONObject) array1.getJSONObject(i);
			if(obj.get("Company").equals(company))
			{
				int bal=obj.getInt("Shares")+shares;
				obj.remove("Shares");
				obj.put("Shares",bal);
			}
		}
		utility.Utility.writeFile(path2,array2);
		utility.Utility.writeFile(path1,array1);
		}
	}
	public static void display(JSONArray array) throws JSONException
	{
		int i=0;
		if(array.length()==0)
		{
			System.out.println("Empty File");
		}
		while(i!=array.length())
		{
			System.out.println(array.get(i));
			i++;
		}	
	}
	public static int totalValueOf(JSONArray array) throws JSONException
	{
		int total=0;
		for(int i=0;i<array.length();i++)
		{
			JSONObject obj=(JSONObject) array.getJSONObject(i);
			total=obj.getInt("Shares")*obj.getInt("Price");
		}
		return total;
	}
	public static int valueOf(JSONArray array1, JSONArray array2, String name) throws JSONException
	{
		int value=0;
		for(int i=0;i<array2.length();i++)
		{
			JSONObject obj=(JSONObject) array2.getJSONObject(i);
			if(obj.get("Name").equals(name))
			{
				for(int j=0;j<array1.length();j++)
				{
					JSONObject obj1=(JSONObject) array1.getJSONObject(i);
					
					if(obj.get("Company").equals(obj1.get("Company")))
					{
						value=obj1.getInt("Price");
					}
				}
				value=value*obj.getInt("Shares");
			}
		}
		return value;
	}
	public static void main(String[] args) throws Throwable {
		
		
		JSONArray array1=utility.Utility.readFile(path1);
		JSONArray array2=utility.Utility.readFile(path2);
		
		//display(array1);
		//display(array2);
		
		//sell(array1,array2,"Kote","Microsoft",2);
		 
		//System.out.println(" After sale of Kote, Amazon, 2");
		//display(array2);
		//display(array1);
		int total=totalValueOf(array1);
		System.out.println(total);
		int value=valueOf(array1,array2,"Arjun");
		System.out.println(value);
	}
}
