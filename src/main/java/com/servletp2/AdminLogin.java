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

@WebServlet("/admin")
public class AdminLogin extends HttpServlet {
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
			 String s2=request.getParameter("pass");
			 PreparedStatement ps= con.prepareStatement("select * from Admin2 where UserName=? and PassWord=?");
			 ps.setString(1,s1);
			 ps.setString(2,s2);
			 ResultSet rs=ps.executeQuery();
			 PrintWriter pw=response.getWriter();
			 if(rs.next()) {
				pw.println("login succesfull");
				RequestDispatcher r=request.getRequestDispatcher("AdminHome.html");
				r.include(request, response);
			 }
			 else {
				 pw.println("invalid name or pass");
				 
			 } 
			} catch (Exception e) {
				 e.printStackTrace();
			}
			 
		}

	}
