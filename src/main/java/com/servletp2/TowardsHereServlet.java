package com.servletp2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.bean.TruckBean;
 @WebServlet("/towards")
public class TowardsHereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	response.setContentType("text/html");
    	PrintWriter pw=response.getWriter();
    	
    	TruckBean t =TowardsHere .getTowardsHere(request);
    	if(t==null) 
    	{
    		pw.print("check details");
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("TowardsHere.html");
    		requestDispatcher.include(request, response);
    	}
    	else 
    	{
//    		pw.print("phone no:"+balance.getPhone()+" "+"AccountNo:"+balance.getAccount()+" "+"Address:"+balance.getAddress()+" "+"name:"+balance.getName()+" "+"amount:"+balance.getAmount());
    		request.setAttribute("data",t);
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("TowardsHere.jsp");
    		requestDispatcher.include(request, response);
    	}
    }
}