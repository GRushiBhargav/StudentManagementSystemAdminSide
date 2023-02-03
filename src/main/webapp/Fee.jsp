<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.*" %>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fess</title>
<style>
body{
background-size:cover;
color: black;
font-size:25px;
color: white
}
input{
font-size:25px;
background:transparent;
border-width:0 0 2px;
border-radius:6px;
margin-right:30px;	
fill:none;
outline:none;
border:0px solid;
border-width:0 0 2px;
color: white;
}
</style>
</head>
<body background="https://www.solidbackgrounds.com/download/2560x1440-blue-abstract-noise-free-website-background-image.jpg">
<% response.setContentType("text/html");
PrintWriter pw =response.getWriter();
  HttpSession s = request.getSession(false);
  if(s!=null){%>
<center>
<u><i><h1>Fee Details</h1></i></u>
<form action="Feeadd" method="post">
<table>
<tr>
<td>Student Id:
<td><input type="number" name="sid">
</tr>
<tr>
<td>Fee Id:
<td><input type="number" name="fee">
</tr>
<tr>
<td>Total Amount:
<td><input type="number" name="amount">
</tr>
<tr>
<td>Amount Paid:
<td><input type="number" name="paid">
</tr>
<tr>
<td>
<td><input type="submit"> <input type="reset">
</tr>
</table>
</form>
<br>
<br>
<u><i><h3>Search Student Fee Details</h3></i></u>
<form action="FeeDisplay.jsp" method="post">
Student id: <input type="number" name="id"><br><br>
<input type="submit">
</center>
</form>
<%}
  else{
	  pw.print("login first");
	  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
	  rd.include(request,response);
  }
  %>


</body>
</html>