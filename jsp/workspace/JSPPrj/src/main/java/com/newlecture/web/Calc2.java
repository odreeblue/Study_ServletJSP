package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc2") //해당 url을 책임지는 서블릿 코드라는 것을 선언
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response)
							throws ServletException, IOException{
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		
		PrintWriter out = response.getWriter();
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		
		
		//계산 
		if(op.equals("=")) {
			//int x = (Integer)application.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v;
			//String opeartor = (String)application.getAttribute("op");
			String opeartor = (String)session.getAttribute("op");
			int result = 0;
			if(opeartor.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			response.getWriter().printf("results is %d\n", result);
		}
		//값을 저
		else {
			
//			application.setAttribute("value",v);
//			application.setAttribute("op",op); 
			
			session.setAttribute("value",v);
			session.setAttribute("op",op); 
			response.sendRedirect("calc2.html");
		}
		
		
		
		
		
		
	}
	
}
