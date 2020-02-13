<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>

<h2>Welcome to edit Page</h2>
<form action="editfn" method="post">
Full Name:<input type="text" name="name" required>
<button type="submit" value="submit">Update</button><br><br>
</form>

<form action="editpn" method="post">
Phone Number:<input type="text" name="phone" required>
<button type="submit" value="submit">Update</button><br><br>
</form>

<form action="editc" method="post">
City:<input type="text" name="city" required>
<button type="submit" value="submit">Update</button><br><br>
</form>

<form action="editpd" method="post">
Update Password:<input type="password" name="password" required>
<button type="submit" value="submit">Update</button><br><br>
</form>

<a href="AccountPage.jsp">Click here to go to your account</a>

</body>
</html>