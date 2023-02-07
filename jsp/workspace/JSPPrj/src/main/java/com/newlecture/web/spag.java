package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		
		String num_ = request.getParameter("n");
		
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result = "";
		if(num%2!=0){
			result = "홀수"; 
		}
		else{
			result = "짝수";
		}
		request.setAttribute("result", result);
		
		String[] names = {"newlec","dragon"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id",1);
		notice.put("title","EL은 좋아요");
		request.setAttribute("notice", notice);
		
		// 서버상에 상태를 저장하기 위해 사용되는 저장소는 4가지임
		// 포워드 관계에 있는 둘 사이에 저장소는 request가 사용됨
		// 내장객체를 사용할 때 페이지 내에서 혼자서 사용할 수 있는 저장소는 pageContext
		// 현재 세션에서 공유될 수 있는 저장소는 session
		// 모든 세션, 모든 페이지에서 공유되는 저장소는 page
		
		// 클라이언트에게 저장하기 위해 사용되는 저장소는 1가지임 -> 쿠키
		

		
		//redirect : 현재 작업하는 내용과 상관 없이 새로운 요청하게 만드는 것
		//forward : 현재 작업하는 내용을 공유
		RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp");
		dispatcher.forward(request, response);
	}

}
