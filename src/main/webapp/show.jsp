<%@page import="java.util.List"%>
<%@page import="com.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
List<UserModel> data = (List<UserModel>)request.getAttribute("data");

%>
<table border="2px">
<tr>
	<th>sno</th>
	<th>name</th>
	<th>email</th>
	<th>password</th>
	<th>image</th>
	<th>Operations</th>
</tr>
<% for(int i=0;i<data.size();i++) {%>
<tr>
	<td><%=data.get(i).getSno() %></td>
	<td><%=data.get(i).getName() %></td>
	<td><%=data.get(i).getEmail() %></td>
	<td><%=data.get(i).getPassword() %></td>
	<td><img src="upload/<%=data.get(i).getFilename() %>" width="100px" height="100px" alt="Image"></td>
	<td><a href='delete?sno=<%=data.get(i).getSno() %>'>Delete</a></td>
</tr>
<%} %>
</table>
</body>
</html>