<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.TruckBean" %>
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
ArrayList<TruckBean> trucks = (ArrayList<TruckBean>)request.getAttribute("status");
if (trucks != null && !trucks.isEmpty()) {
%>
<center> 
<table border="1">
    <caption>Details of Truck</caption>
    <thead>
        <tr>
            <th>TMODEL</th>
            <th>TNO</th>
            <th>INSURANCE</th>
            <th>COMPANYNAME</th>
            <th>OWNERNAME</th>
            <th>MOBILE</th>
            <th>RFROMS</th>
            <th>RTOS</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
    <%
    for (TruckBean t : trucks) {
    %>
        <tr>
             <td><%= t.getTruck_Model() %></td>
            <td><%= t.getTruck_no() %></td>
            <td><%= t.getInsurance() %></td>
            <td><%= t.getInsurance_Company() %></td>
            <td><%= t.getOwner() %></td>
            <td><%= t.getMobile() %></td>
            <td><%= t.getRoute_from() %></td>
            <td><%= t.getRoute_to()%></td>
            <td><a href="statusupdate.html"><%=t.getStatus()%></a></td>
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
<a href="managerHome.html">go Back</a>
</div>
</body>
</html>