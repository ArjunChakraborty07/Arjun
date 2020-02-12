package com.bridgelabz.service;

import java.sql.*;
import com.bridgelabz.repository.Repository;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class EditDataBase {

	public static void editData(Repository obj) throws ClassNotFoundException, SQLException
	{
//		int ctr=0;
		
		String Driver="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/Registration";
//		String statement="update employee set name='?' where email_id=?";
		Class.forName(Driver);
		Connection conn=(Connection) DriverManager.getConnection(URL,"Arjun","password");
		Statement st=(Statement) conn.createStatement();
		//st.execute(statement);
		String query = "update users set password = ? where email_id = ?";
	    PreparedStatement preparedStmt = conn.prepareStatement(query);
	    preparedStmt.setString(1, obj.getPwd());
	    preparedStmt.setString(2, obj.getEmail());
//		ResultSet rs=st.executeQuery("Select * from registration");
//		while(ctr==0)
//		{
//			rs.next();
//			PreparedStatement ps= conn.prepareStatement("update registration set password=? where email_id="+obj.getEmail());				
//			ps.setString(1, obj.getUname());
//			ps.execute();
//			ctr++;		
//		}
//		rs=DisplayData.dispalyData(obj);
		
	}
}
