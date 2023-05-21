<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Employee Data</title>

</head>
<body>
<h1>Employees Records</h1>
<%
ResultSet rs =(ResultSet)session.getAttribute("emplist");
%>


<%while(rs.next()){%>
<table cellpadding="15px" align="center" border="2">
<th>first_name</th> 
<th>last_name</th> 
<th>salary</th> 
<th>department</th> 
<th>position</th> 
<th>email</th> 
<th>contact</th> 
<th>picture</th> 

<tr>
<td> <%= rs.getString(1) %> </td>
<td> <%= rs.getString(2) %> </td>
<td> <%= rs.getDouble(3) %> </td>
<td> <%= rs.getString(4) %> </td>
<td> <%= rs.getString(5) %> </td>
<td> <%= rs.getString(6) %> </td>
<td> <%= rs.getLong(7) %> </td>
<td> <%= rs.getBlob(8) %> </td>
<td> <%= rs.getInt(9) %> </td>
<td> <a href="edit?Id=<%=rs.getInt(9)%>">Edit</a> </td>  <td> <a href="delete?Id=<%=rs.getInt(9)%>">Delete</a> </td>



</tr> 
</table><%}
%>
</body>
</html>