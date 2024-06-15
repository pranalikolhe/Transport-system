package com.servletp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.ManagerBean;

import jakarta.servlet.http.HttpServletRequest;

public class ManagerSearchDAo {
	public static ManagerBean getManager(HttpServletRequest req)
	{
		ManagerBean ab1=null;
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			PreparedStatement ps=con.prepareStatement("select * from ManagerDetail2  where branch=? and username=?  ");
			ps.setString(1, req.getParameter("branch"));
			ps.setString(2, req.getParameter("find"));
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				ab1=new ManagerBean();
				 ab1.setBranch(rs.getString(1));
				 ab1.setUsername(rs.getString(2));
				 ab1.setSalary(rs.getString(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab1;
		}
}