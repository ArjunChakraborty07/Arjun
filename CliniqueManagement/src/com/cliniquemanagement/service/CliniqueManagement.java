package com.cliniquemanagement.service;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

public interface CliniqueManagement {
	
	public void doctorFile() throws JSONException, IOException, ParseException;
	public void showDoctor() throws JSONException, IOException, ParseException;
	public void patientFile() throws JSONException, IOException, ParseException;
	public void showPatient() throws JSONException, IOException, ParseException;
	public void appointment() throws JSONException, IOException, ParseException;
	public void showAppointment() throws JSONException, IOException, ParseException;
	public Object popularity() throws JSONException, IOException, ParseException;
	
}
