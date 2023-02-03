<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.*" %>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
background-attachment: fixed;
font-size: 20px;
font-family: verdana;
}
input{
background:transparent;
border-width:0 0 2px;
border-radius:6px;
fill:none;
outline:none;
}
</style>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body background="https://wallpaperaccess.com/full/5137774.jpg" >
<% response.setContentType("text/html");
PrintWriter pw =response.getWriter();
  HttpSession s = request.getSession(false);
  if(s!=null){%>

<center>
<u><i><h2>Student Details</h2></i></u>
<form action="./StudentDetails" method="post">
<table>
<tr>
<td>Student id: </td>
<td><input type="text" name="sid"></td>
</tr>
<tr>
<td> Student Name: </td>
<td> <input type="text" name="sn"></td>
</tr> 
<tr>
<td>Gender: </td>
<td><input type="radio" value="male"name="gen"> Male  <input type="radio" value="female" name="gen">Female</td>
</tr>
<tr>
<td>Date of Birth:
<td> <input type="date" name="dob">
</tr>
<tr>
<td>Age:
<td><input type="number" name="age">
</tr>
<tr>
<td>Email:
<td> <input type="text" name="eid">
</tr>
<tr>
<td>Father Name:
<td> <input type="text" name="fn">
</tr>
<tr>
<td>Mother Name:
<td> <input type="text" name="mn">
</tr>
<tr>
<td>Mobile No:
<td> <input type="tel" name="tel">
</tr>
<tr>
<td>Blood Group
<td> <input type="text" name="bg">
</tr>
<tr>
<td>Aadhar card no:
<td> <input type="number" name="aan">
</tr>
<tr>
<td>Pan Card no:
<td> <input type="text" name="pen">
</tr>
<tr>
<td>Date Of Joining
<td> <input type="date" name="doj">
</tr>
<tr>
<td> <input type="submit">
<td> <input type="reset">
</tr>
</table>
</form>
<br>
<u><i><h3>Search Student Details</h3></i></u>
<form action="StudentDetailsDisplay.jsp" method="post">
Student id: <input type="number" name="id"><br><br>
<input type="submit">
</form>
</center>
<%}
  else{
	  pw.print("login first");
	  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
	  rd.include(request,response);
  }
  %>
</body>
</html>