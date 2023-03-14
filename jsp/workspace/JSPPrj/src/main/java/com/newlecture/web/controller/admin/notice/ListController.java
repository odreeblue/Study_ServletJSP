package com.newlecture.web.controller.admin.notice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet{
	// 404 : URL이 없음
	// 405 : URL이 있으나 메서드가 없음 
	// 403 : URL , Method 있으나, 권한 없음
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] openIds=request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd=request.getParameter("cmd");
		switch(cmd) {
		case "일괄공개":
			for(String openId:openIds) {
				System.out.printf("open id : %s \n", openId);
			}
			break;
		case "일괄삭제":
			NoticeService service = new NoticeService();
			
			int[] ids = new int[delIds.length];
			for(int i=0; i<delIds.length; i++) {
				ids[i] = Integer.parseInt(delIds[i]);
			}
			int result = service.deleteNoticeAll(ids);
			for(String delId:delIds) {
				System.out.printf("del id : %s \n", delId);
			}
			break;
		}
		
		//doPost를 다 처리하고나면 사용자의 목록 페이지를 보여주는 get 요청을 하면 된다.
		//URL을 같이 쓰지만 Post 요청에서 Get 요청을 호출하게된다.
		response.sendRedirect("list"); //현재 알고 있는 리스트 목록을 재요청 -> doGet이 요청을 받음
									   // 클라이언트가 아니라 서버에서 서버에있는 다른 페이지를 요청하듯이 진행된다.
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String field = "title";
		if(field_ != null && !field_.equals("")) {
			field = field_;
		}
		
		String query = "";
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		NoticeService service = new NoticeService();
		List<Notice> list = service.getNoticeList(field,query,page);
		
		int count= service.getNoticeCount(field,query);

		request.setAttribute("list", list);
		request.setAttribute("count",count);
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(request, response);
		
	}
	
	
	
	

}

