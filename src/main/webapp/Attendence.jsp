<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.*" %>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendence</title>
<style type="text/css">
body{
font-size: 20px;
font-family:  Georgia, serif;
}
input{
font-size:20px;
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
<body background="https://singularityhub.com/wp-content/uploads/2018/09/blur-abstract-background-examination-room-undergraduate_shutterstock_639640396.jpg">
<% response.setContentType("text/html");
PrintWriter pw =response.getWriter();
  HttpSession s = request.getSession(false);
  if(s!=null){%>

<center><b>
<br><br><br>
<u><i><h1>Attendence</h1></i></u>
<form action="AttendenceAdd" method="post">
<table>
<tr>
<td>Student id:
<td><input type="number" name="sid">
</tr>
<tr>
<td>No Of Classess Conducted:   
<td><input type="number" name="noofclassess">
</tr>
<tr>
<td>Attendence classess: 
<td><input type="number" name="attclass">
</tr>
<tr>
<td>Percentage of attendence: 
<td><input type="number" name="percent">
</tr>
<tr>
<td>Status 
<td><input type="text" name="status">
</tr>
<tr>
<td>Remarks
<td><input type="text" name="remark">
</tr>
<tr>
<td> 
<td><input type="submit"><input type="reset">
</tr>
</table>
</form>
<br>
<u><i><h3>Search Student Attendence Details</h3></i></u>
<form action="AttendenceDisplay.jsp" method="post">
Student id: <input type="number" name="id"><br><br>
<input type="submit">
</form>
</center></b>
<%}
  else{
	  pw.print("login first");
	  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
	  rd.include(request,response);
  }
  %>
</body>
</html>