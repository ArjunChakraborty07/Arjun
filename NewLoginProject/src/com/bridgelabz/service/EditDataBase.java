package com.bridgelabz.service;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.Connection;

public class EditDataBase {

	public static void editDataPassword(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		String email = rs.getString(3);
		String pwd = (String) req.getAttribute("password");
		// Setting data to process

		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn = (Connection) DriverManager.getConnection(URL, "Arjun", "password");
		// Connecting servlet with jdbc

		String query = "update registration set password = ? where email_id = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, pwd);
		preparedStmt.setString(2, email);
		preparedStmt.executeUpdate();
		// Executing the sql command

		/*
		 * 
		 */
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from registration");	
		while(rs.next())
		{
			if(email.equals(rs.getString("email_id")))
			{					
				break;
			}
		}
		session.setAttribute("data",rs);
		/*
		 * 
		 */
		RequestDispatcher rd = req.getRequestDispatcher("AccountPage.jsp");
		rd.forward(req, res);
		// Dispatching to the next required page
	}
	
	public static void editDataName(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		String email = rs.getString(3);
		String pwd = (String) req.getAttribute("name");
		// Setting data to process

		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn = (Connection) DriverManager.getConnection(URL, "Arjun", "password");
		// Connecting servlet with jdbc

		String query = "update registration set full_name = ? where email_id = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, pwd);
		preparedStmt.setString(2, email);
		preparedStmt.executeUpdate();
		// Executing the sql command
		/*
		 * 
		 */
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from registration");	
		while(rs.next())
		{
			if(email.equals(rs.getString("email_id")))
			{					
				break;
			}
		}
		session.setAttribute("data",rs);
		/*
		 * 
		 */
		RequestDispatcher rd = req.getRequestDispatcher("AccountPage.jsp");
		rd.forward(req, res);
		// Dispatching to the next required page
	}
	
	public static void editDataCity(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		String email = rs.getString(3);
		String pwd = (String) req.getAttribute("city");
		// Setting data to process

		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn = (Connection) DriverManager.getConnection(URL, "Arjun", "password");
		// Connecting servlet with jdbc

		String query = "update registration set city = ? where email_id = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, pwd);
		preparedStmt.setString(2, email);
		preparedStmt.executeUpdate();
		// Executing the sql command
		/*
		 * 
		 */
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from registration");	
		while(rs.next())
		{
			if(email.equals(rs.getString("email_id")))
			{					
				break;
			}
		}
		session.setAttribute("data",rs);
		/*
		 * 
		 */
		RequestDispatcher rd = req.getRequestDispatcher("AccountPage.jsp");
		rd.forward(req, res);
		// Dispatching to the next required page
	}
	
	public static void editDataphone(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		String email = rs.getString(3);
		String pwd = (String) req.getAttribute("phone");
		// Setting data to process

		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn = (Connection) DriverManager.getConnection(URL, "Arjun", "password");
		// Connecting servlet with jdbc

		String query = "update registration set phone_no = ? where email_id = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, pwd);
		preparedStmt.setString(2, email);
		preparedStmt.executeUpdate();
		// Executing the sql command
		/*
		 * 
		 */
		Statement st=conn.createStatement();
		rs=st.executeQuery("select * from registration");	
		while(rs.next())
		{
			if(email.equals(rs.getString("email_id")))
			{					
				break;
			}
		}
		session.setAttribute("data",rs);
		/*
		 * 
		 */
		RequestDispatcher rd = req.getRequestDispatcher("AccountPage.jsp");
		rd.forward(req, res);
		// Dispatching to the next required page
	}
}
