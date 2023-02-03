<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.*" %>
    <%@page import="java.io.PrintWriter"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject</title>
<style>
body{
font-size:20px;
font-family:  Georgia, serif;
background-size: 1070px;
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
<body background="https://png.pngtree.com/thumb_back/fw800/back_our/20190621/ourmid/pngtree-teacher-s-college-classroom-coaching-training-background-image_188495.jpg">
<% response.setContentType("text/html");
PrintWriter pw =response.getWriter();
  HttpSession s = request.getSession(false);
  if(s!=null){%>

<center>
<u><i><h1>Subjest details</h1></i></u>
<form action="SubjectsAdd" method="post">
<table>
<tr>
<td>Student id:
<td><input type="number" name="sid">
</tr>
<tr>
<td>Subject id:
<td><input type="number" name="sub">
</tr>
<tr>
<td>Subject Name:
<td><input type="text" name="subname">
</tr>

<tr>
<td>Faculty Name
<td><input type="text" name="Fname">
</tr>
<tr>
<td>
<td><input type="submit">     <input type="reset">
</tr>
</table>
</form>
<br>
<br>
<u><i><h3>Search Student Subject Details</h3></i></u>
<form action="SubjetsDisplay.jsp" method="post">
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