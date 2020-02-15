package com.bridgelabz.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DisplayAdmin {
	public static ResultSet dispalyAdmin() throws ClassNotFoundException, SQLException
	{
		String Driver="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn=(Connection) DriverManager.getConnection(URL,"Arjun","password");
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=st.executeQuery("select * from registration");
		return rs;
	}
}
