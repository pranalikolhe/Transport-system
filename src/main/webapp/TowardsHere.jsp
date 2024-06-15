<%@ page import="com.bean.TruckBean" %>
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
TruckBean t = (	TruckBean) request.getAttribute("data");
if (t != null) {
%>
<center> 

<table border="1">
    <tr>
        <td>truck_no</td>
        <td>Truck_model</td>
        <td>insurance</td>
        <td>insurance_company</td>
        <td>owner</td>
        <td>mobile</td>
       
      
        
    </tr>
    <tr>
        <td><%= t.getTruck_no() %></td>
        <td><%= t.getTruck_Model() %></td>
         <td><%= t.getInsurance() %></td>
          <td><%= t.getInsurance_Company() %></td>
           <td><%= t.getOwner() %></td>
            <td><%= t.getMobile() %></td>
           
        
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
<a href="managerHome.html">go Back</a>
</div>
</body>
</html>