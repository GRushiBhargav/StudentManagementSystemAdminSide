<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.*" %>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address Details</title>
<style>
body{
background-attachment: fixed;
font-size: 20px;
font-family: verdana;
color:white;
}
input{
background:transparent;
border-width:0 0 2px;
border-radius:6px;
font-size: 20px;
font-family: verdana;
color:white;
margin-right:30px;	
fill:none;
outline:none;
border:0px solid;
border-width:0 0 2px;
}
</style>
</head>
<body background="https://cdn.wallpapersafari.com/68/66/PLgQbl.jpg">
<% response.setContentType("text/html"); 
PrintWriter pw =response.getWriter();
  HttpSession s = request.getSession(false);
  if(s!=null){%>
<u><i>
<center><h1>Address Details</h1>
</i></u>
<form action="./Address" method="post">
<table>
<tr>
<td>Student id:
<td><input type="number" name="stuid">
</tr>
<tr>
<td>House No:
<td><input type="text" name="hno">
</tr>
<tr>
<td>Area/locality:
<td><input type="text" name="area">
</tr>
<tr>
<td>City:
<td><input type="text" name="city">
</tr>
<tr>
<td>District:
<td><input type="text" name="district">
</tr>
<tr>
<td>State:
<td><input type="text" name="state">
</tr>
<tr>
<td>Pin Code:
<td><input type="number" name="pin">
</tr>
<tr>
</tr>
<tr>
</tr>
<tr>
</tr>
<tr>	
<td> <input type="submit">
<td> <input type="reset">
</tr>
</table>
</form>
<br>
<br>
<u><i>
<h3>Search Student Details</h3>
</i></u>
<form action="AddressDisplay.jsp" method="post">
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