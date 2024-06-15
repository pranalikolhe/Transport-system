package com.servletp2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 @WebServlet("/manager")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	   public void init(ServletConfig config) {
		   try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			} catch (Exception e) {
				 e.printStackTrace();
			}
	   }
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				 response.setContentType("text/html");
				 String s1=request.getParameter("name");
			 String s2=request.getParameter("Pass");
			 PreparedStatement ps= con.prepareStatement("select * from ManagerDetail2 where UserName=? and PassWord=?");
			 ps.setString(1,s1);
			 ps.setString(2,s2);
			 ResultSet rs=ps.executeQuery();
			 PrintWriter pw=response.getWriter();
			 if(rs.next()) {
				RequestDispatcher r=request.getRequestDispatcher("managerHome.html");
				r.include(request, response);
			 }
			 else {
				 pw.println("<body bgcolor=\"cyan\"><body>");
				 pw.println("invalid name or pass");
				 
			 } 
			} catch (Exception e) {
				 e.printStackTrace();
			}
			 
		}

	}
