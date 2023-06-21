package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.YdBrdDao;
import com.yedam.common.Ydbrd;

@WebServlet("/login/second")
public class SecondServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();//출력스트림은 웹브라우저
		out.print("<h3>Hello World</h3>");
		
		YdBrdDao dao = new YdBrdDao();
		List<Ydbrd> list1 = dao.list();
		out.print("<ul>");
		for(Ydbrd vo : list1) {
			out.print("<li>글제목: "+vo.getTitle()+ "</li>");
		}
		out.print("</ul>");
		out.close();
		
	}
}
