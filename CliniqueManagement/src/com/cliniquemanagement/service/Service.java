package com.cliniquemanagement.service;

import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import com.cliniquemanagement.repository.Repository;
import com.cliniquemanagement.utility.Utility;

public class Service implements CliniqueManagement{


	static File pathDoctor = new File("/home/admin1/Desktop/DoctorFile.json");
	static File pathPatient = new File("/home/admin1/Desktop/PatientFile.json");
	static File pathAppointment = new File("/home/admin1/Desktop/AppointmentFile.json");
	static int ctr=0;
	 

	public void doctorFile() throws JSONException, IOException, ParseException {
		
		JSONArray array =Repository.readFile(pathDoctor);
		JSONObject object=new JSONObject();
		System.out.println("Enter Name:");
		String name=Utility.returnString();
		System.out.println("Enter Department:");
		String dept=Utility.returnString();
		System.out.println("Enter Availability:");
		String avail=Utility.returnString();
		
		
		object.put("Name", name);
		object.put("Department", dept);
		object.put("Availability", avail);
		array.put(object);
		
		Repository.writeFile(pathDoctor, array);
		
	}

	public void showDoctor() throws JSONException, IOException, ParseException
	{
		JSONArray array =Repository.readFile(pathDoctor);
		if(array.length()==0)
		{
			System.out.println(" No appointment to show");
		}
		else
		{
			JSONObject obj = new JSONObject();
			for(int i=0;i<array.length();i++)
			{
				obj=array.getJSONObject(i);
				System.out.println("Name: "+obj.get("Name"));
				System.out.println("Department: "+obj.get("Department"));
				System.out.println("Availability: "+obj.get("Availability"));
				System.out.println();
			}
		}
		
	}
	
	
	
	public void patientFile() throws JSONException, IOException, ParseException {
		
		JSONArray array =Repository.readFile(pathPatient);
		JSONObject object=new JSONObject();
		System.out.println("Enter Name:");
		String name=Utility.returnString();
		System.out.println("Enter Department:");
		String dept=Utility.returnString();
		System.out.println("Enter Case:");
		String cas=Utility.returnString();
		
		
		for(int i=0;i<array.length();i++)
		{
			JSONObject ob=array.getJSONObject(i);
			if(ob.get("Department").equals(dept))
				ctr++;		
		}
		if(ctr>4)
		{
			System.out.println("Doctor is too busy for the day");
							
		}
		else
		{
			System.out.println(ctr);
			object.put("Name", name);
			object.put("Department", dept);
			object.put("Case", cas);
			array.put(object);
			Repository.writeFile(pathPatient, array);
			System.out.println(" Patient added successfully");
		}				
	}

	public void showPatient() throws JSONException, IOException, ParseException
	{
		JSONArray array =Repository.readFile(pathPatient);
		if(array.length()==0)
		{
			System.out.println(" No patients to show");
		}
		else
		{
			JSONObject obj = new JSONObject();
			for(int i=0;i<array.length();i++)
			{
				obj=array.getJSONObject(i);
				System.out.println("Name: "+obj.get("Name"));
				System.out.println("Department: "+obj.get("Department"));
				System.out.println("Case: "+obj.get("Case"));
				System.out.println();
			}
		}
	}
	public void appointment() throws JSONException, IOException, ParseException {
		
		JSONArray array = Repository.readFile(pathAppointment);
		
		JSONArray readPatient = Repository.readFile(pathPatient);
		JSONArray readDoctor = Repository.readFile(pathDoctor);
		
		array=new JSONArray();
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
					break;
				}
			}
		}
		Repository.writeFile(pathAppointment, array);
		System.out.println(" Appointment Secure\n");
	}
	
	public void showAppointment() throws JSONException, IOException, ParseException
	{
		JSONArray array = Repository.readFile(pathAppointment);
		if(array.length()==0)
		{
			System.out.println(" No appointment to show");
		}
		else
		{
			JSONObject obj = new JSONObject();
			JSONArray arr=new JSONArray();
			for(int i=0;i<array.length();i++)
			{
				obj=array.getJSONObject(i);
				arr=(JSONArray) obj.get("Names");
				System.out.println("Doctor Name: "+arr.get(0)+"		"+"Patient name: "+arr.get(1));
			}
		}
	}

	public Object popularity() throws JSONException, IOException, ParseException {

		JSONArray array = Repository.readFile(pathAppointment);
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		if(array.length()==0)
		{
			System.out.println(" No appointment to show");
			return null;
		}
		else
			{
			int arr[] = new int[array.length()];
			for (int i = 0; i < array.length(); i++) {
				int ctr = 0;
				obj1 = (JSONObject) array.get(i);
				JSONArray dr = (JSONArray) obj1.get("Names");
				for (int j = 0; j < array.length(); j++) {
					obj2 = (JSONObject) array.get(j);
					JSONArray pt = obj2.getJSONArray("Names");
					if (dr.get(0).equals(pt.get(0))) {
						ctr++;
					}
				}
				arr[i] = ctr;
			}
			int max = arr[0];
			int index = 0;
			for (int i = 0; i < array.length(); i++) {
				if (arr[i] > max)
					index = i;
			}
			obj1 = (JSONObject) array.get(index);
			JSONArray arrpopularity = (JSONArray) obj1.get("Names");
			return arrpopularity.get(0);			
		}
		
	}

}
