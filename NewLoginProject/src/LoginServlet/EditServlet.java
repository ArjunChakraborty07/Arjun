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
import com.bridgelabz.service.EditDataBase;
@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Repository obj;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		obj = null;
		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		System.out.println("editservlet");
		try {
			System.out.println("editservlet");
			obj.setEmail(rs.getString(3));
			System.out.println(rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.setPwd(req.getParameter("password"));
		try {
			EditDataBase.editData(obj);
			RequestDispatcher rd=req.getRequestDispatcher("AccountPage.jsp");
			rd.forward(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
