package LoginServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.repository.Repository;
import com.bridgelabz.service.UpdateDataBase;
@WebServlet("/page1a")
public class ServletRegister extends  HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5512530923957167705L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("password");
		String email=req.getParameter("email");
		Repository obj = new Repository();
		obj.setEmail(email);
		obj.setPwd(pwd);
		obj.setUname(uname);
		try {
			boolean flag= UpdateDataBase.updateData(obj);
			if(flag==true)
			{
				HttpSession session=req.getSession();
				session.setAttribute("username",uname);
				RequestDispatcher rd=req.getRequestDispatcher("LoginPage.jsp");
				rd.forward(req, res);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
