package com.servletp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.TruckBean;

import jakarta.servlet.http.HttpServletRequest;

public class StatusDao 
{
	public static ArrayList<TruckBean> status(HttpServletRequest req)
	{
		ArrayList<TruckBean> a = new ArrayList<TruckBean>();
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "root");
			PreparedStatement p1 = con.prepareStatement("Select * from truck");
			ResultSet rs = p1.executeQuery();
			while (rs.next()) 
			{
				TruckBean t = new TruckBean();
				t.setTruck_no(rs.getString(1));
				 t.setTruck_Model(rs.getString(2));
				 t.setInsurance(rs.getString(3));
				 t.setInsurance_Company(rs.getString(4));
				 t.setOwner(rs.getString(5));
				 t.setMobile(rs.getString(6));
				 t.setRoute_from(rs.getString(7));
				 t.setRoute_to(rs.getString(8));
				 t.setStatus(rs.getString(9));
				a.add(t);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}
}