package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;
@MultipartConfig(
		//location="/tmp", //
		fileSizeThreshold=1024*1024, //
		maxFileSize = 1024*1024*50, //하나의 파일 사이즈 = 5MB
		maxRequestSize = 1024*1024*50*5 // 전체 요청 사이즈 = 5MB * 5 = 25MB
		
		)

@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		
		System.out.print("title : ");
		System.out.println(title);
		
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		Collection<Part> parts=request.getParts();
		StringBuilder builder = new StringBuilder();
		for(Part p:parts) {
			if(!p.getName().equals("file")) {
				continue;
			}
			if(p.getSize()==0) continue; // 파일이긴 한데 실제 데이터로서 바이너리 파일을 전달하지않고
											// 비어있는 것은 건너띈다.
			
			Part filePart = p;
			String fileName = filePart.getSubmittedFileName();
			
			builder.append(fileName);
			builder.append(",");
			
			InputStream fis = filePart.getInputStream(); //바이너
			//   "/upload/" -> "c:temp...upload" ...
					
			String realPath = request.getServletContext().getRealPath("/upload");
			System.out.println(realPath);
			
			File path = new File(realPath);
			if(!path.exists()) {
				path.mkdirs();
			}
			
			String filePath = realPath + File.separator +fileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			
			byte[] buf = new byte[1024]; // 한번에 읽는 크기를 크게
			int size=0;
			while((size=fis.read(buf)) != -1) {
				fos.write(buf,0,size);
			}
			fos.close();
			fis.close();
		}
		builder.delete(builder.length()-1, builder.length());
							// 
		
		String pub = "false";
		if(isOpen != null) {
			pub = "true";
		}
		
		Notice notice=new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterId("newlec"); // 추후 바뀔 예정
		notice.setFiles(builder.toString());
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		
		response.sendRedirect("list");
		
		
	}

}
