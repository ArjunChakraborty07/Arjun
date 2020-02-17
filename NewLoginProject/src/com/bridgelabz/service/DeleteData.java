package com.bridgelabz.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DeleteData {

	public static void deleteData(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		ResultSet rs=null;
		HttpSession session= req.getSession();
		rs=(ResultSet) session.getAttribute("data");
		String email=rs.getString("email_id");
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Registration";
		Class.forName(driver);
		Connection conn=(Connection) DriverManager.getConnection(url,"Arjun","password");
		String query="delete from registration where email_id=?";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
		ps.setString(1, email);
		ps.execute();
		conn.close();
		req.removeAttribute("data");
		PrintWriter out=res.getWriter();
		out.println("<html><head></head><body onload=\"alert('Account Deleted')\"></body></html>");
		RequestDispatcher rd=req.getRequestDispatcher("RegistrationPage.jsp");
		rd.include(req, res);
	}
}
