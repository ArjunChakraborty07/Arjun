package LoginServlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.repository.Repository;
import com.bridgelabz.service.DisplayData;
@WebServlet("/page1b")
public class ServletLogin extends  HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5512530923957167705L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		String pwd=req.getParameter("password");
		Repository obj = new Repository();		
		obj.setPwd(pwd);
		obj.setEmail(email);
		try {
			ResultSet rs=DisplayData.dispalyData(obj);
			if(rs!=null)
			{
				HttpSession session=req.getSession();
				session.setAttribute("data", rs);		
				RequestDispatcher rd=req.getRequestDispatcher("AccountPage.jsp");				
				rd.forward(req, res);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
