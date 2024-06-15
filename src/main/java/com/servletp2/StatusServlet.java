package com.servletp2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.bean.TruckBean;

@WebServlet("/rt")
public class StatusServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	PrintWriter pw=response.getWriter();
    	response.setContentType("text/html");
    	try 
    	{
    		ArrayList<TruckBean> a2=StatusDao.status(request);
    		if(a2==null)
			{
				pw.println("please check details");
				RequestDispatcher rd = request.getRequestDispatcher("admin.html");
				rd.include(request, response);
			} else {
				request.setAttribute("status", a2);
				RequestDispatcher rd = request.getRequestDispatcher("Status.jsp");
				rd.forward(request, response);
			}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
	}
}