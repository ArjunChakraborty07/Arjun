package com.bridgelabz.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.repository.DataSetter;


public class DatabaseOperation {
	public static void dataUpdate(DataSetter obj, HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException, ServletException {
		String myDriver =  "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(myDriver);
		Connection conn = (Connection) DriverManager.getConnection(myUrl, "Arjun", "password");
		Statement st = conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from registration");
		int ctr=0;
		while(rs.next()) 
		{
			if(rs.getString("email_id").equals(obj.getEid()))
			{
				ctr++;
				break;
			}
		}
		if(ctr==0)
		{
			PreparedStatement ps=conn.prepareStatement("insert into registration(user_name,email_id,password) values(?,?,?)");
			ps.setString(1, obj.getUname());
			ps.setString(2, obj.getEid());
			ps.setString(3, obj.getPwd());
			ps.execute();
			RequestDispatcher rd=req.getRequestDispatcher("AlertPage.jsp");
			rd.include(req, res);
			//PrintWriter out=res.getWriter();
			
			//out.println("Registration Sucessfull");
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("page.html");
			rd.forward(req, res);
			
			//PrintWriter out=res.getWriter();
			//out.println("Email id already exists");
		}
		conn.close();
	}	
	
	
	public static void dataQuary(HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException {
		String myDriver =  "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(myDriver);
		Connection conn = (Connection) DriverManager.getConnection(myUrl, "Arjun", "password");
		Statement st = conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from registration");
		String uname, eid;
		while(rs.next())
		{
			 uname=rs.getString("user_name");
			 eid=rs.getString("email_id");	
			 PrintWriter out=res.getWriter();
			 out.println(uname+" "+eid);		
		}		
		conn.close();		
	}	
	public static void login(DataSetter obj, HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException, ServletException
	{
		int ctr=0;
		String myDriver= "com.mysql.jdbc.Driver";
		String myURL="jdbc:mysql://localhost:3306/Registration";
		Class.forName(myDriver);
		Connection conn=DriverManager.getConnection(myURL, "Arjun", "password");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from registration");
		while(ctr==0)
		{
			rs.next();
			
			if(rs.getString("email_id").equals(obj.getEid())||rs.getString("user_name").equals(obj.getEid()))
			{
				if(rs.getString("password").equals(obj.getPwd()))
				{
					RequestDispatcher rd=req.getRequestDispatcher("Account.jsp");
					rd.forward(req, res);
					//out.println("Welcome to your home page");
					ctr++;
				}
				else
				{
					RequestDispatcher rd=req.getRequestDispatcher("page.html");
					rd.forward(req, res);
					//out.println("Wrong Password");
					break;
				}
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("page.html");
				rd.forward(req, res);
				//out.println("Wrong Username/email Id");
				break;
			}
		}
		
	}
}
