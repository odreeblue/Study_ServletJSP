package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc") //해당 url을 책임지는 서블릿 코드라는 것을 선언
public class Calc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response)
							throws ServletException, IOException{
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		PrintWriter out = response.getWriter();
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		String op = request.getParameter("operator");
		
		int x = 0;
		int y = 0;
		if(!x_.equals("")) {
			x = Integer.parseInt(x_);
		}
		if(!y_.equals("")) {
			y = Integer.parseInt(y_);
		}
		int total;
		if(op.equals("plus")) {
			total = x+y;
		}
		else {
			total =  x-y;
		}
		
		
		out.println("x: "+x+", y: "+y);
		if(op.equals("plus")) {
			out.println("x + y = "+total);
		}
		else {
			out.println("x - y = "+total);
		}
		
		
		
		
	}
	
}
