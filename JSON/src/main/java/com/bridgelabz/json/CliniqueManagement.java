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
	static File pathDoctor = new File("/home/admin1/Desktop/DoctorFile.json");
	static File pathPatient = new File("/home/admin1/Desktop/PatientFile.json");
	static File pathAppointment = new File("/home/admin1/Desktop/AppointmentFile.json");

	public static void doctorFile(JSONArray array) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("Name", "Dr.Arjun Chakraborty");
		obj.put("Department", "Cardiologist");
		obj.put("Availability", "AM and PM");
		array.put(obj);
		obj = new JSONObject();
		obj.put("Name", "Dr.Manu Saini");
		obj.put("Department", "Neurology");
		obj.put("Availability", "PM");
		array.put(obj);
		obj = new JSONObject();
		obj.put("Name", "Dr.Vipin Sharma");
		obj.put("Department", "General Physician");
		obj.put("Availability", "PM");
		array.put(obj);
	}

	public static void patientFile(JSONArray array) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("Name", "Mark Ambi");
		obj.put("Department", "Cardiologist");
		obj.put("Case", "COPD");
		array.put(obj);
		obj = new JSONObject();
		obj.put("Name", "Arijit Chakraborty");
		obj.put("Department", "Neurology");
		obj.put("Case", "Migrane");
		array.put(obj);
		obj = new JSONObject();
		obj.put("Name", "Govind Patel");
		obj.put("Department", "General Physician");
		obj.put("Case", "Monthly Checkup");
		array.put(obj);
		obj = new JSONObject();
		obj.put("Name", "Aditya Desai");
		obj.put("Department", "General Physician");
		obj.put("Case", "Black fever");
		array.put(obj);
		obj = new JSONObject();
		obj.put("Name", "Rounak Mukherjee");
		obj.put("Department", "Cardiologist");
		obj.put("Case", "Cholesterol");
		array.put(obj);
		obj = new JSONObject();
		obj.put("Name", "Rahul Singh");
		obj.put("Department", "General Physician");
		obj.put("Case", "Back pain");
		array.put(obj);
	}

	public static void appointment(JSONArray array) throws JSONException, IOException, ParseException {
		JSONArray readPatient = readFile(pathPatient);
		JSONArray readDoctor = readFile(pathDoctor);
		for (int i = 0; i < readPatient.length(); i++) {

			JSONObject patients = (JSONObject) readPatient.get(i);
			String departmentpatient = patients.getString("Department");
			for (int k = 0; k < readDoctor.length(); k++) {

				
				JSONObject doctors = (JSONObject) readDoctor.get(k);
				String departmentdoctor = doctors.getString("Department");
				if (departmentdoctor.equals(departmentpatient)) {
					JSONObject obj = new JSONObject();					
					obj.accumulate("Names", doctors.getString("Name"));					
					obj.accumulate("Names", patients.get("Name"));					
					array.put(obj);
				}
			}
		}

	}

	public static Object popularity() throws JSONException, IOException, ParseException
	{
		
		JSONArray array=readFile(pathAppointment);
		JSONObject obj1=new JSONObject();
		JSONObject obj2=new JSONObject();
		int arr[]=new int [array.length()];
		for(int i=0;i<array.length();i++)
		{
			int ctr=0;
			obj1=(JSONObject) array.get(i);
			JSONArray dr=(JSONArray) obj1.get("Names");
			for( int j=0;j<array.length();j++)
			{
				obj2=(JSONObject) array.get(j);
				JSONArray pt=obj2.getJSONArray("Names");
				if(dr.get(0).equals(pt.get(0)))
				{
					ctr++;
				}
			}
			arr[i]=ctr;
		}
		int max=arr[0];
		int index=0;
		for(int i=0;i<array.length();i++)
		{	
			if(arr[i]>max)
				index=i;				
		}
		obj1=(JSONObject) array.get(index);
		JSONArray arrpopularity=(JSONArray) obj1.get("Names");
		
		return arrpopularity.get(0);	
						
	}
	public static void writeFile(File path, JSONArray array) throws IOException {
		FileWriter file = new FileWriter(path);
		file.append(array.toString());
		file.close();
	}

	public static JSONArray readFile(File path) throws JSONException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(path);
		JSONArray doctorfile = new JSONArray(jsonParser.parse(reader).toString());
		return doctorfile;
	}

	public static void main(String args[]) throws JSONException, IOException, ParseException {
		JSONArray arrayDoctor = new JSONArray();
		doctorFile(arrayDoctor);
		writeFile(pathDoctor, arrayDoctor);
		JSONArray arrayPatient = new JSONArray();
		patientFile(arrayPatient);
		writeFile(pathPatient, arrayPatient);
		JSONArray arrayAppointment = new JSONArray();
		appointment(arrayAppointment);
		writeFile(pathAppointment, arrayAppointment);
		System.out.println(arrayAppointment);
		System.out.println(popularity());
	}
}
