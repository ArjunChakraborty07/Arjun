
package com.bridgelabz.service;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

public interface StockManagement {
	public void buy() throws JSONException, IOException, ParseException;
	public void addCompany() throws JSONException, IOException, ParseException;
	public void sell() throws JSONException, IOException, ParseException;
	public void display() throws JSONException, IOException, ParseException;
	public int totalValueOf() throws JSONException, IOException, ParseException;
	public int valueOf() throws JSONException, IOException, ParseException;
}
