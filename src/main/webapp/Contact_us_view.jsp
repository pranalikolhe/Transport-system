<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.Contact_usBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Truck Details</title>
</head>
<body bgcolor="cyan">
<div> 
<%
ArrayList<Contact_usBean> Contact = (ArrayList<Contact_usBean>)request.getAttribute("Contact");
if (Contact != null && !Contact.isEmpty()) {
%>
<center> 
<table border="1">
    <caption>Details of Truck</caption>
    <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Message</th>
             
        </tr>
    </thead>
    <tbody>
    <%
    for (Contact_usBean t :  Contact) {
    %>
        <tr>
             <td><%= t.getName()%></td>
            <td><%= t.getEmail() %></td>
            <td><%= t.getPhone() %></td>
            <td><%= t.getMessage() %></td>
             
        </tr>
    <%
    }
    %>
    </tbody>
</table>
<%
} else {
%>
<table border="1">
    <tr>
        <td>Data not available</td>
    </tr>
</table>
</center>
<%
}
%>
<a href="AdminHome.html">go Back</a>
</div>
</body>
</html>