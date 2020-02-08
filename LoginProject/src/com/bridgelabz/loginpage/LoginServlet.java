package com.bridgelabz.loginpage;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.bridgelabz.database.DatabaseOperation;
import com.bridgelabz.repository.DataSetter;

@WebServlet("/Page1")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String email=req.getParameter("uname");
		String password=req.getParameter("pwd");
		DataSetter obj= new DataSetter();
		obj.setEid(email);
		obj.setPwd(password);
		try {
			DatabaseOperation.login(obj,req,res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
