package com.bridgelabz.service;


import java.sql.*;


import com.bridgelabz.repository.Repository;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DisplayData {

	public static ResultSet dispalyData(Repository obj) throws ClassNotFoundException, SQLException
	{
		String Driver="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn=(Connection) DriverManager.getConnection(URL,"Arjun","password");
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=st.executeQuery("select * from registration");
		
		while(rs.next())
		{
			if(obj.getPwd().equals(rs.getString("password"))&&obj.getEmail().equals(rs.getString("email_id")))
			{								
				return rs;
			}	
		}
		return null;
	}
}
