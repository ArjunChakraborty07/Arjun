package LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page2")
public class ServletLogout extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		out.println("<script type='text/javascript'> alert('Logout Successful')	Location='RegistrationPage.jsp'</script>");
		RequestDispatcher rd= req.getRequestDispatcher("RegistrationPage.jsp");
		rd.forward(req, res);
	}

}
