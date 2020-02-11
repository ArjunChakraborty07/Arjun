package com.bridgelabz.database;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Try extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void display(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd=req.getRequestDispatcher("page.html");
		rd.include(req, res);
	}
}
