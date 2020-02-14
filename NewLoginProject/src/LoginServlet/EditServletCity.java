package LoginServlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.repository.Repository;
import com.bridgelabz.service.EditDataBase;
@WebServlet("/editc")
public class EditServletCity extends HttpServlet { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Repository obj=null;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
							
		String pwd=null;;
		pwd=req.getParameter("city");				
		req.setAttribute("city",pwd);
		
		try {
			EditDataBase.editDataCity(req, res);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
