<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
<style type="text/css">

</style>
</head>
<body align="center" bgcolor="grey">
<%
ResultSet rs = (ResultSet)session.getAttribute("emp");



%>
<div>
<form action="updateemployee">
<input type="text" name="name" value="<%=rs.getString(1) %>"> <br> <br>
<input type="text" name="lastname" value="<%=rs.getString(2) %>"> <br> <br>
<input type="text" name="salary" value="<%=rs.getDouble(3)%>"> <br> <br>
<input type="text" name="department" value="<%=rs.getString(4)%>"> <br> <br>
<input type="text" name="position" value="<%=rs.getString(5)%>"> <br> <br>
<input type="email" name="email" value="<%=rs.getString(6)%>"> <br> <br>
<input type="text" name="contact" value="<%=rs.getLong(7)%>"> <br> <br>
<input type="file" name="picture" value="<%=rs.getBlob(8)%>"> <br> <br>
<input type="submit">

</form>

</div>


</body>
</html>