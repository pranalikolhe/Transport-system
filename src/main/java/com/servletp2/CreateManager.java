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

 @WebServlet("/managerc")
public class CreateManager extends HttpServlet {
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
		 String s1=request.getParameter("branch");
		 String s2=request.getParameter("name");
		 String s3=request.getParameter("Pass");
		 String s4= changeFormat(request.getParameter("doj"));
		 String s5=changeFormat(request.getParameter("dob"));
		 String s6=request.getParameter("sal");
		 PreparedStatement ps= con.prepareStatement("insert into  ManagerDetail2 values(?,?,?,?,?,?)");
		 ps.setString(1,s1);
		 ps.setString(2,s2);
		 ps.setString(3,s3);
		 ps.setString(4,s4);
		 ps.setString(5,s5);
		 ps.setString(6,s6);
		 
		 ps.executeQuery();
		 PrintWriter pw=response.getWriter();
		 pw.println("<body bgcolor=\"cyan\"><body>");
		 pw.println("<center>");
		  pw.println("<h1>data entered succesfully<h1>");
		  pw.println("<a href=\"CreateManager.html\">Create new  manager</a><br><br>");
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