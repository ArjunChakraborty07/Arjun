package com.bridgelabz.service;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

public interface AddressBook {
	public void addAddress(String fname, String lname, String address, String city, String state, int zip,
			String phone) throws JSONException, IOException, ParseException;
	public void editAddress(String fname) throws JSONException, IOException, ParseException;
	public void deleteAddress(String fname) throws Exception;
	public void sortZIP() throws IOException, JSONException, ParseException;
	public void sortName() throws JSONException, IOException, ParseException;
	public void display() throws JSONException, IOException, ParseException;
}
