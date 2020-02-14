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
//				PrintWriter out= res.getWriter();
//				out.println("<html><head></head><body onload=\"alert('Logout Successful')\"></body></html>");
//				RequestDispatcher rd=req.getRequestDispatcher("LoginPage.jsp");				
//				rd.include(req, res);
				return rs;
			}	
		}
		return null;
	}
}
