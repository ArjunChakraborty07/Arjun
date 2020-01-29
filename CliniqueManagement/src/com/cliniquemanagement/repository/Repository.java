package com.cliniquemanagement.repository;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Repository {
	public static void writeFile(File path, JSONArray array) throws IOException {
		FileWriter file = new FileWriter(path);
		file.append(array.toString());
		file.close();
	}

	public static JSONArray readFile(File path) throws JSONException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(path);
		JSONArray array = new JSONArray(jsonParser.parse(reader).toString());
		return array;
	}
}
