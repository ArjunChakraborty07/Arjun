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
	public void addAddress(String fname, String lname, String address, String city, String state, int zip,
			String phone) throws JSONException, IOException, ParseException {
		JSONArray array = Repository.readFile(path);
		JSONObject obj = new JSONObject();
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

	@Override
	public void editAddress(String fname) throws JSONException, IOException, ParseException {
		int ctr = 0;
		JSONArray array = Repository.readFile(path);
		JSONObject obj = new JSONObject();

		for (int i = 0; i < array.length(); i++) {
			obj = (JSONObject) array.get(i);
			if (obj.get("First Name").equals(fname)) {
				System.out.print("Enter the element to edit:");
				String key = Utility.returnString();
				obj.remove(key);
				System.out.print("Enter the updated element:");
				String add = Utility.returnString();
				obj.put(key, add);

			} else {
				ctr++;
			}

		}
		if (ctr == array.length()) {
			System.out.println("Name Not Found");
		}
		Repository.writeFile(path, array);

		
	}

	@Override
	public void deleteAddress(String fname) throws Exception {
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

	@Override
	public void sortZIP() throws IOException, JSONException, ParseException {
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

	@Override
	public void sortName() throws JSONException, IOException, ParseException {
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

	@Override
	public void display() throws JSONException, IOException, ParseException {
		JSONArray array = Repository.readFile(path);
		System.out.println(array);
		
	}

}
