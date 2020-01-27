package com.bridgelabz.json;

import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class AddressBook {

	static File path= new File("/home/admin1/Desktop/AddressBook.json"); 	
	public static void addAddress(String fname, String lname, String address, String city, String state, int zip, String phone) throws JSONException, IOException, ParseException
	{
		JSONArray array=utility.Utility.readFile(path);
		JSONObject obj=new JSONObject();
		obj.put("First Name", fname);
		obj.put("Last Name", lname);
		obj.put("Address", address);
		obj.put("City", city);
		obj.put("State", state);
		obj.put("ZIP code", zip);
		obj.put("Phone No", phone);
		array.put(obj);
		utility.Utility.writeFile(path, array);
	}
	public static void editAddress(String fname) throws JSONException, IOException, ParseException  //, String address, String city, String state, int zip, String phone
	{
		JSONArray array=utility.Utility.readFile(path);
		JSONObject obj=new JSONObject();
		for(int i=0;i<array.length();i++)
		{
			obj= (JSONObject) array.get(i);
			if(obj.get("First Name").equals(fname))
			{
				System.out.print("Enter the element to edit:");
				String key=utility.Utility.returnString();
				obj.remove(key);
				System.out.print("Enter the updated element:");
				String add=utility.Utility.returnString();
				obj.put(key,add);
				/*obj.put("Address", address);
				obj.put("City", city);
				obj.put("State", state);
				obj.put("ZIP code", zip);
				obj.put("Phone No", phone);*/
				array.put(obj);
			}
			else
			{
				System.out.println("Name Not Found");
			}
		}
		utility.Utility.writeFile(path, array);
	}
	public static void deleteAddress(String fname) throws JSONException, IOException, ParseException
	{
		JSONArray array=utility.Utility.readFile(path);
		JSONObject obj=new JSONObject();
		for(int i=0;i<array.length();i++)
		{
			obj= (JSONObject) array.get(i);
			if(obj.get("First Name").equals(fname))
			{
				array.remove(i);
			}
		}
		utility.Utility.writeFile(path, array);
	}
	public static void sortZIP() throws JSONException, IOException, ParseException
	{
		JSONArray array=utility.Utility.readFile(path);
		JSONObject obj=new JSONObject();
		for(int i=0;i<array.length();i++)
		{
			obj= (JSONObject) array.get(i);
			int zip=(int) obj.get("ZIP");
		}
		utility.Utility.writeFile(path, array);
	}
	public static void display() throws JSONException, IOException, ParseException
	{
		JSONArray array=utility.Utility.readFile(path);
		System.out.println(array);
	}
	public static void main(String args[]) throws IOException, JSONException, ParseException
	{
		JSONArray array=new JSONArray();
		//utility.Utility.writeFile(path, array);
		array=utility.Utility.readFile(path);
		int s=0;
		while(s==0)
		{
			System.out.print("1. Add address 2. Edit Address 3. Delete Address 4. Display"
					+ "\nEnter a choice of operation:");
			int ch=utility.Utility.returnInt();
			utility.Utility.returnString();
			switch(ch)		
			{
			case 1:
				System.out.print(" Enter the First Name: ");
				String fname=utility.Utility.returnString();
				System.out.print(" Enter the Last Name: ");
				String lname=utility.Utility.returnString();
				System.out.print(" Enter Address: ");
				String address=utility.Utility.returnString();
				System.out.print(" Enter City: ");
				String city=utility.Utility.returnString();
				System.out.print(" Enter State: ");
				String state=utility.Utility.returnString();
				System.out.print(" Enter ZIP: ");
				int zip=utility.Utility.returnInt();
				utility.Utility.returnString();
				System.out.print(" Enter Phone Number: ");
				String phone=utility.Utility.returnString();
				addAddress(fname, lname, address, city, state, zip, phone);
				display();
				break;
			case 2:
				System.out.print(" Enter the First Name: ");
				fname=utility.Utility.returnString();
				//System.out.print(" Enter Address: ");
				//address=utility.Utility.returnString();
				//System.out.print(" Enter City: ");
				//city=utility.Utility.returnString();
				//System.out.print(" Enter State: ");
				//state=utility.Utility.returnString();
				//System.out.print(" Enter ZIP: ");
				//zip=utility.Utility.returnInt();
				//utility.Utility.returnString();
				//System.out.print(" Enter Phone Number: ");
				//phone=utility.Utility.returnString();
				editAddress(fname);
				display();
				break;
			case 3:
				System.out.print(" Enter the First Name: ");
				fname=utility.Utility.returnString();
				deleteAddress(fname);
				display();
				break;
			case 4:
				display();
				break;
			default:
				s++;
			}
		}
	}
}
