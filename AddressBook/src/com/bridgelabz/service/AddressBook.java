package com.bridgelabz.service;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

public interface AddressBook {
	public void addAddress() throws JSONException, IOException, ParseException;
	public void editAddress() throws JSONException, IOException, ParseException;
	public void deleteAddress() throws Exception;
	public void sortZIP() throws IOException, JSONException, ParseException;
	public void sortName() throws JSONException, IOException, ParseException;
	public void display() throws JSONException, IOException, ParseException;
}
