<%@ page import="com.bean.ManagerBean" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<div> 
<% 
ManagerBean ab1 = (	ManagerBean) request.getAttribute("data");
if (ab1 != null) {
%>
<center> 

<table border="1">
    <tr>
        <td>branch</td>
        <td>UserName</td>
        <td>Salary</td>
    </tr>
    <tr>
        <td><%= ab1.getBranch() %></td>
        <td><%= ab1.getUsername() %></td>
        <td><%= ab1.getSalary() %></td>
        
    </tr>
</table>
<% 
} else {
%>
<table border="1">
    <tr>
        <td colspan="5">Data not available</td>
    </tr>
</table>
</center>
<% 
}
%>
</div>
</body>
</html>