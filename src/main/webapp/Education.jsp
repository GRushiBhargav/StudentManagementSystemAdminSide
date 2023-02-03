<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.*" %>
    <%@page import="java.io.PrintWriter"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Education</title>
<style>
body{
background-size:cover;
color: black;
font-size:20px;
color: white
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
<body background="https://wallpapercave.com/wp/zuiHX0K.jpg">
<% response.setContentType("text/html");
PrintWriter pw =response.getWriter();
  HttpSession s = request.getSession(false);
  if(s!=null){%>

<center>
<h1>Education Details</h1>
<form action="EducationAdd" method="post">
<table>
<tr>
<td>Student id:
<td><input type="number" name="sid">
</tr>
<tr>
<td>Student 10<sup>th</sup> School Name:
<td><input type="text" name="schten">
</tr>
<tr>
<td>Student 10<sup>th</sup> Completion year:
<td><input type="number" name="comten">
</tr>
<tr>
<td>Student 10<sup>th</sup> Board/University:
<td><input type="text" name="tenbord">
</tr>
<tr>
<td>Student 10<sup>th</sup> Subjects:
<td><input type="text" name="subten">
</tr>
<tr>
<td>Student 12<sup>th</sup> School Name:
<td><input type="text" name="twesch">
</tr>
<tr>
<td>Student 12<sup>th</sup> Completion year:
<td><input type="number" name="comptwe">
</tr>
<tr>
<td>Student 12<sup>th</sup> Board/University:
<td><input type="text" name="bordtwe">
</tr>
<tr>
<td>Student 12<sup>th</sup> Subjects:
<td><input type="text" name="subtwe">
</tr>
<tr>
<td> <input type="submit">
<td> <input type="reset">
</tr>
</table>
</form>
<br>
<br>
<u><i><h3>Search Student Education Details</h3></i></u>
<form action="EducationDisplay.jsp" method="post">
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
