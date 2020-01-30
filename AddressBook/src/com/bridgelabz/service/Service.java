package com.bridgelabz.service;

import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import com.addressbook.utility.Utility;
import com.bridgelabz.repository.Repository;

public class Service implements AddressBook{
	static File path = new File("/home/admin1/Desktop/AddressBook.json");
	
	@Override
	public void addAddress() throws JSONException, IOException, ParseException {
		try {
		
		
		
		JSONArray array = Repository.readFile(path);
		JSONObject obj = new JSONObject();
		
		System.out.print(" Enter the First Name: ");
		String fname = Utility.returnString();
		System.out.print(" Enter the Last Name: ");
		String lname = Utility.returnString();
		System.out.print(" Enter Address: ");
		String address = Utility.returnString();
		System.out.print(" Enter City: ");
		String city = Utility.returnString();
		System.out.print(" Enter State: ");
		String state =Utility.returnString();
		System.out.print(" Enter ZIP: ");
		int zip = Utility.returnInt();
		Utility.returnString();
		System.out.print(" Enter Phone Number: ");
		String phone = Utility.returnString();
		
		
		obj.put("First Name", fname);
		obj.put("Last Name", lname);
		obj.put("Address", address);
		obj.put("City", city);
		obj.put("State", state);
		obj.put("ZIP code", zip);
		obj.put("Phone No", phone);
		array.put(obj);
		Repository.writeFile(path, array);
	
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input");
		}
	}

	@Override
	public void editAddress() throws JSONException, IOException, ParseException  {
		
		try {
		int ctr = 0;
		
		System.out.print(" Enter the First Name: ");
		String fname = Utility.returnString();
		
		
		JSONArray array = Repository.readFile(path);
		JSONObject obj = new JSONObject();

		for (int i = 0; i < array.length(); i++) {
			obj = (JSONObject) array.get(i);
			if (obj.get("First Name").equals(fname)) {
				System.out.print(" Enter the element to edit:");
				String key = Utility.returnString();
				if(key.equals("First Name")||(key.equals("Last Name")))
				{
					System.out.println("Name cannot be edited");
				}
				else
				{
					obj.remove(key);
					System.out.print(" Enter the updated element:");
					String add = Utility.returnString();
					obj.put(key, add);
				}

			} else {
				ctr++;
			}

		}
		if (ctr == array.length()) {
			System.out.println("Name Not Found");
		}
		Repository.writeFile(path, array);
	}
	catch(Exception e)
	{
		System.out.println("Invalid Input");
	}
		}
		

	@Override
	public void deleteAddress() throws Exception {
		try {
		System.out.print(" Enter the First Name: ");
		String fname = Utility.returnString();
		
		
		JSONArray array =Repository.readFile(path);
		JSONObject obj = new JSONObject();
		for (int i = 0; i < array.length(); i++) {
			obj = (JSONObject) array.get(i);
			if (obj.get("First Name").equals(fname)) {
				array.remove(i);
			}
		}
		Repository.writeFile(path, array);
	}
	catch(Exception e)
	{
		System.out.println("Invalid Input");
	}
	}

	@Override
	public void sortZIP() throws IOException, JSONException, ParseException {
		
		try {
		JSONArray array = Repository.readFile(path);
		JSONArray sortedarray = new JSONArray();
		JSONObject obj = new JSONObject();
		int zip[] = new int[array.length()];
		for (int i = 0; i < array.length(); i++) {
			obj = (JSONObject) array.get(i);
			zip[i] = obj.getInt("ZIP code");

		}
		Utility.insertion(zip);
		obj = new JSONObject();
		for (int i = 0; i < array.length(); i++) {
			for (int j = 0; j < array.length(); j++) {
				obj = (JSONObject) array.get(j);
				if (zip[i] == obj.getInt("ZIP code")) {
					sortedarray.put(obj);
				}
			}
		}
		Repository.writeFile(path, sortedarray);
	}
	catch(Exception e)
	{
		System.out.println("Invalid Input");
	}
	}

	@Override
	public void sortName() throws JSONException, IOException, ParseException {
		
		try {
		
		JSONArray array = Repository.readFile(path);
		JSONArray sortedarray = new JSONArray();
		JSONObject obj = new JSONObject();
		String zip[] = new String[array.length()];
		for (int i = 0; i < array.length(); i++) {
			obj = (JSONObject) array.get(i);
			zip[i] = obj.getString("Last Name");

		}
		Utility.insertionSort(zip);
		obj = new JSONObject();
		for (int i = 0; i < array.length(); i++) {
			for (int j = 0; j < array.length(); j++) {
				obj = (JSONObject) array.get(j);
				if (zip[i].equals(obj.getString("Last Name"))) {
					sortedarray.put(obj);
				}
			}

		}
		Repository.writeFile(path, sortedarray);
	}
	catch(Exception e)
	{
		System.out.println("Invalid Input");
	}
	}

	@Override
	public void display() throws JSONException, IOException, ParseException {
		
		try {
		JSONArray array = Repository.readFile(path);
		JSONObject obj=new JSONObject();
		for(int i=0;i<array.length();i++)
		{
			obj=(JSONObject) array.get(i);
			System.out.println("________________________________________________");
			System.out.println("|Name: "+obj.getString("First Name")+" "+obj.getString("Last Name"));
			System.out.println("|Address: "+obj.getString("Address"));
			System.out.println("|City: "+obj.getString("City"));
			System.out.println("|State: "+obj.getString("State"));
			System.out.println("|ZIP Code: "+obj.getInt("ZIP code"));
			System.out.println("|Phone Number: "+obj.getString("Phone No"));
			System.out.println("________________________________________________");
		}
	}
	catch(Exception e)
	{
		System.out.println("Invalid Input");
	}
	}
	
}
