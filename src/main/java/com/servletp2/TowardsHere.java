package com.servletp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.TruckBean;

import jakarta.servlet.http.HttpServletRequest;

public class TowardsHere {
	public static TruckBean getTowardsHere(HttpServletRequest req)
	{
	TruckBean a=null;
	
	try 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		PreparedStatement ps=con.prepareStatement("select * from truck  where  ROUTE_To=?");
		ps.setString(1, req.getParameter("b2"));
		 
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			a=new TruckBean();
			 a.setTruck_no(rs.getString(1));
			 a.setTruck_Model(rs.getString(2));
			 a.setInsurance(rs.getString(3));
			 a.setInsurance_Company(rs.getString(4));
			 a.setOwner(rs.getString(5));
			 a.setMobile(rs.getString(6));
			  
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return a;
	}
}

