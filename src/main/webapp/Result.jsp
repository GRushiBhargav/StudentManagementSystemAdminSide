<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.*" %>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
<style>
body{
background-size: cover;
font-family:  Georgia, serif;
font-size: 22px
}
input{
font-size:19px;
background:transparent;
border-width:0 0 2px;
border-radius:6px;
margin-right:30px;	
fill:none;
outline:none;
border:0px solid;
border-width:0 0 2px;
}
</style>
</head>
<body background="https://www.employmenthelp.org/wp-content/uploads/Seccond-Career-Header-Background-1030x404.png">
<% response.setContentType("text/html");
PrintWriter pw =response.getWriter();
  HttpSession s = request.getSession(false);
  if(s!=null){%>
<center>
<u><i><h1>Results</h1></i></u>
<form action="ResultsAdd">
<table>
<tr>
<td>Student id:
<td><input type="number" name="sid">
</tr>
<tr>
<td>Semister:
<td><input type="number" name="sem">
</tr>
<tr>
<td>SGPA:
<td><input type="number" name="sgpa" step="any">
</tr>
<tr>
<td>CGPA:
<td><input type="number" name="cgpa"  step="any">
</tr>
<tr>
<td>Subjects:
<td><input type="text" name="sub">
</tr>
<tr>
<td>
<td><input type="submit">       <input type="reset">
</tr>
</table>
</form>
<br>
<br>
<u><i><h3>Search Student Results</h3></i></u>
<form action="ResultsDisplay.jsp" method="post">
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