package LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.repository.DisplayAdmin;
import com.bridgelabz.service.DeleteData;


@WebServlet("/page2")
public class ServletLogout extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		String button=req.getParameter("button");
		if(button.equals("logout"))
		{			
			HttpSession s=req.getSession();
			s.invalidate();
			res.setHeader("Cache-Control","no-cache");
			res.setHeader("Cache-Control","no-store");
			res.setHeader("Pragma","no-cache");
			res.setHeader ("Expires", "0");
			PrintWriter out= res.getWriter();
			out.println("<html><head></head><body onload=\"alert('Logout Successful')\"></body></html>");
			RequestDispatcher rd=req.getRequestDispatcher("RegistrationPage.jsp");				
			rd.include(req, res);
		}
		if(button.equals("edit"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("EditData.jsp");				
			rd.include(req, res);
		}
		if(button.equals("delete"))
		{
			try {
				
				DeleteData.deleteData(req, res);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(button.equals("admin"))
		{
			HttpSession session=req.getSession();
			ResultSet rs;
			try {
				rs = DisplayAdmin.dispalyAdmin();
				session.setAttribute("admin", rs);
				RequestDispatcher rd=req.getRequestDispatcher("AdminPage.jsp");				
				rd.include(req, res);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
	}
}
