package com.bridgelabz.service;

import java.sql.*;


import com.bridgelabz.repository.Repository;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UpdateDataBase {

	public static boolean updateData(Repository obj) throws ClassNotFoundException, SQLException
	{
		System.out.println("Check1");
		int ctr=0;
		String Driver="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn=(Connection) DriverManager.getConnection(URL, "Arjun","password");
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from registration");
		while(rs.next())
		{			
			if(obj.getEmail().equals(rs.getObject("email_id")))
			{
				ctr++;
			}					
		}
		if(ctr==0)
		{
			System.out.println("check2");
			PreparedStatement ps=conn.prepareStatement("insert into registration (user_name,email_id,password) values(?,?,?)");
			ps.setString(1, obj.getUname());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getPwd());
			ps.execute();
			return true;
		}
		return false;
	}
}
