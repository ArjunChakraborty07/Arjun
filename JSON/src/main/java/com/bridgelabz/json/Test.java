package com.bridgelabz.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {
	public static void testing() throws JSONException
	{
		JSONArray array=new JSONArray();
		JSONObject obj=new JSONObject();
		obj.put("Name","Rahul");
		String str="Rohit";
		if(str.length()==3)
		{
			obj.accumulate("Name", str);
			array.put(obj);
		}
		else
		{
			obj=new JSONObject();
			obj.put("Name", str);
			array.put(obj);
		}
		
		System.out.println(array);
	}
	public static void main(String[] args) throws JSONException {
		testing();
	}
}
