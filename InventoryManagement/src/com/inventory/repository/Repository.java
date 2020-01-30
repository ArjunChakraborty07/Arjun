package com.inventory.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Repository {
	public static void writeFile(JSONArray inventory) throws IOException
	{
		FileWriter file = new FileWriter("/home/admin1/Desktop/Inventory.json");
        file.append((inventory).toString());
        file.close();        
	}	
	public static JSONArray readFile() throws JSONException, IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		JSONArray inventory=new JSONArray();
		FileReader reader = new FileReader("/home/admin1/Desktop/Inventory.json");
		inventory = new JSONArray(jsonParser.parse(reader).toString());
		return inventory;
	}
}
