package com.cliniquemanagement.controller;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.cliniquemanagement.service.Service;
import com.cliniquemanagement.utility.Utility;

public class Controller {
	public static void main(String args[]) throws JSONException, IOException, ParseException {
		
		Service obj=new Service();
		int ctr=0;		
		while(ctr==0)
		{			
			System.out.println("1.Add Doctor");
			System.out.println("2.Add Patient");
			System.out.println("3.Make appointments");
			System.out.println("4.Check popularity");
			System.out.println("5.Check Doctors");
			System.out.println("6.Check Patients");
			System.out.println("7.Check Appointment");
			
			int ch=Utility.returnInt();
			Utility.returnString();
			switch(ch)
			{
			case 1:				
				obj.doctorFile();				
				break;
			case 2:								
				obj.patientFile();				
				break;
			case 3:								
				obj.appointment();				
				break;
			case 4:
				System.out.println(obj.popularity());
				break;
			case 5:								
				obj.showDoctor();
				break;
			case 6:
				
				obj.showPatient();
				break;
			case 7:				
				obj.showAppointment();
				break;
			default:
				ctr++;
			}
		}
	}
}

