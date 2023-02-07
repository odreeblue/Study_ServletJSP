package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc3") //해당 url을 책임지는 서블릿 코드라는 것을 선언
public class Calc3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response)
							throws ServletException, IOException{
		
		
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			
			for (Cookie c : cookies)
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		}
		if(operator != null && operator.equals("=")){
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");// 제거되어 사용 불가한 것으로 보임 
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operator != null && operator.equals("C")){
			exp="";
		}
		else {
			exp += (value == null)?"":value;
			exp += (operator == null)?"":operator;
			exp += (dot == null)?"":dot;
		}
		
		
		Cookie expCookie = new Cookie("exp",exp);
		if(operator != null && operator.equals("C"))
			expCookie.setMaxAge(0);
		response.addCookie(expCookie);
		response.sendRedirect("calcpage");

	}
	
}
