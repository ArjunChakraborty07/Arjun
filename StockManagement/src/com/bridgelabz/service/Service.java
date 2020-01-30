package com.bridgelabz.service;

import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgelabz.repository.Repository;
import com.bridgelabz.utility.Utility;

public class Service implements StockManagement{
	static File path1=new File("/home/admin1/Desktop/StockDetails.json");
	static File path2=new File("/home/admin1/Desktop/CustomerDetails.json");
	
	public void buy() throws JSONException, IOException, ParseException
	{
		JSONArray array1=Repository.readFile(path1);
		JSONArray array2=Repository.readFile(path2);
		
		
		System.out.print(" Enter the customer name: ");
		String name=Utility.returnString();
		System.out.print(" Desired company :");
		String company=Utility.returnString();
		System.out.print(" Desired number of shares:");
		int shares=Utility.returnInt();
		Utility.returnString();
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
		Repository.writeFile(path2,array2);
		Repository.writeFile(path1,array1);
	}
	public void addCompany() throws JSONException, IOException, ParseException
	{
		JSONArray array1=Repository.readFile(path1);
		
		JSONObject obj=new JSONObject();
		System.out.print(" Enter the Company name: ");
		String name=Utility.returnString();
		obj.put("Company",name);
		System.out.print(" Number of shares:");
		int shareNo=Utility.returnInt();
		obj.put("Shares", shareNo);
		System.out.print(" Price of each share:");
		int price=Utility.returnInt();		
		Utility.returnString();
		obj.put("Price", price);
		array1.put(obj);
		Repository.writeFile(path1,array1);
	}
	public void sell() throws JSONException, IOException, ParseException
	{
		JSONArray array1=Repository.readFile(path1);
		JSONArray array2=Repository.readFile(path2);
		
		System.out.print("Enter Customer Name: ");
		String name=Utility.returnString();
		System.out.print("Enter Company: ");
		String company=Utility.returnString();
		System.out.print("Number of shares want to sell: ");
		int shares=Utility.returnInt();
		
		
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
		Repository.writeFile(path2,array2);
		Repository.writeFile(path1,array1);
		}
	}
	public void display() throws JSONException, IOException, ParseException
	{
		JSONArray array=new JSONArray();
		System.out.println("1.Companies");
		System.out.println("2.Customers");
		int ch=Utility.returnInt();
		if(ch==1)
			array=Repository.readFile(path1);
		else
			array=Repository.readFile(path2);
		int i=0;
		if(array.length()==0)
		{
			System.out.println("Empty File");
		}
		while(i!=array.length())
		{
			if(ch==1)
			{
				JSONObject obj=(JSONObject) array.get(i);
				System.out.println("__________________________________________");
				System.out.println("|Company: "+obj.get("Company"));
				System.out.println("|Remaining Shares: "+obj.get("Shares"));
				System.out.println("|Price Per Share: "+obj.get("Price"));
				System.out.println("__________________________________________");
				i++;
			}
			else
			{
				JSONObject obj=(JSONObject) array.get(i);
				System.out.println("__________________________________________");
				System.out.println("|Name: "+obj.get("Name"));
				System.out.println("|Company: "+obj.get("Company"));
				System.out.println("|Share: "+obj.get("Shares"));
				System.out.println("__________________________________________");
				i++;
			}
		}	
	}
	public int totalValueOf() throws JSONException, IOException, ParseException
	{
		JSONArray array2=Repository.readFile(path1);
		
		int total=0;
		for(int i=0;i<array2.length();i++)
		{
			JSONObject obj=(JSONObject) array2.getJSONObject(i);
			total=obj.getInt("Shares")*obj.getInt("Price");
		}
		System.out.println("__________________________________________");
		System.out.println("Net worth of the unsold market");
		return total;
	}
	public int valueOf() throws JSONException, IOException, ParseException
	{
		JSONArray array1=Repository.readFile(path1);
		JSONArray array2=Repository.readFile(path2);
		
		System.out.print("Enter Customer Name: ");
		String name=Utility.returnString();
		int value=0;
		int sum=0;
		for(int i=0;i<array2.length();i++)
		{
			JSONObject obj=(JSONObject) array2.getJSONObject(i);
			if(obj.get("Name").equals(name))
			{
				for(int j=0;j<array1.length();j++)
				{
					JSONObject obj1=(JSONObject) array1.getJSONObject(j);
					
					if(obj.get("Company").equals(obj1.get("Company")))
					{
						value=obj1.getInt("Price");
					}
				}
				value=value*obj.getInt("Shares");
			}
			sum=sum+value;
		}
		System.out.println("__________________________________________");
		System.out.println("Value possesed by "+name);
		return sum;
	}
}
