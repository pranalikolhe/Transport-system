package com.servletp2;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/truck")
public class CreateTruck extends HttpServlet {
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
			 String s1=request.getParameter("tm");
			 String s2=request.getParameter("tn");
			 String s3=request.getParameter("choice");
			 String s4=request.getParameter("inc");
			 String s5=request.getParameter("owner");
			 String s6=request.getParameter("mobile");
			 String s7=request.getParameter("branch1");
			 String s8=request.getParameter("branch2");
			 String s9= request.getParameter("status");
			 String s10= changeFormat(request.getParameter("date"));
			 PreparedStatement ps= con.prepareStatement("insert into truck values(?,?,?,?,?,?,?,?,?,?)");
			 ps.setString(1,s1);
			 ps.setString(2,s2);
			 ps.setString(3,s3);
			 ps.setString(4,s4);
			 ps.setString(5,s5);
			 ps.setString(6,s6);
			 ps.setString(7,s7);
			 ps.setString(8,s8);
			 ps.setString(9,s9);
			 ps.setString(10,s10);
			 ps.executeQuery();
			 PrintWriter pw=response.getWriter();
			  pw.println("<body bgcolor=\"cyan\"><body>");
			  pw.println("<center>");
			  pw.println("<h1>data entered succesfully<h1>");
			  pw.println("<a href=\"Createtruck.html\">create new truck</a><br><br>");
			  pw.println("<a href=\"AdminHome.html\">go Back home page of Admin</a>");
			  pw.println("</center>");
			  
			} catch (Exception e) {
				 e.printStackTrace();
			}
			 
		}
	public static String changeFormat(String date) throws ParseException{
		SimpleDateFormat s1= new SimpleDateFormat("yyyy-mm-dd");
		Date d1=s1.parse(date);
		SimpleDateFormat s2=new SimpleDateFormat("dd-mm-yyyy");
		return s2.format(d1);
	}
	}

