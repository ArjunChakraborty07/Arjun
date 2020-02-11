package com.bridgelabz.loginpage;



import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.database.DatabaseOperation;
import com.bridgelabz.repository.DataSetter;

@WebServlet("/Page")
public class ServletPage extends HttpServlet{

	
	private static final long serialVersionUID = -5358225852804788775L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		
			String username=(String) req.getParameter("uname");
			String email=(String) req.getParameter("eid");
			String password=(String) req.getParameter("pwd");
			DataSetter obj= new DataSetter();
			obj.setUname(username);
			obj.setEid(email);
			obj.setPwd(password);
			
			
			try {
				DatabaseOperation.dataUpdate(obj,req,res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
}
