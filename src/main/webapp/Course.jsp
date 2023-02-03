<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.*" %>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Details</title>
<style>
body{
background-size: 2250px;
font-size: 20px;
color: white;
}
input{
background:transparent;
border-width:0 0 2px;
border-radius:6px;
color:white;
margin-right:30px;	
fill:none;
outline:none;
border:0px solid;
border-width:0 0 2px;
font-size: 20px;
}
</style>
</head>
<body background="https://images.hdqwalls.com/wallpapers/night-in-mountains-od.jpg">
<% response.setContentType("text/html"); 
PrintWriter pw =response.getWriter();
  HttpSession s = request.getSession(false);
  if(s!=null){%>
<center>
<u><i>
<h1>Course Details</h1>
</i></u>
<form action="Coursesadd" method="post">
<table>
<tr>
<td> Student Id: 
<td> <input type="number" name="sid">
</tr>
<tr>
<td> Course Id: 
<td> <input type="number" name="cid">
</tr>
<tr>
<td> Course Name: 
<td> <input type="text" name="cname">
</tr>
<tr>
<td> Subjects :
<td> <input type="text" name="sub">
</tr>
<tr>
<td> <input type="submit">
<td> <input type="reset">
</tr>
</table>
</form>
<br>
<u><i>
<h2>Search Course Details</h2>
</i></u>
<form action="CourseDisplay.jsp" method="post">
Student id: <input type="number" name="ida"><br><br>
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