
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bridgelabz.service.*"%>
<%@page import="com.bridgelabz.repository.*"%>
<%@page import="LoginServlet.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Page</title>
</head>

	<%!
	HttpSession session=null;		
	%>
<body>
<div align="center">
<h2>Welcome</h2>

<table border="1">
         
    <tr>
        <th>User Name:</th>
        <th>Email Id:</th>
        <th>Full Name:</th>
        <th>City:</th>
        <th>Phone Number:</th>
    </tr>
    
<%
  	session=request.getSession();
    ResultSet rs=(ResultSet)session.getAttribute("data");  
%>
<tr>
                <td><%= rs.getString(2)%></td>
                <td><%= rs.getString(3)%></td>  
                <td><%= rs.getString(4)%></td> 
                <td><%= rs.getString(5)%></td> 
                <td><%= rs.getString(6)%></td>    
</tr>   
</table>


<form action="page2" method="post">
<button type="submit" value="submit">LogOut</button>
</form>
<a href=EditData.jsp>Click Here to edit data</a>
</div>
<form action="page2a" method="post">
<button type="submit">DeleteAccount</button>
</form>
</body>
</html>