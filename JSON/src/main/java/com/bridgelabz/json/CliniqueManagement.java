package com.bridgelabz.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CliniqueManagement {
	static File pathDoctor=new File("/home/admin1/Desktop/DoctorFile.json");
	static File pathPatient=new File("/home/admin1/Desktop/PatientFile.json");
	static File pathAppointment= new File("/home/admin1/Desktop/AppointmentFile.json");
	public static void doctorFile(JSONArray array) throws JSONException
	{
		JSONObject obj=new JSONObject();
		obj.put("Name","Dr.Arjun Chakraborty");
		obj.put("Department","Cardiologist");
		obj.put("Availability","AM and PM");
		array.put(obj);
	}
	public static void patientFile(JSONArray array) throws JSONException
	{
		JSONObject obj=new JSONObject();
		obj.put("Name", "Mark Ambi");
		obj.put("Department", "Cardiologist");
		obj.put("Case","COPD");
		array.put(obj);
	}
	public static void appointment(JSONArray array) throws JSONException
	{
		JSONObject rootObject = new JSONObject();
		JSONArray arr=new JSONArray();
		JSONObject obj=new JSONObject();
		obj.put("Name", "Mark Ambi");
		obj.put("Department", "Cardiologist");
		obj.put("Case","COPD");
		array.put(obj);
		JSONObject ob1=new JSONObject();
		
		ob1.put("Dr.Arjun Chakraborty",array);
		
		
		arr.put(ob1);
		rootObject.put("doctors", array);
	}
	public static void writeFile(File path,JSONArray array) throws IOException
	{
		FileWriter file=new FileWriter(path);
		file.append(array.toString());
		file.close();
	}
	public static JSONArray readFile(File path) throws JSONException, IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		JSONArray doctorfile=new JSONArray();
		FileReader reader = new FileReader(path);
		doctorfile = new JSONArray(jsonParser.parse(reader).toString());
		return doctorfile;
	}
	public static void main(String args[]) throws JSONException, IOException, ParseException
	{
		JSONArray arrayDoctor=new JSONArray();
		doctorFile(arrayDoctor);
		writeFile(pathDoctor,arrayDoctor);
		JSONArray arrayPatient=new JSONArray();
		patientFile(arrayPatient);
		writeFile(pathPatient,arrayPatient);
		JSONArray arrayAppointment=new JSONArray();
		appointment(arrayAppointment);
		writeFile(pathAppointment,arrayAppointment);
	}
}
