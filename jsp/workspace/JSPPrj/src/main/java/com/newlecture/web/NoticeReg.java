package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/notice-reg") //해당 url을 책임지는 서블릿 코드라는 것을 선언
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response)
							throws ServletException, IOException{
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//request.setCharacterEncoding("UTF-8");//필터를 사용해서 사
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		out.println(title);
		out.println(content);
		
		
	}
	
}
