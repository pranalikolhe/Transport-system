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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bean.TruckBean;
@SuppressWarnings("serial")
@WebServlet("/rec")
public class RsesentallyInatallTruck extends HttpServlet {
	Connection con;
	public void init(ServletConfig config) {
	 	   try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
	 	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	 	   
			} catch (Exception e) {
				 e.printStackTrace();
			}
	    }
		@SuppressWarnings("unused")
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				String join = changeFormat(request.getParameter("fd"));
				String join1 = changeFormat(request.getParameter("td"));
				PreparedStatement p1 = con.prepareStatement("SELECT * FROM truck WHERE  DATE_OF_JOIN  BETWEEN TO_DATE(?, 'DD-MM-YYYY') AND TO_DATE(?, 'DD-MM-YYYY')");
				p1.setString(1, join);
				p1.setString(2, join1);
				ResultSet rs = p1.executeQuery();
				ArrayList<TruckBean> a = new ArrayList<TruckBean>();
				while (rs.next()) {
					TruckBean t = new TruckBean();
					  t.setTruck_Model(rs.getString(1));
					  t.setTruck_no(rs.getString(2));
					  t.setInsurance(rs.getString(3));
					  t.setInsurance_Company(rs.getString(4));
					  t.setOwner(rs.getString(5));
					  t.setMobile(rs.getString(6));
					  t.setRoute_from(rs.getString(7));
					  t.setRoute_to(rs.getString(8));
					  t.setStatus(rs.getString(9));
					  t.setDate_of_joining(rs.getDate(10));
					  a.add(t);
				}
				System.out.println(a);
				PrintWriter pw=response.getWriter();
		    	response.setContentType("text/html");
				if(a==null)
				{
					pw.println("please check details");
					RequestDispatcher rd = request.getRequestDispatcher("recentlytruck.html");
					rd.include(request, response);
				} else {
					request.setAttribute("recentlyTryck", a);
					RequestDispatcher rd = request.getRequestDispatcher("recently.jsp");
					rd.forward(request, response);
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}

		public static String changeFormat(String date) throws ParseException {
			SimpleDateFormat s1 = new SimpleDateFormat("yyyy-mm-dd");
			Date d1 = s1.parse(date);
			SimpleDateFormat s2 = new SimpleDateFormat("dd-mm-yyyy");
			return s2.format(d1);
		}
	}
