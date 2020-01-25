package com.bridgelabz.json;

import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class AddressBook {

	static File path= new File("/home/admin1/Desktop/AddressBook.json"); 
	
	public static void addAddress(String fname, String lname, String address, String city, String state, int zip, int phone) throws JSONException, IOException, ParseException
	{
		JSONArray array=utility.Utility.readFile(path);
		JSONObject obj=new JSONObject();
		obj.put("First Name",fname);
		obj.put("Last Name",lname);
		obj.put("Address", address);
		obj.put("City", city);
		obj.put("State", state);
		obj.put("ZIP code", zip);
		obj.put("Phone No", phone);
	}
	
}
