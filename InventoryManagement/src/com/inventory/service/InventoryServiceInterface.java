package com.inventory.service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

public interface InventoryServiceInterface {
	public void add() throws JSONException, IOException, ParseException;
	public void delete() throws JSONException, IOException, ParseException;
	public void edit() throws JSONException, IOException, ParseException;
	public void display() throws JSONException, IOException, ParseException;
	public void writeFile(JSONArray inventory) throws IOException;
	
}
